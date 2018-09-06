package com.huateng.scf.bas.lan.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huateng.authority.entity.BctlVO;
import com.huateng.authority.inter.service.ScubeUserService;
import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.cnt.dao.IBCntDebtExtInfoDAO;
import com.huateng.scf.bas.cnt.dao.IBCntDebtInfoDAO;
import com.huateng.scf.bas.cnt.dao.IBCntMprotBaseInfoDAO;
import com.huateng.scf.bas.cnt.dao.model.BCntDebtExtInfo;
import com.huateng.scf.bas.cnt.dao.model.BCntDebtExtInfoExample;
import com.huateng.scf.bas.cnt.dao.model.BCntDebtExtInfoExample.Criteria;
import com.huateng.scf.bas.cnt.dao.model.BCntDebtInfo;
import com.huateng.scf.bas.cnt.dao.model.BCntDebtInfoExample;
import com.huateng.scf.bas.common.constant.ScfBasConstant;
import com.huateng.scf.bas.common.startup.ScfMessageUtil;
import com.huateng.scf.bas.common.util.ScfCommonUtil;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.crm.dao.IBCrmBaseInfoDAO;
import com.huateng.scf.bas.crm.dao.model.BCrmBaseInfo;
import com.huateng.scf.bas.crr.dao.IBCrrDuebillAppDAO;
import com.huateng.scf.bas.crr.dao.IBCrrGntyConDAO;
import com.huateng.scf.bas.crr.dao.IBCrrLnConDAO;
import com.huateng.scf.bas.crr.dao.IBCrrPrdMdDAO;
import com.huateng.scf.bas.crr.dao.model.BCrrDuebillApp;
import com.huateng.scf.bas.crr.dao.model.BCrrGntyCon;
import com.huateng.scf.bas.crr.dao.model.BCrrLnCon;
import com.huateng.scf.bas.crr.dao.model.BCrrPrdMd;
import com.huateng.scf.bas.crr.model.BCrrDueBillDetail;
import com.huateng.scf.bas.icr.dao.IBIcrInfoDAO;
import com.huateng.scf.bas.icr.dao.model.BIcrInfo;
import com.huateng.scf.bas.lan.constant.BLanErrorConstant;
import com.huateng.scf.bas.lan.dao.IBLanAppliBillInfoDAO;
import com.huateng.scf.bas.lan.dao.IBLanAppliLnciBaseDAO;
import com.huateng.scf.bas.lan.dao.IBLanLnciBaseDAO;
import com.huateng.scf.bas.lan.dao.model.BLanAppliLnciBase;
import com.huateng.scf.bas.lan.dao.model.BLanLnciBase;
import com.huateng.scf.bas.lan.service.IBLanRepayDetailService;
import com.huateng.scf.bas.mrn.dao.IBMrnAppliAcctInfoDAO;
import com.huateng.scf.bas.pbc.dao.IBPbcAppliBaseInfoDAO;
import com.huateng.scf.bas.pbc.dao.IBPbcMtgBaseInfoDAO;
import com.huateng.scf.bas.pbc.service.IAmountService;
import com.huateng.scf.bas.prd.dao.IBPrdCreditBindDAO;
import com.huateng.scf.bas.prd.dao.IBPrdInfoDAO;
import com.huateng.scf.bas.prd.dao.model.BPrdCreditBind;
import com.huateng.scf.bas.prd.dao.model.BPrdInfo;
import com.huateng.scf.bas.sys.dao.IBSysAcctBctlDAO;
import com.huateng.scf.bas.sys.dao.model.RSysAcctBctl;
import com.huateng.scf.rec.bcp.dao.IRBcpAppliBussDtlDAO;
import com.huateng.scf.rec.bcp.dao.IRBcpDebtPoolDAO;
import com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussDtl;
import com.huateng.scf.rec.bcp.dao.model.RBcpDebtPool;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * <p>
 * </p>
 *
 * @author liph
 * @date 2016年12月10日下午1:39:20
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 *            <pre>
 * =================Modify Record=======================
 * Modifier			date	 	 Content
 * liph		2016年12月10日下午1:39:20	      新增
 *
 *            </pre>
 */
@ScubeService
@Service("BLanRepayDetailServiceImpl")
public class BLanRepayDetailServiceImpl implements IBLanRepayDetailService {
	private final Logger log = LoggerFactory.getLogger(getClass());
	private static final String PROTOCOLNO = "protocolNo";
	private static final String PROTOCOLTYPE = "protocolType";
	private static final String ROLECREDIT = "roleCredit";
	private static final String ROLECORE = "roleCore";
	private static final String ROLEBACKCORE = "roleBackcore";

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
	@Resource(name = "IBCrrDuebillAppDAO")
	IBCrrDuebillAppDAO ibcrrduebillappdao;
	@Resource(name = "IBCrrPrdMdDAO")
	IBCrrPrdMdDAO bcrrprdmddao;
	@Resource(name = "IBCrrGntyConDAO")
	IBCrrGntyConDAO ibCrrGntyConDAO;
	@Resource(name = "BPbcMtgBaseInfoDAO")
	IBPbcMtgBaseInfoDAO ibPbcMtgBaseInfoDAO;
	@Resource(name = "BPrdCreditBindDAO")
	IBPrdCreditBindDAO ibPrdCreditBindDAO;
	@Resource(name = "BIcrInfoDAO")
	IBIcrInfoDAO ibIcrInfoDAO;
	@Resource(name = "BLanLnciBaseDAO")
	IBLanLnciBaseDAO ibLanLnciBaseDAO;
	@Resource(name = "RBcpAppliBussDtlDAO")
	IRBcpAppliBussDtlDAO irBcpAppliBussDtlDAO;
	@Resource(name = "BCntDebtInfoDAO")
	IBCntDebtInfoDAO ibCntDebtInfoDAO;
	@Resource(name = "RBcpDebtPoolDAO")
	IRBcpDebtPoolDAO irBcpDebtPoolDAO;
	@Resource(name = "BCntMprotBaseInfoDAO")
	private IBCntMprotBaseInfoDAO bCntMprotBaseInfoDAO;
	@Resource(name = "AmountServiceImpl")
	IAmountService amountService;
	// 用于页面费用网点转译
	@Resource(name = "IBSysAcctBctlDAO")
	IBSysAcctBctlDAO bSysAcctBctlDAO;
	// 交易对手信息
	@Resource(name = "BCntDebtExtInfoDAO")
	IBCntDebtExtInfoDAO iBCntDebtExtInfoDAO;
	@Resource(name = "BCntDebtInfoDAO")
	IBCntDebtInfoDAO iBCntDebtInfoDAO;
	@Autowired
	ScubeUserService scubeUserService;
	@Override
	@Transactional
	public BCrrDueBillDetail findBLanRepayDetailById(String id) {
		BCrrDuebillApp bCrrDuebillApp = ibcrrduebillappdao.selectByPrimaryKey(id);
		if (bCrrDuebillApp == null) {
			log.info("出账申请信息丢失");
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BLanErrorConstant.SCF_BAS_LAN_20002), BLanErrorConstant.SCF_BAS_LAN_20002);
		}
		BCrrDueBillDetail bCrrDueBillDetail = new BCrrDueBillDetail();
		BeanUtils.copyProperties(bCrrDuebillApp, bCrrDueBillDetail);
		String mastContno = bCrrDuebillApp.getAppId();// 主合同号
		BCrrLnCon bCrrLnCon = ibCrrLnConDAO.selectByPrimaryKey(mastContno);
		if (bCrrLnCon == null) {
			log.info("信贷合同为空");
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BLanErrorConstant.SCF_BAS_LAN_20018), BLanErrorConstant.SCF_BAS_LAN_20018);
		}
		String prdId = bCrrLnCon.getPrdId();
		BCrrPrdMd bCrrPrdMd = bcrrprdmddao.selectByPrimaryKey(prdId);
		bCrrDueBillDetail.setVidNo(bCrrLnCon.getVidNo());// 协议号
		bCrrDueBillDetail.setCreditProId(bCrrLnCon.getCreditProtNo());// 额度协议流水号
		bCrrDueBillDetail.setAppStatus(bCrrLnCon.getAppStat());// 申请状态
		bCrrDueBillDetail.setHtsxr(bCrrLnCon.getLnStrtDt());
		bCrrDueBillDetail.setHtdqr(bCrrLnCon.getLnEndDt());
		bCrrDueBillDetail.setTotAmt(bCrrLnCon.getLnAmt());

		/** 信贷合同可用敞口 */
		BigDecimal contOpenAmount = this.getContRiskAmtByCycle(bCrrLnCon.getAppId(), bCrrLnCon.getControlType());
		BigDecimal xdhtky = bCrrLnCon.getLnAmt() == null ? BigDecimal.ZERO : bCrrLnCon.getLnAmt().subtract(contOpenAmount);
		bCrrDueBillDetail.setLnSum(xdhtky);
		bCrrDueBillDetail.setLoanWay(bCrrPrdMd.getLoanWay());
		bCrrDueBillDetail.setXh(bCrrLnCon.getControlType() == null ? "2" : bCrrLnCon.getControlType());
		bCrrDueBillDetail.setVidBusTyp(bCrrLnCon.getVidBusiTyp());

		/** 买方名称--保存之后赋值 */
		String maifang = bCrrDuebillApp.getCrdtCustCd();
		BCrmBaseInfo bCrmBaseInfo = ibCrmBaseInfoDAO.selectById(maifang);
		String cname = "";
		if (bCrmBaseInfo != null) {
			cname = bCrmBaseInfo.getCname();
		}
		bCrrDueBillDetail.setCname(cname);
		String maifang1 = bCrrDuebillApp.getCustCd();
		BCrmBaseInfo bCrmBaseInfo1 = ibCrmBaseInfoDAO.selectById(maifang1);
		String name = "";
		if (bCrmBaseInfo1 != null) {
			name = bCrmBaseInfo1.getCname();
		}
		bCrrDueBillDetail.setName(name);

		BLanAppliLnciBase bLanAppliLnciBase = ibLanAppliLnciBaseDAO.selectByAppno(id);
		BigDecimal lnciAmt = bLanAppliLnciBase.getLnciAmt() == null ? BigDecimal.ZERO : bLanAppliLnciBase.getLnciAmt();
		BigDecimal csbzjAmt = bLanAppliLnciBase.getBailAmount() == null ? BigDecimal.ZERO : bLanAppliLnciBase.getBailAmount();// 初始保证金金额
		BigDecimal csxjdjwAmt = bLanAppliLnciBase.getInitCashEqtAmt() == null ? BigDecimal.ZERO : bLanAppliLnciBase.getInitCashEqtAmt();// 初始现金等价物
		BigDecimal addBailAmt = bLanAppliLnciBase.getAddBailAmount() == null ? BigDecimal.ZERO : bLanAppliLnciBase.getAddBailAmount();// 追加保证金金额
		BigDecimal addCashEqtAmt = bLanAppliLnciBase.getAddCashEqtAmt() == null ? BigDecimal.ZERO : bLanAppliLnciBase.getAddCashEqtAmt();// 追加现金等价物金额\
		// 融资信息=============================开始
		// 供应链补录承兑协议号/借据号
		if (ScfBasConstant.LOAN_WAY_BANK_ACCEPTENCE.equals(bCrrPrdMd.getLoanWay())) {// 银承
			//bCrrDueBillDetail.setDebetNo(bLanAppliLnciBase.getProtocolNo());
			//借据编号从正式表取
			String debetNo = bLanAppliLnciBase.getDebetNo();
			BLanLnciBase bLanLnciBase = ibLanLnciBaseDAO.selectByPrimaryKey(debetNo);
			if(bLanLnciBase!=null){
				bCrrDueBillDetail.setDebetNo(bLanLnciBase.getDebetId());
			}
		} else {// 流贷
			bCrrDueBillDetail.setDebetNo(bLanAppliLnciBase.getDebetId());
		}
		bCrrDueBillDetail.setJjje(lnciAmt);
		bCrrDueBillDetail.setQxrq(bLanAppliLnciBase.getStartDate());
		bCrrDueBillDetail.setRzjg(bCrrDuebillApp.getActBrCd());// 财务机构==入账机构
		// 财务机构翻译
		RSysAcctBctl rSysAcctBctl = bSysAcctBctlDAO.selectByPrimaryKey(bCrrDuebillApp.getActBrCd());
		bCrrDueBillDetail.setRzjgName(rSysAcctBctl.getBrname());
		bCrrDueBillDetail.setDqrq(bLanAppliLnciBase.getEndDate());
		bCrrDueBillDetail.setRzzh(bCrrDuebillApp.getLnNo());// 入账帐号
		bCrrDueBillDetail.setHkfs(bCrrLnCon.getRtnTyp());// 还款方式
		bCrrDueBillDetail.setKxq(bLanAppliLnciBase.getGraceDays() == null ? BigDecimal.ZERO : bLanAppliLnciBase.getGraceDays());
		bCrrDueBillDetail.setCsbzjje(bLanAppliLnciBase.getBailAmount() == null ? BigDecimal.ZERO : bLanAppliLnciBase.getBailAmount());
		bCrrDueBillDetail.setCsbzjbl(bLanAppliLnciBase.getFirstBailRatio() == null ? BigDecimal.ZERO : bLanAppliLnciBase.getFirstBailRatio());
		bCrrDueBillDetail.setCsxjdjwbl(bLanAppliLnciBase.getInitCashEqtAmt() == null ? BigDecimal.ZERO : bLanAppliLnciBase.getInitCashEqtAmt());
		// 融资信息------------------------------结束
		// 利率信息=----------------------------=开始
		bCrrDueBillDetail.setLllx(bLanAppliLnciBase.getRateType());
		bCrrDueBillDetail.setLlfdfs(bLanAppliLnciBase.getRateFloatType());
		bCrrDueBillDetail.setFdlltzfs(bLanAppliLnciBase.getRateAdjustType());
		bCrrDueBillDetail.setLlfdz(bLanAppliLnciBase.getRateFloatValue() == null ? BigDecimal.ZERO : bLanAppliLnciBase.getRateFloatValue());
		bCrrDueBillDetail.setZxll(bLanAppliLnciBase.getRate() == null ? BigDecimal.ZERO : bLanAppliLnciBase.getRate());
		bCrrDueBillDetail.setLldm(bCrrLnCon.getIntCd());// 利率代码
		bCrrDueBillDetail.setJzlv(bCrrLnCon.getBasInt());// 基准利率
		// 银城信息获取--借据信息
		// 出票日期-到期日期就是起效日期-到期日期
		// 出票金额-借据金额
		bCrrDueBillDetail.setCdjgh(bLanAppliLnciBase.getDraftBrcode());//承兑机构号
		bCrrDueBillDetail.setQfjgh(bLanAppliLnciBase.getSignBrcode());//签发机构号
		bCrrDueBillDetail.setSqjgh(bLanAppliLnciBase.getBussBrcode());//申请机构号
		bCrrDueBillDetail.setDkjgh(bLanAppliLnciBase.getPrePayBrcode());//垫款机构号
		//承兑机构号翻译
		if(StringUtil.isStrNotEmpty(bLanAppliLnciBase.getDraftBrcode())){
			BctlVO brName = scubeUserService.selectBctlByBrNo(bLanAppliLnciBase.getDraftBrcode(),ScfCommonUtil.getBrManagerNo(scubeUserService));
			bCrrDueBillDetail.setCdjghName(brName.getBrName());
		}
		//签发机构号翻译
		if(StringUtil.isStrNotEmpty(bLanAppliLnciBase.getSignBrcode())){
			BctlVO brName = scubeUserService.selectBctlByBrNo(bLanAppliLnciBase.getDraftBrcode(),ScfCommonUtil.getBrManagerNo(scubeUserService));
			bCrrDueBillDetail.setQfjghName(brName.getBrName());
		}
		//申请机构号翻译
		if(StringUtil.isStrNotEmpty(bLanAppliLnciBase.getBussBrcode())){
			BctlVO brName = scubeUserService.selectBctlByBrNo(bLanAppliLnciBase.getBussBrcode(),ScfCommonUtil.getBrManagerNo(scubeUserService));
			bCrrDueBillDetail.setSqjghName(brName.getBrName());
		}
		//垫款机构号翻译
		if(StringUtil.isStrNotEmpty(bLanAppliLnciBase.getPrePayBrcode())){
			BctlVO brName = scubeUserService.selectBctlByBrNo(bLanAppliLnciBase.getPrePayBrcode(),ScfCommonUtil.getBrManagerNo(scubeUserService));
			bCrrDueBillDetail.setDkjghName(brName.getBrName());
		}
	
		bCrrDueBillDetail.setBillNum(bLanAppliLnciBase.getBillNum());

		/** 间接额度可用余额 */
		BPrdCreditBind bind = new BPrdCreditBind();
		bind.setProductId(bLanAppliLnciBase.getProductId());
		bind.setOprMode(ScfBasConstant.CREDIT_OPR_MODE_SELLER_AND_BUYER);// 模式
		//TODO 间接额度阶段取值
		bind.setCreditPhase(ScfBasConstant.CREDIT_PHASE_FOUR_WAREHOUSE_ACCOUNT);// 额度阶段
		bind.setOprType(ScfBasConstant.CREDIT_OPR_TYPE_OCCUPY);// 操作类型
		List<BPrdCreditBind> prdBindList = ibPrdCreditBindDAO.selectCreditBind(bind);
		bCrrDueBillDetail.setDrawbackTerm(bLanAppliLnciBase.getDrawbackTerm() == null ? BigDecimal.ZERO : bLanAppliLnciBase.getDrawbackTerm());// 赎货期限
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
			bCrrDueBillDetail.setCreditBalAmt(creditUseBal);// 间接额度可用额度
		}

		String bussType = bCrrLnCon.getVidBusiTyp();
		BPrdInfo bPrdInfo = ibPrdInfoDAO.selectByPrimaryKey(bussType);
		String parentId = bPrdInfo.getParentId();
		bCrrDueBillDetail.setBigProductId(parentId);
		BigDecimal ypze = BigDecimal.ZERO;
		// -------------------现货抵押------------------
		if (ScfBasConstant.PRODUCT_TYPE_MORT.equals(parentId)) {
			List<Map> yaList = ibPbcMtgBaseInfoDAO.selectByCondition(bCrrLnCon.getVidNo());
			Map map = yaList.get(0);
			if (map.get("TOTPRICE") != null) {
				ypze = (BigDecimal) map.get("TOTPRICE");
			}
			bCrrDueBillDetail.setXhypzjz(ypze);

			BCrrGntyCon bCrrGntyCon = ibCrrGntyConDAO.selectByPrimaryKey(bCrrLnCon.getVidNo());
			if (bCrrGntyCon != null) {
				bCrrDueBillDetail.setJght(bCrrGntyCon.getPrtclNo());
				bCrrDueBillDetail.setJggsmc(bCrrGntyCon.getPrtclBrNm());
				bCrrDueBillDetail.setDzyl(bCrrGntyCon.getRation());// 抵质押率
				bCrrDueBillDetail.setZdkhjz(bCrrGntyCon.getLowPrice() == null ? BigDecimal.ZERO : bCrrGntyCon.getLowPrice());
			}

			/** 本笔风险敞口 */
			BigDecimal riskAmt = lnciAmt.subtract(csbzjAmt).subtract(csxjdjwAmt);
			bCrrDueBillDetail.setBbfxck(riskAmt);

			/** 敞口余额 */
			BigDecimal avalibalRiskAmt = BigDecimal.ZERO;
			com.huateng.scf.bas.pbc.model.AmountVO amountVO = new com.huateng.scf.bas.pbc.model.AmountVO();
			amountVO.setProductId(bCrrLnCon.getVidBusiTyp());
			amountVO.setSlaveContno(bCrrLnCon.getVidNo());
			/** 初始化金额 */
			amountVO.setBailInit(new BigDecimal(0));
			amountVO.setCashInit(new BigDecimal(0));
			amountVO.setBailRefund(new BigDecimal(0));
			amountVO.setCashRefund(new BigDecimal(0));
			amountVO.setBailAmount(new BigDecimal(0));
			amountVO.setCashAmount(new BigDecimal(0));

			avalibalRiskAmt = amountService.getPant(amountVO);// 敞口余额
			bCrrDueBillDetail.setCkye(avalibalRiskAmt);

			/** 可融资金额--可融资金额 = 押品总价值*质押率 - 敞口余额 */
			String moniModel = bCrrGntyCon.getMoniMd();
			BigDecimal avaliableAmt = BigDecimal.ZERO;
			BigDecimal abc = bCrrGntyCon.getLowPriceNew() == null ? BigDecimal.ZERO : bCrrGntyCon.getLowPriceNew();
			if (ScfBasConstant.MONI_MODEL_STATIC.equals(moniModel)) {// 静态
				avaliableAmt = ypze.multiply(bCrrGntyCon.getRation() == null ? BigDecimal.ZERO : bCrrGntyCon.getRation()).divide(new BigDecimal(100))
						.subtract(avalibalRiskAmt).setScale(2, BigDecimal.ROUND_HALF_UP);
			} else {
				avaliableAmt = abc.multiply(bCrrGntyCon.getRation() == null ? BigDecimal.ZERO : bCrrGntyCon.getRation()).divide(new BigDecimal(100))
						.subtract(avaliableAmt).setScale(2, BigDecimal.ROUND_HALF_UP);
			}
			bCrrDueBillDetail.setKrzje(avaliableAmt);
		}
		// ------------------------国内保理-----------------
		else if (ScfBasConstant.PRODUCT_TYPE_ACCR.equals(parentId) && (ScfBasConstant.PRODUCT_TYPE_GNFAC.equals(bCrrLnCon.getVidBusiTyp())||ScfBasConstant.PRODUCT_TYPE_GNFXBL.equals(bCrrLnCon.getVidBusiTyp())||ScfBasConstant.PRODUCT_TYPE_YSZKZY.equals(bCrrLnCon.getVidBusiTyp()))) {
			/** 本次风险敞口 */
			BigDecimal riskAmt = lnciAmt.subtract(csbzjAmt).subtract(csxjdjwAmt).subtract(addBailAmt).subtract(addCashEqtAmt);
			bCrrDueBillDetail.setBbfxck(riskAmt);
			/** 融资比例 */
			// vidNo(业务合同) crdtCustCd(买方客户)
			BCntDebtExtInfoExample bCntDebtExtInfoExample = new BCntDebtExtInfoExample();
			Criteria criteria = bCntDebtExtInfoExample.createCriteria();
			if (bCrrLnCon.getVidNo() != null) {
				criteria.andBusinessNoEqualTo(bCrrLnCon.getVidNo());
			}
			if (bCrrLnCon.getCrdtCustCd() != null) {
				criteria.andBuyerCustcdEqualTo(bCrrLnCon.getCrdtCustCd());
			}
			List<BCntDebtExtInfo> bCntDebtExtInfoList = iBCntDebtExtInfoDAO.selectByExample(bCntDebtExtInfoExample);
			if (bCntDebtExtInfoList != null && bCntDebtExtInfoList.size() > 0) {
				bCrrDueBillDetail.setRzbl(bCntDebtExtInfoList.get(0).getLoanPercent());
			}
			// 应收账款融资交易对手信息表的融资比例值为null,则取应收账款合同的融资比例值
			else {
				BCntDebtInfoExample bCntDebtInfoExample = new BCntDebtInfoExample();
				bCntDebtInfoExample.createCriteria().andDebtContnoEqualTo(bCrrLnCon.getVidNo());
				List<BCntDebtInfo> bCntDebtInfoList = iBCntDebtInfoDAO.selectByExample(bCntDebtInfoExample);
				if (bCntDebtInfoList != null && bCntDebtInfoList.size() > 0) {
					bCrrDueBillDetail.setRzbl(bCntDebtInfoList.get(0).getLoanPercent());
				}
			}
			BigDecimal rzbl = bCrrDueBillDetail.getRzbl();
			/** 应收账款总额 R_BCP_APPLI_BUSS_DTL */
			List<RBcpAppliBussDtl> appliBussDtlList = irBcpAppliBussDtlDAO.selectByAppno(bCrrDuebillApp.getId());
			BigDecimal remainingAmount = BigDecimal.ZERO;
			if (appliBussDtlList.size() > 0) {
				for (int i = 0; i < appliBussDtlList.size(); i++) {
					RBcpAppliBussDtl rBcpAppliBussDtl = appliBussDtlList.get(i);
					remainingAmount = remainingAmount
							.add(rBcpAppliBussDtl.getRemainingAmount() == null ? BigDecimal.ZERO : rBcpAppliBussDtl.getRemainingAmount());
				}
			}
			bCrrDueBillDetail.setYsTotalAmt(remainingAmount);
			bCrrDueBillDetail.setKrzje(remainingAmount.multiply(rzbl).divide(new BigDecimal(100), 2, BigDecimal.ROUND_DOWN));
		}
		// -------------------------国内保理池-----------------------
		else if (ScfBasConstant.PRODUCT_TYPE_ACCR.equals(parentId) && (ScfBasConstant.PRODUCT_TYPE_DEBT_POOL.equals(bCrrLnCon.getVidBusiTyp())||ScfBasConstant.PRODUCT_TYPE_CKTS_POOL.equals(bCrrLnCon.getVidBusiTyp())||ScfBasConstant.PRODUCT_TYPE_YSZKZY_POOL.equals(bCrrLnCon.getVidBusiTyp()))) {
			/** 融资比例 */
			// vidNo(业务合同) crdtCustCd(买方客户)
			BCntDebtExtInfoExample bCntDebtExtInfoExample = new BCntDebtExtInfoExample();
			if (bCrrLnCon.getVidNo() != null) {
				bCntDebtExtInfoExample.createCriteria().andBusinessNoEqualTo(bCrrLnCon.getVidNo());
			}
			if (bCrrLnCon.getCrdtCustCd() != null) {
				bCntDebtExtInfoExample.createCriteria().andBuyerCustcdEqualTo(bCrrLnCon.getCrdtCustCd());
			}
			List<BCntDebtExtInfo> bCntDebtExtInfoList = iBCntDebtExtInfoDAO.selectByExample(bCntDebtExtInfoExample);
			if (bCntDebtExtInfoList != null && bCntDebtExtInfoList.size() > 0) {
				bCrrDueBillDetail.setRzbl(bCntDebtExtInfoList.get(0).getLoanPercent());
			}
			// 应收账款融资交易对手信息表的融资比例值为null,则取应收账款合同的融资比例值
			else {
				BCntDebtInfoExample bCntDebtInfoExample = new BCntDebtInfoExample();
				bCntDebtInfoExample.createCriteria().andDebtContnoEqualTo(bCrrLnCon.getVidNo());
				List<BCntDebtInfo> bCntDebtInfoList = iBCntDebtInfoDAO.selectByExample(bCntDebtInfoExample);
				if (bCntDebtInfoList != null && bCntDebtInfoList.size() > 0) {
					bCrrDueBillDetail.setRzbl(bCntDebtInfoList.get(0).getLoanPercent());
				}
			}
			/** 池保证金帐号 */
			BCntDebtInfo bCntDebtInfo = ibCntDebtInfoDAO.selectByPrimaryKey(bCrrLnCon.getVidNo());
			String bailAccount = "";
			if (bCntDebtInfo != null) {
				bailAccount = bCntDebtInfo.getBailAcctNo();
			}
			bCrrDueBillDetail.setBailActNo(bailAccount);
			/** 池敞口余额 */
			String bussinessNo = bCntDebtInfo.getDebtContno();
			BigDecimal cckye = amountService.calculatePoolRiskAvailableAmtByBusinessNo(bussinessNo);
			if (cckye.compareTo(BigDecimal.ZERO) < 0) {
				cckye = BigDecimal.ZERO;
			}
			bCrrDueBillDetail.setPoolRiskAmt(cckye);
			/** 本笔风险敞口 */
			BigDecimal riskAmt = lnciAmt.subtract(csbzjAmt).subtract(csxjdjwAmt).subtract(addBailAmt).subtract(addCashEqtAmt);
			bCrrDueBillDetail.setBbfxck(riskAmt);
			/** 池应收账款余额 */
			BigDecimal poolRemainDebtAmt = BigDecimal.ZERO;
			BigDecimal poolUseableAmount = BigDecimal.ZERO;
			Map map = new HashMap();
			map.put("mastContno", bCrrLnCon.getVidNo());
			List<RBcpDebtPool> poolList = irBcpDebtPoolDAO.getInpoolInfo(map);
			if (poolList != null && poolList.size() > 0) {
				RBcpDebtPool rBcpDebtPool = poolList.get(0);
				if (rBcpDebtPool != null) {
					poolRemainDebtAmt = rBcpDebtPool.getTotalDebtRemainAmount() == null ? BigDecimal.ZERO : rBcpDebtPool.getTotalDebtRemainAmount();
					poolUseableAmount = rBcpDebtPool.getPoolUseableAmount() == null ? BigDecimal.ZERO : rBcpDebtPool.getPoolUseableAmount();
					bCrrDueBillDetail.setTotalBillsAmount(poolRemainDebtAmt);
					bCrrDueBillDetail.setPoolUseableAmount(poolUseableAmount);
				}
			} else {
				bCrrDueBillDetail.setTotalBillsAmount(BigDecimal.ZERO);
				bCrrDueBillDetail.setPoolUseableAmount(BigDecimal.ZERO);
			}
			// BigDecimal amt1 = new BigDecimal(10000000);
			bCrrDueBillDetail.setTotalBailAmount(null);
			/*
			 * BigDecimal amt2 = amt1.subtract(poolUseableAmount);
			 * bCrrDueBillDetail.setPoolUseableAmount(amt2);
			 */
		}
		// -----------------------担保提货--预付类-----------------------
		/*
		else if (ScfBasConstant.PRODUCT_TYPE_PREP.equals(parentId)) {
			Map<String, String> map = new HashMap<String, String>();
			String protocolNo = bCrrLnCon.getVidNo();
			if (StringUtil.isStrNotEmpty(protocolNo)) {
				map.put(PROTOCOLNO, protocolNo);
			}
			map.put(PROTOCOLTYPE, ScfBasConstant.MUTI_PROTOCOL_THREEWH);
			map.put(ROLECREDIT, ScfBasConstant.PROTOCOL_PART_ROLE_CREDIT);
			map.put(ROLECORE, ScfBasConstant.PROTOCOL_PART_ROLE_CORE);
			map.put(ROLEBACKCORE, ScfBasConstant.PROTOCOL_PART_ROLE_BACKCORE);
			com.huateng.scf.bas.cnt.dao.model.ThreeProtocolVO daoThreeProtocolVO = new com.huateng.scf.bas.cnt.dao.model.ThreeProtocolVO();
			Page resultPage = bCntMprotBaseInfoDAO.queryThreeProtocolList(null, map, false);// 不分页查询
			if (null != resultPage) {
				List<com.huateng.scf.bas.cnt.dao.model.ThreeProtocolVO> threeProtocolVOList = resultPage.getRecords();
				if (null != threeProtocolVOList && threeProtocolVOList.size() > 0) {
					daoThreeProtocolVO = threeProtocolVOList.get(0);
				}
			}
			bCrrDueBillDetail.setCsbzjbl(daoThreeProtocolVO.getFirstBailRatio() == null ? BigDecimal.ZERO
					: daoThreeProtocolVO.getFirstBailRatio());
		}
*/

		return bCrrDueBillDetail;
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

}