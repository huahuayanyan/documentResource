/**
 * 
 */
package com.huateng.scf.bas.pbc.service.impl;

import java.math.BigDecimal;
import java.text.ParseException;
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
import com.huateng.authority.entity.BctlVO;
import com.huateng.authority.entity.UserInfo;
import com.huateng.authority.inter.service.ScubeUserService;
import com.huateng.base.common.beans.Page;
import com.huateng.flowsharp.api.IProcessService;
import com.huateng.flowsharp.api.ITaskService;
import com.huateng.flowsharp.entity.FlowsharpException;
import com.huateng.flowsharp.entity.ProcessEntity;
import com.huateng.scf.bas.bcp.dao.ISBcpAppliLowerPriceDAO;
import com.huateng.scf.bas.bcp.dao.model.SBcpAppliLowerPrice;
import com.huateng.scf.bas.bcp.dao.model.SBcpAppliLowerPriceExample;
import com.huateng.scf.bas.cnt.constant.BCntErrorConstant;
import com.huateng.scf.bas.cnt.model.BCntMprotBaseInfo;
import com.huateng.scf.bas.cnt.model.BCntMprotCmPriceHis;
import com.huateng.scf.bas.cnt.model.BCntMprotPartInfo;
import com.huateng.scf.bas.cnt.model.MonitorProtocolVO;
import com.huateng.scf.bas.cnt.service.IBCntMprotBaseInfoService;
import com.huateng.scf.bas.cnt.service.IBCntMprotCmPriceHisService;
import com.huateng.scf.bas.cnt.service.IBCntMprotPartInfoService;
import com.huateng.scf.bas.cnt.service.IMonitorProtocolService;
import com.huateng.scf.bas.common.constant.BComErrorConstant;
import com.huateng.scf.bas.common.constant.NoticeConstant;
import com.huateng.scf.bas.common.constant.ScfBasConstant;
import com.huateng.scf.bas.common.service.IScfWorkFlowService;
import com.huateng.scf.bas.common.startup.ScfBaseData;
import com.huateng.scf.bas.common.startup.ScfMessageUtil;
import com.huateng.scf.bas.common.util.ScfDateUtil;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.common.util.UUIDGeneratorUtil;
import com.huateng.scf.bas.crm.model.BCrmBaseInfo;
import com.huateng.scf.bas.crm.model.BCrmEntInfo;
import com.huateng.scf.bas.crm.service.IBCrmBaseInfoService;
import com.huateng.scf.bas.crm.service.IBCrmEntInfoService;
import com.huateng.scf.bas.crr.model.BCrrGntyCon;
import com.huateng.scf.bas.crr.service.IBCrrGntyConService;
import com.huateng.scf.bas.mrn.service.IContractService;
import com.huateng.scf.bas.nte.dao.IBNteNoticeBaseDAO;
import com.huateng.scf.bas.nte.dao.model.BNteNoticeBase;
import com.huateng.scf.bas.nte.service.IBNteNoticeBaseService;
import com.huateng.scf.bas.pbc.dao.IBPbcAppliBaseInfoDAO;
import com.huateng.scf.bas.pbc.dao.IBPbcAppliMtgInfoDAO;
import com.huateng.scf.bas.pbc.dao.IBPbcMtgBaseInfoDAO;
import com.huateng.scf.bas.pbc.dao.ext.ExtIBPbcMtgBaseInfoDAO;
import com.huateng.scf.bas.pbc.dao.model.BPbcAppliMtgInfo;
import com.huateng.scf.bas.pbc.dao.model.BPbcAppliMtgInfoExample;
import com.huateng.scf.bas.pbc.dao.model.BPbcMtgBaseInfo;
import com.huateng.scf.bas.pbc.model.AmountVO;
import com.huateng.scf.bas.pbc.model.BPbcAppliBaseInfo;
import com.huateng.scf.bas.pbc.model.BPbcMtgBaseInfoDO;
import com.huateng.scf.bas.pbc.model.BPbcMtgClass;
import com.huateng.scf.bas.pbc.model.CustInfo;
import com.huateng.scf.bas.pbc.model.GntyconInfo;
import com.huateng.scf.bas.pbc.model.ProcessTemplate;
import com.huateng.scf.bas.pbc.model.QualityApplyDO;
import com.huateng.scf.bas.pbc.model.SlaveProtoContInfo;
import com.huateng.scf.bas.pbc.service.IAmountService;
import com.huateng.scf.bas.pbc.service.IBPbcAppliBaseInfoService;
import com.huateng.scf.bas.pbc.service.IBPbcAppliMtgInfoService;
import com.huateng.scf.bas.pbc.service.IBPbcMtgBaseInfoService;
import com.huateng.scf.bas.pbc.service.IBPbcMtgClassService;
import com.huateng.scf.bas.pbc.service.IBPbcMtgStockDtlService;
import com.huateng.scf.bas.pbc.service.IBPbcMtgStorDeliService;
import com.huateng.scf.bas.pbc.service.IMortgageEnteringService;
import com.huateng.scf.bas.pbc.service.IQualityApplyService;
import com.huateng.scf.bas.pbc.vo.MortgageApplyVO;
import com.huateng.scf.bas.prd.model.BPrdWkflowCop;
import com.huateng.scf.bas.prd.service.IBPrdInfoService;
import com.huateng.scf.bas.prd.service.IBPrdWkflowCopService;
import com.huateng.scf.bas.sys.constant.WorkflowConstant;
import com.huateng.scf.bas.sys.dao.IBSysRegionDAO;
import com.huateng.scf.bas.sys.dao.model.BSysRegion;
import com.huateng.scf.bas.sys.dao.model.BSysRegionExample;
import com.huateng.scf.bas.sys.service.DealEndFlowService;
import com.huateng.scf.bas.sys.service.DealInFlowService;
import com.huateng.scf.bas.sys.service.IBSysSerialNoService;
import com.huateng.scf.rec.bcp.constant.RBcpErrorConstant;
import com.huateng.scf.sto.nwr.dao.ISBcpMortBillNormalDAO;
import com.huateng.scf.sto.nwr.dao.model.SBcpMortBillNormal;
import com.huateng.scf.sto.nwr.vo.AppliMortgageBaseQryVO;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * <p>
 * </p>
 *
 * @author huangshuidan
 * @date 2016年11月22日下午4:53:26
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 *            <pre>
 * =================Modify Record=======================
 * Modifier			   date			              Content
 * huangshuidan		   2016年11月22日下午4:53:26              新增
 *
 *            </pre>
 */
@ScubeService
@Service("QualityApplyServiceImpl")
public class QualityApplyServiceImpl implements IQualityApplyService, DealInFlowService, DealEndFlowService {

	private final Logger log = LoggerFactory.getLogger(getClass());
	@Autowired
	ITaskService taskService;// 流程任务

	@Resource(name = "BCrrGntyConServiceImpl")
	IBCrrGntyConService bCrrGntyConService;

//	@Resource(name = "SBcpAppliLowerPriceServiceImpl")
//	ISBcpAppliLowerPriceService sBcpAppliLowerPriceService;

	@Resource(name = "BCrmBaseInfoServiceImpl")
	IBCrmBaseInfoService bCrmBaseInfoService;

	@Resource(name = "BCrmEntInfoServiceImpl")
	IBCrmEntInfoService bCrmEntInfoService;

	@Resource(name = "BNteNoticeBaseServiceImpl")
	IBNteNoticeBaseService bNteNoticeBaseService;

	@Resource(name = "BPbcMtgClassServiceImpl")
	IBPbcMtgClassService bPbcMtgClassService;

	@Resource(name = "MonitorProtocolServiceImpl")
	IMonitorProtocolService monitorProtocolService;

	@Resource(name = "MortgageEnteringServiceImpl")
	IMortgageEnteringService mortgageEnteringService;

	@Resource(name = "BCntMprotCmPriceHisServiceImpl")
	IBCntMprotCmPriceHisService bCntMprotCmPriceHisService;

	@Resource(name = "BPbcMtgBaseInfoDAO")
	IBPbcMtgBaseInfoDAO bPbcMtgBaseInfoDAO;

	@Resource(name = "ExtBPbcMtgBaseInfoDAO")
	ExtIBPbcMtgBaseInfoDAO extIBPbcMtgBaseInfoDAO;

	@Resource(name = "BPbcAppliBaseInfoDAO")
	IBPbcAppliBaseInfoDAO bPbcAppliBaseInfoDAO;

	@Resource(name = "BPbcAppliMtgInfoDAO")
	IBPbcAppliMtgInfoDAO bPbcAppliMtgInfoDAO;

	@Resource(name = "SBcpAppliLowerPriceDAO")
	ISBcpAppliLowerPriceDAO sBcpAppliLowerPriceDAO;

	@Resource(name = "BSysSerialNoServiceImpl")
	private IBSysSerialNoService bSysSerialNoService;// 流水号生成服务

	@Resource(name = "AmountServiceImpl")
	private IAmountService amountService;

	@Resource(name = "BPbcMtgStockDtlServiceImpl")
	IBPbcMtgStockDtlService bPbcMtgStockDtlService;

	@Resource(name = "BPbcMtgStorDeliServiceImpl")
	IBPbcMtgStorDeliService bPbcMtgStorDeliService;

	@Resource(name = "BPrdWkflowCopServiceImpl")
	private IBPrdWkflowCopService bPrdWkflowCopService;

	// 产品信息
	@Resource(name = "BPrdInfoServiceImpl")
	IBPrdInfoService bPrdInfoService;

	// 多方协议参与者信息
	@Resource(name = "BCntMprotPartInfoServiceImpl")
	IBCntMprotPartInfoService bCntMprotPartInfoService;

	@Resource(name = "BPbcAppliMtgInfoServiceImpl")
	IBPbcAppliMtgInfoService bPbcAppliMtgInfoService;

	// 押品信息
	@Resource(name = "BPbcMtgBaseInfoServiceImpl")
	IBPbcMtgBaseInfoService bPbcMtgBaseInfoService;

	// 押品信息
	@Resource(name = "BCntMprotBaseInfoServiceImpl")
	IBCntMprotBaseInfoService bCntMprotBaseInfoService;

	@Autowired
	ScubeUserService scubeUserService;

	@Autowired
	private IProcessService processService;

	// @Autowired
	// private ITaskService taskService;

	@Resource(name = IBPbcAppliBaseInfoService.BEAN_ID)
	IBPbcAppliBaseInfoService bPbcAppliBaseInfoService;// 业务申请表

	// 通知书
	@Resource(name = "BNteNoticeBaseDAO")
	IBNteNoticeBaseDAO bNteNoticeBaseDAO;

	@Resource(name = "BSysRegionDAO")
	IBSysRegionDAO iBSysRegionDAO;

	@Resource(name = IScfWorkFlowService.BEAN_ID)
	IScfWorkFlowService scfWorkFlowService;

	// 客户信息
	@Resource(name = "BCrmBaseInfoServiceImpl")
	IBCrmBaseInfoService bcrmbaseinfoservice;

	@Resource(name = "BPbcAppliMtgInfoServiceImpl")
	IBPbcAppliMtgInfoService bpbcapplimtginfoservice;

	@Resource(name = "ISBcpMortBillNormalDAO")
	ISBcpMortBillNormalDAO sbcpmortbillnormaldao;

	@Resource(name = "ContractServiceImpl")
	IContractService contractservice;

	@Override
	public SlaveProtoContInfo slaveProtocontInfo(int pageNo, int pageSize, QualityApplyDO qualityApplyDO) {
		String conId = qualityApplyDO.getConId();
		SlaveProtoContInfo slaveProtoContInfo = new SlaveProtoContInfo();
		String appNo = qualityApplyDO.getAppNo();
		// 最新最低控货价值
		BigDecimal lowPriceNew = BigDecimal.ZERO;
		// 查询本次入库押品总价值
		if (appNo != null) {
			BPbcAppliBaseInfo bPbcAppliBaseInfo = bPbcAppliBaseInfoService.findBPbcAppliBaseInfoByKey(appNo);
			slaveProtoContInfo.setAmount(bPbcAppliBaseInfo.getAmt());
			conId = bPbcAppliBaseInfo.getSlaveContno();
			SBcpAppliLowerPriceExample example = new SBcpAppliLowerPriceExample();
			SBcpAppliLowerPriceExample.Criteria e = example.createCriteria();
			e.andAppnoEqualTo(appNo);
			List<SBcpAppliLowerPrice> list = sBcpAppliLowerPriceDAO.selectByExample(example);
			if (list != null && list.size() > 0) {
				SBcpAppliLowerPrice info = list.get(0);
				lowPriceNew = info.getLowPriceNew();
			}
		} else {
			slaveProtoContInfo.setAmount(new BigDecimal(0));
		}
		BCrrGntyCon bCrrGntyCon = bCrrGntyConService.findBCrrGntyConByConId(conId);
		if (bCrrGntyCon == null) {
			log.error("抵质押合同信息丢失！");
			throw new ScubeBizException("抵质押合同信息丢失！");
		}

		MonitorProtocolVO monitorProtocolVO = monitorProtocolService.monitorProtocolQuery(bCrrGntyCon.getPrtclNo());
		slaveProtoContInfo.setConId(conId);
		// 出质人翻译
		BCrmBaseInfo bCrmBaseInfo = bCrmBaseInfoService.findBCrmBaseInfoByCustcd(bCrrGntyCon.getGutId());
		slaveProtoContInfo.setSecName(bCrmBaseInfo.getCname());// 出质人
		slaveProtoContInfo.setPrtclNo(bCrrGntyCon.getPrtclNo());// 监管协议号
		slaveProtoContInfo.setThrName(monitorProtocolVO.getThrName());// 监管公司名称
		slaveProtoContInfo.setProductId(bCrrGntyCon.getVidPrdId());// 业务品种
		slaveProtoContInfo.setMoniType(monitorProtocolVO.getMoniType());

		// 计算敞口
		AmountVO amountVO = new AmountVO();
		amountVO.setProductId(slaveProtoContInfo.getProductId());
		amountVO.setSlaveContno(conId);
		// 初始化以下几个参数
		amountVO.setBailInit(new BigDecimal(0));
		amountVO.setCashInit(new BigDecimal(0));
		amountVO.setBailRefund(new BigDecimal(0));
		amountVO.setCashRefund(new BigDecimal(0));
		amountVO.setBailAmount(new BigDecimal(0));
		amountVO.setCashAmount(new BigDecimal(0));

		BigDecimal debtAmount = amountService.getPant(amountVO);// 融资余额-保证金总额

		// 计算已入库押品总价值
		BigDecimal mortgageAmount = BigDecimal.ZERO;
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("slaveContno", conId);
		mortgageAmount = bPbcMtgBaseInfoService.getMortgageSumPriceByParam(map);
		slaveProtoContInfo.setMortgageAmount(mortgageAmount);// 已入库押品总价值
		slaveProtoContInfo.setRation(bCrrGntyCon.getRation());// 抵/质押率(%)
		slaveProtoContInfo.setOpenAmount(debtAmount);// 敞口余额
		if(appNo != null)
			slaveProtoContInfo.setLowPriceNew(lowPriceNew);// 最低控货价值
		else
			slaveProtoContInfo.setLowPriceNew(bCrrGntyCon.getLowPriceNew());
		return slaveProtoContInfo;
	}

	@Override
	public GntyconInfo findBCrrGntyCon(QualityApplyDO qualityApplyDO) {
		GntyconInfo gntyconInfo = new GntyconInfo();
		String conId = qualityApplyDO.getConId();
		BCrrGntyCon bCrrGntyCon = bCrrGntyConService.findBCrrGntyConByConId(conId);
		gntyconInfo.setPrtclNo(bCrrGntyCon.getPrtclNo());
		gntyconInfo.setConId(bCrrGntyCon.getConId());
		gntyconInfo.setRation(bCrrGntyCon.getRation());
		gntyconInfo.setGuardRat(bCrrGntyCon.getGuardRat());
		gntyconInfo.setGutyTyp(bCrrGntyCon.getGutyTyp());
		gntyconInfo.setConStat(bCrrGntyCon.getConStat());
		gntyconInfo.setGutCurcd(bCrrGntyCon.getGutCurcd());
		gntyconInfo.setGutVal(bCrrGntyCon.getGutVal());
		MonitorProtocolVO monitorProtocolVO = monitorProtocolService.monitorProtocolQuery(bCrrGntyCon.getPrtclNo());
		gntyconInfo.setProductId(monitorProtocolVO.getProductId());
		gntyconInfo.setSecName(monitorProtocolVO.getSecName());
		gntyconInfo.setThrName(monitorProtocolVO.getThrName());
		gntyconInfo.setStartDate(monitorProtocolVO.getStartDate());
		gntyconInfo.setEndDate(monitorProtocolVO.getEndDate());
		gntyconInfo.setTlrName(monitorProtocolVO.getTlrName());
		gntyconInfo.setBrcodeNm(monitorProtocolVO.getBrcodeNm());
		return gntyconInfo;
	}

	@Override
	public MonitorProtocolVO monitorProtocontInfo(QualityApplyDO qualityApplyDO) {
		String conId = qualityApplyDO.getConId();
		BCrrGntyCon bCrrGntyCon = bCrrGntyConService.findBCrrGntyConByConId(conId);
		// String prtclNo = qualityApplyDO.getPrtclNo();
		MonitorProtocolVO monitorProtocolVO = monitorProtocolService.monitorProtocolQuery(bCrrGntyCon.getPrtclNo());
		return monitorProtocolVO;
	}

	@Override
	public CustInfo findBCrmBaseInfo(QualityApplyDO qualityApplyDO) {
		// String slaveContno = qualityApplyDO.getSlaveContno();
		// BCrrGntyCon bCrrGntyCon =
		// bCrrGntyConService.findBCrrGntyConByConId(slaveContno);
		CustInfo custInfo = new CustInfo();
		String custcd = qualityApplyDO.getGutId();
		BCrmBaseInfo cbi = new BCrmBaseInfo();
		cbi.setCustcd(custcd);
		BCrmBaseInfo bCrmBaseInfo = bCrmBaseInfoService.findBCrmBaseInfoByKey(cbi);
		BCrmEntInfo cei = new BCrmEntInfo();
		cei.setCustcd(custcd);
		BCrmEntInfo bCrmEntInfo = bCrmEntInfoService.findBCrmEntInfoByKey(cei);
		custInfo.setCustno(bCrmBaseInfo.getCustno());
		custInfo.setCname(bCrmBaseInfo.getCname());
		custInfo.setCcmsCustcd(bCrmBaseInfo.getCcmsCustcd());
		custInfo.setOrgCode(bCrmBaseInfo.getOrgCode());
		custInfo.setIndustryType(bCrmEntInfo.getIndustryType());
		custInfo.setIndustryTypeName(bCrmEntInfo.getIndustryTypeName());
		custInfo.setEnterpriseScope(bCrmEntInfo.getEnterpriseScope());
		custInfo.setIsMarketCorp(bCrmEntInfo.getIsMarketCorp());
		custInfo.setEstablishDate(bCrmEntInfo.getEstablishDate());
		custInfo.setRegCapital(bCrmEntInfo.getRegCapital());
		custInfo.setArea(bCrmEntInfo.getArea());
		// 转译地区 iBSysRegionDAO
		if (bCrmEntInfo.getArea() != null && !"".equals(bCrmEntInfo.getArea())) {
			BSysRegionExample regionExample = new BSysRegionExample();
			regionExample.createCriteria().andRegionCodeEqualTo(bCrmEntInfo.getArea());
			List<BSysRegion> list = iBSysRegionDAO.selectByExample(regionExample);
			if (list != null && list.size() == 1) {
				custInfo.setAreaName(list.get(0).getRegionName());
			}
		}

		custInfo.setTlrcd(bCrmBaseInfo.getTlrcd());
		custInfo.setTlrName(bCrmBaseInfo.getTlrName()); // 经办人
		custInfo.setBrcode(bCrmBaseInfo.getBrcode());
		custInfo.setBrName(bCrmBaseInfo.getBrName());// 经办机构
		custInfo.setCreditFlag(bCrmBaseInfo.getCreditFlag());
		custInfo.setImportantFlag(bCrmBaseInfo.getImportantFlag());
		custInfo.setCoreFlag(bCrmBaseInfo.getCoreFlag());
		custInfo.setMoniFlag(bCrmBaseInfo.getMoniFlag());
		custInfo.setFlcFlag(bCrmBaseInfo.getFlcFlag());
		custInfo.setInsureFlag(bCrmBaseInfo.getInsureFlag());
		custInfo.setFactorFlag(bCrmBaseInfo.getFactorFlag());
		custInfo.setCommercialFalg(bCrmBaseInfo.getCommercialFalg());
		custInfo.setSupplyPosition(bCrmEntInfo.getSupplyPosition());
		custInfo.setContactName(bCrmEntInfo.getContactName());
		custInfo.setContactTel(bCrmEntInfo.getContactTel());
		custInfo.setFax(bCrmEntInfo.getFax());
		custInfo.setRegAddr(bCrmEntInfo.getRegAddr());
		custInfo.setContactAddr(bCrmEntInfo.getContactAddr());
		return custInfo;
	}

	@Override
	@Transactional
	public String saveQualityApplyInfo(String conId, BigDecimal lowPriceNew, List<BPbcMtgBaseInfoDO> mortgageInfoList) {

		// 获取抵质押合同信息
		BCrrGntyCon bCrrGntyCon = bCrrGntyConService.findBCrrGntyConByConId(conId);
		// 获取监管合同信息
		MonitorProtocolVO monitorProtocolVO = monitorProtocolService.monitorProtocolQuery(bCrrGntyCon.getPrtclNo());
		String businessnoType = WorkflowConstant.APPLI_TYPE_DYNAMIC_QUALITY_APPLY;// 申请类型
		String workApplyType = WorkflowConstant.PROCNAME_DYNAMICQUALITYAPPLY;// 申请业务类型
		// 保存出质入库申请基本信息
		com.huateng.scf.bas.pbc.dao.model.BPbcAppliBaseInfo info = new com.huateng.scf.bas.pbc.dao.model.BPbcAppliBaseInfo();
		String appno = bSysSerialNoService.genSerialNo(ScfBasConstant.CZRK_APP_NO);// 担保提货流水号;
		info.setAppno(appno);
		info.setCustcd(bCrrGntyCon.getGutId());
		info.setCurcd(monitorProtocolVO.getCurcdNm());// 币种
		info.setProcessTemplateName(workApplyType);// 流程名称
		info.setAppliType(businessnoType);// 申请类型
		info.setBusinessnoType("02");// 从合同号类型
		info.setBusinessno(conId);// 从合同号
		info.setAppliStatus("00");// 申请状态:未提交（默认）
		info.setAppliStatusDtl("00");// 申请状态明细:未提交（默认）
		info.setPledgeMode(monitorProtocolVO.getMonitortype());// 质押模式
		info.setAppBrcode(ContextHolder.getOrgInfo().getBrNo());// 登记机构
		info.setAppDate(ScfDateUtil.getStringDate(new Date())); // 登记时间
		info.setAppTlrcd(ContextHolder.getUserInfo().getTlrNo());// 登记人
		Date startDate = null;
		// Date endDate=null;
		try {
			if (StringUtil.isStrNotEmpty(monitorProtocolVO.getStartDate())) {
				startDate = ScfDateUtil.toDate(monitorProtocolVO.getStartDate(), ScfDateUtil.DATE_FORMAT_YYYYMMDD);
			}
		} catch (ParseException e) {
			log.error("保存多方协议，日期转换错误" + e.getMessage());
			e.printStackTrace();
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BCntErrorConstant.SCF_BAS_CNT_20003), BCntErrorConstant.SCF_BAS_CNT_20003);
		}
		info.setStartTime(startDate);
		info.setStratDate(monitorProtocolVO.getStartDate());
		info.setStartBrcode(ContextHolder.getOrgInfo().getBrNo());
		info.setStartTlrcd(ContextHolder.getUserInfo().getTlrNo());
		info.setSupplyChainPdId(bCrrGntyCon.getVidPrdId());// 产品ID
		info.setSupplyChainPdId(monitorProtocolVO.getProductId());// 产品ID
		// info.setMastContno(contSlaveInfo.getMastContno());// 主合同号
		info.setSlaveContno(conId);// 业务合同号
		info.setProtocolNo(monitorProtocolVO.getProtocolNo());// 监管协议号
		info.setOtherProtocolNo(monitorProtocolVO.getProtocolNo());// 监管协议号
		info.setMemo(monitorProtocolVO.getOtherDes()); // 描述
		// info.setAmt();//业务发生额
		// info.setBailAmount();//保证金金额
		bPbcAppliBaseInfoDAO.insert(info);
		// 保存监管底线变更信息
		// 保存最低价值申请信息
		SBcpAppliLowerPrice info2 = new SBcpAppliLowerPrice();
		info2.setId(UUIDGeneratorUtil.generate());
		info2.setAppno(appno);
		info2.setMoniModel(monitorProtocolVO.getMonitortype());
		info2.setMoniOfCustcd(monitorProtocolVO.getThrCode());
		info2.setProtocolNo(monitorProtocolVO.getProtocolCode());
		info2.setSlaveContno(monitorProtocolVO.getProtocolCode());
		info2.setLowPrice(lowPriceNew);
		info2.setLowPriceNew(lowPriceNew);
		sBcpAppliLowerPriceDAO.insert(info2);

		// 保存申请押品信息
		BPbcAppliMtgInfo info3 = new BPbcAppliMtgInfo();
		for (int i = 0; i < mortgageInfoList.size(); i++) {
			info3.setId(UUIDGeneratorUtil.generate());
			info3.setAppno(appno);
			// info3.setProductId(mortgageInfoList);
			info3.setSlaveContno(mortgageInfoList.get(i).getMonitorProtocolNo());
			info3.setCustcd(mortgageInfoList.get(i).getCustcd());
			// if(StringUtil.isEmpty(info3.getMortgageNo())){
			// info3.setMortgageNo(getMortgageNo());
			// }
			info3.setMortgageNo(mortgageInfoList.get(i).getMortgageNo());
			info3.setSlaveContno(conId);// 担保合同号
			info3.setCustcd(mortgageInfoList.get(i).getCustcd());
			info3.setMoniOfCustcd(mortgageInfoList.get(i).getMoniOfCustcd());
			info3.setMastContno(mortgageInfoList.get(i).getMastContno());
			info3.setMonitorProtocolNo(mortgageInfoList.get(i).getMonitorProtocolNo());// 监管协议号
			info3.setFlag("01");// FLAG 01 可用
			info3.setStatus("01");// 状态 01 可用
			info3.setBrcode(ContextHolder.getOrgInfo().getBrNo());
			info3.setStockStatus(ScfBasConstant.STOCK_STATUS_NORMAL);// 押品状态
			bPbcAppliMtgInfoDAO.insert(info3);
			BPbcMtgBaseInfo bPbcMtgBaseInfo = new BPbcMtgBaseInfo();
			bPbcMtgBaseInfo.setMortgageNo(mortgageInfoList.get(i).getMortgageNo());
			bPbcMtgBaseInfo.setIsLocked(ScfBasConstant.LOCKED);
			bPbcMtgBaseInfo.setLockAppno(appno);
			bPbcMtgBaseInfoDAO.updateByPrimaryKeySelective(bPbcMtgBaseInfo);
		}

		String modelId = WorkflowConstant.PROCNAME_DYNAMICQUALITYAPPLY;
		String ProcessName = WorkflowConstant.QUALITYAPPLY_APPLY;
		String NodeId = WorkflowConstant.PROCNODE_APPLY;

		// 获取当前用户
		UserInfo user = ContextHolder.getUserInfo();
		String startedUserId = user.getTlrNo();
		// 发起流程并保存业务信息
		// String appNo = this.saveThipartiteConfirmApply(applyVO,
		// businessnoType, modelId);
		String appNo = appno;
		// 扩展业务信息
		String bizId = appno;
		String custCd = monitorProtocolVO.getCustcd();
		String custName = monitorProtocolVO.getSecName();
		// processService.startProcess(modelId, ProcessName, NodeId,
		// startedUserId, bizId, new String[]{appNo,custCd,custName,modelId});
		// 流程发起
		ProcessEntity processEntity = new ProcessEntity();
		try {
			processEntity = processService.startProcess(modelId, ProcessName, NodeId, startedUserId, bizId,
					new String[] { appNo, custCd, custName, modelId });
		} catch (FlowsharpException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BPbcAppliBaseInfo bPbcAppliBaseInfo = bPbcAppliBaseInfoService.findBPbcAppliBaseInfoByKey(appno);
		String processId = processEntity.getProcessId();
		bPbcAppliBaseInfo.setPiid(processId);
		bPbcAppliBaseInfoService.updateBPbcAppliBaseInfo(bPbcAppliBaseInfo);
		return appNo;
	}

	@Override
	@Transactional
	public String updateQualityApplyInfo(String appNo, String conId, BigDecimal lowPriceNew, List<BPbcMtgBaseInfoDO> mortgageInfoList) {

		// 获取抵质押合同信息
		BCrrGntyCon bCrrGntyCon = bCrrGntyConService.findBCrrGntyConByConId(conId);

		// 保存最低价值申请信息
		SBcpAppliLowerPrice info2 = new SBcpAppliLowerPrice();
		info2.setLowPriceNew(lowPriceNew);
		SBcpAppliLowerPriceExample example = new SBcpAppliLowerPriceExample();
		SBcpAppliLowerPriceExample.Criteria e = example.createCriteria();
		e.andAppnoEqualTo(appNo);
		sBcpAppliLowerPriceDAO.updateByExampleSelective(info2, example);

		// 保存申请押品信息
		BPbcAppliMtgInfoExample example1 = new BPbcAppliMtgInfoExample();
		BPbcAppliMtgInfoExample.Criteria criteria = example1.createCriteria();
		criteria.andAppnoEqualTo(appNo);
		bPbcAppliMtgInfoDAO.deleteByExample(example1);
		BPbcAppliMtgInfo info3 = new BPbcAppliMtgInfo();
		for (int i = 0; i < mortgageInfoList.size(); i++) {
			info3.setId(UUIDGeneratorUtil.generate());
			info3.setAppno(appNo);
			info3.setSlaveContno(mortgageInfoList.get(i).getMonitorProtocolNo());
			info3.setCustcd(bCrrGntyCon.getGutId());
			info3.setMortgageNo(mortgageInfoList.get(i).getMortgageNo());
			info3.setSlaveContno(conId);// 担保合同号
			info3.setMoniOfCustcd(mortgageInfoList.get(i).getMoniOfCustcd());
			info3.setMastContno(mortgageInfoList.get(i).getMastContno());
			info3.setMonitorProtocolNo(mortgageInfoList.get(i).getMonitorProtocolNo());// 监管协议号
			info3.setFlag("01");// FLAG 01 可用
			info3.setStatus("01");// 状态 01 可用
			info3.setTotPrice(mortgageInfoList.get(i).getTotPrice());
			info3.setBrcode(ContextHolder.getOrgInfo().getBrNo());
		}
		bPbcAppliMtgInfoDAO.insert(info3);
		for (int i = 0; i < mortgageInfoList.size(); i++) {
			BPbcMtgBaseInfo record = new BPbcMtgBaseInfo();
			record.setMortgageNo(mortgageInfoList.get(i).getMortgageNo());
			record.setConfirmPrice(mortgageInfoList.get(i).getConfirmPrice());// 核定单价
			record.setFixMortgageNo(mortgageInfoList.get(i).getFixMortgageNo());// 盯市编号，市场货价表货物编号
			record.setConfirmAccording(mortgageInfoList.get(i).getConfirmAccording());// 核价依据
			record.setMarketPrice(mortgageInfoList.get(i).getMarketPrice());// 市场价
			record.setJoinBatch(mortgageInfoList.get(i).getJoinBatch());
			record.setStockStatus(mortgageInfoList.get(i).getStockStatus());
			if (!(record.getConfirmPrice() == null && record.getFixMortgageNo() == null && record.getConfirmAccording() == null
					&& record.getMarketPrice() == null && record.getJoinBatch() == null)) {
				bPbcMtgBaseInfoDAO.updateByPrimaryKeySelective(record);
			}
		}

		return appNo;
	}

	// 代办任务第一节点的提交按钮
	@Override
	@Transactional
	public void submitQualityApplyInfo(String appNo, String conId, BigDecimal lowPriceNew, List<BPbcMtgBaseInfoDO> mortgageInfoList, String state) {

		if (appNo != null && !"".equals(appNo)) {
			// 提交业务处理
			if (state.equals(WorkflowConstant.WRITE_TASK)) {

			}
			// 核价业务处理
			if (state.equals(WorkflowConstant.CHECK_TASK)) {
				for (int i = 0; i < mortgageInfoList.size(); i++) {
					BPbcMtgBaseInfo pami = new BPbcMtgBaseInfo();
					pami.setMortgageNo(mortgageInfoList.get(i).getMortgageNo());
					pami.setTotPrice(mortgageInfoList.get(i).getTotPrice());
					if (mortgageInfoList.get(i).getConfirmPrice() != null) {
						pami.setConfirmPrice(mortgageInfoList.get(i).getConfirmPrice());
					} else {
						throw new ScubeBizException("核定价不能为空！");
					}
					pami.setConfirmAccording(mortgageInfoList.get(i).getConfirmAccording());
					pami.setMarketPrice(mortgageInfoList.get(i).getMarketPrice());
					pami.setMemo(mortgageInfoList.get(i).getMemo());
					bPbcMtgBaseInfoDAO.updateByPrimaryKeySelective(pami);
				}
				// 新增通知书信息
				BNteNoticeBase record = new BNteNoticeBase();
				record.setId(UUIDGeneratorUtil.generate());
				record.setAppno(appNo);
				bNteNoticeBaseDAO.insert(record);
			}

			// 出质入库审核处理
			if (state.equals(WorkflowConstant.APPROVE_TASK)) {

			}

			// 出质入库确认处理
			if (state.equals(WorkflowConstant.RECEIPT_TASK)) {
				for (int i = 0; i < mortgageInfoList.size(); i++) {
					BPbcMtgBaseInfo pami = new BPbcMtgBaseInfo();
					pami.setMortgageNo(mortgageInfoList.get(i).getMortgageNo());
					pami.setStockStatus(ScfBasConstant.STOCK_STATUS_INVALID);
					// mortgageInfoList.get(i).setStockStatus(ScfBasConstant.STOCK_STATUS_INVALID);
					bPbcMtgBaseInfoDAO.updateByPrimaryKeySelective(pami);
				}
				BCrrGntyCon bCrrGntyCon = new BCrrGntyCon();
				bCrrGntyCon.setConId(conId);
				bCrrGntyCon.setLowPrice(lowPriceNew);
				bCrrGntyConService.update(bCrrGntyCon);
				// updateQualityApplyInfo(appNo,conId,lowPriceNew,mortgageInfoList);
			}
			BPbcAppliBaseInfo bPbcAppliBaseInfo = bPbcAppliBaseInfoService.findBPbcAppliBaseInfoByKey(appNo);
			bPbcAppliBaseInfo.setAppliStatus(WorkflowConstant.APPLI_STATUS_SUBMITUNAPPROVE);// 已提交(未审批)
			bPbcAppliBaseInfo.setAppliStatusDtl(WorkflowConstant.APPLI_STATUS_DTL_APPROVING);// 已提交
			bPbcAppliBaseInfoService.updateBPbcAppliBaseInfo(bPbcAppliBaseInfo);
			// 流程流转
			String status = WorkflowConstant.WORKFLOW_TRANS_AGREE;
			try {
				scfWorkFlowService.processTasks(bPbcAppliBaseInfo, status);
			} catch (FlowsharpException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// 流程开始
			// String userId = ContextHolder.getUserInfo().getTlrNo();// 操作员
			// try {
			// BCrmBaseInfo bCrmBaseInfo = new BCrmBaseInfo();
			// bCrmBaseInfo.setCustcd(bPbcAppliBaseInfo.getCustcd());
			// BCrmBaseInfo crminfo =
			// bcrmbaseinfoservice.findBCrmBaseInfoByKey(bCrmBaseInfo);
			// String cname = crminfo.getCname();
			// String modelId = WorkflowConstant.PROCNAME_DYNAMICQUALITYAPPLY;
			// String[] bizData = { bPbcAppliBaseInfo.getAppno(),
			// bPbcAppliBaseInfo.getCustcd(), cname, modelId,
			// ContextHolder.getUserInfo().getTlrName() };
			// String processId = bPbcAppliBaseInfo.getPiid();
			// // 领取任务
			//// String taskId = WorkflowConstant.WRITE_TASK;
			// String taskId = state;
			// taskService.takeTask(taskId, processId, userId);
			// // 任务提交
			// String comment = "任务完成";
			// taskService.completeTask(taskId, processId, userId, comment,
			// bizData);
			// // 节点转移(自己要再设置一下)
			// processService.autoSignal(processId);// 通知书回执节点(下一节点)
			// } catch (Exception e) {
			// throw new ScubeBizException("出质入库申请提交失败,流程申请基本信息更改失败！");
			// }
		} else {
			throw new ScubeBizException("出质入库申请提交失败,前台所传数据无业务申请号！");
		}
	}

	@Override
	public ProcessTemplate initPageUserOrg() {
		ProcessTemplate processTemplate = new ProcessTemplate();
		processTemplate = this.setPageUserOrg(processTemplate);
		return processTemplate;
	}

	/**
	 * 设置用户及机构 信息
	 * 
	 * @param threeProtocolVO
	 * @return
	 * @throws ScubeBizException
	 */
	public ProcessTemplate setPageUserOrg(ProcessTemplate processTemplate) {
		// 获取机构信息
		BctlVO bctlVO = ContextHolder.getOrgInfo();
		BPrdWkflowCop bPrdWkflowCop = new BPrdWkflowCop();
		bPrdWkflowCop.setFlowCopId(WorkflowConstant.PROCNAME_DYNAMICQUALITYAPPLY);
		List<BPrdWkflowCop> pwfc = bPrdWkflowCopService.findBPrdWkflowCopByBPrd(bPrdWkflowCop);
		processTemplate.setProcessTemplateName(pwfc.get(0).getFlowName());
		processTemplate.setStartBrName(bctlVO.getBrName());
		processTemplate.setStartTime(ScfDateUtil.formatDate(new Date(), ScfDateUtil.DATE_FORMAT_YYYYMMDD));
		UserInfo user = ContextHolder.getUserInfo();
		processTemplate.setStartTlrNm(user.getTlrName());
		return processTemplate;
	}

	// 任务基本信息
	@Override
	public BPbcAppliBaseInfo queryTaskInfoByAppno(String appno) {
		String process = "";
		process = WorkflowConstant.PROCNAME_DYNAMICQUALITYAPPLY;

		return scfWorkFlowService.findBPbcAppliBaseInfoByAppno(appno, process);
	}

	/*
	 * 任务基本信息
	 */
	@Override
	public BPbcAppliBaseInfo queryStaticTaskInfoByAppno(String appno) {
		String process = "";
		process = WorkflowConstant.PROCNAME_STATICQUALITYAPPLY;

		return scfWorkFlowService.findBPbcAppliBaseInfoByAppno(appno, process);
	}

	/**
	 * 查询出质物清单信息
	 * 
	 * @param appliMortgageBaseQryVO
	 * @return
	 * @throws BeansException
	 * @author mengjiajia
	 * @date 2017年4月13日下午4:50:25
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Page getApplyMortgageList(AppliMortgageBaseQryVO appliMortgageBaseQryVO) throws BeansException {
		Page result = bpbcapplimtginfoservice.getTblAppliMortgageBaseInfoByPara(appliMortgageBaseQryVO);
		List oldList = result.getRecords();
		int num = 0;
		if (!StringUtil.isEmpty(appliMortgageBaseQryVO.getBillno())) {
			if (appliMortgageBaseQryVO.getBillno().indexOf("/f") == -1) {
				if (bpbcapplimtginfoservice.queryAppliMortgageByBillno(appliMortgageBaseQryVO.getBillno())) {
					List list = bPbcMtgBaseInfoService.getBillstandardMorgByBillno(appliMortgageBaseQryVO.getBillno());
					if (list != null && list.size() > 0) {
						oldList.addAll(list);
						num = list.size();
					}
				}
			} else {
				String[] ids = appliMortgageBaseQryVO.getBillno().split("/f");
				for (int i = 0; i < ids.length; i++) {
					if (bpbcapplimtginfoservice.queryAppliMortgageByBillno(ids[i])) {
						List<com.huateng.scf.bas.pbc.dao.vo.BPbcMtgBaseInfoVO> list = bPbcMtgBaseInfoService.getBillstandardMorgByBillno(ids[i]);
						if (list != null && list.size() > 0) {
							for (com.huateng.scf.bas.pbc.dao.vo.BPbcMtgBaseInfoVO baseInfo : list) {
								SBcpMortBillNormal bcpMortBillNormal = sbcpmortbillnormaldao.selectByPrimaryKey(baseInfo.getBillno());
								if (bcpMortBillNormal != null) {
									baseInfo.setBillcode(bcpMortBillNormal.getBillcode());
								}
								oldList.add(baseInfo);
							}
							num += list.size();
						}
					}
				}
			}
		}
		result.setRecords(oldList);
		result.setTotalRecord(result.getTotalRecord() + num);
		return result;
	}

	/*
	 * 存货类出质入库押品添加
	 */
	@Override
	public Page MortgageEnteringAddListGettter(int pageNo, int pageSize, com.huateng.scf.bas.pbc.model.BPbcMtgBaseInfo baseInfo,
			List<com.huateng.scf.bas.pbc.model.BPbcMtgBaseInfo> baseInfoList) throws BeansException {
		Page page = new Page(pageSize, pageNo, 0);
		if (baseInfo != null) {
			ArrayList<String> arrayList = new ArrayList<String>();
			if (baseInfoList != null && baseInfoList.size() > 0) {
				for (com.huateng.scf.bas.pbc.model.BPbcMtgBaseInfo bPbcMtgBaseInfo1 : baseInfoList) {
					arrayList.add("'" + bPbcMtgBaseInfo1.getMortgageNo() + "'");
				}
			}
			HashMap<String, Object> map = new HashMap<String, Object>();

			String lockAppno = baseInfo.getLockAppno();// 锁定申请号
			String slaveContno = baseInfo.getSlaveContno();// 抵质押合同号

			String mortgageLevelOne = baseInfo.getMortgageLevelOne();// 押品一级编号
			String mortgageLevelTwo = baseInfo.getMortgageLevelTwo();// 押品二级编号
			String mortgageName = baseInfo.getMortgageName();// 押品名称
			map.put("lockAppno", lockAppno);
			map.put("slaveContno", slaveContno);

			map.put("mortgageLevelOne", mortgageLevelOne);
			map.put("mortgageLevelTwo", mortgageLevelTwo);

			map.put("mortgageName", mortgageName);
			map.put("mortgageNoList", arrayList);
			ArrayList<com.huateng.scf.bas.pbc.model.BPbcMtgBaseInfoVO> arrayList2 = new ArrayList<com.huateng.scf.bas.pbc.model.BPbcMtgBaseInfoVO>();
			List<BPbcMtgBaseInfo> BPbcMtgBaseInfoList = extIBPbcMtgBaseInfoDAO.getMortgageEnteringAddList(map, page);
			if (BPbcMtgBaseInfoList != null && BPbcMtgBaseInfoList.size() > 0) {
				for (BPbcMtgBaseInfo bPbcMtgBaseInfo1 : BPbcMtgBaseInfoList) {
					com.huateng.scf.bas.pbc.model.BPbcMtgBaseInfoVO bPbcMtgBaseInfoVO = new com.huateng.scf.bas.pbc.model.BPbcMtgBaseInfoVO();
					BeanUtils.copyProperties(bPbcMtgBaseInfo1, bPbcMtgBaseInfoVO);
					if (StringUtils.isNotEmpty(bPbcMtgBaseInfo1.getMortgageLevelOne())) {
						BPbcMtgClass bPbcMtgClassOne = bPbcMtgClassService.translateMortgageNameByCode(bPbcMtgBaseInfo1.getMortgageLevelOne());
						bPbcMtgBaseInfoVO.setMortgageLevelOneName(bPbcMtgClassOne.getMortgageName());
					}
					if (StringUtils.isNotEmpty(bPbcMtgBaseInfo1.getMortgageLevelTwo())) {
						BPbcMtgClass bPbcMtgClassTwo = bPbcMtgClassService.translateMortgageNameByCode(bPbcMtgBaseInfo1.getMortgageLevelTwo());
						bPbcMtgBaseInfoVO.setMortgageLevelTwoName(bPbcMtgClassTwo.getMortgageName());
					}
					arrayList2.add(bPbcMtgBaseInfoVO);
				}
				page.setRecords(arrayList2);
			}
		}
		return page;
	}

	/*
	 * 存货类动态/静态出质入库保存按钮发起流程
	 */
	@Override
	@Transactional
	public String saveQualityApply(SlaveProtoContInfo SlaveProtoContInfo, List<BPbcMtgBaseInfoDO> mortgageInfoList) throws BeansException {
		// 1.校验数据
		if (SlaveProtoContInfo == null || mortgageInfoList == null || mortgageInfoList.size() == 0) {
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10005), RBcpErrorConstant.SCF_REC_BCP_10005);
		}
		String businessnoType = "";// 申请类型
		String workApplyType = ""; // 申请业务类型
		String moniType = SlaveProtoContInfo.getMoniType();
		BigDecimal amt = SlaveProtoContInfo.getAmount();
		String slaveContno = SlaveProtoContInfo.getConId();
		String appno = SlaveProtoContInfo.getAppno();
		String protocolNo = SlaveProtoContInfo.getPrtclNo();// 监管合同号

		// 判断业务
		if (StringUtil.isEmpty(appno)) {
			// 保存操作
			if (ScfBasConstant.MONI_MODEL_DYNAMIC.equalsIgnoreCase(moniType)) {// 出质入库申请-动态
				businessnoType = WorkflowConstant.APPLI_TYPE_DYNAMIC_QUALITY_APPLY;
				workApplyType = WorkflowConstant.PROCNAME_DYNAMICQUALITYAPPLY;
			} else if (ScfBasConstant.MONI_MODEL_STATIC.equalsIgnoreCase(moniType)) {// 出质入库申请-静态
				businessnoType = WorkflowConstant.APPLI_TYPE_STATIC_QUALITY_APPLY;
				workApplyType = WorkflowConstant.PROCNAME_STATICQUALITYAPPLY;
			} else {
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10005),
						RBcpErrorConstant.SCF_REC_BCP_10005);
			}
			// 1.校验数据
			MortgageApplyVO mortgageApplyVO = new MortgageApplyVO();
			BCrrGntyCon bCrrGntyCon = bCrrGntyConService.findBCrrGntyConByConId(slaveContno);
			if (bCrrGntyCon == null) {
				throw new ScubeBizException("抵/质押合同关联失败，无对应抵/质押合同！");
			}
			BCntMprotBaseInfo bCntMprotBaseInfoMoni = bCntMprotBaseInfoService.findBCntMprotBaseInfoByKey(protocolNo);
			if (bCntMprotBaseInfoMoni == null) {
				throw new ScubeBizException("监管合同关联失败，无对应监管合同！");
			}
			// 监管公司名称
			BCntMprotPartInfo moniInfo = bCntMprotPartInfoService.findCustByProtocolNoAndRole(protocolNo, ScfBasConstant.PROTOCOL_PART_ROLE_MONI);
			if (moniInfo == null || StringUtils.isEmpty(moniInfo.getCustcd())) {
				throw new ScubeBizException("监管公司信息查询失败！");
			}
			// 校验监管公司是否拥有押品的监管货权 对应的表 TblMoniMortReal不知道是那一个
			// TODO
			// contractService.checkSuvRightOfGoods(moniCustcd,insertList,null);
			mortgageApplyVO.setMoniCustcd(moniInfo.getCustcd());
			mortgageApplyVO.setProductId(bCntMprotBaseInfoMoni.getProductId());
			mortgageApplyVO.setCustcd(bCrrGntyCon.getGutId());
			mortgageApplyVO.setSlaveContno(slaveContno);
			mortgageApplyVO.setAmt(amt);
			mortgageApplyVO.setProtocolNo(protocolNo);
			mortgageApplyVO.setMoniType(moniType);
			mortgageApplyVO.setAppliMortBizType(ScfBasConstant.MORT_BIZ_TYPE_PLEDGE_IN);
			mortgageApplyVO.setLowPriceNew(SlaveProtoContInfo.getLowPriceNew());
			// 2.保存信息
			// 保存出质入库申请基本信息
			appno = bPbcAppliBaseInfoService.saveQualityApplyInfo(mortgageApplyVO, businessnoType, workApplyType);
			// 保存监管底线变更信息
//			sBcpAppliLowerPriceService.saveAppliLowPrice(appno, mortgageApplyVO);
			// 保存申请押品信息
			modifyAppMortgageList(appno, mortgageInfoList);
			// 3.发起工作流
			// 工作流开始
			HashMap<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("modelId", workApplyType);
			paramMap.put("NodeId", WorkflowConstant.PROCNODE_APPLY);
			paramMap.put("startedUserId", ContextHolder.getUserInfo().getTlrNo());
			try {
				scfWorkFlowService.commonStartFlow(appno, workApplyType, workApplyType, paramMap);
			} catch (FlowsharpException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			// 更新本次入库金额
			BPbcAppliBaseInfo bPbcAppliBaseInfo = bPbcAppliBaseInfoService.findBPbcAppliBaseInfoByKey(appno);
			bPbcAppliBaseInfo.setAmt(amt);
			bPbcAppliBaseInfoService.updateBPbcAppliBaseInfo(bPbcAppliBaseInfo);
			// 更新押品申请信息
			modifyAppMortgageList(appno, mortgageInfoList);
			if (SlaveProtoContInfo.getLowPriceNew() != null) {
				// 更新监管下限
				MortgageApplyVO mortgageApplyVO = new MortgageApplyVO();
				mortgageApplyVO.setLowPriceNew(SlaveProtoContInfo.getLowPriceNew());
//				sBcpAppliLowerPriceService.saveAppliLowPrice(appno, mortgageApplyVO);
			}
		}
		return appno;
	}

	/*
	 * 
	 */
	@Override
	@Transactional
	public void modifyAppMortgageList(String appno, List<BPbcMtgBaseInfoDO> mortgageInfoList) throws BeansException {
		if (StringUtils.isEmpty(appno) || mortgageInfoList == null || mortgageInfoList.size() == 0) {
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10005), RBcpErrorConstant.SCF_REC_BCP_10005);
		}
		// 删除原来的业务申请明细信息
		bPbcAppliMtgInfoService.delAppliMortgageListByAppno(appno);
		// 解锁对应押品信息
		bPbcMtgBaseInfoService.releaseMortgageBaseInfoByAppno(appno);
		for (BPbcMtgBaseInfoDO bPbcMtgBaseInfo1 : mortgageInfoList) {
			com.huateng.scf.bas.pbc.model.BPbcAppliMtgInfo bPbcAppliMtgInfo = new com.huateng.scf.bas.pbc.model.BPbcAppliMtgInfo();
			BeanUtils.copyProperties(bPbcMtgBaseInfo1, bPbcAppliMtgInfo);
			// 因为BPbcAppliMtgInfo无对应的未出质数量
			// INV_QUANTITY字段，所以先存入QUANTITY，取出的时候再赋值给INV_QUANTITY
			bPbcAppliMtgInfo.setQuantity(bPbcMtgBaseInfo1.getInvQuantity());
			bPbcAppliMtgInfo.setAppno(appno);
			bPbcAppliMtgInfoService.addBPbcAppliMtgInfo(bPbcAppliMtgInfo);
			bPbcMtgBaseInfoService.lockMortgageBaseInfo(bPbcMtgBaseInfo1.getMortgageNo(), appno);
		}
	}

	/*
	 * 
	 */
	@Override
	@Transactional
	public String QualityAppWriteSubmitUpdater(SlaveProtoContInfo SlaveProtoContInfo, List<BPbcMtgBaseInfoDO> mortgageInfoList)
			throws BeansException {
		// 1.校验数据
		if (SlaveProtoContInfo == null || mortgageInfoList == null || mortgageInfoList.size() == 0) {
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10005), RBcpErrorConstant.SCF_REC_BCP_10005);
		}
		// 2.数据保存
		saveQualityApply(SlaveProtoContInfo, mortgageInfoList);
		// 3.流程流转
		BPbcAppliBaseInfo bPbcAppliBaseInfo = bPbcAppliBaseInfoService.findBPbcAppliBaseInfoByKey(SlaveProtoContInfo.getAppno());
		String status = WorkflowConstant.WORKFLOW_TRANS_AGREE;
		try {
			scfWorkFlowService.processTasks(bPbcAppliBaseInfo, status);
		} catch (Exception e) {
			log.debug(e.getMessage());
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BComErrorConstant.SCF_BAS_COM_10000), BComErrorConstant.SCF_BAS_COM_10000);
		}
		return SlaveProtoContInfo.getAppno();
	}

	/*
	 * 现货静态动态出质入库回执确认
	 */
	@Override
	@Transactional
	public void doWorkForPass(String appNo) {
		// 1.更新通知书
		bNteNoticeBaseService.modifyNoticeBaseInfo(appNo, NoticeConstant.NOTICE_BASE_STATUS_CONFIRM_AGREE);
		// 2.保存 押品基础信息表、押品基本信息表、出入库信息表、动态中更新监管下限以及历史表，增加核库信息
		qualityAppliAccountProcess(appNo);
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
	 * 
	 */
	@Override
	@Transactional
	public void doWorkForBack(String appNo) {
		// TODO Auto-generated method stub

	}

	/*
	 * 核价的时候页面提交按钮，生成对应通知书
	 */
	@Override
	@Transactional
	public void doWorkForSubmit(String appNo) throws ScubeBizException {
		// 生成通知书
		List noticeBaseInfoList = bNteNoticeBaseService.getNoticeBaseInfoByAppno(appNo);
		if (noticeBaseInfoList.size() == 0) {
			bNteNoticeBaseService.addNoticeByMortgagePriceFloor(appNo);
		} else {
			bNteNoticeBaseService.modifyNoticeByMortgagePriceFloor(appNo);
		}
	}

	/*
	 * 1.更新押品申请信息表 2.更新最低价值申请信息表 3.保存押品基本信息表 4.保存库存信息明细表 5.保存监管下线信息表
	 */
	@Override
	public void qualityAppliAccountProcess(String appno) throws BeansException {
		// 1.数据校验
		BPbcAppliBaseInfo bPbcAppliBaseInfo = bPbcAppliBaseInfoService.findBPbcAppliBaseInfoByKey(appno);
		BCrrGntyCon bCrrGntyCon = bCrrGntyConService.findBCrrGntyConByConId(bPbcAppliBaseInfo.getSlaveContno());
		if (bCrrGntyCon == null) {
			throw new ScubeBizException("抵/质押合同关联失败，无对应抵/质押合同！");
		}
		List<com.huateng.scf.bas.pbc.model.BPbcAppliMtgInfo> bPbcAppliMtgInfoList = bPbcAppliMtgInfoService.findBPbcAppliMtgInfoByAppno(appno);
		if (bPbcAppliMtgInfoList == null || bPbcAppliMtgInfoList.size() == 0) {
			throw new ScubeBizException("无对应申请出质入库押品信息！");
		}
		BCntMprotBaseInfo bCntMprotBaseInfoMoni = bCntMprotBaseInfoService.findBCntMprotBaseInfoByKey(bPbcAppliBaseInfo.getProtocolNo());
		if (bCntMprotBaseInfoMoni == null) {
			throw new ScubeBizException("监管合同关联失败，无对应监管合同！");
		}
		// 监管公司名称
		BCntMprotPartInfo moniInfo = bCntMprotPartInfoService.findCustByProtocolNoAndRole(bPbcAppliBaseInfo.getProtocolNo(),
				ScfBasConstant.PROTOCOL_PART_ROLE_MONI);
		if (moniInfo == null || StringUtils.isEmpty(moniInfo.getCustcd())) {
			throw new ScubeBizException("监管公司信息查询失败！");
		}
		// 2.数据保存
		// 监管方式：1-动态模式下 需更新监管下限以及变更历史表
		MonitorProtocolVO monitorProtocolVO = monitorProtocolService.monitorProtocolQuery(bCrrGntyCon.getPrtclNo());
		if (ScfBasConstant.MONI_MODEL_DYNAMIC.equalsIgnoreCase(monitorProtocolVO.getMoniType())) {// 出质入库申请-动态
			SBcpAppliLowerPriceExample example = new SBcpAppliLowerPriceExample();
			SBcpAppliLowerPriceExample.Criteria e = example.createCriteria();
			e.andAppnoEqualTo(appno);
			List<SBcpAppliLowerPrice> list = sBcpAppliLowerPriceDAO.selectByExample(example);
			if (list != null && list.size() > 0) {
				SBcpAppliLowerPrice info = list.get(0);
				// 修改抵质押合同
				bCrrGntyCon.setLowPriceNew(info.getLowPriceNew());
				bCrrGntyConService.update(bCrrGntyCon);
				// 更新监管协议最低价值变更历史表
				BCntMprotCmPriceHis bCntMprotCmPriceHis = new com.huateng.scf.bas.cnt.model.BCntMprotCmPriceHis();
				bCntMprotCmPriceHis.setProtocolNo(bCrrGntyCon.getPrtclNo());
				bCntMprotCmPriceHis.setSlaveContno(bCrrGntyCon.getConId());
				bCntMprotCmPriceHis.setLowPrice(info.getLowPrice());
				bCntMprotCmPriceHis.setLowPriceNew(info.getLowPriceNew());
				bCntMprotCmPriceHis.setTxdate(ScfBaseData.getScfGlobalInfoData().getTxnDate()); // 日期
				bCntMprotCmPriceHis.setRecordTlrcd(ContextHolder.getUserInfo().getTlrNo()); // 登记人
				bCntMprotCmPriceHis.setRecordBrcode(ContextHolder.getOrgInfo().getBrNo()); // 登记机构
				bCntMprotCmPriceHisService.add(bCntMprotCmPriceHis);
			}
		}

		// 记TBL_MORTGAGE_STOR_DELI_INFO[押品流水信息表]
		// B_PBC_MTG_STOR_DELI(押品出质入库等业务信息表)
		String storDeliInfoId = bPbcMtgStorDeliService.addTblMortgageStorDeliInfo(bPbcAppliBaseInfo, ScfBasConstant.STOR_DELI_BIZ_TYPE_STOCK,
				ScfBasConstant.STOR_OR_DELI_IN, null, bCrrGntyCon.getVidPrdId());

		for (com.huateng.scf.bas.pbc.model.BPbcAppliMtgInfo bPbcAppliMtgInfo1 : bPbcAppliMtgInfoList) {
			com.huateng.scf.bas.pbc.model.BPbcAppliMtgInfoVO bPbcAppliMtgInfoVO = new com.huateng.scf.bas.pbc.model.BPbcAppliMtgInfoVO();
			BeanUtils.copyProperties(bPbcAppliMtgInfo1, bPbcAppliMtgInfoVO);
			// 押品数据变更明细信息表
			bPbcMtgStockDtlService.addTblMortgageStockInfoByAppliInfo(bPbcAppliMtgInfoVO, storDeliInfoId, ScfBasConstant.MORT_BIZ_TYPE_PLEDGE_IN,
					ScfBasConstant.STOR_DELI_BIZ_TYPE_STOCK, bCrrGntyCon.getVidPrdId());
			// 记押品基础信息表（最重要的方法！！！！！！！！！！，改变状态为出质入库等字段。）
			bPbcMtgBaseInfoService.addMortgageBaseInfoByAppli(bPbcAppliMtgInfo1, bPbcAppliBaseInfo);
			// 更新押品申请业务类型
			bPbcAppliMtgInfo1.setAppliMortBizType(ScfBasConstant.MORT_BIZ_TYPE_PLEDGE_IN);// 业务类型
			bPbcAppliMtgInfo1.setStockStatus(ScfBasConstant.STOCK_STATUS_NORMAL);// 库存状态
			bPbcAppliMtgInfoService.updateBPbcAppliMtgInfo(bPbcAppliMtgInfo1);
		}
	}

	/**
	 * 保存到B_PBC_APPLI_BASE_INFO[业务申请基本信息表]
	 * @param mortgageApplyVO
	 * @param businessnoType
	 * @param workApplyType
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年5月16日下午4:05:23
	 */
	@Override
	public String saveQualityApplyInfo(MortgageApplyVO mortgageApplyVO,String businessnoType,String workApplyType) throws ScubeBizException
	{
		contractservice.checkUpdateSlaveContractBySupplyChainPdId(mortgageApplyVO.getSlaveContno(),mortgageApplyVO.getProductId());
		BCrrGntyCon contSlaveInfo = bCrrGntyConService.findBCrrGntyConByConId(mortgageApplyVO.getSlaveContno());
		BPbcAppliBaseInfo tblAppliBaseInfo = null;
		if (StringUtil.isEmpty(mortgageApplyVO.getAppno()))
		{                                       // 保存新增
			tblAppliBaseInfo = new BPbcAppliBaseInfo();
			BeanUtils.copyProperties(mortgageApplyVO, tblAppliBaseInfo);                         // 拷贝信息                            // 客户号
			String appno = bSysSerialNoService.genSerialNo("PLTH_APP_NO");
			tblAppliBaseInfo.setAppno(appno);
			tblAppliBaseInfo.setCurcd(contSlaveInfo.getGutCurcd());                         // 币种
			tblAppliBaseInfo.setProcessTemplateName(workApplyType);              		 // 流程名称
			tblAppliBaseInfo.setAppliType(businessnoType);                               // 申请类型
			tblAppliBaseInfo.setBusinessnoType(ScfBasConstant.BUSINESSNO_TYPE_SLAVECONTNO);// 从合同号类型
			tblAppliBaseInfo.setBusinessno(mortgageApplyVO.getSlaveContno());                    // 从合同号
			tblAppliBaseInfo.setAppliStatus(WorkflowConstant.APPLI_STATUS_UNSUBMIT);         // 申请状态:未提交（默认）
			tblAppliBaseInfo.setAppliStatusDtl(WorkflowConstant.APPLI_STATUS_DTL_WRITING);  // 申请状态明细:未提交（默认）
			tblAppliBaseInfo.setPledgeMode(mortgageApplyVO.getMoniType());						//质押模式
			if(!StringUtil.isEmpty(mortgageApplyVO.getProductId()))
			{
				tblAppliBaseInfo.setSupplyChainPdId(mortgageApplyVO.getProductId());               // 产品ID
			}
			else 
			{
				tblAppliBaseInfo.setSupplyChainPdId(contSlaveInfo.getVidPrdId());
			}
//			tblAppliBaseInfo.setMastContno(contSlaveInfo.getMastContno());                     // 主合同号
			tblAppliBaseInfo.setSlaveContno(mortgageApplyVO.getSlaveContno());	                 // 业务合同号
			tblAppliBaseInfo.setProtocolNo(contSlaveInfo.getPrtclNo());              	// 监管协议号
			tblAppliBaseInfo.setOtherProtocolNo(contSlaveInfo.getPrtclNo());              	// 监管协议号
			tblAppliBaseInfo.setMemo(mortgageApplyVO.getDescription());                   // 描述
			tblAppliBaseInfo.setAmt(mortgageApplyVO.getAmt());                      //业务发生额
			tblAppliBaseInfo.setBailAmount(mortgageApplyVO.getBailAmount());   //保证金金额
			bPbcAppliBaseInfoService.addBPbcAppliBaseInfo(tblAppliBaseInfo);
		}
		else
		{//更新
			tblAppliBaseInfo = bPbcAppliBaseInfoService.findBPbcAppliBaseInfoByKey(mortgageApplyVO.getAppno());
			tblAppliBaseInfo.setMemo(mortgageApplyVO.getDescription());
			tblAppliBaseInfo.setDeliverValue(mortgageApplyVO.getDeliverValue());
			tblAppliBaseInfo.setAmt(mortgageApplyVO.getAmt());
			tblAppliBaseInfo.setBailAmount(mortgageApplyVO.getBailAmount());
			bPbcAppliBaseInfoService.updateBPbcAppliBaseInfo(tblAppliBaseInfo);
		}
		return tblAppliBaseInfo.getAppno();
	}
}
