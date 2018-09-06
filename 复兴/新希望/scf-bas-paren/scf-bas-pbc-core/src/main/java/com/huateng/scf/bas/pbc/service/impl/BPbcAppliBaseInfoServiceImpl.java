/**
 * 
 */
package com.huateng.scf.bas.pbc.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
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
import com.huateng.authority.entity.TlrInfoVO;
import com.huateng.authority.entity.UserInfo;
import com.huateng.authority.inter.service.ScubeUserService;
import com.huateng.authority.service.OrgService;
import com.huateng.authority.service.UserService;
import com.huateng.base.common.beans.Page;
import com.huateng.flowsharp.api.IProcessService;
import com.huateng.flowsharp.entity.ProcessEntity;
import com.huateng.scf.adv.fcs.model.FourApplyVO;
import com.huateng.scf.bas.cnt.model.BCntDebtInfo;
import com.huateng.scf.bas.cnt.model.BCntDebtInfoVO;
import com.huateng.scf.bas.cnt.model.BCntMprotBaseInfo;
import com.huateng.scf.bas.cnt.service.IBCntDebtInfoService;
import com.huateng.scf.bas.cnt.service.IBCntMprotBaseInfoService;
import com.huateng.scf.bas.common.constant.ScfBasConstant;
import com.huateng.scf.bas.common.service.IScfWorkFlowService;
import com.huateng.scf.bas.common.startup.ScfBaseData;
import com.huateng.scf.bas.common.startup.ScfMessageUtil;
import com.huateng.scf.bas.common.util.ScfDateUtil;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.common.util.UUIDGeneratorUtil;
import com.huateng.scf.bas.crm.model.BCrmBaseInfo;
import com.huateng.scf.bas.crm.service.IBCrmBaseInfoService;
import com.huateng.scf.bas.crr.model.BCrrGntyCon;
import com.huateng.scf.bas.crr.model.BCrrLnCon;
import com.huateng.scf.bas.crr.service.IBCrrGntyConService;
import com.huateng.scf.bas.crr.service.IBCrrLnConService;
import com.huateng.scf.bas.lan.model.LoanApplyVO;
import com.huateng.scf.bas.mrn.dao.ext.ExtBMrnDAO;
import com.huateng.scf.bas.mrn.dao.model.BMrnAcctBussInfo;
import com.huateng.scf.bas.mrn.vo.CashEqualValueContractVO;
import com.huateng.scf.bas.mrn.vo.OldApplyVO;
import com.huateng.scf.bas.pbc.constant.BPbcErrorConstant;
import com.huateng.scf.bas.pbc.dao.IBPbcAppliBaseInfoDAO;
import com.huateng.scf.bas.pbc.dao.model.BPbcAppliBaseInfoExample;
import com.huateng.scf.bas.pbc.dao.model.BPbcAppliBaseInfoExample.Criteria;
import com.huateng.scf.bas.pbc.model.BPbcAppliBaseInfo;
import com.huateng.scf.bas.pbc.model.BPbcAppliBaseInfoVO;
import com.huateng.scf.bas.pbc.model.BPbcAppliMtgInfo;
import com.huateng.scf.bas.pbc.model.BPbcMtgBaseInfo;
import com.huateng.scf.bas.pbc.service.IBPbcAppliBaseInfoService;
import com.huateng.scf.bas.pbc.service.IBPbcAppliMtgInfoService;
import com.huateng.scf.bas.pbc.service.IBPbcMtgBaseInfoService;
import com.huateng.scf.bas.pbc.service.IBPbcMtgClassService;
import com.huateng.scf.bas.pbc.vo.MortgageApplyVO;
import com.huateng.scf.bas.prd.dao.IBPrdInfoDAO;
import com.huateng.scf.bas.prd.model.BPrdInfo;
import com.huateng.scf.bas.prd.model.BPrdWkflowCop;
import com.huateng.scf.bas.prd.service.IBPrdInfoService;
import com.huateng.scf.bas.prd.service.IBPrdWkflowCopService;
import com.huateng.scf.bas.sys.constant.WorkflowConstant;
import com.huateng.scf.bas.sys.model.BSysUploadFileVO;
import com.huateng.scf.bas.sys.service.IBSysSerialNoService;
import com.huateng.scf.bas.sys.service.IBSysUploadFileService;
import com.huateng.scf.nrec.bcp.model.BCntBcpInfoVO;
import com.huateng.scf.nrec.bcp.service.IBCntBcpInfoService;
import com.huateng.scf.nrec.bcp.service.INRBcpAppliBussDtlService;
import com.huateng.scf.nrec.bcp.service.INRBcpAppliBussInfoService;
import com.huateng.scf.nrec.bcp.service.IRBcpDebtInfoService;
import com.huateng.scf.rec.bcp.constant.RBcpErrorConstant;
import com.huateng.scf.rec.bcp.model.DebtBussInfoVO;
import com.huateng.scf.sto.nwr.model.SBcpAppliWarehouseVO;
import com.huateng.scf.sto.nwr.vo.BillNormalAppVO;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * <p>
 * </p>
 *
 * @author shangxiujuan
 * @date 2016年12月14日下午5:25:31
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 *            <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * shangxiujuan		2016年12月14日下午5:25:31	     新增
 *
 *            </pre>
 */
@ScubeService
@Service("BPbcAppliBaseInfoServiceImpl")
public class BPbcAppliBaseInfoServiceImpl implements IBPbcAppliBaseInfoService {

	private final Logger log = LoggerFactory.getLogger(getClass());

	@Resource(name = "orgService")
	OrgService orgService;

	@Resource(name = "userService")
	UserService userService;

	@Resource(name = "BPrdInfoDAO")
	IBPrdInfoDAO bPrdInfoDAO;

	@Resource(name = "BCrmBaseInfoServiceImpl")
	IBCrmBaseInfoService bCrmBaseInfoService;

	@Resource(name = "RBcpDebtInfoServiceImpl")
	IRBcpDebtInfoService rBcpDebtInfoService;

	@Resource(name = "BPbcAppliBaseInfoDAO")
	IBPbcAppliBaseInfoDAO bPbcAppliBaseInfoDAO;

	@Resource(name = "BCntDebtInfoServiceImpl")
	IBCntDebtInfoService bCntDebtInfoService;

	@Resource(name = "BPrdWkflowCopServiceImpl")
	IBPrdWkflowCopService bPrdWkflowCopService;

	@Resource(name = "BPbcMtgClassServiceImpl")
	IBPbcMtgClassService bPbcMtgClassService;

	@Resource(name = "BSysSerialNoServiceImpl")
	IBSysSerialNoService bSysSerialNoService;// 流水号生成服务

	@Resource(name = "BCrrLnConServiceImpl")
	IBCrrLnConService bcrrlnconservice;// 流水号生成服务

	@Resource(name = "ExtBMrnDAO")
	ExtBMrnDAO extbmrndao;

	@Resource(name = "BPrdInfoServiceImpl")
	IBPrdInfoService bPrdInfoService;
	// 担保合同信息
	@Resource(name = "BCrrGntyConServiceImpl")
	IBCrrGntyConService bCrrGntyConService;

	// 担保合同信息
	@Resource(name = "BCntMprotBaseInfoServiceImpl")
	IBCntMprotBaseInfoService bCntMprotBaseInfoService;

	// 担保合同信息
	@Resource(name = "BPbcAppliMtgInfoServiceImpl")
	IBPbcAppliMtgInfoService bPbcAppliMtgInfoService;

	// 流程发起
	@Resource(name = "processService")
	IProcessService iProcessService;

	@Resource(name = IScfWorkFlowService.BEAN_ID) // 供应链工作流
	IScfWorkFlowService scfWorkFlowService;

	@Resource(name = "BPbcMtgBaseInfoServiceImpl")
	IBPbcMtgBaseInfoService bPbcMtgBaseInfoService;


	@Resource(name = "NRBcpAppliBussInfoServiceImpl")
	INRBcpAppliBussInfoService nRBcpAppliBussInfoService;

	@Resource(name = "NRBcpAppliBussDtlServiceImpl")
	INRBcpAppliBussDtlService nRBcpAppliBussDtlService;

	@Resource(name = "BCntBcpInfoServiceImpl")
	IBCntBcpInfoService bCntBcpInfoService;

	@Autowired
	ScubeUserService scubeUserService;

	@Resource(name = "BSysUploadFileServiceImpl")
	IBSysUploadFileService bsysuploadfileservice;
	
	@Resource(name = "BPbcMtgBaseInfoServiceImpl")
	IBPbcMtgBaseInfoService iBPbcMtgBaseInfoService;

	@Transactional
	@Override
	public void addBPbcAppliBaseInfo(BPbcAppliBaseInfo bPbcAppliBaseInfo) throws ScubeBizException {
		// ScfCommonUtil.setCommonField(bPbcAppliBaseInfo);//设置公共字段 add by
		// huangshuidan 2016-11-11
		// 获取当前用户
		UserInfo user = ContextHolder.getUserInfo();
		String tlrNo = user.getTlrNo();
		String brCode = user.getBrNo();
		// 设置公共字段
		bPbcAppliBaseInfo.setAppBrcode(brCode);// 登记机构
		bPbcAppliBaseInfo.setApprover(tlrNo);
		bPbcAppliBaseInfo.setApproveTime(new Date());
		bPbcAppliBaseInfo.setAppDate(ScfDateUtil.getStringDate(new Date())); // 登记时间
		bPbcAppliBaseInfo.setAppTlrcd(tlrNo);// 登记人

		bPbcAppliBaseInfo.setStartTime(new Date()); // 流程启动时间
		if (StringUtil.isEmpty(bPbcAppliBaseInfo.getStratDate())) {
			bPbcAppliBaseInfo.setStratDate(ScfDateUtil.getStringDate(new Date())); // 流程启动日期
		}
		bPbcAppliBaseInfo.setStartBrcode(brCode); // 流程发起机构
		bPbcAppliBaseInfo.setStartTlrcd(tlrNo); // 流程启动人
		com.huateng.scf.bas.pbc.dao.model.BPbcAppliBaseInfo bPbcAppliBaseInfodal = new com.huateng.scf.bas.pbc.dao.model.BPbcAppliBaseInfo();
		try {
			BeanUtils.copyProperties(bPbcAppliBaseInfo, bPbcAppliBaseInfodal);
		} catch (BeansException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error("业务申请基本信息转换异常！");
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BPbcErrorConstant.SCF_BAS_PBC_10000), BPbcErrorConstant.SCF_BAS_PBC_10000);
		}
		try {
			// TODO
			bPbcAppliBaseInfoDAO.insertSelective(bPbcAppliBaseInfodal);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("业务申请基本信息插入异常！" + e.getMessage());
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BPbcErrorConstant.SCF_BAS_PBC_10001), BPbcErrorConstant.SCF_BAS_PBC_10001);
		}
	}

	@Transactional
	@Override
	public int updateBPbcAppliBaseInfo(BPbcAppliBaseInfo bPbcAppliBaseInfo) throws ScubeBizException {
		com.huateng.scf.bas.pbc.dao.model.BPbcAppliBaseInfo bPbcAppliBaseInfodal = new com.huateng.scf.bas.pbc.dao.model.BPbcAppliBaseInfo();
		try {
			BeanUtils.copyProperties(bPbcAppliBaseInfo, bPbcAppliBaseInfodal);
		} catch (BeansException e) {
			e.printStackTrace();
			log.error("业务申请基本信息转换异常！" + e.getMessage());
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BPbcErrorConstant.SCF_BAS_PBC_10000), BPbcErrorConstant.SCF_BAS_PBC_10000);
		}
		int i = 0;
		try {
			i = bPbcAppliBaseInfoDAO.updateByPrimaryKeySelective(bPbcAppliBaseInfodal);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("业务申请基本信息更新异常！" + e.getMessage());
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BPbcErrorConstant.SCF_BAS_PBC_10002), BPbcErrorConstant.SCF_BAS_PBC_10002);
		}
		return i;
	}

	@Transactional
	@Override
	public int deleteBPbcAppliBaseInfo(String key) throws ScubeBizException {
		// TODO Auto-generated method stub
		int i = 0;
		try {
			i = bPbcAppliBaseInfoDAO.deleteByPrimaryKey(key);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error("业务申请基本信息删除异常！");
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BPbcErrorConstant.SCF_BAS_PBC_10003), BPbcErrorConstant.SCF_BAS_PBC_10003);
		}
		return i;
	}

	@Override
	@Transactional
	public List<String> batchDeleteBPbcAppliBaseInfoAndRelated(List<BPbcAppliBaseInfo> list) throws ScubeBizException {
		if (list == null || list.size() == 0) {
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BPbcErrorConstant.SCF_BAS_PBC_10003), BPbcErrorConstant.SCF_BAS_PBC_10003);
		}
		/**
		 * mengjiajia picIds用于存放文件ID start
		 */
		List<String> picIds = new ArrayList<String>();
		/**
		 * mengjiajia picIds用于存放文件ID end
		 */

		for (BPbcAppliBaseInfo bPbcAppliBaseInfo : list) {
			if (StringUtils.isEmpty(bPbcAppliBaseInfo.getAppno())) {
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BPbcErrorConstant.SCF_BAS_PBC_10003),
						BPbcErrorConstant.SCF_BAS_PBC_10003);
			} else {
				/**
				 * mengjiajia删除文件信息，并将文件ID放入集合picIds中 start
				 */
				List<BSysUploadFileVO> fileList = bsysuploadfileservice.findBSysUploadFileByAppno(bPbcAppliBaseInfo.getAppno());
				if (fileList != null && fileList.size() > 0) {
					for (BSysUploadFileVO fileVO : fileList) {
						picIds.add(fileVO.getId());
						bsysuploadfileservice.deleteBSysUploadById(fileVO.getId());
					}
				}
				/**
				 * mengjiajia删除文件信息，并将文件ID放入集合picIds中 end
				 */

				bPbcAppliBaseInfoDAO.deleteByPrimaryKey(bPbcAppliBaseInfo.getAppno());
				nRBcpAppliBussInfoService.deleteByAppno(bPbcAppliBaseInfo.getAppno());
				// 删除原有申请明细信息，如果有对应的单据信息，则解锁。
				nRBcpAppliBussDtlService.deleteRBcpAppliBussDtlAndReleaseDebt(bPbcAppliBaseInfo.getAppno());
			}
		}
		return picIds;
	}

	@Transactional
	@Override
	public BPbcAppliBaseInfo findBPbcAppliBaseInfoByKey(String key) throws ScubeBizException {
		BPbcAppliBaseInfo bPbcAppliBaseInfo = new BPbcAppliBaseInfo();
		com.huateng.scf.bas.pbc.dao.model.BPbcAppliBaseInfo bPbcAppliBaseInfodal = new com.huateng.scf.bas.pbc.dao.model.BPbcAppliBaseInfo();
		bPbcAppliBaseInfodal = bPbcAppliBaseInfoDAO.selectByPrimaryKey(key);
		if (bPbcAppliBaseInfodal != null) {
			BPrdWkflowCop bPrdWkflowCop = new BPrdWkflowCop();
			bPrdWkflowCop.setFlowCopId(bPbcAppliBaseInfodal.getProcessTemplateName());
			BPrdWkflowCop bPrdWkflow = bPrdWkflowCopService.queryBPrdWkflowCopByBPrd(bPrdWkflowCop);
			if (bPrdWkflow != null) {
				bPbcAppliBaseInfodal.setExt2(bPrdWkflow.getFlowName());
			}
			// 流程信息
			// String processName = null == bPrdWkflow ? "" :
			// bPrdWkflow.getFlowName();

			try {
				if (bPbcAppliBaseInfodal != null) {
					BeanUtils.copyProperties(bPbcAppliBaseInfodal, bPbcAppliBaseInfo);
				}
				bPbcAppliBaseInfo.setAppTlrcd(ContextHolder.getUserInfo().getTlrNo());
				bPbcAppliBaseInfo.setApproveBrcode(ContextHolder.getOrgInfo().getBrNo());
			} catch (BeansException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				log.error("业务申请基本信息转换异常！");
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BPbcErrorConstant.SCF_BAS_PBC_10000),
						BPbcErrorConstant.SCF_BAS_PBC_10000);
			}
			return bPbcAppliBaseInfo;
		} else {
			return null;
		}

	}

	// IRBcpAppliBussInfoService rBcpAppliBussInfoService;
	@Override
	public String saveBillsVendorAppliBaseInfo(DebtBussInfoVO debtVO, String businessnoType, String workApplyType) throws ScubeBizException {
		// 保理合同基本信息中查询相应的记录
		BCntDebtInfo tblContBaseInfo = bCntDebtInfoService.findBCntDebtInfoByKey(debtVO.getMastContno());
		com.huateng.scf.bas.pbc.dao.model.BPbcAppliBaseInfo bPbcAppliBaseInfo = new com.huateng.scf.bas.pbc.dao.model.BPbcAppliBaseInfo();
		if (StringUtils.isEmpty(debtVO.getAppno())) {
			UserInfo globalInfo = ContextHolder.getUserInfo();
			bPbcAppliBaseInfo.setBusinessnoType(businessnoType);
			bPbcAppliBaseInfo.setCustcd(debtVO.getCustcdSaller());
			bPbcAppliBaseInfo.setMoniCustcd(debtVO.getCustcdBuyer());
			bPbcAppliBaseInfo.setCurcd(tblContBaseInfo.getCurcd()); // 币种
			bPbcAppliBaseInfo.setProcessTemplateName(workApplyType); // 流程名称
			bPbcAppliBaseInfo.setAppliType(businessnoType);
			bPbcAppliBaseInfo.setBusinessnoType(ScfBasConstant.BUSINESSNO_TYPE_CONTNO);
			bPbcAppliBaseInfo.setAppliStatus(WorkflowConstant.APPLI_STATUS_UNSUBMIT); // 申请状态:未提交（默认）
			bPbcAppliBaseInfo.setAppliStatusDtl(WorkflowConstant.APPLI_STATUS_DTL_WRITING); // 申请状态明细:未提交（默认）
			bPbcAppliBaseInfo.setAppBrcode(globalInfo.getBrNo()); // 登记机构
			bPbcAppliBaseInfo.setApprover(globalInfo.getTlrNo());
			bPbcAppliBaseInfo.setApproveTime(new Date());
			bPbcAppliBaseInfo.setAppDate(ScfDateUtil.formatDate(new Date())); // 登记时间
			bPbcAppliBaseInfo.setStartTime(new Date());
			bPbcAppliBaseInfo.setStratDate(ScfDateUtil.formatDate(new Date()));
			bPbcAppliBaseInfo.setStartBrcode(globalInfo.getBrNo());
			bPbcAppliBaseInfo.setStartTlrcd(globalInfo.getTlrNo());
			bPbcAppliBaseInfo.setAppTlrcd(globalInfo.getTlrNo()); // 登记人
			// bPbcAppliBaseInfo.setSupplyChainPdId(debtVO.getProductId()); //
			// 产品ID
			bPbcAppliBaseInfo.setSupplyChainPdId(debtVO.getBussType()); // 业务品种
			bPbcAppliBaseInfo.setMemo(debtVO.getMemo());
			bPbcAppliBaseInfo.setMastContno(tblContBaseInfo.getDebtContno()); // 主合同号
			bPbcAppliBaseInfo.setProtocolNo(debtVO.getLoanWay()); // 出账方式
			bPbcAppliBaseInfo.setBusinessno(debtVO.getBusinessNo());
			bPbcAppliBaseInfo.setAmt(debtVO.getAmount());
			String appno = "SJDJ" + ScfDateUtil.formatDate(new Date()) + "01" + UUIDGeneratorUtil.generate(bPbcAppliBaseInfo).substring(26);
			bPbcAppliBaseInfo.setAppno(appno);
			/*
			 * if (StringUtils.isEmpty(bPbcAppliBaseInfo.getAppno())) {
			 * bPbcAppliBaseInfo.setAppno(String.valueOf(this.getSeqPK(
			 * ScfBasConstant.VALUE_NO_SEQ_TBL_ID,
			 * ScfBasConstant.VALUE_INDEX_APPLIBASEINFO_ID))); }
			 */
			if (StringUtils.isEmpty(bPbcAppliBaseInfo.getBusinessno())) {
				bPbcAppliBaseInfo.setBusinessno(bPbcAppliBaseInfo.getAppno());
			}
			if (StringUtils.isEmpty(bPbcAppliBaseInfo.getChannelFlag())) {
				bPbcAppliBaseInfo.setChannelFlag(ScfBasConstant.CHANNEL_FLAG_SCF);// 默认渠道标识为供应链
			}
			if (StringUtils.isEmpty(bPbcAppliBaseInfo.getIsFlowEnd())) {
				bPbcAppliBaseInfo.setIsFlowEnd(ScfBasConstant.FLAG_OFF);// 默认流程未结束
			}
			// 业务申请基本信息表插入一条数据
			bPbcAppliBaseInfoDAO.insert(bPbcAppliBaseInfo);

		} else {// 更新
			String appNo = debtVO.getAppno();
			bPbcAppliBaseInfo = (com.huateng.scf.bas.pbc.dao.model.BPbcAppliBaseInfo) bPbcAppliBaseInfoDAO.selectByPrimaryKey(appNo);
			bPbcAppliBaseInfo.setAmt(debtVO.getTotalAmount());
			bPbcAppliBaseInfoDAO.updateByPrimaryKey(bPbcAppliBaseInfo);
		}
		return bPbcAppliBaseInfo.getAppno();
	}

	@Override
	public BCntDebtInfoVO queuyBCntDebtInfoVOByAppno(String appno, String buyerCustcd) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("appno", appno);
		map.put("buyerCustcd", buyerCustcd);
		com.huateng.scf.bas.cnt.dao.model.BCntDebtInfoVO bCntDebtInfoVODal = bPbcAppliBaseInfoDAO.selectBCntDebtInfoVOByMap(map);
		BCntDebtInfoVO bCntDebtInfoVO = new BCntDebtInfoVO();
		BeanUtils.copyProperties(bCntDebtInfoVODal, bCntDebtInfoVO);
		bCntDebtInfoVO.setDisputeAmount(bCntDebtInfoVODal.getAmount());
		bCntDebtInfoVO.setDisputeCount(bCntDebtInfoVODal.getDebtNum());
		// bCntDebtInfoVO.setDisputeDate(bCntDebtInfoVODal.getInsertDate());
		return bCntDebtInfoVO;
	}

	@Override
	public Page queryBPbcAppliBaseInfoList(int pageNo, int pageSize, BPbcAppliBaseInfo value) {
		Page p = new Page(pageSize, pageNo, 0);
		BPbcAppliBaseInfoExample example = new BPbcAppliBaseInfoExample();
		example.setOrderByClause("APP_DATE  desc");
		Criteria cri = example.createCriteria();
		if (value != null) {
			if (value.getAppliType() != null && value.getAppliType().length() > 0) {
				cri.andAppliTypeEqualTo(value.getAppliType());

			}
			if (value.getAppno() != null && value.getAppno().length() > 0) {
				cri.andAppnoLike("%" + value.getAppno() + "%");

			}
			// 增加产品ID查询条件 add by huangshuidan 2017-01-16
			if (StringUtil.isStrNotEmpty(value.getSupplyChainPdId())) {
				cri.andSupplyChainPdIdEqualTo(value.getSupplyChainPdId());
			}
		}

		int total = bPbcAppliBaseInfoDAO.countByExample(example);
		p.setRecords(bPbcAppliBaseInfoDAO.selectByPage(example, p));

		log.debug("totalPage=" + p.getTotalPage());
		log.debug("totalRecord=" + p.getTotalRecord());
		log.debug("current=" + p.getCurrent());

		p.setTotalRecord(total);
		return p;
	}

	/**
	 * @Description: 根据业务合同号查询流程中的借据敞口余额汇总
	 * @author xiaolong.xiong
	 * @Created 2013-9-27下午6:00:54
	 * @param businessNo
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public List getFlowRiskAmtByBusinessNo(String businessNo) {
		HashMap<String, String> omap = new HashMap<String, String>();
		omap.put("businessNo", businessNo);
		omap.put("appliStatusDtl", WorkflowConstant.APPLI_STATUS_DTL_WAITCMS);
		return bPbcAppliBaseInfoDAO.getFlowRiskAmtByBusinessNo(omap);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.huateng.scf.bas.pbc.service.IBPbcAppliBaseInfoService#
	 * findBPbcAppliBaseInfoByLimits(com.huateng.scf.bas.pbc.model.
	 * BPbcAppliBaseInfo)
	 */
	@Override
	public int findBPbcAppliBaseInfoByLimits(BPbcAppliBaseInfo bPbcAppliBaseInfo) throws ScubeBizException {
		if (bPbcAppliBaseInfo == null || bPbcAppliBaseInfo.equals("")) {
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10005), RBcpErrorConstant.SCF_REC_BCP_10005);
		}
		BPbcAppliBaseInfoExample bPbcAppliBaseInfoExample = new BPbcAppliBaseInfoExample();
		Criteria appliBaseCriteria = bPbcAppliBaseInfoExample.createCriteria();
		// 信贷合同号
		if (bPbcAppliBaseInfo.getMastContcode() != null && !"".equals(bPbcAppliBaseInfo.getMastContcode())) {
			appliBaseCriteria.andMastContcodeEqualTo(bPbcAppliBaseInfo.getMastContcode());
		}
		int x = 0;
		try {
			List<com.huateng.scf.bas.pbc.dao.model.BPbcAppliBaseInfo> bPbcAppliBaseInfoList = bPbcAppliBaseInfoDAO
					.selectByExample(bPbcAppliBaseInfoExample);
			if (bPbcAppliBaseInfoList != null && bPbcAppliBaseInfoList.size() > 0) {
				x = bPbcAppliBaseInfoList.size();
			}
		} catch (Exception e) {
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BPbcErrorConstant.SCF_BAS_PBC_10006), BPbcErrorConstant.SCF_BAS_PBC_10006);
		}

		return x;
	}

	/**
	 * 描述：保存现金等价物维护流程发起申请基本信息
	 * 
	 * @param contractnVO
	 * @param businessnoType
	 * @param workApplyType
	 * @return
	 * @throws ScubeBizException
	 * @date 2013-6-24
	 * @author mengjiajia
	 */
	@Override
	public String saveApplyBaseInfo(CashEqualValueContractVO contractVO, String businessnoType, String workApplyType) throws ScubeBizException {
		BPbcAppliBaseInfo tblAppliBaseInfo = null;
		BCrrLnCon bCrrLnCon = bcrrlnconservice.findBCrrLnConByAppId(contractVO.getMastContno());
		if (StringUtil.isEmpty(contractVO.getAppno())) { // 保存新增
			tblAppliBaseInfo = new BPbcAppliBaseInfo();
			String appno = bSysSerialNoService.genSerialNo("CEVDJ_APP_NO");
			tblAppliBaseInfo.setAppno(appno);
			tblAppliBaseInfo.setPledgeMode(""); // 发起方式
			tblAppliBaseInfo.setCustcd(contractVO.getCustcd()); // 客户号
			tblAppliBaseInfo.setCurcd(contractVO.getCurcd()); // 币种
			tblAppliBaseInfo.setProcessTemplateName(workApplyType); // 流程名称
			tblAppliBaseInfo.setAppliType(businessnoType); // 申请类型
			tblAppliBaseInfo.setBusinessnoType(ScfBasConstant.BUSINESSNO_TYPE_SLAVECONTNO);// 从合同号类型
			tblAppliBaseInfo.setProtocolNo(contractVO.getProtocolNo()); // 质押监管协议号
			tblAppliBaseInfo.setAppliStatus(ScfBasConstant.APPLI_STATUS_UNSUBMIT); // 申请状态:未提交（默认）
			tblAppliBaseInfo.setAppliStatusDtl(WorkflowConstant.APPLI_STATUS_DTL_WRITING); // 申请状态明细:未提交（默认）
			// tblAppliBaseInfo.setAppBrcode(bctlVO.getBrNo()); // 登记机构
			// tblAppliBaseInfo.setAppTlrcd(userinfo.getTlrNo()); // 登记人
			// tblAppliBaseInfo.setStartTime(new Date());
			// tblAppliBaseInfo.setStratDate(ScfDateUtil.formatDate(new
			// Date()));
			// tblAppliBaseInfo.setStartBrcode(bctlVO.getBrNo());
			// tblAppliBaseInfo.setStartTlrcd(userinfo.getTlrNo());
			tblAppliBaseInfo.setSupplyChainPdId(bCrrLnCon.getVidBusiTyp()); // 产品ID
			tblAppliBaseInfo.setMastContno(contractVO.getMastContno()); // 主合同号
			tblAppliBaseInfo.setBusinessno(bCrrLnCon.getVidNo());
			tblAppliBaseInfo.setMemo(contractVO.getDescription());
			// if(StringUtil.isEmpty(tblAppliBaseInfo.getBusinessno())){
			// tblAppliBaseInfo.setBusinessno(tblAppliBaseInfo.getAppno());
			// }
			this.addBPbcAppliBaseInfo(tblAppliBaseInfo);
		} else {// 更新
			tblAppliBaseInfo = this.findBPbcAppliBaseInfoByKey(contractVO.getAppno());
			if ("现金等价物维护提交审批".equals(contractVO.getDescription())) {
				tblAppliBaseInfo.setAppliStatus(ScfBasConstant.APPLI_STATUS_SUBMITUNAPPROVE); // 申请状态:已提交(未审批)
				tblAppliBaseInfo.setAppliStatusDtl(WorkflowConstant.APPLI_STATUS_DTL_APPROVING);
			} else if ("现金等价物维护审批同意".equals(contractVO.getDescription())) {
				tblAppliBaseInfo.setAppliStatus(ScfBasConstant.APPLI_STATUS_APPROVED); // 申请状态:已通过(审批通过)
				tblAppliBaseInfo.setAppliStatusDtl(WorkflowConstant.APPLI_STATUS_DTL_APPROVED);
			} else if ("现金等价物维护审批退回".equals(contractVO.getDescription())) {
				tblAppliBaseInfo.setAppliStatus(ScfBasConstant.APPLI_STATUS_GOBACK); // 申请状态:已退回(审批被退回)
				tblAppliBaseInfo.setAppliStatusDtl(WorkflowConstant.APPLI_STATUS_DTL_GOBACK);
			}
			this.updateBPbcAppliBaseInfo(tblAppliBaseInfo);
		}
		return tblAppliBaseInfo.getAppno();
	}

	/**
	 * DESCRIPTION:现金等价物解押验证，已提交的放款合同不允许再次提交,放款合同下未绑定现金等价物，无法发起流程
	 * 
	 * @author mengjiajia
	 * @date 2012-5-17 checkAppliBaseInfo 方法
	 * @param applyVO
	 * @throws ScubeBizException
	 */
	@Override
	public void checkAppliBaseInfo(OldApplyVO applyVO) throws ScubeBizException {
		String mastContNo = applyVO.getMastContno();
		BPbcAppliBaseInfoExample example = new BPbcAppliBaseInfoExample();
		BPbcAppliBaseInfoExample.Criteria cri = example.createCriteria();
		cri.andMastContnoEqualTo(mastContNo);
		List<String> appliStatus = new ArrayList<String>();
		appliStatus.add("00");
		appliStatus.add("01");
		cri.andAppliStatusIn(appliStatus);
		List<com.huateng.scf.bas.pbc.dao.model.BPbcAppliBaseInfo> list = bPbcAppliBaseInfoDAO.selectByExample(example);
		if (list != null && list.size() > 0) {
			// throw new
			// ScubeBizException("该放款合同已提交审批流程，无法再次提交",RBcpErrorConstant.RECORD_HAS_EXIST);
		}
		HashMap<String, Object> omap = new HashMap<String, Object>();
		omap.put("mastContno", mastContNo);
		omap.put("confirmStatus1", "03");
		omap.put("confirmStatus2", "04");
		omap.put("bailType", "03");
		List<BMrnAcctBussInfo> result = extbmrndao.queryAcctBussInfoList(omap);
		if (result == null || result.size() < 1) {
			throw new ScubeBizException("该主合同下未绑定现金等价物，无法发起流程", RBcpErrorConstant.RECORD_NOT_EXIST);
		}
	}

	/**
	 * DESCRIPTION:保存现金等价物解押流程发起申请基本信息
	 * 
	 * @author mengjiajia
	 * @date 2017-02-20 saveMdApplyBaseInfoDismortgage 方法
	 * @param applyVO
	 * @param businessnoType
	 * @param workApplyType
	 * @return
	 * @throws ScubeBizException
	 */
	@Override
	public String saveApplyBaseInfo(OldApplyVO applyVO, String businessnoType, String workApplyType) throws ScubeBizException {
		BPbcAppliBaseInfo tblAppliBaseInfo = null;
		if (StringUtil.isEmpty(applyVO.getAppno())) {// 保存新增
			tblAppliBaseInfo = new BPbcAppliBaseInfo();
			String appno = bSysSerialNoService.genSerialNo("CEVJY_APP_NO");
			tblAppliBaseInfo.setAppno(appno);
			tblAppliBaseInfo.setPledgeMode(applyVO.getPledgeMode()); // 发起方式
			tblAppliBaseInfo.setCustcd(applyVO.getCustcd()); // 客户号
			tblAppliBaseInfo.setCurcd(applyVO.getCurcd()); // 币种
			tblAppliBaseInfo.setProcessTemplateName(workApplyType); // 流程名称
			tblAppliBaseInfo.setAppliType(businessnoType); // 申请类型
			tblAppliBaseInfo.setBusinessnoType(ScfBasConstant.BUSINESSNO_TYPE_SLAVECONTNO);// 从合同号类型
			tblAppliBaseInfo.setProtocolNo(applyVO.getProtocolNo()); // 质押监管协议号
			tblAppliBaseInfo.setAppliStatus(ScfBasConstant.APPLI_STATUS_UNSUBMIT); // 申请状态:未提交（默认）
			tblAppliBaseInfo.setAppliStatusDtl(WorkflowConstant.APPLI_STATUS_DTL_UNSUBMIT); // 申请状态明细:未提交（默认）
			// tblAppliBaseInfo.setAppBrcode(globalInfo.getBrcode()); // 登记机构
			// tblAppliBaseInfo.setAppTlrcd(globalInfo.getTlrno()); // 登记人
			// tblAppliBaseInfo.setStartTime(DateUtil.getCurrentDate());
			// tblAppliBaseInfo.setStratDate(DateUtil.getCurrentDate());
			// tblAppliBaseInfo.setStartBrcode(globalInfo.getBrcode());
			// tblAppliBaseInfo.setStartTlrcd(globalInfo.getTlrno());
			tblAppliBaseInfo.setSupplyChainPdId(applyVO.getProductId()); // 产品ID
			tblAppliBaseInfo.setMastContno(applyVO.getMastContno()); // 主合同号
			tblAppliBaseInfo.setMemo(applyVO.getDescription()); // 描述

			if (StringUtil.isEmpty(tblAppliBaseInfo.getBusinessno())) {
				tblAppliBaseInfo.setBusinessno(tblAppliBaseInfo.getAppno());
			}

			if (StringUtil.isEmpty(tblAppliBaseInfo.getChannelFlag())) {
				tblAppliBaseInfo.setChannelFlag(ScfBasConstant.CHANNEL_FLAG_SCF);// 默认渠道标识为供应链
			}
			if (StringUtil.isEmpty(tblAppliBaseInfo.getIsFlowEnd())) {
				tblAppliBaseInfo.setIsFlowEnd(ScfBasConstant.FLAG_OFF);// 默认流程未结束
			}

			this.addBPbcAppliBaseInfo(tblAppliBaseInfo);
		} else {// 更新
			tblAppliBaseInfo = this.findBPbcAppliBaseInfoByKey(applyVO.getAppno());
			tblAppliBaseInfo.setMemo(applyVO.getDescription());
			this.updateBPbcAppliBaseInfo(tblAppliBaseInfo);
		}
		return tblAppliBaseInfo.getAppno();
	}

	/**
	 * 保存时取SEQ
	 *
	 * @author hui.liu
	 * @date 2011-07-25 save 方法
	 * @throws HibernateException
	 */
	@Override
	public String save(BPbcAppliBaseInfo tblAppliBaseInfo) throws ScubeBizException {
		if (StringUtil.isEmpty(tblAppliBaseInfo.getAppno())) {
			String appno = bSysSerialNoService.genSerialNo("MAXI_APP_NO");
			tblAppliBaseInfo.setAppno(appno);
		}
		if (StringUtil.isEmpty(tblAppliBaseInfo.getBusinessno())) {
			tblAppliBaseInfo.setBusinessno(tblAppliBaseInfo.getAppno());
		}
		if (StringUtil.isEmpty(tblAppliBaseInfo.getChannelFlag())) {
			tblAppliBaseInfo.setChannelFlag(ScfBasConstant.CHANNEL_FLAG_SCF);// 默认渠道标识为供应链
		}
		if (StringUtil.isEmpty(tblAppliBaseInfo.getIsFlowEnd())) {
			tblAppliBaseInfo.setIsFlowEnd(ScfBasConstant.FLAG_OFF);// 默认流程未结束
		}
		this.addBPbcAppliBaseInfo(tblAppliBaseInfo);
		return tblAppliBaseInfo.getAppno();
	}

	/**
	 * 放款补录添加业务申请基本信息表
	 */
	@Transactional
	@Override
	public String saveLoanAppBasicInfo(LoanApplyVO loanApplyVO) throws ScubeBizException {
		// TODO Auto-generated method stub
		// 查询信贷合同
		BCrrLnCon bCrrLnCon = bcrrlnconservice.findBCrrLnConByAppId(loanApplyVO.getMastContcode());
		BPbcAppliBaseInfo tblAppliBaseInfo = null;
		// 更新
		tblAppliBaseInfo = this.findBPbcAppliBaseInfoByKey(loanApplyVO.getAppno());

		// 从信贷过来的数据，有可能下列为空，需要补下。
		tblAppliBaseInfo.setCustcd(bCrrLnCon.getCustId()); // 客户号
		tblAppliBaseInfo.setCurcd(bCrrLnCon.getCurcd()); // 币种
		// tblAppliBaseInfo.setSupplyChainPdId(tblContBaseInfo.getSupplyChainPdId());
		// // 产品ID
		tblAppliBaseInfo.setMastContno(bCrrLnCon.getAppId()); // 主合同号
		tblAppliBaseInfo.setProtocolNo(bCrrLnCon.getVidNo()); // 质押监管协议号
		// 若为空，需要从担保合同中获取
		String supplyChainPdId = tblAppliBaseInfo.getSupplyChainPdId();
		BPrdInfo bPrdInfo = bPrdInfoService.findBPrdInfoObjectByKey(supplyChainPdId);
		String parentId = ""; // 父产品ID
		if (bPrdInfo == null) {
			log.error("产品不存在");
			throw new ScubeBizException("产品不存在!");
		}
		parentId = bPrdInfo.getParentId();
		if (StringUtil.isEmpty(tblAppliBaseInfo.getProtocolNo()) || StringUtil.isEmpty(tblAppliBaseInfo.getBusinessno())) {
			// TODO
			if (ScfBasConstant.PRODUCT_TYPE_CAR_PLEDGE.equals(parentId) || ScfBasConstant.PRODUCT_TYPE_CHATTLE.equals(parentId)) {
				BCrrGntyCon bCrrGntyCon = bCrrGntyConService.findBCrrGntyConByConId(bCrrLnCon.getVidNo());
				tblAppliBaseInfo.setBusinessnoType(ScfBasConstant.BUSINESSNO_TYPE_SLAVECONTNO);// 从合同号类型
				tblAppliBaseInfo.setBusinessno(bCrrGntyCon.getConId()); // 从合同号
				tblAppliBaseInfo.setProtocolNo(bCrrGntyCon.getPrtclNo()); // 监管协议号
				tblAppliBaseInfo.setSlaveContno(bCrrGntyCon.getConId()); // 担保合同号
			}

			if (ScfBasConstant.PRODUCT_TYPE_WAREHOUSE.equals(parentId)) {
				// 存放先票后货协议号
				// TblMutiProtBaseInfoDAO tblMutiProtBaseInfoDAO =
				// DAOUtils.getTblMutiProtBaseInfoDAO();

			}

		}

		tblAppliBaseInfo.setMemo(loanApplyVO.getMemo());
		this.updateBPbcAppliBaseInfo(tblAppliBaseInfo);
		return tblAppliBaseInfo.getAppno();

	}

	/**
	 * 保存或更新业务申请基本信息
	 * 
	 * @param applyVO
	 * @param businessnoType
	 * @param workApplyType
	 * @return
	 * @throws ScubeBizException
	 */
	@Transactional
	@Override
	public String saveOrUpdateAppInfo(FourApplyVO applyVO, String businessnoType, String workApplyType) throws ScubeBizException {
		// TODO Auto-generated method stub
		BCntMprotBaseInfo mutiProtBaseInfo = bCntMprotBaseInfoService.findBCntMprotBaseInfoByKey(applyVO.getProtocolNo());
		BPbcAppliBaseInfo bPbcAppliBaseInfo = null;
		String appno = "";
		if (StringUtil.isEmpty(applyVO.getAppno())) { // 保存新增
			bPbcAppliBaseInfo = new BPbcAppliBaseInfo();
			BeanUtils.copyProperties(applyVO, bPbcAppliBaseInfo); // 拷贝信息
			if (workApplyType.equals(WorkflowConstant.PROCNAME_FOURHOUSEPLEDGEAPPLY)) {// 先票款后货
																						// -出质入库
				appno = bSysSerialNoService.genSerialNo(ScfBasConstant.BUSSNO_TYPE_CZRK_F_APP_NO);
			}
			// 先票款后货 -提货申请(一一对应)
			else if (workApplyType.equals(WorkflowConstant.PROCNAME_ONE2ONEFOURDELIVERYAPPLY)) {
				appno = bSysSerialNoService.genSerialNo(ScfBasConstant.BUSSNO_TYPE_THSQ_F_APP_NO);

			}
			bPbcAppliBaseInfo.setAppno(appno);
			bPbcAppliBaseInfo.setProcessTemplateName(workApplyType); // 流程名称
			bPbcAppliBaseInfo.setAppliType(businessnoType);
			// bPbcAppliBaseInfo.setAppBrcode(globalInfo.getBranchBrcode()); //
			// 登记机构
			// bPbcAppliBaseInfo.setApprover(globalInfo.getTlrno());
			bPbcAppliBaseInfo.setCustcd(applyVO.getCustcd()); // 客户号
			bPbcAppliBaseInfo.setBusinessno(applyVO.getBusinessno()); // 先票/款后货协议号
			bPbcAppliBaseInfo.setSupplyChainPdId(mutiProtBaseInfo.getProductId()); // 产品ID
			bPbcAppliBaseInfo.setOtherProtocolNo(applyVO.getMonitorProtocolNo()); // 监管协议号
			bPbcAppliBaseInfo.setProtocolNo(applyVO.getProtocolNo());
			// bPbcAppliBaseInfo.setApproveTime(DateUtil.getCurrentDate());
			// bPbcAppliBaseInfo.setAppDate(DateUtil.getCurrentDate()); // 登记时间
			// bPbcAppliBaseInfo.setStartTime(DateUtil.getCurrentDate());
			// bPbcAppliBaseInfo.setStratDate(DateUtil.getCurrentDate());
			// bPbcAppliBaseInfo.setStartBrcode(globalInfo.getBrcode());
			// bPbcAppliBaseInfo.setStartTlrcd(globalInfo.getTlrno());
			// bPbcAppliBaseInfo.setAppTlrcd(globalInfo.getTlrno());
			bPbcAppliBaseInfo.setAppliStatus(ScfBasConstant.APPLI_STATUS_UNSUBMIT); // 申请状态:未提交（默认）
			bPbcAppliBaseInfo.setAppliStatusDtl(WorkflowConstant.APPLI_STATUS_DTL_WRITING); // 申请状态明细:未提交（默认）
			bPbcAppliBaseInfo.setAppliStatus(WorkflowConstant.APPLI_STATUS_UNSUBMIT); // 申请状态:未提交（默认）
			bPbcAppliBaseInfo.setEbankAppno(applyVO.getEbankAppno()); // 网银流水号
			bPbcAppliBaseInfo.setChannelFlag(applyVO.getChannelFlag()); // 渠道标识
			// bPbcAppliBaseInfo.setDeliverValue(applyVO.getOkPrice()); //可提货金额
			bPbcAppliBaseInfo.setExt1(applyVO.getDebetNo()); // 借据号
			this.addBPbcAppliBaseInfo(bPbcAppliBaseInfo);
		} else {// 更新
			bPbcAppliBaseInfo = this.findBPbcAppliBaseInfoByKey(applyVO.getAppno());
			bPbcAppliBaseInfo.setAmt(applyVO.getAmt());
			bPbcAppliBaseInfo.setBailAmount(applyVO.getBailAmount());
			// bPbcAppliBaseInfo.setDeliverValue(applyVO.getOkPrice()); //可提货金额
			this.updateBPbcAppliBaseInfo(bPbcAppliBaseInfo);
		}
		return bPbcAppliBaseInfo.getAppno();
	}

	/**
	 * DESCRIPTION:到货出质入库核价信息保存 updatePledgeAppAmt
	 * 
	 * @param appno
	 * @param appAmt
	 * @return
	 * @throws ScubeBizException
	 * @param
	 * @return
	 */
	@Transactional
	@Override
	public BPbcAppliBaseInfo updatePledgeAppAmt(String appno, BigDecimal appAmt) throws ScubeBizException {
		// 更新申请主表金额字段，存放总申请金额
		if (appAmt == null) {
			log.error("申请金额获取失败!");
			throw new ScubeBizException("申请金额获取失败!");
		}
		BPbcAppliBaseInfo appliBaseInfo = this.findBPbcAppliBaseInfoByKey(appno);
		appliBaseInfo.setAmt(appAmt);
		this.updateBPbcAppliBaseInfo(appliBaseInfo);

		return appliBaseInfo;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.huateng.scf.bas.pbc.service.IBPbcAppliBaseInfoService#
	 * getListBySlaveContno(java.lang.String)
	 */
	@Override
	public int getListBySlaveContno(String slaveContno) throws ScubeBizException {
		if (slaveContno == null || "".equals(slaveContno)) {
			return 0;
		}
		int x = 0;
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("slaveContno", slaveContno);
		List<com.huateng.scf.bas.pbc.dao.model.BPbcAppliBaseInfo> listBySlaveContno = bPbcAppliBaseInfoDAO.getListBySlaveContno(map);
		if (listBySlaveContno != null && listBySlaveContno.size() > 0) {
			x = listBySlaveContno.size();
		}
		return x;
	}

	/**
	 * 保存批量调价信息
	 * 
	 */
	@Override
	@Transactional
	public String saveOrUpdateMutilPriceAdjustApplyInfo(BPbcAppliMtgInfo bPbcAppliMtgInfo) throws ScubeBizException {
		// 1.校验数据
		if (bPbcAppliMtgInfo == null) {
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10005), RBcpErrorConstant.SCF_REC_BCP_10005);
		}
		// 三级押品押品代码和名称一致性校验
		com.huateng.scf.bas.pbc.model.BPbcMtgBaseInfoVO bPbcMtgBaseInfoVO = new com.huateng.scf.bas.pbc.model.BPbcMtgBaseInfoVO();
		bPbcMtgBaseInfoVO.setMortgageLevelOne(bPbcAppliMtgInfo.getMortgageLevelOne());
		bPbcMtgBaseInfoVO.setMortgageLevelOneName(bPbcAppliMtgInfo.getMortgageLevelOneNm());
		bPbcMtgBaseInfoVO.setMortgageLevelTwo(bPbcAppliMtgInfo.getMortgageLevelTwo());
		bPbcMtgBaseInfoVO.setMortgageLevelTwoName(bPbcAppliMtgInfo.getMortgageLevelTwoNm());
		bPbcMtgBaseInfoVO.setMortgageLevelThree(bPbcAppliMtgInfo.getMortgageLevelThree());
		bPbcMtgBaseInfoVO.setMortgageLevelThreeName(bPbcAppliMtgInfo.getMortgageLevelThreeNm());
		bPbcMtgClassService.checkInfoForThreeLevelsSelect(bPbcMtgBaseInfoVO);
		// 押品信息是否被锁定，是否有对应押品信息校验
		BPbcMtgBaseInfo bPbcMtgBaseInfo = new BPbcMtgBaseInfo();
		bPbcMtgBaseInfo.setMortgageLevelOne(bPbcAppliMtgInfo.getMortgageLevelOne());
		bPbcMtgBaseInfo.setMortgageLevelTwo(bPbcAppliMtgInfo.getMortgageLevelTwo());
		bPbcMtgBaseInfo.setMortgageLevelThree(bPbcAppliMtgInfo.getMortgageLevelThree());
		bPbcMtgBaseInfo.setSupplyChainPdId(bPbcAppliMtgInfo.getProductId());
		if(!StringUtil.isEmpty(bPbcAppliMtgInfo.getAppno())){
			bPbcMtgBaseInfo.setChannelFlag("Approve");
		}
		
		Page page = iBPbcMtgBaseInfoService.getPriceAdjustSlaveContGetter(1, 99999, bPbcMtgBaseInfo);
		if(page ==null || page.getRecords()==null || page.getRecords().size()==0)
			throw new ScubeBizException("无对应押品信息！");
		
		String appno = "";
		// 2.如果申请号为空,新增
		if (StringUtil.isEmpty(bPbcAppliMtgInfo.getAppno())) {
			String businessnoType = WorkflowConstant.APPLI_TYPE_MULTIPRICEADJUSTAPPLY;
			String workApplyType = "";
			if (bPbcAppliMtgInfo.getProductId().equals(ScfBasConstant.PRODUCT_TYPE_PLSY))// 现货静态
				workApplyType = WorkflowConstant.PROCNAME_MULTIPRICEADJUSTAPPLYXHJT;
			else if (bPbcAppliMtgInfo.getProductId().equals(ScfBasConstant.PRODUCT_TYPE_PLDY))// 现货动态
				workApplyType = WorkflowConstant.PROCNAME_MULTIPRICEADJUSTAPPLYXHDT;
			else if (bPbcAppliMtgInfo.getProductId().equals(ScfBasConstant.PRODUCT_TYPE_XPHH))// 先票款后货
				workApplyType = WorkflowConstant.PROCNAME_MULTIPRICEADJUSTAPPLY;
			String tlrNo = ContextHolder.getUserInfo().getTlrNo();
			String brNo = ContextHolder.getOrgInfo().getBrNo();
			appno = bSysSerialNoService.genSerialNo(ScfBasConstant.VALUE_INDEX_APP_NO);// 6位序列号
			com.huateng.scf.bas.pbc.dao.model.BPbcAppliBaseInfo bPbcAppliBaseInfo = new com.huateng.scf.bas.pbc.dao.model.BPbcAppliBaseInfo();
			bPbcAppliBaseInfo.setAppliType(businessnoType);
			bPbcAppliBaseInfo.setProcessTemplateName(workApplyType);
			bPbcAppliBaseInfo.setAppBrcode(brNo);
			bPbcAppliBaseInfo.setAppTlrcd(tlrNo);
			bPbcAppliBaseInfo.setAppDate(ScfBaseData.getScfGlobalInfoData().getTxnDate());
			bPbcAppliBaseInfo.setStartBrcode(brNo);
			bPbcAppliBaseInfo.setStartTlrcd(tlrNo);
			bPbcAppliBaseInfo.setStratDate(ScfDateUtil.formatDate(new Date()));
			bPbcAppliBaseInfo.setStartTime(new Date());
			bPbcAppliBaseInfo.setAppliStatus(ScfBasConstant.APPLI_STATUS_UNSUBMIT);
			bPbcAppliBaseInfo.setSupplyChainPdId(bPbcAppliMtgInfo.getProductId());
			bPbcAppliBaseInfo.setPledgeMode(ScfBasConstant.PLEDGE_MODE_MUTI);
			bPbcAppliBaseInfo.setAppno(appno);
			bPbcAppliMtgInfo.setAppno(appno);
			bPbcAppliBaseInfo.setChannelFlag(ScfBasConstant.CHANNEL_FLAG_SCF);
			bPbcAppliBaseInfo.setIsFlowEnd(ScfBasConstant.FLAG_OFF);
			bPbcAppliBaseInfo.setBusinessno(appno);

			// 发起工作流
			String processId = "";
			// String modelId = workApplyType;
			String[] aStrings = new String[5];
			aStrings[0] = appno;
			aStrings[1] = "";// 客户号
			aStrings[2] = "";// 对应客户名称
			aStrings[3] = workApplyType;
			aStrings[4] = ContextHolder.getUserInfo().getTlrName();
			try {
				ProcessEntity processEntity = iProcessService.startProcess(workApplyType, "现货质押批量价格调整申请", "Write",
						ContextHolder.getUserInfo().getTlrNo(), appno, aStrings);
				processId = processEntity.getProcessId();
			} catch (Exception e) {// SCF_REC_BCP_10022,发起流程失败
				log.error("" + e);
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10022),
						RBcpErrorConstant.SCF_REC_BCP_10022);
			}
			bPbcAppliBaseInfo.setPiid(processId);
			bPbcAppliBaseInfoDAO.insert(bPbcAppliBaseInfo);
		} else {
			appno = bPbcAppliMtgInfo.getAppno();
		}
		// 3.修改操作
		bPbcAppliMtgInfoService.updateMutiPriceAdjustInfo(bPbcAppliMtgInfo);
		return appno;
	}

	/*
	 * 提交批量调价信息
	 * 
	 *
	 */
	@Override
	@Transactional
	public void submitMutilPriceAdjustApplyInfo(BPbcAppliMtgInfo bPbcAppliMtgInfo) throws ScubeBizException {
		// 1.校验数据
		if (bPbcAppliMtgInfo == null) {
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10005), RBcpErrorConstant.SCF_REC_BCP_10005);
		}
		// 2.保存页面信息
		this.saveOrUpdateMutilPriceAdjustApplyInfo(bPbcAppliMtgInfo);
		// 3.修改申请基本信息(申请状态为已提交)
		/*
		 * com.huateng.scf.bas.pbc.dao.model.BPbcAppliBaseInfo bPbcAppliBaseInfo
		 * =
		 * bPbcAppliBaseInfoDAO.selectByPrimaryKey(bPbcAppliMtgInfo.getAppno());
		 * if (bPbcAppliBaseInfo == null) { throw new
		 * ScubeBizException("提交失败！"); }
		 * bPbcAppliBaseInfo.setAppliStatus(ScfBasConstant.
		 * APPLI_STATUS_SUBMITUNAPPROVE);// 已提交
		 * bPbcAppliBaseInfoDAO.updateByPrimaryKey(bPbcAppliBaseInfo);
		 */
		// 4.流程跳转(申请状态已)
		scfWorkFlowService.takeTaskAndRelated(bPbcAppliMtgInfo.getAppno());
		return;
	}

	@Transactional
	@Override
	public BPbcAppliBaseInfo findBPbcAppliBaseInfoByIfspAppno(String ifspAppno) {
		BPbcAppliBaseInfo bPbcAppliBaseInfo = new BPbcAppliBaseInfo();
		com.huateng.scf.bas.pbc.dao.model.BPbcAppliBaseInfo bPbcAppliBaseInfodal = new com.huateng.scf.bas.pbc.dao.model.BPbcAppliBaseInfo();
		bPbcAppliBaseInfodal = bPbcAppliBaseInfoDAO.selectByIfspAppno(ifspAppno);
		if (bPbcAppliBaseInfodal == null) {
			throw new ScubeBizException("业务流水信息不存在！");
		}
		BeanUtils.copyProperties(bPbcAppliBaseInfodal, bPbcAppliBaseInfo);
		return bPbcAppliBaseInfo;
	}

	/**
	 * 解押申请-维护普通仓单质押 B_PBC_APPLI_BASE_INFO[业务申请基本信息表]
	 * 
	 * @param basicApplyVO
	 * @return
	 * @throws ScubeBizException
	 * @author mengjiajia
	 * @date 2017年5月3日上午11:05:15
	 */
	@Override
	public String addBillNormalReceiptAppInfo(BillNormalAppVO billNormalAppVO) throws ScubeBizException {
		if (StringUtil.isEmpty(billNormalAppVO.getAppno())) { // 申请编号
			String appno = bSysSerialNoService.genSerialNo("FBJY_APP_NO");
			billNormalAppVO.setAppno(appno);
		}
		com.huateng.scf.bas.pbc.dao.model.BPbcAppliBaseInfo tblAppliBaseInfodao = bPbcAppliBaseInfoDAO.selectByPrimaryKey(billNormalAppVO.getAppno());
		BPbcAppliBaseInfo tblAppliBaseInfo = new BPbcAppliBaseInfo();
		SBcpAppliWarehouseVO ware = new SBcpAppliWarehouseVO();
		if (tblAppliBaseInfodao == null) { // 新增
			if (!StringUtil.isEmpty(billNormalAppVO.getMastContno())) {
				BCrrLnCon tblContBaseInfo = bcrrlnconservice.findBCrrLnConByAppId(billNormalAppVO.getMastContno());
				billNormalAppVO.setCurcd(tblContBaseInfo.getCurcd());
				billNormalAppVO.setContAmount(tblContBaseInfo.getLnAmt());
			}
			BeanUtils.copyProperties(billNormalAppVO, tblAppliBaseInfo);
			tblAppliBaseInfo.setCurcd(billNormalAppVO.getCurcd()); // 币种
			tblAppliBaseInfo.setAmt(billNormalAppVO.getContAmount()); // 申请金额（合同金额）
			tblAppliBaseInfo.setAppliType(WorkflowConstant.APPLI_TYPE_BILL_NORMAL_UNPLEDGEAPPLI); // 解押申请
			tblAppliBaseInfo.setBusinessnoType(ScfBasConstant.BUSINESSNO_TYPE_SLAVECONTNO); // 提货申请的合同编号（从合同号）
			tblAppliBaseInfo.setBusinessno(billNormalAppVO.getSlaveContno()); // 从合同号
			tblAppliBaseInfo.setAppliStatus(ScfBasConstant.APPLI_STATUS_UNSUBMIT); // 申请状态:未提交（默认）
			tblAppliBaseInfo.setAppliStatusDtl(WorkflowConstant.APPLI_STATUS_DTL_WRITING); // 申请状态明细:未提交（默认）
			// tblAppliBaseInfo.setSupplyChainPdId(SCFConstants.PRODUCT_TYPE_1003);//产品ID
			tblAppliBaseInfo.setProtocolNo(bCntMprotBaseInfoService.getMonitorProtocolNoBySlaveContnoAppnoPt(tblAppliBaseInfo.getSlaveContno(), "",
					ScfBasConstant.MUTI_PROTOCOL_MONI)); // 监管协议号
			this.addBPbcAppliBaseInfo(tblAppliBaseInfo);
		} else { // 更新
			BeanUtils.copyProperties(tblAppliBaseInfodao, tblAppliBaseInfo);
			String appliStatusDtl = billNormalAppVO.getAppliStatusDtl();
			if (StringUtil.isEmpty(appliStatusDtl)) {

			} else if (appliStatusDtl.equals(WorkflowConstant.APPLI_STATUS_DTL_GOBACK)) {
				tblAppliBaseInfo.setAppliStatusDtl(WorkflowConstant.APPLI_STATUS_DTL_BACKMODIFY);
			}
			tblAppliBaseInfo.setBailAmount(billNormalAppVO.getBailAmount());
			tblAppliBaseInfo.setMemo(billNormalAppVO.getMemo());
			this.updateBPbcAppliBaseInfo(tblAppliBaseInfo);
		}
		BeanUtils.copyProperties(billNormalAppVO, ware);
		ware.setAppno(tblAppliBaseInfo.getAppno());
//		sbcpappliwarehouseservice.saveOrUpdate(ware);// 保存在临时表中用于页面显示
		return tblAppliBaseInfo.getAppno();
	}

	/**
	 * getWareMnAddByPara 预解押仓单列表
	 * 
	 * @param billNormalAppVO
	 * @return
	 * @throws ScubeBizException
	 * @author mengjiajia
	 * @date 2017年5月3日下午3:26:50
	 */
	@Override
	public Page getWareMnAddByPara(BillNormalAppVO billNormalAppVO) throws ScubeBizException {
		HashMap<String, Object> omap = new HashMap<String, Object>();
		omap.put("appno", billNormalAppVO.getAppno());
		omap.put("businessnoType", ScfBasConstant.BUSINESSNO_TYPE_SLAVECONTNO);

		if (!StringUtil.isEmpty(billNormalAppVO.getSlaveContno())) {
			// 从合同号
			omap.put("businessno", billNormalAppVO.getSlaveContno());
		}
		int total = extbmrndao.countWareMnAddByPara(omap);
		Page page = new Page(billNormalAppVO.getPageSize(), billNormalAppVO.getPageIndex(), total);
		page.setRecords(extbmrndao.getWareMnAddByPara(omap, page));
		return page;
	}

	/**
	 * 普通仓单置换申请表的保存
	 * 
	 * @param billNormalAppVO
	 * @return
	 * @throws ScubeBizException
	 * @author mengjiajia
	 * @date 2017年5月8日下午5:47:37
	 */
	@Override
	public String saveBillManageExchangeAppBaseInfo(BillNormalAppVO billNormalAppVO) throws ScubeBizException {
		// 第一步保存从合同产品信息
		BCrrGntyCon tblContSlaveInfo = bCrrGntyConService.findBCrrGntyConByConId(billNormalAppVO.getSlaveContno());
		// 第二步 主合同信息
		BPbcAppliBaseInfo appBaseInfo = new BPbcAppliBaseInfo();
		appBaseInfo.setProcessTemplateName(WorkflowConstant.PROCNAME_NORMAL_BILL_EXCHANGE_APPLY); // 流程名称
		appBaseInfo.setAppliType(WorkflowConstant.APPLI_TYPE_BILL_NORMAL_EXCHANGE);// 普通仓单置换申请
		appBaseInfo.setAppliStatus(WorkflowConstant.APPLI_STATUS_UNSUBMIT); // 申请状态:未提交（默认）
		appBaseInfo.setAppliStatusDtl(WorkflowConstant.APPLI_STATUS_DTL_WRITING); // 申请状态明细:未提交（默认）
		appBaseInfo.setBusinessnoType(ScfBasConstant.BUSINESSNO_TYPE_SLAVECONTNO); // 提货申请的合同编号（从合同号）
		appBaseInfo.setCustcd(billNormalAppVO.getCustcd()); // 客户号
		appBaseInfo.setBusinessno(billNormalAppVO.getSlaveContno());
		appBaseInfo.setAmt(tblContSlaveInfo.getGutVal()); // 申请金额（合同金额）
		appBaseInfo.setCurcd(tblContSlaveInfo.getGutCurcd());
		appBaseInfo.setMemo(billNormalAppVO.getMemo());
		// appBaseInfo.setAppliStatus(applyVO.getAppliStatus());//申请状态
		// appBaseInfo.setAppliStatusDtl(applyVO.getAppliStatusDtl());//审批状态
		appBaseInfo.setMastContno(billNormalAppVO.getMastContno());
		appBaseInfo.setSlaveContno(billNormalAppVO.getSlaveContno());
		appBaseInfo.setProtocolNo(bCntMprotBaseInfoService.getMonitorProtocolNoBySlaveContnoAppnoPt(billNormalAppVO.getSlaveContno(),
				billNormalAppVO.getAppno(), ScfBasConstant.MUTI_PROTOCOL_MONI)); // 监管协议号
		appBaseInfo.setSupplyChainPdId(tblContSlaveInfo.getVidPrdId());
		String appno = bSysSerialNoService.genSerialNo("FBZH_APP_NO");
		appBaseInfo.setAppno(appno);
		// 保存PO，返回PK
		this.addBPbcAppliBaseInfo(appBaseInfo);
		return appno;
	}

	/**
	 * 修改置换申请信息
	 * 
	 * @param billNormalAppVO
	 * @return
	 * @throws ScubeBizException
	 * @author mengjiajia
	 * @date 2017年5月8日下午6:03:23
	 */
	@Override
	public String saveBillManageExchangeAppBaseInfoForModify(BillNormalAppVO billNormalAppVO) throws ScubeBizException {
		UserInfo user = ContextHolder.getUserInfo();
		String tlrNo = user.getTlrNo();
		String brCode = user.getBrNo();

		BPbcAppliBaseInfo bPbcAppliBaseInfo = this.findBPbcAppliBaseInfoByKey(billNormalAppVO.getAppno());
		bPbcAppliBaseInfo.setAppDate(ScfDateUtil.getStringDate(billNormalAppVO.getAppDate()));// 申请日期
		bPbcAppliBaseInfo.setMemo(billNormalAppVO.getMemo());
		bPbcAppliBaseInfo.setAppDate(ScfDateUtil.getStringDate(new Date())); // 登记时间

		bPbcAppliBaseInfo.setStartTime(new Date()); // 流程启动时间
		bPbcAppliBaseInfo.setStratDate(ScfDateUtil.getStringDate(new Date())); // 流程启动日期
		bPbcAppliBaseInfo.setStartBrcode(brCode); // 流程发起机构
		bPbcAppliBaseInfo.setStartTlrcd(tlrNo); // 流程启动人
		this.updateBPbcAppliBaseInfo(bPbcAppliBaseInfo);
		String appno = bPbcAppliBaseInfo.getAppno();
		return appno;
	}

	/**
	 * 根据质押合同号查询，处于审批流程中的质押合同
	 * 
	 * @param slaveContno
	 * @return
	 * @author mengjiajia
	 * @date 2017年5月10日下午2:34:50
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public List queryAppliBaseInfoBySlaveContno(String slaveContno) {
		List<String> applistatusList = new ArrayList<String>();
		applistatusList.add(WorkflowConstant.APPLI_STATUS_DTL_WAIT_SCF_WRITING);
		applistatusList.add(WorkflowConstant.APPLI_STATUS_DTL_WAITCMS);
		BPbcAppliBaseInfoExample example = new BPbcAppliBaseInfoExample();
		BPbcAppliBaseInfoExample.Criteria cri = example.createCriteria();
		cri.andSlaveContnoEqualTo(slaveContno);
		cri.andAppliStatusDtlIn(applistatusList);
		List<com.huateng.scf.bas.pbc.dao.model.BPbcAppliBaseInfo> list = bPbcAppliBaseInfoDAO.selectByExample(example);
		return list;
	}

	/*
	 * 
	 */
	@Override
	@Transactional
	public String saveQualityApplyInfo(MortgageApplyVO mortgageApplyVO, String businessnoType, String workApplyType) throws ScubeBizException {
		if (mortgageApplyVO == null || businessnoType == null || workApplyType == null) {
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10005), RBcpErrorConstant.SCF_REC_BCP_10005);
		}
		BCrrGntyCon bCrrGntyCon = bCrrGntyConService.findBCrrGntyConByConId(mortgageApplyVO.getSlaveContno());
		String appno = "";
		if (StringUtils.isEmpty(mortgageApplyVO.getAppno())) {
			com.huateng.scf.bas.pbc.dao.model.BPbcAppliBaseInfo bPbcAppliBaseInfo = new com.huateng.scf.bas.pbc.dao.model.BPbcAppliBaseInfo();
			bPbcAppliBaseInfo.setCurcd(bCrrGntyCon.getGutCurcd());
			bPbcAppliBaseInfo.setProcessTemplateName(workApplyType); // 流程名称
			bPbcAppliBaseInfo.setAppliType(businessnoType);// 申请类型
			bPbcAppliBaseInfo.setMoniCustcd(mortgageApplyVO.getMoniCustcd());
			bPbcAppliBaseInfo.setBusinessnoType(ScfBasConstant.BUSINESSNO_TYPE_SLAVECONTNO);// 从合同号类型
			bPbcAppliBaseInfo.setBusinessno(mortgageApplyVO.getSlaveContno()); // 从合同号
			bPbcAppliBaseInfo.setAppliStatus(WorkflowConstant.APPLI_STATUS_UNSUBMIT); // 申请状态:未提交（默认）
			bPbcAppliBaseInfo.setAppliStatusDtl(WorkflowConstant.APPLI_STATUS_DTL_WRITING); // 申请状态明细:未提交（默认）
			bPbcAppliBaseInfo.setAppBrcode(ContextHolder.getOrgInfo().getBrNo()); // 登记机构
			bPbcAppliBaseInfo.setAppDate(ScfBaseData.getScfGlobalInfoData().getTxnDate()); // 登记时间
			bPbcAppliBaseInfo.setAppTlrcd(ContextHolder.getUserInfo().getTlrNo()); // 登记人
			bPbcAppliBaseInfo.setPledgeMode(mortgageApplyVO.getMoniType()); // 质押模式
			bPbcAppliBaseInfo.setStartTime(new Date());
			bPbcAppliBaseInfo.setStratDate(ScfDateUtil.getStringDate(new Date()));
			bPbcAppliBaseInfo.setStartBrcode(ContextHolder.getOrgInfo().getBrNo());
			bPbcAppliBaseInfo.setStartTlrcd(ContextHolder.getUserInfo().getTlrNo());
			bPbcAppliBaseInfo.setSupplyChainPdId(bCrrGntyCon.getVidPrdId());
			bPbcAppliBaseInfo.setSlaveContno(mortgageApplyVO.getSlaveContno()); // 业务合同号
			bPbcAppliBaseInfo.setProtocolNo(bCrrGntyCon.getPrtclNo()); // 监管协议号
			bPbcAppliBaseInfo.setOtherProtocolNo(bCrrGntyCon.getPrtclNo()); // 监管协议号
			bPbcAppliBaseInfo.setAmt(mortgageApplyVO.getAmt()); // 业务发生额
			bPbcAppliBaseInfo.setBailAmount(mortgageApplyVO.getBailAmount()); // 保证金金额
			bPbcAppliBaseInfo.setPledgeMode(mortgageApplyVO.getMoniType());
			bPbcAppliBaseInfo.setCustcd(mortgageApplyVO.getCustcd());
			appno = bSysSerialNoService.genSerialNo("INDEX_APP_NO");
			bPbcAppliBaseInfo.setAppno(appno);
			bPbcAppliBaseInfo.setPiid(UUIDGeneratorUtil.generate());
			bPbcAppliBaseInfo.setChannelFlag(ScfBasConstant.CHANNEL_FLAG_SCF);
			bPbcAppliBaseInfo.setIsFlowEnd(ScfBasConstant.FLAG_OFF);
			bPbcAppliBaseInfoDAO.insert(bPbcAppliBaseInfo);
		} else {
			BPbcAppliBaseInfo bPbcAppliBaseInfo = findBPbcAppliBaseInfoByKey(mortgageApplyVO.getAppno());
			com.huateng.scf.bas.pbc.dao.model.BPbcAppliBaseInfo bPbcAppliBaseInfo2 = new com.huateng.scf.bas.pbc.dao.model.BPbcAppliBaseInfo();
			BeanUtils.copyProperties(bPbcAppliBaseInfo, bPbcAppliBaseInfo2);
			bPbcAppliBaseInfo2.setAmt(mortgageApplyVO.getAmt());
			bPbcAppliBaseInfo2.setBailAmount(mortgageApplyVO.getBailAmount());
			bPbcAppliBaseInfoDAO.updateByPrimaryKey(bPbcAppliBaseInfo2);
			appno = bPbcAppliBaseInfo2.getAppno();
		}
		return appno;
	}

	@Override
	public Page queryBPbcAppliBaseInfoByPage(int pageNo, int pageSize, BPbcAppliBaseInfo bPbcAppliBaseInfo) throws ScubeBizException {
		if (bPbcAppliBaseInfo == null) {
			return null;
		}
		BPbcAppliBaseInfoExample bPbcAppliBaseInfoExample = new BPbcAppliBaseInfoExample();
		BPbcAppliBaseInfoExample.Criteria crea = bPbcAppliBaseInfoExample.createCriteria();
		// 申请类型确定业务
		if (StringUtils.isNotEmpty(bPbcAppliBaseInfo.getAppliType())) {
			if (bPbcAppliBaseInfo.getAppliType().contains(",")) {
				String[] appliType = bPbcAppliBaseInfo.getAppliType().split(",");
				ArrayList<String> arrayList = new ArrayList<String>();
				for (int i = 0; i < appliType.length; i++) {
					arrayList.add(appliType[i]);
				}
				crea.andAppliTypeIn(arrayList);
			} else {
				crea.andAppliTypeEqualTo(bPbcAppliBaseInfo.getAppliType());
			}
		}
		// appno
		if (StringUtils.isNotEmpty(bPbcAppliBaseInfo.getAppno())) {
			crea.andAppnoLike("%" + bPbcAppliBaseInfo.getAppno() + "%");
		}
		// supplyChainPdId
		if (StringUtils.isNotEmpty(bPbcAppliBaseInfo.getSupplyChainPdId())) {
			crea.andSupplyChainPdIdEqualTo(bPbcAppliBaseInfo.getSupplyChainPdId());
		}
		// appliStatus
		if (StringUtils.isNotEmpty(bPbcAppliBaseInfo.getAppliStatus())) {
			crea.andAppliStatusEqualTo(bPbcAppliBaseInfo.getAppliStatus());
		}
		// 卖方 custcd
		if (StringUtils.isNotEmpty(bPbcAppliBaseInfo.getCustcd())) {
			crea.andCustcdEqualTo(bPbcAppliBaseInfo.getCustcd());
		}
		// 买方 moniCustcd
		if (StringUtils.isNotEmpty(bPbcAppliBaseInfo.getMoniCustcd())) {
			crea.andMoniCustcdEqualTo(bPbcAppliBaseInfo.getMoniCustcd());
		}
		// 业务合同号
		if (StringUtils.isNotEmpty(bPbcAppliBaseInfo.getMastContno())) {
			crea.andMastContnoLike("%"+bPbcAppliBaseInfo.getMastContno()+"%");
		}
		// 查询权限设置
		HashMap<String, List<String>> map = ScfMessageUtil.transSysParamByKey(ScfBasConstant.QUERY_LIMITS);
		if (!StringUtil.isEmpty(map.get("tlrNoList"))) {
			crea.andStartTlrcdIn(map.get("tlrNoList"));
		}
		if (!StringUtil.isEmpty(map.get("brNoList"))) {
			crea.andStartBrcodeIn(map.get("brNoList"));
		}
		bPbcAppliBaseInfoExample.setOrderByClause("APPROVE_TIME DESC");
		Page page = new Page(pageSize, pageNo, 0);
		List<com.huateng.scf.bas.pbc.dao.model.BPbcAppliBaseInfo> bPbcAppliBaseInfoList = bPbcAppliBaseInfoDAO.selectByPage(bPbcAppliBaseInfoExample,
				page);
		ArrayList<BPbcAppliBaseInfoVO> arrayList = new ArrayList<BPbcAppliBaseInfoVO>();
		if (bPbcAppliBaseInfoList != null && bPbcAppliBaseInfoList.size() > 0) {
			for (com.huateng.scf.bas.pbc.dao.model.BPbcAppliBaseInfo bPbcAppliBaseInfo2 : bPbcAppliBaseInfoList) {
				BPbcAppliBaseInfoVO bPbcAppliBaseInfoVO = new BPbcAppliBaseInfoVO();
				BeanUtils.copyProperties(bPbcAppliBaseInfo2, bPbcAppliBaseInfoVO);
				// 业务品种
				if (StringUtils.isNotEmpty(bPbcAppliBaseInfoVO.getSupplyChainPdId())) {
					com.huateng.scf.bas.prd.dao.model.BPrdInfo bPrdInfo = bPrdInfoDAO.selectByPrimaryKey(bPbcAppliBaseInfoVO.getSupplyChainPdId());
					if (bPrdInfo != null) {
						bPbcAppliBaseInfoVO.setSupplyChainPdName(bPrdInfo.getProductName());
					}
				}
				// 卖方名称
				if (StringUtils.isNotEmpty(bPbcAppliBaseInfoVO.getCustcd())) {
					BCrmBaseInfo bCrmBaseInfo = new BCrmBaseInfo();
					bCrmBaseInfo.setCustcd(bPbcAppliBaseInfoVO.getCustcd());
					BCrmBaseInfo bCrmBaseInfo1 = bCrmBaseInfoService.findBCrmBaseInfoByKey(bCrmBaseInfo);
					if (bCrmBaseInfo1 != null) {
						bPbcAppliBaseInfoVO.setCname(bCrmBaseInfo1.getCname());
					}
				}

				// 买方名称
				if (StringUtils.isNotEmpty(bPbcAppliBaseInfoVO.getMoniCustcd())) {
					BCrmBaseInfo bCrmBaseInfo2 = new BCrmBaseInfo();
					bCrmBaseInfo2.setCustcd(bPbcAppliBaseInfoVO.getMoniCustcd());
					BCrmBaseInfo bCrmBaseInfo3 = bCrmBaseInfoService.findBCrmBaseInfoByKey(bCrmBaseInfo2);
					if (bCrmBaseInfo3 != null) {
						bPbcAppliBaseInfoVO.setMoniCname(bCrmBaseInfo3.getCname());
					}
				}

				UserInfo userInfo1 = new UserInfo();
				userInfo1.setTlrNo(bPbcAppliBaseInfoVO.getStartTlrcd());// 搜索创建人对应的名称。
				List<TlrInfoVO> userList = userService.selectByExample(userInfo1);
				if (userList != null && userList.size() == 1) {
					bPbcAppliBaseInfoVO.setStartTlrNm(userList.get(0).getTlrName());
				}

				// 经办机构brName
				BctlVO bctlVO = new BctlVO();
				bctlVO.setBrNo(bPbcAppliBaseInfoVO.getStartBrcode());
				List<BctlVO> bctlVOList = orgService.selectByExample(bctlVO);
				if (bctlVOList != null && bctlVOList.size() == 1) {
					bPbcAppliBaseInfoVO.setStartBrName(bctlVOList.get(0).getBrName());
				}
				arrayList.add(bPbcAppliBaseInfoVO);
			}
		}
		page.setRecords(arrayList);
		return page;
	}

	// 新应收类商纠登记新增申请基本信息
	@Override
	@Transactional
	public String saveDisputeRegisterAppliBaseInfo(DebtBussInfoVO debtVO, String businessnoType, String workApplyType) throws ScubeBizException {
		// 保理合同基本信息中查询相应的记录
		BCntBcpInfoVO tblContBaseInfo = bCntBcpInfoService.queryBCntBcpInfoByMastContno(debtVO.getMastContno());
		com.huateng.scf.bas.pbc.dao.model.BPbcAppliBaseInfo bPbcAppliBaseInfo = new com.huateng.scf.bas.pbc.dao.model.BPbcAppliBaseInfo();
		if (StringUtils.isEmpty(debtVO.getAppno())) {
			UserInfo globalInfo = ContextHolder.getUserInfo();
			bPbcAppliBaseInfo.setBusinessnoType(businessnoType);
			bPbcAppliBaseInfo.setCustcd(debtVO.getCustcdSaller());
			bPbcAppliBaseInfo.setMoniCustcd(debtVO.getCustcdBuyer());
			bPbcAppliBaseInfo.setCurcd(tblContBaseInfo.getCurcd()); // 币种
			bPbcAppliBaseInfo.setProcessTemplateName(workApplyType); // 流程名称
			bPbcAppliBaseInfo.setAppliType(businessnoType);
			bPbcAppliBaseInfo.setBusinessnoType(ScfBasConstant.BUSINESSNO_TYPE_CONTNO);
			bPbcAppliBaseInfo.setAppliStatus(WorkflowConstant.APPLI_STATUS_UNSUBMIT); // 申请状态:未提交（默认）
			bPbcAppliBaseInfo.setAppliStatusDtl(WorkflowConstant.APPLI_STATUS_DTL_WRITING); // 申请状态明细:未提交（默认）
			bPbcAppliBaseInfo.setAppBrcode(globalInfo.getBrNo()); // 登记机构
			bPbcAppliBaseInfo.setApprover(globalInfo.getTlrNo());
			bPbcAppliBaseInfo.setApproveTime(new Date());
			bPbcAppliBaseInfo.setAppDate(ScfDateUtil.formatDate(new Date())); // 登记时间
			bPbcAppliBaseInfo.setStartTime(new Date());
			bPbcAppliBaseInfo.setStratDate(ScfDateUtil.formatDate(new Date()));
			bPbcAppliBaseInfo.setStartBrcode(globalInfo.getBrNo());
			bPbcAppliBaseInfo.setStartTlrcd(globalInfo.getTlrNo());
			bPbcAppliBaseInfo.setAppTlrcd(globalInfo.getTlrNo()); // 登记人
			// bPbcAppliBaseInfo.setSupplyChainPdId(debtVO.getProductId()); //
			// 产品ID
			bPbcAppliBaseInfo.setSupplyChainPdId(debtVO.getBussType()); // 业务品种
			bPbcAppliBaseInfo.setMemo(debtVO.getMemo());
			bPbcAppliBaseInfo.setMastContno(tblContBaseInfo.getMastContno()); // 主合同号
			bPbcAppliBaseInfo.setProtocolNo(debtVO.getLoanWay()); // 出账方式
			bPbcAppliBaseInfo.setBusinessno(debtVO.getBusinessNo());
			bPbcAppliBaseInfo.setAmt(debtVO.getAmount());
			String appno = "";
			String genSerialNo = bSysSerialNoService.genSerialNo("INDEX_APP_NO");
			if (workApplyType.contains("RemoveApply")) {
				appno = "SJJC" + ScfDateUtil.formatDate(new Date()) + genSerialNo;
			} else {
				appno = "SJDJ" + ScfDateUtil.formatDate(new Date()) + genSerialNo;
			}
			bPbcAppliBaseInfo.setAppno(appno);
			/*
			 * if (StringUtils.isEmpty(bPbcAppliBaseInfo.getAppno())) {
			 * bPbcAppliBaseInfo.setAppno(String.valueOf(this.getSeqPK(
			 * ScfBasConstant.VALUE_NO_SEQ_TBL_ID,
			 * ScfBasConstant.VALUE_INDEX_APPLIBASEINFO_ID))); }
			 */
			if (StringUtils.isEmpty(bPbcAppliBaseInfo.getBusinessno())) {
				bPbcAppliBaseInfo.setBusinessno(bPbcAppliBaseInfo.getAppno());
			}
			if (StringUtils.isEmpty(bPbcAppliBaseInfo.getChannelFlag())) {
				bPbcAppliBaseInfo.setChannelFlag(ScfBasConstant.CHANNEL_FLAG_SCF);// 默认渠道标识为供应链
			}
			if (StringUtils.isEmpty(bPbcAppliBaseInfo.getIsFlowEnd())) {
				bPbcAppliBaseInfo.setIsFlowEnd(ScfBasConstant.FLAG_OFF);// 默认流程未结束
			}
			// 业务申请基本信息表插入一条数据
			bPbcAppliBaseInfoDAO.insert(bPbcAppliBaseInfo);

		} else {// 更新
			String appNo = debtVO.getAppno();
			bPbcAppliBaseInfo = (com.huateng.scf.bas.pbc.dao.model.BPbcAppliBaseInfo) bPbcAppliBaseInfoDAO.selectByPrimaryKey(appNo);
			bPbcAppliBaseInfo.setAmt(debtVO.getTotalAmount());
			bPbcAppliBaseInfoDAO.updateByPrimaryKey(bPbcAppliBaseInfo);
		}
		return bPbcAppliBaseInfo.getAppno();
	}

	// 根据flag修改申请基本信息申请状态
	@Override
	@Transactional
	public void editAppliBaseStatusByFlag(String appno, String flag) throws ScubeBizException {
		if (StringUtils.isEmpty(appno) || StringUtils.isEmpty(flag)) {
			return;
		}
		BPbcAppliBaseInfo bPbcAppliBaseInfo = findBPbcAppliBaseInfoByKey(appno);
		if (bPbcAppliBaseInfo == null) {// 申请基本信息查询失败！
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10040), RBcpErrorConstant.SCF_REC_BCP_10040);
		}
		if (flag.equals("pass")) {
			bPbcAppliBaseInfo.setAppliStatus(WorkflowConstant.APPLI_STATUS_APPROVED);
			bPbcAppliBaseInfo.setAppliStatusDtl(WorkflowConstant.APPLI_STATUS_DTL_APPROVED);
			bPbcAppliBaseInfo.setIsFlowEnd("1");// 流程已结束
		} else if (flag.equals("reject")) {// 顺带解锁对应单据信息
			bPbcAppliBaseInfo.setAppliStatus(WorkflowConstant.APPLI_STATUS_REFUSED);
			bPbcAppliBaseInfo.setAppliStatusDtl(WorkflowConstant.APPLI_STATUS_DTL_REFUSED);
			bPbcAppliBaseInfo.setIsFlowEnd("1");// 流程已结束
			// 顺带解锁对应单据信息
			rBcpDebtInfoService.releaseDebtInfoByAppno(bPbcAppliBaseInfo.getAppno());
		} else if (flag.equals("back")) {
			bPbcAppliBaseInfo.setAppliStatus(WorkflowConstant.APPLI_STATUS_GOBACK);
			bPbcAppliBaseInfo.setAppliStatusDtl(WorkflowConstant.APPLI_STATUS_DTL_GOBACK);
		} else if (flag.equals("next")) {
			bPbcAppliBaseInfo.setAppliStatus(WorkflowConstant.APPLI_STATUS_SUBMITUNAPPROVE);
		}
		try {
			updateBPbcAppliBaseInfo(bPbcAppliBaseInfo);
		} catch (Exception e) {
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10040), RBcpErrorConstant.SCF_REC_BCP_10040);
		}
		return;
	}

	/**
	 * 查询在流程中的放款信息(池融资放款)
	 * @return
	 * @author 	mengjiajia
	 * @date 	2017年7月20日下午4:36:07
	 */
	@Override
	public List<BPbcAppliBaseInfoVO> findInFlowDuebillAppByParam()
	{
		// 查询
		BPbcAppliBaseInfoExample example = new BPbcAppliBaseInfoExample();
		BPbcAppliBaseInfoExample.Criteria cri = example.createCriteria();
		//申请类型
		List<String> appliTypes = new ArrayList<String>();
		appliTypes.add(WorkflowConstant.APPLI_TYPE_FINANCINGPOOLAPPLY);//流贷放款
		//流程ID
		List<String> modelIds = new ArrayList<String>();
		modelIds.add("N-"+WorkflowConstant.PROCNAME_FINANCING_POOL_APPLY);
		//业务申请状态（流程中）
		List<String> appliStatus = new ArrayList<String>();
		appliStatus.add(WorkflowConstant.APPLI_STATUS_SUBMITUNAPPROVE);//已提交
		appliStatus.add(WorkflowConstant.APPLI_STATUS_GOBACK);//已退回
		cri.andAppliTypeIn(appliTypes);
		cri.andProcessTemplateNameIn(modelIds);
		cri.andAppliStatusIn(appliStatus);
		//流程是否结束
//		cri.andIsFlowEndNotEqualTo("1");//流程已结束
		List<com.huateng.scf.bas.pbc.dao.model.BPbcAppliBaseInfo> list = bPbcAppliBaseInfoDAO.selectByExample(example);
		List<BPbcAppliBaseInfoVO> result = new ArrayList<BPbcAppliBaseInfoVO>();
		if(list!=null&&list.size()>0)
		{
			BPbcAppliBaseInfoVO appliBaseInfoVO = null;
			for(com.huateng.scf.bas.pbc.dao.model.BPbcAppliBaseInfo appliBaseInfo:list)
			{
				appliBaseInfoVO = new BPbcAppliBaseInfoVO();
				try
				{
					BeanUtils.copyProperties(appliBaseInfo, appliBaseInfoVO);
				}catch(BeansException e)
				{
					throw new ScubeBizException("转换异常");
				}
				result.add(appliBaseInfoVO);
			}
		}
		return result;
	}

}
