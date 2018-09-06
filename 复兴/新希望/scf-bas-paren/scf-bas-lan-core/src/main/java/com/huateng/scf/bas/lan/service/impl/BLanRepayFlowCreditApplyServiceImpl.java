package com.huateng.scf.bas.lan.service.impl;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huateng.scf.bas.brp.dao.IBBrpPrdFactoringDAO;
import com.huateng.scf.bas.common.constant.ScfBasConstant;
import com.huateng.scf.bas.common.startup.ScfMessageUtil;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.crm.dao.IBCrmBaseInfoDAO;
import com.huateng.scf.bas.crm.dao.model.BCrmBaseInfo;
import com.huateng.scf.bas.crr.dao.IBCrrLnConDAO;
import com.huateng.scf.bas.crr.dao.model.BCrrLnCon;
import com.huateng.scf.bas.lan.constant.BLanErrorConstant;
import com.huateng.scf.bas.lan.dao.IBLanAppliLnciBaseDAO;
import com.huateng.scf.bas.lan.dao.model.BLanAppliLnciBase;
import com.huateng.scf.bas.lan.service.IBLanCommonService;
import com.huateng.scf.bas.lan.service.IBLanRepayFlowCreditApplyService;
import com.huateng.scf.bas.mrn.constant.BMrnErrorConstant;
import com.huateng.scf.bas.mrn.dao.IBMrnAppliAcctInfoDAO;
import com.huateng.scf.bas.mrn.dao.model.BMrnAppliAcctInfo;
import com.huateng.scf.bas.pbc.constant.BPbcErrorConstant;
import com.huateng.scf.bas.pbc.dao.IBPbcAppliBaseInfoDAO;
import com.huateng.scf.bas.pbc.dao.model.BPbcAppliBaseInfo;
import com.huateng.scf.bas.prd.dao.IBPrdInfoDAO;
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
@Service("BLanRepayFlowCreditApplyServiceImpl")
public class BLanRepayFlowCreditApplyServiceImpl implements IBLanRepayFlowCreditApplyService{
	private final Logger log = LoggerFactory.getLogger(getClass());
	@Resource(name = "BLanCommonServiceImpl")	
	IBLanCommonService  ibLanCommonService;
	@Resource(name = "BPrdInfoDAO")
	IBPrdInfoDAO ibPrdInfoDAO;
	@Resource(name = "BPbcAppliBaseInfoDAO")
	IBPbcAppliBaseInfoDAO ibPbcAppliBaseInfoDAO;
	@Resource(name = "IBCrrLnConDAO")
	IBCrrLnConDAO ibCrrLnConDAO;
	@Resource(name = "IBCrmBaseInfoDAO")
	IBCrmBaseInfoDAO ibCrmBaseInfoDAO;
	@Resource(name = "BLanAppliLnciBaseDAO")
	IBLanAppliLnciBaseDAO ibLanAppliLnciBaseDAO;
	@Resource(name = "IBMrnAppliAcctInfoDAO")
	IBMrnAppliAcctInfoDAO ibMrnAppliAcctInfoDAO;
	@Resource(name = "BBrpPrdFactoringDAO")
	IBBrpPrdFactoringDAO ibBrpPrdFactoringDAO;
	
	@Override
	@Transactional
	public String repayapply(Map map) {
		BPbcAppliBaseInfo bPbcAppliBaseInfo = null;
		String loanWay = (String) map.get("LOAN_WAY");//出账方式
		String prdid = (String) map.get("PRD_ID");
		String processId = (String)map.get("PROCESSID");
		String workApplyType = (String)map.get("MODELID");// 流程名称
		String businessnoType = (String)map.get("APPLITYPE");// 申请类型
		if(!ScfBasConstant.LOAN_WAY_WORKING_CAPITAL.equals(loanWay)){
			log.info("出账方式不为流贷");
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BLanErrorConstant.SCF_BAS_LAN_20003),
					BLanErrorConstant.SCF_BAS_LAN_20003);
		}
		String bussType = (String) map.get("VID_BUSI_TYP");
		/*BPrdInfo bPrdInfo = ibPrdInfoDAO.selectByPrimaryKey(bussType);
		if(bPrdInfo == null){
			log.info("业务种类获取大类为空");
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BLanErrorConstant.SCF_BAS_LAN_20024),
					BLanErrorConstant.SCF_BAS_LAN_20024);
		}
		String bigProductId = bPrdInfo.getParentId();//产品种类--产品大类：应收类
*/		String appno = (String)map.get("APP_NO");//台帐信息生成的id--关联所有流程
		if(StringUtil.isEmpty(appno)){
			log.info("出账流水号为空");
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BLanErrorConstant.SCF_BAS_LAN_20025),
					BLanErrorConstant.SCF_BAS_LAN_20025);
		}
		String contno = (String)map.get("APP_ID");
		if(StringUtil.isEmpty(contno)){
			log.info("信贷合同编号为空");
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BLanErrorConstant.SCF_BAS_LAN_20026),
					BLanErrorConstant.SCF_BAS_LAN_20026);
		}
//		String protocolno = (String)map.get("VID_NO");
//		if(StringUtil.isEmpty(protocolno)){
//			log.info("协议号不能为空!");
//			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BLanErrorConstant.SCF_BAS_LAN_20028),
//				BLanErrorConstant.SCF_BAS_LAN_20028);
//		}
//		List<BPbcAppliBaseInfo> bPbclist = ibPbcAppliBaseInfoDAO.getFkStatus(protocolno);
//		if(bPbclist.size()>0){
//			BPbcAppliBaseInfo bPbc = bPbclist.get(0);
//			if(bPbc != null){
//				if(ScfBasConstant.APPLI_STATUS_DTL_CCMS_AGREE.equals(bPbc.getAppliStatus())){
//					log.info("该借据已处于信贷放款通过状态，不能再次放款申请");
//					throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BLanErrorConstant.SCF_BAS_LAN_20004),
//						BLanErrorConstant.SCF_BAS_LAN_20004);
//				}
//			}
//		}
		
		//信贷合同校验
		BCrrLnCon cont = ibCrrLnConDAO.selectByPrimaryKey(contno);
		if(cont == null){
			log.info("信贷合同不能为空");
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BLanErrorConstant.SCF_BAS_LAN_20018),
				BLanErrorConstant.SCF_BAS_LAN_20018);
		}
		/*String workApplyType = "";// 流程名称
		String businessnoType = "";// 申请类型
		if(ScfBasConstant.LOAN_WAY_WORKING_CAPITAL.equals(loanWay)){//流贷
			if(ScfBasConstant.PRODUCT_TYPE_ACCR.equals(bigProductId)){//应收账款
				BBrpPrdFactoring bBrpPrdFactoring = ibBrpPrdFactoringDAO.selectByPrimaryKey(bussType);
				String factType = bBrpPrdFactoring.getFactType();
				if(ScfBasConstant.FACT_TYPE_INLAND.equals(factType)||ScfBasConstant.FACT_TYPE_REVERSE.equals(factType)
						||ScfBasConstant.FACT_TYPE_DEBT_PLEDGE.equals(factType)){
					workApplyType = WorkflowConstant.PROCNAME_INCOICE_FINANCING_APPLY;
					businessnoType = WorkflowConstant.APPLI_TYPE_INCOICEFINANCINGAPPLY;
				}else if(ScfBasConstant.FACT_TYPE_DEBT_POOL_PLEDGE.equals(factType) || ScfBasConstant.FACT_TYPE_DEBT_POOL.equals(factType)
					|| ScfBasConstant.FACT_TYPE_EXPORT_POOL_PLEDGE.equals(factType)){//应收账款池融资
					workApplyType = WorkflowConstant.PROCNAME_FINANCING_POOL_APPLY;
					businessnoType = WorkflowConstant.APPLI_TYPE_FINANCINGPOOLBILLAPPLY;
				}
			}else if(ScfBasConstant.PRODUCT_TYPE_MORT.equals(bigProductId)){//现货质押
				workApplyType = WorkflowConstant.PROCNAME_MORTGAGECASHLOANAPPLY;
				businessnoType = WorkflowConstant.APPLI_TYPE_MORTGAGE_CASH_LOAN_APPLY;
			}
		}*/
		
		String originalAppliStatus = "";
		if(!StringUtil.isEmpty(appno)){//申请主表--信贷申请号
			bPbcAppliBaseInfo = ibPbcAppliBaseInfoDAO.selectByPrimaryKey(appno);
			if(bPbcAppliBaseInfo == null){
				bPbcAppliBaseInfo = new BPbcAppliBaseInfo();
			}else{
				originalAppliStatus = bPbcAppliBaseInfo.getAppliStatusDtl();
			}
		}
		//客户信息校验
		String custcd = (String)map.get("CUST_CD");//授信客户号
		BCrmBaseInfo bCrmBaseInfo = ibCrmBaseInfoDAO.selectById(custcd);
		if(bCrmBaseInfo == null){
			log.info("客户信息不存在");
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BLanErrorConstant.SCF_BAS_LAN_20002),
				BLanErrorConstant.SCF_BAS_LAN_20002);
		}
		//间接额度--客户号验证
		String creditType = (String)map.get("INDRCT_CRDT");//间接额度类型
		String creditCustcd = (String)map.get("CRDT_CUST_CD");//间接额度占用客户号
		if(ScfBasConstant.FLAG_ON.equals(creditType)){
			com.huateng.scf.bas.crm.dao.model.BCrmBaseInfo bCrmBaseInfo1 = ibCrmBaseInfoDAO.selectById(creditCustcd);
			if(bCrmBaseInfo1 == null){
				log.info("间接额度扣减客户信息不存在");
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BLanErrorConstant.SCF_BAS_LAN_20029),
					BLanErrorConstant.SCF_BAS_LAN_20029);
			}
		}
		String mastContno="";
		if(cont != null){
			if(!cont.getPrdId().equals(prdid)){
				log.info("与主合同出账方式不匹配");
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BLanErrorConstant.SCF_BAS_LAN_20001),
						BLanErrorConstant.SCF_BAS_LAN_20001);
			}
			mastContno = cont.getAppId();
			bPbcAppliBaseInfo.setMastContno(mastContno);
			bPbcAppliBaseInfo.setBusinessnoType(ScfBasConstant.BUSINESSNO_TYPE_CONTNO);
			bPbcAppliBaseInfo.setBusinessno(cont.getVidNo());
			bPbcAppliBaseInfo.setSlaveContno(cont.getVidNo());
		}
		
		//将客户号转换成供应链系统内部客户号
		map.put("CUST_CD", bCrmBaseInfo.getCustcd());
		bPbcAppliBaseInfo.setPiid(processId);
		bPbcAppliBaseInfo.setProcessTemplateName(workApplyType);//工作流模版名
		String amt = (String)map.get("LN_AMT");
		BigDecimal amtbig = new BigDecimal(amt);
		bPbcAppliBaseInfo.setAmt(amtbig);//出账金额
		bPbcAppliBaseInfo.setAppliType(businessnoType);//业务申请类型
		bPbcAppliBaseInfo.setCustcd(bCrmBaseInfo.getCustcd());//客户号
		bPbcAppliBaseInfo.setMastContcode(contno);//信贷合同号
		bPbcAppliBaseInfo.setSupplyChainPdId(bussType);//产品类型
		bPbcAppliBaseInfo.setIncomeAppno(appno);//信贷申请号
		bPbcAppliBaseInfo.setAppBrcode((String)map.get("APP_BR_CD"));//申请机构
		bPbcAppliBaseInfo.setAppliStatus(ScfBasConstant.APPLI_STATUS_SUBMITUNAPPROVE);//申请状态-未提交
		bPbcAppliBaseInfo.setAppliStatusDtl(ScfBasConstant.APPLI_STATUS_DTL_WAIT_SCF_WRITING);//供应链补录
		bPbcAppliBaseInfo.setChannelFlag(ScfBasConstant.CHANNEL_FLAG_SCF);//默认取到标识为供应链
		bPbcAppliBaseInfo.setIsFlowEnd(ScfBasConstant.FLAG_OFF);//默认流程未结束
		bPbcAppliBaseInfo.setCurcd(ScfBasConstant.RMB);//币种
		//bPbcAppliBaseInfo.setProtocolNo(protocolno);//协议号
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		java.util.Date date = new java.util.Date();
		String strdate = sdf.format(date);
		bPbcAppliBaseInfo.setAppDate(strdate);//申请日期
		if(!StringUtil.isEmpty(loanWay)){
			bPbcAppliBaseInfo.setExt1(loanWay);//出账方式
		}
		com.huateng.scf.bas.pbc.model.BPbcAppliBaseInfo appliBaseInfo = new com.huateng.scf.bas.pbc.model.BPbcAppliBaseInfo();
		BeanUtils.copyProperties(bPbcAppliBaseInfo, appliBaseInfo);
		//申请表信息保存
		try {
			ibLanCommonService.saveBPbcAppliBaseInfo(appliBaseInfo,originalAppliStatus,appno);
		} catch (Exception e) {
			log.info("申请表信息保存异常");
			e.printStackTrace();
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BPbcErrorConstant.SCF_BAS_PBC_10001),
				BPbcErrorConstant.SCF_BAS_PBC_10001);
		}
		String debetNo = "";
		//借据申请信息保存
		BLanAppliLnciBase bLanAppliLnciBase = ibLanAppliLnciBaseDAO.selectByAppno(appno);
		if(bLanAppliLnciBase != null){//判断是否保存过
			debetNo = bLanAppliLnciBase.getDebetNo();
			bLanAppliLnciBase = this.setBLanAppliLnciBase(appno,map,mastContno,bCrmBaseInfo.getMgrno(),bLanAppliLnciBase);
			bLanAppliLnciBase.setSlaveContno(bPbcAppliBaseInfo.getSlaveContno());
			bLanAppliLnciBase.setDebetNo(debetNo);
			bLanAppliLnciBase.setStartDate((String)map.get("IS_DT"));
			bLanAppliLnciBase.setEndDate((String)map.get("TE_DT"));
			try {
				ibLanAppliLnciBaseDAO.updateByPrimaryKey(bLanAppliLnciBase);
			} catch (Exception e) {
				log.info("借据申请表更新异常");
				e.printStackTrace();
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BLanErrorConstant.SCF_BAS_LAN_10002),
						BLanErrorConstant.SCF_BAS_LAN_10002);
			}
		}else{
			com.huateng.scf.bas.lan.model.BLanAppliLnciBase appliLnciBase = new com.huateng.scf.bas.lan.model.BLanAppliLnciBase();
			bLanAppliLnciBase = this.setBLanAppliLnciBaseInfo(appno,map,mastContno,bCrmBaseInfo.getMgrno()); 
			bLanAppliLnciBase.setSlaveContno(bPbcAppliBaseInfo.getSlaveContno());
			BeanUtils.copyProperties(bLanAppliLnciBase, appliLnciBase);
			try {
				debetNo = ibLanCommonService.saveBLanAppliLnciBase(appno,appliLnciBase);
			} catch (Exception e) {
				log.info("借据申请表插入异常");
				e.printStackTrace();
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BLanErrorConstant.SCF_BAS_LAN_10001),
						BLanErrorConstant.SCF_BAS_LAN_10001);
			}
		}
		//set保证金信息方法liph
		List list = this.setMrnAcctInfo(appno,map,debetNo,mastContno);
		//保证金信息保存
		try {
			ibLanCommonService.saveBMrnAppliAcctInfo(appno,list);
		} catch (Exception e) {
			log.info("保证金插入异常");
			e.printStackTrace();
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BMrnErrorConstant.SCF_BAS_MRN_10001),
					BMrnErrorConstant.SCF_BAS_MRN_10001);
		}
		return null;
	}
	
	/**
	 * @Description: 将字段值Set到TblAppliLnciBaseInfo中
	 * @author liph
	 */
	@SuppressWarnings("unchecked")
	public BLanAppliLnciBase setBLanAppliLnciBase(String appno,Map map,String mastContno,String mgrno,BLanAppliLnciBase bLanAppliLnciBase){
		if(bLanAppliLnciBase == null){
			bLanAppliLnciBase = new BLanAppliLnciBase();
		}
		bLanAppliLnciBase.getAccountNo();
		bLanAppliLnciBase.setCurcd(ScfBasConstant.RMB);
		bLanAppliLnciBase.setStartDate((String)map.get("IS_DT"));//起息日
		bLanAppliLnciBase.setEndDate((String)map.get("TE_DT"));//到期日
		BigDecimal bailRat = new BigDecimal((String)map.get("BAIL_RAT"));
		bLanAppliLnciBase.setFirstBailRatio(bailRat);//最低保证金比例
		bLanAppliLnciBase.setBailAmount(new BigDecimal((String)map.get("BAIL_AMT")));//初始保证金总额
		bLanAppliLnciBase.setLoanUse(null);//贷款用途
		bLanAppliLnciBase.setMgrno(mgrno);//客户经理
		bLanAppliLnciBase.setLnciType((String)map.get("PRD_ID"));//出账方式
		bLanAppliLnciBase.setDebetId((String)map.get("VID_NO"));//承兑协议号
		bLanAppliLnciBase.setOrgDebetId(null);//原来借据信息
		bLanAppliLnciBase.setCustcd((String)map.get("CUST_CD"));//客户号
		bLanAppliLnciBase.setProductId((String)map.get("VID_BUSI_TYP"));//产品id
		bLanAppliLnciBase.setMastContcode((String)map.get("APP_ID"));//信贷合同号
		bLanAppliLnciBase.setRate((BigDecimal)map.get("ACT_INT"));//执行利率
		bLanAppliLnciBase.setMastContno(mastContno);//主合同号
		bLanAppliLnciBase.setBussBrcode((String)map.get("APP_BR_CD"));//申请机构号
		bLanAppliLnciBase.setAppno(appno);
		bLanAppliLnciBase.setLnciBal(bLanAppliLnciBase.getLnciAmt());//贷款余额
		bLanAppliLnciBase.setDebetNo(null);
		bLanAppliLnciBase.setLoanAppno(appno);//信贷出账流水号
		//计算宽限期
		//String startDate = bLanAppliLnciBase.getStartDate();
		//String endDate = bLanAppliLnciBase.getEndDate();
		//int graceDays = ScfDateUtil.diffdates(ScfDateUtil.numberToDate(startDate), ScfDateUtil.numberToDate(endDate));// 账期的计算
		//bLanAppliLnciBase.setGraceDays(new BigDecimal(graceDays));
		//计算保证金总金额
		BMrnAppliAcctInfo bail = null;
		List<BMrnAppliAcctInfo> bailList = (List)map.get("bailist");
		BigDecimal totalBailAmount = new BigDecimal("0");
		if(null!=bailList && bailList.size()>0){
			for(int i=0;i<bailList.size();i++){
				bail=(BMrnAppliAcctInfo) bailList.get(i);
				totalBailAmount = totalBailAmount.add(bail.getBailFrozenAmt() == null ? BigDecimal.ZERO : bail.getBailFrozenAmt());// 计算总金额： 冻结保证金
			}
		}
		bLanAppliLnciBase.setBailAmount(totalBailAmount);//保证金总额
		if ("1".equals(map.get("INDRCT_CRDT"))){//1-是
			bLanAppliLnciBase.setHasIndirectCredit(ScfBasConstant.FLAG_ON);
		}else if ("2".equals(map.get("INDRCT_CRDT"))){ //2-否
			bLanAppliLnciBase.setHasIndirectCredit(ScfBasConstant.FLAG_OFF);
		}
		return bLanAppliLnciBase;
	}
	
	/**
	 * @Description: 将字段值Set到TblAppliLnciBaseInfo中
	 * @author liph
	 */
	@SuppressWarnings("unchecked")
	public BLanAppliLnciBase setBLanAppliLnciBaseInfo(String appno,Map map,String mastContno,String mgrno){
		BLanAppliLnciBase appliLnci = new BLanAppliLnciBase();
		BCrrLnCon bCrrLnCon = ibCrrLnConDAO.selectByPrimaryKey(mastContno);
		appliLnci.setCurcd(ScfBasConstant.RMB);
		appliLnci.setStartDate((String)map.get("IS_DT"));//起息日
		appliLnci.setEndDate((String)map.get("TE_DT"));//到期日
		BigDecimal bailRat = new BigDecimal((String)map.get("BAIL_RAT")==null?"0":(String)map.get("BAIL_RAT"));
		appliLnci.setFirstBailRatio(bailRat);//最低保证金比例(%)
		appliLnci.setBailAmount(new BigDecimal((String)map.get("BAIL_AMT")==null?"0":(String)map.get("BAIL_AMT")));//初始保证金总额
		appliLnci.setLoanUse(null);//贷款用途
		appliLnci.setMgrno(mgrno);//客户经理
		appliLnci.setLnciAmt(map.get("LN_AMT")==null?BigDecimal.ZERO:new BigDecimal((String)map.get("LN_AMT")));
		appliLnci.setHasIndirectCredit((String)map.get("INDRCT_CRDT"));//间接额度类型
		appliLnci.setLnciType((String)map.get("LOAN_WAY"));//出账方式--供应链的出账方式
		appliLnci.setDebetId((String)map.get("EXT_ID"));//借据号/承兑协议号
		appliLnci.setOrgDebetId(null);//原借据号
		appliLnci.setCustcd((String)map.get("CUST_CD"));//客户名称
		appliLnci.setProductId((String)map.get("VID_BUSI_TYP"));//产品ID
		appliLnci.setMastContcode((String)map.get("APP_ID"));// 信贷合同号
		BigDecimal rate = (BigDecimal) map.get("ACT_INT");
		appliLnci.setRate(bCrrLnCon.getActInt());//执行利率
		appliLnci.setMastContno(mastContno);//主合同号
		appliLnci.setBussBrcode((String)map.get("APP_BR_CD"));//申请机构号
		appliLnci.setAppno(appno);
		appliLnci.setLnciBal(appliLnci.getLnciAmt());  //贷款余额
		appliLnci.setDebetNo(null);
		appliLnci.setLoanAppno(appno);//信贷出账流水号
		appliLnci.setRateFloatType(bCrrLnCon.getIntFltTyp());//利率浮动方式
		appliLnci.setRateAdjustType(bCrrLnCon.getIntAdj());
		appliLnci.setRateFloatValue(bCrrLnCon.getFltIntVal());//利率浮动值
		appliLnci.setBaseYearRate(bCrrLnCon.getBasInt());//基准年利率
		appliLnci.setHasIndirectCredit(bCrrLnCon.getIndrctCrdt());//间接额度
		appliLnci.setCreditCustcd(bCrrLnCon.getCrdtCustCd());//间接额度占用客户号
		
		//计算保证金总金额
		BMrnAppliAcctInfo bail = null;
		List<BMrnAppliAcctInfo> bailList = (List)map.get("bailist");
		BigDecimal totalBailAmount = new BigDecimal("0");
		if(null!=bailList && bailList.size()>0){
			for(int i=0;i<bailList.size();i++){
				bail=(BMrnAppliAcctInfo) bailList.get(i);
				totalBailAmount = totalBailAmount.add(bail.getBailFrozenAmt() == null ? BigDecimal.ZERO : bail.getBailFrozenAmt());// 计算总金额
			}
		}
		if(totalBailAmount.compareTo(BigDecimal.ZERO)>0){
			appliLnci.setBailAmount(totalBailAmount);//保证金总额
		}
		if ("1".equals(map.get("INDRCT_CRDT"))){//1-是
			appliLnci.setHasIndirectCredit(ScfBasConstant.FLAG_ON);
		}else if ("2".equals(map.get("INDRCT_CRDT"))){ //2-否
			appliLnci.setHasIndirectCredit(ScfBasConstant.FLAG_OFF);
		}
		return appliLnci;
	}
	
	/**
	 * @Description: 将字段值Set到保证金TblAppliCustAccountInfo中
	 * @author liph
	 */
	public List setMrnAcctInfo(String appno,Map map,String debetNo,String mastContno){
		List list = new ArrayList();
		BMrnAppliAcctInfo bailInfo = null;
		BMrnAppliAcctInfo bail = null;
		List<BMrnAppliAcctInfo> bailList = (List<BMrnAppliAcctInfo>) map.get("bailist"); 
		for(int i = 0;i<bailList.size();i++){
			bailInfo = new BMrnAppliAcctInfo();
			bail=(BMrnAppliAcctInfo) bailList.get(i);
			bailInfo.setBailAccountno(bail.getBailAccountno());//保证金账号
			bailInfo.setBailAmount(bail.getBailAmount());//保证金金额
			bailInfo.setBailFrozenAmt(bail.getBailFrozenAmt());//冻结金额
			bailInfo.setAccountName(bail.getAccountName());
			bailInfo.setBrCd(bail.getBrCd());//经办机构
			bailInfo.setAppno(appno);
			bailInfo.setDebetNo(debetNo);//借据表主键
			bailInfo.setMastContno(mastContno);//主合同
			bailInfo.setCustcd((String)map.get("CUST_CD"));
			bailInfo.setCurcd(ScfBasConstant.RMB);
			list.add(bailInfo);
		}
		return list;
	}
}
