/**
 * 
 */
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

import com.huateng.scf.bas.common.constant.ScfBasConstant;
import com.huateng.scf.bas.common.startup.ScfMessageUtil;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.crm.dao.IBCrmBaseInfoDAO;
import com.huateng.scf.bas.crm.dao.model.BCrmBaseInfo;
import com.huateng.scf.bas.crr.dao.IBCrrLnConDAO;
import com.huateng.scf.bas.crr.dao.model.BCrrLnCon;
import com.huateng.scf.bas.lan.constant.BLanErrorConstant;
import com.huateng.scf.bas.lan.dao.IBLanAppliBillInfoDAO;
import com.huateng.scf.bas.lan.dao.IBLanAppliLnciBaseDAO;
import com.huateng.scf.bas.lan.dao.model.BLanAppliLnciBase;
import com.huateng.scf.bas.lan.service.IBLanCommonService;
import com.huateng.scf.bas.lan.service.IBLanRepaySilverApplyService;
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
@Service("BLanRepaySilverApplyServiceImpl")
public class BLanRepaySilverApplyServiceImpl implements IBLanRepaySilverApplyService {

	private final Logger log = LoggerFactory.getLogger(getClass());

	//公共lan-service调用
	@Resource(name = "BLanCommonServiceImpl")	
	IBLanCommonService  ibLanCommonService;
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
	
	//放款申请
	@Override
	@Transactional
	public String repayapply(Map map) {
		String appno = (String)map.get("APP_NO");
		String prdid = (String)map.get("PRD_ID");//出账方式
		String custcd = (String)map.get("CUST_CD");//授信客户号
		String creditType = (String)map.get("INDRCT_CRDT");//间接额度类型
		String creditCustcd = (String)map.get("CRDT_CUST_CD");//间接额度占用客户号
		String loanWay = (String)map.get("LOAN_WAY");//出账方式
		String processId = (String)map.get("PROCESSID");
		String workApplyType = (String)map.get("MODELID");// 流程名称
		String businessnoType = (String)map.get("APPLITYPE");// 申请类型
		String mastContno="";
		BPbcAppliBaseInfo bPbcAppliBaseInfo = null;
		if(StringUtil.isEmpty(loanWay)){
			log.info("出账方式不能为空");
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BLanErrorConstant.SCF_BAS_LAN_20002),
				BLanErrorConstant.SCF_BAS_LAN_20002);
		}
		if(ScfBasConstant.LOAN_WAY_WORKING_CAPITAL.equals(loanWay)){
			log.info("出账方式不正确");
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BLanErrorConstant.SCF_BAS_LAN_20003),
				BLanErrorConstant.SCF_BAS_LAN_20003);
		}
		String ccmsAppno = (String)map.get("APP_NO");//出账流水号--信贷申请号
		if(StringUtil.isEmpty(ccmsAppno)){
			log.info("贷款出账流水号不能为空");
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BLanErrorConstant.SCF_BAS_LAN_20025),
				BLanErrorConstant.SCF_BAS_LAN_20025);
		}
		String contno = (String)map.get("APP_ID");//信贷合同号
		if(StringUtil.isEmpty(contno)){
			log.info("信贷合同编号不能为空！");
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BLanErrorConstant.SCF_BAS_LAN_20026),
				BLanErrorConstant.SCF_BAS_LAN_20026);
		}
		String protocolno = (String)map.get("VID_NO");
		if(StringUtil.isEmpty(protocolno)){
			log.info("协议号不能为空!");
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BLanErrorConstant.SCF_BAS_LAN_20028),
				BLanErrorConstant.SCF_BAS_LAN_20028);
		}
		List<BPbcAppliBaseInfo> bpbclist = ibPbcAppliBaseInfoDAO.getFkStatus(protocolno);
		if(bpbclist.size()>0){
			BPbcAppliBaseInfo bPbc = bpbclist.get(0);
			if(bPbc!=null){
				if(ScfBasConstant.APPLI_STATUS_DTL_CCMS_AGREE.equals(bPbc.getAppliStatus())){
					log.info("该借据已处于信贷放款通过状态，不能再次放款申请");
					throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BLanErrorConstant.SCF_BAS_LAN_20004),
						BLanErrorConstant.SCF_BAS_LAN_20004);
				}
			}
		}
		
		//信贷合同校验
		BCrrLnCon bCrrLnCon = ibCrrLnConDAO.selectByPrimaryKey(contno);
		if(bCrrLnCon == null){
			log.info("信贷合同不能为空");
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BLanErrorConstant.SCF_BAS_LAN_20018),
				BLanErrorConstant.SCF_BAS_LAN_20018);
		}
		//业务种类，产品种类获取--分的不详细跟出账方式代码是相同的
		String bussType = (String)map.get("VID_BUSI_TYP");//业务品种--业务小类
	/*	BPrdInfo bPrdInfo = ibPrdInfoDAO.selectByPrimaryKey(bussType);
		if(bPrdInfo == null){
			log.info("业务种类获取大类为空");
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BLanErrorConstant.SCF_BAS_LAN_20024),
				BLanErrorConstant.SCF_BAS_LAN_20024);
		}
		String bigProductId = bPrdInfo.getParentId();//产品种类--产品大类：预付类
		
		if(ScfBasConstant.LOAN_WAY_BANK_ACCEPTENCE.equals(loanWay)){//出账方式为银承
			if(ScfBasConstant.PRODUCT_TYPE_PREP.equals(bigProductId)){//预付类
				if(ScfBasConstant.PRODUCT_TYPE_SMALL_WH.equals(bussType)){//担保提货
					workApplyType = WorkflowConstant.PROCNAME_THREE_BILL_APPLY;
					businessnoType = WorkflowConstant.APPLI_TYPE_THREE_BILLPPLI;
				}
			}
		}*/
		//客户信息校验
		BCrmBaseInfo bCrmBaseInfo = ibCrmBaseInfoDAO.selectById(custcd);
		if(bCrmBaseInfo == null){
			log.info("客户信息不存在");
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BLanErrorConstant.SCF_BAS_LAN_20030),
				BLanErrorConstant.SCF_BAS_LAN_20030);
		}
		
		String originalAppliStatus = "";
		if(!StringUtil.isEmpty(ccmsAppno)){//申请主表--信贷申请号
			bPbcAppliBaseInfo = ibPbcAppliBaseInfoDAO.selectByPrimaryKey(ccmsAppno);
			if(bPbcAppliBaseInfo == null){
				bPbcAppliBaseInfo = new BPbcAppliBaseInfo();
			}else{
				originalAppliStatus = bPbcAppliBaseInfo.getAppliStatusDtl();
			}
		}
		//ProcessEntity processEntity = (ProcessEntity) map.get("processEntity");
		//if(processEntity != null){
		bPbcAppliBaseInfo.setPiid(processId);
		//}
		//间接额度--客户号验证
		if(ScfBasConstant.FLAG_ON.equals(creditType)){
			com.huateng.scf.bas.crm.dao.model.BCrmBaseInfo bCrmBaseInfo1 = ibCrmBaseInfoDAO.selectById(creditCustcd);
			if(bCrmBaseInfo1 == null){
				log.info("间接额度扣减客户信息不存在");
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BLanErrorConstant.SCF_BAS_LAN_20029),
					BLanErrorConstant.SCF_BAS_LAN_20029);
			}
		}
		//主合同出账方式校验
		if(bCrrLnCon!= null){
			if(!bCrrLnCon.getPrdId().equals(prdid)){
				log.info("与主合同出账方式不匹配");
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BLanErrorConstant.SCF_BAS_LAN_20001),
					BLanErrorConstant.SCF_BAS_LAN_20001);
			}
			mastContno=bCrrLnCon.getAppId();//合同流水号
			bPbcAppliBaseInfo.setMastContno(mastContno);
			bPbcAppliBaseInfo.setBusinessnoType(ScfBasConstant.BUSINESSNO_TYPE_CONTNO);
			bPbcAppliBaseInfo.setBusinessno(bCrrLnCon.getVidNo());
			bPbcAppliBaseInfo.setSlaveContno(bCrrLnCon.getVidNo());
		}
		//将客户号转换成供应链系统内部客户号
		map.put("CUST_CD", bCrmBaseInfo.getCustcd());
		bPbcAppliBaseInfo.setProcessTemplateName(workApplyType);//工作流模板名
		String amt = (String)map.get("LN_AMT");
		BigDecimal amtbig = new BigDecimal(amt);
		bPbcAppliBaseInfo.setAmt(amtbig);//出票总金额
		bPbcAppliBaseInfo.setAppliType(businessnoType);//业务申请类型
		bPbcAppliBaseInfo.setCustcd(bCrmBaseInfo.getCustcd());//客户号
		bPbcAppliBaseInfo.setMastContcode(contno);//信贷合同号
		bPbcAppliBaseInfo.setSupplyChainPdId(bussType);//产品类型
		bPbcAppliBaseInfo.setIncomeAppno(ccmsAppno);//信贷申请号
		bPbcAppliBaseInfo.setAppBrcode((String)map.get("APP_BR_CD"));//申请机构
		bPbcAppliBaseInfo.setAppliStatus(ScfBasConstant.APPLI_STATUS_SUBMITUNAPPROVE);//申请状态-未提交
		bPbcAppliBaseInfo.setAppliStatusDtl(ScfBasConstant.APPLI_STATUS_DTL_WAIT_SCF_WRITING);//供应链补录
		bPbcAppliBaseInfo.setChannelFlag(ScfBasConstant.CHANNEL_FLAG_SCF);//默认取到标识为供应链
		bPbcAppliBaseInfo.setIsFlowEnd(ScfBasConstant.FLAG_OFF);//默认流程未结束
		bPbcAppliBaseInfo.setCurcd(ScfBasConstant.RMB);//币种
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		java.util.Date date = new java.util.Date();
		String strdate = sdf.format(date);
		bPbcAppliBaseInfo.setAppDate(strdate);//申请日期
		if(!StringUtil.isEmpty(loanWay)){
			bPbcAppliBaseInfo.setExt1(loanWay);//出账方式
		}
		String debetno = "";
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
		//借据申请信息保存
		BLanAppliLnciBase bLanAppliLnciBase = ibLanAppliLnciBaseDAO.selectByAppno(appno);
		if(bLanAppliLnciBase != null){
			debetno = bLanAppliLnciBase.getDebetNo();
			try {
				bLanAppliLnciBase = this.setBLanAppliLnciBase(appno,map,mastContno,bCrmBaseInfo.getMgrno(),bLanAppliLnciBase);
				bLanAppliLnciBase.setSlaveContno(bPbcAppliBaseInfo.getSlaveContno());
				bLanAppliLnciBase.setDebetNo(debetno);
				ibLanAppliLnciBaseDAO.updateByPrimaryKey(bLanAppliLnciBase);
			} catch (Exception e) {
				log.info("借据申请信息更新异常");
				e.printStackTrace();
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BLanErrorConstant.SCF_BAS_LAN_10002),
					BLanErrorConstant.SCF_BAS_LAN_10002);
			}
		}else{//set申请借据信息方法
			com.huateng.scf.bas.lan.model.BLanAppliLnciBase appliLnciBase = new com.huateng.scf.bas.lan.model.BLanAppliLnciBase();
			try {
				bLanAppliLnciBase = this.setBLanAppliLnciBase(appno,map,mastContno,bCrmBaseInfo.getMgrno(),bLanAppliLnciBase);
				bLanAppliLnciBase.setSlaveContno(bPbcAppliBaseInfo.getSlaveContno());
				BeanUtils.copyProperties(bLanAppliLnciBase, appliLnciBase);
				//保存申请借据表
				debetno = ibLanCommonService.saveBLanAppliLnciBase(appno,appliLnciBase);
			} catch (Exception e) {
				log.info("借据申请信息保存异常");
				e.printStackTrace();
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BLanErrorConstant.SCF_BAS_LAN_10001),
					BLanErrorConstant.SCF_BAS_LAN_10001);
			}
		}
		//票据信息保存
		try {
			ibLanCommonService.saveBLanApplyBillInfo(appno,debetno,map);
		} catch (Exception e) {
			log.info("票据信息保存异常");
			e.printStackTrace();
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BLanErrorConstant.SCF_BAS_LAN_10010),
				BLanErrorConstant.SCF_BAS_LAN_10010);
		}
		//保证金set方法
		List list=this.setBMrnAppliAcctInfo(appno, map, debetno, mastContno);
		//添加保证金保存
		try {
			ibLanCommonService.saveBMrnAppliAcctInfo(appno,list);
		} catch (Exception e) {
			log.info("保证金保存异常");
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
		BCrrLnCon bCrrLnCon = ibCrrLnConDAO.selectByPrimaryKey(mastContno);
		bLanAppliLnciBase.setCurcd(ScfBasConstant.RMB);
		bLanAppliLnciBase.setStartDate((String)map.get("IS_DT"));//出票日期
		bLanAppliLnciBase.setEndDate((String)map.get("TE_DT"));//最迟到期日
		List list = (List) map.get("list");
		BigDecimal bigDecimal = new BigDecimal(list.size());
		bLanAppliLnciBase.setBillNum(list == null?BigDecimal.ZERO:bigDecimal);//出票张数
		//MAP 中并没有 传BAIL_RAT 这个字段，导致FirstBailRatio一直为空
		bLanAppliLnciBase.setFirstBailRatio((String)map.get("BAIL_RAT")==null?BigDecimal.ZERO:new BigDecimal((String)map.get("BAIL_RAT")));//最低保证金比例
		bLanAppliLnciBase.setBailAmount(new BigDecimal((String)map.get("BAIL_AMT")==null?"0":(String)map.get("BAIL_AMT")));//初始保证金总额
		bLanAppliLnciBase.setLnciType((String)map.get("LOAN_WAY"));//出账方式
		//bLanAppliLnciBase.setDebetId((String)map.get("VID_NO"));//承兑协议号
		bLanAppliLnciBase.setDebetId(appno);
		bLanAppliLnciBase.setOrgDebetId(null);//原来借据信息
		bLanAppliLnciBase.setEbFlag((String)map.get("ELEC_FLG"));//电票标识
		bLanAppliLnciBase.setCustcd((String)map.get("CUST_CD"));//客户号
		bLanAppliLnciBase.setMgrno(mgrno);//客户经理
		bLanAppliLnciBase.setHasIndirectCredit((String)map.get("INDRCT_CRDT"));
		bLanAppliLnciBase.setMastContcode((String)map.get("APP_ID"));//信贷合同号
		bLanAppliLnciBase.setPrePayBrcode(null);//垫购机构号
		bLanAppliLnciBase.setBussBrcode((String)map.get("APP_BR_CD"));//申请机构号
		bLanAppliLnciBase.setLnciAmt(map.get("LN_AMT")==null?BigDecimal.ZERO:new BigDecimal((String)map.get("LN_AMT")));//出票总金额
		bLanAppliLnciBase.setProductId((String)map.get("VID_BUSI_TYP"));//产品id
		bLanAppliLnciBase.setMastContno(mastContno);//主合同
		bLanAppliLnciBase.setAppno(appno);
		bLanAppliLnciBase.setDebetNo(null);
		bLanAppliLnciBase.setLnciBal(bLanAppliLnciBase.getLnciAmt());//贷款余额
		bLanAppliLnciBase.setLoanAppno((String)map.get("APP_NO"));//信贷出账流水号--信贷申请号
		bLanAppliLnciBase.setRateFloatType(bCrrLnCon.getIntFltTyp());//利率浮动方式
		bLanAppliLnciBase.setRateFloatValue(bCrrLnCon.getFltIntVal());//利率浮动值
		bLanAppliLnciBase.setBaseYearRate(bCrrLnCon.getBasInt());//基准年利率 //?
		bLanAppliLnciBase.setHasIndirectCredit(bCrrLnCon.getIndrctCrdt());//间接额度
		bLanAppliLnciBase.setCreditCustcd(bCrrLnCon.getCrdtCustCd());//间接额度占用客户号
		bLanAppliLnciBase.setProtocolNo((String)map.get("EXT_ID"));//协议号
		//TODO计算保证金总金额
	
		BMrnAppliAcctInfo bail = null;
		List<BMrnAppliAcctInfo> bailList = (List)map.get("bailist");
		BigDecimal totalBailAmount = new BigDecimal("0");

		if(null!=bailList && bailList.size()>0){
			for(int i=0;i<bailList.size();i++){
				bail=(BMrnAppliAcctInfo) bailList.get(i); //保证金金额 存在amount字段导致
				//totalBailAmount = totalBailAmount.add(bail.getBailAmount() == null ? BigDecimal.ZERO : bail.getBailAmount());// 计算总金额
				totalBailAmount = totalBailAmount.add(bail.getBailFrozenAmt() == null ? BigDecimal.ZERO : bail.getBailFrozenAmt());// 计算总金额 ：冻结保证金
			}
		}
		bLanAppliLnciBase.setBailAmount(totalBailAmount);//保证金总额
		//最低保证金比例(%)firstBailRatio		
		BigDecimal firstBailRatio = BigDecimal.ZERO;
		BigDecimal lnAmt = map.get("LN_AMT")==null?BigDecimal.ZERO:new BigDecimal((String)map.get("LN_AMT"));//出票总金额
		firstBailRatio = totalBailAmount.multiply(new BigDecimal(100)).divide(lnAmt, 2, BigDecimal.ROUND_DOWN);;
		bLanAppliLnciBase.setFirstBailRatio(firstBailRatio);
		if ("1".equals(map.get("INDRCT_CRDT"))){//1-是
			bLanAppliLnciBase.setHasIndirectCredit(ScfBasConstant.FLAG_ON);
		}else if ("2".equals(map.get("INDRCT_CRDT"))){ //2-否
			bLanAppliLnciBase.setHasIndirectCredit(ScfBasConstant.FLAG_OFF);
		}
		return bLanAppliLnciBase;
	}
	/**
	 * @author liph
	 * @descript 保证金数值set
	 * @param list
	 */
	@SuppressWarnings("unchecked")
	public List setBMrnAppliAcctInfo(String appno,Map map,String debtno,String mastContno){
		List list = new ArrayList();
		BMrnAppliAcctInfo bMrnAppliAcctInfo = null;
		BMrnAppliAcctInfo bail = null;
		List<BMrnAppliAcctInfo> bailList = (List<BMrnAppliAcctInfo>) map.get("bailist"); 
		for(int i=0;i<bailList.size();i++){
			bMrnAppliAcctInfo = new BMrnAppliAcctInfo();
			bail=(BMrnAppliAcctInfo) bailList.get(i);
			bMrnAppliAcctInfo.setBailAccountno(bail.getBailAccountno());//保证金账号
			bMrnAppliAcctInfo.setBailAccountno(bail.getAccountNo());
			//bMrnAppliAcctInfo.setBailAmount(bail.getBailAmount());//保证金金额
			bMrnAppliAcctInfo.setBailAmount(bail.getAmount());//保证金金额 存在amount
			bMrnAppliAcctInfo.setBailFrozenAmt(bail.getBailFrozenAmt());//冻结金额
			bMrnAppliAcctInfo.setAccountName(bail.getAccountName());
			bMrnAppliAcctInfo.setBrCd(bail.getBrCd());//经办机构
			bMrnAppliAcctInfo.setAppno(appno);
			bMrnAppliAcctInfo.setDebetNo(debtno);//借据表主键
			bMrnAppliAcctInfo.setMastContno(mastContno);//主合同
			bMrnAppliAcctInfo.setCustcd((String)map.get("CUST_CD"));
			bMrnAppliAcctInfo.setCurcd(ScfBasConstant.RMB);
			list.add(bMrnAppliAcctInfo);
		}
		return list;
	}
}
