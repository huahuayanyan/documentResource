package com.huateng.scf.bas.crr.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huateng.authority.common.ContextHolder;
import com.huateng.base.common.beans.Page;
import com.huateng.flowsharp.api.IProcessService;
import com.huateng.flowsharp.entity.FlowsharpException;
import com.huateng.flowsharp.entity.ProcessEntity;
import com.huateng.scf.bas.brp.model.BBrpPrdFactoring;
import com.huateng.scf.bas.brp.service.IBBrpPrdFactoringService;
import com.huateng.scf.bas.common.constant.ScfBasConstant;
import com.huateng.scf.bas.common.service.IScfWorkFlowService;
import com.huateng.scf.bas.common.startup.ScfBaseData;
import com.huateng.scf.bas.common.startup.ScfMessageUtil;
import com.huateng.scf.bas.common.util.ScfDateUtil;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.crm.dao.IBCrmBaseInfoDAO;
import com.huateng.scf.bas.crm.dao.model.BCrmBaseInfo;
import com.huateng.scf.bas.crr.dao.IBCrrBillInfoDAO;
import com.huateng.scf.bas.crr.dao.IBCrrDuebillAppDAO;
import com.huateng.scf.bas.crr.dao.IBCrrEqptInfoDAO;
import com.huateng.scf.bas.crr.dao.IBCrrInvInfoDAO;
import com.huateng.scf.bas.crr.dao.IBCrrLcInfoDAO;
import com.huateng.scf.bas.crr.dao.IBCrrLgInfoDAO;
import com.huateng.scf.bas.crr.dao.IBCrrLnConRelaDAO;
import com.huateng.scf.bas.crr.dao.IBCrrPrdMdDAO;
import com.huateng.scf.bas.crr.dao.ext.ExtBCrrDAO;
import com.huateng.scf.bas.crr.dao.model.BCrrBillInfo;
import com.huateng.scf.bas.crr.dao.model.BCrrDuebillAppExample;
import com.huateng.scf.bas.crr.dao.model.BCrrDuebillAppExample.Criteria;
import com.huateng.scf.bas.crr.dao.model.BCrrPrdMd;
import com.huateng.scf.bas.crr.model.BCrrDuebill;
import com.huateng.scf.bas.crr.model.BCrrDuebillApp;
import com.huateng.scf.bas.crr.model.BCrrLnCon;
import com.huateng.scf.bas.crr.service.IBCrrDuebillAppService;
import com.huateng.scf.bas.crr.service.IBCrrGntyConService;
import com.huateng.scf.bas.crr.service.IBCrrLnConService;
import com.huateng.scf.bas.crr.util.BCrrModelCommonUtil;
import com.huateng.scf.bas.dcr.service.IbDcrLinService;
import com.huateng.scf.bas.dcr.vo.VbDcrLin;
import com.huateng.scf.bas.icr.dao.IBIcrInfoDAO;
import com.huateng.scf.bas.icr.dao.IBIcrPrdBindDAO;
import com.huateng.scf.bas.icr.dao.model.BIcrInfo;
import com.huateng.scf.bas.icr.dao.model.BIcrPrdBind;
import com.huateng.scf.bas.lan.constant.BLanErrorConstant;
import com.huateng.scf.bas.lan.dao.IBLanAppliLnciBaseDAO;
import com.huateng.scf.bas.lan.dao.model.BLanAppliLnciBase;
import com.huateng.scf.bas.lan.service.IBLanRepayApproveCommonService;
import com.huateng.scf.bas.lan.service.IBLanRepayFlowCreditApplyService;
import com.huateng.scf.bas.lan.service.IBLanRepaySilverApplyService;
import com.huateng.scf.bas.mrn.dao.IBMrnAppliAcctInfoDAO;
import com.huateng.scf.bas.mrn.dao.model.BMrnAppliAcctInfo;
import com.huateng.scf.bas.prd.constant.BPrdErrorConstant;
import com.huateng.scf.bas.prd.dao.IBPrdCreditBindDAO;
import com.huateng.scf.bas.prd.dao.model.BPrdCreditBind;
import com.huateng.scf.bas.prd.model.BPrdInfo;
import com.huateng.scf.bas.prd.model.BPrdWkflowCop;
import com.huateng.scf.bas.prd.service.IBPrdInfoService;
import com.huateng.scf.bas.prd.service.IBPrdWkflowCopService;
import com.huateng.scf.bas.sys.constant.BSysErrorConstant;
import com.huateng.scf.bas.sys.constant.WorkflowConstant;
import com.huateng.scf.bas.sys.dao.model.RSysAcctBctl;
import com.huateng.scf.bas.sys.model.BSysAcctBctl;
import com.huateng.scf.bas.sys.service.DealEndFlowService;
import com.huateng.scf.bas.sys.service.IBSysAcctBctlService;
import com.huateng.scf.bas.sys.service.IBSysSerialNoService;
import com.huateng.scf.rec.bcp.dao.IRBcpAppliBussDtlDAO;
import com.huateng.scf.rec.bcp.dao.IRBcpDebtBussDtlDAO;
import com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussDtl;
import com.huateng.scf.rec.bcp.model.ProcessModel;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * 
 * <p>
 * BCrrDuebillApp接口实现类
 * </p>
 *
 * @author mengjiajia
 * @date 2016年11月14日下午8:26:27
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 *            <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2016年11月14日下午8:26:27	     新增
 *
 *            </pre>
 */
@ScubeService
@Service("BCrrDuebillAppServiceImpl")
public class BCrrDuebillAppServiceImpl implements IBCrrDuebillAppService, DealEndFlowService {
	private final Logger log = LoggerFactory.getLogger(getClass());

	@Resource(name = "IBCrrDuebillAppDAO")
	IBCrrDuebillAppDAO bcrrduebillappdao;

	@Resource(name = "BCrrDuebillServiceImpl")
	BCrrDuebillServiceImpl bcrrduebillservice;

	@Resource(name = "ExtBCrrDAO")
	ExtBCrrDAO extbcrrdao;

	@Resource(name = "BSysSerialNoServiceImpl")
	IBSysSerialNoService ibSysSerialNoService;
	// 银承放款申请接口调用
	@Resource(name = "BLanRepaySilverApplyServiceImpl")
	IBLanRepaySilverApplyService ibLanRepaySilverApplyService;
	// 流贷放款申请接口调用
	@Resource(name = "BLanRepayFlowCreditApplyServiceImpl")
	IBLanRepayFlowCreditApplyService ibLanRepayFlowCreditApplyService;

	// 放款申请同意接口调用
	@Resource(name = "BLanRepayApproveCommonServiceImpl")
	IBLanRepayApproveCommonService ibLanRepayApproveCommonService;

	@Resource(name = "BPrdCreditBindDAO")
	IBPrdCreditBindDAO ibPrdCreditBindDAO;

	@Resource(name = "BCrrLnConServiceImpl")
	IBCrrLnConService bcrrlnconservice;

	@Resource(name = "IBMrnAppliAcctInfoDAO")
	IBMrnAppliAcctInfoDAO bmrnappliacctinfodao;

	@Resource(name = "IBCrrBillInfoDAO")
	IBCrrBillInfoDAO bcrrbillinfodao;

	@Resource(name = "IBCrrInvInfoDAO")
	IBCrrInvInfoDAO bcrrinvinfodao;

	@Resource(name = "IBCrrLgInfoDAO")
	IBCrrLgInfoDAO bcrrlginfodao;

	@Resource(name = "IBCrrLcInfoDAO")
	IBCrrLcInfoDAO bcrrlcinfodao;

	@Resource(name = "IBCrrEqptInfoDAO")
	IBCrrEqptInfoDAO bcrreqptinfodao;

	@Resource(name = "BLanAppliLnciBaseDAO")
	IBLanAppliLnciBaseDAO ibLanAppliLnciBaseDAO;

	@Resource(name = "IBCrrPrdMdDAO")
	IBCrrPrdMdDAO bcrrprdmddao;

	@Resource(name = "IBCrrLnConRelaDAO")
	IBCrrLnConRelaDAO bcrrlnconreladao;

	@Resource(name = "BCrrGntyConServiceImpl")
	IBCrrGntyConService bcrrgntyconservice;

	@Resource(name = "BIcrPrdBindDAO")
	IBIcrPrdBindDAO ibIcrPrdBindDAO;

	@Resource(name = "BIcrInfoDAO")
	IBIcrInfoDAO ibIcrInfoDAO;

	@Resource(name = "IBCrmBaseInfoDAO")
	IBCrmBaseInfoDAO ibCrmBaseInfoDAO;

	@Resource(name = "BSysAcctBctlServiceImpl")
	IBSysAcctBctlService bsysacctbctlservice;

	@Resource(name = "IRBcpDebtBussDtlDAO")
	IRBcpDebtBussDtlDAO irBcpDebtBussDtlDAO;

	@Resource(name = "RBcpAppliBussDtlDAO")
	IRBcpAppliBussDtlDAO irBcpAppliBussDtlDAO;

	@Resource(name = "processService")
	IProcessService iProcessService;
	
	@Resource(name = "BDcrLinServiceImpl")
	IbDcrLinService bdcrlinservice;
	
	@Resource(name = "BPrdInfoServiceImpl")
	IBPrdInfoService bPrdInfoService;
	
	@Resource(name = "BBrpPrdFactoringServiceImpl")
	IBBrpPrdFactoringService bBrpPrdFactoringService;
	
	@Resource(name = IScfWorkFlowService.BEAN_ID)
	IScfWorkFlowService scfWorkFlowService;
	
	//流程组件信息
	@Resource(name = "BPrdWkflowCopServiceImpl")
	IBPrdWkflowCopService bPrdWkflowCopService;

	@Override
	@Transactional
	public BCrrDuebillApp add(BCrrDuebillApp bCrrDuebillApp) {
		log.info("出账申请新增操作");
		String id = ibSysSerialNoService.genSerialNo("DUE_APP_NO");
		String appStat = WorkflowConstant.APPLI_STATUS_UNSUBMIT;
		bCrrDuebillApp.setId(id);
		bCrrDuebillApp.setAppStat(appStat);
		BCrrModelCommonUtil.setAddField(bCrrDuebillApp);
		// VO转PO 展现层对象转换DAO层对象
		com.huateng.scf.bas.crr.dao.model.BCrrDuebillApp bCrrDuebillAppdal = new com.huateng.scf.bas.crr.dao.model.BCrrDuebillApp();
		try {
			BeanUtils.copyProperties(bCrrDuebillApp, bCrrDuebillAppdal);
		} catch (BeansException e) {
			throw new ScubeBizException("转换异常");
		}
		try {
			bcrrduebillappdao.insertSelective(bCrrDuebillAppdal);
		} catch (BeansException e) {
			throw new ScubeBizException("插入异常");
		}
		BCrrLnCon bCrrLnCon = new BCrrLnCon();
		bCrrLnCon.setAppId(bCrrDuebillApp.getAppId());
		bcrrlnconservice.update(bCrrLnCon);
		return bCrrDuebillApp;
	}

	@Override
	@Transactional
	public int update(BCrrDuebillApp bCrrDuebillApp) {
		log.info("出账申请编辑操作");
		BCrrModelCommonUtil.setUpdateField(bCrrDuebillApp);
		// VO转PO 展现层对象转换DAO层对象
		com.huateng.scf.bas.crr.dao.model.BCrrDuebillApp bCrrDuebillAppdal = new com.huateng.scf.bas.crr.dao.model.BCrrDuebillApp();
		try {
			BeanUtils.copyProperties(bCrrDuebillApp, bCrrDuebillAppdal);
		} catch (BeansException e) {
			throw new ScubeBizException("转换异常");
		}
		int i;
		try {
			i = bcrrduebillappdao.updateByPrimaryKeySelective(bCrrDuebillAppdal);
		} catch (BeansException e) {
			throw new ScubeBizException("编辑异常");
		}
		return i;
	}

	@Override
	@Transactional
	public BCrrDuebillApp submit(BCrrDuebillApp bCrrDuebillApp) {
		String id = bCrrDuebillApp.getId();
		if (id == null || id.equals("")) {
			bCrrDuebillApp = add(bCrrDuebillApp);
			id = bCrrDuebillApp.getId();
		}
		String appStat = WorkflowConstant.APPLI_STATUS_SUBMITUNAPPROVE;
		bCrrDuebillApp.setAppStat(appStat);
		bCrrDuebillApp.setFlag("0");
		BCrrModelCommonUtil.setUpdateField(bCrrDuebillApp);
		com.huateng.scf.bas.crr.dao.model.BCrrDuebillApp bCrrDuebillAppdal = new com.huateng.scf.bas.crr.dao.model.BCrrDuebillApp();
		try {
			BeanUtils.copyProperties(bCrrDuebillApp, bCrrDuebillAppdal);
		} catch (BeansException e) {
			throw new ScubeBizException("转换异常");
		}
		try {
			bcrrduebillappdao.updateByPrimaryKeySelective(bCrrDuebillAppdal);
		} catch (BeansException e) {
			throw new ScubeBizException("提交异常");
		}
		// 更新合同可用余额
		BCrrLnCon bCrrLnCon = bcrrlnconservice.findBCrrLnConByAppId(bCrrDuebillApp.getAppId());
		Double lnSum = bCrrLnCon.getLnSum().doubleValue();
		Double duebillLnAmt = bCrrDuebillApp.getLnAmt().doubleValue();
		lnSum = lnSum - duebillLnAmt;
		BCrrLnCon lncon = new BCrrLnCon();
		lncon.setLnSum(BigDecimal.valueOf(lnSum));
		lncon.setAppId(bCrrLnCon.getAppId());
		bcrrlnconservice.update(lncon);
		return bCrrDuebillApp;
	}

	@Override
	@Transactional
	public int batchDelete(List<BCrrDuebillApp> list) {
		List<com.huateng.scf.bas.crr.dao.model.BCrrDuebillApp> listdal = new ArrayList<com.huateng.scf.bas.crr.dao.model.BCrrDuebillApp>();
		for (BCrrDuebillApp bCrrDuebillApp : list) {
			// VO转PO 展现层对象转换DAO层对象
			com.huateng.scf.bas.crr.dao.model.BCrrDuebillApp bCrrDuebillAppdal = new com.huateng.scf.bas.crr.dao.model.BCrrDuebillApp();
			try {
				BeanUtils.copyProperties(bCrrDuebillApp, bCrrDuebillAppdal);
			} catch (BeansException e) {
				throw new ScubeBizException("转换异常");
			}
			listdal.add(bCrrDuebillAppdal);
		}
		int i = 0;
		try {
			for (com.huateng.scf.bas.crr.dao.model.BCrrDuebillApp record : listdal) {
				String id = record.getId();
				i += bcrrduebillappdao.deleteByPrimaryKey(id);
			}
		} catch (BeansException e) {
			throw new ScubeBizException("删除异常");
		}
		return i;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Page findBCrrDuebillAppByPage(int pageNo, int pageSize, BCrrDuebillApp bCrrDuebillApp) {

		BCrrDuebillAppExample example = new BCrrDuebillAppExample();
		Criteria cri = example.createCriteria();

		if (bCrrDuebillApp != null) {
			// 出账流水号
			if (bCrrDuebillApp.getId() != null && bCrrDuebillApp.getId().length() > 0) {
				cri.andIdLike("%" + bCrrDuebillApp.getId() + "%");
			}
			// 客户名称
			if (bCrrDuebillApp.getCustNm() != null && bCrrDuebillApp.getCustNm().length() > 0) {
				cri.andCustNmLike("%" + bCrrDuebillApp.getCustNm() + "%");
			}
			// 放款日期
			if (bCrrDuebillApp.getIsDt() != null && bCrrDuebillApp.getIsDt().length() > 0) {
				cri.andIsDtGreaterThanOrEqualTo(bCrrDuebillApp.getIsDt());
			}
			// 到期日期
			if (bCrrDuebillApp.getTeDt() != null && bCrrDuebillApp.getTeDt().length() > 0) {
				cri.andTeDtLessThanOrEqualTo(bCrrDuebillApp.getTeDt());
			}
			cri.andTlrNoEqualTo(ContextHolder.getUserInfo().getTlrNo());
		}
		example.setOrderByClause("INP_DT DESC");

		int total = bcrrduebillappdao.countByExample(example);
		Page p = new Page(pageSize, pageNo, total);

		log.info("totalPage=" + p.getTotalPage());
		log.info("totalPage=" + p.getTotalPage());
		log.info("totalRecord=" + p.getTotalRecord());
		log.info("totalRecord=" + p.getTotalRecord());
		log.info("current=" + p.getCurrent());
		log.info("current=" + p.getCurrent());

		/**
		 * 供应链出账模式开关
		 */
		@SuppressWarnings("static-access")
		String flag = ScfBaseData.getInstance().getLoanWayFlag();

		Page result = new Page();
		result.setRecords(bcrrduebillappdao.selectByPage(example, p));
		List<com.huateng.scf.bas.crr.dao.model.BCrrDuebillApp> listdal = result.getRecords();
		List<com.huateng.scf.bas.crr.dao.model.BCrrDuebillApp> list = new ArrayList<com.huateng.scf.bas.crr.dao.model.BCrrDuebillApp>();
		if (listdal.size() > 0) {
			for (com.huateng.scf.bas.crr.dao.model.BCrrDuebillApp duebillapp : listdal) {
				duebillapp.setFlag(flag);
				String actBrCd = duebillapp.getActBrCd();
				String actBrNm = "";
				if (StringUtil.isStrNotEmpty(actBrCd)) {
					BSysAcctBctl bSysAcctBctl = new BSysAcctBctl();
					bSysAcctBctl.setBrcode(actBrCd);
					Page sysacct = bsysacctbctlservice.findBSysAcctBctlByPage(pageNo, pageSize, bSysAcctBctl);
					List<RSysAcctBctl> sysacctlist = sysacct.getRecords();
					if (sysacctlist.size() > 0) {
						actBrNm = sysacctlist.get(0).getBrname();
					}
				}
				duebillapp.setActBrNm(actBrNm);
				/**
				 * 供应链出账显示字段
				 */
				String appno = duebillapp.getId();// appno--关联所有信息
				// 间接可用额度计算
				BLanAppliLnciBase bLanAppliLnciBase = ibLanAppliLnciBaseDAO.selectByPrimaryKey(appno);
				if (bLanAppliLnciBase != null) {
					BPrdCreditBind bind = new BPrdCreditBind();
					bind.setProductId(bLanAppliLnciBase.getProductId());
					bind.setOprMode(ScfBasConstant.CREDIT_OPR_MODE_SELLER_AND_BUYER);// 模式
					bind.setCreditPhase(ScfBasConstant.CREDIT_PHASE_FOUR_WAREHOUSE_ACCOUNT);// 额度阶段
					bind.setOprType(ScfBasConstant.CREDIT_OPR_TYPE_OCCUPY);// 操作类型
					List<BPrdCreditBind> prdBindList = ibPrdCreditBindDAO.selectCreditBind(bind);
					duebillapp.setDrawbackTerm(bLanAppliLnciBase.getDrawbackTerm() == null ? "0" : bLanAppliLnciBase.getDrawbackTerm().toString());// 赎货期限
					String creditType = "";
					if (prdBindList.size() > 0) {
						BPrdCreditBind bindInfo = prdBindList.get(0);
						creditType = bindInfo.getCreditType();
					}

					// 间接额度表
					BIcrInfo bIcrInfo = new BIcrInfo();
					bIcrInfo.setCreditClass(ScfBasConstant.CREDIT_CLASS_INDIRECT);
					bIcrInfo.setNodeType(ScfBasConstant.CREDIT_NODE_TYPE_SUB_LEAF);
					bIcrInfo.setCustcd(bLanAppliLnciBase.getCreditCustcd());
					bIcrInfo.setOtherCustcd(bLanAppliLnciBase.getCustcd());
					bIcrInfo.setCreditType(creditType);
					List<BIcrInfo> icrList = ibIcrInfoDAO.selectByParam(bIcrInfo);
					BigDecimal creditUseBal = BigDecimal.ZERO;
					if (icrList.size() > 0) {
						BIcrInfo bInfo = icrList.get(0);
						creditUseBal = bInfo.getCreditUsableAmount() == null ? BigDecimal.ZERO : bInfo.getCreditUsableAmount();
						duebillapp.setCreditBalAmt(creditUseBal);// 间接额度可用额度
					}
					BCrmBaseInfo baseInfo = ibCrmBaseInfoDAO.selectById(bLanAppliLnciBase.getCustcd());
					duebillapp.setCname(baseInfo.getCname());// 买方名称
				}
				list.add(duebillapp);
			}
		}
		p.setRecords(list);
		log.info("p.toString()=" + p.toString());
		return p;
	}

	@Override
	public BCrrDuebillApp findBCrrDuebillAppByAppId(String appId) {
		com.huateng.scf.bas.crr.dao.model.BCrrDuebillApp bCrrDuebillAppdal = extbcrrdao.selectByAppId(appId);
		if (bCrrDuebillAppdal == null) {
			return null;
		} else {
			BCrrDuebillApp bCrrDuebillApp = new BCrrDuebillApp();
			try {
				BeanUtils.copyProperties(bCrrDuebillAppdal, bCrrDuebillApp);
			} catch (BeansException e) {
				throw new ScubeBizException("转换异常");
			}
			return bCrrDuebillApp;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public BCrrDuebillApp findBCrrDuebillAppById(String id) {
		com.huateng.scf.bas.crr.dao.model.BCrrDuebillApp bCrrDuebillAppdal = bcrrduebillappdao.selectByPrimaryKey(id);
		if (bCrrDuebillAppdal == null) {
			return null;
		} else {
			BCrrDuebillApp duebillapp = new BCrrDuebillApp();
			try {
				BeanUtils.copyProperties(bCrrDuebillAppdal, duebillapp);
			} catch (BeansException e) {
				throw new ScubeBizException("转换异常");
			}
			/**
			 * 供应链出账模式开关
			 */
			@SuppressWarnings("static-access")
			String flag = ScfBaseData.getInstance().getLoanWayFlag();
			duebillapp.setFlag(flag);
			String actBrCd = duebillapp.getActBrCd();
			String actBrNm = "";
			if (StringUtil.isStrNotEmpty(actBrCd)) {
				BSysAcctBctl bSysAcctBctl = new BSysAcctBctl();
				bSysAcctBctl.setBrcode(actBrCd);
				Page sysacct = bsysacctbctlservice.findBSysAcctBctlByPage(1, 10, bSysAcctBctl);
				List<RSysAcctBctl> sysacctlist = sysacct.getRecords();
				if (sysacctlist.size() > 0) {
					actBrNm = sysacctlist.get(0).getBrname();
				}
			}
			duebillapp.setActBrNm(actBrNm);
			/**
			 * 供应链出账显示字段
			 */
			BLanAppliLnciBase bLanAppliLnciBase = ibLanAppliLnciBaseDAO.selectByAppno(id);
			if (bLanAppliLnciBase != null) {
				List<BIcrPrdBind> prdBindList = ibIcrPrdBindDAO.selectByPid(bLanAppliLnciBase.getProductId());
				duebillapp.setDrawbackTerm(bLanAppliLnciBase.getDrawbackTerm() == null ? "0" : bLanAppliLnciBase.getDrawbackTerm().toString());// 赎货期限
				String creditType = "";
				if ((prdBindList.size() > 0)) {
					BIcrPrdBind bind = prdBindList.get(0);
					creditType = bind.getCreditType();
				}

				// 间接额度表
				BIcrInfo bIcrInfo = new BIcrInfo();
				bIcrInfo.setCreditClass(ScfBasConstant.CREDIT_CLASS_INDIRECT);
				bIcrInfo.setNodeType(ScfBasConstant.CREDIT_NODE_TYPE_SUB_LEAF);
				bIcrInfo.setCustcd(bLanAppliLnciBase.getCreditCustcd());
				bIcrInfo.setOtherCustcd(bLanAppliLnciBase.getCustcd());
				bIcrInfo.setCreditType(creditType);
				bIcrInfo.setStatus(ScfBasConstant.CREDIT_STATUS_NORMAL);// 有效
				List<BIcrInfo> icrList = ibIcrInfoDAO.selectByParam(bIcrInfo);
				BigDecimal creditUseBal = BigDecimal.ZERO;
				if (icrList.size() > 0) {
					BIcrInfo bInfo = icrList.get(0);
					creditUseBal = bInfo.getCreditUsableAmount() == null ? BigDecimal.ZERO : bInfo.getCreditUsableAmount();
					duebillapp.setCreditBalAmt(creditUseBal);// 间接额度可用额度
				} else {
					duebillapp.setCreditBalAmt(BigDecimal.ZERO);
				}
				List<RBcpAppliBussDtl> list = irBcpAppliBussDtlDAO.selectByAppno(id);
				BigDecimal ystotAmt = BigDecimal.ZERO;
				for (int i = 0; i < list.size(); i++) {
					RBcpAppliBussDtl rBcpAppliBussDtl = list.get(i);
					ystotAmt = ystotAmt.add(rBcpAppliBussDtl.getRemainingAmount() == null ? BigDecimal.ZERO : rBcpAppliBussDtl.getRemainingAmount());
				}
				duebillapp.setYsTotalAmt(ystotAmt);
			}
			return duebillapp;
		}
	}

	/**
	 * @author liph
	 * @param id
	 * @return
	 */
	@Override
	public BCrrDuebillApp findBCrrDuebillAppByIdid(String id) {
		com.huateng.scf.bas.crr.dao.model.BCrrDuebillApp bCrrDuebillAppdal = bcrrduebillappdao.selectByPrimaryKey(id);
		if (bCrrDuebillAppdal == null) {
			return null;
		} else {
			BCrrDuebillApp bCrrDuebillApp = new BCrrDuebillApp();
			try {
				BeanUtils.copyProperties(bCrrDuebillAppdal, bCrrDuebillApp);
			} catch (BeansException e) {
				throw new ScubeBizException("转换异常");
			}
			return bCrrDuebillApp;
		}
	}

	@Override
	@Transactional
	public void doWorkForPass(String appNo) {
		BCrrDuebillApp bCrrDuebillApp = findBCrrDuebillAppByIdid(appNo);
		BCrrDuebill bCrrDuebill = new BCrrDuebill();
		try {
			BeanUtils.copyProperties(bCrrDuebillApp, bCrrDuebill);
		} catch (BeansException e) {
			log.warn("转换异常", e);
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BSysErrorConstant.SCF_BAS_DCR_50000), BSysErrorConstant.SCF_BAS_DCR_50000);

		}
		// 更新出账信息状态
		bCrrDuebillApp.setAppStat(WorkflowConstant.APPLI_STATUS_APPROVED);
		update(bCrrDuebillApp);
		@SuppressWarnings("static-access")
		String flag = ScfBaseData.getInstance().getLoanWayFlag();
		if (flag == "1" || flag.equals("1")) 
		{
			BCrrLnCon bCrrLnCon = bcrrlnconservice.findBCrrLnConByAppId(bCrrDuebillApp.getAppId());
			// String prdId = bCrrLnCon.getPrdId();
			// if(prdId=="004"||prdId.equals("004")){
			// 供应链表操作
			BLanAppliLnciBase bLanAppliLnciBase = ibLanAppliLnciBaseDAO.selectByAppno(appNo);// 放款申请对应一条借据
			String paybrcode = "";
			if (bLanAppliLnciBase != null) {
				paybrcode = bLanAppliLnciBase.getPrePayBrcode();
			} else {
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BLanErrorConstant.SCF_BAS_LAN_20002),
						BLanErrorConstant.SCF_BAS_LAN_20002);
			}
			String paytlrno = ContextHolder.getUserInfo().getTlrNo();
			String paychecker = ContextHolder.getUserInfo().getTlrNo();
			String vidbusityp = bCrrLnCon.getVidBusiTyp();
			Map<String, String> map = new HashMap<String, String>();
			map.put("APP_NO", appNo);
			map.put("opinion", WorkflowConstant.WORKFLOW_TRANS_AGREE);// 同意
			map.put("payBrcode", paybrcode);
			map.put("payTlrno", paytlrno);
			map.put("payChecker", paychecker);
			map.put("VID_BUSI_TYP", vidbusityp);
			try {
				ibLanRepayApproveCommonService.repayapprove(map);
			} catch (Exception e) {
				log.info("供应链审核确认接口调用失败");
				e.printStackTrace();
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BLanErrorConstant.SCF_BAS_LAN_20002),
						BLanErrorConstant.SCF_BAS_LAN_20002);
			}
		}
		bCrrDuebill.setRelaId(appNo);
		bCrrDuebill.setConNo(bCrrDuebillApp.getAppId());
		bCrrDuebill.setClrCls("02");
		bCrrDuebill.setLnStat("01");
		bCrrDuebill.setInpDt(ScfDateUtil.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
		bCrrDuebill.setLstUpdDt(ScfDateUtil.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
		// 审批通过生成台帐信息
		bcrrduebillservice.add(bCrrDuebill);
	}

	@Override
	@Transactional
	public void doWorkForReject(String appNo) {
		BCrrDuebillApp bCrrDuebillApp = findBCrrDuebillAppByIdid(appNo);
		// 审批不通过，更新出账信息状态
		bCrrDuebillApp.setAppStat(WorkflowConstant.APPLI_STATUS_REFUSED);
		update(bCrrDuebillApp);
		// 更新合同可用余额
		BCrrLnCon bCrrLnCon = bcrrlnconservice.findBCrrLnConByAppId(bCrrDuebillApp.getAppId());
		Double lnSum = bCrrLnCon.getLnSum().doubleValue();
		Double duebillLnAmt = bCrrDuebillApp.getLnAmt().doubleValue();
		lnSum = lnSum + duebillLnAmt;
		BCrrLnCon lncon = new BCrrLnCon();
		lncon.setLnSum(BigDecimal.valueOf(lnSum));
		lncon.setAppId(bCrrLnCon.getAppId());
		bcrrlnconservice.update(lncon);
	}

	@Override
	public Page queryLnConSource(int pageNo, int pageSize, Map<String, String> value) {
		log.debug("传递参数,value=" + value);
		Page p = new Page(pageSize, pageNo, 0);
		Map<String, String> omap = new HashMap<String, String>();
		if (value != null && value.get("appId") != null && value.get("custId") != null) {
			omap.put("appId", value.get("appId").toString().trim());
			omap.put("custId", value.get("custId").toString().trim());
			omap.put("custNm", value.get("appId").toString().trim());
		}
		omap.put("appStat", "1");
		extbcrrdao.queryLnConSource(omap, p);
		return p;
	}

	/**
	 * 判断是否关联供应链出账
	 * 
	 * @param bCrrDuebillApp
	 * @throws ScubeBizException 
	 */
	@Transactional
	@Override
	public void connectVid(BCrrDuebillApp bCrrDuebillApp, ProcessModel processModel) throws ScubeBizException {
		String appno = bCrrDuebillApp.getId();// 流程申请号
		String processId = "";
		//TODO 不同的业务品种发起流程模板ID不同
		/*try {//2.发起流程
			processModel.setBizId(appno);
			processModel.getBizData()[0] = appno;
			ProcessEntity processEntity = iProcessService.startProcess(processModel.getModelId(), processModel.getProcessName(),
					processModel.getNodeId(), processModel.getStartedUserId(), processModel.getBizId(), processModel.getBizData());
			processId = processEntity.getProcessId();
			//processName = processEntity.getProcessName();
		} catch (Exception e) {
			log.error("出账申请流程发起异常！");
			e.printStackTrace();
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BLanErrorConstant.SCF_BAS_LAN_20031), BLanErrorConstant.SCF_BAS_LAN_20031);
		}*/
		//根据关联的业务品种获得流程的模板ID，流程名称及申请类型
		HashMap<String, String> flowMap = this.getWkflowMode(bCrrDuebillApp);
		String modelId = flowMap.get("modelId");
		String processName = flowMap.get("processName");
		String appliType = flowMap.get("appliType"); //流程申请类型
		String nodeId = WorkflowConstant.PROCNODE_DUEBILLAPPLY;//流程首节点
		String startedUserId = ContextHolder.getUserInfo().getTlrNo();
		String bizId = bCrrDuebillApp.getId();
		String custCd = bCrrDuebillApp.getCustCd(); 
		String custName = bCrrDuebillApp.getCustNm(); 
	    String[] BizData = {appno,custCd,custName,modelId};
	
		//发起工作流
		try {//2.发起流程
			processModel.setBizId(appno);
			processModel.getBizData()[0] = appno;
			ProcessEntity processEntity = iProcessService.startProcess(modelId, processName,
					nodeId, startedUserId, bizId, BizData);
			processId = processEntity.getProcessId();
			//processName = processEntity.getProcessName();
		} catch (Exception e) {
			log.error("出账申请流程发起异常！");
			e.printStackTrace();
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BLanErrorConstant.SCF_BAS_LAN_20031), BLanErrorConstant.SCF_BAS_LAN_20031);
		}

		try {
			BCrrLnCon bCrrLnCon = new BCrrLnCon();
			bCrrLnCon = bcrrlnconservice.findBCrrLnConByAppId(bCrrDuebillApp.getAppId());
			String prdId = bCrrLnCon.getPrdId();
			BCrrPrdMd bCrrPrdMd = bcrrprdmddao.selectByPrimaryKey(prdId);
			String extId = bCrrLnCon.getExtId();
			// 保证金列表
			List<BMrnAppliAcctInfo> bailist = bmrnappliacctinfodao.selectByBillId(extId);
			// 票据列表
			List<BCrrBillInfo> billinfo = bcrrbillinfodao.selectByExtId(extId);

			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("PROCESSID", processId);// 流程号
			map.put("MODELID", modelId);// 流程模板
			map.put("APPLITYPE", appliType);// 申请类型
			map.put("APP_NO", bCrrDuebillApp.getId());// 信贷申请号
			map.put("PRD_ID", bCrrLnCon.getPrdId());// 004-003-01
			map.put("CUST_CD", bCrrDuebillApp.getCustCd());// 授信客户号
			map.put("CUST_NM", bCrrDuebillApp.getCustNm());// 授信客户名称
			map.put("LOAN_WAY", bCrrPrdMd.getLoanWay());// 出账方式
			map.put("VID_BUSI_TYP", bCrrLnCon.getVidBusiTyp());// 业务品种
			map.put("APP_ID", bCrrLnCon.getAppId());// 信贷合同号
			map.put("CURCD", bCrrLnCon.getCurcd());// 币种
			map.put("VID_NO", bCrrLnCon.getVidNo());// 协议号
			map.put("LN_AMT", bCrrDuebillApp.getLnAmt().toString());// 出票总金额
			map.put("IS_DT", bCrrDuebillApp.getIsDt());// 出票日期
			map.put("TE_DT", bCrrDuebillApp.getTeDt());// 到期日
			if (bCrrDuebillApp.getBailRat() != null) {
				map.put("BAIL_RAT", bCrrDuebillApp.getBailRat().toString());// 最低保证金比例
			} else {
				map.put("BAIL_RAT", "");
			}
			if (bCrrDuebillApp.getBailAmt() != null) {
				map.put("BAIL_AMT", bCrrDuebillApp.getBailAmt().toString());// 初始保证金总额
			} else {
				map.put("BAIL_AMT", "");
			}
			map.put("INDRCT_CRDT", bCrrDuebillApp.getIndrctCrdt());// 间接额度类型
			if(bCrrDuebillApp.getIndrctCrdt().equals("1"))
			{
				if(StringUtil.isEmpty(bCrrDuebillApp.getCrdtCustCd()))
				{
					VbDcrLin bDcrLin = bdcrlinservice.findVbDcrLinByKey(bCrrDuebillApp.getBcCrId());
					if(null!=bDcrLin)
					{
						bCrrDuebillApp.setCrdtCustCd(bDcrLin.getCustId());
					}
				}
			}
			map.put("CRDT_CUST_CD", bCrrDuebillApp.getCrdtCustCd());// 间接额度占用客户号
			map.put("EXT_ID", extId);// 关联票据EXT_ID字段
			map.put("ELEC_FLG", bCrrDuebillApp.getElecFlg());// 电票标志
			map.put("ACT_INT", bCrrLnCon.getActInt());// 执行利率
			map.put("APP_BR_CD", bCrrDuebillApp.getBrCd());// 申请机构号/经办人机构号
			map.put("list", billinfo);
			map.put("bailist", bailist);// 保证金列表
			if (bCrrPrdMd.getLoanWay().equals(ScfBasConstant.LOAN_WAY_BANK_ACCEPTENCE)) {
				try {// 银承放款接口
					ibLanRepaySilverApplyService.repayapply(map);
				} catch (Exception e) {
					log.info("银承放款申请接口调用失败");
					e.printStackTrace();
					throw new ScubeBizException("银承放款申请接口调用异常");
				}
			} else if (bCrrPrdMd.getLoanWay().equals(ScfBasConstant.LOAN_WAY_WORKING_CAPITAL)) {
				try {// 流贷放款接口
					ibLanRepayFlowCreditApplyService.repayapply(map);
				} catch (Exception e) {
					log.info("流贷放款申请接口调用失败");
					e.printStackTrace();
					throw new ScubeBizException("流贷放款申请接口调用异常");
				}
			}
		} catch (Exception e) {
			log.info("业务逻辑处理异常,流程撤销");
			try {
				iProcessService.cancelProcess(processId);
			} catch (FlowsharpException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			BCrrDuebillApp duebillApp = new BCrrDuebillApp();
			duebillApp.setId(bCrrDuebillApp.getId());
			duebillApp.setAppStat(WorkflowConstant.APPLI_STATUS_UNSUBMIT);
			update(duebillApp);
			e.printStackTrace();
		}
	}

	@Override
	public void isHide(String id, String flag) {
		com.huateng.scf.bas.crr.dao.model.BCrrDuebillApp bCrrDuebillAppdal = new com.huateng.scf.bas.crr.dao.model.BCrrDuebillApp();
		bCrrDuebillAppdal.setId(id);
		bCrrDuebillAppdal.setFlag(flag);
		try {
			bcrrduebillappdao.updateByPrimaryKeySelective(bCrrDuebillAppdal);
		} catch (BeansException e) {
			throw new ScubeBizException("同步数据异常");
		}
	}

	@Override
	public void doWorkForBack(String appNo) {
		// TODO Auto-generated method stub

	}
	
	public HashMap<String, String> getWkflowMode(BCrrDuebillApp bCrrDuebillApp)  throws ScubeBizException{
		// TODO Auto-generated method stub
		HashMap<String, String> map = new HashMap<String, String>();
		BCrrLnCon bCrrLnCon = bcrrlnconservice.findBCrrLnConByAppId(bCrrDuebillApp.getAppId());
		String prdId = bCrrLnCon.getPrdId();
		BCrrPrdMd bCrrPrdMd = bcrrprdmddao.selectByPrimaryKey(prdId);
		String loanWay = bCrrPrdMd.getLoanWay();// 出账方式
		String bussType = bCrrLnCon.getVidBusiTyp();// //业务品种--产品
		String modelId = "";// 流程Id
		String appliType = "";// 申请类型
		BPrdInfo bPrdInfo = bPrdInfoService.findBPrdInfoObjectByKey(bussType);
		
		if(bPrdInfo == null){
			log.info("业务品种不存在");
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BPrdErrorConstant.SCF_BAS_PRD_10002),
					BPrdErrorConstant.SCF_BAS_PRD_10002);
		}
		String bigProductId = bPrdInfo.getParentId();//产品种类--产品大类：预付类
		
		//出账方式为流贷 
		if(ScfBasConstant.LOAN_WAY_WORKING_CAPITAL.equals(loanWay)){//流贷
			if(ScfBasConstant.PRODUCT_TYPE_ACCR.equals(bigProductId)){//应收账款
				BBrpPrdFactoring bBrpPrdFactoring = bBrpPrdFactoringService.findBBrpPrdFactoringByKey(bussType);
				String factType = bBrpPrdFactoring.getFactType();
				if(ScfBasConstant.FACT_TYPE_INLAND.equals(factType)||ScfBasConstant.FACT_TYPE_REVERSE.equals(factType)
						||ScfBasConstant.FACT_TYPE_DEBT_PLEDGE.equals(factType)){
					modelId = WorkflowConstant.PROCNAME_INCOICE_FINANCING_APPLY;
					appliType = WorkflowConstant.APPLI_TYPE_INCOICEFINANCINGAPPLY;
				}else if(ScfBasConstant.FACT_TYPE_DEBT_POOL_PLEDGE.equals(factType) || ScfBasConstant.FACT_TYPE_DEBT_POOL.equals(factType)
					|| ScfBasConstant.FACT_TYPE_EXPORT_POOL_PLEDGE.equals(factType)){//应收账款池融资
					modelId = WorkflowConstant.PROCNAME_FINANCING_POOL_APPLY;
					appliType = WorkflowConstant.APPLI_TYPE_FINANCINGPOOLBILLAPPLY;
				}
			}else if(ScfBasConstant.PRODUCT_TYPE_MORT.equals(bigProductId)){//现货质押
				if(ScfBasConstant.PRODUCT_TYPE_PLDY.equals(bussType)||ScfBasConstant.PRODUCT_TYPE_PLSY.equals(bussType))
				{//现货动态质押、现货静态质押
					modelId = WorkflowConstant.PROCNAME_MORTGAGECASHLOANAPPLY;
					appliType = WorkflowConstant.APPLI_TYPE_MORTGAGE_CASH_LOAN_APPLY;
				}
				if(ScfBasConstant.PRODUCT_TYPE_BILL_NORMAL.equals(bussType))
				{//非标仓单
					modelId = WorkflowConstant.PROCNAME_NORMAL_CASH_LOAN_APPLY;
					appliType = WorkflowConstant.APPLI_TYPE_BILL_NORMAL_CASH_LOAN_APPLY;
				}
			}else if(ScfBasConstant.PRODUCT_TYPE_PREP.equals(bigProductId)){//预付类
				//先票款/后货
				if(ScfBasConstant.PRODUCT_TYPE_XPHH.equals(bussType))
				{
					modelId = WorkflowConstant.PROCNAME_FOUR_LOAN_APPLY;
					appliType = WorkflowConstant.APPLI_TYPE_FOUR_LOAN_APPLY;
				}
			}
		}
		//出账方式为银承 
		else if(ScfBasConstant.LOAN_WAY_BANK_ACCEPTENCE.equals(loanWay)){
			if(ScfBasConstant.PRODUCT_TYPE_PREP.equals(bigProductId)){//预付类
				if(ScfBasConstant.PRODUCT_TYPE_SMALL_WH.equals(bussType)){//担保提货
					modelId = WorkflowConstant.PROCNAME_THREE_BILL_APPLY;
					appliType = WorkflowConstant.APPLI_TYPE_THREE_BILLPPLI;
				}else if(ScfBasConstant.PRODUCT_TYPE_XPHH.equals(bussType)){//先票款后货
					modelId = WorkflowConstant.PROCNAME_FOUR_LOAN_BILL_APPLY;
					appliType = WorkflowConstant.APPLI_TYPE_FOUR_BILL_APPLY;
				}
			}
			if(ScfBasConstant.PRODUCT_TYPE_PLDY.equals(bussType)||ScfBasConstant.PRODUCT_TYPE_PLSY.equals(bussType))
			{//现货动态质押、现货静态质押
				modelId = WorkflowConstant.PROCNAME_MORTGAGEBILLLOANAPPLY;
				appliType = WorkflowConstant.APPLI_TYPE_MORTGAGE_BILL_LOAN_APPLY;
			}
			else if(ScfBasConstant.PRODUCT_TYPE_MORT.equals(bigProductId)){//现货类
				if(ScfBasConstant.PRODUCT_TYPE_BILL_NORMAL.equals(bussType))
				{//非标仓单
					modelId = WorkflowConstant.PROCNAME_NORMAL_BILL_LOAN_APPLY;
					appliType = WorkflowConstant.APPLI_TYPE_BILL_NORMAL_BILL_LOAN_APPLY;
				}
			}
		}
		//根据流程ID获得流程名称
		// 根据modelId查询流程名称
		BPrdWkflowCop bPrdWkflowCop = new BPrdWkflowCop();
		bPrdWkflowCop.setFlowCopId(modelId);
		BPrdWkflowCop bPrdWkflow = bPrdWkflowCopService.queryBPrdWkflowCopByBPrd(bPrdWkflowCop);
		// 流程信息
		String processName = null == bPrdWkflow ? "" : bPrdWkflow.getFlowName();
		if(StringUtil.isEmpty(processName)){
			log.error("缺少对应的流程组件配置，或是流程名称为空！");
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BPrdErrorConstant.SCF_BAS_PRD_20001),
					BPrdErrorConstant.SCF_BAS_PRD_20001);
		}
		map.put("modelId", modelId);
		map.put("processName", processName);
		map.put("appliType", appliType);
		return map;
	}
}
