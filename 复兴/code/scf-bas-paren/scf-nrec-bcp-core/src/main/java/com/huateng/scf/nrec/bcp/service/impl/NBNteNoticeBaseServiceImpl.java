/**
 * 
 */
package com.huateng.scf.nrec.bcp.service.impl;

import java.math.BigDecimal;
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
import com.huateng.authority.entity.TlrInfoVO;
import com.huateng.authority.entity.UserInfo;
import com.huateng.authority.inter.service.ScubeUserService;
import com.huateng.authority.service.OrgService;
import com.huateng.authority.service.UserService;
import com.huateng.base.common.beans.Page;
import com.huateng.scf.adv.bcp.model.ABcpAppliImprestBuss;
import com.huateng.scf.adv.bcp.service.IABcpAppliImprestBussService;
import com.huateng.scf.adv.tcs.constant.ATcsErrorConstant;
import com.huateng.scf.bas.cnt.dao.IBCntMprotDealInfoDAO;
import com.huateng.scf.bas.cnt.dao.model.BCntMprotDealInfo;
import com.huateng.scf.bas.cnt.dao.model.BCntMprotDealInfoExample;
import com.huateng.scf.bas.cnt.model.BCntBuyInfo;
import com.huateng.scf.bas.cnt.model.BCntMprotBaseInfo;
import com.huateng.scf.bas.cnt.model.BCntMprotPartInfo;
import com.huateng.scf.bas.cnt.model.FourWareLoanVO;
import com.huateng.scf.bas.cnt.service.IBCntBuyInfoService;
import com.huateng.scf.bas.cnt.service.IBCntMprotBaseInfoService;
import com.huateng.scf.bas.cnt.service.IBCntMprotPartInfoService;
import com.huateng.scf.bas.common.constant.NoticeConstant;
import com.huateng.scf.bas.common.constant.ScfBasConstant;
import com.huateng.scf.bas.common.model.DeliveryApplyQryVO;
import com.huateng.scf.bas.common.model.NoticeQryPrintVO;
import com.huateng.scf.bas.common.startup.ScfBaseData;
import com.huateng.scf.bas.common.startup.ScfGlobalInfo;
import com.huateng.scf.bas.common.startup.ScfGlobalInfoUtil;
import com.huateng.scf.bas.common.startup.ScfMessageUtil;
import com.huateng.scf.bas.common.util.ScfCommonUtil;
import com.huateng.scf.bas.common.util.ScfDateUtil;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.common.util.UUIDGeneratorUtil;
import com.huateng.scf.bas.crm.dao.IBCrmBaseInfoDAO;
import com.huateng.scf.bas.crm.model.BCrmBaseInfo;
import com.huateng.scf.bas.crm.service.IBCrmBaseInfoService;
import com.huateng.scf.bas.crr.dao.IBCrrGntyConDAO;
import com.huateng.scf.bas.crr.model.BCrrGntyCon;
import com.huateng.scf.bas.crr.model.BCrrLnCon;
import com.huateng.scf.bas.crr.service.IBCrrGntyConService;
import com.huateng.scf.bas.crr.service.IBCrrLnConService;
import com.huateng.scf.bas.lan.model.BLanLnciBase;
import com.huateng.scf.bas.lan.service.IBLanLnciBaseService;
import com.huateng.scf.bas.nte.constant.BNteErrorConstant;
import com.huateng.scf.bas.nte.dao.IBNteNoticeBaseDAO;
import com.huateng.scf.bas.nte.dao.IBNteNoticeMtgDAO;
import com.huateng.scf.bas.nte.dao.ext.ExtBNteDAO;
import com.huateng.scf.bas.nte.dao.model.BNteNoticeBaseExample;
import com.huateng.scf.bas.nte.dao.model.BNteNoticeBaseExample.Criteria;
import com.huateng.scf.bas.nte.dao.model.BNteNoticeMtgExample;
import com.huateng.scf.bas.nte.model.BNteNoticeBase;
import com.huateng.scf.bas.nte.model.BNteNoticeMtg;
import com.huateng.scf.bas.nte.model.NoticeQryVO;
import com.huateng.scf.bas.nte.service.IBNteNoticeMtgService;
import com.huateng.scf.bas.pbc.constant.BPbcErrorConstant;
import com.huateng.scf.bas.pbc.dao.model.BPbcAppliMtgInfo;
import com.huateng.scf.bas.pbc.model.BPbcAppliBaseInfo;
import com.huateng.scf.bas.pbc.service.IBPbcAppliBaseInfoService;
import com.huateng.scf.bas.pbc.service.IBPbcAppliMtgInfoService;
import com.huateng.scf.bas.pbc.vo.MortgageApplyVO;
import com.huateng.scf.bas.prd.model.BPrdInfo;
import com.huateng.scf.bas.prd.service.IBPrdInfoService;
import com.huateng.scf.bas.sys.constant.BSysConstant;
import com.huateng.scf.bas.sys.constant.WorkflowConstant;
import com.huateng.scf.bas.sys.service.IBSysSerialNoService;
import com.huateng.scf.nrec.bcp.model.BCntBcpInfoVO;
import com.huateng.scf.nrec.bcp.service.IBCntBcpExtInfoService;
import com.huateng.scf.nrec.bcp.service.IBCntBcpInfoService;
import com.huateng.scf.nrec.bcp.service.INBNteNoticeBaseService;
import com.huateng.scf.nrec.bcp.service.INRBcpAppliBussInfoService;
import com.huateng.scf.rec.bcp.constant.RBcpErrorConstant;
import com.huateng.scf.rec.bcp.model.AppliBussInfoVO;
import com.huateng.scf.rec.bcp.model.RBcpAppliBussInfo;
import com.huateng.scf.rec.bcp.service.IRBcpAppliBussInfoService;
import com.huateng.scf.sto.dmp.model.SBcpAppliLowerPrice;
import com.huateng.scf.sto.dmp.service.ISBcpAppliLowerPriceService;
import com.huateng.scf.sto.nwr.vo.AppliMortgageBaseQryVO;
import com.huateng.scf.sto.nwr.vo.BillNormalMortgageVO;
import com.huateng.scf.sto.nwr.vo.BillStandardBussInfoVO;
import com.huateng.scf.sto.nwr.vo.DeliveyApplyVO;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * <p>
 * </p>
 *
 * @author shangxiujuan
 * @date 2016年12月15日上午9:25:25
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 *            <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * shangxiujuan		2016年12月15日上午9:25:25	     新增
 *
 *            </pre>
 */
@ScubeService
@Service("NBNteNoticeBaseServiceImpl")
public class NBNteNoticeBaseServiceImpl implements INBNteNoticeBaseService {
	private final Logger log = LoggerFactory.getLogger(getClass());
	@Resource(name = "orgService")
	OrgService orgService;

	@Resource(name = "userService")
	UserService userService;

	@Resource(name = "BNteNoticeBaseDAO")
	IBNteNoticeBaseDAO bNteNoticeBaseDAO;

	@Resource(name = "BNteNoticeMtgDAO")
	IBNteNoticeMtgDAO bNteNoticeMtgDAO;

	@Resource(name = IBPbcAppliBaseInfoService.BEAN_ID)
	IBPbcAppliBaseInfoService bPbcAppliBaseInfoService;// 业务申请表

	@Resource(name = "BCntBcpInfoServiceImpl")
	IBCntBcpInfoService bcntbcpinfoservice;// 合同基本信息

	@Resource(name = IRBcpAppliBussInfoService.BEAN_ID)
	IRBcpAppliBussInfoService rBcpAppliBussInfoService;// 应收账款业务申请流水基本信息

	// 客户信息
	@Resource(name = "IBCrmBaseInfoDAO")
	IBCrmBaseInfoDAO bCrmBaseInfoDAO;

	// 客户信息
	@Resource(name = "BCrmBaseInfoServiceImpl")
	IBCrmBaseInfoService bCrmBaseInfoService;

	// 产品信息（用于业务品种翻译）
	@Resource(name = "BPrdInfoServiceImpl")
	IBPrdInfoService bPrdInfoService;

	@Resource(name = "bSysSerialNoService")
	private IBSysSerialNoService bSysSerialNoService;

	@Resource(name = "BLanLnciBaseServiceImpl")
	IBLanLnciBaseService bLanLnciBaseService;

	@Resource(name = "BCntBcpExtInfoServiceImpl")
	IBCntBcpExtInfoService bcntbcpextinfoservice; // 合同交易对手信息

	@Resource(name = "BCntMprotPartInfoServiceImpl")
	IBCntMprotPartInfoService bCntMprotPartInfoService;

	@Resource(name = "BCntMprotDealInfoDAO")
	IBCntMprotDealInfoDAO bCntMprotDealInfoDAO;

	// 押品业务申请表
	@Resource(name = "BPbcAppliMtgInfoServiceImpl")
	IBPbcAppliMtgInfoService bpbcapplimtginfoservice;

	@Autowired
	ScubeUserService scubeUserService;

	@Resource(name = "ExtBNteDAO")
	ExtBNteDAO extbntedao;

	@Resource(name = "BCntBuyInfoServiceImpl")
	IBCntBuyInfoService bCntBuyInfoService;

	@Resource(name = "IBCrrGntyConDAO")
	IBCrrGntyConDAO bcrrgntycondao;

	@Resource(name = "BNteNoticeMtgServiceImpl")
	IBNteNoticeMtgService bntenoticemtgservice;

	@Resource(name = "BCntMprotBaseInfoServiceImpl")
	IBCntMprotBaseInfoService bcntmprotbaseinfoservice;// 监管协议/担保提货协议/先票(款)后货协议信息表

	@Resource(name = "ABcpAppliImprestBussServiceImpl")
	IABcpAppliImprestBussService aBcpAppliImprestBussService;

	@Resource(name = "bCrrLnConService")
	IBCrrLnConService bCrrLnConService; // 信贷合同

	@Resource(name = "BCrrGntyConServiceImpl")
	IBCrrGntyConService bCrrGntyConService;

	// 押品信息
	@Resource(name = "BCntMprotBaseInfoServiceImpl")
	IBCntMprotBaseInfoService bCntMprotBaseInfoService;

	@Resource(name = "SBcpAppliLowerPriceServiceImpl")
	ISBcpAppliLowerPriceService sBcpAppliLowerPriceService;
	
	@Resource(name = "NRBcpAppliBussInfoServiceImpl")
	INRBcpAppliBussInfoService nrbcpapplibussinfoservice;

	@Transactional
	@Override
	public String addBNteNoticeBase(BNteNoticeBase bNteNoticeBase) throws ScubeBizException {
		// ScfCommonUtil.setCommonField(bNteNoticeBase);//设置公共字段 add by
		// huangshuidan 2016-11-11
		bNteNoticeBase.setId(UUIDGeneratorUtil.generate());
		com.huateng.scf.bas.nte.dao.model.BNteNoticeBase bNteNoticeBasedal = new com.huateng.scf.bas.nte.dao.model.BNteNoticeBase();
		try {
			BeanUtils.copyProperties(bNteNoticeBase, bNteNoticeBasedal);
		} catch (BeansException e) {
			log.error("通知书基本信息转换异常！");
			e.printStackTrace();
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BNteErrorConstant.SCF_BAS_NTE_10000), BNteErrorConstant.SCF_BAS_NTE_10000);
		}
		// TODO
		try {
			bNteNoticeBaseDAO.insertSelective(bNteNoticeBasedal);
		} catch (Exception e) {
			log.error("通知书基本信息插入异常！");
			e.printStackTrace();
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BNteErrorConstant.SCF_BAS_NTE_10001), BNteErrorConstant.SCF_BAS_NTE_10001);
		}
		return bNteNoticeBase.getId();
	}

	@Transactional
	@Override
	public int updateBNteNoticeBase(BNteNoticeBase bNteNoticeBase) throws ScubeBizException {
		// TODO Auto-generated method stub
		com.huateng.scf.bas.nte.dao.model.BNteNoticeBase bNteNoticeBasedal = new com.huateng.scf.bas.nte.dao.model.BNteNoticeBase();
		try {
			BeanUtils.copyProperties(bNteNoticeBase, bNteNoticeBasedal);
		} catch (BeansException e) {
			log.error("通知书基本信息转换异常！");
			e.printStackTrace();
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BNteErrorConstant.SCF_BAS_NTE_10000), BNteErrorConstant.SCF_BAS_NTE_10000);
		}
		int i = 0;
		try {
			i = bNteNoticeBaseDAO.updateByPrimaryKeySelective(bNteNoticeBasedal);
		} catch (Exception e) {
			log.error("通知书基本信息更新异常！");
			e.printStackTrace();
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BNteErrorConstant.SCF_BAS_NTE_10002), BNteErrorConstant.SCF_BAS_NTE_10002);
		}
		return i;
	}

	@Transactional
	@Override
	public int deleteBNteNoticeBase(String key) throws ScubeBizException {
		// TODO Auto-generated method stub
		int i = 0;
		try {
			i = bNteNoticeBaseDAO.deleteByPrimaryKey(key);
		} catch (Exception e) {
			log.error("通知书基本信息删除异常！");
			e.printStackTrace();
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BNteErrorConstant.SCF_BAS_NTE_10003), BNteErrorConstant.SCF_BAS_NTE_10003);
		}
		return i;
	}

	@Transactional
	@Override
	public BNteNoticeBase findBNteNoticeBaseByKey(String key) throws ScubeBizException {
		BNteNoticeBase bNteNoticeBase = new BNteNoticeBase();
		com.huateng.scf.bas.nte.dao.model.BNteNoticeBase bNteNoticeBasedal = new com.huateng.scf.bas.nte.dao.model.BNteNoticeBase();
		bNteNoticeBasedal = bNteNoticeBaseDAO.selectByPrimaryKey(key);
		try {
			BeanUtils.copyProperties(bNteNoticeBase, bNteNoticeBasedal);
		} catch (BeansException e) {
			log.error("通知书基本信息转换异常！");
			e.printStackTrace();
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BNteErrorConstant.SCF_BAS_NTE_10000), BNteErrorConstant.SCF_BAS_NTE_10000);
		}
		return bNteNoticeBase;
	}

	/**
	 * 通过APPNO和NOTICETYPE查找通知书
	 * 
	 * @param noticeBase
	 * @return
	 */
	@Override
	public List<BNteNoticeBase> findBNteNoticeBaseByAppno(BNteNoticeBase noticeBase) {
		// 条件bean转换
		com.huateng.scf.bas.nte.dao.model.BNteNoticeBase bNteNoticeBasedal = new com.huateng.scf.bas.nte.dao.model.BNteNoticeBase();
		try {
			BeanUtils.copyProperties(noticeBase, bNteNoticeBasedal);
		} catch (BeansException e) {
			log.error("通知书基本信息转换异常！");
			e.printStackTrace();
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BNteErrorConstant.SCF_BAS_NTE_10000), BNteErrorConstant.SCF_BAS_NTE_10000);
		}
		List<BNteNoticeBase> list = new ArrayList<BNteNoticeBase>();
		BNteNoticeBase bNteNoticeBase = null;
		List<com.huateng.scf.bas.nte.dao.model.BNteNoticeBase> listdal = bNteNoticeBaseDAO.findBNteNoticeBaseByAppno(bNteNoticeBasedal);
		for (com.huateng.scf.bas.nte.dao.model.BNteNoticeBase info : listdal) {
			bNteNoticeBase = new BNteNoticeBase();
			try {
				BeanUtils.copyProperties(info, bNteNoticeBase);
			} catch (BeansException e) {
				log.error("通知书基本信息转换异常！");
				e.printStackTrace();
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BNteErrorConstant.SCF_BAS_NTE_10000),
						BNteErrorConstant.SCF_BAS_NTE_10000);
			}
			list.add(bNteNoticeBase);
		}
		return list;
	}

	/**
	 * 根据appno删除对应的通知书
	 * 
	 * @param appno
	 * @return
	 */
	@Transactional
	@Override
	public void deleteBNteNoticeBaseByAppno(String appno) {
		// TODO Auto-generated method stub
		try {
			bNteNoticeBaseDAO.deleteBNteNoticeBaseByAppno(appno);
		} catch (Exception e) {
			log.error("通知书基本信息删除异常！");
			e.printStackTrace();
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BNteErrorConstant.SCF_BAS_NTE_10003), BNteErrorConstant.SCF_BAS_NTE_10003);
		}
	}

	/**
	 * 担保提货更改通知书状态公共方法
	 * 
	 * @param appno
	 * @param status
	 * @throws ScubeBizException
	 */
	@Transactional
	public void updaterNoticeStatus(String appno, String status) throws ScubeBizException {
		com.huateng.scf.bas.nte.dao.model.BNteNoticeBase noticeBaseQry = new com.huateng.scf.bas.nte.dao.model.BNteNoticeBase();
		noticeBaseQry.setAppno(appno);
		List<com.huateng.scf.bas.nte.dao.model.BNteNoticeBase> list = bNteNoticeBaseDAO.findBNteNoticeBaseByAppno(noticeBaseQry);
		com.huateng.scf.bas.nte.dao.model.BNteNoticeBase noticeBase = null;
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				noticeBase = (com.huateng.scf.bas.nte.dao.model.BNteNoticeBase) list.get(i);
				if (NoticeConstant.NOTICE_BASE_STATUS_CONFIRM_APPROVED.equals(status)) {
					// tblNoticeBaseInfo.setStatus(NoticeConstants.NOTICE_BASE_STATUS_CONFIRM_APPROVED);//已签发
					noticeBase.setSignDate(BSysConstant.WORKDATE);// 签发日期
				} else if (NoticeConstant.NOTICE_BASE_STATUS_CONFIRM_AGREE.equals(status)) {
					noticeBase.setStatus(NoticeConstant.NOTICE_BASE_STATUS_CONFIRM_AGREE);// 已回执
					noticeBase.setCommonDate(BSysConstant.WORKDATE);// 回执日期
				}
				try {
					bNteNoticeBaseDAO.updateByPrimaryKeySelective(noticeBase);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} else {
			log.error("申请基本信息:通知书信息丢失!");
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BNteErrorConstant.SCF_BAS_NTE_10004), BNteErrorConstant.SCF_BAS_NTE_10004);
		}
	}

	/**
	 * 保理催收 提示付款通知书
	 */
	@Transactional
	@Override
	public void savePromptPaymentNoticeInfo(String appno) throws ScubeBizException {

		BPbcAppliBaseInfo bPbcAppliBaseInfo = bPbcAppliBaseInfoService.findBPbcAppliBaseInfoByKey(appno);
		;
		if (bPbcAppliBaseInfo == null) {
			log.error("申请基本信息丢失");
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(ATcsErrorConstant.SCF_ADV_TCS_10002), ATcsErrorConstant.SCF_ADV_TCS_10002);
		}

		BNteNoticeBase bean = new BNteNoticeBase();
		bean.setAppno(bPbcAppliBaseInfo.getAppno());
		bean.setMastContno(bPbcAppliBaseInfo.getMastContno());
		bean.setCustcd(bPbcAppliBaseInfo.getCustcd());
		BCntBcpInfoVO bCntBcpInfoVO = null;
		String factType = null;
		// 通知书编号
		String noticeNo = "";
		if (StringUtil.isStrNotEmpty(bPbcAppliBaseInfo.getMastContno())) {
			bCntBcpInfoVO = bcntbcpinfoservice.queryBCntBcpInfoByMastContno(bPbcAppliBaseInfo.getMastContno());
			if (bCntBcpInfoVO != null) {
				factType = bCntBcpInfoVO.getFactType();
			}
		}

		if(ScfBasConstant.FACT_TYPE_INLAND.equals(factType) //国内保理
				|| ScfBasConstant.FACT_TYPE_REVERSE.equals(factType))//反向保理
		{
			bean.setNoticeType(NoticeConstant.NOTICE_TYPE_116);
			noticeNo = bSysSerialNoService.genSerialNo(ScfBasConstant.BUSSNO_TYPE_YSZK_T_NOTICE_NO);
		}
		else if(ScfBasConstant.FACT_TYPE_DEBT_POOL.equals(factType)// 保理池融资
				|| ScfBasConstant.FACT_TYPE_DEBT_POOL_PLEDGE.equals(factType) // 应收账款质押池融资
				|| ScfBasConstant.FACT_TYPE_EXPORT_POOL_PLEDGE.equals(factType))// 出口退税池质押融资
		{
			bean.setNoticeType(NoticeConstant.NOTICE_TYPE_117);
			noticeNo = bSysSerialNoService.genSerialNo(ScfBasConstant.BUSSNO_TYPE_YSZKC_T_NOTICE_NO);
		}
		else if(ScfBasConstant.FACT_TYPE_DOUBLE_FACT.equals(factType))
		{// 国内双保理
			bean.setNoticeType(NoticeConstant.NOTICE_TYPE_118);
			noticeNo = bSysSerialNoService.genSerialNo(ScfBasConstant.BUSSNO_TYPE_YSZK_T_NOTICE_NO);
		}
		else if(ScfBasConstant.FACT_TYPE_CREDIT_FACT.equals(factType))
		{// 信保保理
			bean.setNoticeType(NoticeConstant.NOTICE_TYPE_119);
			noticeNo = bSysSerialNoService.genSerialNo(ScfBasConstant.BUSSNO_TYPE_YSZK_T_NOTICE_NO);
		}
		else if(ScfBasConstant.FACT_TYPE_LEASE_FACT.equals(factType))
		{// 租赁保理
			bean.setNoticeType(NoticeConstant.NOTICE_TYPE_120);
			noticeNo = bSysSerialNoService.genSerialNo(ScfBasConstant.BUSSNO_TYPE_YSZK_T_NOTICE_NO);
		}
		else if(ScfBasConstant.FACT_TYPE_DEBT_PLEDGE.equals(factType))
		{// 应收账款质押
			bean.setNoticeType(NoticeConstant.NOTICE_TYPE_121);
			noticeNo = bSysSerialNoService.genSerialNo(ScfBasConstant.BUSSNO_TYPE_YSZK_T_NOTICE_NO);
		}
		List<RBcpAppliBussInfo> list = rBcpAppliBussInfoService.queryAppliBussInfoBillsNo(appno);// 获取申请基本信息
		if (list == null || list.size() <= 0) {
			log.error("申请信息获取失败");
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_20001), RBcpErrorConstant.SCF_REC_BCP_20001);
		}
		RBcpAppliBussInfo debtVO = (RBcpAppliBussInfo) list.get(0);
		bean.setCommonNum(String.valueOf(debtVO.getDebtNum()));// 发票份数
		bean.setAppliDate(BSysConstant.WORKDATE);
		bean.setSignDate(bean.getAppliDate());// 签发日
		bean.setBussType(debtVO.getBussType());
		bean.setCommonAmt(debtVO.getTotalDebtAmount());
		bean.setStatus(NoticeConstant.NOTICE_BASE_STATUS_UNCONFIRM);
		bean.setOtherCustcd(debtVO.getCustcdBuyer());
		bean.setCustName(bCrmBaseInfoDAO.selectById(bPbcAppliBaseInfo.getCustcd()).getCname());
		bean.setOtherCustName(bCrmBaseInfoDAO.selectById(debtVO.getCustcdBuyer()).getCname());
		bean.setTlrn(bPbcAppliBaseInfo.getAppTlrcd());
		// 分支行信息
		bean.setBrcode(bPbcAppliBaseInfo.getStartBrcode());

		bean.setNum(noticeNo); // 通知书编号
		this.addBNteNoticeBase(bean);

	}

	/***
	 * 根据申请编号保存通知书基本信息表 催收
	 */
	@Transactional
	@Override
	public void dealWithNoticeInfo(String appno) throws ScubeBizException {
		BPbcAppliBaseInfo bPbcAppliBaseInfo = bPbcAppliBaseInfoService.findBPbcAppliBaseInfoByKey(appno);
		;
		if (bPbcAppliBaseInfo == null) {
			log.error("申请基本信息丢失");
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(ATcsErrorConstant.SCF_ADV_TCS_10002), ATcsErrorConstant.SCF_ADV_TCS_10002);
		}

		String applyType = bPbcAppliBaseInfo.getAppliType();
		BNteNoticeBase bean = new BNteNoticeBase();

		bean.setAppno(bPbcAppliBaseInfo.getAppno());
		bean.setMastContno(bPbcAppliBaseInfo.getMastContno());
		bean.setCustcd(bPbcAppliBaseInfo.getCustcd());
		BCntBcpInfoVO bCntBcpInfoVO = null;
		String factType = null;
		// 通知书编号
		String noticeNo = "";
		if (StringUtil.isStrNotEmpty(bPbcAppliBaseInfo.getMastContno())) {
			bCntBcpInfoVO = bcntbcpinfoservice.queryBCntBcpInfoByMastContno(bPbcAppliBaseInfo.getMastContno());
			if (bCntBcpInfoVO != null) {
				factType = bCntBcpInfoVO.getFactType();
			}
		}
		if ((WorkflowConstant.APPLI_TYPE_DISPUTEINVOICESETAPPLY).equals(applyType))
		{// 商业纠纷设定申请
			bean.setNoticeType(NoticeConstant.NOTICE_TYPE_DISPUTEINVOICESETAPPLY);
		}
		else if ((WorkflowConstant.APPLI_TYPE_DISPUTEINVOICREMOVEAPPLY).equals(applyType))
		{// 商业纠纷解除申请
			bean.setNoticeType(NoticeConstant.NOTICE_TYPE_DISPUTEINVOICREMOVEAPPLY);
		}
		else if ((WorkflowConstant.APPLI_TYPE_DEBTPRESSINGAPPLY).equals(applyType)//应收账款催收
				|| WorkflowConstant.APPLI_TYPE_DEBTPOOLPRESSINGAPPLY.equals(applyType)//应收账款池融资催收
				|| WorkflowConstant.APPLI_TYPE_DEBTDOUBLEPRESSINGAPPLY.equals(applyType)//国内双保理催收
				|| WorkflowConstant.APPLI_TYPE_DEBTCREDITPRESSINGAPPLY.equals(applyType)//信保保理催收
				|| WorkflowConstant.APPLI_TYPE_DEBTLEASEPRESSINGAPPLY.equals(applyType))//租赁保理催收
		{
			// 催收
			if (ScfBasConstant.FACT_TYPE_INLAND.equals(factType) 
					|| ScfBasConstant.FACT_TYPE_REVERSE.equals(factType))
			{//国内保理，反向保理
				bean.setNoticeType(NoticeConstant.NOTICE_TYPE_33);
				noticeNo = bSysSerialNoService.genSerialNo(ScfBasConstant.BUSSNO_TYPE_YSZK_C_NOTICE_NO);
			}
			else if (ScfBasConstant.FACT_TYPE_DEBT_POOL.equals(factType) 
					|| ScfBasConstant.FACT_TYPE_DEBT_POOL_PLEDGE.equals(factType)
					|| ScfBasConstant.FACT_TYPE_EXPORT_POOL_PLEDGE.equals(factType))
			{//保理池融资、应收账款质押池融资、出口退税池质押融资
				bean.setNoticeType(NoticeConstant.NOTICE_TYPE_110);
				noticeNo = bSysSerialNoService.genSerialNo(ScfBasConstant.BUSSNO_TYPE_YSZKC_C_NOTICE_NO);
			}
			else if (ScfBasConstant.FACT_TYPE_DOUBLE_FACT.equals(factType))
			{//行内双保理
				bean.setNoticeType(NoticeConstant.NOTICE_TYPE_111);
				noticeNo = bSysSerialNoService.genSerialNo(ScfBasConstant.BUSSNO_TYPE_111_NOTICE_NO);
			}
			else if (ScfBasConstant.FACT_TYPE_CREDIT_FACT.equals(factType))
			{//信保保理
				bean.setNoticeType(NoticeConstant.NOTICE_TYPE_112);
				noticeNo = bSysSerialNoService.genSerialNo(ScfBasConstant.BUSSNO_TYPE_112_NOTICE_NO);
			}
			else if (ScfBasConstant.FACT_TYPE_LEASE_FACT.equals(factType))
			{//租赁保理
				bean.setNoticeType(NoticeConstant.NOTICE_TYPE_113);
				noticeNo = bSysSerialNoService.genSerialNo(ScfBasConstant.BUSSNO_TYPE_113_NOTICE_NO);
			}
			else if (ScfBasConstant.FACT_TYPE_DEBT_PLEDGE.equals(factType))
			{//应收账款质押
				bean.setNoticeType(NoticeConstant.NOTICE_TYPE_115);
				noticeNo = bSysSerialNoService.genSerialNo(ScfBasConstant.BUSSNO_TYPE_115_NOTICE_NO);
			}

		}
		List<RBcpAppliBussInfo> list = rBcpAppliBussInfoService.queryAppliBussInfoBillsNo(appno);// 获取申请基本信息
		if (list == null || list.size() <= 0) {
			log.error("申请信息获取失败");
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_20001), RBcpErrorConstant.SCF_REC_BCP_20001);
		}
		RBcpAppliBussInfo debtVO = (RBcpAppliBussInfo) list.get(0);
		// 争议以及解除
		bean.setCommonNum(String.valueOf(debtVO.getDebtNum()));// 发票份数
		bean.setAppliDate(BSysConstant.WORKDATE);// 申请日期
		bean.setSignDate(bean.getAppliDate());// 签发日期
		bean.setCommonAmt(debtVO.getTotalDebtAmount());// 争议金额
		bean.setTlrn(bPbcAppliBaseInfo.getAppTlrcd());
		bean.setBussType(debtVO.getBussType());
		// insertDate,pressMode,totalNum,totalAmount--催收的那些事
		// bean.setReasonType(debtVO.getReturnType());//催收方式

		bean.setMortgageChangeType(debtVO.getChargeType());// 费用收取方式
		bean.setBailAmount(debtVO.getAmount());// 费用总计
		if (StringUtil.isStrNotEmpty(debtVO.getCustcdBuyer())) {
			bean.setOtherCustcd(debtVO.getCustcdBuyer());
			bean.setOtherCustName(bCrmBaseInfoDAO.selectById(debtVO.getCustcdBuyer()).getCname());
		}
		if (StringUtil.isStrNotEmpty(bPbcAppliBaseInfo.getCustcd())) {
			bean.setCustName(bCrmBaseInfoDAO.selectById(bPbcAppliBaseInfo.getCustcd()).getCname());
		}
		bean.setStatus(NoticeConstant.NOTICE_BASE_STATUS_UNCONFIRM);
		// 分支行信息
		bean.setBrcode(bPbcAppliBaseInfo.getStartBrcode());
		bean.setNum(noticeNo); // 通知书编号
		this.addBNteNoticeBase(bean);

	}

	/**
	 * 更新通知书基础信息
	 */
	@Transactional
	@Override
	public void modifyNoticeBaseInfo(String appno, String noticeBaseStatus) {
		BNteNoticeBase bNteNoticeBase = new BNteNoticeBase();
		bNteNoticeBase.setAppno(appno);
		ScfGlobalInfo scfGlobalInfo = ScfBaseData.getScfGlobalInfoData();
		List<BNteNoticeBase> list = this.findBNteNoticeBaseByAppno(bNteNoticeBase);
		for (int i = 0; i < list.size(); i++) {
			BNteNoticeBase noticeBaseInfo = (BNteNoticeBase) list.get(i);
			noticeBaseInfo.setCommonDate(scfGlobalInfo.getTxnDate());// 监管公司(核库/巡库岗确认日期)回执日期
			noticeBaseInfo.setStatus(noticeBaseStatus);
			if (NoticeConstant.NOTICE_BASE_STATUS_CONFIRM_APPROVED.equals(noticeBaseStatus)) {
				noticeBaseInfo.setSignDate(scfGlobalInfo.getTxnDate());
			}
			// noticeBaseInfo.setTlrn(GlobalInfo.getCurrentInstance().getTlrno());
			BNteNoticeBase base = null;
			base = this.findBNteNoticeBaseByKey(noticeBaseInfo.getId());
			if (base != null) { // 更新
				BeanUtils.copyProperties(noticeBaseInfo, base);
				this.updateBNteNoticeBase(noticeBaseInfo);
			} else {// 新增
				base = new BNteNoticeBase();
				BeanUtils.copyProperties(noticeBaseInfo, base);
				this.addBNteNoticeBase(noticeBaseInfo);
			}
			// noticeBaseInfoDAO.getHibernateTemplate().merge(noticeBaseInfo);
		}

	}

	/**
	 * 通过appno生成核销通知书 addDebtCancelNoticeByAppno 方法
	 * 
	 * @param appno
	 * @throws ScubeBizException
	 */
	@Transactional
	public void addDebtCancelNoticeByAppno(String appno) throws ScubeBizException {
		// 获取Tbl_Appli_Buss_Info
		RBcpAppliBussInfo bcpAppliBussInfo = rBcpAppliBussInfoService.findByAppno(appno);
		AppliBussInfoVO debtVO = new AppliBussInfoVO();
		BeanUtils.copyProperties(bcpAppliBussInfo, debtVO);
		BigDecimal amount = debtVO.getTotalDebtAmount();
		// 调用应收账款管理公共方法
		this.saveFactoringNotice(debtVO, amount, NoticeConstant.NOTICE_TYPE_25);
	}

	/**
	 * 保理应收账款管理生成通知书 saveFactoringNotice 应收账款管理公共方法
	 * 
	 * @param debtVO//申请信息业务信息
	 * @param amount//折让、回改、核销、承购金额
	 * @param noticeType//通知书类型
	 * @throws ScubeBizException
	 */
	@Transactional
	@Override
	public void saveFactoringNotice(AppliBussInfoVO debtVO, BigDecimal amount, String noticeType) throws ScubeBizException
	{
		if (debtVO == null) {// 申请信息不存在
			throw new ScubeBizException("信息不存在，不能更新");
		}
		// 通知书编号
		String noticeNo = bSysSerialNoService.genSerialNo(ScfBasConstant.BUSSNO_TYPE_YSHX_T_NOTICE_NO);
		if(noticeType.equals(NoticeConstant.NOTICE_TYPE_17))
		{//折让
			noticeNo = bSysSerialNoService.genSerialNo(ScfBasConstant.BUSSNO_TYPE_YSZR_T_NOTICE_NO);
		}
		else if(noticeType.equals(NoticeConstant.NOTICE_TYPE_25))
		{//核销
			noticeNo = bSysSerialNoService.genSerialNo(ScfBasConstant.BUSSNO_TYPE_YSHX_T_NOTICE_NO);
		}
		BNteNoticeBase bNteNoticeBase = new BNteNoticeBase();
		bNteNoticeBase.setAppno(debtVO.getAppno());
		List<BNteNoticeBase> list = this.findBNteNoticeBaseByAppno(bNteNoticeBase);
		// 获取合同信息
		BCntBcpInfoVO bCntBcpInfoVO = bcntbcpinfoservice.queryBCntBcpInfoByMastContno(debtVO.getMastContno());
		if (bCntBcpInfoVO == null) {
			throw new ScubeBizException("保理合同信息丢失，无法生成相关信息");
		}
//		BCntBcpExtInfoVO bCntBcpExtInfoVO = bcntbcpextinfoservice.queryContDebtExInfoByMastContno(debtVO.getMastContno(), debtVO.getCustcdBuyer());
//		String factType = "";
//		String cont_noticeType = "";
//		if (bCntBcpInfoVO != null) {
//			factType = bCntBcpInfoVO.getFactType();
//			cont_noticeType = bCntBcpExtInfoVO.getNoticeType();
//			if (ScfBasConstant.FACT_TYPE_INLAND.equals(factType) || ScfBasConstant.FACT_TYPE_REVERSE.equals(factType))
//			{
//				if (StringUtil.isStrNotEmpty(cont_noticeType) && RBcpDebtConstant.FACTORY_NOTICE_TYPE.equals(cont_noticeType)) {
//					noticeType = NoticeConstant.NOTICE_TYPE_100;
//					// TODO
//					// String noticeNo;
//				} else if (RBcpDebtConstant.FACTORY_ONLY_NOTICE_TYPE.equals(cont_noticeType)) {
//					noticeType = NoticeConstant.NOTICE_TYPE_125;
//					// TODO
//					// String noticeNo;
//				} else {
//					noticeType = NoticeConstant.NOTICE_TYPE_13;
//					// TODO
//					// String noticeNo;
//				}
//			} else if (ScfBasConstant.FACT_TYPE_DEBT_POOL_PLEDGE.equals(factType) || ScfBasConstant.FACT_TYPE_DEBT_POOL.equals(factType)
//					|| ScfBasConstant.FACT_TYPE_EXPORT_POOL_PLEDGE.equals(factType)) {
//				if (StringUtil.isStrNotEmpty(cont_noticeType) && RBcpDebtConstant.FACTORY_NOTICE_TYPE.equals(cont_noticeType)) {
//					noticeType = NoticeConstant.NOTICE_TYPE_102;
//					// TODO
//					// String noticeNo;
//				} else if (RBcpDebtConstant.FACTORY_ONLY_NOTICE_TYPE.equals(cont_noticeType)) {
//					noticeType = NoticeConstant.NOTICE_TYPE_125;
//					// TODO
//					// String noticeNo;
//				} else {
//					noticeType = NoticeConstant.NOTICE_TYPE_101;
//					// TODO
//					// String noticeNo;
//				}
//			} else if (ScfBasConstant.FACT_TYPE_DOUBLE_FACT.equals(factType)) {
//				if (StringUtil.isStrNotEmpty(cont_noticeType) && RBcpDebtConstant.FACTORY_NOTICE_TYPE.equals(cont_noticeType)) {
//					noticeType = NoticeConstant.NOTICE_TYPE_104;
//					// TODO
//					// String noticeNo;
//				} else if (RBcpDebtConstant.FACTORY_ONLY_NOTICE_TYPE.equals(cont_noticeType)) {
//					noticeType = NoticeConstant.NOTICE_TYPE_125;
//					// TODO
//					// String noticeNo;
//				} else {
//					noticeType = NoticeConstant.NOTICE_TYPE_103;
//					// TODO
//					// String noticeNo;
//				}
//			} else if (ScfBasConstant.FACT_TYPE_CREDIT_FACT.equals(factType)) {
//				if (StringUtil.isStrNotEmpty(cont_noticeType) && RBcpDebtConstant.FACTORY_NOTICE_TYPE.equals(cont_noticeType)) {
//					noticeType = NoticeConstant.NOTICE_TYPE_106;
//					// TODO
//					// String noticeNo;
//				} else if (RBcpDebtConstant.FACTORY_ONLY_NOTICE_TYPE.equals(cont_noticeType)) {
//					noticeType = NoticeConstant.NOTICE_TYPE_125;
//					// TODO
//					// String noticeNo;
//				} else {
//					noticeType = NoticeConstant.NOTICE_TYPE_105;
//					// TODO
//					// String noticeNo;
//				}
//			} else if (ScfBasConstant.FACT_TYPE_LEASE_FACT.equals(factType)) {
//				noticeType = NoticeConstant.NOTICE_TYPE_107;
//				// TODO
//				// String noticeNo;
//			} else if (ScfBasConstant.FACT_TYPE_DEBT_PLEDGE.equals(factType)) {
//				noticeType = NoticeConstant.NOTICE_TYPE_114;
//				// TODO
//				// String noticeNo;
//			}

//		}
		// 开始存通知书表
		BNteNoticeBase noticeBaseInfo = null;
		if (list != null && list.size() < 1) {// 新增
			noticeBaseInfo = new BNteNoticeBase();
			noticeBaseInfo.setAppno(debtVO.getAppno());
			// String noticeNo =
			// bSysSerialNoService.genSerialNo(ScfBasConstant.BUSSNO_TYPE_SKQR_T_NOTICE_NO);
			noticeBaseInfo.setNum(noticeNo);
			noticeBaseInfo.setCommonAmt(amount);// 金额
			noticeBaseInfo.setBussType(debtVO.getBussType());// 业务品种
			noticeBaseInfo.setCustName(bCrmBaseInfoDAO.selectById(debtVO.getCustcdSaller()).getCname());
			noticeBaseInfo.setOtherCustName(bCrmBaseInfoDAO.selectById(debtVO.getCustcdBuyer()).getCname());
			noticeBaseInfo.setCommonNum(debtVO.getDebtNum().toString());//
			noticeBaseInfo.setMastContno(debtVO.getMastContno());// 主合同号
			noticeBaseInfo.setCustcd(debtVO.getCustcdSaller());// 卖方
			noticeBaseInfo.setOtherCustcd(debtVO.getCustcdBuyer());
			noticeBaseInfo.setNoticeType(noticeType);// 通知书类型
			noticeBaseInfo.setBrcode(bCntBcpInfoVO.getBrcode());// 经办机构
			noticeBaseInfo.setTlrn(ContextHolder.getUserInfo().getTlrNo());
			// noticeBaseInfo.setAppliDate(new Date());
			noticeBaseInfo.setAppliDate(ScfDateUtil.getStringDate(new Date()));// 申请日期
			// noticeBaseInfo.setSignDate(noticeBaseInfo.getAppliDate());//签发日
			noticeBaseInfo.setSignDate(ScfDateUtil.getStringDate(new Date()));// 签发日
			noticeBaseInfo.setStatus(NoticeConstant.NOTICE_BASE_STATUS_UNCONFIRM);
			this.addBNteNoticeBase(noticeBaseInfo);
		} else {// 修改状态
			noticeBaseInfo = (BNteNoticeBase) list.get(0);
			// noticeBaseInfo.setStatus(NoticeConstants.NOTICE_BASE_STATUS_CONFIRM_AGREE);
			noticeBaseInfo.setCommonAmt(amount);// 金额
			noticeBaseInfo.setCommonNum(debtVO.getDebtNum().toString());
			noticeBaseInfo.setNoticeType(noticeType);// 通知书类型
			noticeBaseInfo.setTlrn(ContextHolder.getUserInfo().getTlrNo());
			noticeBaseInfo.setAppliDate(ScfGlobalInfoUtil.getScfGlobalInfo().getTxnDate());// 申请日期
			this.updateBNteNoticeBase(noticeBaseInfo);
		}

	}

	/*
	 * 
	 * 
	 * 预付类，发货通知管理首页查询
	 */
	@Override
	public Page getAdvDeliveryNotifyByParam(int pageNo, int pageSize, NoticeQryVO noticeQryVO) throws ScubeBizException {
		Page page = new Page(pageSize, pageNo, 0);
		HashMap<String, Object> map = new HashMap<String, Object>();
		if (null != noticeQryVO) {
			String ext1 = noticeQryVO.getExt1();// 发货通知书编号
			String num = noticeQryVO.getNum();// 收款确认函编号
			String otherCustName = noticeQryVO.getOtherCustName();// 卖方名称
			String custName = noticeQryVO.getCustName();// 买方名称

			String appliDateFrom = noticeQryVO.getAppliDateFrom();// 发货日 从
			String appliDateTo = noticeQryVO.getAppliDateTo();// 发货日 到
			String commonDateFrom = noticeQryVO.getCommonDateFrom();// 收款确认日 从
			String commonDateTo = noticeQryVO.getCommonDateTo();// 收款确认日 到

			String ext2 = noticeQryVO.getExt2();// 发货通知状态

			map.put("ext1", ext1);
			map.put("num", num);
			map.put("otherCustName", otherCustName);
			map.put("custName", custName);

			map.put("appliDateFrom", appliDateFrom);
			map.put("appliDateTo", appliDateTo);
			map.put("commonDateFrom", commonDateFrom);
			map.put("commonDateTo", commonDateTo);

			map.put("ext2", ext2);

		}
		// 查询状态为‘已阅已确认的’收款确认通知书，发货通知书，借据信息多表联查
		try {
			bNteNoticeBaseDAO.getAdvDeliveryNotifyByParam(map, page);
		} catch (Exception e) {
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BNteErrorConstant.SCF_BAS_NTE_10007), BNteErrorConstant.SCF_BAS_NTE_10007);
		}

		return page;
	}

	/*
	 * 预付类发货通知管理-收款确认函查询
	 */
	@Override
	public Page getAdvDeliveryNotifyConfirmByParam(int pageNo, int pageSize, NoticeQryVO noticeQryVO) throws ScubeBizException {
		Page page = new Page(pageSize, pageNo, 0);
		HashMap<String, Object> map = new HashMap<String, Object>();
		if (null != noticeQryVO) {
			String custName = noticeQryVO.getCustName();// 买方名称
			String otherCustName = noticeQryVO.getOtherCustName();// 卖方名称
			String protocolCode = noticeQryVO.getProtocolCode();// 先票/款后货协议号
			String num = noticeQryVO.getNum();// 收款确认函编号（可查询唯一结果）

			String commonDateFrom = noticeQryVO.getCommonDateFrom();// 收款确认日 从
			String commonDateTo = noticeQryVO.getCommonDateTo();// 收款确认日 到
			String debetId = noticeQryVO.getDebetId();// 借据号/承兑协议号
			String appno = noticeQryVO.getAppno();// 申请号（可以查询到唯一结果）

			map.put("custName", custName);
			map.put("otherCustName", otherCustName);
			map.put("protocolCode", protocolCode);
			map.put("num", num);

			map.put("commonDateFrom", commonDateFrom);
			map.put("commonDateTo", commonDateTo);
			map.put("debetId", debetId);
			map.put("appno", appno);

		}
		// 查询收款确认的通知书和借据确认状态为 1 ‘已收到’ 的借据信息的多表联查
		try {
			bNteNoticeBaseDAO.getAdvDeliveryNotifyConfirmByParam(map, page);
		} catch (Exception e) {
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BNteErrorConstant.SCF_BAS_NTE_10008), BNteErrorConstant.SCF_BAS_NTE_10008);
		}

		return page;
	}

	/*
	 * 
	 * 
	 * 预付类发货通知管理-根据发货通知书编号，申请号查询对应发货通知书
	 */
	@Override
	public BNteNoticeBase getDeliveryNotifyByDeliveryNo(String deliveryNo, String appno) throws ScubeBizException {
		if (deliveryNo == null || "".equals(deliveryNo)) {
			return null;
		}
		BNteNoticeBaseExample bNteNoticeBaseExample = new BNteNoticeBaseExample();
		Criteria criteria = bNteNoticeBaseExample.createCriteria();
		criteria.andExt1EqualTo(deliveryNo);
		if (appno != null && !"".equals(appno)) {
			criteria.andAppnoNotEqualTo(appno);
		}
		try {
			List<com.huateng.scf.bas.nte.dao.model.BNteNoticeBase> bNteNoticeBaseList = bNteNoticeBaseDAO.selectByExample(bNteNoticeBaseExample);
			// 只要有数据就说明重复了，取出第一个返回
			if (bNteNoticeBaseList != null && bNteNoticeBaseList.size() > 0) {
				com.huateng.scf.bas.nte.dao.model.BNteNoticeBase bNteNoticeBase = bNteNoticeBaseList.get(0);
				BNteNoticeBase bNteNoticeBase2 = new BNteNoticeBase();
				BeanUtils.copyProperties(bNteNoticeBase, bNteNoticeBase2);
				return bNteNoticeBase2;
			} else {
				return null;
			}
		} catch (Exception e) {
			log.debug(e.getMessage());
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BNteErrorConstant.SCF_BAS_NTE_10009), BNteErrorConstant.SCF_BAS_NTE_10009);
		}

	}

	/**
	 * 保存通知书基础信息
	 * 
	 * @param bPbcAppliBaseInfo
	 * @param bCrrGntyCon
	 * @param bCntMprotBaseInfo
	 * @param mortgageChangeType
	 * @param noticeType
	 * @param noticeNo
	 *            --通知书编号
	 * @return
	 * @throws ScubeBizException
	 */
	@Transactional
	public String addNoticeBaseInfo(BPbcAppliBaseInfo bPbcAppliBaseInfo, BCrrGntyCon bCrrGntyCon, BCntMprotBaseInfo bCntMprotBaseInfo,
			String mortgageChangeType, String noticeType, String noticeNo) throws ScubeBizException {
		// 获取当前用户
		UserInfo user = ContextHolder.getUserInfo();
		String tlrNo = user.getTlrNo();
		String brCode = user.getBrNo();
		// 通知书基本信息表
		BNteNoticeBase bNteNoticeBase = new BNteNoticeBase();
		bNteNoticeBase.setAppno(bPbcAppliBaseInfo.getAppno());
		bNteNoticeBase.setMonitorProtocolNo(bCrrGntyCon.getPrtclNo());// 监管协议号
		bNteNoticeBase.setProtocolNo(bPbcAppliBaseInfo.getBusinessno());// 四方协议号
		bNteNoticeBase.setProtocolCode(bCntMprotBaseInfo.getProtocolCode() != null ? bCntMprotBaseInfo.getProtocolCode() : "");// 四方协议名称
		bNteNoticeBase.setSlaveContno(bPbcAppliBaseInfo.getSlaveContno());
		bNteNoticeBase.setSlaveContcode(bCrrGntyCon.getConId());
		bNteNoticeBase.setNoticeType(noticeType);
		bNteNoticeBase.setMortgageChangeType(mortgageChangeType);
		List<BCntMprotPartInfo> list1 = bCntMprotPartInfoService.findBCntMpartInfoByProtocolNo(bCntMprotBaseInfo.getProtocolNo());// 通过协议号查询参与方
		if (list1 != null && list1.size() > 0) {
			for (int i = 0; i < list1.size(); i++) {
				BCntMprotPartInfo mutiProtPartInfo = (BCntMprotPartInfo) list1.get(i);
				if (ScfBasConstant.PROTOCOL_PART_ROLE_CREDIT.equals(mutiProtPartInfo.getRole())) {// 授信客户
					bNteNoticeBase.setCustcd(mutiProtPartInfo.getCustcd());// 借款人
					bNteNoticeBase.setCustName(mutiProtPartInfo.getCname());
				} else if (ScfBasConstant.PROTOCOL_PART_ROLE_MONI.equals(mutiProtPartInfo.getRole())) {// 监管公司
					bNteNoticeBase.setMoniOfCustcd(mutiProtPartInfo.getCustcd());
					bNteNoticeBase.setMoniOfName(mutiProtPartInfo.getCname());
				} else if (ScfBasConstant.PROTOCOL_PART_ROLE_CORE.equals(mutiProtPartInfo.getRole())) {// 核心厂商
					bNteNoticeBase.setOtherCustcd(mutiProtPartInfo.getCustcd());//
					bNteNoticeBase.setOtherCustName(mutiProtPartInfo.getCname());
				} else if (ScfBasConstant.PROTOCOL_PART_ROLE_BACKCORE.equals(mutiProtPartInfo.getRole())) {// 回购厂商
				}
			}
		}

		bNteNoticeBase.setBrcode(brCode);// 签发机构
		bNteNoticeBase.setTlrn(tlrNo);// 签发人
		bNteNoticeBase.setAppliDate(BSysConstant.WORKDATE);// 日期
		if (NoticeConstant.NOTICE_TYPE_83.equals(noticeType)) {
			bNteNoticeBase.setStatus(NoticeConstant.NOTICE_BASE_STATUS_CONFIRM_APPROVED);// 已签发
		}
		bNteNoticeBase.setSignDate(BSysConstant.WORKDATE);// 签发日期
		bNteNoticeBase.setStatus(NoticeConstant.NOTICE_BASE_STATUS_UNCONFIRM);// 未签发
		bNteNoticeBase.setCommonAmt(bPbcAppliBaseInfo.getAmt());
		// bNteNoticeBase.setId(null);
		bNteNoticeBase.setNum(noticeNo);
		// TODO
		/*
		 * if(NoticeConstant.NOTICE_TYPE_1.equals(noticeType)){ List
		 * list=SCFDAOUtils.getTblAppliLowerPriceDAO().
		 * getMortgageUnderSlaveContList(bPbcAppliBaseInfo.getAppno());
		 * if(list!=null&&list.size()>0){ TblAppliLowerPrice
		 * tblAppliLowerPrice=(TblAppliLowerPrice)list.get(0);
		 * bNteNoticeBase.setExt1Amount(tblAppliLowerPrice.getLowPriceNew());//
		 * 监管下限
		 * bNteNoticeBase.setExt2Amount(bCrrGntyCon.getLowPriceNew());//jiu监管下限
		 * }else{ bNteNoticeBase.setExt1Amount(new BigDecimal(0.00));
		 * bNteNoticeBase.setExt2Amount(new BigDecimal(0.00));//jiu监管下限 } }
		 */
		if (NoticeConstant.NOTICE_TYPE_22.equals(noticeType)) {
			bNteNoticeBase.setExt1Amount(bPbcAppliBaseInfo.getAmt());
		}
		if (NoticeConstant.NOTICE_TYPE_83.equals(noticeType)) {
			bNteNoticeBase.setExt1Amount(bPbcAppliBaseInfo.getAmt());
		}

		// 通知书基本表中存入业务品种 add by changhao.huang 2013-9-13
		// 通知书基本表中存入业务品种
		String productId = "";
		if (bPbcAppliBaseInfo != null) {
			productId = bPbcAppliBaseInfo.getSupplyChainPdId();
			bNteNoticeBase.setBussType(productId);
		}

		// bNteNoticeBase.setSignDate(null);
		String id = this.addBNteNoticeBase(bNteNoticeBase);

		return id;
	}

	/*
	 * 
	 */
	@Override
	@Transactional
	public BNteNoticeBase saveDeliveryNotify(BNteNoticeBase deliveryNotify, List<BNteNoticeMtg> bNteNoticeMtgList) throws ScubeBizException {
		// 1.校验数据
		if (deliveryNotify == null || bNteNoticeMtgList == null || bNteNoticeMtgList.size() == 0) {
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BNteErrorConstant.SCF_BAS_NTE_10005), BNteErrorConstant.SCF_BAS_NTE_10005);
		}
		// 2.如果有appno则是修改操作
		if (deliveryNotify.getAppno() != null && !"".equals(deliveryNotify.getAppno())) {
			this.updateDeliveryNotify(deliveryNotify, bNteNoticeMtgList);
		} else {
			// 3.如果没有appno则是新增操作-------
			String brcode = ContextHolder.getOrgInfo().getBrNo();
			String tlrNo = ContextHolder.getUserInfo().getTlrNo();
			// 1、保存通知书基本表TblNoticeBaseInfo
			com.huateng.scf.bas.nte.dao.model.BNteNoticeBase bNteNoticeBase = new com.huateng.scf.bas.nte.dao.model.BNteNoticeBase();
			String pid = UUIDGeneratorUtil.generate();
			String appno = bSysSerialNoService.genSerialNo(ScfBasConstant.VALUE_INDEX_APP_NO);
			String num = bSysSerialNoService.genSerialNo(ScfBasConstant.BUSSNO_TYPE_YFFU_T_NOTICE_NO);
			deliveryNotify.setId(pid);
			deliveryNotify.setAppno(appno);
			deliveryNotify.setNum(num);// 通知书编号
			deliveryNotify.setStatus("00");// 00 - 记录为已录入
			deliveryNotify.setNoticeType(NoticeConstant.NOTICE_TYPE_122);// 发货通知书
			deliveryNotify.setProtocolNo(deliveryNotify.getProtocolCode());
			deliveryNotify.setExt2(deliveryNotify.getStatus());
			deliveryNotify.setBussType(ScfBasConstant.PRODUCT_TYPE_XPHH);// 先票后货
			deliveryNotify.setSignDate(BSysConstant.WORKDATE);
			deliveryNotify.setTlrn(tlrNo);
			deliveryNotify.setBrcode(brcode);

			// 监管公司号,名称,监管协议号
			DeliveryApplyQryVO deliveryApplyQryVO = new DeliveryApplyQryVO();
			deliveryApplyQryVO.setProtocolNo(deliveryNotify.getProtocolCode());
			deliveryApplyQryVO.setRole_Q(ScfBasConstant.PROTOCOL_PART_ROLE_MONI);
			BCntMprotPartInfo BCntMprotPartInfo2 = bCntMprotPartInfoService.getMoniMutiProtPartInfoByProAndRole(deliveryApplyQryVO);
			if (BCntMprotPartInfo2 != null) {
				deliveryNotify.setMoniOfCustcd(BCntMprotPartInfo2.getCustcd());
				deliveryNotify.setMoniOfName(BCntMprotPartInfo2.getCname());
				deliveryNotify.setMonitorProtocolNo(BCntMprotPartInfo2.getProtocolNo());
			}

			BeanUtils.copyProperties(deliveryNotify, bNteNoticeBase);
			bNteNoticeBaseDAO.insert(bNteNoticeBase);

			// 2、保存通知书押品关联表TblNoticeMortgageInfo
			for (BNteNoticeMtg bNteNoticeMtg1 : bNteNoticeMtgList) {
				com.huateng.scf.bas.nte.dao.model.BNteNoticeMtg bNteNoticeMtg = new com.huateng.scf.bas.nte.dao.model.BNteNoticeMtg();
				BeanUtils.copyProperties(bNteNoticeMtg1, bNteNoticeMtg);
				bNteNoticeMtg.setId(UUIDGeneratorUtil.generate());
				bNteNoticeMtg.setPid(pid);
				bNteNoticeMtg.setAppno(appno);
				bNteNoticeMtg.setMortgageNo(bSysSerialNoService.genSerialNo(ScfBasConstant.MORTGAGE_NO));
				bNteNoticeMtg.setBalQuantity(bNteNoticeMtg.getQuantity());
				bNteNoticeMtgDAO.insert(bNteNoticeMtg);
			}
		}
		return deliveryNotify;
	}

	/*
	 * 
	 */
	@Override
	@Transactional
	public void updateDeliveryNotify(BNteNoticeBase deliveryNotify, List<BNteNoticeMtg> bNteNoticeMtgList) throws ScubeBizException {

		BNteNoticeBase bNteNoticeBase2 = getDeliveryNotifyByDeliveryNo(deliveryNotify.getExt1(), deliveryNotify.getAppno());
		if (bNteNoticeBase2 != null) {
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BNteErrorConstant.SCF_BAS_NTE_10006), BNteErrorConstant.SCF_BAS_NTE_10006);
		}
		com.huateng.scf.bas.nte.dao.model.BNteNoticeBase bNteNoticeBase1 = bNteNoticeBaseDAO.selectByPrimaryKey(deliveryNotify.getId());
		bNteNoticeBase1.setExt1(deliveryNotify.getExt1());// 发货通知书编号
		bNteNoticeBase1.setAppliDate(deliveryNotify.getAppliDate());// 发货日期
		bNteNoticeBase1.setDeliveryQuantity(deliveryNotify.getDeliveryQuantity());// 本次发货数量
		bNteNoticeBase1.setDeliveryAmt(deliveryNotify.getDeliveryAmt());// 本次发货金额
		bNteNoticeBase1.setBalanceAmt(deliveryNotify.getBalanceAmt());// 发货剩余金额（已经在页面计算好了减去了此次发货金额）
		bNteNoticeBase1.setStatus(deliveryNotify.getStatus());// 状态
		bNteNoticeBase1.setExt2(deliveryNotify.getExt2());
		if (deliveryNotify.getCommonDate() != null) {
			bNteNoticeBase1.setCommonDate(deliveryNotify.getCommonDate());
		}
		bNteNoticeBaseDAO.updateByPrimaryKey(bNteNoticeBase1);

		BNteNoticeMtgExample bNteNoticeMtgExample = new BNteNoticeMtgExample();
		bNteNoticeMtgExample.createCriteria().andPidEqualTo(deliveryNotify.getId());
		bNteNoticeMtgDAO.deleteByExample(bNteNoticeMtgExample);

		for (BNteNoticeMtg bNteNoticeMtg1 : bNteNoticeMtgList) {
			com.huateng.scf.bas.nte.dao.model.BNteNoticeMtg bNteNoticeMtg = new com.huateng.scf.bas.nte.dao.model.BNteNoticeMtg();
			BeanUtils.copyProperties(bNteNoticeMtg1, bNteNoticeMtg);
			bNteNoticeMtg.setId(UUIDGeneratorUtil.generate());
			bNteNoticeMtg.setPid(deliveryNotify.getId());
			bNteNoticeMtg.setAppno(deliveryNotify.getAppno());
			bNteNoticeMtg.setMortgageNo(bSysSerialNoService.genSerialNo(ScfBasConstant.MORTGAGE_NO));
			bNteNoticeMtg.setBalQuantity(bNteNoticeMtg.getQuantity());
			bNteNoticeMtgDAO.insert(bNteNoticeMtg);
		}
		return;
	}

	/*
	 * 
	 */
	@Override
	@Transactional
	public void submitDeliveryNotify(BNteNoticeBase deliveryNotify, List<BNteNoticeMtg> bNteNoticeMtgList) throws ScubeBizException {
		// 1.校验数据
		if (deliveryNotify == null || bNteNoticeMtgList == null || bNteNoticeMtgList.size() == 0) {
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BNteErrorConstant.SCF_BAS_NTE_10005), BNteErrorConstant.SCF_BAS_NTE_10005);
		}
		BNteNoticeBase bNteNoticeBase2 = getDeliveryNotifyByDeliveryNo(deliveryNotify.getExt1(), deliveryNotify.getAppno());
		if (bNteNoticeBase2 != null) {
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BNteErrorConstant.SCF_BAS_NTE_10006), BNteErrorConstant.SCF_BAS_NTE_10006);
		}
		deliveryNotify.setExt2("01");// 01 - 记录为已提交
		deliveryNotify.setCommonDate(BSysConstant.WORKDATE);
		// 2.如果有appno则是修改操作
		if (deliveryNotify.getAppno() != null && !"".equals(deliveryNotify.getAppno())) {
			this.updateDeliveryNotify(deliveryNotify, bNteNoticeMtgList);
		} else {
			// 3.如果没有appno则是新增操作-------
			String brcode = ContextHolder.getOrgInfo().getBrNo();
			String tlrNo = ContextHolder.getUserInfo().getTlrNo();
			// 1、保存通知书基本表TblNoticeBaseInfo
			com.huateng.scf.bas.nte.dao.model.BNteNoticeBase bNteNoticeBase = new com.huateng.scf.bas.nte.dao.model.BNteNoticeBase();
			String pid = UUIDGeneratorUtil.generate();
			String appno = bSysSerialNoService.genSerialNo(ScfBasConstant.VALUE_INDEX_APP_NO);
			String num = bSysSerialNoService.genSerialNo(ScfBasConstant.BUSSNO_TYPE_YFFU_T_NOTICE_NO);
			deliveryNotify.setId(pid);
			deliveryNotify.setAppno(appno);
			deliveryNotify.setNum(num);// 通知书编号
			deliveryNotify.setStatus("00");
			deliveryNotify.setNoticeType(NoticeConstant.NOTICE_TYPE_122);// 发货通知书
			deliveryNotify.setProtocolNo(deliveryNotify.getProtocolCode());
			deliveryNotify.setBussType(ScfBasConstant.PRODUCT_TYPE_XPHH);// 先票后货
			deliveryNotify.setSignDate(BSysConstant.WORKDATE);
			deliveryNotify.setTlrn(tlrNo);
			deliveryNotify.setBrcode(brcode);

			// 监管公司号,名称,监管协议号
			DeliveryApplyQryVO deliveryApplyQryVO = new DeliveryApplyQryVO();
			deliveryApplyQryVO.setProtocolNo(deliveryNotify.getProtocolCode());
			deliveryApplyQryVO.setRole_Q(ScfBasConstant.PROTOCOL_PART_ROLE_MONI);
			BCntMprotPartInfo BCntMprotPartInfo2 = bCntMprotPartInfoService.getMoniMutiProtPartInfoByProAndRole(deliveryApplyQryVO);
			if (BCntMprotPartInfo2 != null) {
				deliveryNotify.setMoniOfCustcd(BCntMprotPartInfo2.getCustcd());
				deliveryNotify.setMoniOfName(BCntMprotPartInfo2.getCname());
				deliveryNotify.setMonitorProtocolNo(BCntMprotPartInfo2.getProtocolNo());
			}

			BeanUtils.copyProperties(deliveryNotify, bNteNoticeBase);
			bNteNoticeBaseDAO.insert(bNteNoticeBase);

			// 2、保存通知书押品关联表TblNoticeMortgageInfo
			for (BNteNoticeMtg bNteNoticeMtg1 : bNteNoticeMtgList) {
				com.huateng.scf.bas.nte.dao.model.BNteNoticeMtg bNteNoticeMtg = new com.huateng.scf.bas.nte.dao.model.BNteNoticeMtg();
				BeanUtils.copyProperties(bNteNoticeMtg1, bNteNoticeMtg);
				bNteNoticeMtg.setId(UUIDGeneratorUtil.generate());
				bNteNoticeMtg.setPid(pid);
				bNteNoticeMtg.setAppno(appno);
				bNteNoticeMtg.setMortgageNo(bSysSerialNoService.genSerialNo(ScfBasConstant.MORTGAGE_NO));
				bNteNoticeMtg.setBalQuantity(bNteNoticeMtg.getQuantity());
				bNteNoticeMtgDAO.insert(bNteNoticeMtg);
			}
		}
		// 3、更新协议已出质金额 BCntMprotDealInfo
		BigDecimal deliveryAmt = deliveryNotify.getDeliveryAmt();// 本次发货总价值
		BCntMprotDealInfoExample bCntMprotDealInfoExample = new BCntMprotDealInfoExample();
		bCntMprotDealInfoExample.createCriteria().andProtocolNoEqualTo(deliveryNotify.getProtocolCode());
		List<BCntMprotDealInfo> bCntMprotDealInfoList = bCntMprotDealInfoDAO.selectByExample(bCntMprotDealInfoExample);
		if (bCntMprotDealInfoList != null && bCntMprotDealInfoList.size() == 1) {
			BCntMprotDealInfo bCntMprotDealInfo = bCntMprotDealInfoList.get(0);
			BigDecimal amount = (bCntMprotDealInfo.getPledgeAmt() == null ? new BigDecimal("0") : bCntMprotDealInfo.getPledgeAmt()).add(deliveryAmt);
			bCntMprotDealInfo.setPledgeAmt(amount);
			bCntMprotDealInfoDAO.updateByPrimaryKey(bCntMprotDealInfo);
		}
		// 4、更新借据表：累计发货金额、剩余发货金额
		BLanLnciBase bLanLnciBase = bLanLnciBaseService.findBLanLnciBaseByDebtId(deliveryNotify.getDebetId());
		if (bLanLnciBase != null) {
			// 累计发货金额=上次累计发货金额+本次发货金额
			BigDecimal amt = (bLanLnciBase.getAccuSendAmt() == null ? BigDecimal.ZERO : bLanLnciBase.getAccuSendAmt()).add(deliveryAmt);
			// 剩余发货金额=借据金额-累计发货金额（包括本次发货金额）
			BigDecimal balSendAmt = bLanLnciBase.getLnciAmt().subtract(amt);
			// 如果小于0
			if (balSendAmt.compareTo(new BigDecimal(0)) == -1) {
				throw new ScubeBizException("剩余发货金额不足以此次发货！");
			}
			bLanLnciBase.setAccuSendAmt(amt);
			bLanLnciBase.setBalSendAmt(balSendAmt);
			BLanLnciBase bLanLnciBase2 = new com.huateng.scf.bas.lan.model.BLanLnciBase();
			BeanUtils.copyProperties(bLanLnciBase, bLanLnciBase2);
			bLanLnciBaseService.updateBLanLnciBase(bLanLnciBase2);
		}
		// 5.购销合同未将发货的对应货物数量减去 TODO
		return;
	}

	/*
	 * 删除发货通知书（以及相关的通知书押品关联表）
	 */
	@Override
	@Transactional
	public void deleteDeliveryNotify(BNteNoticeBase deliveryNotify) throws ScubeBizException {
		if (deliveryNotify == null) {
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BNteErrorConstant.SCF_BAS_NTE_10005), BNteErrorConstant.SCF_BAS_NTE_10005);
		}

		BNteNoticeBaseExample bNteNoticeBaseExample = new BNteNoticeBaseExample();
		Criteria createCriteria = bNteNoticeBaseExample.createCriteria();
		// 发货通知书编号（客户手写的不是序列号生成的）
		if (deliveryNotify.getExt1() != null && !"".equals(deliveryNotify.getExt1())) {
			createCriteria.andExt1EqualTo(deliveryNotify.getExt1());
		}
		if (deliveryNotify.getAppno() != null && !"".equals(deliveryNotify.getAppno())) {
			createCriteria.andAppnoEqualTo(deliveryNotify.getAppno());
		}
		try {
			bNteNoticeBaseDAO.deleteByExample(bNteNoticeBaseExample);
		} catch (Exception e) {
			log.debug(e.getMessage());
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BNteErrorConstant.SCF_BAS_NTE_10010), BNteErrorConstant.SCF_BAS_NTE_10010);
		}
		BNteNoticeMtgExample bNteNoticeMtgExample = new BNteNoticeMtgExample();
		com.huateng.scf.bas.nte.dao.model.BNteNoticeMtgExample.Criteria createCriteria2 = bNteNoticeMtgExample.createCriteria();
		if (deliveryNotify.getAppno() != null && !"".equals(deliveryNotify.getAppno())) {
			createCriteria2.andAppnoEqualTo(deliveryNotify.getAppno());
		}
		if (deliveryNotify.getId() != null && !"".equals(deliveryNotify.getId())) {
			createCriteria2.andPidEqualTo(deliveryNotify.getId());
		}
		try {
			bNteNoticeMtgDAO.deleteByExample(bNteNoticeMtgExample);
		} catch (Exception e) {
			log.debug(e.getMessage());
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BNteErrorConstant.SCF_BAS_NTE_10010), BNteErrorConstant.SCF_BAS_NTE_10010);
		}

		return;
	}

	/*
	 * 提交发货通知书（预付类发货通知书管理首页提交按钮）
	 */
	@Override
	@Transactional
	public void submitDeliveryNotify2(BNteNoticeBase deliveryNotify) throws ScubeBizException {
		if (deliveryNotify == null) {
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BNteErrorConstant.SCF_BAS_NTE_10005), BNteErrorConstant.SCF_BAS_NTE_10005);
		}
		BNteNoticeBaseExample bNteNoticeBaseExample = new BNteNoticeBaseExample();
		Criteria createCriteria = bNteNoticeBaseExample.createCriteria();
		// 发货通知书编号
		if (deliveryNotify.getExt1() != null && !"".equals(deliveryNotify.getExt1())) {
			createCriteria.andExt1EqualTo(deliveryNotify.getExt1());
		}
		if (deliveryNotify.getAppno() != null && !"".equals(deliveryNotify.getAppno())) {
			createCriteria.andAppnoEqualTo(deliveryNotify.getAppno());
		}
		try {
			List<com.huateng.scf.bas.nte.dao.model.BNteNoticeBase> bNteNoticeBaseList = bNteNoticeBaseDAO.selectByExample(bNteNoticeBaseExample);
			if (bNteNoticeBaseList != null && bNteNoticeBaseList.size() == 1) {
				com.huateng.scf.bas.nte.dao.model.BNteNoticeBase bNteNoticeBase = bNteNoticeBaseList.get(0);
				// 3、更新协议已出质金额 BCntMprotDealInfo
				BigDecimal deliveryAmt = bNteNoticeBase.getDeliveryAmt();// 本次发货总价值
				BCntMprotDealInfoExample bCntMprotDealInfoExample = new BCntMprotDealInfoExample();
				bCntMprotDealInfoExample.createCriteria().andProtocolNoEqualTo(bNteNoticeBase.getProtocolCode());
				List<BCntMprotDealInfo> bCntMprotDealInfoList = bCntMprotDealInfoDAO.selectByExample(bCntMprotDealInfoExample);
				if (bCntMprotDealInfoList != null && bCntMprotDealInfoList.size() == 1) {
					BCntMprotDealInfo bCntMprotDealInfo = bCntMprotDealInfoList.get(0);
					BigDecimal amount = (bCntMprotDealInfo.getPledgeAmt() == null ? new BigDecimal("0") : bCntMprotDealInfo.getPledgeAmt())
							.add(deliveryAmt);
					bCntMprotDealInfo.setPledgeAmt(amount);
					bCntMprotDealInfoDAO.updateByPrimaryKey(bCntMprotDealInfo);
				}
				// 4、更新借据表：累计发货金额、剩余发货金额
				BLanLnciBase bLanLnciBase = bLanLnciBaseService.findBLanLnciBaseByDebtId(bNteNoticeBase.getDebetId());
				BigDecimal balSendAmt = new BigDecimal(0);
				if (bLanLnciBase != null) {
					// 累计发货金额=上次累计发货金额+本次发货金额
					BigDecimal amt = (bLanLnciBase.getAccuSendAmt() == null ? BigDecimal.ZERO : bLanLnciBase.getAccuSendAmt()).add(deliveryAmt);
					// 剩余发货金额=借据金额-累计发货金额（包括本次发货金额）
					balSendAmt = bLanLnciBase.getLnciAmt().subtract(amt);
					bLanLnciBase.setAccuSendAmt(amt);
					bLanLnciBase.setBalSendAmt(balSendAmt);
					BLanLnciBase bLanLnciBase2 = new com.huateng.scf.bas.lan.model.BLanLnciBase();
					BeanUtils.copyProperties(bLanLnciBase, bLanLnciBase2);
					bLanLnciBaseService.updateBLanLnciBase(bLanLnciBase2);
				}
				// 5.购销合同未将发货的对应货物数量减去 TODO
				// 正式保存剩余发货金额
				bNteNoticeBase.setExt2("01");// 提交状态
				bNteNoticeBase.setCommonDate(BSysConstant.WORKDATE);
				bNteNoticeBase.setBalanceAmt(balSendAmt);
				bNteNoticeBaseDAO.updateByPrimaryKey(bNteNoticeBase);
			} else {
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BNteErrorConstant.SCF_BAS_NTE_10011),
						BNteErrorConstant.SCF_BAS_NTE_10011);
			}
		} catch (Exception e) {
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BNteErrorConstant.SCF_BAS_NTE_10011), BNteErrorConstant.SCF_BAS_NTE_10011);
		}
		return;
	}

	/**
	 * 
	 * @Description: 非标准仓单质押通知书
	 * @author huangshan
	 * @Created 2014-3-10上午10:24:43
	 * @param appno,noticeType,bussVO
	 * @throws ScubeBizException
	 */
	@Override
	public void saveBillNormalNoticeInfo(String appno, String noticeType, BillStandardBussInfoVO bussVO) throws ScubeBizException {
		BPbcAppliBaseInfo tblAppliBaseInfo = bPbcAppliBaseInfoService.findBPbcAppliBaseInfoByKey(appno);
		com.huateng.scf.bas.nte.dao.model.BNteNoticeBase bean = new com.huateng.scf.bas.nte.dao.model.BNteNoticeBase();
		// 删除旧的数据
		List<BNteNoticeBase> oldNoticBaseInfoList = this.getNoticeInfoByAppnoAndNoticeType(appno, noticeType);
		if (oldNoticBaseInfoList != null && oldNoticBaseInfoList.size() > 0) {
			for (BNteNoticeBase oldNoticeInfo : oldNoticBaseInfoList) {
				bNteNoticeBaseDAO.deleteByPrimaryKey(oldNoticeInfo.getId());
			}
		}

		String noticeNo = bSysSerialNoService.genSerialNo(ScfBasConstant.BUSSNO_TYPE_FBCD_ZY_NOTICE_NO);
		bean.setNum(noticeNo);
		bean.setId(UUIDGeneratorUtil.generate());
		bean.setAppno(bussVO.getAppno());
		bean.setMastContno(bussVO.getMastContno());
		bean.setProtocolNo(bussVO.getProtocolNo());
		bean.setMonitorProtocolNo(bussVO.getProtocolNo());
		bean.setProtocolCode(bussVO.getProtocolNo());
		bean.setSlaveContno(bussVO.getSlaveContno());
		bean.setSlaveContcode(bussVO.getSlaveContno());
		bean.setCustcd(bussVO.getCustcd());
		if (noticeType == NoticeConstant.NOTICE_TYPE_140) {
			bean.setMoniOfName(bussVO.getExt2());
		} else {
			bean.setMoniOfCustcd(bussVO.getExt1());
			bean.setMoniOfName(bCrmBaseInfoDAO.selectById(bussVO.getExt1()).getCname());
		}
		bean.setCustName(bCrmBaseInfoDAO.selectById(bussVO.getCustcd()).getCname());
		bean.setNoticeType(noticeType);
		bean.setAppliDate(ScfDateUtil.formatDate(tblAppliBaseInfo.getStartTime()));// 时间
		bean.setSignDate(null);
		bean.setCommonDate(null); // 确认日期
		AppliMortgageBaseQryVO commonQueryVo = new AppliMortgageBaseQryVO();
		commonQueryVo.setAppno_Q(appno);
		bean.setCommonAmt(bpbcapplimtginfoservice.getAppliMortgageTotalPrice(commonQueryVo));// 金额
		bean.setBrcode(tblAppliBaseInfo.getStartBrcode());
		bean.setTlrn(tblAppliBaseInfo.getStartTlrcd());
		bean.setBussType(tblAppliBaseInfo.getSupplyChainPdId());// 业务类型
		bean.setStatus(NoticeConstant.NOTICE_BASE_STATUS_UNCONFIRM);
		bNteNoticeBaseDAO.insertSelective(bean);
	}

	/**
	 * 非标准仓单置换通知书
	 * 
	 * @param appno
	 * @param noticeType
	 * @param bussVO
	 * @param status
	 * @throws ScubeBizException
	 * @author mengjiajia
	 * @date 2017年5月9日上午11:18:38
	 */
	@Override
	public void saveBillNormalNoticeInfo(String appno, String noticeType, BillStandardBussInfoVO bussVO, String status) throws ScubeBizException {
		BPbcAppliBaseInfo tblAppliBaseInfo = bPbcAppliBaseInfoService.findBPbcAppliBaseInfoByKey(appno);
		// String applyType = tblAppliBaseInfo.getAppliType();
		BNteNoticeBase bean = new BNteNoticeBase();
		// 删除旧的数据
		List<BNteNoticeBase> oldNoticBaseInfoList = this.getNoticeInfoByAppnoAndNoticeType(appno, noticeType);
		if (oldNoticBaseInfoList != null && oldNoticBaseInfoList.size() > 0) {
			for (BNteNoticeBase oldNoticeInfo : oldNoticBaseInfoList) {
				bNteNoticeBaseDAO.deleteByPrimaryKey(oldNoticeInfo.getId());
			}
		}

		String noticeNum = bSysSerialNoService.genSerialNo(ScfBasConstant.BUSSNO_TYPE_FBCD_ZY_NOTICE_NO);
		bean.setNum(noticeNum);
		bean.setAppno(bussVO.getAppno());
		bean.setMastContno(bussVO.getMastContno());
		bean.setProtocolNo(bussVO.getProtocolNo());
		bean.setMonitorProtocolNo(bussVO.getProtocolNo());
		bean.setProtocolCode(bussVO.getProtocolNo());
		bean.setSlaveContno(bussVO.getSlaveContno());
		bean.setSlaveContcode(bussVO.getSlaveContcode());
		bean.setCustcd(bussVO.getCustcd());
		if (noticeType == NoticeConstant.NOTICE_TYPE_140) {
			bean.setMoniOfName(bussVO.getExt2());
		} else {
			bean.setMoniOfCustcd(bussVO.getExt1());
			bean.setMoniOfName(bCrmBaseInfoDAO.selectById(bussVO.getExt1()).getCname());
		}
		bean.setCustName(bCrmBaseInfoDAO.selectById(bussVO.getCustcd()).getCname());
		// bean.setNoticeType(NoticeConstants.NOTICE_TYPE_ORDER_DEBE_REVERSE);
		bean.setNoticeType(noticeType);
		// bean.setCommonNum(String.valueOf(appliBussInfo.getBillsNum()));//份数
		bean.setAppliDate(ScfDateUtil.getStringDate(tblAppliBaseInfo.getStartTime()));// 时间
		bean.setSignDate(null);
		bean.setCommonDate(null); // 确认日期
		AppliMortgageBaseQryVO commonQueryVo = new AppliMortgageBaseQryVO();
		commonQueryVo.setAppno(appno);
		commonQueryVo.setStatus(status);
		bean.setCommonAmt(bpbcapplimtginfoservice.getExchangeTotalPrice(commonQueryVo));// 金额
		bean.setBrcode(tblAppliBaseInfo.getStartBrcode());
		bean.setTlrn(tblAppliBaseInfo.getStartTlrcd());
		bean.setBussType(tblAppliBaseInfo.getSupplyChainPdId());// 业务类型
		bean.setStatus(NoticeConstant.NOTICE_BASE_STATUS_UNCONFIRM);

		this.addBNteNoticeBase(bean);
	}

	/**
	 * 查找指定条件的通知书信息
	 * 
	 * @param appno
	 * @param noticeType
	 * @return
	 * @throws ScubeBizException
	 * @author mengjiajia
	 * @date 2017年4月18日下午5:41:30
	 */
	public List<BNteNoticeBase> getNoticeInfoByAppnoAndNoticeType(String appno, String noticeType) throws ScubeBizException {
		BNteNoticeBaseExample example = new BNteNoticeBaseExample();
		BNteNoticeBaseExample.Criteria cri = example.createCriteria();
		cri.andAppnoEqualTo(appno);
		cri.andNoticeTypeEqualTo(noticeType);
		List<com.huateng.scf.bas.nte.dao.model.BNteNoticeBase> listdal = bNteNoticeBaseDAO.selectByExample(example);
		List<BNteNoticeBase> list = new ArrayList<BNteNoticeBase>();
		if (listdal.size() > 0 && listdal != null) {
			for (com.huateng.scf.bas.nte.dao.model.BNteNoticeBase base : listdal) {
				BNteNoticeBase noticeBase = new BNteNoticeBase();
				BeanUtils.copyProperties(base, noticeBase);
				list.add(noticeBase);
			}
		}
		return list;
	}

	/**
	 * 更新通知书状态
	 * 
	 * @param appno
	 * @param noticeType
	 * @param status
	 * @throws ScubeBizException
	 * @author mengjiajia
	 * @date 2017年4月19日下午3:04:42
	 */
	@Override
	public void updateNoticeStatus(String appno, String noticeType, String status) throws ScubeBizException {
		List<BNteNoticeBase> noticeBaseInfoList = this.getNoticeInfoByAppnoAndNoticeType(appno, noticeType);
		if (noticeBaseInfoList != null && noticeBaseInfoList.size() > 0) {
			for (int i = 0; i < noticeBaseInfoList.size(); i++) {
				BNteNoticeBase tblNoticeBaseInfo = noticeBaseInfoList.get(i);
				com.huateng.scf.bas.nte.dao.model.BNteNoticeBase tblNoticeBaseInfoTmp = bNteNoticeBaseDAO
						.selectByPrimaryKey(tblNoticeBaseInfo.getId());
				tblNoticeBaseInfoTmp.setStatus(status);
				tblNoticeBaseInfoTmp.setSignDate(ScfDateUtil.getStringDate(new Date()));
				bNteNoticeBaseDAO.updateByPrimaryKeySelective(tblNoticeBaseInfoTmp);
			}
		}
	}

	/*
	 * 通知书分页条件查询 （翻译业务品种和出质人名称）
	 *
	 */
	@Override
	public Page selectNoticePageByParam(int pageNo, int pageSize, NoticeQryVO noticeQryVO) throws ScubeBizException {
		Page page = new Page(pageSize, pageNo, 0);
		HashMap<String, Object> map = new HashMap<String, Object>();
		if (noticeQryVO != null) {
			String slaveContcode = noticeQryVO.getSlaveContcode();// 抵/质押合同号
			String bussType = noticeQryVO.getBussType();// 业务品种
			String custcd = noticeQryVO.getCustcd();// 出质人
			String cname = noticeQryVO.getCustName();// 出质人名称
			String noticeType = noticeQryVO.getNoticeType();// 通知书类型
			map.put("slaveContcode", slaveContcode);
			map.put("bussType", bussType);
			map.put("custcd", custcd);
			map.put("cname", cname);
			map.put("noticeType", noticeType);
			List<com.huateng.scf.bas.nte.dao.model.NoticeQryVO> noticeQryVOList = bNteNoticeBaseDAO.selectNoticePageByParamForPage(map, page);
			// 经办机构，操作员名称转译
			for (com.huateng.scf.bas.nte.dao.model.NoticeQryVO noticeQryVO1 : noticeQryVOList) {
				if (noticeQryVO1.getTlrn() != null && !"".equals(noticeQryVO1.getTlrn())) {
					// 翻译，创建人tlrcd，经办机构brcode，
					UserInfo userInfo1 = new UserInfo();
					userInfo1.setTlrNo(noticeQryVO1.getTlrn());// 搜索创建人对应的名称。
					List<TlrInfoVO> userList = userService.selectByExample(userInfo1);
					if (userList != null && userList.size() == 1) {
						noticeQryVO1.setTlrname(userList.get(0).getTlrName());
					}
				}
				if (noticeQryVO1.getBrcode() != null && !"".equals(noticeQryVO1.getBrcode())) {
					// 经办机构brName
					BctlVO bctlVO = new BctlVO();
					bctlVO.setBrNo(noticeQryVO1.getBrcode());
					List<BctlVO> bctlVOList = orgService.selectByExample(bctlVO);
					if (bctlVOList != null && bctlVOList.size() == 1) {
						noticeQryVO1.setBrname(bctlVOList.get(0).getBrName());
					}
				}
			}
			page.setRecords(noticeQryVOList);
		}
		return page;
	}

	/**
	 * 查询通知书基本信息
	 * 
	 * @param noticeCommonQueryVO
	 * @return
	 * @throws ScubeBizException
	 * @author mengjiajia
	 * @date 2017年4月20日上午9:57:44
	 */
	@Override
	public Page getNoticeBaseInfoByNoticeCommonQueryVO(NoticeQryPrintVO noticeCommonQueryVO) throws ScubeBizException {
		HashMap<String, Object> omap = new HashMap<String, Object>();

		List<String> noticeTypeList = new ArrayList<String>();
		List<String> brcodeList = new ArrayList<String>();

		if (!StringUtil.isEmpty(noticeCommonQueryVO.getFlag()) && ScfBasConstant.FLAG_ON.equals(noticeCommonQueryVO.getFlag())) { // 是否开启业务品种比较查询
			omap.put("flag", "#");
		}
		if (!StringUtil.isEmpty(noticeCommonQueryVO.getProductId())) {
			omap.put("bussType", noticeCommonQueryVO.getProductId());
		}
		if (!StringUtil.isEmpty(noticeCommonQueryVO.getId())) {
			omap.put("id", noticeCommonQueryVO.getId());
		}
		if (!StringUtil.isEmpty(noticeCommonQueryVO.getExt1())) {
			omap.put("ext1", noticeCommonQueryVO.getExt1());
		}
		if (!StringUtil.isEmpty(noticeCommonQueryVO.getAppno())) { // 申请号
			omap.put("appno", noticeCommonQueryVO.getAppno());
		}
		if (!StringUtil.isEmpty(noticeCommonQueryVO.getNum())) {// 通知书编号
			omap.put("num", noticeCommonQueryVO.getNum());
		}
		if (!StringUtil.isEmpty(noticeCommonQueryVO.getNoticeType())) { // 通知书类型
			String[] ambts = noticeCommonQueryVO.getNoticeType().split("\\,");
			if (ambts.length > 1) {
				String[] noticeTypes = StringUtil.strSplit(noticeCommonQueryVO.getNoticeType(), ",");
				for (int i = 0; i < noticeTypes.length; i++) {
					noticeTypeList.add(noticeTypes[i]);
				}
			} else {
				omap.put("noticeType", noticeCommonQueryVO.getNoticeType());
			}
		}
		if (noticeTypeList.size() > 0 && noticeTypeList != null) {
			omap.put("noticeTypeList", noticeTypeList);
		}
		if (!StringUtil.isEmpty(noticeCommonQueryVO.getSlaveContno())) { // 担保合ID
			omap.put("slaveContno", noticeCommonQueryVO.getSlaveContno());
		}
		if (!StringUtil.isEmpty(noticeCommonQueryVO.getSlaveContCode())) { // 担保合同号
			omap.put("slaveContcode", noticeCommonQueryVO.getSlaveContCode());
		}
		if (!StringUtil.isEmpty(noticeCommonQueryVO.getProtocolCode())) { // 监管协议号
			omap.put("protocolCode", noticeCommonQueryVO.getProtocolCode());
		}
		if (!StringUtil.isEmpty(noticeCommonQueryVO.getProtocolNo())) { // 监管协议号
																		// 或者
																		// 四方协议
			omap.put("monitorProtocolNo", noticeCommonQueryVO.getProtocolNo());
		}
		if (!StringUtil.isEmpty(noticeCommonQueryVO.getCustcd())) { // 出质人
			omap.put("custcd", noticeCommonQueryVO.getCustcd());
		}
		if (!StringUtil.isEmpty(noticeCommonQueryVO.getCname())) { // 出质人
			omap.put("cname", noticeCommonQueryVO.getCname());
		}
		if (!StringUtil.isEmpty(noticeCommonQueryVO.getMoniOfCustcd())) { // 监管人
			omap.put("moniOfCustcd", noticeCommonQueryVO.getMoniOfCustcd());
		}
		if (!StringUtil.isEmpty(noticeCommonQueryVO.getBrcodes())) {// 机构集
			String[] scpids = noticeCommonQueryVO.getBrcodes().split("\\,");
			if (scpids.length > 1) {
				for (String brcode : scpids) {
					brcodeList.add(brcode);
				}
			} else {
				omap.put("brcode", noticeCommonQueryVO.getBrcodes());
			}
		}
		if (brcodeList.size() > 0 && brcodeList != null) {
			omap.put("brcodeList", brcodeList);
		}
		if (!StringUtil.isEmpty(noticeCommonQueryVO.getBrcode())) {
			omap.put("parentBrcode1", noticeCommonQueryVO.getBrcode());
			omap.put("affiliationType1", ScfBasConstant.BCTL_AFFILIATION_BELONG);
		}
		if (!StringUtil.isEmpty(noticeCommonQueryVO.getStatus())) {// status[回执状态]:0:未确认回执
																	// 1:监管公司确认回执
																	// 2:核库巡库岗确认回执
																	// 9：其它
			omap.put("status", noticeCommonQueryVO.getStatus());
		}
		if (!StringUtil.isEmpty(noticeCommonQueryVO.getStartDate_Q()) && StringUtil.isEmpty(noticeCommonQueryVO.getEndDate_Q())) { // 开始日期
			omap.put("signDate1", noticeCommonQueryVO.getStartDate_Q());
		}
		if (!StringUtil.isEmpty(noticeCommonQueryVO.getEndDate_Q()) && StringUtil.isEmpty(noticeCommonQueryVO.getStartDate_Q())) { // 结束日期
			omap.put("signDate2", noticeCommonQueryVO.getEndDate_Q());
		}
		if (!StringUtil.isEmpty(noticeCommonQueryVO.getEndDate_Q()) && !StringUtil.isEmpty(noticeCommonQueryVO.getStartDate_Q())) { // =>开始日期
																																	// <=结束日期
			omap.put("signDate3", noticeCommonQueryVO.getStartDate_Q());
			omap.put("signDate4", noticeCommonQueryVO.getEndDate_Q());
		}
		if (!StringUtil.isEmpty(noticeCommonQueryVO.getPawneeorgid())) { // 出质人
			omap.put("pawneeorgid", noticeCommonQueryVO.getPawneeorgid());
		}
		if (!StringUtil.isEmpty(noticeCommonQueryVO.getStartDate_from_Q())) {// 签发日期
																				// 从
			omap.put("signDate5", noticeCommonQueryVO.getStartDate_from_Q());
		}
		if (!StringUtil.isEmpty(noticeCommonQueryVO.getStartDate_to_Q())) {// 签发日期
																			// 到
			omap.put("signDate6", noticeCommonQueryVO.getStartDate_to_Q());
		}
		if (!StringUtil.isEmpty(noticeCommonQueryVO.getEndDate_from_Q())) {// 回执日期
																			// 从
			omap.put("commonDate1", noticeCommonQueryVO.getEndDate_from_Q());
		}
		if (!StringUtil.isEmpty(noticeCommonQueryVO.getEndDate_to_Q())) {// 回执日期
																			// 到
			omap.put("commonDate2", noticeCommonQueryVO.getEndDate_to_Q());
		}
		if (ScfBasConstant.PRODUCT_TYPE_ORDERBILLS.equals(noticeCommonQueryVO.getBussType())) {// 订单融资
			String brcode = ContextHolder.getOrgInfo().getBrNo();
			// 村镇银行
			if (ScfBasConstant.FLAG_ON
					.equals(scubeUserService.selectBctlByBrNo(brcode, ScfCommonUtil.getBrManagerNo(scubeUserService)).getBrAttr())) {
				omap.put("cooperationBrcode", brcode);
			} else {
				omap.put("parentBrcode2", brcode);
				omap.put("affiliationType2", ScfBasConstant.BCTL_AFFILIATION_BELONG);
			}
		}

		Page pageQueryResult = new Page();
		pageQueryResult.setRecords(extbntedao.getNoticeBaseInfoByNoticeCommonQueryVO(omap, null));
		return pageQueryResult;
	}

	/*
	 * 
	 */
	@Override
	@Transactional
	public void addAdvWorthCompensateNoticeInfo(BNteNoticeBase bNteNoticeBase) throws ScubeBizException {
		if (bNteNoticeBase == null) {
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BNteErrorConstant.SCF_BAS_NTE_10005), BNteErrorConstant.SCF_BAS_NTE_10005);
		}
		com.huateng.scf.bas.nte.dao.model.BNteNoticeBase bNteNoticeBase2 = new com.huateng.scf.bas.nte.dao.model.BNteNoticeBase();
		BeanUtils.copyProperties(bNteNoticeBase, bNteNoticeBase2);
		String brcode = ContextHolder.getOrgInfo().getBrNo();
		String tlrNo = ContextHolder.getUserInfo().getTlrNo();
		bNteNoticeBase2.setId(UUIDGeneratorUtil.generate());
		String appno = bSysSerialNoService.genSerialNo(ScfBasConstant.VALUE_INDEX_APP_NO);
		String num = bSysSerialNoService.genSerialNo(ScfBasConstant.BUSSNO_TYPE_DJBC_T_NOTICE_NO);
		bNteNoticeBase2.setAppno(appno);
		bNteNoticeBase2.setNum(num);
		bNteNoticeBase2.setAppliDate(BSysConstant.WORKDATE);
		bNteNoticeBase2.setSignDate(BSysConstant.WORKDATE);
		bNteNoticeBase2.setStatus(NoticeConstant.NOTICE_BASE_STATUS_UNCONFIRM);
		bNteNoticeBase2.setMonitorProtocolNo(bNteNoticeBase2.getProtocolNo());// 按照老代码，这里存入的就是抵质押合同号
		bNteNoticeBase2.setProtocolCode(bNteNoticeBase2.getProtocolNo());
		bNteNoticeBase2.setBrcode(brcode);
		bNteNoticeBase2.setTlrn(tlrNo);
		try {
			bNteNoticeBaseDAO.insert(bNteNoticeBase2);
		} catch (Exception e) {
			log.debug(e.getMessage());
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BNteErrorConstant.SCF_BAS_NTE_10001), BNteErrorConstant.SCF_BAS_NTE_10001);
		}
		return;
	}

	/**
	 * 非标仓单提货通知书 保存
	 * 
	 * @param applyVO
	 * @param billList
	 * @param mortList
	 * @throws ScubeBizException
	 * @author mengjiajia
	 * @date 2017年4月27日上午11:06:44
	 */
	@SuppressWarnings("rawtypes")
	@Override
	@Transactional
	public void saveBillNormalDeliveryNotice(DeliveyApplyVO applyVO, List<BillNormalMortgageVO> billList, List<MortgageApplyVO> mortList)
			throws ScubeBizException {
		List noticeList = this.getNoticeBaseInfoByAppno(applyVO.getAppno());
		String pid = "";
		if (null == noticeList || noticeList.size() == 0) {
			String protocolNo = "";
			if (!StringUtil.isEmpty(applyVO.getSlaveContno())) {
				com.huateng.scf.bas.crr.dao.model.BCrrGntyCon slaveInfo = bcrrgntycondao.selectByPrimaryKey(applyVO.getSlaveContno());
				if (null != slaveInfo) {
					protocolNo = slaveInfo.getPrtclNo();
				}
			} else {
				throw new ScubeBizException("质押合同号丢失！");
			}
			// TblNoticeBaseInfo
			BNteNoticeBase baseInfo = new BNteNoticeBase();
			baseInfo.setAppliDate(ScfDateUtil.getStringDate(new Date()));// 日期
			baseInfo.setBrcode(ContextHolder.getOrgInfo().getBrNo());// 签发机构
			baseInfo.setTlrn(ContextHolder.getUserInfo().getTlrNo());// 签发人
			baseInfo.setAppno(applyVO.getAppno());
			baseInfo.setCustcd(applyVO.getCustcd());
			baseInfo.setSlaveContno(applyVO.getSlaveContno());
			baseInfo.setMonitorProtocolNo(protocolNo);
			baseInfo.setMortgageChangeType(ScfBasConstant.MORTGAGE_CHANGE_TYPE_RELESE);
			baseInfo.setStatus(NoticeConstant.NOTICE_BASE_STATUS_UNCONFIRM);// 未确认
			baseInfo.setNoticeType(NoticeConstant.NOTICE_TYPE_130);
			baseInfo.setDeliveryAmt(applyVO.getDeliverValue());// 提货价值
			if (!StringUtil.isEmpty(protocolNo)) {
				baseInfo.setMoniOfCustcd(bCntMprotPartInfoService.findCnameByProAndRole(protocolNo, ScfBasConstant.PROTOCOL_PART_ROLE_MONI,
						ScfBasConstant.RETURN_FLAG_CUSTCD));
			} else {
				throw new ScubeBizException("质押合同中监管协议号丢失！");
			}
			if (StringUtil.isEmpty(applyVO.getSupplyChainPdId())) {
				String productId = bPbcAppliBaseInfoService.findBPbcAppliBaseInfoByKey(applyVO.getAppno()).getSupplyChainPdId();
				baseInfo.setBussType(productId);
			} else {
				baseInfo.setBussType(applyVO.getSupplyChainPdId());
			}
			this.addBNteNoticeBase(baseInfo);
			pid = baseInfo.getId();
		} else {
			com.huateng.scf.bas.nte.dao.model.BNteNoticeBase tblNoticeBaseInfo = (com.huateng.scf.bas.nte.dao.model.BNteNoticeBase) noticeList.get(0);
			tblNoticeBaseInfo.setAppliDate(ScfDateUtil.getStringDate(new Date()));// 日期
			bNteNoticeBaseDAO.updateByPrimaryKeySelective(tblNoticeBaseInfo);
			pid = tblNoticeBaseInfo.getId();
		}

		// BNteNoticeMtg
		List list = bntenoticemtgservice.getMortgageListByAppnoAndPid(applyVO.getAppno(), pid);
		for (int i = 0; i < list.size(); i++) {
			com.huateng.scf.bas.nte.dao.model.BNteNoticeMtg mtg = (com.huateng.scf.bas.nte.dao.model.BNteNoticeMtg) list.get(i);
			bNteNoticeMtgDAO.deleteByPrimaryKey(mtg.getId());
		}
		if (null != mortList && mortList.size() > 0) {
			for (int i = 0; i < mortList.size(); i++) {
				MortgageApplyVO appliVO = (MortgageApplyVO) mortList.get(i);
				com.huateng.scf.bas.nte.dao.model.BNteNoticeMtg noticeMortgageInfo = new com.huateng.scf.bas.nte.dao.model.BNteNoticeMtg();
				BeanUtils.copyProperties(appliVO, noticeMortgageInfo);
				if ("false".equals(noticeMortgageInfo.getJoinBatch())) {
					noticeMortgageInfo.setJoinBatch("0");
				} else if ("true".equals(noticeMortgageInfo.getJoinBatch())) {
					noticeMortgageInfo.setJoinBatch("1");
				}
				if (StringUtil.isEmpty(noticeMortgageInfo.getAppno())) {
					noticeMortgageInfo.setAppno(applyVO.getAppno());
				}
				noticeMortgageInfo.setMortgageType(ScfBasConstant.MORTGAGE_TYPE_OUT);// 货物类型
																						// 0：表示新入库。1:表示解除抵押，出库。
				noticeMortgageInfo.setPid(pid);
				noticeMortgageInfo.setId(UUIDGeneratorUtil.generate());
				if (noticeMortgageInfo.getBalQuantity().compareTo(BigDecimal.ZERO) > 0) {
					bNteNoticeMtgDAO.insertSelective(noticeMortgageInfo);
				}
			}
		}
	}

	/**
	 * 根据appno查询通知书信息
	 * 
	 * @param appno
	 * @return
	 * @throws ScubeBizException
	 * @author mengjiajia
	 * @date 2017年4月27日上午11:15:10
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public List getNoticeBaseInfoByAppno(String appno) throws ScubeBizException {
		BNteNoticeBaseExample example = new BNteNoticeBaseExample();
		BNteNoticeBaseExample.Criteria cri = example.createCriteria();
		cri.andAppnoEqualTo(appno);
		List noticeList = bNteNoticeBaseDAO.selectByExample(example);
		return noticeList;

	}

	/**
	 * DESCRIPTION:保兑仓提货申请生成通知书(城商行)
	 * 
	 * @author zhoujun.hou
	 * @date 2013-4-26 tripartiteDeliveryNoticeBasicInfoSave 方法
	 * @param appno
	 * @return
	 * @throws ScubeBizException
	 * @param commonQueryVO
	 * @return
	 */
	@Transactional
	public String deliveryNoticeBasicInfoSave(String appno, String noticeNo) throws ScubeBizException {
		// 检查通知书是否已经存在
		// 2、数据准备
		BPbcAppliBaseInfo bPbcAppliBaseInfo = bPbcAppliBaseInfoService.findBPbcAppliBaseInfoByKey(appno);
		if (bPbcAppliBaseInfo == null) {
			log.error("申请基本信息丢失！");
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BPbcErrorConstant.SCF_BAS_PBC_10004), BPbcErrorConstant.SCF_BAS_PBC_10004);
		}

		// 业务流水记录
		ABcpAppliImprestBuss abcpAppliImprestBuss = aBcpAppliImprestBussService.findABcpAppliImprestBussByAppno(appno);
		if (abcpAppliImprestBuss == null) {
			log.error("业务申请流水信息丢失!");
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(ATcsErrorConstant.SCF_ADV_TCS_30002), ATcsErrorConstant.SCF_ADV_TCS_30002);
		}
		BCrrLnCon bCrrLnCon = bCrrLnConService.findBCrrLnConByAppId(bPbcAppliBaseInfo.getMastContno());
		if (bCrrLnCon == null) {
			log.error("合同信息丢失!");
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(ATcsErrorConstant.SCF_ADV_TCS_10003), ATcsErrorConstant.SCF_ADV_TCS_10003);
		}
		BCntMprotBaseInfo baseInfo = bcntmprotbaseinfoservice.findBCntMprotBaseInfoByKey(bPbcAppliBaseInfo.getProtocolNo());
		BNteNoticeBase bNteNoticeBase = null;
		BNteNoticeBase bNteNoticeBaseQry = new BNteNoticeBase();
		bNteNoticeBaseQry.setAppno(appno);
		// 提货申请只有一张通知书 使用该方法 两张以上的通知书不适用
		List<BNteNoticeBase> result = this.findBNteNoticeBaseByAppno(bNteNoticeBaseQry);
		// 提货申请只有一张通知书 使用该方法 两张以上的通知书不适用
		if (result != null && result.size() > 0) {
			bNteNoticeBase = (BNteNoticeBase) result.get(0);
		} else {
			bNteNoticeBase = new BNteNoticeBase();
			bNteNoticeBase.setId(null);
			bNteNoticeBase.setNum(noticeNo);
		}

		bNteNoticeBase.setAppno(appno);
		// 通过协议号查询参与方
		List<BCntMprotPartInfo> partList = bCntMprotPartInfoService.findBCntMpartInfoByProtocolNo(bPbcAppliBaseInfo.getProtocolNo());// 通过协议号查询参与方
		// String coreCustcd = "";
		for (int i = 0; i < partList.size(); i++) {
			BCntMprotPartInfo mutiProtPartInfo = (BCntMprotPartInfo) partList.get(i);
			if (ScfBasConstant.PROTOCOL_PART_ROLE_CREDIT.equals(mutiProtPartInfo.getRole())) {// 授信客户
				bNteNoticeBase.setCustcd(mutiProtPartInfo.getCustcd());// 借款人
				bNteNoticeBase.setCustName(mutiProtPartInfo.getCname());
			} else if (ScfBasConstant.PROTOCOL_PART_ROLE_MONI.equals(mutiProtPartInfo.getRole())) {// 监管公司
				bNteNoticeBase.setMoniOfCustcd(mutiProtPartInfo.getCustcd());
			} else if (ScfBasConstant.PROTOCOL_PART_ROLE_CORE.equals(mutiProtPartInfo.getRole())) {// 核心厂商
				bNteNoticeBase.setOtherCustcd(mutiProtPartInfo.getCustcd());//
				bNteNoticeBase.setOtherCustName(mutiProtPartInfo.getCname());
			} else if (ScfBasConstant.PROTOCOL_PART_ROLE_BACKCORE.equals(mutiProtPartInfo.getRole())) {// 回购厂商
			}
		}
		// 获取当前用户
		UserInfo user = ContextHolder.getUserInfo();
		String tlrNo = user.getTlrNo();
		String brCode = user.getBrNo();
		bNteNoticeBase.setMastContno(bPbcAppliBaseInfo.getMastContno());// 主合同
		bNteNoticeBase.setNoticeType(NoticeConstant.NOTICE_TYPE_83);// 预付款提货通知书
		bNteNoticeBase.setSlaveContno(bPbcAppliBaseInfo.getSlaveContno());
		bNteNoticeBase.setSlaveContcode(bPbcAppliBaseInfo.getSlaveContno());
		bNteNoticeBase.setProtocolNo(bCrrLnCon.getVidNo());// 三方协议
		bNteNoticeBase.setProtocolCode(baseInfo.getProtocolCode());
		bNteNoticeBase.setOrderNo(abcpAppliImprestBuss.getNum() == null ? "" : abcpAppliImprestBuss.getNum());// 收款确认函编号
		bNteNoticeBase.setCommonAmt(abcpAppliImprestBuss.getCommonAmt());// 本次提货金额

		bNteNoticeBase.setDebetNo(abcpAppliImprestBuss.getDebetNo());// 借据号

		BLanLnciBase bLanLnciBase = bLanLnciBaseService.findBLanLnciBaseByKey(abcpAppliImprestBuss.getDebetNo());
		bNteNoticeBase.setDebetId(bLanLnciBase == null ? null : bLanLnciBase.getDebetId());

		bNteNoticeBase.setBussType(abcpAppliImprestBuss.getBussType());// 业务类型

		bNteNoticeBase.setBrcode(brCode);// 签发机构
		bNteNoticeBase.setTlrn(tlrNo);// 签发人
		bNteNoticeBase.setAppliDate(BSysConstant.WORKDATE);// 日期
		bNteNoticeBase.setStatus(NoticeConstant.NOTICE_BASE_STATUS_UNCONFIRM);// 未签发

		// 通知书基本表中存入业务品种 add by changhao.huang 2013-9-13
		String productId = "";
		if (bPbcAppliBaseInfo != null) {
			productId = bPbcAppliBaseInfo.getSupplyChainPdId();
			bNteNoticeBase.setBussType(productId);
		}
		if (bNteNoticeBase.getId() == null) {// 新增
			this.addBNteNoticeBase(bNteNoticeBase);
		} else {
			this.updateBNteNoticeBase(bNteNoticeBase);
		}
		return bNteNoticeBase.getId();
	}

	/**
	 * @Description: 四方差额退款通知书信息保存
	 * @param appno
	 * @param vo
	 * @throws ScubeBizException
	 */
	@Transactional
	public void saveFourMarginNoticBaseInfo(String appno, FourWareLoanVO vo) throws ScubeBizException {
		BPbcAppliBaseInfo bPbcAppliBaseInfo = bPbcAppliBaseInfoService.findBPbcAppliBaseInfoByKey(appno);
		BNteNoticeBase bNteNoticeBaseQry = new BNteNoticeBase();
		bNteNoticeBaseQry.setAppno(vo.getAppno());
		List<BNteNoticeBase> noticebase = this.findBNteNoticeBaseByAppno(bNteNoticeBaseQry);
		BNteNoticeBase tblNoticeBaseInfo = null;
		// 获取当前用户
		UserInfo user = ContextHolder.getUserInfo();
		if (noticebase == null || noticebase.size() < 1) {// 新增
			tblNoticeBaseInfo = new BNteNoticeBase();
			// 通知书基本信息表（核心厂商）
			List<BCntMprotPartInfo> list1 = bCntMprotPartInfoService.findBCntMpartInfoByProtocolNo(bPbcAppliBaseInfo.getProtocolNo());// 通过协议号查询参与方
			for (int i = 0; i < list1.size(); i++) {
				BCntMprotPartInfo mutiProtPartInfo = (BCntMprotPartInfo) list1.get(i);
				if (ScfBasConstant.PROTOCOL_PART_ROLE_CREDIT.equals(mutiProtPartInfo.getRole())) {// 授信客户
					tblNoticeBaseInfo.setCustcd(mutiProtPartInfo.getCustcd());// 借款人
					tblNoticeBaseInfo.setCustName(mutiProtPartInfo.getCname());
				} else if (ScfBasConstant.PROTOCOL_PART_ROLE_MONI.equals(mutiProtPartInfo.getRole())) {// 监管公司
				} else if (ScfBasConstant.PROTOCOL_PART_ROLE_CORE.equals(mutiProtPartInfo.getRole())) {// 核心厂商
					tblNoticeBaseInfo.setOtherCustcd(mutiProtPartInfo.getCustcd());//
					tblNoticeBaseInfo.setOtherCustName(mutiProtPartInfo.getCname());
				} else if (ScfBasConstant.PROTOCOL_PART_ROLE_BACKCORE.equals(mutiProtPartInfo.getRole())) {// 回购厂商
				}
			}
			List<BCntBuyInfo> list = bCntBuyInfoService.findByProtocolNo(bPbcAppliBaseInfo.getProtocolNo());
			String tradeContcode = "";
			if (list != null && list.size() > 0) {
				for (int j = 0; j < list.size(); j++) {
					BCntBuyInfo buyInfo = (BCntBuyInfo) list.get(j);
					if (j == 0) {
						tradeContcode = buyInfo.getTradeContcode();
					} else {
						tradeContcode = tradeContcode + "," + buyInfo.getTradeContcode();
					}
				}
			}

			tblNoticeBaseInfo.setAppno(appno);// 申请编号
			tblNoticeBaseInfo.setProtocolNo(bPbcAppliBaseInfo.getProtocolNo());
			tblNoticeBaseInfo.setProtocolCode(bPbcAppliBaseInfo.getProtocolNo());
			tblNoticeBaseInfo.setNoticeType(NoticeConstant.NOTICE_TYPE_85);// 预付款差额退款通知书
			tblNoticeBaseInfo.setStatus(NoticeConstant.NOTICE_BASE_STATUS_UNCONFIRM);
			tblNoticeBaseInfo.setBrcode(user.getBrNo());// 机构
			tblNoticeBaseInfo.setTlrn(user.getTlrNo());// 签发人
			tblNoticeBaseInfo.setAppliDate(BSysConstant.WORKDATE);// 日期
			tblNoticeBaseInfo.setSignDate(BSysConstant.WORKDATE); // 签发日期
			tblNoticeBaseInfo.setCommonAmt(bPbcAppliBaseInfo.getAmt());// 未发货金额
			tblNoticeBaseInfo.setTradeContno(tradeContcode);// 购销合同
			tblNoticeBaseInfo.setExt1Amount(vo.getLoanAmt()); // 票据总金额Ext1Amount字段
			tblNoticeBaseInfo.setNum(vo.getNum());// 通知书编号 调用前生成通知书编号放到num中
			// tblNoticeBaseInfo.setId(null);

			// 通知书基本表中存入业务品种 add by changhao.huang 2013-9-13
			String productId = bPbcAppliBaseInfo.getSupplyChainPdId();
			tblNoticeBaseInfo.setBussType(productId);
			this.addBNteNoticeBase(tblNoticeBaseInfo);
		} else {
			for (int i = 0; i < noticebase.size(); i++) {
				tblNoticeBaseInfo = (BNteNoticeBase) noticebase.get(i);
				tblNoticeBaseInfo.setCommonAmt(bPbcAppliBaseInfo.getAmt());
				this.updateBNteNoticeBase(tblNoticeBaseInfo);
			}
		}
	}

	/*
	 * 查询及出质通知书查询 （翻译业务品种和出质人名称）
	 */
	@Override
	public Page selectQuantityNoticeBaseInfoForPage(int pageNo, int pageSize, NoticeQryPrintVO noticeCommonQueryVO) throws ScubeBizException {
		Page page = new Page(pageSize, pageNo, 0);

		HashMap<String, Object> omap = new HashMap<String, Object>();

		if (!StringUtil.isEmpty(noticeCommonQueryVO.getSlaveContCode())) {// 抵质押合同号
			omap.put("slaveContcode", noticeCommonQueryVO.getSlaveContCode());
		}

		if (!StringUtil.isEmpty(noticeCommonQueryVO.getBussType())) {// 业务品种
			omap.put("bussType", noticeCommonQueryVO.getBussType());
		}

		if (!StringUtil.isEmpty(noticeCommonQueryVO.getNoticeType())) { // 通知书类型
			omap.put("noticeType", noticeCommonQueryVO.getNoticeType());
		}

		if (!StringUtil.isEmpty(noticeCommonQueryVO.getCname())) { // 出质人
			omap.put("cname", noticeCommonQueryVO.getCname());
		}

		if (!StringUtil.isEmpty(noticeCommonQueryVO.getBrcode())) { // 经办机构
			omap.put("brcode", noticeCommonQueryVO.getBrcode());
		}

		if (!StringUtil.isEmpty(noticeCommonQueryVO.getStatus())) {// 通知书状态
			omap.put("status", noticeCommonQueryVO.getStatus());
		}

		if (!StringUtil.isEmpty(noticeCommonQueryVO.getStartDate_from_Q())) {// 签发日期
																				// 从
			omap.put("signDate5", ScfDateUtil.formatDate(noticeCommonQueryVO.getStartDate_from_Q()));
		}
		if (!StringUtil.isEmpty(noticeCommonQueryVO.getStartDate_to_Q())) {// 签发日期
																			// 到
			omap.put("signDate6", ScfDateUtil.formatDate(noticeCommonQueryVO.getStartDate_to_Q()));
		}
		if (!StringUtil.isEmpty(noticeCommonQueryVO.getEndDate_from_Q())) {// 回执日期
																			// 从
			omap.put("commonDate1", ScfDateUtil.formatDate(noticeCommonQueryVO.getEndDate_from_Q()));
		}
		if (!StringUtil.isEmpty(noticeCommonQueryVO.getEndDate_to_Q())) {// 回执日期
																			// 到
			omap.put("commonDate2", ScfDateUtil.formatDate(noticeCommonQueryVO.getEndDate_to_Q()));
		}
		List<com.huateng.scf.bas.nte.dao.model.BNteNoticeBase> bNteNoticeBaseList = extbntedao.getNoticeBaseInfoByNoticeCommonQueryVO(omap, page);
		if (bNteNoticeBaseList != null && bNteNoticeBaseList.size() > 0) {
			for (com.huateng.scf.bas.nte.dao.model.BNteNoticeBase bNteNoticeBase : bNteNoticeBaseList) {
				// 1.出质人名称
				if (!StringUtil.isEmpty(bNteNoticeBase.getCustcd())) {
					BCrmBaseInfo bCrmBaseInfo = bCrmBaseInfoService.findBCrmBaseInfoByCustcd(bNteNoticeBase.getCustcd());
					bNteNoticeBase.setCname(bCrmBaseInfo.getCname());
				}
				// 2.监管公司名称
				if (!StringUtil.isEmpty(bNteNoticeBase.getMoniOfCustcd())) {
					BCrmBaseInfo bCrmBaseInfo2 = bCrmBaseInfoService.findBCrmBaseInfoByCustcd(bNteNoticeBase.getMoniOfCustcd());
					bNteNoticeBase.setMoniOfName(bCrmBaseInfo2.getCname());
				}
				// 3.业务品种
				if (!StringUtil.isEmpty(bNteNoticeBase.getBussType())) {
					BPrdInfo bPrdInfo = bPrdInfoService.findBPrdInfoObjectByKey(bNteNoticeBase.getBussType());
					bNteNoticeBase.setBussTypeName(bPrdInfo.getProductName());
				}
				// 4.客户经理
				if (!StringUtil.isEmpty(bNteNoticeBase.getTlrn())) {
					UserInfo userInfo1 = new UserInfo();
					userInfo1.setTlrNo(bNteNoticeBase.getTlrn());// 搜索创建人对应的名称。
					List<TlrInfoVO> userList = userService.selectByExample(userInfo1);
					if (userList != null && userList.size() == 1) {
						bNteNoticeBase.setTlrNm(userList.get(0).getTlrName());
					}
				}
				// 5.经办机构
				if (!StringUtil.isEmpty(bNteNoticeBase.getBrcode())) {
					BctlVO bctlVO = new BctlVO();
					bctlVO.setBrNo(bNteNoticeBase.getBrcode());
					List<BctlVO> bctlVOList = orgService.selectByExample(bctlVO);
					if (bctlVOList != null && bctlVOList.size() == 1) {
						bNteNoticeBase.setBrNm(bctlVOList.get(0).getBrName());
					}
				}
			}
			page.setRecords(bNteNoticeBaseList);
		}
		return page;
	}

	/**
	 * 普通仓单解押通知书保存
	 * 
	 * @param appno
	 * @throws ScubeBizException
	 * @author mengjiajia
	 * @date 2017年5月3日下午4:01:34
	 */
	@SuppressWarnings({ "unchecked" })
	@Override
	public void addBillNoticeByMortgageModifyMoniFloor(String appno) throws ScubeBizException {
		BPbcAppliBaseInfo appliBaseInfo = bPbcAppliBaseInfoService.findBPbcAppliBaseInfoByKey(appno);
		if (appliBaseInfo == null) {
			throw new ScubeBizException("主申请信息信息丢失，无法生成相关信息");
		}
		com.huateng.scf.bas.crr.dao.model.BCrrGntyCon appliContSlaveInfo = bcrrgntycondao.selectByPrimaryKey(appliBaseInfo.getSlaveContno());
		if (appliContSlaveInfo == null) {
			throw new ScubeBizException("担保合同信息丢失，无法生成相关信息");
		}
		BCrrGntyCon bCrrGntyCon = new BCrrGntyCon();
		BeanUtils.copyProperties(appliContSlaveInfo, bCrrGntyCon);
		BCntMprotBaseInfo mutiProtBaseInfo = null;
		if (!StringUtil.isEmpty(appliBaseInfo.getProtocolNo())) {
			mutiProtBaseInfo = bcntmprotbaseinfoservice.findBCntMprotBaseInfoByKey(appliBaseInfo.getProtocolNo());
		}

		String noticeId = "";
		// 每次保存之前，先删除之前保存的通知书信息。
		List<com.huateng.scf.bas.nte.dao.model.BNteNoticeBase> noticeBaseInfoList = this.getNoticeBaseInfoByAppno(appno);
		if (noticeBaseInfoList != null && noticeBaseInfoList.size() > 0) {
			for (com.huateng.scf.bas.nte.dao.model.BNteNoticeBase noticeBaseInfo : noticeBaseInfoList) {
				bNteNoticeBaseDAO.deleteByPrimaryKey(noticeBaseInfo.getId());
			}
		}

		List<BNteNoticeMtg> noticeMortgageInfoList = bntenoticemtgservice.findBNteNoticeMtgByAppno(appno);
		if (noticeMortgageInfoList != null && noticeMortgageInfoList.size() > 0) {
			for (BNteNoticeMtg nteNoticeMtg : noticeMortgageInfoList) {
				bNteNoticeMtgDAO.deleteByPrimaryKey(nteNoticeMtg.getId());// 删除通知书中的押品信息
			}

		}
		String noticeNo = bSysSerialNoService.genSerialNo(ScfBasConstant.BUSSNO_TYPE_FBCD_JY_NOTICE_NO);
		noticeId = addNoticeBaseInfo(appliBaseInfo, bCrrGntyCon, mutiProtBaseInfo, ScfBasConstant.MORTGAGE_CHANGE_TYPE_RELESE,
				NoticeConstant.NOTICE_TYPE_127, noticeNo);

		// 通知书中的货物信息表
		AppliMortgageBaseQryVO commonQueryVO = new AppliMortgageBaseQryVO();
		commonQueryVO.setAppno(appno);
		List<BPbcAppliMtgInfo> applyMortgageList = bpbcapplimtginfoservice.getApplyMortgageList(commonQueryVO);
		addNoticeExchangeMortgageInfo(noticeId, applyMortgageList);
	}

	/**
	 * 换货时，通知书中的押品清单保存
	 * 
	 * @param noticeId
	 * @param applyMortgageList
	 * @throws ScubeBizException
	 * @author mengjiajia
	 * @date 2017年5月3日下午4:26:35
	 */
	public void addNoticeExchangeMortgageInfo(String noticeId, List<?> applyMortgageList) throws ScubeBizException {
		for (int i = 0; i < applyMortgageList.size(); i++) {
			BPbcAppliMtgInfo appliMortgageBaseInfo = (BPbcAppliMtgInfo) applyMortgageList.get(i);
			BNteNoticeMtg noticeMortgageInfo = new BNteNoticeMtg();
			BeanUtils.copyProperties(appliMortgageBaseInfo, noticeMortgageInfo);

			// 0：表示新入库。1:表示解除抵押，出库。
			if (ScfBasConstant.MORT_BIZ_TYPE_REPLACE_IN.equals(appliMortgageBaseInfo.getAppliMortBizType())) {
				noticeMortgageInfo.setMortgageType(ScfBasConstant.MORTGAGE_TYPE_IN);

			}
			if (ScfBasConstant.MORT_BIZ_TYPE_NORMAL_RECEIPT_OUT.equals(appliMortgageBaseInfo.getAppliMortBizType())
					|| ScfBasConstant.MORT_BIZ_TYPE_EXCHANGE_OUT.equals(appliMortgageBaseInfo.getAppliMortBizType())
					|| ScfBasConstant.MORT_BIZ_TYPE_DELIVERY_OUT.equals(appliMortgageBaseInfo.getAppliMortBizType())) {
				noticeMortgageInfo.setMortgageType(ScfBasConstant.MORTGAGE_TYPE_OUT);

			}
			noticeMortgageInfo.setPid(noticeId);
			noticeMortgageInfo.setManufacturer(appliMortgageBaseInfo.getManufacturer());
			bntenoticemtgservice.addBNteNoticeMtg(noticeMortgageInfo);
		}
	}

	/**
	 * 通过APPNO 生成通知书（0-押品价格确定调整通知书/2-押品变更通知书）
	 * 
	 * @param bussAppno
	 * @param appliType
	 * @throws ScubeBizException
	 * @author mengjiajia
	 * @date 2017年5月9日下午2:33:38
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public void addNoticeByMortgagePriceModify(String bussAppno, String appliType) throws ScubeBizException {
		BPbcAppliBaseInfo appliBaseInfo = bPbcAppliBaseInfoService.findBPbcAppliBaseInfoByKey(bussAppno);
		if (appliBaseInfo == null) {
			throw new ScubeBizException("主申请信息信息丢失，无法生成相关信息");
		}
		BCntMprotBaseInfo mutiProtBaseInfo = null;
		if (!StringUtil.isEmpty(appliBaseInfo.getProtocolNo())) {
			mutiProtBaseInfo = bcntmprotbaseinfoservice.findBCntMprotBaseInfoByKey(appliBaseInfo.getProtocolNo());
		}
		if (mutiProtBaseInfo == null) {
			throw new ScubeBizException("监管合同信息丢失，无法生成相关信息");
		}
		String noticeId = "";
		noticeId = addExchangeNoticeBaseInfo(appliBaseInfo, mutiProtBaseInfo, ScfBasConstant.MORTGAGE_CHANGE_TYPE_EXCHANGE,
				NoticeConstant.NOTICE_TYPE_0);
		addExchangeNoticeBaseInfo(appliBaseInfo, mutiProtBaseInfo, ScfBasConstant.MORTGAGE_CHANGE_TYPE_EXCHANGE, NoticeConstant.NOTICE_TYPE_2);

		// 通知书中的货物信息表
		if (WorkflowConstant.APPLI_TYPE_EXCHANGEAPPLI.equals(appliType)) {// 客户发起换货
																			// 新入库
			List inApplyMortgageList = bpbcapplimtginfoservice.getAppliMortgageByAppliMortBizType(bussAppno, ScfBasConstant.MORT_BIZ_TYPE_REPLACE_IN);
			addNoticeMortgageInfo(noticeId, inApplyMortgageList, ScfBasConstant.MORTGAGE_TYPE_IN);
			// 出库
			List outApplyMortgageList = bpbcapplimtginfoservice.getAppliMortgageByAppliMortBizType(bussAppno,
					ScfBasConstant.MORT_BIZ_TYPE_EXCHANGE_OUT);
			addNoticeMortgageInfo(noticeId, outApplyMortgageList, ScfBasConstant.MORTGAGE_TYPE_OUT);
		} else if (WorkflowConstant.APPLI_TYPE_BILL_NORMAL_EXCHANGE.equals(appliType)) {// 普通仓单置换申请
																						// 新入库
			List inApplyMortgageList = bpbcapplimtginfoservice.getAppliMortgageByAppliMortBizType(bussAppno,
					ScfBasConstant.MORT_BIZ_TYPE_NORMAL_EXCHANGE_IN);
			addNoticeMortgageInfo(noticeId, inApplyMortgageList, ScfBasConstant.MORTGAGE_TYPE_IN);
			// 出库
			List outApplyMortgageList = bpbcapplimtginfoservice.getAppliMortgageByAppliMortBizType(bussAppno,
					ScfBasConstant.MORT_BIZ_TYPE_NORMAL_EXCHANGE_OUT);
			addNoticeMortgageInfo(noticeId, outApplyMortgageList, ScfBasConstant.MORTGAGE_TYPE_OUT);
		}
	}

	/**
	 * @Description: 换货申请保存通知书
	 * @author xu_hong
	 * @Created 2013-1-17下午03:12:54
	 * @param appliBaseInfo
	 * @param contSlaveInfo
	 * @param mutiProtBaseInfo
	 * @param mortgageChangeType
	 * @param noticeType
	 * @return
	 * @throws CommonException
	 */
	@Transactional
	public String addExchangeNoticeBaseInfo(BPbcAppliBaseInfo appliBaseInfo, BCntMprotBaseInfo mutiProtBaseInfo, String mortgageChangeType,
			String noticeType) throws ScubeBizException {
		// 通知书基本信息表
		com.huateng.scf.bas.nte.dao.model.BNteNoticeBase noticeBaseInfo = new com.huateng.scf.bas.nte.dao.model.BNteNoticeBase();
		noticeBaseInfo.setAppno(appliBaseInfo.getAppno());
		String noticeNum = "";
		if (noticeType.equals(NoticeConstant.NOTICE_TYPE_0)) {
			noticeNum = bSysSerialNoService.genSerialNo(ScfBasConstant.BUSSNO_TYPE_0_NOTICE_NO);
			;// 通知书编号
		}
		if (noticeType.equals(NoticeConstant.NOTICE_TYPE_2)) {
			noticeNum = bSysSerialNoService.genSerialNo(ScfBasConstant.BUSSNO_TYPE_2_NOTICE_NO);
			;// 通知书编号
		}
		noticeBaseInfo.setId(UUIDGeneratorUtil.generate());
		noticeBaseInfo.setNum(String.valueOf(noticeNum));
		// noticeBaseInfo.setAdviceid(String.valueOf(noticeNum));
		noticeBaseInfo.setMonitorProtocolNo(appliBaseInfo.getProtocolNo());
		noticeBaseInfo.setProtocolCode(mutiProtBaseInfo != null ? mutiProtBaseInfo.getProtocolCode() : "");
		noticeBaseInfo.setSlaveContno(appliBaseInfo.getSlaveContno());
		noticeBaseInfo.setSlaveContcode(appliBaseInfo.getSlaveContno());
		noticeBaseInfo.setCustcd(appliBaseInfo.getCustcd());
		noticeBaseInfo.setNoticeType(noticeType);
		noticeBaseInfo.setMortgageChangeType(mortgageChangeType);
		noticeBaseInfo.setBrcode(bCntMprotPartInfoService.findCnameByProAndRole(appliBaseInfo.getProtocolNo(), ScfBasConstant.PROTOCOL_PART_ROLE_BANK,
				ScfBasConstant.RETURN_FLAG_CUSTCD));// 机构号
		// noticeBaseInfo.setPledgorDate(null);//抵押人/出质人签署日期
		// noticeBaseInfo.setPledgeeDate(new Date());//质权人签署日期
		noticeBaseInfo.setAppliDate(appliBaseInfo.getAppDate());
		noticeBaseInfo.setMoniOfCustcd(bCntMprotPartInfoService.findCnameByProAndRole(appliBaseInfo.getProtocolNo(),
				ScfBasConstant.PROTOCOL_PART_ROLE_MONI, ScfBasConstant.RETURN_FLAG_CUSTCD));// 监管人客户号
		noticeBaseInfo.setMoniOfName(bCntMprotPartInfoService.findCnameByProAndRole(appliBaseInfo.getProtocolNo(),
				ScfBasConstant.PROTOCOL_PART_ROLE_MONI, ScfBasConstant.RETURN_FLAG_CNAME));// 监管人名称
		// noticeBaseInfo.setMoniOfTimestamp(null);//监管公司(核库/巡库岗确认日期)回执日期
		noticeBaseInfo.setStatus(NoticeConstant.NOTICE_BASE_STATUS_UNCONFIRM);
		noticeBaseInfo.setCommonDate(appliBaseInfo.getAppDate());
		noticeBaseInfo.setTlrn("");
		// noticeBaseInfo.setMsrno(appliBaseInfo.getDescription());
		// if(NoticeConstants.NOTICE_TYPE_1.equals(noticeType)){
		// noticeBaseInfo.setProtLowPric(tblMutiProtBaseInfoDAO.get(appliBaseInfo.getProtocolNo()).getLowPriceNew());//监管下限
		// }else{
		// noticeBaseInfo.setProtLowPric(new BigDecimal(0.00));
		// }
		bNteNoticeBaseDAO.insertSelective(noticeBaseInfo);
		return noticeBaseInfo.getId();
	}

	/**
	 * @Description: 保存通知书中的货物信息(流程中)
	 * @author xu_hong
	 * @Created 2012-10-19上午10:25:17
	 * @param noticeId
	 * @param applyMortgageList
	 *            押品列表
	 * @param mortgageType
	 *            货物类型 0：表示新入库。1:表示解除抵押，出库。
	 * @throws ScubeBizException
	 */
	@Override
	public void addNoticeMortgageInfo(String noticeId, List<?> applyMortgageList, String mortgageType) throws ScubeBizException {
		for (int i = 0; i < applyMortgageList.size(); i++) {
			BPbcAppliMtgInfo appliMortgageBaseInfo = (BPbcAppliMtgInfo) applyMortgageList.get(i);
			BNteNoticeMtg noticeMortgageInfo = new BNteNoticeMtg();
			BeanUtils.copyProperties(appliMortgageBaseInfo, noticeMortgageInfo);
			noticeMortgageInfo.setMortgageType(mortgageType);// 货物类型
																// 0：表示新入库。1:表示解除抵押，出库。
			noticeMortgageInfo.setPid(noticeId);
			noticeMortgageInfo.setManufacturer(appliMortgageBaseInfo.getManufacturer());
			bntenoticemtgservice.addBNteNoticeMtg(noticeMortgageInfo);
		}
	}

	/**
	 * 现货静态动态核价通知书生成
	 * 
	 * @param bussAppno
	 * @param appliType
	 * @throws ScubeBizException
	 * @author lihao
	 * @date 2017年5月16日下午2:33:51
	 */
	@Override
	@Transactional
	public void addNoticeByMortgagePriceFloor(String appNo) throws ScubeBizException {
		BPbcAppliBaseInfo bPbcAppliBaseInfo = bPbcAppliBaseInfoService.findBPbcAppliBaseInfoByKey(appNo);
		if (bPbcAppliBaseInfo == null) {
			throw new ScubeBizException("申请号无法查询对应申请信息！");
		}
		List<com.huateng.scf.bas.pbc.model.BPbcAppliMtgInfo> applyMortgageList = bpbcapplimtginfoservice.findBPbcAppliMtgInfoByAppno(appNo);
		ArrayList<BPbcAppliMtgInfo> applyMortgageList2 = new ArrayList<BPbcAppliMtgInfo>();
		for (com.huateng.scf.bas.pbc.model.BPbcAppliMtgInfo bPbcAppliMtgInfo1 : applyMortgageList) {
			BPbcAppliMtgInfo bPbcAppliMtgInfo2 = new BPbcAppliMtgInfo();
			BeanUtils.copyProperties(bPbcAppliMtgInfo1, bPbcAppliMtgInfo2);
			applyMortgageList2.add(bPbcAppliMtgInfo2);
		}
		BCrrGntyCon bCrrGntyCon = bCrrGntyConService.findBCrrGntyConByConId(bPbcAppliBaseInfo.getSlaveContno());
		if (bCrrGntyCon == null) {
			throw new ScubeBizException("抵/质押合同关联失败，无对应抵/质押合同！");
		}
		BCntMprotBaseInfo bCntMprotBaseInfoMoni = bCntMprotBaseInfoService.findBCntMprotBaseInfoByKey(bCrrGntyCon.getPrtclNo());
		if (bCntMprotBaseInfoMoni == null) {
			throw new ScubeBizException("监管合同关联失败，无对应监管合同！");
		}
		// 监管公司名称
		BCntMprotPartInfo moniInfo = bCntMprotPartInfoService.findCustByProtocolNoAndRole(bCrrGntyCon.getPrtclNo(),
				ScfBasConstant.PROTOCOL_PART_ROLE_MONI);
		if (moniInfo == null || StringUtils.isEmpty(moniInfo.getCustcd())) {
			throw new ScubeBizException("监管公司信息查询失败！");
		}
		String moniModel = bCntMprotBaseInfoMoni.getMoniType(); // 默认监管模式为 2-静态
		String noticeNo0 = bSysSerialNoService.genSerialNo(ScfBasConstant.BUSSNO_TYPE_0_NOTICE_NO);
		String noticeNo90 = bSysSerialNoService.genSerialNo(ScfBasConstant.BUSSNO_TYPE_90_NOTICE_NO);
		if (ScfBasConstant.MONI_MODEL_DYNAMIC.equals(moniModel)) {// 动态
			// 押品价格确定调整通知书
			String noticeNo1 = bSysSerialNoService.genSerialNo(ScfBasConstant.BUSSNO_TYPE_1_NOTICE_NO);
			String noticeId0 = addNoticeBaseInfo(bPbcAppliBaseInfo, bCrrGntyCon, bCntMprotBaseInfoMoni, ScfBasConstant.MORTGAGE_CHANGE_TYPE_ADD,
					NoticeConstant.NOTICE_TYPE_0, noticeNo0);
			addNoticeMortgageInfo(noticeId0, applyMortgageList2, ScfBasConstant.MORTGAGE_TYPE_IN);
			// 押品监管下限通知书
			addNoticeBaseInfo(bPbcAppliBaseInfo, bCrrGntyCon, bCntMprotBaseInfoMoni, ScfBasConstant.MORTGAGE_CHANGE_TYPE_ADD,
					NoticeConstant.NOTICE_TYPE_1, noticeNo1);
			// 出质入库通知书
			String noticeId90 = addNoticeBaseInfo(bPbcAppliBaseInfo, bCrrGntyCon, bCntMprotBaseInfoMoni, ScfBasConstant.MORTGAGE_CHANGE_TYPE_ADD,
					NoticeConstant.NOTICE_TYPE_90, noticeNo90);
			addNoticeMortgageInfo(noticeId90, applyMortgageList2, ScfBasConstant.MORTGAGE_TYPE_IN);
		} else {// 静态
			// 押品价格确定调整通知书
			String noticeId0 = addNoticeBaseInfo(bPbcAppliBaseInfo, bCrrGntyCon, bCntMprotBaseInfoMoni, ScfBasConstant.MORTGAGE_CHANGE_TYPE_ADD,
					NoticeConstant.NOTICE_TYPE_0, noticeNo0);
			addNoticeMortgageInfo(noticeId0, applyMortgageList2, ScfBasConstant.MORTGAGE_TYPE_IN);
			// 出质入库通知书
			String noticeId90 = addNoticeBaseInfo(bPbcAppliBaseInfo, bCrrGntyCon, bCntMprotBaseInfoMoni, ScfBasConstant.MORTGAGE_CHANGE_TYPE_ADD,
					NoticeConstant.NOTICE_TYPE_90, noticeNo90);
			addNoticeMortgageInfo(noticeId90, applyMortgageList2, ScfBasConstant.MORTGAGE_TYPE_IN);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.huateng.scf.bas.nte.service.IBNteNoticeBaseService#
	 * modifyNoticeByMortgagePriceFloor(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public void modifyNoticeByMortgagePriceFloor(String appno) throws ScubeBizException {
		SBcpAppliLowerPrice sBcpAppliLowerPrice = sBcpAppliLowerPriceService.findsaveAppliLowPriceByAppno(appno);
		if (sBcpAppliLowerPrice == null) {
			throw new ScubeBizException("最低控货价值查询失败！");
		}
		BigDecimal lowPriceNew = sBcpAppliLowerPrice.getLowPriceNew();
		List<com.huateng.scf.bas.nte.dao.model.BNteNoticeBase> noticeBaseInfoList = getNoticeBaseInfoByAppno(appno);
		if (noticeBaseInfoList != null && noticeBaseInfoList.size() > 0) {
			for (int i = 0; i < noticeBaseInfoList.size(); i++) {
				com.huateng.scf.bas.nte.dao.model.BNteNoticeBase tblNoticeBaseInfo = noticeBaseInfoList.get(i);
				BNteNoticeBase bNteNoticeBase = new BNteNoticeBase();
				BeanUtils.copyProperties(tblNoticeBaseInfo, bNteNoticeBase);
				// 根据APPNO 与 NOTICEID更新监管下限
				if ((tblNoticeBaseInfo.getNoticeType()).equals(NoticeConstant.NOTICE_TYPE_1)) {// 监管下限
					tblNoticeBaseInfo.setExt1Amount(lowPriceNew);
					updateBNteNoticeBase(bNteNoticeBase);
				} //// 根据APPNO 与 NOTICEID更新押品
				else if (tblNoticeBaseInfo.getNoticeType().equals(NoticeConstant.NOTICE_TYPE_0)
						|| (tblNoticeBaseInfo.getNoticeType()).equals(NoticeConstant.NOTICE_TYPE_90)) {
					// 押品价格确定通知书 押品出质通知书(先删除原有的再新增)
					bntenoticemtgservice.deleteBNteNoticeMtgByAppno(appno);
					// 通知书中的货物信息表
					AppliMortgageBaseQryVO commonQueryVO = new AppliMortgageBaseQryVO();
					commonQueryVO.setAppno(appno);
					List<BPbcAppliMtgInfo> applyMortgageList = bpbcapplimtginfoservice.getApplyMortgageList(commonQueryVO);
					addNoticeMortgageInfo(tblNoticeBaseInfo.getId(), applyMortgageList, ScfBasConstant.MORTGAGE_TYPE_IN);
				}
			}
		} else {
			log.error("申请基本信息:通知书信息丢失!");
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BNteErrorConstant.SCF_BAS_NTE_10004), BNteErrorConstant.SCF_BAS_NTE_10004);
		}
	}
	
	/**
	 * 通过APPNO 生成应收账款折让通知书（国内保理）
	 * @param bussAppno
	 * @param factType
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年6月5日下午3:03:53
	 */
	@Override
	public void addNoticeAllowanceByAppno(String bussAppno,String factType) throws ScubeBizException
	{
		//获取Tbl_Appli_Buss_Info
		RBcpAppliBussInfo appliBussInfo = nrbcpapplibussinfoservice.findBcpAppliBussInfoByAppno(bussAppno);
		AppliBussInfoVO debt_VO = new AppliBussInfoVO();
		BeanUtils.copyProperties(appliBussInfo, debt_VO);
		BigDecimal amount = debt_VO.getAmount();//折让金额
		//调用应收账款管理公共方法
		this.saveFactoringNotice(debt_VO,amount,NoticeConstant.NOTICE_TYPE_17);
	}
}
