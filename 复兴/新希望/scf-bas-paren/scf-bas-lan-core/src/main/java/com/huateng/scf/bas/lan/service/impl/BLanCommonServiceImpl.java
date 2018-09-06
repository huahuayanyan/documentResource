package com.huateng.scf.bas.lan.service.impl;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

import com.huateng.scf.bas.cnt.dao.IBCntBuyInfoDAO;
import com.huateng.scf.bas.cnt.dao.model.BCntBuyInfo;
import com.huateng.scf.bas.common.constant.ScfBasConstant;
import com.huateng.scf.bas.common.startup.ScfMessageUtil;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.common.util.UUIDGeneratorUtil;
import com.huateng.scf.bas.crm.dao.IBCrmBaseInfoDAO;
import com.huateng.scf.bas.crr.dao.IBCrrDuebillAppDAO;
import com.huateng.scf.bas.crr.dao.IBCrrGntyConDAO;
import com.huateng.scf.bas.crr.dao.IBCrrLnConDAO;
import com.huateng.scf.bas.crr.dao.model.BCrrBillInfo;
import com.huateng.scf.bas.crr.dao.model.BCrrDuebillApp;
import com.huateng.scf.bas.crr.dao.model.BCrrGntyCon;
import com.huateng.scf.bas.crr.dao.model.BCrrLnCon;
import com.huateng.scf.bas.icr.dao.IBIcrInfoDAO;
import com.huateng.scf.bas.icr.dao.model.BIcrInfo;
import com.huateng.scf.bas.lan.constant.BLanErrorConstant;
import com.huateng.scf.bas.lan.dao.IBLanAppliBillInfoDAO;
import com.huateng.scf.bas.lan.dao.IBLanAppliLnciBaseDAO;
import com.huateng.scf.bas.lan.dao.IBLanBillBaseInfoDAO;
import com.huateng.scf.bas.lan.dao.IBLanLnciBaseDAO;
import com.huateng.scf.bas.lan.dao.IBLanLnciBuyBizDAO;
import com.huateng.scf.bas.lan.dao.IBLanLnciBuyInfoDAO;
import com.huateng.scf.bas.lan.dao.model.BLanAppliBillInfo;
import com.huateng.scf.bas.lan.dao.model.BLanBillBaseInfo;
import com.huateng.scf.bas.lan.dao.model.BLanLnciBase;
import com.huateng.scf.bas.lan.dao.model.BLanLnciBuyBiz;
import com.huateng.scf.bas.lan.dao.model.BLanLnciBuyInfo;
import com.huateng.scf.bas.lan.model.BLanAppliLnciBase;
import com.huateng.scf.bas.lan.service.IBLanCommonService;
import com.huateng.scf.bas.lan.service.IBLanLnciBuyInfoService;
import com.huateng.scf.bas.mrn.dao.IBMrnAcctBussInfoDAO;
import com.huateng.scf.bas.mrn.dao.IBMrnAppliAcctInfoDAO;
import com.huateng.scf.bas.mrn.dao.model.BMrnAcctBussInfo;
import com.huateng.scf.bas.mrn.dao.model.BMrnAppliAcctInfo;
import com.huateng.scf.bas.pbc.dao.IBPbcAppliBaseInfoDAO;
import com.huateng.scf.bas.pbc.dao.IBPbcMtgBaseInfoDAO;
import com.huateng.scf.bas.pbc.model.BPbcAppliBaseInfo;
import com.huateng.scf.bas.pbc.service.IAmountService;
import com.huateng.scf.bas.pbc.service.IBPbcAppliBaseInfoService;
import com.huateng.scf.bas.prd.dao.IBPrdCreditBindDAO;
import com.huateng.scf.bas.prd.dao.IBPrdInfoDAO;
import com.huateng.scf.bas.prd.dao.model.BPrdCreditBind;
import com.huateng.scf.bas.prd.dao.model.BPrdInfo;
import com.huateng.scf.bas.sys.constant.BSysErrorConstant;
import com.huateng.scf.bas.sys.constant.WorkflowConstant;
import com.huateng.scf.bas.sys.service.IBSysSerialNoService;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * <p>
 * </p>
 *
 * @author liph
 * @date 2016年12月14日下午4:40:20
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 *            <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * liph		2016年12月14日下午4:40:20	     新增
 *
 *            </pre>
 */
@ScubeService
@Service("BLanCommonServiceImpl")
public class BLanCommonServiceImpl implements IBLanCommonService 
{
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
	
	@Resource(name = "BCntBuyInfoDAO")
	IBCntBuyInfoDAO ibCntBuyInfoDAO;
	
	@Resource(name = "BLnaLnciBuyBizDAO")
	IBLanLnciBuyBizDAO ibLanLnciBuyBizDAO;
	
	@Resource(name = "BLanLnciBuyInfoDAO")
	IBLanLnciBuyInfoDAO ibLanLnciBuyInfoDAO;
	
	@Resource(name = "BLanLnciBaseDAO")
	IBLanLnciBaseDAO ibLanLnciBaseDAO;
	
	@Resource(name = "BMrnAcctBussInfoDAO")
	IBMrnAcctBussInfoDAO ibMrnAcctBussInfoDAO;
	
	@Resource(name = "BLanBillBaseInfoDAO")
	IBLanBillBaseInfoDAO ibLanBillBaseInfoDAO;
	
	@Resource(name = "IBCrrDuebillAppDAO")
	IBCrrDuebillAppDAO bcrrduebillappdao;
	
	@Resource(name = "IBCrrGntyConDAO")
	IBCrrGntyConDAO ibCrrGntyConDAO;
	
	@Resource(name = "BPbcMtgBaseInfoDAO")
	IBPbcMtgBaseInfoDAO ibPbcMtgBaseInfoDAO;
	
	@Resource(name = "BPrdCreditBindDAO")
	IBPrdCreditBindDAO ibPrdCreditBindDAO;
	
	@Resource(name = "BIcrInfoDAO")
	IBIcrInfoDAO ibIcrInfoDAO;
	
	@Resource(name = "AmountServiceImpl")
	IAmountService amountService;
	
	@Resource(name = "bSysSerialNoService")
	IBSysSerialNoService bSysSerialNoService;
	
	@Resource(name = "BPbcAppliBaseInfoServiceImpl")
	IBPbcAppliBaseInfoService bpbcapplibaseinfoservice;
	
	// 放款申请购销合同申请表
	@Resource(name = "BLanLnciBuyInfoServiceImpl")
	IBLanLnciBuyInfoService bLanLnciBuyInfoService;

	/**
	 * @author liph 业务申请主表插入
	 */
	@Transactional
	@Override
	public void saveBPbcAppliBaseInfo(BPbcAppliBaseInfo bPbcAppliBaseInfo, String originalAppliStatus, String appno) throws ScubeBizException {
		// 申请表保存
		if (StringUtil.isEmpty(bPbcAppliBaseInfo.getAppno())) 
		{
			bPbcAppliBaseInfo.setAppno(appno);
			if (StringUtil.isEmpty(bPbcAppliBaseInfo.getBusinessno())) 
			{
				bPbcAppliBaseInfo.setBusinessno(appno);
			}
			if (StringUtil.isEmpty(bPbcAppliBaseInfo.getChannelFlag())) {
				bPbcAppliBaseInfo.setChannelFlag(ScfBasConstant.CHANNEL_FLAG_SCF);
			}
			if (StringUtil.isEmpty(bPbcAppliBaseInfo.getIsFlowEnd())) {
				bPbcAppliBaseInfo.setIsFlowEnd(ScfBasConstant.FLAG_OFF);
			}
			bpbcapplibaseinfoservice.addBPbcAppliBaseInfo(bPbcAppliBaseInfo);
		} else {
			bpbcapplibaseinfoservice.updateBPbcAppliBaseInfo(bPbcAppliBaseInfo);
		}
	}

	/**
	 * @author liph 借据申请信息插入
	 */
	@Transactional
	@Override
	public String saveBLanAppliLnciBase(String appno, BLanAppliLnciBase bLanAppliLnciBase) throws ScubeBizException {
		com.huateng.scf.bas.lan.dao.model.BLanAppliLnciBase appliLnciBase = new com.huateng.scf.bas.lan.dao.model.BLanAppliLnciBase();
		BeanUtils.copyProperties(bLanAppliLnciBase, appliLnciBase);
		List list = ibLanAppliLnciBaseDAO.selectByAppNo(appno);
		appliLnciBase.setId(UUIDGeneratorUtil.generate());
		appliLnciBase.setDebetNo(UUIDGeneratorUtil.generate());
		if (list == null || list.size() == 0) {
			ibLanAppliLnciBaseDAO.insert(appliLnciBase);
		} else {
			for (int i = 0; i < list.size(); i++) {
				appliLnciBase = (com.huateng.scf.bas.lan.dao.model.BLanAppliLnciBase) list.get(i);
				ibLanAppliLnciBaseDAO.updateByPrimaryKey(appliLnciBase);
			}
		}
		return appliLnciBase.getDebetNo();
	}

	/**
	 * @author liph 保证金保存
	 */
	@Transactional
	@Override
	public void saveBMrnAppliAcctInfo(String appno, List baiList) {
		List<BMrnAppliAcctInfo> list = ibMrnAppliAcctInfoDAO.selectByAppno(appno);
		BMrnAppliAcctInfo bailInfo = null;
		BMrnAppliAcctInfo orgbailInfo = null;
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				orgbailInfo = (BMrnAppliAcctInfo) list.get(i);
				ibMrnAppliAcctInfoDAO.deleteByPrimaryKey(orgbailInfo.getId());
			}
		}
		if (baiList != null && baiList.size() > 0) {
			for (int j = 0; j < baiList.size(); j++) {
				bailInfo = (BMrnAppliAcctInfo) baiList.get(j);
				bailInfo.setId(UUIDGeneratorUtil.generate());
				ibMrnAppliAcctInfoDAO.insert(bailInfo);
			}
		}
	}

	/**
	 * @author liph 票据信息保存
	 */
	@Transactional
	@Override
	public void saveBLanApplyBillInfo(String appno, String debetno, Map map) throws ScubeBizException{
		List<BCrrBillInfo> list = (List) map.get("list");
		BCrrBillInfo repayBill = null;
		String contno = (String) map.get("APP_ID");// 信贷合同号
		BCrrLnCon bCrrLnCon = ibCrrLnConDAO.selectByPrimaryKey(contno);
		for (int i = 0; i < list.size(); i++) {
			repayBill = list.get(i);
			BLanAppliBillInfo bLanAppliBillInfo = ibLanAppliBillInfoDAO.selectByBillId(repayBill.getBillId());
			if (bLanAppliBillInfo == null) {// 票据的新增
				bLanAppliBillInfo = new BLanAppliBillInfo();
				bLanAppliBillInfo.setId(UUIDGeneratorUtil.generate());
				bLanAppliBillInfo.setBillNo(repayBill.getBillNo());
				bLanAppliBillInfo.setBillId(repayBill.getBillId());
				bLanAppliBillInfo.setBillDate(repayBill.getWrtDt());
				bLanAppliBillInfo.setBillEndDate(repayBill.getMtrDt());
				SimpleDateFormat sim = new SimpleDateFormat("yyyyMMdd");
				Date start = null;
				Date end = null;
				try {
					start = sim.parse(repayBill.getWrtDt());
					end = sim.parse(repayBill.getMtrDt());
				} catch (ParseException e) {
					e.printStackTrace();
				}
				Long loanDays = new Long("0");
				if (!(start == null) && !(end == null)) {
					loanDays = (end.getTime() - start.getTime()) / (24 * 60 * 60 * 1000);
				}
				bLanAppliBillInfo.setLoanDays(loanDays.toString());
				bLanAppliBillInfo.setDrawer(repayBill.getWrtNm());// 出票人名称
				bLanAppliBillInfo.setAcceptor(repayBill.getAcptNm());// 承兑人名称
				bLanAppliBillInfo.setDrawerAccount(repayBill.getWrtId());// 出票人帐号
				bLanAppliBillInfo.setReceiverName(repayBill.getGatrNm());// 收款人名称
				bLanAppliBillInfo.setBussContno(repayBill.getTradConNo());// 贸易合同号
				bLanAppliBillInfo.setAppno(appno);
				bLanAppliBillInfo.setDebetNo(debetno);
				//bLanAppliBillInfo.setDebetId((String) map.get("VID_NO"));// 借据号--协议号
				bLanAppliBillInfo.setDebetId(appno);// 借据号--协议号 //0003237
				bLanAppliBillInfo.setProductId((String) map.get("PRD_ID"));
				bLanAppliBillInfo.setBusiFlag(ScfBasConstant.BILLS_BUSI_FLAG_PROMISSORY);//
				bLanAppliBillInfo.setElecFlag((String) map.get("ELEC_FLG"));// 电票标识
				bLanAppliBillInfo.setAmount(repayBill.getBillSum());// 票面金额
				if (bCrrLnCon != null) {
					bLanAppliBillInfo.setMastContno(bCrrLnCon.getAppId());
				}
				bLanAppliBillInfo.setLoanNo(repayBill.getExtId());
				ibLanAppliBillInfoDAO.insert(bLanAppliBillInfo);// 申请表保存
			} else {
				bLanAppliBillInfo.setBillNo(repayBill.getBillNo());
				bLanAppliBillInfo.setBillId(repayBill.getBillId());
				bLanAppliBillInfo.setBillDate(repayBill.getWrtDt());
				bLanAppliBillInfo.setBillEndDate(repayBill.getMtrDt());
				SimpleDateFormat sim = new SimpleDateFormat("yyyyMMdd");
				Date start = null;
				Date end = null;
				try {
					start = sim.parse(repayBill.getWrtDt());
					end = sim.parse(repayBill.getMtrDt());
				} catch (ParseException e) {
					e.printStackTrace();
				}
				Long loanDays = new Long("0");
				if (!(start == null) && !(end == null)) {
					loanDays = (end.getTime() - start.getTime()) / (24 * 60 * 60 * 1000);
				}
				bLanAppliBillInfo.setLoanDays(loanDays.toString());
				bLanAppliBillInfo.setDrawer(repayBill.getWrtNm());// 出票人名称
				bLanAppliBillInfo.setAcceptor(repayBill.getAcptNm());// 承兑人名称
				bLanAppliBillInfo.setDrawerAccount(repayBill.getWrtId());// 出票人帐号
				bLanAppliBillInfo.setReceiverName(repayBill.getGatrNm());// 收款人名称
				bLanAppliBillInfo.setBussContno(repayBill.getTradConNo());// 贸易合同号
				bLanAppliBillInfo.setAppno(appno);
				bLanAppliBillInfo.setDebetNo(debetno);
				bLanAppliBillInfo.setDebetId((String) map.get("VID_NO"));// 借据号--协议号
				bLanAppliBillInfo.setProductId((String) map.get("PRD_ID"));
				bLanAppliBillInfo.setBusiFlag(ScfBasConstant.BILLS_BUSI_FLAG_PROMISSORY);//
				bLanAppliBillInfo.setElecFlag((String) map.get("ELEC_FLG"));// 电票标识
				bLanAppliBillInfo.setAmount(repayBill.getBillSum());// 票面金额
				if (bCrrLnCon != null) {
					bLanAppliBillInfo.setMastContno(bCrrLnCon.getAppId());
				}
				bLanAppliBillInfo.setLoanNo(repayBill.getExtId());
				ibLanAppliBillInfoDAO.updateByPrimaryKey(bLanAppliBillInfo);
			}
		}
	}

	/**
	 * 审批通过/提交按钮触发业务逻辑
	 */
	@Transactional
	@Override
	public void saveLoanInfo(String appno, String result, Map map) throws ScubeBizException{
		com.huateng.scf.bas.lan.dao.model.BLanAppliLnciBase bLanAppliLnciBase = ibLanAppliLnciBaseDAO.selectByAppno(appno);
		BCrrDuebillApp bCrrDuebillApp = bcrrduebillappdao.selectByPrimaryKey(appno);

		String mastContno = bCrrDuebillApp.getAppId();
		BCrrLnCon bCrrLnCon = ibCrrLnConDAO.selectByPrimaryKey(mastContno);
		String lnciType = bLanAppliLnciBase.getLnciType(); // 出账方式
		BLanLnciBase lnciBase = new BLanLnciBase();
		try {
			BeanUtils.copyProperties(bLanAppliLnciBase, lnciBase);
		} catch (BeansException e) {
			log.warn("转换异常", e);
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BSysErrorConstant.SCF_BAS_DCR_50000), BSysErrorConstant.SCF_BAS_DCR_50000);
		}

		String debetNo = lnciBase.getDebetNo();// 主键

		String cino = bSysSerialNoService.genSerialNo("DUE_NO");// 借据流水号
		lnciBase.setDebetId(cino);
		lnciBase.setLnciStatus(ScfBasConstant.LNCI_STATUS_NORMAL);// 借据状态
		lnciBase.setState(ScfBasConstant.LNCI_STATE_0);// 信贷放款通过时借据记录状态直接为正常
		lnciBase.setIsSettle(ScfBasConstant.FLAG_OFF);
		lnciBase.setConfirmStatus(ScfBasConstant.LNCI_CONFIRM_NOTRECEIVED);
		lnciBase.setTimestamps(new Date());// 记录更新时间
		if (map != null) {
			lnciBase.setPayBrcode(((String) map.get("payBrcode")));// 放款机构
			lnciBase.setPayTlrno(((String) map.get("payTlrno")));// 放款员
			lnciBase.setPayChecker(((String) map.get("payChecker")));// 放款复核员
		}
		BLanLnciBase bLanLnciBase = ibLanLnciBaseDAO.selectByPrimaryKey(debetNo);
		//1- 借据申请表数据插入到借据正式表里面
		try {
			if (bLanLnciBase == null) {
				ibLanLnciBaseDAO.insert(lnciBase);
			} else {
				ibLanLnciBaseDAO.updateByPrimaryKey(lnciBase);
			}

		} catch (Exception e) {
			log.info("插入借据正式表异常");
			e.printStackTrace();
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BLanErrorConstant.SCF_BAS_LAN_20000), BLanErrorConstant.SCF_BAS_LAN_20000);
		}
		//1-1 将借据申请表中的借据号回显到借据申请表中
		this.updateBLanAppliLnciBase(appno,lnciBase.getDebetId());
		// 2-保存保证金列表信息
		List list = ibMrnAppliAcctInfoDAO.selectByAppno(appno);
		BMrnAppliAcctInfo bMrnAppliAcctInfo = null;
		BMrnAcctBussInfo bMrnAcctBussInfo = null;
		List list1 = ibMrnAcctBussInfoDAO.selectByAppno(appno);
		if (list1!=null&&list1.size() > 0) {
			for (int i = 0; i < list1.size(); i++) {
				BMrnAcctBussInfo bMrnAcctBussInfo1 = (BMrnAcctBussInfo) list1.get(i);
				try {
					ibMrnAcctBussInfoDAO.deleteByPrimaryKey(bMrnAcctBussInfo1.getId());
				} catch (Exception e) {
					log.info("保证金删除异常");
					e.printStackTrace();
					throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BLanErrorConstant.SCF_BAS_LAN_20000),
							BLanErrorConstant.SCF_BAS_LAN_20000);
				}
			}
		}
		if (list!=null&&list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				bMrnAcctBussInfo = new BMrnAcctBussInfo();
				bMrnAppliAcctInfo = (BMrnAppliAcctInfo) list.get(i);
				BeanUtils.copyProperties(bMrnAppliAcctInfo, bMrnAcctBussInfo);
				try {
					if (StringUtil.isEmpty(bMrnAcctBussInfo.getId())) {
						bMrnAcctBussInfo.setId(UUIDGeneratorUtil.generate());
					}
					ibMrnAcctBussInfoDAO.insert(bMrnAcctBussInfo);
				} catch (Exception e) {
					log.info("保证金插入异常");
					e.printStackTrace();
					throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BLanErrorConstant.SCF_BAS_LAN_20000),
							BLanErrorConstant.SCF_BAS_LAN_20000);
				}
			}
		}
		// 3-开票业务，需要保存开票信息
		if (ScfBasConstant.ACCOUNT_WAY_BILL.equals(lnciType)) {
			List applibilllist = ibLanAppliBillInfoDAO.selectByAppno(appno);
			List billlist = ibLanBillBaseInfoDAO.selectByAppno(appno);
			if (billlist!=null&&billlist.size() > 0) {
				for (int i = 0; i < billlist.size(); i++) {
					BLanBillBaseInfo bLanBillBaseInfo = (BLanBillBaseInfo) billlist.get(i);
					try {
						ibLanBillBaseInfoDAO.deleteByPrimaryKey(bLanBillBaseInfo.getBillId());
					} catch (Exception e) {
						log.info("票据信息删除异常");
						throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BLanErrorConstant.SCF_BAS_LAN_20000),
								BLanErrorConstant.SCF_BAS_LAN_20000);
					}
				}
			}
			if (applibilllist!=null&&applibilllist.size() > 0) {
				int count = applibilllist.size();
				BLanAppliBillInfo applibill = null;
				BLanBillBaseInfo bLanBillBaseInfo = null;
				for (int i = 0; i < count; i++) {
					bLanBillBaseInfo = new BLanBillBaseInfo();
					applibill = (BLanAppliBillInfo) applibilllist.get(i);
					BeanUtils.copyProperties(applibill, bLanBillBaseInfo);
					bLanBillBaseInfo.setIsLocked("0");
					bLanBillBaseInfo.setStatus(ScfBasConstant.FLAG_ON);
					try {
						ibLanBillBaseInfoDAO.insert(bLanBillBaseInfo);
					} catch (Exception e) {
						log.info("票据信息插入异常");
						e.printStackTrace();
						throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BLanErrorConstant.SCF_BAS_LAN_20000),
								BLanErrorConstant.SCF_BAS_LAN_20000);
					}
				}
			}
		}
		// 业务种类，产品种类获取--分的不详细跟出账方式代码是相同的
		String bussType = "";
		if (map != null) {
			bussType = (String) map.get("VID_BUSI_TYP");// 业务品种--业务小类
		} else {
			bussType = bCrrLnCon.getVidBusiTyp();
		}

		BPrdInfo bPrdInfo = ibPrdInfoDAO.selectByPrimaryKey(bussType);
		if (bPrdInfo == null) {
			log.info("业务种类获取大类为空");
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BLanErrorConstant.SCF_BAS_LAN_20002), BLanErrorConstant.SCF_BAS_LAN_20002);
		}
		//原来放款申请的购销合同表的正式表和申请表弄反了
		// 先票款后货\担保提货 保存购销合同信息至正式表当中
		String bigProductId = bPrdInfo.getParentId();// 产品种类--产品大类：预付类
		if (ScfBasConstant.PRODUCT_TYPE_PREP.equals(bigProductId)) {// 预付类
			//if (ScfBasConstant.PRODUCT_TYPE_SMALL_WH.equals(bussType)||ScfBasConstant.PRODUCT_TYPE_XPHH.equals(bussType)) {// 担保提货
			if (ScfBasConstant.PRODUCT_TYPE_SMALL_WH.equals(bussType)) {// 担保提货
				List buyList = ibLanLnciBuyBizDAO.selectByAppno(appno);
				for (int i = 0; i < buyList.size(); i++) {
					BLanLnciBuyBiz buyBiz = (BLanLnciBuyBiz) buyList.get(i);
					BLanLnciBuyInfo bLanLnciBuyInfo = new BLanLnciBuyInfo();
					BeanUtils.copyProperties(buyBiz, bLanLnciBuyInfo);
					bLanLnciBuyInfo.setAccuLoanAmt(buyBiz.getAccuLoanAmt().add(buyBiz.getLoanAmt()));// --主键未添加--------------------------
					//补录借据号
					//buyBiz.setDebetNo(debetNo);
					// 将购销合同信息存入正式表当中
					try {
						ibLanLnciBuyInfoDAO.insert(bLanLnciBuyInfo);
					} catch (Exception e) {
						log.info("购销合同正式表插入失败");
						throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BLanErrorConstant.SCF_BAS_LAN_20000),
								BLanErrorConstant.SCF_BAS_LAN_20000);
					}
					// 更新购销合同累计出账金额
					String tradeContno = bLanLnciBuyInfo.getTradeContno();
					BigDecimal loanAmt = bLanLnciBuyInfo.getLoanAmt() == null ? BigDecimal.ZERO : bLanLnciBuyInfo.getLoanAmt();// 本次出账金额
					BCntBuyInfo buyInfo = ibCntBuyInfoDAO.selectByPrimaryKey(tradeContno);
					BigDecimal totalAmt = buyInfo.getTotAmt() == null ? BigDecimal.ZERO : buyInfo.getTotAmt();
					buyInfo.setTotAmt(totalAmt.add(loanAmt));
					try {
						ibCntBuyInfoDAO.updateByPrimaryKey(buyInfo);
					} catch (Exception e) {
						log.info("购销合同信息更新异常");
						throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BLanErrorConstant.SCF_BAS_LAN_20000),
								BLanErrorConstant.SCF_BAS_LAN_20000);
					}
					// 释放审批中的累计出账金额
					this.realseLoanRemainAmtOut(appno);
				}
			}
			//TODO 上面的担保提货需要todo
			//if (ScfBasConstant.PRODUCT_TYPE_SMALL_WH.equals(bussType)||ScfBasConstant.PRODUCT_TYPE_XPHH.equals(bussType)) {// 担保提货，先票款后货
			if (ScfBasConstant.PRODUCT_TYPE_XPHH.equals(bussType)) {// 担保提货，先票款后货
				List<com.huateng.scf.bas.lan.model.BLanLnciBuyInfo> buyList = bLanLnciBuyInfoService.findBLanLnciBuyInfoByAppno(appno);
				for (int i = 0; i < buyList.size(); i++) {
					com.huateng.scf.bas.lan.model.BLanLnciBuyInfo bLanLnciBuyInfo = (com.huateng.scf.bas.lan.model.BLanLnciBuyInfo) buyList.get(i);
					BLanLnciBuyBiz buyBiz = new BLanLnciBuyBiz();
					BeanUtils.copyProperties(bLanLnciBuyInfo,buyBiz);
					buyBiz.setAccuLoanAmt(buyBiz.getAccuLoanAmt().add(buyBiz.getLoanAmt()));// --主键未添加--------------------------
					//补录借据号
					buyBiz.setDebetNo(debetNo);
					// 将购销合同信息存入正式表当中
					try {
						ibLanLnciBuyBizDAO.insert(buyBiz);
					} catch (Exception e) {
						log.info("购销合同正式表插入失败");
						throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BLanErrorConstant.SCF_BAS_LAN_20000),
								BLanErrorConstant.SCF_BAS_LAN_20000);
					}
					
					// 更新购销合同累计出账金额
					String tradeContno = bLanLnciBuyInfo.getTradeContno();
					BigDecimal loanAmt = bLanLnciBuyInfo.getLoanAmt() == null ? BigDecimal.ZERO : bLanLnciBuyInfo.getLoanAmt();// 本次出账金额
					BCntBuyInfo buyInfo = ibCntBuyInfoDAO.selectByPrimaryKey(tradeContno);
					BigDecimal totalAmt = buyInfo.getTotAmt() == null ? BigDecimal.ZERO : buyInfo.getTotAmt();
					buyInfo.setTotAmt(totalAmt.add(loanAmt));
					try {
						ibCntBuyInfoDAO.updateByPrimaryKey(buyInfo);
					} catch (Exception e) {
						log.info("购销合同信息更新异常");
						throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BLanErrorConstant.SCF_BAS_LAN_20000),
								BLanErrorConstant.SCF_BAS_LAN_20000);
					}
					// 释放审批中的累计出账金额
					this.realseLoanRemainAmtOut(appno);
				}
			}
		}
	}

	/**
	 * @author liph
	 * @descript 出账金额释放
	 */
	@Transactional
	public void realseLoanRemainAmtOut(String appno) {
		List list = ibLanLnciBuyBizDAO.selectByAppno(appno);
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				BLanLnciBuyBiz bLanLnciBuyBiz = (BLanLnciBuyBiz) list.get(i);
				BigDecimal loanAmt = bLanLnciBuyBiz.getLoanAmt();// 本次出账金额
				String tradeContno = bLanLnciBuyBiz.getTradeContno();
				BCntBuyInfo buyInfo = ibCntBuyInfoDAO.selectByPrimaryKey(tradeContno);
				if (buyInfo != null) {
					BigDecimal remainAmtOut = buyInfo.getRemainAmt() == null ? BigDecimal.ZERO : buyInfo.getRemainAmt();
					buyInfo.setRemainAmt(remainAmtOut.subtract(loanAmt));
					ibCntBuyInfoDAO.updateByPrimaryKey(buyInfo);
				}
			}
		}
	}

	/**
	 * 金额校验--现货抵押--银承
	 */
	/**
	 * @author liph 金额校验
	 */
	@Transactional
	public void checkLoanApplyInfo(String appno, BigDecimal appInitCashEqtAmt) {
		com.huateng.scf.bas.lan.dao.model.BLanAppliLnciBase bLanAppliLnciBase = ibLanAppliLnciBaseDAO.selectByAppno(appno);
		String mastContcode = bLanAppliLnciBase.getMastContcode();
		com.huateng.scf.bas.pbc.dao.model.BPbcAppliBaseInfo bPbcAppliBaseInfo = ibPbcAppliBaseInfoDAO.selectByPrimaryKey(appno);
		BCrrLnCon bCrrLnCon = ibCrrLnConDAO.selectByPrimaryKey(mastContcode);
		String cycle = bCrrLnCon.getControlType();
		if (StringUtil.isEmpty(cycle)) {
			cycle = ScfBasConstant.CONT_CREDIT_NOCYCLE;
		}
		String supplyChainPdId = bPbcAppliBaseInfo.getSupplyChainPdId();
		BPrdInfo bPrdInfo = ibPrdInfoDAO.selectByPrimaryKey(supplyChainPdId);
		String parentId = "";
		if (bPrdInfo != null) {
			parentId = bPrdInfo.getParentId();
		}
		// 获得合同项下的所有的借据金额、借据敞口余额。
		BigDecimal totalLnciamt = BigDecimal.ZERO; // 合同项目下的借据总金额
		BigDecimal contAmount = bCrrLnCon.getLnAmt(); // 信贷合同金额
		//BigDecimal riskAmt = bCrrLnCon.getLnAmt(); // 敞口金额---------------------------供应链老系统的区别
		BigDecimal riskAmt = BigDecimal.ZERO;// 信贷合同可用敞口
		BigDecimal avalibalRiskAmt = null; // 质押合同下的敞口余额

		BigDecimal totalMortgageValue = BigDecimal.ZERO;// 押品总价值
		BigDecimal tempRistAmt = BigDecimal.ZERO;// 本笔风险敞口

		// 计算本笔风险敞口
		BigDecimal bailAmount1 = bLanAppliLnciBase.getBailAmount() == null ? BigDecimal.ZERO : bLanAppliLnciBase.getBailAmount();
		BigDecimal initCashEqtAmt1 = appInitCashEqtAmt == null ? BigDecimal.ZERO : appInitCashEqtAmt;
		BigDecimal lnciBal1 = bLanAppliLnciBase.getLnciBal() == null ? BigDecimal.ZERO : bLanAppliLnciBase.getLnciBal();
		tempRistAmt = lnciBal1.subtract(bailAmount1).subtract(initCashEqtAmt1);
		totalLnciamt = ibLanLnciBaseDAO.getTotalLoanAmtInContInfo(bCrrLnCon.getAppId());
		// 获取合同下的敞口余额
		BigDecimal contRistAmtTemp = this.getContRiskAmtByCycle(bCrrLnCon.getAppId(), cycle);
		riskAmt = bCrrLnCon.getLnAmt() == null ? BigDecimal.ZERO : bCrrLnCon.getLnAmt().subtract(contRistAmtTemp);
		// 1-校验合同的可用额度是否足够
		// 1.1 不可循环额度合同。
		// 规则1：信贷合同项下所有借据金额 + 本次放款金额 <= 信贷合同金额
		// 规则2：∑（借据金额-初始保证金金额-初始现金等价物金额）+本次放款敞口<=合同总敞口
		if (ScfBasConstant.CONT_CREDIT_NOCYCLE.equals(cycle)) {
			List<Map> listTemp = ibLanAppliLnciBaseDAO.getFlowKindsOfSumByMastContno(bCrrLnCon.getAppId());
			if (listTemp!=null&&listTemp.size() > 0) {
				Map map = listTemp.get(0);
				BigDecimal flowLnciRiskAmt = BigDecimal.ZERO;
				if (map.get("LNCIAMT") != null) {
					flowLnciRiskAmt = (BigDecimal) map.get("LNCIAMT");
				}
				totalLnciamt = totalLnciamt.add(flowLnciRiskAmt);
			}
			if (totalLnciamt.add(bLanAppliLnciBase.getLnciAmt() == null ? BigDecimal.ZERO : bLanAppliLnciBase.getLnciAmt())
					.compareTo(contAmount) > 0) {
				log.info("(信贷合同项下所有放款的借据金额 + 本次放款金额)必须小于等于信贷合同金额!");
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BLanErrorConstant.SCF_BAS_LAN_20008),
						BLanErrorConstant.SCF_BAS_LAN_20008);
			}
			// 非循环合同，还需要在添加一个校验规则。
			// 检查规则2是否满足
			if (contRistAmtTemp.add(tempRistAmt).compareTo(riskAmt) > 0) {
				log.info("信贷合同可用敞口不足！");
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BLanErrorConstant.SCF_BAS_LAN_20009),
						BLanErrorConstant.SCF_BAS_LAN_20009);
			}
		}

		// 1.2 可循环额度合同
		// 规则：借据敞口余额 = 借据余额 – 冻结保证金 – 现金等价物金额
		// 规则：信贷合同项下所有生效的借据敞口余额 + 本笔风险敞口〈=信贷合同总敞口
		// 规则：本笔风险敞口 = 出账金额 – 初始保证金 – 初始现金等价物金额
		if (ScfBasConstant.CONT_CREDIT_CYCLE.equals(cycle)) {
			if (contRistAmtTemp.add(tempRistAmt).compareTo(riskAmt) > 0) {
				log.info("(信贷合同项下所有生效的借据敞口余额 + 本次风险敞口)必须小于等于信贷合同总敞口");
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BLanErrorConstant.SCF_BAS_LAN_20010),
						BLanErrorConstant.SCF_BAS_LAN_20010);
			}
		}

		// 现货放款审批判断规则
		if (ScfBasConstant.PRODUCT_TYPE_CAR_PLEDGE.equals(parentId) || ScfBasConstant.PRODUCT_TYPE_CHATTLE.equals(parentId)) {
			BCrrGntyCon bCrrGntyCon = ibCrrGntyConDAO.selectByPrimaryKey(bCrrLnCon.getVidNo());
			String moniModel = bCrrGntyCon.getMoniMd() == null ? "" : bCrrGntyCon.getMoniMd();// 动态
																								// 静态标志
			BigDecimal lowPriceNew = bCrrGntyCon.getLowPriceNew() == null ? BigDecimal.ZERO : bCrrGntyCon.getLowPriceNew();// 最低控货价值
			BigDecimal ration = bCrrGntyCon.getRation().divide(new BigDecimal(100)); // 质押率
			// 抵质押率不能小于0
			if (ration.floatValue() <= 0) {
				log.info("该笔抵/质押合同的抵质押率不能小于等于0！");
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BLanErrorConstant.SCF_BAS_LAN_20012),
						BLanErrorConstant.SCF_BAS_LAN_20012);
			}
			List<Map> yaList = ibPbcMtgBaseInfoDAO.selectByCondition(bCrrLnCon.getVidNo());
			Map map = yaList.get(0);
			if (map.get("TOTPRICE") != null) {
				totalMortgageValue = (BigDecimal) map.get("TOTPRICE");
			}
			// 敞口余额
			com.huateng.scf.bas.pbc.model.AmountVO amountVO = new com.huateng.scf.bas.pbc.model.AmountVO();
			amountVO.setProductId(supplyChainPdId);
			amountVO.setProtocolNo(bCrrLnCon.getVidNo());
			amountVO.setSlaveContno(bCrrLnCon.getVidNo());
			avalibalRiskAmt = amountService.getPant(amountVO); // 敞口余额
			BigDecimal tempAmt = BigDecimal.ZERO;// 可融资金额 = 最低控货价值*抵/质押率 - 敞口余额
			if (ScfBasConstant.MONI_MODEL_DYNAMIC.equals(moniModel)) {// 动态
				// 可融资金额 = 最低控货价值*质押率 - 敞口余额
				tempAmt = lowPriceNew.multiply(ration).setScale(10, BigDecimal.ROUND_HALF_UP).subtract(avalibalRiskAmt);
				if (tempRistAmt.compareTo(tempAmt) >= 0.005) {// 本笔风险敞口<=可融资金额
					log.info("当前最低控货价值不足以覆盖本笔风险敞口");
					throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BLanErrorConstant.SCF_BAS_LAN_20013),
							BLanErrorConstant.SCF_BAS_LAN_20013);
				}
			} else {// 静态
				// 可融资金额 = 押品总价值*质押率 - 敞口余额
				if (totalMortgageValue == null) {
					totalMortgageValue = new BigDecimal(0);
				}
				tempAmt = totalMortgageValue.multiply(ration).setScale(10, BigDecimal.ROUND_HALF_UP).subtract(avalibalRiskAmt);
				if (tempRistAmt.compareTo(tempAmt) >= 0.005) {// 本笔风险敞口 < 可融资金额
					log.info("当前押品价值不足以覆盖本笔风险敞口");
					throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BLanErrorConstant.SCF_BAS_LAN_20014),
							BLanErrorConstant.SCF_BAS_LAN_20014);
				}
			}
		}

		// 预付款的放款审批判断规则
		if (ScfBasConstant.PRODUCT_TYPE_PREP.equals(parentId)) {
			if (ScfBasConstant.PRODUCT_TYPE_SMALL_WH.equals(supplyChainPdId)) {
				// 间接可用额度计算
				BigDecimal creditUseBal = BigDecimal.ZERO;
				String hasIndirectCredit = bLanAppliLnciBase.getHasIndirectCredit();// 间接额度类型
				if (ScfBasConstant.HAS_INDIRECT_CREDIT_TRUE.equals(hasIndirectCredit)) {
					BPrdCreditBind bind = new BPrdCreditBind();
					bind.setProductId(bLanAppliLnciBase.getProductId());
					bind.setOprMode(ScfBasConstant.CREDIT_OPR_MODE_SELLER_AND_BUYER);// 模式
					bind.setCreditPhase(ScfBasConstant.CREDIT_PHASE_FOUR_WAREHOUSE_ACCOUNT);// 额度阶段
					bind.setOprType(ScfBasConstant.CREDIT_OPR_TYPE_OCCUPY);// 操作类型
					List<BPrdCreditBind> prdBindList = ibPrdCreditBindDAO.selectCreditBind(bind);
					String creditType = "";
					if (prdBindList.size() > 0) {
						BPrdCreditBind bindInfo = prdBindList.get(0);
						creditType = bindInfo.getCreditType();
					}
					if (!StringUtil.isEmpty(creditType)) {
						// 间接额度表
						BIcrInfo bIcrInfo = new BIcrInfo();
						bIcrInfo.setCreditClass(ScfBasConstant.CREDIT_CLASS_INDIRECT);
						bIcrInfo.setNodeType(ScfBasConstant.CREDIT_NODE_TYPE_SUB_LEAF);
						bIcrInfo.setCustcd(bLanAppliLnciBase.getCreditCustcd());
						bIcrInfo.setOtherCustcd(bLanAppliLnciBase.getCustcd());
						bIcrInfo.setCreditType(creditType);
						List<BIcrInfo> icrList = ibIcrInfoDAO.selectByParam(bIcrInfo);
						if (icrList.size() > 0) {
							BIcrInfo bInfo = icrList.get(0);
							creditUseBal = bInfo.getCreditUsableAmount() == null ? BigDecimal.ZERO : bInfo.getCreditUsableAmount();
						}
					}

					if (tempRistAmt.compareTo(creditUseBal) > 0) {
						log.info("担保方间接额度可用余额不足");
						throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BLanErrorConstant.SCF_BAS_LAN_20015),
								BLanErrorConstant.SCF_BAS_LAN_20015);
					}
				}
			}
		}
	}

	/**
	 * @author liph
	 */
	public BigDecimal getContRiskAmtByCycle(String mastContno, String cycle) {
		BigDecimal avalibalRiskAmt = BigDecimal.ZERO;
		if (StringUtil.isEmpty(cycle)) {
			cycle = ScfBasConstant.CONT_CREDIT_NOCYCLE;
		}
		List<Map> list = ibLanAppliLnciBaseDAO.getFlowRiskAmtByMastContno(mastContno);
		BigDecimal flowRiskAmt = BigDecimal.ZERO;
		Map map = new HashMap();
		if (list != null && list.size() > 0) {
			map = list.get(0);
			if (map.get("RISKAMT") != null) {
				flowRiskAmt = (BigDecimal) map.get("RISKAMT");
			}
		}
		// 非循环合同
		if (ScfBasConstant.CONT_CREDIT_NOCYCLE.equals(cycle)) {
			avalibalRiskAmt = getContRiskAmt(mastContno, cycle);
		}
		// 循环合同
		if (ScfBasConstant.CONT_CREDIT_CYCLE.equals(cycle)) {
			avalibalRiskAmt = getContRiskAmt(mastContno, cycle);
		}
		// 增加流程审批中的借据（仅仅包括已经提交给信贷，但是未审批通过）
		avalibalRiskAmt = avalibalRiskAmt.add(flowRiskAmt);
		return avalibalRiskAmt;
	}

	/**
	 * @author liph
	 */
	public BigDecimal getContRiskAmt(String mastContno, String cycle) {
		BigDecimal riskAmt = BigDecimal.ZERO;
		BigDecimal totRiskAmt = BigDecimal.ZERO;
		List list = new ArrayList();
		// 循环合同，已经结清的借据不需要要计算的。
		BLanLnciBase bLanLnciBase = new BLanLnciBase();
		bLanLnciBase.setMastContno(mastContno);
		bLanLnciBase.setState(ScfBasConstant.FLAG_ON);
		if (ScfBasConstant.CONT_CREDIT_CYCLE.equals(cycle)) {
			bLanLnciBase.setIsSettle(ScfBasConstant.FLAG_OFF);
		}
		List<BLanLnciBase> lncilist = ibLanLnciBaseDAO.queryByCondition(bLanLnciBase);
		if (lncilist.size() > 0) {
			for (int i = 0; i < lncilist.size(); i++) {
				riskAmt = this.getLnciRiskAmt((BLanLnciBase) list.get(i), cycle);
				if (riskAmt == null) {
					riskAmt = BigDecimal.ZERO;
				}
				totRiskAmt = totRiskAmt.add(riskAmt);
			}
		}
		return totRiskAmt;
	}

	/**
	 * @author liph
	 */
	public BigDecimal getLnciRiskAmt(BLanLnciBase bLanLnciBase, String cycle) {

		BigDecimal bailAmount = null;
		BigDecimal initCashEqtAmt = null;
		BigDecimal addBailAmount = null;
		BigDecimal addCashEqtAmt = null;
		BigDecimal riskAmt = null;
		bailAmount = (bLanLnciBase.getBailAmount() == null ? new BigDecimal(0) : bLanLnciBase.getBailAmount());
		addBailAmount = (bLanLnciBase.getAddBailAmount() == null ? new BigDecimal(0) : bLanLnciBase.getAddBailAmount());
		initCashEqtAmt = (bLanLnciBase.getInitCashEqtAmt() == null ? new BigDecimal(0) : bLanLnciBase.getInitCashEqtAmt());
		addCashEqtAmt = (bLanLnciBase.getAddCashEqtAmt() == null ? new BigDecimal(0) : bLanLnciBase.getAddCashEqtAmt());
		if (ScfBasConstant.CONT_CREDIT_NOCYCLE.equals(cycle)) {
			riskAmt = bLanLnciBase.getLnciAmt().subtract(bailAmount).subtract(initCashEqtAmt);
		}
		if (ScfBasConstant.CONT_CREDIT_CYCLE.equals(cycle)) {

			riskAmt = bLanLnciBase.getLnciBal().subtract(bailAmount).subtract(addBailAmount).subtract(initCashEqtAmt).subtract(addCashEqtAmt);
		}
		return riskAmt;
	}

	/**
	 * @author liph 更新业务申请主表--最后审批通过的时候
	 */
	@Transactional
	@Override
	public void upAppliBaseInfo(String appno) {
		com.huateng.scf.bas.pbc.dao.model.BPbcAppliBaseInfo bPbcAppliBaseInfo = ibPbcAppliBaseInfoDAO.selectByPrimaryKey(appno);
		bPbcAppliBaseInfo.setAppliStatusDtl(WorkflowConstant.APPLI_STATUS_DTL_CCMS_AGREE);// 放款通过
		ibPbcAppliBaseInfoDAO.updateByPrimaryKey(bPbcAppliBaseInfo);
	}

	/**
	 * 更新借据申请表的借据号
	 */
	@Transactional
	@Override
	public void updateBLanAppliLnciBase(String appno,String debetId) throws ScubeBizException{
		// TODO Auto-generated method stub
		com.huateng.scf.bas.lan.dao.model.BLanAppliLnciBase bLanAppliLnciBase = ibLanAppliLnciBaseDAO.selectByAppno(appno);
		bLanAppliLnciBase.setDebetId(debetId);
		try {
			ibLanAppliLnciBaseDAO.updateByPrimaryKey(bLanAppliLnciBase);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); 
			log.error(e.getMessage());
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BLanErrorConstant.SCF_BAS_LAN_10002),
					BLanErrorConstant.SCF_BAS_LAN_10002);//
		}
	}

}
