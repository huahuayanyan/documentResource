/**
 * 
 */
package com.huateng.scf.bas.lan.service.impl;

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
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huateng.authority.common.ContextHolder;
import com.huateng.authority.entity.BctlVO;
import com.huateng.authority.entity.UserInfo;
import com.huateng.base.common.beans.Page;
import com.huateng.flowsharp.entity.FlowsharpException;
import com.huateng.scf.bas.cnt.dao.model.BCntDebtExtInfo;
import com.huateng.scf.bas.cnt.dao.model.BCntDebtExtInfoExample;
import com.huateng.scf.bas.cnt.dao.model.BCntDebtInfo;
import com.huateng.scf.bas.cnt.dao.model.BCntDebtInfoExample;
import com.huateng.scf.bas.cnt.dao.model.BCntDebtExtInfoExample.Criteria;
import com.huateng.scf.bas.cnt.model.BCntMprotBaseInfo;
import com.huateng.scf.bas.cnt.service.IBCntMprotBaseInfoService;
import com.huateng.scf.bas.cnt.service.IBCntMprotPartInfoService;
import com.huateng.scf.bas.common.constant.IndirectCreditConstant;
import com.huateng.scf.bas.common.constant.ScfBasConstant;
import com.huateng.scf.bas.common.service.IScfIndirectCreditService;
import com.huateng.scf.bas.common.service.IScfWorkFlowService;
import com.huateng.scf.bas.common.startup.ScfMessageUtil;
import com.huateng.scf.bas.common.util.ScfCommonUtil;
import com.huateng.scf.bas.common.util.ScfDateUtil;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.common.util.UUIDGeneratorUtil;
import com.huateng.scf.bas.crm.dao.IBCrmBaseInfoDAO;
import com.huateng.scf.bas.crm.model.BCrmBaseInfo;
import com.huateng.scf.bas.crm.service.IBCrmBaseInfoService;
import com.huateng.scf.bas.crr.dao.IBCrrDuebillAppDAO;
import com.huateng.scf.bas.crr.dao.IBCrrLnConDAO;
import com.huateng.scf.bas.crr.dao.IBCrrPrdMdDAO;
import com.huateng.scf.bas.crr.dao.model.BCrrDuebillApp;
import com.huateng.scf.bas.crr.dao.model.BCrrPrdMd;
import com.huateng.scf.bas.crr.model.BCrrDueBillDetail;
import com.huateng.scf.bas.crr.model.BCrrGntyCon;
import com.huateng.scf.bas.crr.model.BCrrLnCon;
import com.huateng.scf.bas.crr.service.IBCrrGntyConService;
import com.huateng.scf.bas.crr.service.IBCrrLnConService;
import com.huateng.scf.bas.icr.model.BIcrInfo;
import com.huateng.scf.bas.icr.service.IBIcrInfoService;
import com.huateng.scf.bas.lan.constant.BLanErrorConstant;
import com.huateng.scf.bas.lan.dao.IBLanAppliLnciBaseDAO;
import com.huateng.scf.bas.lan.dao.IBLanLnciBaseDAO;
import com.huateng.scf.bas.lan.dao.ext.ExtBLanDAO;
import com.huateng.scf.bas.lan.dao.model.BLanLnciBase;
import com.huateng.scf.bas.lan.dao.model.LoanApplyListVO;
import com.huateng.scf.bas.lan.model.ApplyBuyContVO;
import com.huateng.scf.bas.lan.model.BLanAppliLnciBase;
import com.huateng.scf.bas.lan.model.LoanApplyQryVO;
import com.huateng.scf.bas.lan.model.LoanApplyVO;
import com.huateng.scf.bas.lan.model.MortgageLnciBaseInfoLDVO;
import com.huateng.scf.bas.lan.model.MortgageLnciBaseInfoVO;
import com.huateng.scf.bas.lan.service.IBLanAppliLnciBaseService;
import com.huateng.scf.bas.lan.service.IBLanCommonService;
import com.huateng.scf.bas.lan.service.IBLanLnciBuyInfoService;
import com.huateng.scf.bas.lan.service.IBLanLoanApplyService;
import com.huateng.scf.bas.pbc.dao.IBPbcMtgBaseInfoDAO;
import com.huateng.scf.bas.pbc.model.AmountVO;
import com.huateng.scf.bas.pbc.model.BPbcAppliBaseInfo;
import com.huateng.scf.bas.pbc.service.IAmountService;
import com.huateng.scf.bas.pbc.service.IBPbcAppliBaseInfoService;
import com.huateng.scf.bas.prd.constant.BPrdErrorConstant;
import com.huateng.scf.bas.prd.model.BPrdCreditBind;
import com.huateng.scf.bas.prd.model.BPrdInfo;
import com.huateng.scf.bas.prd.service.IBPrdCreditBindService;
import com.huateng.scf.bas.prd.service.IBPrdInfoService;
import com.huateng.scf.bas.sys.constant.WorkflowConstant;
import com.huateng.scf.bas.sys.dao.IBSysAcctBctlDAO;
import com.huateng.scf.bas.sys.dao.model.RSysAcctBctl;
import com.huateng.scf.bas.sys.service.DealEndFlowService;
import com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussDtl;
import com.huateng.scf.rec.bcp.dao.model.RBcpDebtPool;
import com.huateng.scf.rec.bcp.model.DebtCommonQryVO;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * <p>
 * </p>
 *
 * @author shangxiujuan
 * @date 2017年4月10日下午1:34:26
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 *            <pre>
 * =================Modify Record=======================
 * Modifier			   date			              Content
 * shangxiujuan		   2017年4月10日下午1:34:26              新增
 *
 *            </pre>
 */
@ScubeService
@Service("BLanLoanApplyServiceImpl")
public class BLanLoanApplyServiceImpl implements IBLanLoanApplyService,DealEndFlowService {
	private final Logger log = LoggerFactory.getLogger(getClass());
	@Resource(name = "ExtBLanDAO")
	ExtBLanDAO extBLanDAO;

	@Resource(name = "BCrrLnConServiceImpl")
	IBCrrLnConService bCrrLnConService;

	@Resource(name = "AmountServiceImpl")
	IAmountService amountService;

	// 产品信息
	@Resource(name = "BPrdInfoServiceImpl")
	IBPrdInfoService bPrdInfoService;
	// 产品额度绑定
	@Resource(name = "BPrdCreditBindServiceImpl")
	IBPrdCreditBindService bPrdCreditBindService;

	// 额度信息
	@Resource(name = "BIcrInfoServiceImpl")
	IBIcrInfoService bIcrInfoService;
	// 担保合同信息
	@Resource(name = "BCrrGntyConServiceImpl")
	IBCrrGntyConService bCrrGntyConService;
	// 监管协议/担保提货协议/先票(款)后货协议信息
	@Resource(name = "BCntMprotBaseInfoServiceImpl")
	IBCntMprotBaseInfoService bCntMprotBaseInfoService;
	//多方协议参与者信息
	@Resource(name = "BCntMprotPartInfoServiceImpl")
	IBCntMprotPartInfoService bCntMprotPartInfoService;
	//客户信息
	@Resource(name = "BCrmBaseInfoServiceImpl")
	IBCrmBaseInfoService bCrmBaseInfoService;
	

	// 放款公用
	@Resource(name = "BLanCommonServiceImpl")
	IBLanCommonService bLanCommonService;

	@Resource(name = "BPbcAppliBaseInfoServiceImpl")
	IBPbcAppliBaseInfoService bPbcAppliBaseInfoService;

	// 借据申请
	@Resource(name = IBLanAppliLnciBaseService.BEAN_ID)
	IBLanAppliLnciBaseService bLanAppliLnciBaseService;

	// 放款申请购销合同申请表
	@Resource(name = "BLanLnciBuyInfoServiceImpl")
	IBLanLnciBuyInfoService bLanLnciBuyInfoService;
	
	// 间接额度通用处理
	@Resource(name = IScfIndirectCreditService.BEAN_ID)
	IScfIndirectCreditService scfIndirectCreditService;
	
	// 供应链工作流
	@Resource(name = IScfWorkFlowService.BEAN_ID)
	IScfWorkFlowService scfWorkFlowService;

	//押品库存基本信息
	@Resource(name = "BPbcMtgBaseInfoDAO")
	IBPbcMtgBaseInfoDAO ibPbcMtgBaseInfoDAO;
	
	@Resource(name = "IBCrrDuebillAppDAO")
	IBCrrDuebillAppDAO ibcrrduebillappdao;
	@Resource(name = "IBCrrLnConDAO")
	IBCrrLnConDAO ibCrrLnConDAO;
	@Resource(name = "IBCrrPrdMdDAO")
	IBCrrPrdMdDAO bcrrprdmddao;
	@Resource(name = "IBCrmBaseInfoDAO")
	IBCrmBaseInfoDAO ibCrmBaseInfoDAO;
	@Resource(name = "BLanAppliLnciBaseDAO")
	IBLanAppliLnciBaseDAO ibLanAppliLnciBaseDAO;
	@Resource(name = "BLanLnciBaseDAO")
	IBLanLnciBaseDAO ibLanLnciBaseDAO;
	// 用于页面费用网点转译
	@Resource(name = "IBSysAcctBctlDAO")
	IBSysAcctBctlDAO bSysAcctBctlDAO;
	
	private static final String CNAME = "cname";
	private static final String MASTCONTCODE = "mastContCode";
	private static final String DEBETID = "debetId";
	private static final String APPLISTATUSDTL = "appliStatusDtl";
	private static final String SUPPLYCHAINPDID = "supplyChainPdId";
	private static final String APPNO = "appno";

	/**
	 * 放款审批查询列表 先票/款后货
	 */
	@Override
	public Page queryLoanApplyList(int pageNo, int pageSize, LoanApplyQryVO loanApplyQryVO) {
		Page page = new Page(pageSize, pageNo, 0);
		Map<String, Object> map = new HashMap<String, Object>();
		if (null != loanApplyQryVO) {
			String supplyChainPdId = "";
			String cname = loanApplyQryVO.getCname();// 客户名称
			String mastContCode = loanApplyQryVO.getMastContCode();// 信贷合同号
			String debetId = loanApplyQryVO.getDebetId();// 借据号(承兑协议号)
			String appliStatusDtl = loanApplyQryVO.getAppliStatusDtl();// 审批状态
			String flag = loanApplyQryVO.getFlag();// 产品标识
			String appno = loanApplyQryVO.getAppno();// 申请号
			if (StringUtil.isStrNotEmpty(cname)) {
				map.put(CNAME, cname);
			}
			if (StringUtil.isStrNotEmpty(mastContCode)) {
				map.put(MASTCONTCODE, mastContCode);
			}
			if (StringUtil.isStrNotEmpty(debetId)) {
				map.put(DEBETID, debetId);
			}
			if (StringUtil.isStrNotEmpty(appliStatusDtl)) {
				map.put(APPLISTATUSDTL, appliStatusDtl);
			}
			if (StringUtil.isStrNotEmpty(appno)) {
				map.put(APPNO, appno);
			}
			if (ScfBasConstant.PRODUCT_TYPE_FOURWARE.equals(flag)) {
				supplyChainPdId = ScfBasConstant.PRODUCT_TYPE_XPHH;
			}
			/*
			 * else
			 * if(ScfBasConstant.PRODUCT_TYPE_CHATTLE_STATIC.equals(flag)){//静态
			 * supplyChainPdId = productService.getProductStatic(); }else
			 * if(ScfBasConstant.PRODUCT_TYPE_CARPLEDGE.equals(flag)) //汽车货押 {
			 * supplyChainPdId =
			 * productService.getProductInfoByMidParentID(SCFConstants.
			 * PRODUCT_TYPE_CAR_PLEDGE); }else
			 * if(ScfBasConstant.PRODUCT_TYPE_CHATTLE_DYNAMIC.equals(flag)){//动态
			 * supplyChainPdId = productService.getProductDynamic(); } else
			 * if(SCFConstants.PRODUCT_TYPE_CAR_FIRST.equals(flag)){
			 * supplyChainPdId =
			 * productService.getProductInfoByMidParentID(SCFConstants.
			 * PRODUCT_TYPE_CAR_FIRST_PAY); }else
			 * if(SCFConstants.PRODUCT_TYPE_NORMAL_BILL.equals(flag)){ // 普通仓单
			 * supplyChainPdId =
			 * SCFDAOUtils.getTblProductInfoDAO().getProductIdByFlag(
			 * SCFConstants.PRODUCT_TYPE_NORMAL_BILL); }else
			 * if(SCFConstants.PRODUCT_TYPE_STANDARD_BILL.equals(flag)){ // 标准仓单
			 * supplyChainPdId =
			 * SCFDAOUtils.getTblProductInfoDAO().getProductIdByFlag(
			 * SCFConstants.PRODUCT_TYPE_STANDARD_BILL); }
			 */
			if (StringUtil.isStrNotEmpty(supplyChainPdId)) {
				map.put(SUPPLYCHAINPDID, supplyChainPdId);
			}
			loanApplyQryVO.setSupplyChainPdId(supplyChainPdId);
			extBLanDAO.getLoanApplyList(map, page);
		}
		List list = page.getRecords();
		List listTmp = new ArrayList();
		LoanApplyListVO loanApplyListVO = null;
		BCrrGntyCon bCrrGntyCon = null;
		AmountVO amountVO = null;
		// 获得合同信息。因为有可能这两个信息都没有。客户信息已关联
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				loanApplyListVO = (LoanApplyListVO) list.get(i);
				String custcd = loanApplyListVO.getCustcd();
				String mastContcode = loanApplyListVO.getMastContcode();

				// 如果合同存在
				if (StringUtil.isStrNotEmpty(mastContcode)) {

					BCrrLnCon bCrrLnCon = bCrrLnConService.findBCrrLnConByAppId(mastContcode);
					if (bCrrLnCon != null) {

						loanApplyListVO.setCurcd(bCrrLnCon.getCurcd());

						loanApplyListVO.setContAmount(bCrrLnCon.getLnAmt()); // 合同金额
						loanApplyListVO.setRiskAmt(bCrrLnCon.getLnAmt()); // 信贷合同总敞口

						String businessNo = bCrrLnCon.getVidNo(); //

						// 获取信贷合同的可用敞口
						BigDecimal openAmount = amountService.getContRiskAmtByCycle(mastContcode,
								bCrrLnCon.getControlType());
						loanApplyListVO.setAvaliableRiskAmt(bCrrLnCon.getLnAmt().subtract(openAmount));
						// 获取信贷合同的可用敞口
						// 先票/款后货 查询协议
						BPrdInfo bPrdInfo = bPrdInfoService
								.findBPrdInfoObjectByKey(loanApplyQryVO.getSupplyChainPdId());

						// String midProductId =
						// SCFDAOUtils.getTblProductInfoDAO().getSubClassProductIds(loanApplyQryVO.getSupplyChainPdId());
						String productId = bPrdInfo.getProductId();
						String parentId = bPrdInfo.getParentId();
						// 若业务合同号有值，说明该信贷合同已经关联了质押合同了。
				
						if (StringUtil.isStrNotEmpty(businessNo)) {
							// if(ScfBasConstant.PRODUCT_TYPE_WAREHOUSE.equals(midProductId)){
							// 预付类:担保提货，先票款后货，银票通（即保兑仓）
							if(ScfBasConstant.PRODUCT_TYPE_PREP.equals(parentId)){
								if (ScfBasConstant.PRODUCT_TYPE_SMALL_WH.equals(productId)
										||ScfBasConstant.PRODUCT_TYPE_XPHH.equals(productId)) {
									 BCntMprotBaseInfo bCntMprotBaseInfo =
									 bCntMprotBaseInfoService.findBCntMprotBaseInfoByKey(businessNo);
									 if(bCntMprotBaseInfo!=null){
										 loanApplyListVO.setBusinessNo(businessNo);
										 //根据先票/款后货协议查询对应的购销合同
										 BCrrGntyCon qryVO = new BCrrGntyCon();
										 qryVO.setPrtclNo(businessNo); 
//										 List slaveList =
//										SCFDAOUtils.getTblMutiProtBaseInfoDAO().getContSlaveByCustcdAndCore(qryVO).getQueryResult();
//										 if(slaveList!=null&&slaveList.size()>0){
//											 tblContSlaveInfo = (TblContSlaveInfo)slaveList.get(0);
//											 loanApplyListVO.setSlaveContcode(tblContSlaveInfo.getSlaveContcode());
									
//									 }
									 }

									// 判断是否有领用间接额度
									// 查询额度类型
									BPrdCreditBind bPrdCreditBind = new BPrdCreditBind();
									bPrdCreditBind.setProductId(loanApplyListVO.getSupplyChainPdId());
									bPrdCreditBind.setOprMode(ScfBasConstant.CREDIT_OPR_MODE_SELLER_AND_BUYER);// 模式
									bPrdCreditBind.setCreditPhase(ScfBasConstant.CREDIT_PHASE_FOUR_WAREHOUSE_ACCOUNT);// 额度阶段
									bPrdCreditBind.setOprType(ScfBasConstant.CREDIT_OPR_TYPE_OCCUPY);// 操作类型
									String creditType = "";
									List<BPrdCreditBind> creditBindList = bPrdCreditBindService
											.findBPrdCreditBindBPrd(bPrdCreditBind);
									if (creditBindList != null & creditBindList.size() > 0) {
										BPrdCreditBind creditBind = creditBindList.get(0);
										creditType = creditBind.getCreditType(); // 额度类型
									}

									if (StringUtil.isStrNotEmpty(creditType)) {
										BIcrInfo bIcrInfo = new BIcrInfo();
										bIcrInfo.setCreditClass(ScfBasConstant.CREDIT_CLASS_INDIRECT);
										bIcrInfo.setNodeType(ScfBasConstant.CREDIT_NODE_TYPE_SUB_LEAF);// 领用额度
										bIcrInfo.setCustcd(loanApplyListVO.getCreditCustcd());
										bIcrInfo.setOtherCustcd(loanApplyListVO.getCustcd());// appliLnciBaseInfo.getCreditCustcd()
										bIcrInfo.setCreditType(creditType);
										bIcrInfo.setStatus(ScfBasConstant.CREDIT_STATUS_NORMAL);

										List subLeafCreditInfoList = bIcrInfoService
												.findBIcrInfoByPage(1, Integer.MAX_VALUE, bIcrInfo).getRecords();
										if (subLeafCreditInfoList != null && subLeafCreditInfoList.size() > 0) {
											loanApplyListVO.setFlag("1");
										} else {
											loanApplyListVO.setFlag("0");
										}
									}
									// END

								} else {
									bCrrGntyCon = bCrrGntyConService.findBCrrGntyConByConId(businessNo);
									if (bCrrGntyCon != null) {
										loanApplyListVO.setBusinessNo(businessNo);
										loanApplyListVO.setSlaveContcode(bCrrGntyCon.getPrtclNo()); // 业务
									}
								}								
							}
						}
					}
				}

				listTmp.add(loanApplyListVO);
			}
		}
		page.setRecords(listTmp);
		return page;
	}

	/**
	 * 贷款的详细信息
	 * 先票/款后货  、动产、汽车货物
	 * 普通仓单
	 */
	@Override
	public MortgageLnciBaseInfoVO getMortgageLoanApplyInfo(DebtCommonQryVO debtCommonQryVO) throws ScubeBizException {
		// TODO Auto-generated method stub

		//汽车贷款、动产、预付款的VO对象。
		MortgageLnciBaseInfoVO infoVO = new MortgageLnciBaseInfoVO();
		BLanAppliLnciBase appliLnciBaseInfo = bLanAppliLnciBaseService.queryBLanAppliLnciBaseByAppno(debtCommonQryVO.getAppno());// 借据申请信息
		BPbcAppliBaseInfo tblAppliBaseInfo = bPbcAppliBaseInfoService.findBPbcAppliBaseInfoByKey(debtCommonQryVO.getAppno());
		infoVO.setAppBrcode(tblAppliBaseInfo.getAppBrcode());  //申请机构号

		//1-获取借据表的信息
		BeanUtils.copyProperties(appliLnciBaseInfo,infoVO);

		infoVO.setLoanWay(appliLnciBaseInfo.getLnciType());  //出账方式
		//2-借款合同表的信息
		BCrrLnCon bCrrLnCon =bCrrLnConService.findBCrrLnConByAppId(infoVO.getMastContcode());  //信贷合同号
		infoVO.setContStartDate(bCrrLnCon.getLnStrtDt());
		infoVO.setContEndDate(bCrrLnCon.getLnEndDt());
		infoVO.setContAmount(bCrrLnCon.getLnAmt());  //合同金额
		infoVO.setContRiskAmt((bCrrLnCon.getLnAmt()));  //总敞口
		infoVO.setCycle(bCrrLnCon.getControlType() == null ? "2" : bCrrLnCon.getControlType());  //是否循环使用
		infoVO.setMastContStatus(bCrrLnCon.getAppStat()); //合同状态
		infoVO.setMastContcode(bCrrLnCon.getAppId());  //信贷合同号
		infoVO.setMastContno(bCrrLnCon.getAppId()); //信贷合同号(ID)
		infoVO.setCurcd(bCrrLnCon.getCurcd());   //币种
		infoVO.setCreditProtNo(bCrrLnCon.getCreditProtNo());  //额度协议流水号

        //设置借据申请表的产品ID信息
        String product_Q = debtCommonQryVO.getSupplyChainPdId_Q();
        if(StringUtil.isStrNotEmpty(product_Q)){
        	appliLnciBaseInfo.setProductId(product_Q);
        }
        String protocolNo = null;
        String productID = appliLnciBaseInfo.getProductId();
        BPrdInfo bPrdInfo = bPrdInfoService.findBPrdInfoObjectByKey(productID);;
        infoVO.setProductName(bPrdInfo.getProductName()); //业务品种
        String parentId = bPrdInfo.getParentId();
        BigDecimal lowNewPrice = new BigDecimal(0);
        String businessNo  = bCrrLnCon.getVidNo();  //业务合同号
        String moniModel="";

       //获取信贷合同的可用敞口  start
		BigDecimal contOpenAmount=amountService.getContRiskAmtByCycle(bCrrLnCon.getAppId(),bCrrLnCon.getControlType());
		infoVO.setAvaliableRiskAmt(bCrrLnCon.getLnAmt().subtract(contOpenAmount));
		//获取信贷合同的可用敞口 end
		// 现货类:现货动态质押 、现货静态质押 、汽车货押
        if(ScfBasConstant.PRODUCT_TYPE_MORT.equals(parentId)){
        	if(ScfBasConstant.PRODUCT_TYPE_PLDY.equals(productID)
        		||ScfBasConstant.PRODUCT_TYPE_PLSY.equals(productID)
        		||ScfBasConstant.PRODUCT_TYPE_CAR_PL.equals(productID)
        		||ScfBasConstant.PRODUCT_TYPE_BILL_NORMAL.equals(productID))
        	{
        		   //3-担保合同信息 TODO
                BCrrGntyCon tblContSlaveInfo = bCrrGntyConService.findBCrrGntyConByConId(businessNo);  //担保合同号ID
                infoVO.setSupplyChainPdId(tblContSlaveInfo.getVidPrdId());  //业务品种
                infoVO.setSlaveContno(tblContSlaveInfo.getConId());
                infoVO.setSlaveContcode(tblContSlaveInfo.getConId());  //质押合同号
                infoVO.setRation(tblContSlaveInfo.getRation());  //质押率
                infoVO.setBusinessNo(tblContSlaveInfo.getConId());
                protocolNo = tblContSlaveInfo.getPrtclNo();
                lowNewPrice = tblContSlaveInfo.getLowPriceNew();
                moniModel=tblContSlaveInfo.getMoniMd();
        	}
        	
        }
        //预付类 ：担保提货 先票/款后货
        if(ScfBasConstant.PRODUCT_TYPE_PREP.equals(parentId)){
        	if(ScfBasConstant.PRODUCT_TYPE_SMALL_WH.equals(productID)
        		||ScfBasConstant.PRODUCT_TYPE_XPHH.equals(productID)
        		){
            	BCntMprotBaseInfo tblMutiProtBaseInfo = new BCntMprotBaseInfo();
            	infoVO.setHasIndirectCredit(appliLnciBaseInfo.getHasIndirectCredit()); //间接额度类型
            	tblMutiProtBaseInfo = bCntMprotBaseInfoService.findBCntMprotBaseInfoByKey(businessNo);
            	protocolNo = tblMutiProtBaseInfo.getProtocolNo();
            	infoVO.setBusinessNo(protocolNo); //先票款后货协议
            	infoVO.setProtocolCode(protocolNo);
            	infoVO.setProtocolNo(protocolNo);
            	infoVO.setSupplyChainPdId(tblMutiProtBaseInfo.getProductId());
            	String custcd = bCntMprotPartInfoService.findCnameByProAndRole(tblMutiProtBaseInfo.getProtocolNo(),ScfBasConstant.PROTOCOL_PART_ROLE_BACKCORE, ScfBasConstant.RETURN_FLAG_CUSTCD);
            	//
            	BCrmBaseInfo bCrmBaseInfo =bCrmBaseInfoService.findBCrmBaseInfoObjectByKey(custcd);
            	infoVO.setAssureCname(bCrmBaseInfo.getCname()); //担保方名称

            	//间接可用额度计算
                BigDecimal creditUseBal=BigDecimal.ZERO;
               //查询额度类型
                BPrdCreditBind bind=new BPrdCreditBind();
                bind.setProductId(appliLnciBaseInfo.getProductId());
                bind.setOprMode(ScfBasConstant.CREDIT_OPR_MODE_SELLER_AND_BUYER);//模式
                bind.setCreditPhase(ScfBasConstant.CREDIT_PHASE_FOUR_WAREHOUSE_ACCOUNT);//额度阶段
                bind.setOprType(ScfBasConstant.CREDIT_OPR_TYPE_OCCUPY);//操作类型
               	String creditType="";
               	List<BPrdCreditBind>  creditBindList = bPrdCreditBindService.getTblProductCreditBind(bind);
             		if(creditBindList!=null&creditBindList.size()>0){
             			BPrdCreditBind creditBind = creditBindList.get(0);
             			 creditType = creditBind.getCreditType();  // 额度类型
             		}


             	if(StringUtil.isStrNotEmpty(creditType)){
             	// 间接额度表
            	BIcrInfo bIcrInfo = new BIcrInfo();
            	bIcrInfo.setCreditClass(ScfBasConstant.CREDIT_CLASS_INDIRECT);
            	bIcrInfo.setNodeType(ScfBasConstant.CREDIT_NODE_TYPE_SUB_LEAF);
            	bIcrInfo.setCustcd(appliLnciBaseInfo.getCreditCustcd());
            	bIcrInfo.setOtherCustcd(appliLnciBaseInfo.getCustcd());//appliLnciBaseInfo.getCreditCustcd()
            	bIcrInfo.setCreditType(creditType);
            	bIcrInfo.setStatus(ScfBasConstant.CREDIT_STATUS_NORMAL);
           		Page page=bIcrInfoService.findBIcrInfoByPage(1, Integer.MAX_VALUE, bIcrInfo);
           		List<BIcrInfo> icrList = page.getRecords();
    	       		if (icrList!=null&&icrList.size()>0) {
    	       			BIcrInfo subLeafInfo =(BIcrInfo)icrList.get(0);
    	       			creditUseBal=subLeafInfo.getCreditUsableAmount();//可用额度
    	       			infoVO.setIndirectCreaditLastAmt(creditUseBal);
    	       		}
             	}
             	 //计算可用敞口
                AmountVO amountVO=new AmountVO();
                amountVO.setProductId(infoVO.getSupplyChainPdId());//产品类型
                amountVO.setDebetNo(infoVO.getDebetNo());//借据号 
                amountVO.setArrivedManageModel(ScfBasConstant.ARRIVED_MANAGE_MODE_SINGLE); //融资方式
                BigDecimal openAmount=amountService.getPant(amountVO);//敞口金额
          //    mortgageLnciBaseInfoVO.setAvaliableRiskAmt(mortgageLnciBaseInfoVO.getContRiskAmt().subtract(openAmount));//信贷合同可用敞口
                //本笔风险敞口
                //规则：本笔风险敞口 = 出账金额 – 初始保证金 – 初始现金等价物金额。页面端需要根据初始现金等价物的更新而变化。
                if(infoVO.getBailAmount() == null)
                {
                	infoVO.setBailAmount(new BigDecimal(0));  //判空处理
                }
                if(infoVO.getInitCashEqtAmt() == null)
                {
                	infoVO.setInitCashEqtAmt(new BigDecimal(0));   //判空处理
                }

                BigDecimal riskAmt = infoVO.getLnciAmt().subtract(infoVO.getBailAmount()).subtract(infoVO.getInitCashEqtAmt());
                infoVO.setRiskAmt(riskAmt);

        	}
        }

        //4-监管合同信息
        infoVO.setProtocolNo(protocolNo);
        
       BCntMprotBaseInfo bCntMprotBaseInfo = bCntMprotBaseInfoService.findBCntMprotBaseInfoByKey(protocolNo);
        if(bCntMprotBaseInfo != null)
        {
        	infoVO.setProtocolCode(bCntMprotBaseInfo.getProtocolCode());
        	String custcd = bCntMprotPartInfoService.findCnameByProAndRole(protocolNo,ScfBasConstant.PROTOCOL_PART_ROLE_MONI, ScfBasConstant.RETURN_FLAG_CUSTCD);
        	//
        	BCrmBaseInfo bCrmBaseInfo =bCrmBaseInfoService.findBCrmBaseInfoObjectByKey(custcd);
        	infoVO.setMoniCustcd(custcd);  //监管公司客户号
        	if(bCrmBaseInfo!=null){
        		infoVO.setMoniName(bCrmBaseInfo.getCname());  //监管公司名称
        	}
        	
        }

        //5-出质人名称
        BCrmBaseInfo bCrmBaseInfo = null;
        bCrmBaseInfo = bCrmBaseInfoService.findBCrmBaseInfoObjectByKey(infoVO.getCustcd());
        infoVO.setCname(bCrmBaseInfo.getCname());

     // 现货类:现货动态质押 、现货静态质押 、汽车货押
        if(ScfBasConstant.PRODUCT_TYPE_MORT.equals(parentId)){
        	if(ScfBasConstant.PRODUCT_TYPE_PLDY.equals(productID)
        		||ScfBasConstant.PRODUCT_TYPE_PLSY.equals(productID)
        		||ScfBasConstant.PRODUCT_TYPE_CAR_PL.equals(productID)
        		){
        	 	  //6-计算可用敞口
                AmountVO amountVO =  new AmountVO();
                amountVO.setProductId(infoVO.getSupplyChainPdId());
                amountVO.setProtocolNo(infoVO.getBusinessNo());
                BigDecimal openAmount = amountService.getPant(amountVO);//敞口余额
                infoVO.setOpenAmount(openAmount);
          //    mortgageLnciBaseInfoVO.setAvaliableRiskAmt(mortgageLnciBaseInfoVO.getContRiskAmt().subtract(openAmount));//信贷合同可用敞口

                //7-现货押品总价值B_PBC_MTG_BASE_INFO
            	BigDecimal totalPrice = BigDecimal.ZERO;
            	List<Map> mortgageList = ibPbcMtgBaseInfoDAO.selectByCondition(infoVO.getBusinessNo());
                if(mortgageList!=null && mortgageList.size() > 0)
                {
                	Map map = mortgageList.get(0);
                	if (map.get("TOTPRICE") != null) {
                		totalPrice = (BigDecimal) map.get("TOTPRICE");
        			}
                	infoVO.setMortgageTotalValue(totalPrice);  //押品总价值
                	
                }

                //8-可融资金额
                //规则：可融资金额 = 押品总价值*质押率 - 敞口余额
                BigDecimal avaliableAmt = BigDecimal.ZERO;
                if(ScfBasConstant.MONI_MODEL_STATIC.equals(moniModel)){//静态
                	avaliableAmt =infoVO
                			.getMortgageTotalValue().multiply(
                					infoVO.getRation()).divide(new BigDecimal(100)).subtract(
                							openAmount).setScale(
                									2, BigDecimal.ROUND_HALF_UP);
                }else{
                	avaliableAmt =lowNewPrice.multiply(
                			infoVO.getRation()).divide(new BigDecimal(100)).subtract(
                							openAmount).setScale(
                									2, BigDecimal.ROUND_HALF_UP);
                }

                infoVO.setAvaliableAmt(avaliableAmt);

                //9-本笔风险敞口
                //规则：本笔风险敞口 = 出账金额 – 初始保证金 – 初始现金等价物金额。页面端需要根据初始现金等价物的更新而变化。
                if(infoVO.getBailAmount() == null)
                {
                	infoVO.setBailAmount(new BigDecimal(0));  //判空处理
                }
                if(infoVO.getInitCashEqtAmt() == null)
                {
                	infoVO.setInitCashEqtAmt(new BigDecimal(0));   //判空处理
                }

                BigDecimal riskAmt = infoVO.getLnciAmt().subtract(infoVO.getBailAmount()).subtract(infoVO.getInitCashEqtAmt());
                infoVO.setRiskAmt(riskAmt);
                //汽车货押或监管模式 2-静态
                	if(ScfBasConstant.PRODUCT_TYPE_CAR_PL.equals(productID) //
                			||moniModel.equals(ScfBasConstant.MONI_MODEL_STATIC)
                			){
                		lowNewPrice=openAmount.multiply(new BigDecimal(100)).divide(infoVO.getRation(),2,BigDecimal.ROUND_HALF_UP);
                		infoVO.setLowPriceNew(lowNewPrice);
                		
                }
        	}else{
            	infoVO.setLowPriceNew(lowNewPrice);
            }
        		
        }
	
		return infoVO;
	}
	
	/**
	 * 放款供应链补录保存 先票/款后货
	 */
	@Transactional
	@Override
	public String LoanApplySaveUpdate(MortgageLnciBaseInfoVO mortgageLnciBaseInfoVO, List<ApplyBuyContVO> list) {
		// TODO Auto-generated method stub
		String appno = "";
		String productId = "";
		if (null != mortgageLnciBaseInfoVO) {
			productId = mortgageLnciBaseInfoVO.getSupplyChainPdId();
			BPrdInfo bPrdInfo = bPrdInfoService.findBPrdInfoObjectByKey(productId);
			String parentId = "";
			if (bPrdInfo == null) {
				log.error("不存在对应的产品！");
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BPrdErrorConstant.SCF_BAS_PRD_10002),
						BPrdErrorConstant.SCF_BAS_PRD_10002);
			}
			parentId = bPrdInfo.getParentId();
			// 先票后货 TODO动产、汽车货押、
			if (ScfBasConstant.PRODUCT_TYPE_XPHH.equals(productId)
			// ||ScfBasConstant.PRODUCT_TYPE_CAR_PLEDGE.equals(productId)
			// || ScfBasConstant.PRODUCT_TYPE_CHATTLE.equals(productId)
			) {
				LoanApplyVO loanApplyVO = new LoanApplyVO();
				loanApplyVO.setMastContcode(mortgageLnciBaseInfoVO.getMastContcode());
				loanApplyVO.setAppno(mortgageLnciBaseInfoVO.getAppno());

				loanApplyVO.setMastContcode(mortgageLnciBaseInfoVO.getMastContcode());
				appno = bPbcAppliBaseInfoService.saveLoanAppBasicInfo(loanApplyVO);
				mortgageLnciBaseInfoVO.setAppno(appno);
				// 放款校验
				bLanCommonService.checkLoanApplyInfo(appno, mortgageLnciBaseInfoVO.getInitCashEqtAmt());

				// 保存借据申请表的信息
				this.saveLoanApplyInfo(mortgageLnciBaseInfoVO);
				// 先票款后货保存购销合同出账申请信息;
				if (ScfBasConstant.PRODUCT_TYPE_PREP.equals(parentId)) {
					if (ScfBasConstant.PRODUCT_TYPE_XPHH.equals(productId)) {// 先票款后货
						bLanLnciBuyInfoService.saveLoanApplyBuyContnoInfo(list, appno, false);
					}

				}
			}
		}
		return appno;

	}

	/**
	 * 放款供应链补录提交 先票/款后货
	 */
	@Transactional
	@Override
	public void LoanApplyWriteSubmit(MortgageLnciBaseInfoVO mortgageLnciBaseInfoVO, List<ApplyBuyContVO> list) {
		// TODO Auto-generated method stub
		String appno = mortgageLnciBaseInfoVO.getAppno();
		String productId = "";
		if (null != mortgageLnciBaseInfoVO) {
			productId = mortgageLnciBaseInfoVO.getSupplyChainPdId();
			BPrdInfo bPrdInfo = bPrdInfoService.findBPrdInfoObjectByKey(productId);
			String parentId = "";
			if (bPrdInfo == null) {
				log.error("不存在对应的产品！");
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BPrdErrorConstant.SCF_BAS_PRD_10002),
						BPrdErrorConstant.SCF_BAS_PRD_10002);
			}
			parentId = bPrdInfo.getParentId();
			// TODO先票后货 动产、汽车货押、

			if (ScfBasConstant.PRODUCT_TYPE_XPHH.equals(productId)
			// ||ScfBasConstant.PRODUCT_TYPE_CAR_PLEDGE.equals(productId)
			// || ScfBasConstant.PRODUCT_TYPE_CHATTLE.equals(productId)
			) {
				/*LoanApplyVO loanApplyVO = new LoanApplyVO();
				loanApplyVO.setMastContcode(mortgageLnciBaseInfoVO.getMastContcode());
				loanApplyVO.setAppno(mortgageLnciBaseInfoVO.getAppno());

				loanApplyVO.setMastContcode(mortgageLnciBaseInfoVO.getMastContcode());
				appno = bPbcAppliBaseInfoService.saveLoanAppBasicInfo(loanApplyVO);
				mortgageLnciBaseInfoVO.setAppno(appno);*/
				// 放款校验
				bLanCommonService.checkLoanApplyInfo(appno, mortgageLnciBaseInfoVO.getInitCashEqtAmt());

				// 保存借据申请表的信息
				this.saveLoanApplyInfo(mortgageLnciBaseInfoVO);
				// 先票款后货保存购销合同出账申请信息;
				if (ScfBasConstant.PRODUCT_TYPE_PREP.equals(parentId)) {
					if (ScfBasConstant.PRODUCT_TYPE_XPHH.equals(productId)) {// 先票款后货
						bLanLnciBuyInfoService.saveLoanApplyBuyContnoInfo(list, appno, false);
					}

				}
				//TODO 现货质押、汽车货押占用监管商额度 add by huangshuidan 2014-02-12 begin
				/*if (SCFConstants.PRODUCT_TYPE_CAR_PLEDGE.equals(midProductId)
						|| SCFConstants.PRODUCT_TYPE_CHATTLE.equals(midProductId)) {
					TblAppliLnciBaseInfoDAO tblAppliLnciBaseInfoDAO = SCFDAOUtils.getTblAppliLnciBaseInfoDAO();
					TblAppliLnciBaseInfo tblAppliLnciBaseInfo = tblAppliLnciBaseInfoDAO
							.queryAppliLnciBaseInfoByAppno(tblAppliLnciInfo.getAppno());
					String hasIndirectCredit = tblAppliLnciBaseInfo.getHasIndirectCredit() == null ? ""
							: tblAppliLnciBaseInfo.getHasIndirectCredit().trim();
					if (SCFConstants.FLAG_ON.equals(hasIndirectCredit)) {// 有间接额度
						BigDecimal lnciRiskAmt = AmountService.getInstance()
								.getLnciRiskAmtByAppno(tblAppliLnciInfo.getAppno());
						IndirectCreditService.getInstance().indirectCreditAppliCommonProcess(
								tblAppliLnciInfo.getAppno(), null, SCFConstants.CREDIT_TRADE_TYPE_DIRECT_OCCUPY,
								lnciRiskAmt);
					}
				}*/
				// 现货质押、汽车货押占用监管商额度 add by huangshuidan 2014-02-12 end
				
				//现票后货占用间接额度
				if(ScfBasConstant.PRODUCT_TYPE_XPHH.equals(productId)){
					BLanAppliLnciBase bLanAppliLnciBase = bLanAppliLnciBaseService
							.queryBLanAppliLnciBaseByAppno(appno);
					String hasIndirectCredit=bLanAppliLnciBase.getHasIndirectCredit()==null?"":bLanAppliLnciBase.getHasIndirectCredit().trim();

					if(ScfBasConstant.FLAG_ON.equals(hasIndirectCredit)){//有间接额度
						BigDecimal lnciRiskAmt=amountService.getLnciRiskAmtByAppno(appno);
						Map<String, String> indirectMap = new HashMap<String, String>();
						indirectMap.put(IndirectCreditConstant.APP_NO, appno); //业务申请号
						indirectMap.put(IndirectCreditConstant.DEBIT_NO, bLanAppliLnciBase.getDebetNo());
						indirectMap.put(IndirectCreditConstant.OPER_TYPE, ScfBasConstant.CREDIT_TRADE_TYPE_DIRECT_OCCUPY); ////操作类型
						scfIndirectCreditService.indCreditAppliCommonProcess(indirectMap, lnciRiskAmt);
					}
				}
//TODO
				/*String switchType = SysParamUnit.getCcmsFlag();
				if (SCFConstants.FLAG_ON.equals(switchType)){
					TblAppliBaseInfo tblAppliBaseInfo=SCFDAOUtils.getTblAppliBaseInfoDAO().get(tblAppliLnciInfo.getAppno());
					G012ReqData g012ReqData= new G012ReqData();
					g012ReqData.setCcmsAppno(tblAppliBaseInfo.getIncomeAppno());
					g012ReqData.setOpinion(SCFConstants.SCF_LOAN_AGREE);
					g012ReqData.setRemark("");
					CcmsClientService.getInstance().doG012(g012ReqData);
				}*/
				
				// 流程流转
				BPbcAppliBaseInfo bPbcAppliBaseInfo = bPbcAppliBaseInfoService.findBPbcAppliBaseInfoByKey(appno);
				String status = WorkflowConstant.WORKFLOW_TRANS_AGREE;
				try {
					scfWorkFlowService.processTasks(bPbcAppliBaseInfo, status);
				} catch (FlowsharpException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					log.error(e.getMessage());
				throw new ScubeBizException("工作流异常！");
				}
				UserInfo user = ContextHolder.getUserInfo();
				String userId = user.getTlrNo();
				bPbcAppliBaseInfo.setApprover(userId); // 当前已审批人员
				bPbcAppliBaseInfo.setApproveBrcode(user.getBrNo()); // 当前已审批机构
				bPbcAppliBaseInfo.setApproveDate(ScfDateUtil.getStringDate(new Date())); // 当前已审批日期
				bPbcAppliBaseInfo.setApproveTime(new Date()); // 当前已审批时间
				bPbcAppliBaseInfo.setAppliStatusDtl(WorkflowConstant.APPLI_STATUS_DTL_WAITCMS);
				bPbcAppliBaseInfo.setAppliStatus(WorkflowConstant.APPLI_STATUS_SUBMITUNAPPROVE);
				/*com.huateng.scf.bas.pbc.model.BPbcAppliBaseInfo appliBaseInfo = new com.huateng.scf.bas.pbc.model.BPbcAppliBaseInfo();
				BeanUtils.copyProperties(bPbcAppliBaseInfo, appliBaseInfo);*/
				bPbcAppliBaseInfoService.updateBPbcAppliBaseInfo(bPbcAppliBaseInfo);
			}
		}

	}

	/***
	 * 退回修改
	 */
	@Override
	public void doWorkForBack(String appNo) {
		// TODO Auto-generated method stub
		String status = WorkflowConstant.WORKFLOW_TRANS_GOBACK;
		BPbcAppliBaseInfo bPbcAppliBaseInfo = bPbcAppliBaseInfoService.findBPbcAppliBaseInfoByKey(appNo);
		try {
			scfWorkFlowService.processTasks(bPbcAppliBaseInfo, status);
		} catch (FlowsharpException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 审批通过 
	 */
	@Override
	public void doWorkForPass(String appNo) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * 审批拒绝
	 */
	@Override
	public void doWorkForReject(String appNo) {
		// TODO Auto-generated method stub
		
	}

	


	
	/**
	 * 保存借据表的信息
	 */
	@Transactional
	@Override
	public void saveLoanApplyInfo(MortgageLnciBaseInfoVO appliLnciInfo) throws ScubeBizException {
		// 保存借据申请表的信息
		BLanAppliLnciBase bLanAppliLnciBase = bLanAppliLnciBaseService
				.queryBLanAppliLnciBaseByAppno(appliLnciInfo.getAppno());
		// 获取中类信息
		// String midProductId =
		// SCFDAOUtils.getTblProductInfoDAO().getSubClassProductIds(appliLnciInfo.getSupplyChainPdId());
		String productId = appliLnciInfo.getSupplyChainPdId();
		// 获取父类信息
		BPrdInfo bPrdInfo = bPrdInfoService.findBPrdInfoObjectByKey(productId);
		String parentId = "";
		if (bPrdInfo == null) {
			log.error("不存在对应的产品！");
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BPrdErrorConstant.SCF_BAS_PRD_10002),
					BPrdErrorConstant.SCF_BAS_PRD_10002);
		}
		parentId = bPrdInfo.getParentId();
		// 补录相关的信息
		bLanAppliLnciBase.setInitCashEqtAmt(
				appliLnciInfo.getInitCashEqtAmt() == null ? new BigDecimal(0) : appliLnciInfo.getInitCashEqtAmt());
		BigDecimal bailAmount = bLanAppliLnciBase.getBailAmount() == null ? new BigDecimal(0)
				: bLanAppliLnciBase.getBailAmount();
		BigDecimal addBailAmount = bLanAppliLnciBase.getAddBailAmount() == null ? new BigDecimal(0)
				: bLanAppliLnciBase.getAddBailAmount();
		bLanAppliLnciBase.setTotalBailAmount(bailAmount.add(addBailAmount)); // 保证金总金额
		bLanAppliLnciBase.setRiskAmt(appliLnciInfo.getRiskAmt()); // 本笔风险敞口；
		bLanAppliLnciBase.setAvaliableAmt(appliLnciInfo.getAvaliableAmt()); // 可融资金额
		bLanAppliLnciBase.setBailAmount(appliLnciInfo.getBailAmount());
		// 预付类借据补录协议编号、客户经理
		if (ScfBasConstant.PRODUCT_TYPE_PREP.equals(parentId)) {
			if (ScfBasConstant.PRODUCT_TYPE_SMALL_WH.equals(productId)
					|| ScfBasConstant.PRODUCT_TYPE_XPHH.equals(productId)) {

				bLanAppliLnciBase.setMgrno(ContextHolder.getUserInfo().getTlrNo());
				bLanAppliLnciBase.setProtocolNo(appliLnciInfo.getBusinessNo());
				bLanAppliLnciBase.setSlaveLimit(appliLnciInfo.getSlaveLimit());
				// 先票款后货
				if (ScfBasConstant.PRODUCT_TYPE_XPHH.equals(productId)) {
					if (StringUtil.isEmpty(bLanAppliLnciBase.getSlaveContno())) {
						List<BCntMprotBaseInfo> mutiList = bCntMprotBaseInfoService.getProtocolByOtherProtocol(
								bLanAppliLnciBase.getProtocolNo(), ScfBasConstant.MUTI_PROTOCOL_MONI);
						if (mutiList != null && mutiList.size() > 0) {
							BCntMprotBaseInfo bCntMprotBaseInfo = (BCntMprotBaseInfo) mutiList.get(0);
							if (bCntMprotBaseInfo != null) {
								List<BCrrGntyCon> slaveList = bCrrGntyConService
										.getContSlaveByProtocolNo(bCntMprotBaseInfo.getProtocolNo());
								if (slaveList != null && slaveList.size() > 0) {
									bLanAppliLnciBase.setSlaveContno(((BCrrGntyCon) slaveList.get(0)).getConId()); // 质押合同号
								}
							}
						}
					}
				}
			}
		}
		//TODO
//		 if(SCFConstants.PRODUCT_TYPE_CAR_PLEDGE.equals(midProductId) ||
//		 SCFConstants.PRODUCT_TYPE_CHATTLE.equals(midProductId)) {
//		 if(SCFDataFormat.isEmpty(bLanAppliLnciBase.getSlaveContno())) {
//		 TblContBaseInfoDAO tblContBaseInfoDAO =
//		 SCFDAOUtils.getTblContBaseInfoDAO(); TblContSlaveInfoDAO
//		 tblContSlaveInfoDAO = SCFDAOUtils.getTblContSlaveInfoDAO();
//		 TblContBaseInfo tblContBaseInfo =
//		 tblContBaseInfoDAO.getTblContBaseInfoByMastContCode(bLanAppliLnciBase
//		 .getMastContcode()); TblContSlaveInfo tblContSlaveInfo =
//		 tblContSlaveInfoDAO.get(tblContBaseInfo.getBusinessNo());
//		 bLanAppliLnciBase.setSlaveContno(tblContSlaveInfo.getSlaveContno());
//		 //质押合同号
//		 bLanAppliLnciBase.setProtocolNo(tblContSlaveInfo.getProtocolNo());
//		 //监管协议号 } }
		
		if (StringUtil.isEmpty(bLanAppliLnciBase.getId())) {
			bLanAppliLnciBase.setId(UUIDGeneratorUtil.generate());
		}
		if (StringUtil.isEmpty(bLanAppliLnciBase.getDebetNo())) {
			bLanAppliLnciBase.setDebetNo(UUIDGeneratorUtil.generate());
		}

		// TODO 有更新，无新增
		bLanAppliLnciBaseService.updateBLanAppliLnciBase(bLanAppliLnciBase);
	}

	@Override
	public MortgageLnciBaseInfoLDVO getMortgageLoanApplyInfoLD(DebtCommonQryVO debtCommonQryVO) throws ScubeBizException {

		//先票款后货流贷
		MortgageLnciBaseInfoLDVO infoVO = new MortgageLnciBaseInfoLDVO();
		BLanAppliLnciBase appliLnciBaseInfo = bLanAppliLnciBaseService.queryBLanAppliLnciBaseByAppno(debtCommonQryVO.getAppno());// 借据申请信息
		BPbcAppliBaseInfo tblAppliBaseInfo = bPbcAppliBaseInfoService.findBPbcAppliBaseInfoByKey(debtCommonQryVO.getAppno());
		infoVO.setAppBrcode(tblAppliBaseInfo.getAppBrcode());  //申请机构号

		//1-获取借据表的信息
		BeanUtils.copyProperties(appliLnciBaseInfo,infoVO);

		infoVO.setLoanWay(appliLnciBaseInfo.getLnciType());  //出账方式
		//2-借款合同表的信息
		BCrrLnCon bCrrLnCon =bCrrLnConService.findBCrrLnConByAppId(infoVO.getMastContcode());  //信贷合同号
		infoVO.setContStartDate(bCrrLnCon.getLnStrtDt());
		infoVO.setContEndDate(bCrrLnCon.getLnEndDt());
		infoVO.setContAmount(bCrrLnCon.getLnAmt());  //合同金额
		infoVO.setContRiskAmt((bCrrLnCon.getLnAmt()));  //总敞口
		infoVO.setCycle(bCrrLnCon.getControlType() == null ? "2" : bCrrLnCon.getControlType());  //是否循环使用
		infoVO.setMastContStatus(bCrrLnCon.getAppStat()); //合同状态
		infoVO.setMastContcode(bCrrLnCon.getAppId());  //信贷合同号
		infoVO.setMastContno(bCrrLnCon.getAppId()); //信贷合同号(ID)
		infoVO.setCurcd(bCrrLnCon.getCurcd());   //币种
		infoVO.setCreditProtNo(bCrrLnCon.getCreditProtNo());  //额度协议流水号

        //设置借据申请表的产品ID信息
        String product_Q = debtCommonQryVO.getSupplyChainPdId_Q();
        if(StringUtil.isStrNotEmpty(product_Q)){
        	appliLnciBaseInfo.setProductId(product_Q);
        }
        String protocolNo = null;
        String productID = appliLnciBaseInfo.getProductId();
        BPrdInfo bPrdInfo = bPrdInfoService.findBPrdInfoObjectByKey(productID);;
        infoVO.setProductName(bPrdInfo.getProductName()); //业务品种
        String parentId = bPrdInfo.getParentId();
        BigDecimal lowNewPrice = new BigDecimal(0);
        String businessNo  = bCrrLnCon.getVidNo();  //业务合同号
        String moniModel="";

       //获取信贷合同的可用敞口  start
		BigDecimal contOpenAmount=amountService.getContRiskAmtByCycle(bCrrLnCon.getAppId(),bCrrLnCon.getControlType());
		infoVO.setAvaliableRiskAmt(bCrrLnCon.getLnAmt().subtract(contOpenAmount));
		//获取信贷合同的可用敞口 end

        //预付类 ：担保提货 先票/款后货
        if(ScfBasConstant.PRODUCT_TYPE_PREP.equals(parentId)){
        	if(ScfBasConstant.PRODUCT_TYPE_SMALL_WH.equals(productID)
        		||ScfBasConstant.PRODUCT_TYPE_XPHH.equals(productID)
        		){
            	BCntMprotBaseInfo tblMutiProtBaseInfo = new BCntMprotBaseInfo();
            	infoVO.setHasIndirectCredit(appliLnciBaseInfo.getHasIndirectCredit()); //间接额度类型
            	tblMutiProtBaseInfo = bCntMprotBaseInfoService.findBCntMprotBaseInfoByKey(businessNo);
            	protocolNo = tblMutiProtBaseInfo.getProtocolNo();
            	infoVO.setBusinessNo(protocolNo); //先票款后货协议
            	infoVO.setProtocolCode(protocolNo);
            	infoVO.setProtocolNo(protocolNo);
            	infoVO.setSupplyChainPdId(tblMutiProtBaseInfo.getProductId());
            	String custcd = bCntMprotPartInfoService.findCnameByProAndRole(tblMutiProtBaseInfo.getProtocolNo(),ScfBasConstant.PROTOCOL_PART_ROLE_BACKCORE, ScfBasConstant.RETURN_FLAG_CUSTCD);
            	//
            	BCrmBaseInfo bCrmBaseInfo =bCrmBaseInfoService.findBCrmBaseInfoObjectByKey(custcd);
            	infoVO.setAssureCname(bCrmBaseInfo.getCname()); //担保方名称

            	//间接可用额度计算
                BigDecimal creditUseBal=BigDecimal.ZERO;
               //查询额度类型
                BPrdCreditBind bind=new BPrdCreditBind();
                bind.setProductId(appliLnciBaseInfo.getProductId());
                bind.setOprMode(ScfBasConstant.CREDIT_OPR_MODE_SELLER_AND_BUYER);//模式
                bind.setCreditPhase(ScfBasConstant.CREDIT_PHASE_FOUR_WAREHOUSE_ACCOUNT);//额度阶段
                bind.setOprType(ScfBasConstant.CREDIT_OPR_TYPE_OCCUPY);//操作类型
               	String creditType="";
               	List<BPrdCreditBind>  creditBindList = bPrdCreditBindService.getTblProductCreditBind(bind);
             		if(creditBindList!=null&creditBindList.size()>0){
             			BPrdCreditBind creditBind = creditBindList.get(0);
             			 creditType = creditBind.getCreditType();  // 额度类型
             		}


             	if(StringUtil.isStrNotEmpty(creditType)){
             	// 间接额度表
            	BIcrInfo bIcrInfo = new BIcrInfo();
            	bIcrInfo.setCreditClass(ScfBasConstant.CREDIT_CLASS_INDIRECT);
            	bIcrInfo.setNodeType(ScfBasConstant.CREDIT_NODE_TYPE_SUB_LEAF);
            	bIcrInfo.setCustcd(appliLnciBaseInfo.getCreditCustcd());
            	bIcrInfo.setOtherCustcd(appliLnciBaseInfo.getCustcd());//appliLnciBaseInfo.getCreditCustcd()
            	bIcrInfo.setCreditType(creditType);
            	bIcrInfo.setStatus(ScfBasConstant.CREDIT_STATUS_NORMAL);
           		Page page=bIcrInfoService.findBIcrInfoByPage(1, Integer.MAX_VALUE, bIcrInfo);
           		List<BIcrInfo> icrList = page.getRecords();
    	       		if (icrList!=null&&icrList.size()>0) {
    	       			BIcrInfo subLeafInfo =(BIcrInfo)icrList.get(0);
    	       			creditUseBal=subLeafInfo.getCreditUsableAmount();//可用额度
    	       			infoVO.setIndirectCreaditLastAmt(creditUseBal);
    	       		}
             	}
             	 //计算可用敞口
                AmountVO amountVO=new AmountVO();
                amountVO.setProductId(infoVO.getSupplyChainPdId());//产品类型
                amountVO.setDebetNo(infoVO.getDebetNo());//借据号 
                amountVO.setArrivedManageModel(ScfBasConstant.ARRIVED_MANAGE_MODE_SINGLE); //融资方式
                BigDecimal openAmount=amountService.getPant(amountVO);//敞口金额
          //    mortgageLnciBaseInfoVO.setAvaliableRiskAmt(mortgageLnciBaseInfoVO.getContRiskAmt().subtract(openAmount));//信贷合同可用敞口
                //本笔风险敞口
                //规则：本笔风险敞口 = 出账金额 – 初始保证金 – 初始现金等价物金额。页面端需要根据初始现金等价物的更新而变化。
                if(infoVO.getBailAmount() == null)
                {
                	infoVO.setBailAmount(new BigDecimal(0));  //判空处理
                }
                if(infoVO.getInitCashEqtAmt() == null)
                {
                	infoVO.setInitCashEqtAmt(new BigDecimal(0));   //判空处理
                }

                BigDecimal riskAmt = infoVO.getLnciAmt().subtract(infoVO.getBailAmount()).subtract(infoVO.getInitCashEqtAmt());
                infoVO.setRiskAmt(riskAmt);

        	}
        }

        //4-监管合同信息
        infoVO.setProtocolNo(protocolNo);
        
       BCntMprotBaseInfo bCntMprotBaseInfo = bCntMprotBaseInfoService.findBCntMprotBaseInfoByKey(protocolNo);
        if(bCntMprotBaseInfo != null)
        {
        	infoVO.setProtocolCode(bCntMprotBaseInfo.getProtocolCode());
        	String custcd = bCntMprotPartInfoService.findCnameByProAndRole(protocolNo,ScfBasConstant.PROTOCOL_PART_ROLE_MONI, ScfBasConstant.RETURN_FLAG_CUSTCD);
        	//
        	BCrmBaseInfo bCrmBaseInfo =bCrmBaseInfoService.findBCrmBaseInfoObjectByKey(custcd);
        	infoVO.setMoniCustcd(custcd);  //监管公司客户号
        	if(bCrmBaseInfo!=null){
        		infoVO.setMoniName(bCrmBaseInfo.getCname());  //监管公司名称
        	}
        	
        }

        //5-出质人名称
        BCrmBaseInfo bCrmBaseInfo = null;
        bCrmBaseInfo = bCrmBaseInfoService.findBCrmBaseInfoObjectByKey(infoVO.getCustcd());
        infoVO.setCname(bCrmBaseInfo.getCname());
        
		return this.getDetails(infoVO);
	}

	//获取融资信息、利率信息
    public MortgageLnciBaseInfoLDVO getDetails(MortgageLnciBaseInfoLDVO vo){
		BCrrDuebillApp bCrrDuebillApp = ibcrrduebillappdao.selectByPrimaryKey(vo.getAppno());
		if (bCrrDuebillApp == null) {
			log.info("出账申请信息丢失");
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BLanErrorConstant.SCF_BAS_LAN_20002), BLanErrorConstant.SCF_BAS_LAN_20002);
		}
/*		BeanUtils.copyProperties(bCrrDuebillApp, vo);*/
		String mastContno = bCrrDuebillApp.getAppId();// 主合同号
		com.huateng.scf.bas.crr.dao.model.BCrrLnCon  bCrrLnCon = ibCrrLnConDAO.selectByPrimaryKey(mastContno);
		if (bCrrLnCon == null) {
			log.info("信贷合同为空");
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BLanErrorConstant.SCF_BAS_LAN_20018), BLanErrorConstant.SCF_BAS_LAN_20018);
		}
		String prdId = bCrrLnCon.getPrdId();
		BCrrPrdMd bCrrPrdMd = bcrrprdmddao.selectByPrimaryKey(prdId);
		vo.setVidNo(bCrrLnCon.getVidNo());// 协议号
		vo.setCreditProId(bCrrLnCon.getCreditProtNo());// 额度协议流水号
		vo.setAppStatus(bCrrLnCon.getAppStat());// 申请状态
		vo.setHtsxr(bCrrLnCon.getLnStrtDt());
		vo.setHtdqr(bCrrLnCon.getLnEndDt());
		vo.setTotAmt(bCrrLnCon.getLnAmt());

		com.huateng.scf.bas.lan.dao.model.BLanAppliLnciBase bLanAppliLnciBase = ibLanAppliLnciBaseDAO.selectByAppno(vo.getAppno());
		BigDecimal lnciAmt = bLanAppliLnciBase.getLnciAmt() == null ? BigDecimal.ZERO : bLanAppliLnciBase.getLnciAmt();
		// 融资信息=============================开始
		// 供应链补录承兑协议号/借据号
		if (ScfBasConstant.LOAN_WAY_BANK_ACCEPTENCE.equals(bCrrPrdMd.getLoanWay())) {// 银承
			//借据编号从正式表取
			String debetNo = bLanAppliLnciBase.getDebetNo();
			BLanLnciBase bLanLnciBase = ibLanLnciBaseDAO.selectByPrimaryKey(debetNo);
			if(bLanLnciBase!=null){
				vo.setDebetNo(bLanLnciBase.getDebetId());
			}
		} else {// 流贷
			vo.setDebetNo(bLanAppliLnciBase.getDebetId());
		}
		vo.setJjje(lnciAmt);
		vo.setQxrq(bLanAppliLnciBase.getStartDate());
		vo.setRzjg(bCrrDuebillApp.getActBrCd());// 财务机构==入账机构
		// 财务机构翻译
		RSysAcctBctl rSysAcctBctl = bSysAcctBctlDAO.selectByPrimaryKey(bCrrDuebillApp.getActBrCd());
		vo.setRzjgName(rSysAcctBctl.getBrname());
		vo.setDqrq(bLanAppliLnciBase.getEndDate());
		vo.setRzzh(bCrrDuebillApp.getLnNo());// 入账帐号
		vo.setHkfs(bCrrLnCon.getRtnTyp());// 还款方式
		vo.setKxq(bLanAppliLnciBase.getGraceDays() == null ? BigDecimal.ZERO : bLanAppliLnciBase.getGraceDays());
		vo.setCsbzjje(bLanAppliLnciBase.getBailAmount() == null ? BigDecimal.ZERO : bLanAppliLnciBase.getBailAmount());
		vo.setCsbzjbl(bLanAppliLnciBase.getFirstBailRatio() == null ? BigDecimal.ZERO : bLanAppliLnciBase.getFirstBailRatio());
		vo.setCsxjdjwbl(bLanAppliLnciBase.getInitCashEqtAmt() == null ? BigDecimal.ZERO : bLanAppliLnciBase.getInitCashEqtAmt());
		// 融资信息------------------------------结束
		// 利率信息=----------------------------=开始
		vo.setLllx(bLanAppliLnciBase.getRateType());
		vo.setLlfdfs(bLanAppliLnciBase.getRateFloatType());
		vo.setFdlltzfs(bLanAppliLnciBase.getRateAdjustType());
		vo.setLlfdz(bLanAppliLnciBase.getRateFloatValue() == null ? BigDecimal.ZERO : bLanAppliLnciBase.getRateFloatValue());
		vo.setZxll(bLanAppliLnciBase.getRate() == null ? BigDecimal.ZERO : bLanAppliLnciBase.getRate());
		vo.setLldm(bCrrLnCon.getIntCd());// 利率代码
		vo.setJzlv(bCrrLnCon.getBasInt());// 基准利率
		return vo;

    }

}
