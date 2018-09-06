package com.huateng.scf.bas.mrn.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.huateng.authority.common.ContextHolder;
import com.huateng.authority.entity.BctlVO;
import com.huateng.authority.entity.UserInfo;
import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.cnt.model.BCntMprotPartInfo;
import com.huateng.scf.bas.cnt.service.IBCntMprotPartInfoService;
import com.huateng.scf.bas.common.constant.NoticeConstant;
import com.huateng.scf.bas.common.constant.ScfBasConstant;
import com.huateng.scf.bas.common.model.AmountVO;
import com.huateng.scf.bas.common.model.CommonApplyDtlInfoVO;
import com.huateng.scf.bas.common.util.ScfDateUtil;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.crr.dao.model.BCrrLnCon;
import com.huateng.scf.bas.crr.model.BCrrGntyCon;
import com.huateng.scf.bas.crr.service.IBCrrGntyConService;
import com.huateng.scf.bas.crr.service.IBCrrLnConService;
import com.huateng.scf.bas.icr.service.IBIcrInfoService;
import com.huateng.scf.bas.lan.model.BLanLnciBase;
import com.huateng.scf.bas.lan.service.IBLanLnciBaseService;
import com.huateng.scf.bas.mrn.model.BMrnAcctBussInfo;
import com.huateng.scf.bas.mrn.model.BMrnAppliAcctInfo;
import com.huateng.scf.bas.mrn.model.BMrnBussInfo;
import com.huateng.scf.bas.mrn.service.IBMrnAcctBussInfoService;
import com.huateng.scf.bas.mrn.service.IBMrnAppliAcctInfoService;
import com.huateng.scf.bas.mrn.service.IBMrnBussInfoService;
import com.huateng.scf.bas.mrn.service.ICompositeMngService;
import com.huateng.scf.bas.mrn.service.IContractService;
import com.huateng.scf.bas.mrn.vo.BailBussInfoVO;
import com.huateng.scf.bas.mrn.vo.BailLnciQryVO;
import com.huateng.scf.bas.mrn.vo.CashEqualVO;
import com.huateng.scf.bas.mrn.vo.CashEqualValueContractVO;
import com.huateng.scf.bas.mrn.vo.OldApplyVO;
import com.huateng.scf.bas.mrn.vo.OldCommonQueryVO;
import com.huateng.scf.bas.mrn.vo.OldContractVO;
import com.huateng.scf.bas.nte.model.BNteNoticeBase;
import com.huateng.scf.bas.nte.model.BNteNoticeBill;
import com.huateng.scf.bas.nte.service.IBNteNoticeBaseService;
import com.huateng.scf.bas.nte.service.IBNteNoticeBillService;
import com.huateng.scf.bas.pbc.model.BPbcAppliBaseInfo;
import com.huateng.scf.bas.pbc.service.IAmountService;
import com.huateng.scf.bas.pbc.service.IBPbcAppliBaseInfoService;
import com.huateng.scf.bas.sys.constant.WorkflowConstant;
import com.huateng.scf.rec.bcp.constant.RBcpErrorConstant;
import com.huateng.scf.rec.bcp.model.DebtLnciBaseInfoVO;
import com.huateng.scf.rec.bcp.model.RBcpAppliBussDtl;
import com.huateng.scf.rec.bcp.model.RBcpAppliBussInfo;
import com.huateng.scf.rec.bcp.service.IRBcpAppliBussDtlService;
import com.huateng.scf.rec.bcp.service.IRBcpAppliBussInfoService;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * 
 * <p>公共</p>
 *
 * @author 	mengjiajia
 * @date 	2017年2月13日下午5:00:13
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2017年2月13日下午5:00:13	     新增
 *
 * </pre>
 */
@SuppressWarnings("deprecation")
@ScubeService
@Service("CompositeMngServiceImpl")
public class CompositeMngServiceImpl implements ICompositeMngService{
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@Resource(name = "BMrnAcctBussInfoServiceImpl")
	IBMrnAcctBussInfoService bmrnacctbussinfoservice;
	
	@Resource(name = "BPbcAppliBaseInfoServiceImpl")
	IBPbcAppliBaseInfoService bpbcapplibaseinfoservice;
	
	@Resource(name = "RBcpAppliBussDtlServiceImpl")
	IRBcpAppliBussDtlService rbcpapplibussdtlservice;
	
	@Resource(name = "RBcpAppliBussInfoServiceImpl")
	IRBcpAppliBussInfoService rbcpapplibussinfoservice;
	
	@Resource(name = "BMrnAppliAcctInfoServiceImpl")
	IBMrnAppliAcctInfoService bmrnappliacctinfoservice;
	/**
	 * 借据信息
	 */
	@Resource(name="BLanLnciBaseServiceImpl")
	IBLanLnciBaseService blanlncibaseservice;
	
	@Resource(name = "BIcrInfoServiceImpl")
	IBIcrInfoService bicrinfoservice;
	
	@Resource(name = "BCrrLnConServiceImpl")
	IBCrrLnConService bcrrlnconservice;
	
	@Resource(name = "ContractServiceImpl")
	IContractService contractservice;
	
	@Resource(name = "BNteNoticeBaseServiceImpl")
	IBNteNoticeBaseService bntenoticebaseservice;
	
	@Resource(name = "BNteNoticeBillServiceImpl")
	IBNteNoticeBillService bntenoticebillservice;
	
	@Resource(name = "AmountServiceImpl")
	IAmountService amountService;
	
	@Resource(name = "BCrrGntyConServiceImpl")
	IBCrrGntyConService bcrrgntyconservice;
	
	@Resource(name = "BCntMprotPartInfoServiceImpl")
	IBCntMprotPartInfoService bcntmprotpartinfoservice;
	
	@Resource(name = "BMrnBussInfoServiceImpl")
	IBMrnBussInfoService bmrnbussinfoservice;
	/**
	 *
	 * @Description: 查询保证金及现金等价物信息
	 * @author mengjiajia
	 * @Created 2012-11-8下午05:45:51
	 * @param commonQueryVO
	 * @return
	 * @throws ScubeBizException
	 */
	// 大VO改造 comment by xiaolong.xiong 2013-07-13
	@Override
	public Page getTblCustAccountBussInfoByParam(BailLnciQryVO commonQueryVO) throws ScubeBizException {
		log.debug("mastContno:"+commonQueryVO.getMastContno());
		Page pageQueryResult = new Page();
		pageQueryResult = bmrnacctbussinfoservice.getTblCustAccountBussInfoByParam(commonQueryVO);
		return pageQueryResult;
	}

	/**
	 *
	 * @Description: 保证金转出申请流程：保存流程发起申请基本信息
	 * @author mengjiajia
	 * @Created 2012-11-9下午04:59:24
	 * @param contractVO
	 * @param businessnoType
	 * @param workApplyType
	 * @return
	 * @throws ScubeBizException
	 */
	@Override
	public String saveApplyBaseInfo(OldContractVO contractVO,String businessnoType,String workApplyType) throws ScubeBizException{
		//保证金转出申请发起-维护TBL_APPLI_BASE_INFO[业务申请基本信息表],生成APPNO
		BPbcAppliBaseInfo tblAppliBaseInfo = new BPbcAppliBaseInfo();
		tblAppliBaseInfo.setCustcd(contractVO.getCustcd());						 	 //客户号
		tblAppliBaseInfo.setAppliType(businessnoType);								 //申请类型
		if(WorkflowConstant.APPLI_TYPE_MAXBAIL_TRANSFER_OUT_APPLY.equals(businessnoType)){
			tblAppliBaseInfo.setBusinessnoType(ScfBasConstant.BUSINESSNO_TYPE_SLAVECONTNO);//业务编号类型
			tblAppliBaseInfo.setBusinessno(contractVO.getSlaveContno());			 //抵质押合同号
		}else{
			tblAppliBaseInfo.setBusinessnoType(ScfBasConstant.BUSINESSNO_TYPE_CONTNO); //业务编号类型
			tblAppliBaseInfo.setBusinessno(contractVO.getMastContno());				 //主合同号
		}
		tblAppliBaseInfo.setProcessTemplateName(workApplyType);						 //流程名称
		tblAppliBaseInfo.setSupplyChainPdId(contractVO.getSupplyChainPdId());	 	 //供应链产品ID 操作模式
		tblAppliBaseInfo.setProtocolNo(contractVO.getOtherProtocolNo());   	 //关联协议号
		tblAppliBaseInfo.setAppliStatus(ScfBasConstant.APPLI_STATUS_UNSUBMIT);         //申请状态:未提交（默认）
//		tblAppliBaseInfo.setAppBrcode(ContextHolder.getOrgInfo().getBrNo());	                             //登记机构
//		tblAppliBaseInfo.setAppTlrcd(ContextHolder.getUserInfo().getTlrNo());	                     		 //登记人
//		tblAppliBaseInfo.setAppDate(ScfDateUtil.formatDate(new Date()));						 //登记时间
//		tblAppliBaseInfo.setStartBrcode(ContextHolder.getOrgInfo().getBrNo());							 //发起申请行
//		tblAppliBaseInfo.setStartTlrcd(ContextHolder.getUserInfo().getTlrNo());								 //发起操作员号
//		tblAppliBaseInfo.setStratDate(ScfDateUtil.getStringDate(new Date()));					 //发起日期
//		tblAppliBaseInfo.setStartTime(new Date());					 //申请发起时间
		tblAppliBaseInfo.setMastContno(contractVO.getMastContno());					 //主合同号
		tblAppliBaseInfo.setSlaveContno(contractVO.getSlaveContno());				 //抵质押合同号
		String appno = bpbcapplibaseinfoservice.save(tblAppliBaseInfo);
		return appno;
	}

	/**
	 * @Description: 在这里添加方法的注释
	 * @author xiong_xiaolong
	 * @Created 2013-7-10下午2:51:57
	 * @param insertList
	 * @param lncimodifyList
	 * @return
	 * @throws ScubeBizException
	 */
	// 大VO改造 comment by xiaolong.xiong 2013-07-13
//	public ArrayList<TblCustAccountBussInfo> cashEqualValueInfoUpdatesign(List insertList,List lncimodifyList) throws ScubeBizException {
//		//更新现金等价物
//		TblCustAccountBussInfoDAO tblCustAccountBussInfoDAO = SCFDAOUtils.getTblCustAccountBussInfoDAO();
//		ArrayList<TblCustAccountBussInfo> bailAccountList=tblCustAccountBussInfoDAO.cashEqualValueInfoUpdate(insertList);
//
//
////		dealCredit(lncimodifyList, SCFConstants.CREDIT_OPERATION_TYPE09, ((OldContractVO)lncimodifyList.get(0)).getAddAmount());
//		return bailAccountList;
//	}

	/**
	 * DESCRIPTION:现金等价物单笔模式
	 * @author JINGNAN.WANG
	 * @date 2012-5-15
	 * cashEqualValueSingleInfoUpdate 方法
	 * @param insertList
	 * @param modifyList
	 * @param deleteList
	 * @throws ScubeBizException
	 * @param commonQueryVO
	 * @return
	 */
//	public ArrayList<TblLnciBaseInfo> cashEqualValueSingleInfoUpdate(List modifyList) throws ScubeBizException {
//		//更新借据信息
//		TblLnciBaseInfoDAO tblLnciBaseInfoDAO = SCFDAOUtils.getTblLnciBaseInfoDAO();
//		return tblLnciBaseInfoDAO.updateTblLnciBaseInfo(modifyList);
//	}

	/**
	 * DESCRIPTION:现金等价物单笔模式流水记录
	 * @author JINGNAN.WANG
	 * @date 2012-5-17
	 * insertCashEqualValueInfoForSingle 方法
	 * @param bailAccountList
	 * @throws ScubeBizException
	 * @param commonQueryVO
	 * @return
	 */
//	public void insertCashEqualValueInfoForSingle(OldContractVO contractVO,List bailAccountList,List lnciList,List lncimodifyList) throws ScubeBizException {
//		//记录流水信息
//		log.info("------ 现金等价物单笔模式流水记录 start------");
//		TblCustAccountBussInfoDAO tblBussInfoDAO = SCFDAOUtils.getTblCustAccountBussInfoDAO();
//		//tblBussInfoDAO.insertCashEqualValueInfoForSingle(contractVO,bailAccountList,lnciList,lncimodifyList);
//		GlobalInfo gb = GlobalInfo.getCurrentInstance();
//    	TblCustAccountBussInfo tblCustAccountBussInfo = null;
//    	TblAppliCustAccountInfo appliInfo = null;
//    	String appno = String.valueOf(this.getSeqPK(SCFConstants.VALUE_NO_SEQ_TBL_ID, SCFConstants.VALUE_INDEX_APPLIBASEINFO_ID));
//    	//记录流水信息
//    	if(null != bailAccountList && bailAccountList.size() > 0 && null != lnciList && lnciList.size() > 0){
//    		for(int i=0;i<bailAccountList.size();i++){
//    			appliInfo = (TblAppliCustAccountInfo) bailAccountList.get(i);
//    			//记录现金等价物质押登记添加的现金等价物流水
//    			tblCustAccountBussInfo = new TblCustAccountBussInfo();
//    			CommonFunction.copyProperties(tblCustAccountBussInfo, appliInfo);
////    			tblCustAccountBussInfo.setBillsNo(tblCustAccountBussInfo.getId().toString());//现金等价物id
////    			tblCustAccountBussInfo.setStatus(SCFConstants.LOANBAIL_CONFIRM_STATUS_UNSUBMIT);//保证金及现金等价物状态
////    			tblCustAccountBussInfo.setCustcdBuyer(tblCustAccountBussInfo.getCustcd());//客户号
////    			tblCustAccountBussInfo.setBussType(SCFConstants.SUPPLYCHAINPDID_02);
////    			tblCustAccountBussInfo.setApplyType(WorkflowConstant.APPLI_TYPE_MORTGAGEBILL);
////				tblCustAccountBussInfo.setAppno(appno);
////				tblCustAccountBussInfo.setBillsType(tblCustAccountBussInfo.getBailType());//保证等价物类型/还款类型
////				BigDecimal value =  tblCustAccountBussInfo.getBailAmount().multiply(tblCustAccountBussInfo.getBailRate());
////				tblCustAccountBussInfo.setBillsAmount(value.divide(new BigDecimal("100")));//现金等价物质押价值/还款金额
////				tblCustAccountBussInfo.setPledgeActiveDate(gb.getTxdate());//还款时间
////				tblCustAccountBussInfo.setDebetNo(tblCustAccountBussInfo.getDebetNo());//借据号
////				tblCustAccountBussInfo.setPayAmount(((OldContractVO)lncimodifyList.get(0)).getAddAmount());//本次追加金额
//				tblCustAccountBussInfo.setId(null);
//				tblBussInfoDAO.save(tblCustAccountBussInfo);//现贷预付业务流水明细表Tbl_Buss_Detail
//    		}
//
//    	}
//
//		log.info("------ 现金等价物单笔模式流水记录 end ------");
//	}

	/**
	 * DESCRIPTION:额度处理
	 * @author QUANYU.SI
	 * @date 2012-6-26
	 * dealCredit 方法
	 * @param lnciList
	 * @param CREDIT_OPERATION_TYPE
	 * @param amount
	 * @throws ScubeBizException
	 */
	/*public void dealCredit(List lnciList,String CREDIT_OPERATION_TYPE,BigDecimal amount) throws ScubeBizException{
		//现金等价物登记--09额度--恢复，现金等价物解押--10额度--占用
		if(lnciList != null && lnciList.size()>0){
			TblLnciBaseInfo lnci = DAOUtils.getTblLnciBaseInfoDAO().get(((OldContractVO)lnciList.get(0)).getDebetNo());;
			//String creditTradeType = null ;
			if(SCFConstants.CREDIT_OPERATION_TYPE09.equals(CREDIT_OPERATION_TYPE)){
				//creditTradeType = SCFConstants.APPLY_TYPE_TRADE_04;
			}else if(SCFConstants.CREDIT_OPERATION_TYPE10.equals(CREDIT_OPERATION_TYPE)){
				//creditTradeType = SCFConstants.APPLY_TYPE_TRADE_02;
				amount = getCreditAmount(lnci,amount);
			}else{
				ExceptionUtil.throwScubeBizException("额度操作类型丢失！", SCFErrorCode.RECORD_NOT_EXIST);
			}
			//String operationType = SCFConstants.OPERATION_TYPE_02;
//			CreditService.getInstance().creditLnci(lnci, creditTradeType, operationType, CREDIT_OPERATION_TYPE, amount);
		}else{
			ExceptionUtil.throwScubeBizException("借据信息丢失！", SCFErrorCode.RECORD_NOT_EXIST);
		}
	}*/

	/**
	 * DESCRIPTION:获取占用额度，
	 * if(借据余额-初始-追加〉0){
	 *	  占用金额=转出金额
	 * }else if(借据余额-初始-追加〈=0){
	 *	  占用金额=转出金额-（初始+追加-借据余额）；
	 *	  占用金额=占用金额〉0？占用金额：0；
     * }
	 * @author mengjiajia
	 * @date 2012-6-26
	 * getCreditAmount 方法
	 * @param lnci
	 * @param amount
	 * @return
	 */
	public BigDecimal getCreditAmount(BLanLnciBase lnci , BigDecimal amount){
		BigDecimal result = new BigDecimal(0);
		/*借据余额*/
		BigDecimal lnciBal = lnci.getLnciBal()!=null?lnci.getLnciBal():new BigDecimal(0);
		/*初始保证及等价物金额*/
		BigDecimal bailAmount = lnci.getBailAmount()!=null?lnci.getBailAmount():new BigDecimal(0);
		/*追加保证金及等价物金额*/
		BigDecimal refundAmount = lnci.getAddBailAmount()!=null?lnci.getAddBailAmount():new BigDecimal(0);
		if(lnciBal.subtract(bailAmount).subtract(refundAmount).floatValue()>0){
			result = amount;
		}else if(lnciBal.subtract(bailAmount).subtract(refundAmount).floatValue()<=0){
			BigDecimal transate = new BigDecimal(0);
			transate = amount.subtract(bailAmount).subtract(refundAmount).add(lnciBal);
			result = transate.floatValue()>0?transate:new BigDecimal(0);
		}
		return result;
	}


	/**
	 *
	 * @Description: 差额退款申请信息获取--通用
	 * @author wenkui.xu
	 * @Created 2012-11-12上午11:07:29
	 * @param commonQueryVO
	 * @return
	 * @throws ScubeBizException
	 */
	// 大VO改造 comment by xiaolong.xiong 2013-07-13
	/*public PageQueryResult getTripartiteAppBaseInfo(OldCommonQueryVO commonQueryVO) throws ScubeBizException{
		String appno = commonQueryVO.getAppno_Q();
		if(DataFormat.isEmpty(appno)){
			ExceptionUtil.throwScubeBizException("申请编号丢失！", SCFErrorCode.RECORD_NOT_EXIST);
		}
		TblAppliBaseInfoDAO tblAppliBaseInfoDAO = DAOUtils.getTblAppliBaseInfoDAO();
		TblAppliBaseInfo tblAppliBaseInfo = tblAppliBaseInfoDAO.get(appno);
		if(tblAppliBaseInfo==null){
			ExceptionUtil.throwScubeBizException("申请编号信息丢失！", SCFErrorCode.RECORD_NOT_EXIST);
		}

		// 根据申请主表PK，查询WorkflowTaskInfo
		TaskVO taskVO = WorkFlowService.getInstance().getTodoTaskByAppno(appno);
		OldApplyVO applyVO = new OldApplyVO();
		try {
			BeanUtils.copyProperties(applyVO, tblAppliBaseInfo);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		applyVO.setProcessTemplate(taskVO.getTemplateId());//设置流程名
		applyVO.setTaskName(taskVO.getNodeName());//设置任务名
		applyVO.setTaskId(taskVO.getTaskId());//流程ID
		applyVO.setProtocolNo(tblAppliBaseInfo.getProtocolNo());//差额回购协议
		applyVO.setBusinessno(tblAppliBaseInfo.getBusinessno());//

		ArrayList<OldApplyVO> result = new ArrayList<OldApplyVO>();
		result.add(applyVO);
		PageQueryResult pageQueryResult = new PageQueryResult();
		pageQueryResult.setQueryResult(result);
		pageQueryResult.setTotalCount(result.size());

		return pageQueryResult;
	}*/

	/**
	 *
	 * @Description: 保证金转出查询保证金账户-查询scf系统
	 * @author wenkui.xu
	 * @Created 2012-11-12下午02:08:34
	 * @param lnciQryVO
	 * @return
	 * @throws ScubeBizException
	 */
//	public PageQueryResult getCustAccountBussInfoByParam(LnciQryVO lnciQryVO) throws ScubeBizException {
//		TblCustAccountBussInfoDAO tblCustAccountBussInfoDAO = SCFDAOUtils.getTblCustAccountBussInfoDAO();
//		PageQueryResult pageQueryResult = null;
//		pageQueryResult = tblCustAccountBussInfoDAO.getCustAccountBussInfoByParam(lnciQryVO);
//		return pageQueryResult;
//	}

	/**
	 *
	 * @Description: 保证金转入保存——单笔管理模式
	 * @author wenkui.xu
	 * @Created 2012-11-12下午04:31:36
	 * @throws ScubeBizException
	 */
//	public void saveBailTransferApplySingle(BailBussInfoVO bailBussInfoVO)
//			throws ScubeBizException {
//		//获取合同信息
//		TblContBaseInfo tblContBaseInfo=SCFDAOUtils.getTblContBaseInfoDAO().get(bailBussInfoVO.getMastContno());
//		String protocolNo=tblContBaseInfo.getProtocolNo();
//		bailBussInfoVO.setProtocolNo(protocolNo);
//		bailBussInfoVO.setBailType(SCFConstants.BAIL_TYPE_NORMAL);
//		bailBussInfoVO.setInitType(SCFConstants.INIT_TYPE_ADD);
//		// 检测保证金账号在SCF数据库中是否存在
//		TblCustAccountBussInfoDAO tblCustAccountBussInfoDAO = SCFDAOUtils.getTblCustAccountBussInfoDAO();
//		List bailList = tblCustAccountBussInfoDAO.getTblCustAccountBussInfoByBailAccountno(bailBussInfoVO);
//		TblCustAccountBussInfo tblCustAccountBussInfo = null;
//		if (bailList != null && bailList.size() > 0) {
//			// 保证金账号存在,更新客户账号业务信息表中的保证金金额和最后更新时间
//			tblCustAccountBussInfo = this.modifyTblCustAccountBussInfo(bailList,bailBussInfoVO);
//		} else {
//			// 保证金账号不存在,在客户账号信息表Tbl_Cust_Account_Info中插入一条记录
//			tblCustAccountBussInfo = this.addTblCustAccountBussInfoSingle(bailBussInfoVO);
//		}
//		// 更新借据基本信息表Tbl_Lnci_Base_Info中追加现金及其等价物价值
//		this.modifyTblLnciBaseInfo(bailBussInfoVO);
//		// 保证金转入单笔管理模式记录流水
//		this.insertBussInfoOrDetail(bailBussInfoVO,tblCustAccountBussInfo, tblContBaseInfo.getSupplyChainPdId());
//	}

	/**
	 *
	 * @Description: 更新客户账号信息
	 * @author wenkui.xu
	 * @Created 2012-11-12下午04:41:39
	 * @param bailList
	 * @return
	 * @throws ScubeBizException
	 */
//	public TblCustAccountBussInfo modifyTblCustAccountBussInfo(List bailList,
//			BailBussInfoVO bailBussInfoVO) throws ScubeBizException {
//		TblCustAccountBussInfoDAO tblCustAccountBussInfoDAO = SCFDAOUtils
//				.getTblCustAccountBussInfoDAO();
//		TblCustAccountBussInfo tblCustAccountBussInfo = (TblCustAccountBussInfo) bailList
//				.get(0);
//		// SCF保证金金额=前次保证金金额+本次转入保证金金额
//		BigDecimal sumBailAmount = tblCustAccountBussInfo.getBailAmount().add(
//				bailBussInfoVO.getBailAmount());
//		tblCustAccountBussInfo.setBailAmount(sumBailAmount);
//		tblCustAccountBussInfo.setLastUpdateDate(DateUtil.getCurrentDate());
//		tblCustAccountBussInfoDAO.update(tblCustAccountBussInfo);
//		return tblCustAccountBussInfo;
//	}

	/**
	 *
	 * @Description: 新增保证金流水信息
	 * @author wenkui.xu
	 * @Created 2012-11-12下午04:43:16
	 * @return
	 * @throws ScubeBizException
	 */
//	public TblCustAccountBussInfo addTblCustAccountBussInfoSingle(BailBussInfoVO bailBussInfoVO)throws ScubeBizException {
//		TblCustAccountBussInfoDAO tblCustAccountBussInfoDAO = SCFDAOUtils.getTblCustAccountBussInfoDAO();
//		TblCustAccountBussInfo tblCustAccountBussInfo = new TblCustAccountBussInfo();
//		tblCustAccountBussInfo.setBailAccountno(bailBussInfoVO.getBailAccountno());// 保证金账号
//		tblCustAccountBussInfo.setBailAmount(bailBussInfoVO.getBailAmount());// 转入保证金金额
//		tblCustAccountBussInfo.setCustcd(bailBussInfoVO.getCustcd());// 客户号
//		tblCustAccountBussInfo.setMastContno(bailBussInfoVO.getMastContno());// 放款合同号（主）
//		tblCustAccountBussInfo.setBailType(bailBussInfoVO.getBailType());// 保证金等价物类型
//		tblCustAccountBussInfo.setInitType(bailBussInfoVO.getInitType());// 保证金等价物质押类型：初始、追加
//		tblCustAccountBussInfo.setBailRate(new BigDecimal("100"));// 保证金等价物质押率(%)
//		tblCustAccountBussInfo.setLastUpdateDate(DateUtil.getCurrentDate());
//		tblCustAccountBussInfo.setConfirmStatus(SCFConstants.CONFIRM_STATUS_CONFIRMED);
//		tblCustAccountBussInfo.setDebetNo(bailBussInfoVO.getDebetNo());//借据号
//		tblCustAccountBussInfo.setProtocolNo(bailBussInfoVO.getProtocolNo());//协议号
//		TblContBaseInfo contBaseInfo = SCFDAOUtils.getTblContBaseInfoDAO().get(bailBussInfoVO.getMastContno());//根据主合同号查询主合同
//		tblCustAccountBussInfo.setSlaveContno(contBaseInfo.getSlaveContno());//质押合同号
//		tblCustAccountBussInfoDAO.save(tblCustAccountBussInfo);
//		return tblCustAccountBussInfo;
//	}

	/**
	 * DESCRIPTION:更新借据基本信息
	 *
	 * @author MINGLIANG.WANG
	 * @date 2012-5-14 modifyTblLnciBaseInfo 方法
	 * @throws ScubeBizException
	 */
//	public void modifyTblLnciBaseInfo(BailBussInfoVO bailBussInfoVO)
//			throws ScubeBizException {
//		TblLnciBaseInfoDAO tblLnciBaseInfoDAO = SCFDAOUtils.getTblLnciBaseInfoDAO();
//		List lncilist = tblLnciBaseInfoDAO.getTblLnciBaseInfoByDebetNo(bailBussInfoVO);
//
//		if (lncilist != null && lncilist.size() > 0) {
//			TblLnciBaseInfo tblLnciBaseInfo = (TblLnciBaseInfo) lncilist.get(0);
//			// 追加现金及其等价物价值=追加现金及其等价物价值+本次追加现金及其等价物价值
//			if(tblLnciBaseInfo.getAddBailAmount()==null){
//				tblLnciBaseInfo.setAddBailAmount(new BigDecimal(0));
//			}
//			BigDecimal totalBailAmount = tblLnciBaseInfo.getAddBailAmount().add(
//					bailBussInfoVO.getBailAmount());
//			tblLnciBaseInfo.setAddBailAmount(totalBailAmount);
//			SCFDAOUtils.getTblLnciBaseInfoDAO().update(tblLnciBaseInfo);
//		} else {
//			ExceptionUtil.throwAppException("借据号为'"
//					+ bailBussInfoVO.getDebetId() + "'的借据不存在！",
//					SCFErrorCode.RECORD_NOT_EXIST);
//		}
//	}

	/**
	 *
	 * @Description: 保证金转入记录流水
	 * @author wenkui.xu
	 * @Created 2012-11-12下午04:44:49
	 * @param tblCustAccountInfo
	 * @param bussType
	 * @throws ScubeBizException
	 */
//	public void insertBussInfoOrDetail(BailBussInfoVO bailBussInfoVO,
//			TblCustAccountBussInfo tblCustAccountBussInfo, String bussType)
//			throws ScubeBizException {
//		GlobalInfo gb = GlobalInfo.getCurrentInstance();
//		// 在现贷预付业务流水总表Tbl_Buss_Info中插入一条记录
//		//comment by xiaolong.xiong 2013-08-10
//		/*TblBussInfoDAO tblBussInfoDAO = DAOUtils.getTblBussInfoDAO();
//		TblBussInfo tblBussInfo = new TblBussInfo();
//		tblBussInfo.setMastContno(tblCustAccountBussInfo.getMastContno());//主合同号
//		tblBussInfo.setSubContno(tblCustAccountBussInfo.getMastContno());
//		tblBussInfo.setBailType(tblCustAccountBussInfo.getBailType());
//		tblBussInfo.setAmount(bailBussInfoVO.getBailAmount());// 转入金额
//		tblBussInfo.setAppDate(GlobalInfo.getCurrentInstance().getTxnDate());
//		tblBussInfo.setAccountno(tblCustAccountBussInfo.getBailAccountno());// 保证金账号
//		tblBussInfo.setCustcdBuyer(tblCustAccountBussInfo.getCustcd());// 客户号
//		tblBussInfo.setBussType(bussType);
//		tblBussInfo.setBrcode(gb.getBrcode());// 当前机构
//		tblBussInfo.setTlrcd(gb.getTlrno());// 当前操作员
//		tblBussInfo.setAppno(bailBussInfoVO.getAppno());
//		tblBussInfo.setApplyType(WorkflowConstant.APPLI_TYPE_BAILTRANSFERAPPLY);
//		tblBussInfo.setId(null);
//		tblBussInfoDAO.save(tblBussInfo);*/
//
//	}

	/**
	 *
	 * @Description:保证金转出申请录入-单笔管理模式
	 * @author wenkui.xu
	 * @Created 2012-11-13上午10:48:46
	 * @param contractVO
	 * @param selectlist
	 * @throws ScubeBizException
	 */
	// VO改造 2013-07-12 comment by xiaolong.xiong
	/*public void saveBailTransferOutSingleNew(OldContractVO contractVO,List selectlist) throws ScubeBizException {
		//保证金转出申请信息保存至TBL_APPLI_BASE_INFO[业务申请基本信息表]
		TblAppliBaseInfoDAO tblAppliBaseInfoDAO = DAOUtils.getTblAppliBaseInfoDAO();
    	TblAppliBaseInfo tblAppliBaseInfo = tblAppliBaseInfoDAO.get(contractVO.getAppno());
    	if(tblAppliBaseInfo==null){
    		ExceptionUtil.throwAppException("申请信息获取失败！", SCFErrorCode.RECORD_NOT_EXIST);
    	}
    	tblAppliBaseInfo.setBailAmount(contractVO.getBailAmount()); 	  //保证金质押登记总金额
    	tblAppliBaseInfo.setAmt(contractVO.getAmt());//申请转出金额
    	tblAppliBaseInfoDAO.update(tblAppliBaseInfo);
//		//验证敞口
//		if(SCFConstants.ARRIVED_MANAGE_MODE_01.equals(arrivedManageMode)){
//			String protocolNo = OldContractVO.getProtocolNo();
//			AmountVO amountVO = new AmountVO(tblContBaseInfo.getSupplyChainPdId(), protocolNo);
//			BigDecimal amount1 = AmountService.getInstance().getTotalAmount(amountVO,SCFConstants.CALCULATE_MODEL_3,SCFConstants.RETURN_MODEL_1);// 不含押品的敞口
//			BigDecimal amt=OldContractVO.getAmt()==null?new BigDecimal(0):OldContractVO.getAmt();
//			if (amt.compareTo(amount1) > 0) {
//				ExceptionUtil.throwAppException("转出保证金'"
//						+ OldContractVO.getAmt()
//						+ "'后，协议池押品质押值加保证金及其等价物价值不能覆盖池业务敞口！",
//						SCFErrorCode.ERROR_CODE_DATA_INPUT_ERR);
//			}
//		}
		//装借据
		//保证金转出申请信息保存至TBL_APPLI_CUST_ACCOUNT_INFO[保证金转出申请信息临时表]
		TblAppliCustAccountInfoDAO tblAppliCustAccountInfoDAO=DAOUtils.getTblAppliCustAccountInfoDAO();
		//清空保证金信息
		tblAppliCustAccountInfoDAO.deleteByAppno(contractVO.getAppno());
		TblAppliLnciBaseInfoDAO tblAppliLnciBaseInfoDAO = DAOUtils.getTblAppliLnciBaseInfoDAO();
		//清空借据申请信息
		tblAppliLnciBaseInfoDAO.deleteByAppno(contractVO.getAppno());
		Map map = new HashMap();
		if (selectlist != null && selectlist.size() > 0) {
			for (int i = 0; i < selectlist.size(); i++) {
				OldContractVO vo = (OldContractVO) selectlist.get(i);
				BigDecimal removeAmount=vo.getRemoveAmount()==null?new BigDecimal(0):vo.getRemoveAmount();
				String debetNo=vo.getDebetNo();
				if(map.containsKey(debetNo)){//如果借据已存在，则转出金额累加
					BigDecimal value=(BigDecimal) map.get(debetNo);
					map.put(debetNo,value.add(removeAmount));
				}else{
					map.put(debetNo,removeAmount);
				}
				// 校验申请转出金额是否小于等于保证金质押登记总金额
				if (removeAmount.compareTo(vo.getBailAmount()) > 0) {
					ExceptionUtil.throwAppException("申请转出保证金金额不能超过保证金质押登记总金额！",
							SCFErrorCode.ERROR_CODE_DATA_INPUT_ERR);
				}
				//保证金转出申请信息保存至MS_TBL_APPLI_CUST_ACCOUNT_INFO[保证金转出申请信息临时表]
				TblAppliCustAccountInfo t = new TblAppliCustAccountInfo();
				t.setAppno(contractVO.getAppno());
				t.setBailAccountno(vo.getBailAccountno());
				t.setBailAmount(vo.getBailAmount());
				t.setBailType(vo.getBailType());
				t.setProtocolNo(contractVO.getProtocolNo());
				t.setInitType(vo.getInitType());
				t.setDebetNo(vo.getDebetNo());
				t.setAmount(vo.getRemoveAmount());
				t.setLastUpdateDate(vo.getLastUpdateDate());
				t.setBrcode(vo.getBrcode());
				t.setMastContno(vo.getSubContno());
				t.setCustcd(vo.getCustcd());
				t.setBailRate(vo.getBailRate());
				t.setSlaveContno(contractVO.getSlaveContno());//抵质押合同号
				t.setMastContno(contractVO.getMastContno());//主合同号
				t.setId(null);
				tblAppliCustAccountInfoDAO.save(t);
    	}
			//借据信息
			Set s=map.keySet();
			Iterator iter =s.iterator();
			while(iter.hasNext()){
				String debetNo=(String) iter.next();
				//获取借据信息
				TblLnciBaseInfo tblLnciBaseInfo=DAOUtils.getTblLnciBaseInfoDAO().get(debetNo);
//				//借据敞口验证（单笔模式）
//				if(SCFConstants.ARRIVED_MANAGE_MODE_02.equals(arrivedManageMode)){//单笔模式
//					String protocolNo = OldContractVO.getProtocolNo();
//					AmountVO amountVO1 = new AmountVO(
//							tblContBaseInfo.getSupplyChainPdId(), protocolNo, debetNo,null);
//					BigDecimal amount2 = AmountService.getInstance()
//							.getTotalAmount(amountVO1,SCFConstants.CALCULATE_MODEL_3,
//									SCFConstants.RETURN_MODEL_1);// 不含押品的敞口
//					BigDecimal amt1=(BigDecimal) map.get(debetNo);
//					if (amt1.compareTo(amount2) > 0) {
//						ExceptionUtil.throwAppException("借据【"+tblLnciBaseInfo.getDebetId()+"】转出保证金'"
//								+ amt1
//								+ "'后，协议池押品质押值加保证金及其等价物价值不能覆盖池业务敞口！",
//								SCFErrorCode.ERROR_CODE_DATA_INPUT_ERR);
//					}
//				}
				//借据转出申请信息保存至TBL_APPLI_LNCI_BASE_INFO
				TblAppliLnciBaseInfo albi=new TblAppliLnciBaseInfo();
				albi.setAppno(contractVO.getAppno());
				albi.setDebetNo(tblLnciBaseInfo.getDebetNo().toString());
				albi.setDebetId(tblLnciBaseInfo.getDebetId());
				albi.setLnciBal(tblLnciBaseInfo.getLnciBal());
				albi.setLoanType(tblLnciBaseInfo.getLoanType());
				albi.setLnciAmt(tblLnciBaseInfo.getLnciAmt());//借据金额
				albi.setLnciStatus(tblLnciBaseInfo.getLnciStatus());//借据状态
				albi.setSlaveContno(contractVO.getSlaveContno());//抵质押合同号
				albi.setMastContno(contractVO.getMastContno());//主合同号
				albi.setId(null);
				tblAppliLnciBaseInfoDAO.saveOrUpdate(albi);
			}
		}
	}*/


	/**
	 *
	 * @Description: 保证金转出申请，录入岗点击提交时判断申请信息是否已保存
	 * @author mengjiajia
	 * @Created 2012-11-13下午03:32:30
	 * @param appno
	 * @throws ScubeBizException
	 */
	@Override
	public void checkBailTransferOutIsSave(String appno) throws ScubeBizException{
    	BPbcAppliBaseInfo tblAppliBaseInfo = bpbcapplibaseinfoservice.findBPbcAppliBaseInfoByKey(appno);
    	if(tblAppliBaseInfo==null){
    		throw new ScubeBizException("申请信息获取失败！", RBcpErrorConstant.RECORD_NOT_EXIST);
    	}
    }

	/**
	 *
	 * @Description: 保证金转出申请流程结束后更新表内信息
	 * @author mengjiajia
	 * @Created 2012-11-13下午03:57:04
	 * @param appno
	 * @throws ScubeBizException
	 */
	@Override
	public void updateBailTransferOutInfoNew(String appno) throws ScubeBizException {
		//获取申请信息
    	BPbcAppliBaseInfo tblAppliBaseInfo = bpbcapplibaseinfoservice.findBPbcAppliBaseInfoByKey(appno);
    	if(tblAppliBaseInfo==null){
    		throw new ScubeBizException("申请信息获取失败！", RBcpErrorConstant.RECORD_NOT_EXIST);
    	}
    	if(WorkflowConstant.APPLI_TYPE_MAXBAIL_TRANSFER_OUT_APPLY.equals(tblAppliBaseInfo.getAppliType())){//最高额保证金转出
    		this.updateMaxAccountInfo(appno, tblAppliBaseInfo);
    		return;
    	}
    	if(WorkflowConstant.APPLI_TYPE_BAIL_TRANSFER_OUT_APPLY.equals(tblAppliBaseInfo.getAppliType())){//保证金转出
    		this.updateCustAccountInfo(appno,tblAppliBaseInfo);
    		return;
    	}
	}

	/**
	 *
	 * @Description: 更新最高额保证金信息
	 * @author mengjiajia
	 * @Created 2012-11-13下午04:02:06
	 * @param appno
	 * @param tblAppliBaseInfo
	 * @throws ScubeBizException
	 */
	@SuppressWarnings("rawtypes")
	public void updateMaxAccountInfo(String appno,BPbcAppliBaseInfo tblAppliBaseInfo) throws ScubeBizException{
		//获取申请中保证金转出信息
    	RBcpAppliBussInfo tblAppliBussInfo = null;
    	List list = rbcpapplibussinfoservice.findByProperty(appno);
    	if(list.size()>0)
    	{
    		tblAppliBussInfo = (RBcpAppliBussInfo) list.get(0);
    	}
    	//检测保证金账号在SCF数据库中是否存在
		BailBussInfoVO bailBussInfoVO = new BailBussInfoVO();
		bailBussInfoVO.setBailAccountno(tblAppliBussInfo.getBailAccount());
		bailBussInfoVO.setProtocolNo(tblAppliBaseInfo.getProtocolNo());
		bailBussInfoVO.setSlaveContno(tblAppliBaseInfo.getSlaveContno());
		bailBussInfoVO.setBailType(ScfBasConstant.BAIL_TYPE_NORMAL);
		bailBussInfoVO.setInitType(ScfBasConstant.INIT_TYPE_MAX);
		List bailList = bmrnacctbussinfoservice.getTblCustAccountBussInfoByBailAccountno(bailBussInfoVO);
		if(bailList!=null&&bailList.size()>0){//插入一条新的保证金
			com.huateng.scf.bas.mrn.dao.model.BMrnAcctBussInfo tblCustAccountBussInfo = 
					(com.huateng.scf.bas.mrn.dao.model.BMrnAcctBussInfo)bailList.get(0);
			//保证金质押登记总金额=保证金质押登记总金额-申请转出金额
			BigDecimal subBailAmount = tblCustAccountBussInfo.getBailAmount().subtract(tblAppliBussInfo.getAmount());
			tblCustAccountBussInfo.setBailAmount(subBailAmount);
			tblCustAccountBussInfo.setLastUpdTime(new Date());;
//			BigDecimal bigDecimal=new BigDecimal(0);
//			if(subBailAmount.compareTo(bigDecimal)>0){
//				tblCustAccountBussInfo.setConfirmStatus(SCFConstants.CONFIRM_STATUS_CONFIRMED);
//			}else{
//				tblCustAccountBussInfo.setConfirmStatus(SCFConstants.CONFIRM_STATUS_RELEASED);
//			}
			BMrnAcctBussInfo bMrnAcctBussInfo = new BMrnAcctBussInfo();
			BeanUtils.copyProperties(tblCustAccountBussInfo, bMrnAcctBussInfo);
			bmrnacctbussinfoservice.updateBMrnAcctBussInfo(bMrnAcctBussInfo);
			//comment by xiaolong.xiong 2013-08-10
			//在现贷预付业务流水总表Tbl_Buss_Info中插入一条记录
			String protocolNo="";
			if(!StringUtil.isEmpty(tblAppliBaseInfo.getBusinessno())){
				BCrrGntyCon tcsi = bcrrgntyconservice.findBCrrGntyConByConId(tblAppliBaseInfo.getBusinessno());
				protocolNo = tcsi.getPrtclNo();
			}
			BMrnBussInfo tblBussInfo = new BMrnBussInfo();
			tblBussInfo.setAmount(tblAppliBaseInfo.getAmt());//申请转出金额
			tblBussInfo.setAppDate(new Date());
			if(tblCustAccountBussInfo!=null){
				tblBussInfo.setMastContno(tblAppliBaseInfo.getMastContno());
				tblBussInfo.setSubContno(protocolNo);
				tblBussInfo.setBailType(tblCustAccountBussInfo.getBailType());
				tblBussInfo.setInitType(tblCustAccountBussInfo.getInitType());
				tblBussInfo.setAccountno(tblCustAccountBussInfo.getBailAccountno());//保证金账号
				tblBussInfo.setCustcdBuyer(tblCustAccountBussInfo.getCustcd());//客户号
				tblBussInfo.setBrcode(tblCustAccountBussInfo.getBrcode());
			}
			if(tblAppliBaseInfo!=null){
				tblBussInfo.setBussType(tblAppliBaseInfo.getSupplyChainPdId());
			}
			tblBussInfo.setSlaveContno(tblAppliBaseInfo.getSlaveContno());
			tblBussInfo.setApplyType(WorkflowConstant.APPLI_TYPE_MAXBAIL_TRANSFER_OUT_APPLY);
//			tblBussInfo.setConfirmStatus("02");//未确认
			tblBussInfo.setTlrcd(ContextHolder.getUserInfo().getTlrNo());// 当前操作员
			tblBussInfo.setId(null);
			bmrnbussinfoservice.save(tblBussInfo);
		}
	}

	/**
	 *
	 * @Description:保证金转出，更新保证金信息
	 * @author mengjiajia
	 * @Created 2012-11-13下午04:02:49
	 * @param appno
	 * @param tblAppliBaseInfo
	 * @throws ScubeBizException
	 */
	@SuppressWarnings("rawtypes")
	private void updateCustAccountInfo(String appno,BPbcAppliBaseInfo tblAppliBaseInfo) throws ScubeBizException {
		//查询保证金申请临时表MS_TBL_APPLi_CUST_ACCOUNT_INFO
		List list = bmrnappliacctinfoservice.findBMrnAppliAcctInfoByAppno(appno);
		//保存流水
		insertTransferOutInfoAndDetail(tblAppliBaseInfo,list);
		//更新保证金,借据
		if(list!=null&&list.size()>0){
			for(int i=0;i<list.size();i++){
				//1:获取保证金帐号
				BMrnAppliAcctInfo tblAppliCustAccountInfo=(BMrnAppliAcctInfo) list.get(i);
				String initType = tblAppliCustAccountInfo.getInitType();
				BailBussInfoVO bailBussInfoVO = new BailBussInfoVO();
				bailBussInfoVO.setBailAccountno(tblAppliCustAccountInfo.getBailAccountno());
				bailBussInfoVO.setSubContno(tblAppliCustAccountInfo.getMastContno());
				bailBussInfoVO.setProtocolNo(tblAppliCustAccountInfo.getProtocolNo());
				bailBussInfoVO.setDebetNo(tblAppliCustAccountInfo.getDebetNo());
				bailBussInfoVO.setCustcd(tblAppliCustAccountInfo.getCustcd());
				bailBussInfoVO.setInitType(initType);
				bailBussInfoVO.setBailType(tblAppliCustAccountInfo.getBailType());
				List bailList = bmrnacctbussinfoservice.getTblCustAccountBussInfoByBailAccountno(bailBussInfoVO);
				//检测保证金账号在SCF数据库中是否存在
				BMrnAcctBussInfo tblCustAccountBussInfo = null;
				if(bailList != null && bailList.size()>0){
					//3：保证金账号存在,更新客户账号信息表Tbl_Cust_Account_Info中的保证金金额和最后更新时间
					tblCustAccountBussInfo = (BMrnAcctBussInfo)bailList.get(0);
					//保证金质押登记总金额=保证金质押登记总金额-申请转出金额
					BigDecimal subBailAmount = tblCustAccountBussInfo.getBailAmount().subtract(tblAppliCustAccountInfo.getAmount());
					tblCustAccountBussInfo.setBailAmount(subBailAmount);
					tblCustAccountBussInfo.setLastUpdTime(new Date());
					bmrnacctbussinfoservice.updateBMrnAcctBussInfo(tblCustAccountBussInfo);
					//4：更新借据信息
					BLanLnciBase tblLnciBaseInfo=blanlncibaseservice.findBLanLnciBaseByKey(tblAppliCustAccountInfo.getDebetNo());
					if(ScfBasConstant.INIT_TYPE_INIT.equals(initType)){//初始保证金
						BigDecimal bailAmount=tblLnciBaseInfo.getBailAmount()==null?new BigDecimal(0):tblLnciBaseInfo.getBailAmount();
						tblLnciBaseInfo.setBailAmount(bailAmount.subtract(tblAppliCustAccountInfo.getAmount()));
					}else{//追加保证金
						BigDecimal addBailAmount=tblLnciBaseInfo.getAddBailAmount()==null?new BigDecimal(0):tblLnciBaseInfo.getAddBailAmount();
						tblLnciBaseInfo.setAddBailAmount(addBailAmount.subtract(tblAppliCustAccountInfo.getAmount()));
					}
					blanlncibaseservice.updateBLanLnciBase(tblLnciBaseInfo);
				}
			}
		}
	}

	/**
	 *
	 * @Description: 保证金转出保存流水
	 * @author mengjiajia
	 * @Created 2012-11-13下午04:08:29
	 * @param tblAppliBaseInfo
	 * @param list
	 * @throws ScubeBizException
	 */
	@SuppressWarnings({ "rawtypes", "unused" })
	public void insertTransferOutInfoAndDetail(BPbcAppliBaseInfo tblAppliBaseInfo,List list) throws ScubeBizException{
		if(list!=null&&list.size()>0){
			//统计出账总金额
			BigDecimal money=new BigDecimal(0);
			String bailAccount = "";
			for(int i=0;i<list.size();i++){
				BMrnAppliAcctInfo tblAppliCustAccountInfo=(BMrnAppliAcctInfo) list.get(i);
				bailAccount = tblAppliCustAccountInfo.getBailAccountno();
				String debetNo = tblAppliCustAccountInfo.getDebetNo();
				BigDecimal removeAmount=tblAppliCustAccountInfo.getAmount()==null?new BigDecimal(0):tblAppliCustAccountInfo.getAmount();
				money = money.add(removeAmount);
			}
		}
	}


	/**
	 * DESCRIPTION:现金等价物额度检查操作
	 * @author mengjiajia
	 * @date 2012-6-25
	 * dealCheckCredit 方法
	 * @param lnciList
	 * @param CREDIT_OPERATION_TYPE
	 * @param amount
	 * @throws ScubeBizException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void dealCheckCredit(List lnciList,String CREDIT_OPERATION_TYPE,BigDecimal amount) throws ScubeBizException{
		Map<String, Object> map = (Map<String, Object>) lnciList.get(0);
		//现金等价物登记--09额度--恢复，现金等价物解押--10额度--占用
		if(lnciList != null && lnciList.size()>0){
			BLanLnciBase lnci = null;
//			String creditTradeType = null ;
			if(ScfBasConstant.CREDIT_OPERATION_TYPE09.equals(CREDIT_OPERATION_TYPE)){
				//creditTradeType = SCFConstants.APPLY_TYPE_TRADE_04;
				 lnci = blanlncibaseservice.findBLanLnciBaseByKey(map.get("debetNo").toString());
			}else if(ScfBasConstant.CREDIT_OPERATION_TYPE10.equals(CREDIT_OPERATION_TYPE)){
				//creditTradeType = SCFConstants.APPLY_TYPE_TRADE_02;
				 lnci = blanlncibaseservice.findBLanLnciBaseByKey(map.get("debetNo").toString());
				 amount = getCreditAmount(lnci,amount);
			}else{
				throw new ScubeBizException("额度操作类型丢失！", RBcpErrorConstant.RECORD_NOT_EXIST);
			}
//			String operationType = SCFConstants.OPERATION_TYPE_01;
//			CreditService.getInstance().creditLnci(lnci, creditTradeType, operationType, CREDIT_OPERATION_TYPE, amount);
		}else{
			throw new ScubeBizException("借据信息丢失！", RBcpErrorConstant.RECORD_NOT_EXIST);
		}
	}

	/**
	 * DESCRIPTION:发起工作流保存业务申请基本表，并返回appno
	 * @author mengjiajia
	 * @date 2012-5-15
	 * saveApplyBaseInfo 方法
	 * @param applyVO
	 * @param businessnoType
	 * @param workApplyType
	 * @return
	 * @throws ScubeBizException
	 * tblAppliBaseInfo--BPbcAppliBaseInfo
	 */
	@Override
	public String saveApplyBaseInfo(OldApplyVO applyVO,String businessnoType,String workApplyType) throws ScubeBizException{
		//判断流程中是否存在该放款合同下的记录如果存在，不允许再次泛起
		bpbcapplibaseinfoservice.checkAppliBaseInfo(applyVO);
		applyVO.setProtocolNo(bcrrlnconservice.findBCrrLnConByAppId(applyVO.getMastContno()).getVidNo());
		// 现金等价物解押流程-维护TBL_APPLI_BASE_INFO[业务申请基本信息表]
		String appno = bpbcapplibaseinfoservice.saveApplyBaseInfo(applyVO,businessnoType,workApplyType);
		return appno;
	}

	/**
	 * DESCRIPTION:获取业务申请基本信息
	 * @author mengjiajia
	 * @date 2012-5-15
	 * getTblAppliBaseInfo 方法
	 * @param appno
	 * @return
	 */
	@Override
	public BPbcAppliBaseInfo getTblAppliBaseInfo(String appno){
		BPbcAppliBaseInfo tblAppliBaseInfo = bpbcapplibaseinfoservice.findBPbcAppliBaseInfoByKey(appno);
		return tblAppliBaseInfo;
	}

	/**
	 * DESCRIPTION:现金等价物填写
	 * @author mengjiajia
	 * @date 2012-5-17
	 * writeDismortgaegeBill 方法
	 * @param cont
	 * @param bill
	 * @param lnci
	 * @throws ScubeBizException
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public String writeDismortgaegeBill(OldApplyVO cont ,List billList ,List lnciList) throws ScubeBizException, IllegalAccessException, InvocationTargetException{
		String warnString = "ok";
		//List tblCustAccountInfoList = resetTblCustAccountInfo(billList);

		//为防止协议号和产品类型为空，以下代码会查询协议表，取得协议号及产品类型
		OldCommonQueryVO commonQueryVO1 = new OldCommonQueryVO();
		commonQueryVO1.setMastContno_Q(cont.getMastContno());
		Page querResult = bcrrlnconservice.getMastContByPara(commonQueryVO1);
		if(querResult.getTotalRecord()==0){
			return null;
		}
		BCrrLnCon bCrrLnCon = (BCrrLnCon) querResult.getRecords().get(0);
		//mengjiajia
//		OldContractVO contractVO = new OldContractVO();
//		BeanUtils.copyProperties(bCrrLnCon, contractVO);
		
//		AmountVO vo=new AmountVO(contractVO.getSupplyChainPdId(),contractVO.getNetMastId());
//		vo=AmountService.getInstance().setProtocolBaseInfo(vo);
//		String Dismortgagemodel = vo.getArrivedManageModel();
		cont.setProtocolNo(bCrrLnCon.getVidNo());//设置协议号
		cont.setSupplyChainPdId(bCrrLnCon.getVidBusiTyp());//设置产品类型
		List tblAppliBussInfoList = new ArrayList();
		/*if("02".equals(Dismortgagemodel)){
			//单笔模式--差额回购，保存修改借据信息，池模式--动产动态，不操作借据信息
			warnString = checkDismortgageLnci(cont,lnciList);

			取消池模式，全部改为单笔模式
			tblAppliBussInfoList = resetTblAppliBussDetail(lnciList,cont);
			saveTblAppliBussInfoDetail(tblAppliBussInfoList);
		}else{
			warnString = checkDismortgageBill(cont,billList);
		}*/
		//单笔模式--差额回购，保存修改借据信息，池模式--动产动态，不操作借据信息
//		warnString = checkDismortgageLnci(cont,lnciList,Dismortgagemodel);
		tblAppliBussInfoList = resetTblAppliBussDetail(lnciList,cont);
		saveTblAppliBussInfoDetail(tblAppliBussInfoList);
		RBcpAppliBussInfo tabi = setTblAppliBussInfo(cont ,billList ,lnciList);
		rbcpapplibussinfoservice.save(tabi);
		//updateTblCustAccountInfo(tblCustAccountInfoList);
		List list = setTblAppliCustAccountInfo(billList,cont);
		bmrnappliacctinfoservice.saveAll(list);
		//现金等价物解押额度操作
		dealCheckCredit(lnciList,"10",cont.getDismortBailAmount());
		return warnString;
	}

	/**
	 * DESCRIPTION:现金等价物解押，封装对象-借据信息保存到tblapplibussdetail
	 * @author mengjiajia
	 * @date 2012-5-17
	 * resetTblAppliBussDetail 方法
	 * @param lnci
	 * @return
	 * @throws ScubeBizException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List resetTblAppliBussDetail(List lnci,OldApplyVO cont) throws ScubeBizException{
		List list = new ArrayList();
		for(int i = 0 ; i<lnci.size() ; i++){
			Map<String, Object> map = (Map<String, Object>) lnci.get(i);
			RBcpAppliBussDtl tblAppliBussDetail = new RBcpAppliBussDtl();
			tblAppliBussDetail.setAppno(cont.getAppno());
			tblAppliBussDetail.setDebetNo(map.get("debetNo").toString());
			tblAppliBussDetail.setBillsAmountView(new BigDecimal(map.get("billsAmountView").toString()));
			tblAppliBussDetail.setLastUpdTime(new Date());
			list.add(tblAppliBussDetail);
		}
		return list;
	}

	/**
	 * DESCRIPTION:现金等价物，保存借据临时信息到TblAppliBussDetail
	 * @author mengjiajia
	 * @date 2012-5-23
	 * saveTblAppliBussInfo 方法
	 * @param listTblAppliBussInfo
	 */
	@SuppressWarnings("rawtypes")
	public void saveTblAppliBussInfoDetail(List listTblAppliBussInfo){
		for(int i = 0 ; i<listTblAppliBussInfo.size() ; i++){
			RBcpAppliBussDtl tblAppliBussDetail = new RBcpAppliBussDtl();
			tblAppliBussDetail = (RBcpAppliBussDtl) listTblAppliBussInfo.get(i);
			rbcpapplibussdtlservice.save(tblAppliBussDetail);
		}
	}

	/**
	 * DESCRIPTION:封装业务申请业务主表
	 * @author mengjiajia
	 * @date 2012-5-17
	 * setTblAppliBussInfo 方法
	 * @param cont
	 * @param bill
	 * @param lnci
	 * @return
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 * @throws ScubeBizException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public RBcpAppliBussInfo setTblAppliBussInfo(OldApplyVO cont ,List bill ,List lnci) throws IllegalAccessException, InvocationTargetException, ScubeBizException{
		RBcpAppliBussInfo tabi = new RBcpAppliBussInfo();
		Map<String, Object> billmap = (Map<String, Object>) bill.get(0);
		String custcd = billmap.get("custcd").toString();
		String debetNo = billmap.get("debetNo").toString();
		String confirmStatus = billmap.get("confirmStatus").toString();
		tabi.setAppno(cont.getAppno());
		tabi.setApplyType(WorkflowConstant.APPLI_TYPE_DISMORTGAGEBILL);//现金等价物解押
		tabi.setCustcdBuyer(custcd);
		tabi.setMastContno(cont.getMastContno());
		tabi.setBailType(cont.getBailType());
		tabi.setBussType(WorkflowConstant.APPLI_TYPE_DISMORTGAGEBILL);
		tabi.setLoanType(cont.getLoanType());
		tabi.setLoanWay(cont.getDrawType());
		if("02".equals(cont.getSupplyChainPdId())){
			tabi.setDebetNo(debetNo);
		}
		tabi.setBrcode(ContextHolder.getOrgInfo().getBrNo());						  //当前机构
		tabi.setTlrcd(ContextHolder.getUserInfo().getTlrNo());						  //当前名称
		tabi.setBailAccount(cont.getDismortBailAmount().toString());
		tabi.setAmount(cont.getDismortBailAmount());
		tabi.setConfirmStatus(confirmStatus);
		tabi.setAppDate(ScfDateUtil.formatDate(new Date()));
		return tabi;
	}

	/**
	 * DESCRIPTION:保存客户帐号申请表
	 * @author mengjiajia
	 * @date 2012-6-15
	 * setTblAppliCustAccountInfo 方法
	 * @param tblCustAccountInfoList
	 * @return
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 * @throws ScubeBizException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<BMrnAppliAcctInfo> setTblAppliCustAccountInfo(List billList,OldApplyVO cont) throws IllegalAccessException, InvocationTargetException, ScubeBizException{
		List<BMrnAppliAcctInfo> list = new ArrayList<BMrnAppliAcctInfo>();
		for(int i = 0 ; i<billList.size() ; i++){
			Map<String, Object> map = (Map<String, Object>) billList.get(i);
			BMrnAcctBussInfo tcbi = new BMrnAcctBussInfo();
			tcbi = bmrnacctbussinfoservice.findBMrnAcctBussInfoByKey(map.get("id").toString());

			BMrnAppliAcctInfo tacai = new BMrnAppliAcctInfo();
			BeanUtils.copyProperties(tcbi, tacai);
			tacai.setConfirmStatus(ScfBasConstant.LOANBAIL_CONFIRM_STATUS_DISING);//解押中
			tacai.setAccountType(map.get("accountType").toString());//把解押用途保存在账户类型中，现金等价物不用账户类型
			tacai.setLstUpdDt(ScfDateUtil.formatDate(new Date()));
			tacai.setLstUpdTlr(ContextHolder.getUserInfo().getTlrNo());
			tacai.setAccountNo(map.get("id").toString());
			tacai.setId(null);
			tacai.setAppno(cont.getAppno());
			tacai.setProtocolNo(cont.getProtocolNo());//数据库表新增协议号字段，赋值
			list.add(tacai);
		}
		return list;
	}


	/**
	 * DESCRIPTION:现金等价物解押，approve岗保存通知书信息
	 * @author mengjiajia
	 * @date 2012-5-22
	 * saveNotice 方法
	 * @param cont
	 * @param billList
	 * @param lnciList
	 * @throws ScubeBizException
	 */
	@Override
	public void saveNotice(CommonApplyDtlInfoVO commAppInfoVo) throws ScubeBizException{
		// VO改造 2013-07-12 comment by xiaolong.xiong
		/*BPbcAppliBaseInfo tblAppliBaseInfo = this.getTblAppliBaseInfo(commAppInfoVo.getBussAppno());
		com.huateng.scf.bas.crr.model.BCrrLnCon cont = bcrrlnconservice.findBCrrLnConByAppId(tblAppliBaseInfo.getMastContno());
		List billList = getBillList(tblAppliBaseInfo);
		//List lnciList =getlnciList(tblAppliBaseInfo.getSlaveContno());
		BNteNoticeBase tblNoticeBaseInfo = setTblNoticeBaseInfo(cont ,billList ,commAppInfoVo);
		bntenoticebaseservice.addBNteNoticeBase(tblNoticeBaseInfo);
		List list = setTblNoticeBillInfo(cont ,billList ,commAppInfoVo,tblNoticeBaseInfo);
		for(int i = 0 ; i<list.size() ; i++){
			//保存现金等价物编号与金额
			BNteNoticeBill tblNoticeBillInfo = new BNteNoticeBill();
			tblNoticeBillInfo = (BNteNoticeBill) list.get(i);
			bntenoticebillservice.addBNteNoticeBill(tblNoticeBillInfo);;
		}
		OldCommonQueryVO commonQueryVO = new OldCommonQueryVO();
		commonQueryVO.setSubContno_Q(tblAppliBaseInfo.getSlaveContno());
		commonQueryVO.setAppno_Q(commAppInfoVo.getBussAppno());*/
//		Page pageQueryResult = contractservice.getLnciBaseInfoByParamGetter(commonQueryVO);
//		List lncimodifyList = pageQueryResult.getRecords();
//		beforeDealCredit(lncimodifyList,ScfBasConstant.CREDIT_OPERATION_TYPE10,((com.huateng.scf.bas.lan.dao.model.BLanLnciBase)lncimodifyList.get(0)).getBillsAmountView());
//		dealCredit(lncimodifyList, ScfBasConstant.CREDIT_OPERATION_TYPE10, ((com.huateng.scf.bas.lan.dao.model.BLanLnciBase)lncimodifyList.get(0)).getBillsAmountView());
	}

	/**
	 * DESCRIPTION:获取现金等价物信息
	 * @author mengjiajia
	 * @date 2012-5-22
	 * getBillList 方法
	 * @param tblAppliBaseInfo
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public List getBillList(BPbcAppliBaseInfo tblAppliBaseInfo){
		OldCommonQueryVO commonQueryVO = new OldCommonQueryVO();
		commonQueryVO.setAppno_Q(tblAppliBaseInfo.getAppno());
		commonQueryVO.setMastContno_Q(tblAppliBaseInfo.getMastContno());
		Page page = bmrnappliacctinfoservice.getBillCustAccountInfoApprove(commonQueryVO);
		return page.getRecords();
	}

	/**
	 * DESCRIPTION:实例化通知书基本表--现金等价物解押通知书
	 * @author mengjiajia
	 * @date 2012-5-22
	 * setTblNoticeBaseInfo 方法
	 * @param cont
	 * @param billList
	 * @param lnciList
	 * @param commAppInfoVo
	 * @return
	 * @throws ScubeBizException
	 */
	@SuppressWarnings("rawtypes")
	public BNteNoticeBase setTblNoticeBaseInfo(com.huateng.scf.bas.crr.model.BCrrLnCon cont ,List billList ,CommonApplyDtlInfoVO commAppInfoVo) throws ScubeBizException{
		BNteNoticeBase tblNoticeBaseInfo = new BNteNoticeBase();
//		TblMutiProtBaseInfo tblMutiProtBaseInfo = new TblMutiProtBaseInfo();
//		TblMutiProtPartInfoDAO tblMutiProtPartInfoDAO = SCFDAOUtils.getTblMutiProtPartInfoDAO();
		String protocolNo = cont.getVidNo();//协议号
		String protocolCode = new String();
		String custcd = new String();//客户号
		String brcode = new String();//银行
		String moniCustcd = new String();//监管公司
		String moniName = new String();//监管公司名称
		if(protocolNo!=null){
//			tblMutiProtBaseInfo = SCFDAOUtils.getTblMutiProtBaseInfoDAO().get(protocolNo);
//			custcd = tblMutiProtPartInfoDAO.findCnameByProAndRole(protocolNo, ScfBasConstant.PROTOCOL_PART_ROLE_CREDIT, SCFConstants.RETURN_FLAG_CUSTCD);
//			brcode = tblMutiProtPartInfoDAO.findCnameByProAndRole(protocolNo, ScfBasConstant.PROTOCOL_PART_ROLE_BANK, SCFConstants.RETURN_FLAG_CUSTCD);
//			moniCustcd = tblMutiProtPartInfoDAO.findCnameByProAndRole(protocolNo, ScfBasConstant.PROTOCOL_PART_ROLE_MONI, SCFConstants.RETURN_FLAG_CUSTCD);
//			moniName = tblMutiProtPartInfoDAO.findCnameByProAndRole(protocolNo, ScfBasConstant.PROTOCOL_PART_ROLE_MONI, SCFConstants.RETURN_FLAG_CNAME);
		}
//		if(tblMutiProtBaseInfo!=null){
//			protocolCode = tblMutiProtBaseInfo.getProtocolCode();
//		}
		if(ScfBasConstant.PRODUCT_TYPE_TRIPARTITE.equals(cont.getVidBusiTyp())){//三方
			tblNoticeBaseInfo.setProtocolCode(protocolCode);
	    	tblNoticeBaseInfo.setCustcd(custcd);//借款人号
	    	tblNoticeBaseInfo.setBrcode(brcode);//签发机构
		}else if(ScfBasConstant.PRODUCT_TYPE_FRANCHISER.equals(cont.getVidBusiTyp())){//四方
//			tblNoticeBaseInfo.setProtocolCode(tblMutiProtBaseInfo.getProtocolCode());
	    	tblNoticeBaseInfo.setCustcd(custcd);//借款人号
	    	tblNoticeBaseInfo.setMoniOfCustcd(moniCustcd);
	    	tblNoticeBaseInfo.setBrcode(brcode);//签发机构,质押监管协议中的甲方
		}else{//动产及其他
			tblNoticeBaseInfo.setProtocolCode(protocolCode);
	    	tblNoticeBaseInfo.setCustcd(custcd);//借款人号
	    	tblNoticeBaseInfo.setMoniOfCustcd(moniCustcd);
	    	tblNoticeBaseInfo.setMoniOfName(moniName);
	    	tblNoticeBaseInfo.setBrcode(brcode);//签发机构,质押监管协议中的甲方
		}
    	tblNoticeBaseInfo.setAppno(commAppInfoVo.getBussAppno());//申请编号
    	tblNoticeBaseInfo.setMonitorProtocolNo(protocolNo);//差额回购协议编号
    	tblNoticeBaseInfo.setNoticeType(NoticeConstant.NOTICE_TYPE_13);//预付款差额退款通知书
    	tblNoticeBaseInfo.setStatus("0");//AdvanceConstants.NOTICE_STATUS_NOTSIGN);//未签发
    	tblNoticeBaseInfo.setSlaveContno(cont.getAppId());
    	tblNoticeBaseInfo.setSlaveContcode(cont.getAppId());
    	tblNoticeBaseInfo.setTlrn(ContextHolder.getUserInfo().getTlrNo());//签发人
      	tblNoticeBaseInfo.setAppliDate(ScfDateUtil.formatDate(new Date()));//日期
      	tblNoticeBaseInfo.setCommonNum(billList.size()+"");
      	BigDecimal amount = new BigDecimal(0);
      	for(int i = 0 ; i<billList.size() ; i++){
      		amount = ((com.huateng.scf.bas.mrn.dao.model.BMrnAppliAcctInfo)billList.get(i)).getBailAmount().multiply(((com.huateng.scf.bas.mrn.dao.model.BMrnAppliAcctInfo)billList.get(i)).getBailRate()).divide(new BigDecimal(100)).add(amount);
      	}
//      	tblNoticeBaseInfo.setPledgeminimumvalue(amount);
      	tblNoticeBaseInfo.setCommonAmt(amount);
//      	tblNoticeBaseInfo.setMsrno(DataFormat.getRMBCapitalMoney(amount.doubleValue()));
		return tblNoticeBaseInfo;
	}

	/**
	 * DESCRIPTION:实例化通知书票据表--现金等价物解押
	 * @author mengjiajia
	 * @date 2012-5-22
	 * setTblNoticeBillInfo 方法
	 * @param cont
	 * @param billList
	 * @param lnciList
	 * @param commAppInfoVo
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List setTblNoticeBillInfo(com.huateng.scf.bas.crr.model.BCrrLnCon cont ,List billList ,CommonApplyDtlInfoVO commAppInfoVo,BNteNoticeBase tblNoticeBaseInfo){
		List list = new ArrayList();
		for(int i = 0 ; i<billList.size() ; i++){
			BNteNoticeBill tblNoticeBillInfo = new BNteNoticeBill();
			tblNoticeBillInfo.setAppno(commAppInfoVo.getBussAppno());
			tblNoticeBillInfo.setBillNo(((com.huateng.scf.bas.mrn.dao.model.BMrnAppliAcctInfo)billList.get(i)).getBailAccountno());//现金等价物编号
			//tblNoticeBillInfo.setBillId(Integer.valueOf(((TblCustAccountInfo)billList.get(i)).getBailAccountno()));//收款确认函编号
			tblNoticeBillInfo.setAmount(((com.huateng.scf.bas.mrn.dao.model.BMrnAppliAcctInfo)billList.get(i)).getBailAmount().multiply(((com.huateng.scf.bas.mrn.dao.model.BMrnAppliAcctInfo)billList.get(i)).getBailRate()).divide(new BigDecimal(100)));//金额
			tblNoticeBillInfo.setBillId(((com.huateng.scf.bas.mrn.dao.model.BMrnAppliAcctInfo)billList.get(i)).getId());
//			tblNoticeBillInfo.setPid(tblNoticeBaseInfo.getId());
			list.add(tblNoticeBillInfo);
		}
		return list;
	}

	/**
	 * DESCRIPTION:现金等价物解押--最终审批通过
	 * @author mengjiajia
	 * @date 2012-5-19
	 * dealPrint 方法
	 * @param commAppInfoVo
	 * @throws ScubeBizException
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public void dealPrint(CommonApplyDtlInfoVO commAppInfoVo) throws ScubeBizException{
		/*修改现金等价物状态
		修改借据余额和合同余额
		修改合同余额
		copy表tbl_buss_info并保存*/
		String appno = commAppInfoVo.getBussAppno(); // 业务申请号(PK)
		BPbcAppliBaseInfo tblAppliBaseInfo = bpbcapplibaseinfoservice.findBPbcAppliBaseInfoByKey(appno);
//		String subContNo = tblAppliBaseInfo.getMastContno();
		//comment by xiaolong.xiong 2013-08-10
//		TblBussInfo buss = copyTblBussInfo(appno);//流水表
//		buss.setSubContno(subContNo);
		List list = getBillList(tblAppliBaseInfo);//等价物列表
		tblAppliBaseInfo.setAppliStatus("02");//审批以通过
		setBillListAppli(list);
		List tblCustAccountInfoList = setTblCustAccountInfoList(list);//更新现金等价物信息
		List tabdList = getTblAppliBussDetailListByAppno(appno);
//		List tblbussdetailList = new ArrayList();
		List lnciList = setTblLnciBaseInfoList(tabdList);//借据表list

		bpbcapplibaseinfoservice.updateBPbcAppliBaseInfo(tblAppliBaseInfo);
//		try {
//			tblbussdetailList = setTblBussDetailList(tabdList);
//		} catch (IllegalAccessException e) {
//			ExceptionUtil.throwAppException("拷贝属性出错，您录入信息不全！", SCFErrorCode.RECORD_NOT_EXIST);
//			e.printStackTrace();
//		} catch (InvocationTargetException e) {
//			ExceptionUtil.throwAppException("拷贝属性出错，您录入信息不全！", SCFErrorCode.RECORD_NOT_EXIST);
//			e.printStackTrace();
//		}
		//未知使用
//		BigDecimal balance = balanceAmtLnci(tabdList);//解押金额

//		if("02".equals(tblLoanInfo.getSupplyChainPdId().toString().trim())){
//			buss.setBussType(SCFConstants.SUPPLYCHAINPDID_02);
//		}else{
//			buss.setBussType(SCFConstants.SUPPLYCHAINPDID_01);
//		}
//		DAOUtils.getTblBussInfoDAO().save(buss);
		bmrnappliacctinfoservice.updateAll(list);
		bmrnacctbussinfoservice.updateAll(tblCustAccountInfoList);
		blanlncibaseservice.updateAll(lnciList);
	}

	/**
	 * DESCRIPTION:TblAppliBussInfo对象copy-->TblBussInfo对象,实例化TblBussInfo
	 * @author QUANYU.SI
	 * @date 2012-5-19
	 * copyTblBussInfo 方法
	 * @param appno
	 * @return
	 * @throws ScubeBizException
	 */
	//comment by xiaolong.xiong 2013-08-10
	/*public TblBussInfo copyTblBussInfo(String appno) throws ScubeBizException{
		StringBuffer sb = new StringBuffer();
		sb.append("select po from TblAppliBussInfo po where po.appno="+Integer.valueOf(appno));
		List list = DAOUtils.getTblAppliBussInfoDAO().find(sb.toString());
		TblAppliBussInfo t = new TblAppliBussInfo();
		TblBussInfo buss = new TblBussInfo();
		if(list==null || list.size()<1){
			ExceptionUtil.throwAppException("业务申请编号丢失！", SCFErrorCode.RECORD_NOT_EXIST);
		}
		t = (TblAppliBussInfo) list.get(0);
		try {
			BeanUtils.copyProperties(buss, t);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			ExceptionUtil.throwAppException("拷贝属性出错，录入信息不全！", SCFErrorCode.RECORD_NOT_EXIST);
		} catch (InvocationTargetException e) {
			e.printStackTrace();
			ExceptionUtil.throwAppException("拷贝属性出错，录入信息不全！", SCFErrorCode.RECORD_NOT_EXIST);
		}
		GlobalInfo g = GlobalInfo.getCurrentInstance();
		buss.setAppDate(g.getTxdate());

		return buss;

	}*/

	@SuppressWarnings("rawtypes")
	public void setBillListAppli(List list){
		for(int i= 0 ; i<list.size() ; i++){
			((com.huateng.scf.bas.mrn.dao.model.BMrnAppliAcctInfo)list.get(i)).setConfirmStatus(ScfBasConstant.LOANBAIL_CONFIRM_STATUS_DIS);
		}
	}

	/**
	 * DESCRIPTION:修改该协议下现金等价物的状态为已解押
	 * @author QUANYU.SI
	 * @date 2012-5-19
	 * getTblCustAccountInfoList 方法
	 * @param protocolNo
	 * @return
	 */

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List setTblCustAccountInfoList(List list){
		List billList = new ArrayList();
		for(int i = 0 ; i<list.size() ; i++){
			BMrnAcctBussInfo t = bmrnacctbussinfoservice.findBMrnAcctBussInfoByKey(((com.huateng.scf.bas.mrn.dao.model.BMrnAppliAcctInfo)list.get(i)).getAccountNo());
			t.setConfirmStatus(ScfBasConstant.LOANBAIL_CONFIRM_STATUS_DIS);//已解押
			t.setBailAmount(new BigDecimal(0));
			billList.add(t);
		}
		return billList;
	}

	/**
	 * DESCRIPTION:获取借据临时信息
	 * @author QUANYU.SI
	 * @date 2012-5-23
	 * getTblAppliBussDetailListByAppno 方法
	 * @param appno
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public List getTblAppliBussDetailListByAppno(String appno){
		List list = rbcpapplibussdtlservice.findByProperty(appno);
		return list;
	}

	/**
	 * DESCRIPTION:修改借据信息，已还款金额减去解押金额
	 * @author QUANYU.SI
	 * @date 2012-5-19
	 * setTblLnciBaseInfoList 方法
	 * @param list
	 * @return
	 * @throws ScubeBizException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List setTblLnciBaseInfoList (List tabdList) throws ScubeBizException{
		List list = new ArrayList();
		for(int j = 0 ; j<tabdList.size() ; j++){
			BLanLnciBase tblLnciBaseInfo = new BLanLnciBase();
			tblLnciBaseInfo = blanlncibaseservice.findBLanLnciBaseByKey(((RBcpAppliBussDtl)tabdList.get(j)).getDebetNo());
			BigDecimal amount = new BigDecimal(0);
			amount = tblLnciBaseInfo.getAddCashEqtAmt().subtract(((RBcpAppliBussDtl)tabdList.get(j)).getBillsAmountView());
			tblLnciBaseInfo.setAddCashEqtAmt(amount);
			if(amount.floatValue()<0){
				throw new ScubeBizException("借据:"+tblLnciBaseInfo.getDebetId()+"中已还款金额小于零！",RBcpErrorConstant.ERROR_CODE_DATA_INPUT_ERR);
			}
			list.add(tblLnciBaseInfo);
		}
		return list;
	}

	/**
	 * DESCRIPTION:获取解押金额--单笔模式
	 * @author QUANYU.SI
	 * @date 2012-5-19
	 * balanceAmtLnci 方法
	 * @param list
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public BigDecimal balanceAmtLnci(List list){
		BigDecimal balance = new BigDecimal(0);
		for(int i = 0 ; i<list.size() ; i++){
			RBcpAppliBussDtl t = new RBcpAppliBussDtl();
			t = (RBcpAppliBussDtl) list.get(i);
			balance = balance.add(t.getBillsAmountView()==null?new BigDecimal(0):t.getBillsAmountView());
		}
		return balance;
	}

	/**
	 * DESCRIPTION:现金等价物解押--退回修改
	 * @author QUANYU.SI
	 * @date 2012-6-6
	 * backToWriteDismortgaegeBill 方法
	 * @param cont
	 * @param billList
	 * @param lnciList
	 * @return
	 * @throws ScubeBizException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	// 大VO改造 comment by xiaolong.xiong 2013-07-13
	/*public String backToWriteDismortgaegeBill(OldApplyVO cont ,List billList ,List lnciList,List billListBack) throws ScubeBizException, IllegalAccessException, InvocationTargetException{
		String warnString = "ok";

		//为防止协议号和产品类型为空，以下代码会查询协议表，取得协议号及产品类型
		MastContQryVO mastContQryVO = new MastContQryVO();
		mastContQryVO.setMastContno_Q(cont.getMastContno());
		PageQueryResult querResult = DAOUtils.getTblContBaseInfoDAO().getMastContExceptLCMastCont(mastContQryVO);
		OldContractVO contractVO = (OldContractVO) querResult.getQueryResult().get(0);
		cont.setProtocolNo(contractVO.getProtocolNo());//设置协议号
		cont.setSupplyChainPdId(contractVO.getSupplyChainPdId());//设置产品类型

		//原始的现金等价物信息
		List approveListOld = getApproveBill(cont.getAppno());
		//组装要删除的list
		List deleteBillList = checkDeleteTblAppliCustAccountInfo( billListBack, approveListOld,"");//调用重写方法
		//原始额度
		BigDecimal oldCredit = getoldCretdit(approveListOld);
		//修改后额度
		BigDecimal currentCredit = ((OldApplyVO)lnciList.get(0)).getBillsAmountView()==null?new BigDecimal(0):((OldApplyVO)lnciList.get(0)).getBillsAmountView();//本次解押现金及其等价物价值

		//组装要保存或新增的list
		List saveOrUpdateList = checkSaveOrUpdateTblAppliCustAccountInfo( billList, approveListOld, cont,"");//调用重写方法
		updateOrUpdateTblAppliCustAccountInfo(saveOrUpdateList);
		deleteTblAppliCustAccountInfo(deleteBillList);

		String Dismortgagemodel = cont.getSupplyChainPdId();
		List tblAppliBussInfoList = new ArrayList();
		//单笔模式--差额回购，保存修改借据信息，池模式--动产动态，不操作借据信息
		warnString = checkDismortgageLnci(cont,lnciList,Dismortgagemodel);

		tblAppliBussInfoList = backResetTblAppliBussDetail(lnciList,cont);
		updateTblAppliBussInfoDetail(tblAppliBussInfoList);
		TblAppliBussInfo tabi = setUpdateTblAppliBussInfo(cont ,billList ,lnciList);
		DAOUtils.getTblAppliBussInfoDAO().update(tabi);
		if("02".equals(Dismortgagemodel)){
			//单笔模式--差额回购，保存修改借据信息，池模式--动产动态，不操作借据信息
			warnString = checkDismortgageLnci(cont,lnciList);

			tblAppliBussInfoList = backResetTblAppliBussDetail(lnciList,cont);
			updateTblAppliBussInfoDetail(tblAppliBussInfoList);
		}else{
			warnString = checkDismortgageBill(cont,billList);
		}
		//TblAppliBussInfo tabi = setTblAppliBussInfo(cont ,billList ,lnciList);
		//DAOUtils.getTblAppliBussInfoDAO().update(tabi);
		//现金等价解押退回修改，需要注意额度，与原始额度比较后分情况处理
		if(oldCredit.floatValue()==currentCredit.floatValue()){
			//金额相等，不错额度操作
		}else if(oldCredit.floatValue()>currentCredit.floatValue()){
			//原始额度大于修改后额度，恢复部分金额
			dealBackToWriteCredit(lnciList, SCFConstants.CREDIT_OPERATION_TYPE09, currentCredit);
		}else{
			//原始额度小时修改后额度，占用部分额度
			dealBackToWriteCredit(lnciList, SCFConstants.CREDIT_OPERATION_TYPE10, currentCredit);
		}
		return warnString;
	}*/

	/**
	 * DESCRIPTION:封装要删除的现金等价物临时表信息 重写
	 * @author shukun.zhao
	 * @date 2012-6-16
	 * checkDeleteTblAppliCustAccountInfo 方法
	 * @param billListBack
	 * @param approveListOld
	 * @param String
	 * @return
	 */
//	public List checkDeleteTblAppliCustAccountInfo(List billListBack,List approveListOld,String string){
//		List<TblAppliCustAccountInfo> result = new ArrayList();
//		for(int i = 0 ; i<approveListOld.size() ; i++){
//			TblAppliCustAccountInfo old = (TblAppliCustAccountInfo) approveListOld.get(i);
//			result.add(old);
//		}
//		return result;
//	}

	/**
	 * DESCRIPTION:后去审批流程中的现金等价物信息
	 * @author QUANYU.SI
	 * @date 2012-6-16
	 * getApproveBill 方法
	 * @param appno
	 * @return
	 * @throws ScubeBizException
	 */
//	public List getApproveBill(String appno) throws ScubeBizException{
//		StringBuffer hql = new StringBuffer("select tcai from TblAppliCustAccountInfo tcai where 1=1 ");
//    	hql.append(" and tcai.appno='"+appno+"'");
//    	hql.append(" and tcai.confirmStatus='04' and tcai.bailType<>'03'");
//    	hql.append(" order by tcai.id desc");
//    	return SCFDAOUtils.getTblAppliCustAccountInfoDAO().find(hql.toString());
//	}

	/**
	 * DESCRIPTION:
	 * @author QUANYU.SI
	 * @date 2012-6-25
	 * getoldCretdit 方法
	 * @param approveListOld
	 * @return
	 */
//	public BigDecimal getoldCretdit(List approveListOld){
//		BigDecimal result = new BigDecimal(0);
//		for(int i = 0 ; i<approveListOld.size() ; i++){
//			TblAppliCustAccountInfo tacai = new TblAppliCustAccountInfo();
//			tacai = (TblAppliCustAccountInfo) approveListOld.get(i);
//			result = result.add(tacai.getBailAmount().multiply(tacai.getBailRate().divide(new BigDecimal(100))));
//		}
//		return result;
//	}

	/**
	 * DESCRIPTION:封装要保存和更新的现金等价物临时表信息 重写
	 * @author shukun.zhao
	 * @date 2012-6-16
	 * checkSaveOrUpdateTblAppliCustAccountInfo 方法
	 * @param billList
	 * @param approveListOld
	 * @param cont
	 * @param string
	 * @return
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	/*public List checkSaveOrUpdateTblAppliCustAccountInfo(List billList,List approveListOld,OldApplyVO cont,String string ) throws IllegalAccessException, InvocationTargetException{
		List<TblAppliCustAccountInfo> result = new ArrayList();
		List check = new ArrayList();
		for(int j = 0 ; j<billList.size() ; j++){
			OldApplyVO xin = (OldApplyVO) billList.get(j);

			TblAppliCustAccountInfo tacai = new TblAppliCustAccountInfo();
			TblCustAccountBussInfo t = DAOUtils.getTblCustAccountBussInfoDAO().get(xin.getId());
			BeanUtils.copyProperties(tacai, t);
			tacai.setAccountName(xin.getId().toString());
			tacai.setAccountType(xin.getAccountType());
			tacai.setId(null);
			tacai.setConfirmStatus(SCFConstants.LOANBAIL_CONFIRM_STATUS_DISING);
			tacai.setAppno(cont.getAppno());
			tacai.setProtocolNo(cont.getProtocolNo());//数据库表新增协议号字段，赋值
			result.add(tacai);

		}
		return result;
	}
*/
	/**
	 * DESCRIPTION:保存或修改tblAppliCustAccountInfoList
	 * @author QUANYU.SI
	 * @date 2012-6-16
	 * updateOrUpdateTblAppliCustAccountInfo 方法
	 * @param tblAppliCustAccountInfoList
	 */
//	public void updateOrUpdateTblAppliCustAccountInfo(List tblAppliCustAccountInfoList){
//		for(int i = 0 ;i<tblAppliCustAccountInfoList.size() ; i++){
//			TblAppliCustAccountInfo t = new TblAppliCustAccountInfo();
//			t = (TblAppliCustAccountInfo) tblAppliCustAccountInfoList.get(i);
//			Integer id = t.getId();
//			if(id==null || id==0){
//				id = this.getSeqPK(SCFConstants.VALUE_NO_SEQ_TBL_ID, SCFConstants.VALUE_INDEX_CUSTACCOUNT_ID);
//				t.setId(id);
//			}
//			SCFDAOUtils.getTblAppliCustAccountInfoDAO().saveOrUpdate(t);
//		}
//	}

	/**
	 * DESCRIPTION:删除tblAppliCustAccountInfoList
	 * @author QUANYU.SI
	 * @date 2012-6-16
	 * deleteTblAppliCustAccountInfo 方法
	 * @param tblAppliCustAccountInfoList
	 */
//	public void deleteTblAppliCustAccountInfo(List tblAppliCustAccountInfoList){
//		for(int i = 0 ;i<tblAppliCustAccountInfoList.size() ; i++){
//			TblAppliCustAccountInfo t = new TblAppliCustAccountInfo();
//			t = (TblAppliCustAccountInfo) tblAppliCustAccountInfoList.get(i);
//			SCFDAOUtils.getTblAppliCustAccountInfoDAO().delete(t);
//		}
//	}

	/**
	 * DESCRIPTION:检验解押现金等价物后是否可以覆盖敞口
	 * @author QUANYU.SI
	 * @date 2012-5-18
	 * checkDismortgageLnci 方法
	 * @param listTblLnciAmt
	 * @param lnciList
	 * @return
	 * @throws ScubeBizException
	 */
//	public String checkDismortgageLnci(OldApplyVO cont,List lnciList,String Dismortgagemodel) throws ScubeBizException{
//
//		String warnString = "ok";
////		BigDecimal account = new BigDecimal(0);
//		//如果是池模式，检验敞口
////		if(SCFConstants.ARRIVED_MANAGE_MODE_01.equals(Dismortgagemodel)){
////			BigDecimal dismortBailAmount=cont.getDismortBailAmount();//本次解押总金额
////			//计算敞口
////			AmountVO amountVO=new AmountVO(cont.getSupplyChainPdId(),cont.getProtocolNo());
////			BigDecimal amount =	AmountService.getInstance().getTotalAmount(amountVO,SCFConstants.CALCULATE_MODEL_3,SCFConstants.RETURN_MODEL_1);//不含押品的敞口
////			if(dismortBailAmount!=null&&amount!=null){
////				if(dismortBailAmount.compareTo(amount)>0){
////					warnString= "解押现金等价物'"+dismortBailAmount+"'后，协议池押品质押值加保证金及其等价物价值不能覆盖池业务敞口！";
////				}
////			}
////		}
////		if (SCFConstants.ARRIVED_MANAGE_MODE_02.equals(Dismortgagemodel)){
////			for(int j = 0 ; j<lnciList.size(); j++){
////			//如果是单笔模式，分个校验借据敞口
////				BigDecimal totalRemainAmount = ((OldApplyVO)lnciList.get(j)).getBillsAmountView()==null?new BigDecimal(0):((OldApplyVO)lnciList.get(j)).getBillsAmountView();//该借据的本次解押现金及其等价物价值
////				//计算敞口
////				AmountVO amountVO=new AmountVO(cont.getSupplyChainPdId(),cont.getProtocolNo(),
////						((OldApplyVO)lnciList.get(j)).getDebetNo(),null);
////				BigDecimal amount =	AmountService.getInstance().getTotalAmount(amountVO,SCFConstants.CALCULATE_MODEL_3,SCFConstants.RETURN_MODEL_1);//不含押品的敞口
////				if(totalRemainAmount!=null&&amount!=null){
////					if(totalRemainAmount.compareTo(amount)>0){
////						warnString= "借据/银承"+((OldApplyVO)lnciList.get(j)).getDebetId()+"解押现金等价物'"+totalRemainAmount+"'后，单笔押品质押值加保证金及其等价物价值不能覆盖单笔业务敞口！";
////					}
////				}
//
////				BigDecimal totalRemainAmount = ((OldApplyVO)lnciList.get(j)).getBillsAmountView()==null?new BigDecimal(0):((OldApplyVO)lnciList.get(j)).getBillsAmountView();//本次解押现金及其等价物价值
////				TblLnciBaseInfo lnci = DAOUtils.getMsTblLnciBaseInfoDAO().get(((OldApplyVO)lnciList.get(j)).getDebetNo());
////				BigDecimal refundAmount = lnci.getRefundAmount();
////				if(refundAmount.subtract(totalRemainAmount).floatValue()<0){
////					ExceptionUtil.throwAppException("本次解押现金及其等价物价值不能大于追加现金及其等价物",
////						SCFErrorCode.ERROR_CODE_DATA_INPUT_ERR);
////				}
////				if(totalRemainAmount.floatValue()!=0){
////					account = totalRemainAmount.add(account);
////					// 0        1       2                           3                   4
////					//debetNo,--lnciBal,amountIn,------------------bailAmount,-------refundAmount
////					//借据号-借据余额-单笔押品价值*质押率(剩余提货金额)-初始现金及其等价物价值-追加现金及其等价物价值
////					//debetNo,lnciBal,  amountIn,                    bailAmount,       refundAmount
////					BigDecimal lnciBal = lnci.getLnciBal()==null?new BigDecimal(0):lnci.getLnciBal();
////					/*BigDecimal amountIn = new BigDecimal(0);
////					if("02".equals(Dismortgagemodel)){
////					差额回购-----本次解押现金及其等价物价值 <=（单笔押品价值*质押率 + 初始现金及其等价物价值+追加现金及其等价物价值- 借据余额）
////					质押监管-----本次解押现金及其等价物价值 <=（初始现金及其等价物价值+追加现金及其等价物价值- 借据余额）
////						amountIn = new BigDecimal(0);
////					}else{
////						amountIn = lnci.getAmountIn()==null?new BigDecimal(0):lnci.getAmountIn();
////					}*/
////					BigDecimal bailAmount = lnci.getBailAmount()==null?new BigDecimal(0):lnci.getBailAmount();
////
////					if(totalRemainAmount.floatValue()>bailAmount.add(refundAmount).subtract(lnciBal).floatValue()){
////						if("ok".equals(warnString)){
////							warnString = "借据/银承"+lnci.getDebetId()+"解押现金等价物价值"+totalRemainAmount.toString()+"解押 ，单笔押品质押值加保证金及其等价物价值不能覆盖单笔业务敞口！";
////						}else{
////							warnString = warnString+ "借据/银承"+lnci.getDebetId()+"解押现金等价物价值"+totalRemainAmount.toString()+"解押，单笔押品质押值加保证金及其等价物价值不能覆盖单笔业务敞口！";
////						}
////					}
////				}else{
////					continue;
//////				}
////			}
////		}
//		return warnString;
//	}

	/**
	 * DESCRIPTION:修改临时表中借据信息的金额
	 * @author QUANYU.SI
	 * @date 2012-6-7
	 * backResetTblAppliBussDetail 方法
	 * @param lnci
	 * @param cont
	 * @return
	 */
	/*public List backResetTblAppliBussDetail(List lnci,OldApplyVO cont){
		StringBuffer sb = new StringBuffer();
		sb.append("select po from TblAppliBussDetail po where po.appno='"+cont.getAppno()+"'");
		List queryLnci = DAOUtils.getTblAppliBussDetailDAO().find(sb.toString());
		for(int i = 0 ; i<queryLnci.size() ; i++){
			((TblAppliBussDetail) queryLnci.get(0)).setDebetNo(((OldApplyVO)lnci.get(0)).getDebetNo());
			for(int j = 0 ; j<lnci.size() ; j++){
				TblAppliBussDetail tblAppliBussDetail = (TblAppliBussDetail) queryLnci.get(i);
				if(tblAppliBussDetail.getAppno().equals(cont.getAppno())
						&& tblAppliBussDetail.getDebetNo().equals(((OldApplyVO)lnci.get(j)).getDebetNo())){
					tblAppliBussDetail.setBillsAmountView(((OldApplyVO)lnci.get(j)).getBillsAmountView());
				}
			}
		}
		return queryLnci;
	}*/

	/**
	 * DESCRIPTION:现金等价物，更新借据临时信息到TblAppliBussDetail
	 * @author QUANYU.SI
	 * @date 2012-6-7
	 * updateTblAppliBussInfoDetail 方法
	 * @param listTblAppliBussInfo
	 */
//	public void updateTblAppliBussInfoDetail(List listTblAppliBussInfo){
//		for(int i = 0 ; i<listTblAppliBussInfo.size() ; i++){
//			TblAppliBussDetail tblAppliBussDetail = new TblAppliBussDetail();
//			tblAppliBussDetail = (TblAppliBussDetail) listTblAppliBussInfo.get(i);
//			SCFDAOUtils.getTblAppliBussDetailDAO().update(tblAppliBussDetail);
//		}
//	}

	/**
	 * DESCRIPTION:封装业务申请业务主表
	 * @author QUANYU.SI
	 * @date 2012-5-17
	 * setTblAppliBussInfo 方法
	 * @param cont
	 * @param bill
	 * @param lnci
	 * @return
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 * @throws ScubeBizException
	 */
	/*public TblAppliBussInfo setUpdateTblAppliBussInfo(OldApplyVO cont ,List bill ,List lnci) throws IllegalAccessException, InvocationTargetException, ScubeBizException{
		TblAppliBussInfo tabi = new TblAppliBussInfo();
		GlobalInfo gb = GlobalInfo.getCurrentInstance();

		StringBuffer sb = new StringBuffer();
		sb.append("select po from TblAppliBussInfo po where po.appno='"+cont.getAppno()+"'");
		List query = DAOUtils.getTblAppliBussInfoDAO().find(sb.toString());
		for(int i = 0 ; i<query.size() ; i++){
			tabi=(TblAppliBussInfo)query.get(i);

			tabi.setAmount(cont.getDismortBailAmount());
			tabi.setCustcdBuyer(((OldApplyVO)bill.get(0)).getCustcd());
			tabi.setBailType(cont.getBailType());
			tabi.setLoanType(cont.getLoanType());
			tabi.setLoanWay(cont.getDrawType());
		}
		return tabi;
	}*/

	/**
	 * DESCRIPTION:退回修改额度检查
	 * @author QUANYU.SI
	 * @date 2012-6-26
	 * dealBackToWriteCredit 方法
	 * @param lnciList
	 * @param CREDIT_OPERATION_TYPE
	 * @param amount
	 * @throws ScubeBizException
	 */
	/*public void dealBackToWriteCredit(List lnciList,String CREDIT_OPERATION_TYPE,BigDecimal amount) throws ScubeBizException{
		//现金等价物登记--09额度--恢复，现金等价物解押--10额度--占用
		if(lnciList != null && lnciList.size()>0){
			TblLnciBaseInfo lnci = DAOUtils.getTblLnciBaseInfoDAO().get(((OldApplyVO)lnciList.get(0)).getDebetNo());
			String creditTradeType = null ;
			if(SCFConstants.CREDIT_OPERATION_TYPE09.equals(CREDIT_OPERATION_TYPE)){
//				creditTradeType = SCFConstants.APPLY_TYPE_TRADE_04;
			}else if(SCFConstants.CREDIT_OPERATION_TYPE10.equals(CREDIT_OPERATION_TYPE)){
//				creditTradeType = SCFConstants.APPLY_TYPE_TRADE_02;
				amount=getCreditAmount(lnci,amount);
			}else{
				ExceptionUtil.throwScubeBizException("额度操作类型丢失！", SCFErrorCode.RECORD_NOT_EXIST);
			}
//			String operationType = SCFConstants.OPERATION_TYPE_01;
//			CreditService.getInstance().creditLnci(lnci, creditTradeType, operationType, SCFConstants.CREDIT_OPERATION_TYPE10, amount);
		}else{
			ExceptionUtil.throwScubeBizException("借据信息丢失！", SCFErrorCode.RECORD_NOT_EXIST);
		}
	}*/

	/**
	 * 得到序号，不推荐使用该方法
	 * @Deprecated
	 * @param valueNo
	 * @param valueIndex
	 * @return
	 * @throws ScubeBizException
	 */
	/** modify by shen_antonio 20091009 jira:BMS-2059 begin .
	 * @throws ScubeBizException */
//	protected synchronized int getSeqPK(int valueNo, String valueIndex){
//		Integer id = null;
//		try {
//			id = getSeqno(valueNo,valueIndex);
//			if(id==null){
//				ExceptionUtil.throwScubeBizException("主键获取失败！");
//			}
//		} catch (ScubeBizException e) {
//			e.printStackTrace();
//		}
//			return id;
//	}

	/**
	 * DESCRIPTION:现金等价物质押解押信息
	 * @author MINGLIANG.WANG
	 * @date 2012-5-30
	 * getDismortgageBillQuery 方法
	 * @param commonQueryVO
	 * @return
	 * @throws ScubeBizException
	 * @param commonQueryVO
	 * @return
	 */
	// 大VO改造 comment by xiaolong.xiong 2013-07-13
	/*public PageQueryResult getDismortgageBillQuery(OldCommonQueryVO commonQueryVO) throws ScubeBizException {
		TblBussDetailDAO tblBussDetailDAO = DAOUtils.getTblBussDetailDAO();
		TblNoticeBillInfoDAO tblNoticeBillInfoDAO = DAOUtils.getTblNoticeBillInfoDAO();
		PageQueryResult pageQueryResult = null;
		if(WorkflowConstant.APPLI_TYPE_MORTGAGEBILL.equals(commonQueryVO.getApplyType_Q())){
			pageQueryResult = tblBussDetailDAO.getDismortgageBillQuery(commonQueryVO);
		}else if(WorkflowConstant.APPLI_TYPE_DISMORTGAGEBILL.equals(commonQueryVO.getApplyType_Q())){
			pageQueryResult = tblNoticeBillInfoDAO.getDismortgageBillQuery(commonQueryVO);
		}
    	return pageQueryResult;
    }*/

	/**
     * @Description: 获取最高额保证金金额信息
     * @author  mengjiajia
     * @Created 2012-9-25下午01:42:15
     * @param appno 申请号
     * @param slaveContno 抵质押合同号
     * @param supplyChainPdId 供应链产品类型
     * @return
     * @throws ScubeBizException
     */
	// 大VO改造 comment by xiaolong.xiong 2013-07-13
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override
	public Page getMaxBailAccountApplyInfo(String appno, String slaveContno,String supplyChainPdId) throws ScubeBizException{
		BigDecimal amount = null;
		BigDecimal npsBailAmount = null;
    	//获取申请信息
		if (!StringUtil.isEmpty(appno)) {
			BPbcAppliBaseInfo tblAppliBaseInfo = bpbcapplibaseinfoservice.findBPbcAppliBaseInfoByKey(appno);
			if (tblAppliBaseInfo == null) {
				throw new ScubeBizException("申请信息丢失", RBcpErrorConstant.RECORD_NOT_EXIST);
			}
			amount = tblAppliBaseInfo.getAmt();
			npsBailAmount = tblAppliBaseInfo.getAmt();
			supplyChainPdId = tblAppliBaseInfo.getSupplyChainPdId();
		}

		// 获取敞口
		AmountVO amountVO = new AmountVO(supplyChainPdId, slaveContno, null,null, ScfBasConstant.ARRIVED_MANAGE_MODE_POOL);
		com.huateng.scf.bas.pbc.model.AmountVO amountVO2 = new com.huateng.scf.bas.pbc.model.AmountVO();
		BeanUtils.copyProperties(amountVO, amountVO2);
		BigDecimal amt = amountService.getPant(amountVO2);
		// 获取最高额保证金信息
		List list = bmrnacctbussinfoservice.getAccount(slaveContno);
		Page result = new Page();
		List list1 = new ArrayList();
		if (list != null && list.size() > 0) {
			com.huateng.scf.bas.mrn.dao.model.BMrnAcctBussInfo bean = 
					(com.huateng.scf.bas.mrn.dao.model.BMrnAcctBussInfo) list.get(0);
//			OldContractVO vo = new OldContractVO();
//			vo.setBailAccountno(bean.getBailAccountno());
//			vo.setBailAmount(bean.getBailAmount());
//			vo.setAmt(amt);
			// 转出金额
//			if (amount != null) {
//				vo.setAmount(amount.toString());
//			}
//			vo.setNpsBailAmount(npsBailAmount);
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("bailAccountno", bean.getBailAccountno());
			map.put("bailAmount", bean.getBailAmount());
			map.put("amt", amt);
			// 转出金额
			if (amount != null) {
				map.put("amount", amount);
			}
			map.put("npsBailAmount", npsBailAmount);
			list1.add(map);
		} else {
			BCrrGntyCon contSlaveInfo = bcrrgntyconservice.findBCrrGntyConByConId(slaveContno);
//			OldContractVO vo = new OldContractVO();
			BCntMprotPartInfo partInfo = new BCntMprotPartInfo();
			partInfo = bcntmprotpartinfoservice.findCoreorCustByProtocolNo(contSlaveInfo.getPrtclNo(), ScfBasConstant.PROTOCOL_PART_ROLE_CREDIT);
//			if (partInfo != null) {
//				vo.setBailAccountno(partInfo.getBailActno());// 保证金账户
//			}
//			vo.setBailAmount(BigDecimal.ZERO);
//			vo.setAmt(amt);
			
			HashMap<String, Object> map = new HashMap<String, Object>();
			if (partInfo != null) {
				map.put("bailAccountno", partInfo.getBailActno());// 保证金账户
			}
			
			map.put("bailAmount", BigDecimal.ZERO);
			map.put("amt", amt);
			list1.add(map);
		}
		result.setRecords(list1);
		return result;
    }

    /**
	 * DESCRIPTION:保证金转入保存——池管理模式
	 *
	 * @author mengjiajia
	 * @date 2012-5-11 addBailTransferApply 方法
	 * @param contractMngVO
	 * @throws ScubeBizException
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public void saveBailTransferApply(OldContractVO contractVO)
			throws ScubeBizException {
		// 检测保证金账号在SCF数据库中是否存在
		if (StringUtil.isEmpty(contractVO.getBailAccountno())) {
			throw new ScubeBizException("保证金账号丢失", RBcpErrorConstant.RECORD_NOT_EXIST);
		}
		BailBussInfoVO vo = new BailBussInfoVO();
		vo.setBailAccountno(contractVO.getBailAccountno());
		vo.setProtocolNo(contractVO.getProtocolNo());
		vo.setSlaveContno(contractVO.getSlaveContno());
		vo.setBailType(ScfBasConstant.BAIL_TYPE_NORMAL);
		vo.setInitType(ScfBasConstant.INIT_TYPE_MAX);
		List bailList = bmrnacctbussinfoservice.getTblCustAccountBussInfoByBailAccountno(vo);
		BMrnAcctBussInfo tblCustAccountBussInfo = new BMrnAcctBussInfo();
		if (bailList != null && bailList.size() > 0) {
			// 保证金账号存在,更新客户账号信息表Tbl_Cust_Account_Info中的保证金金额和最后更新时间
			com.huateng.scf.bas.mrn.dao.model.BMrnAcctBussInfo acctBussInfo = 
					(com.huateng.scf.bas.mrn.dao.model.BMrnAcctBussInfo) bailList.get(0);
			BeanUtils.copyProperties(acctBussInfo, tblCustAccountBussInfo);
			// SCF保证金金额=前次保证金金额+本次转入保证金金额
			BigDecimal sumBailAmount = tblCustAccountBussInfo.getBailAmount().add(new BigDecimal(contractVO.getAmount()));
			tblCustAccountBussInfo.setBailAmount(sumBailAmount);
			tblCustAccountBussInfo.setLastUpdTime(new Date());;
			tblCustAccountBussInfo.setLastUpdTlrcd(ContextHolder.getUserInfo().getTlrNo());
			bmrnacctbussinfoservice.updateBMrnAcctBussInfo(tblCustAccountBussInfo);
		} else {
			// 保证金账号不存在,在客户账号信息表Tbl_Cust_Account_Info中插入一条记录
			contractVO.setBailType(ScfBasConstant.BAIL_TYPE_NORMAL);
			contractVO.setInitType(ScfBasConstant.INIT_TYPE_MAX);
			tblCustAccountBussInfo = this.addTblCustAccountInfo(contractVO);
		}
		// 保证金转入池管理模式记录流水
		BMrnBussInfo tblBussInfo = new BMrnBussInfo();
		if(tblCustAccountBussInfo!=null){
			tblBussInfo.setMastContno(tblCustAccountBussInfo.getMastContno());
			tblBussInfo.setSubContno(contractVO.getProtocolNo());
			tblBussInfo.setBailType(tblCustAccountBussInfo.getBailType());
			tblBussInfo.setInitType(tblCustAccountBussInfo.getInitType());
			tblBussInfo.setAccountno(tblCustAccountBussInfo.getBailAccountno());//保证金账号
			tblBussInfo.setCustcdBuyer(tblCustAccountBussInfo.getCustcd());//客户号
			tblBussInfo.setBrcode(tblCustAccountBussInfo.getBrcode());//登记机构
			tblBussInfo.setSlaveContno(tblCustAccountBussInfo.getSlaveContno());//抵质押合同号
		}
		tblBussInfo.setAmount(new BigDecimal(contractVO.getAmount()));// 转入金额
		tblBussInfo.setAppDate(new Date());
		tblBussInfo.setBussType(contractVO.getSupplyChainPdId());
		tblBussInfo.setBrcode(ContextHolder.getOrgInfo().getBrNo());// 当前机构
		tblBussInfo.setTlrcd(ContextHolder.getUserInfo().getTlrNo());// 当前操作员
		tblBussInfo.setAppno(contractVO.getAppno());
		tblBussInfo.setApplyType(WorkflowConstant.APPLI_TYPE_BAILTRANSFERAPPLY);
		tblBussInfo.setId(null);
		bmrnbussinfoservice.save(tblBussInfo);
	}

	/**
	 * DESCRIPTION:新增户账号信息
	 *
	 * @author mengjiajia
	 * @date 2012-5-14 addTblCustAccountInfo 方法
	 * @param contractMngVO
	 * @throws ScubeBizException
	 */
	public BMrnAcctBussInfo addTblCustAccountInfo(OldContractVO contractMngVO)
			throws ScubeBizException {
		// 在客户账号信息表Tbl_Cust_Account_Info中插入一条记录
		BMrnAcctBussInfo tblCustAccountBussInfo = new BMrnAcctBussInfo();
		tblCustAccountBussInfo.setBailAccountno(contractMngVO.getBailAccountno());// 保证金账号
		tblCustAccountBussInfo.setBailAmount(new BigDecimal(contractMngVO.getAmount()));// 转入保证金金额
		tblCustAccountBussInfo.setCustcd(contractMngVO.getCustcd());// 客户号
		tblCustAccountBussInfo.setBailType(contractMngVO.getBailType());// 保证金等价物类型
		tblCustAccountBussInfo.setInitType(contractMngVO.getInitType());// 保证金等价物质押类型
		tblCustAccountBussInfo.setBailRate(new BigDecimal("100"));// 保证金等价物质押率(%)
		tblCustAccountBussInfo.setLastUpdTime(new Date());;
		tblCustAccountBussInfo.setLastUpdTlrcd(ContextHolder.getUserInfo().getTlrNo());
		tblCustAccountBussInfo.setConfirmStatus(ScfBasConstant.CONFIRM_STATUS_CONFIRMED);
		tblCustAccountBussInfo.setBrcode(ContextHolder.getOrgInfo().getBrNo());
		//新增时把借据号传入客户账户表
		tblCustAccountBussInfo.setDebetNo(contractMngVO.getDebetNo());//借据号
		tblCustAccountBussInfo.setProtocolNo(contractMngVO.getProtocolNo());//协议号
		tblCustAccountBussInfo.setSlaveContno(contractMngVO.getSlaveContno());//抵质押合同号
		tblCustAccountBussInfo.setMastContno(contractMngVO.getMastContno());//主合同号
		tblCustAccountBussInfo.setCurcd(contractMngVO.getCurcd());//币种
		bmrnacctbussinfoservice.save(tblCustAccountBussInfo);
		return tblCustAccountBussInfo;
	}

	/**
	 * @Description: 最高额保证金申请填写
	 * @author  mengjiajia
	 * @Created 2012-9-25下午03:05:35
	 * @param vo
	 * @throws ScubeBizException
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public void saveBailTransferOutWriteNew(OldContractVO vo) throws ScubeBizException {
		//保证金转出申请信息保存至TBL_APPLI_BASE_INFO[业务申请基本信息表]
    	BPbcAppliBaseInfo tblAppliBaseInfo = bpbcapplibaseinfoservice.findBPbcAppliBaseInfoByKey(vo.getAppno());
    	if(tblAppliBaseInfo==null){
    		throw new ScubeBizException("申请信息获取失败！", RBcpErrorConstant.RECORD_NOT_EXIST);
    	}
    	tblAppliBaseInfo.setBailAmount(vo.getBailAmount()); 	  //保证金质押登记总金额
    	tblAppliBaseInfo.setAmt(new BigDecimal(vo.getAmount())); 		          //申请转出金额
    	//TODO 敞口余额字段缺失
//    	tblAppliBaseInfo.setRiskamt(vo.getAmt());//敞口余额
    	bpbcapplibaseinfoservice.updateBPbcAppliBaseInfo(tblAppliBaseInfo);
		//校验申请转出金额是否小于等于保证金质押登记总金额
		if(vo.getBailAmount()!=null&&vo.getAmount()!=null){
			if(new BigDecimal(vo.getAmount()).compareTo(vo.getBailAmount())>0){
				throw new ScubeBizException("申请转出保证金金额不能超过保证金质押登记总金额！", RBcpErrorConstant.ERROR_CODE_DATA_INPUT_ERR);
			}
		}
//		AmountVO amountVO=new AmountVO(tblAppliBaseInfo.getSupplyChainPdId(),vo.getProtocolNo());
//		BigDecimal amount =	AmountService.getInstance().getTotalAmount(amountVO,SCFConstants.CALCULATE_MODEL_3,SCFConstants.RETURN_MODEL_1);//不含押品的敞口
//		if(vo.getAmount()!=null&&amount!=null){
//			if(vo.getAmount().compareTo(amount)>0){
//				ExceptionUtil.throwAppException("转出保证金'"+vo.getAmount()+"'后，协议池押品质押值加保证金及其等价物价值不能覆盖池业务敞口！",
//						SCFErrorCode.ERROR_CODE_DATA_INPUT_ERR);
//			}
//		}
    	//保证金转出申请信息保存至TBL_APPLI_BUSS_INFO【业务申请业务主表】
    	RBcpAppliBussInfo tblAppliBussInfo = null;
    	List list = rbcpapplibussinfoservice.findByProperty(vo.getAppno());
    	if(list.size()>0)
    	{
    		tblAppliBussInfo = (RBcpAppliBussInfo) list.get(0);
    	}
    	if(tblAppliBussInfo==null){											  //新增
    		tblAppliBussInfo = new RBcpAppliBussInfo();
        	tblAppliBussInfo.setAppno(vo.getAppno());
        	//申请号
        	tblAppliBussInfo.setCustcdBuyer(vo.getCustcd());
        	tblAppliBussInfo.setAppDate(ScfDateUtil.getStringDate(new Date()));
        	tblAppliBussInfo.setMastContno(vo.getMastContno());
        	tblAppliBussInfo.setBussType(vo.getSupplyChainPdId());
        	tblAppliBussInfo.setApplyType(tblAppliBaseInfo.getAppliType());
        	tblAppliBussInfo.setBailType(ScfBasConstant.BAIL_TYPE_NORMAL);		  //保证金等价物类型
        	tblAppliBussInfo.setInitType(ScfBasConstant.INIT_TYPE_MAX);		  //保证金等价物质押类型
        	tblAppliBussInfo.setBailAmt(vo.getBailAmount());		  //保证金质押登记总金额
        	tblAppliBussInfo.setBailAccount(vo.getBailAccountno());//保证金账号
        	tblAppliBussInfo.setAmount(new BigDecimal(vo.getAmount()));//转出金额
        	tblAppliBussInfo.setTotalDebtAmount(vo.getAmt());//敞口余额
        	tblAppliBussInfo.setToPoolAmount(vo.getNpsBailAmount());//核心金额
        	tblAppliBussInfo.setId(null);
        	rbcpapplibussinfoservice.save(tblAppliBussInfo);
    	}else{																  //更新
    		tblAppliBussInfo.setBailAmt(vo.getBailAmount());		  //保证金质押登记总金额
        	tblAppliBussInfo.setBailAccount(vo.getBailAccountno());//保证金账号
        	tblAppliBussInfo.setAmount(new BigDecimal(vo.getAmount()));//转出金额
        	tblAppliBussInfo.setTotalDebtAmount(vo.getAmt());//敞口余额
        	tblAppliBussInfo.setToPoolAmount(vo.getNpsBailAmount());//核心金额
        	rbcpapplibussinfoservice.update(tblAppliBussInfo);
    	}

	}

	/**
	 * @Description: 根据查询条件查询流水详情表
	 * @author liu-zhengzong
	 * @Created 2012-9-26下午01:32:49
	 * @param commonQueryVO
	 * @return
	 * @throws ScubeBizException
	 */
	// 大VO改造 comment by xiaolong.xiong 2013-07-13
	/*public PageQueryResult getBussDetailByParam(OldCommonQueryVO commonQueryVO) throws ScubeBizException {
		TblBussDetailDAO dao = DAOUtils.getTblBussDetailDAO();
		PageQueryResult queryResult = dao.getBussInfoByParam(commonQueryVO);
    	return queryResult;
    }*/

	/**
	 * 描述：保存现金等价物维护申请涉及的业务申请基本表，返回APPNO
	 * @param contractVO
	 * @param businessnoType
	 * @param workApplyType
	 * @return
	 * @throws ScubeBizException
	 * @date 2013-6-24
	 * @author mengjiajia
	 */
	@Override
	public String saveApplyBaseInfo(CashEqualValueContractVO contractVO,String businessnoType,String workApplyType) throws ScubeBizException{
		// 现金等价物维护流程-维护TBL_APPLI_BASE_INFO[业务申请基本信息表]
		String appno = bpbcapplibaseinfoservice.saveApplyBaseInfo(contractVO,businessnoType,workApplyType);
		return appno;
	}

	/**
	 * 描述：额度处理
	 * @param lnci
	 * @param CREDIT_OPERATION_TYPE
	 * @param amount
	 * @throws ScubeBizException
	 * @date 2013-6-24
	 * @author zhonghuabin
	 */
//	public void dealCredit(TblLnciBaseInfo lnci,String CREDIT_OPERATION_TYPE,BigDecimal amount) throws ScubeBizException{
//		//现金等价物登记--09额度--恢复，现金等价物解押--10额度--占用
//		if(lnci != null){
//			if(SCFConstants.CREDIT_OPERATION_TYPE09.equals(CREDIT_OPERATION_TYPE)){
//				//creditTradeType = SCFConstants.APPLY_TYPE_TRADE_04;
//			}else if(SCFConstants.CREDIT_OPERATION_TYPE10.equals(CREDIT_OPERATION_TYPE)){
//				//creditTradeType = SCFConstants.APPLY_TYPE_TRADE_02;
//				amount = getCreditAmount(lnci,amount);
//			}else{
//				ExceptionUtil.throwScubeBizException("额度操作类型丢失！", SCFErrorCode.RECORD_NOT_EXIST);
//			}
//		}
//	}
//
//	public TblLnciBaseInfo getTblLnciBaseInfo(String debetNo){
//		TblLnciBaseInfo tblLnciBaseInfo = new TblLnciBaseInfo();
//		tblLnciBaseInfo = SCFDAOUtils.getTblLnciBaseInfoDAO().get(debetNo);
//		return tblLnciBaseInfo;
//	}

	/**
	 * 描述：现金等价物借据更新
	 * @param modifyList
	 * @return
	 * @throws ScubeBizException
	 * @date 2013-6-24
	 * @author zhonghuabin
	 */
//	public ArrayList<TblLnciBaseInfo> cashEqualValueInfoUpdate(List modifyList) throws ScubeBizException {
//		//更新借据信息
//		TblLnciBaseInfoDAO tblLnciBaseInfoDAO = SCFDAOUtils.getTblLnciBaseInfoDAO();
//		return tblLnciBaseInfoDAO.updTblLnciBaseInfo(modifyList);
//	}

	/**
	 * 描述：现金等价物填写
	 * @param cont
	 * @param lnciList
	 * @return
	 * @throws ScubeBizException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @date 2013-6-24
	 * @author zhonghuabin
	 */
	/*public String writeCashEqualValue(CashEqualValueContractVO cont ,List lnciList) throws ScubeBizException, IllegalAccessException, InvocationTargetException{
		String warnString = "ok";

		//为防止协议号和产品类型为空，以下代码会查询协议表，取得协议号及产品类型
		TblContBaseInfo tblContBaseInfo = SCFDAOUtils.getTblContBaseInfoDAO().get(cont.getMastContno());
		if (tblContBaseInfo == null){
			return null;
		}
		cont.setProtocolNo(tblContBaseInfo.getProtocolNo());//设置协议号
		cont.setSupplyChainPdId(tblContBaseInfo.getSupplyChainPdId());//设置产品类型
//		TblAppliBussInfo tabi = new TblAppliBussInfo();
//		GlobalInfo gb = GlobalInfo.getCurrentInstance();
//		tabi.setAppno(cont.getAppno());
//		tabi.setApplyType(WorkflowConstant.APPLI_TYPE_CASHEQUALVALUE);//现金等价物维护申请
//		tabi.setCustcdBuyer(cont.getCustcd());
//		tabi.setMastContno(cont.getMastContno());
//		tabi.setBussType(WorkflowConstant.APPLI_TYPE_CASHEQUALVALUE);
//		tabi.setLoanType(cont.getLoanType());
//		tabi.setLoanWay(cont.getLoanWay());
//		if("02".equals(cont.getSupplyChainPdId())){
//			tabi.setDebetNo(((CashEqualValueContractVO)lnciList.get(0)).getDebetNo());
//		}
//		tabi.setBrcode(gb.getBrcode());						  //当前机构
//		tabi.setTlrcd(gb.getTlrno());						  //当前名称
//		tabi.setBailAccount(cont.getBailAmount().toString());
//		tabi.setAmount(cont.getBailAmount());
//		tabi.setConfirmStatus(SCFConstants.LOANBAIL_CONFIRM_STATUS_APPLY);
//		tabi.setLastUptTime(DateUtil.getCurrentDate());
//		DAOUtils.getTblAppliBussInfoDAO().save(tabi);

//		List tblAppliBussDetailList = new ArrayList();
		List<TblAppliCustAccountInfo> appliCustAccountlist = new ArrayList();
		for(int i = 0 ; i<lnciList.size() ; i++){
//			TblAppliBussDetail tblAppliBussDetail = new TblAppliBussDetail();
//			tblAppliBussDetail.setAppno(cont.getAppno());
//			tblAppliBussDetail.setMastContno(cont.getMastContno());
//			tblAppliBussDetail.setDebetNo(((CashEqualValueContractVO)lnciList.get(i)).getDebetNo());
//			tblAppliBussDetail.setBillsAmountView(new BigDecimal(0));
//			tblAppliBussDetailList.add(tblAppliBussDetail);

			TblAppliCustAccountInfo tacai = new TblAppliCustAccountInfo();
			tacai.setAppno(cont.getAppno());
			tacai.setCustcd(cont.getCustcd());
			tacai.setMastContno(cont.getMastContno());
			tacai.setConfirmStatus(SCFConstants.LOANBAIL_CONFIRM_STATUS_APPLY);//申请中
			tacai.setAmount(((CashEqualValueContractVO)lnciList.get(i)).getAfterAddBailAmount());
			tacai.setBailAmount(tacai.getAmount());
			tacai.setBailRate(new BigDecimal(100));
			tacai.setLastUpdateDate(DateUtil.getCurrentDate());
			tacai.setLastUpdateTlrcd(GlobalInfo.getCurrentInstance().getTlrno());
			tacai.setBrcode(GlobalInfo.getCurrentInstance().getBrcode());
			tacai.setProtocolNo(cont.getProtocolNo());//数据库表新增协议号字段，赋值
			tacai.setDebetNo(((CashEqualValueContractVO)lnciList.get(i)).getDebetNo());
			tacai.setCurcd(cont.getCurcd());
			appliCustAccountlist.add(tacai);
		}
//		saveTblAppliBussInfoDetail(tblAppliBussDetailList);
		SCFDAOUtils.getTblAppliCustAccountInfoDAO().saveAll(appliCustAccountlist);
		return warnString;
	}*/

	/**
	 * 描述：现金等价物填写更新
	 * @param cont
	 * @param lnciList
	 * @return
	 * @throws ScubeBizException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @date 2013-6-25
	 * @author zhonghuabin
	 */
	/*public String updateCashEqualValue(CashEqualValueContractVO cont ,List lnciList) throws ScubeBizException, IllegalAccessException, InvocationTargetException{
		String warnString = "ok";

		//为防止协议号和产品类型为空，以下代码会查询协议表，取得协议号及产品类型
		TblContBaseInfo tblContBaseInfo = SCFDAOUtils.getTblContBaseInfoDAO().get(cont.getMastContno());
		if (tblContBaseInfo == null){
			return null;
		}
		cont.setProtocolNo(tblContBaseInfo.getProtocolNo());//设置协议号
		cont.setSupplyChainPdId(tblContBaseInfo.getSupplyChainPdId());//设置产品类型
//		PageQueryResult pageQueryResult = DAOUtils.getTblAppliBussInfoDAO().getTblAppliBussInfoByParam(cont);
//		if(pageQueryResult!=null && pageQueryResult.getTotalCount()>0){
//			TblAppliBussInfo tabi = (TblAppliBussInfo)pageQueryResult.getQueryResult().get(0);
//			GlobalInfo gb = GlobalInfo.getCurrentInstance();
//			tabi.setBrcode(gb.getBrcode());						  //当前机构
//			tabi.setTlrcd(gb.getTlrno());						  //当前名称
//			tabi.setBailAccount(cont.getBailAmount().toString());
//			tabi.setAmount(cont.getBailAmount());
//			tabi.setLastUptTime(DateUtil.getCurrentDate());
//			DAOUtils.getTblAppliBussInfoDAO().update(tabi);
//		}

//		List tblAppliBussDetailList = new ArrayList();
		//先全部删除该申请号之前已保存的申请记录信息
		SCFDAOUtils.getTblAppliCustAccountInfoDAO().deleteByAppno(cont.getAppno());

		List<TblAppliCustAccountInfo> appliCustAccountlist = new ArrayList();
		for(int i = 0 ; i<lnciList.size() ; i++){
//			TblAppliBussDetail tblAppliBussDetail = new TblAppliBussDetail();
//			tblAppliBussDetail.setAppno(cont.getAppno());
//			tblAppliBussDetail.setDebetNo(((CashEqualValueContractVO)lnciList.get(i)).getDebetNo());
//			tblAppliBussDetail.setBillsAmountView(new BigDecimal(0));
//			tblAppliBussDetailList.add(tblAppliBussDetail);

//			tacai = DAOUtils.getTblAppliCustAccountInfoDAO().getTblAliCustAccInfoByAppnoAndDebetNo(cont.getAppno(),
//							((CashEqualValueContractVO) lnciList.get(i)).getDebetNo());
//			if (tacai != null && !DataFormat.isEmpty(tacai.getAppno())){
//				tacai.setAmount(((CashEqualValueContractVO)lnciList.get(i)).getAfterAddBailAmount());
//				tacai.setBailAmount(tacai.getAmount());
//				tacai.setLastUpdateDate(DateUtil.getCurrentDate());
//				tacai.setBrcode(GlobalInfo.getCurrentInstance().getBrcode());
//			}

			TblAppliCustAccountInfo tacai = new TblAppliCustAccountInfo();
			tacai.setAppno(cont.getAppno());
			tacai.setCustcd(cont.getCustcd());
			tacai.setMastContno(cont.getMastContno());
			tacai.setConfirmStatus(SCFConstants.LOANBAIL_CONFIRM_STATUS_APPLY);//申请中
			tacai.setAmount(((CashEqualValueContractVO)lnciList.get(i)).getAfterAddBailAmount());
			tacai.setBailAmount(tacai.getAmount());
			tacai.setBailRate(new BigDecimal(100));
			tacai.setLastUpdateDate(DateUtil.getCurrentDate());
			tacai.setLastUpdateTlrcd(GlobalInfo.getCurrentInstance().getTlrno());
			tacai.setBrcode(GlobalInfo.getCurrentInstance().getBrcode());
			tacai.setProtocolNo(cont.getProtocolNo());//数据库表新增协议号字段，赋值
			tacai.setDebetNo(((CashEqualValueContractVO)lnciList.get(i)).getDebetNo());
			tacai.setCurcd(cont.getCurcd());
			appliCustAccountlist.add(tacai);
		}
//		saveTblAppliBussInfoDetail(tblAppliBussDetailList);
		SCFDAOUtils.getTblAppliCustAccountInfoDAO().saveAll(appliCustAccountlist);
		return warnString;
	}

	public void saveCashEqualValueInfo(CommonApplyDtlInfoVO commAppInfoVo) throws ScubeBizException{
		CashEqualValueContractVO contractVO = new CashEqualValueContractVO();
		contractVO.setAppno(commAppInfoVo.getBussAppno());
		contractVO.setDescription("现金等价物维护审批同意");
		SCFDAOUtils.getTblAppliBaseInfoDAO().saveApplyBaseInfo(contractVO, "", "");

		List<TblAppliCustAccountInfo> tacaiList = SCFDAOUtils.getTblAppliCustAccountInfoDAO()
				.getTblAppliCustAccountInfoByAppno(commAppInfoVo.getBussAppno());
		List<TblAppliCustAccountInfo> tacaiUpdateList = new ArrayList();
		List<TblLnciBaseInfo> lnciList = new ArrayList();
		for(int i = 0 ; i<tacaiList.size() ; i++){
			TblAppliCustAccountInfo tacai = tacaiList.get(i);
			tacai.setConfirmStatus(SCFConstants.LOANBAIL_CONFIRM_STATUS_APPROVE);//已审批
			tacai.setLastUpdateDate(DateUtil.getCurrentDate());
			tacai.setLastUpdateTlrcd(GlobalInfo.getCurrentInstance().getTlrno());
			tacaiUpdateList.add(tacai);

			//更新现金等价物信息
			TblCustAccountBussInfo tcaBussInfo = new TblCustAccountBussInfo();
			tcaBussInfo.setCustcd(tacai.getCustcd());//客户号
			tcaBussInfo.setMastContno(tacai.getMastContno());//合同号
			tcaBussInfo.setProtocolNo(SCFDAOUtils.getTblContBaseInfoDAO().get(tacai.getMastContno()).getProtocolNo());//设置关联协议号
			tcaBussInfo.setBailAccountno(tacai.getBailAccountno());//保证金或现金等价物账号
			tcaBussInfo.setBailAmount(tacai.getBailAmount());//保证金或现金等价物登记金额
			tcaBussInfo.setBailRate(tacai.getBailRate());//质押率
			tcaBussInfo.setBailType(tacai.getBailType());//现金等价物种类
			tcaBussInfo.setConfirmStatus(SCFConstants.LOANBAIL_CONFIRM_STATUS_APPROVE);
			tcaBussInfo.setDebetNo(tacai.getDebetNo());
			tcaBussInfo.setInitType(SCFConstants.INIT_TYPE_ADD);//追加
			tcaBussInfo.setId(this.getUUID());
			tcaBussInfo.setLastUpdateDate(DateUtil.getCurrentDate());
			tcaBussInfo.setLastUpdateTlrcd(GlobalInfo.getCurrentInstance().getTlrno());
			tcaBussInfo.setBrcode(tacai.getBrcode());
			tcaBussInfo.setCurcd(tacai.getCurcd());
			SCFDAOUtils.getTblCustAccountBussInfoDAO().save(tcaBussInfo);

			TblLnciBaseInfo tblLnciBaseInfo = new TblLnciBaseInfo();
			tblLnciBaseInfo = SCFDAOUtils.getTblLnciBaseInfoDAO().get(tacai.getDebetNo());
			BigDecimal addAmount = (tacai.getAmount() == null ? new BigDecimal(0) : tacai.getAmount())
				.subtract(tblLnciBaseInfo.getInitCashEqtAmt() == null ? new BigDecimal(0) : tblLnciBaseInfo.getInitCashEqtAmt())
				.subtract(tblLnciBaseInfo.getAddCashEqtAmt() == null ? new BigDecimal(0) : tblLnciBaseInfo.getAddCashEqtAmt());
			if(addAmount.floatValue()>0){
				tblLnciBaseInfo.setAddCashEqtAmt((tacai.getAmount() == null ? new BigDecimal(0) : tacai.getAmount())
						.subtract(tblLnciBaseInfo.getInitCashEqtAmt() == null ? new BigDecimal(0) : tblLnciBaseInfo.getInitCashEqtAmt()));
				//如果增加现金等价物，则要调用额度公用方法，释放相关额度
				if(SCFConstants.HAS_INDIRECT_CREDIT_TRUE.equals(tblLnciBaseInfo.getHasIndirectCredit())){
					IndirectCreditService.getInstance().indirectCreditAppliCommonProcess(
									contractVO.getAppno(),tblLnciBaseInfo.getDebetNo(),
									SCFConstants.CREDIT_TRADE_TYPE_RELEASE,addAmount);
				}
			}else if (addAmount.floatValue()<0){
				if (Math.abs(addAmount.floatValue())-tblLnciBaseInfo.getAddCashEqtAmt().floatValue()>0){
//					ExceptionUtil.throwScubeBizException("本次更新后，借据:"+ tblLnciBaseInfo.getDebetId() + "中追加现金等价物金额小于零！",
//							SCFErrorCode.ERROR_CODE_DATA_INPUT_ERR);
					tblLnciBaseInfo.setAddCashEqtAmt(new BigDecimal(0));
					tblLnciBaseInfo.setInitCashEqtAmt(tacai.getAmount());
				}else{
					tblLnciBaseInfo.setAddCashEqtAmt(tacai.getAmount() == null ? new BigDecimal(0) : tacai.getAmount()
							.subtract(tblLnciBaseInfo.getInitCashEqtAmt() == null ? new BigDecimal(0) : tblLnciBaseInfo.getInitCashEqtAmt()));
				}
			}
			lnciList.add(tblLnciBaseInfo);
		}
		SCFDAOUtils.getTblAppliCustAccountInfoDAO().saveAll(tacaiUpdateList);
		//更新借据表信息
		SCFDAOUtils.getTblLnciBaseInfoDAO().updateAll(lnciList);
	}*/

	/**
	 * 描述：额度处理
	 * @param lnci
	 * @param CREDIT_OPERATION_TYPE
	 * @param amount
	 * @return
	 * @date 2013-6-27
	 * @author zhonghuabin
	 */
//	public BigDecimal getCashEquivalent(TblLnciBaseInfo lnci , String CREDIT_OPERATION_TYPE, BigDecimal amount){
//		BigDecimal result = new BigDecimal(0);
//		/*借据余额*/
//		BigDecimal lnciBal = lnci.getLnciBal()!=null?lnci.getLnciBal():new BigDecimal(0);
//		/*初始现金等价物金额*/
//		BigDecimal initCashEqtAmt = lnci.getInitCashEqtAmt()!=null?lnci.getInitCashEqtAmt():new BigDecimal(0);
//		/*追加现金等价物金额*/
//		BigDecimal addCashEqtAmt = lnci.getAddCashEqtAmt()!=null?lnci.getAddCashEqtAmt():new BigDecimal(0);
//		if (SCFConstants.CREDIT_OPERATION_TYPE10.equals(CREDIT_OPERATION_TYPE)){
//			if(lnciBal.subtract(initCashEqtAmt).subtract(addCashEqtAmt).floatValue()>0){
//				result = amount;
//			}else if(lnciBal.subtract(initCashEqtAmt).subtract(addCashEqtAmt).floatValue()<=0){
//				BigDecimal transate = new BigDecimal(0);
//				transate = amount.subtract(initCashEqtAmt).subtract(addCashEqtAmt).add(lnciBal);
//				result = transate.floatValue()>0?transate:new BigDecimal(0);
//			}
//		}
//		return result;
//	}

	/**
	 *
	 * @Description: 保证金信息列表查询
	 * @author mengjiajia
	 * @Created 2012-11-9下午02:35:53
	 * @param commonQueryVO
	 * @return
	 * @throws ScubeBizException
	 */
//	public Page getBailTransferQuery(BailTransferQryVO commonQueryVO) throws ScubeBizException 
//	{
//		Page pageQueryResult =SCFDAOUtils.getTblCustAccountBussInfoDAO()
//				.getBailBussInfo(commonQueryVO);
//		return pageQueryResult;
//	}

	@Override
	public Page getBailTransferQuery(OldCommonQueryVO commonQueryVO) throws ScubeBizException 
	{
		Page pageQueryResult = bmrnappliacctinfoservice.getBailTransferQuery(commonQueryVO);
		return pageQueryResult;
	}

	@Override
	public Page getBailTransferSerialQuery(OldCommonQueryVO commonQueryVO) throws ScubeBizException 
	{
		Page pageQueryResult = bmrnbussinfoservice.getBailTransferQuery(commonQueryVO);
    	return pageQueryResult;
    }

//	public Page bailTransferQuery(OldCommonQueryVO commonQueryVO) throws ScubeBizException 
//	{
//		TblAppliCustAccountInfoDAO InfoDAO = SCFDAOUtils.getTblAppliCustAccountInfoDAO();
//		Page pageQueryResult = InfoDAO.bailTransferQuery(commonQueryVO);
//		return pageQueryResult;
//	}

	/**
	 *
	 * @Description: 现金等价物登记 保存TblAppliLnciBaseInfo
	 * @author mengjiajia
	 * @Created 2014年2月21日下午11:24:15
	 * @param inAppno
	 * @param lncimodifyList
	 * @throws ScubeBizException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void saveAppliDetailInfo(String inAppno, List lncimodifyList) throws ScubeBizException {
		//delete
		List list = rbcpapplibussdtlservice.findByProperty(inAppno);
		if(list!=null&&list.size()>0){
			for(int i=0;i<list.size();i++){
				RBcpAppliBussDtl bean = (RBcpAppliBussDtl) list.get(i);
				rbcpapplibussdtlservice.delete(bean);
			}
		}
		//add
		RBcpAppliBussDtl appliInfo=null;
		if(null!=lncimodifyList){
			Iterator<DebtLnciBaseInfoVO> ite = lncimodifyList.iterator();
			while(ite.hasNext()){
				DebtLnciBaseInfoVO lnciBaseInfoVO=(DebtLnciBaseInfoVO)ite.next();
				appliInfo=new RBcpAppliBussDtl();
				BeanUtils.copyProperties(lnciBaseInfoVO, appliInfo);
				appliInfo.setId(null);
				appliInfo.setLoanRemainingAmount(lnciBaseInfoVO.getLnciBal());//借据余额
				appliInfo.setAddBailAmount(lnciBaseInfoVO.getAddCashEqtAmt());//追加现金等价物
				appliInfo.setAppno(inAppno);
//				appliInfo.setApplyType(WorkflowConstant.APPLI_TYPE_CASHEQUALREG_APPLY);太长
				rbcpapplibussdtlservice.save(appliInfo);
			}
		}


	}

	/**
	 *
	 * @Description: 现金等价物登记 保存 TblAppliCustAccountInfo
	 * @author mengjiajia
	 * @Created 2014年2月21日下午11:35:03
	 * @param inAppno
	 * @param insertList
	 * @throws ScubeBizException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void saveAppliCustAccountInfo(String inAppno, List insertList) throws ScubeBizException {
		UserInfo userInfo = ContextHolder.getUserInfo();
		BctlVO bctlVO = ContextHolder.getOrgInfo();
		//delete
		bmrnappliacctinfoservice.deleteByAppno(inAppno);
		List bussList = rbcpapplibussinfoservice.findByProperty(inAppno);
		if(bussList!=null&&bussList.size()>0){
			Iterator ite =bussList.iterator();
			while(ite.hasNext()){
				RBcpAppliBussInfo app = (RBcpAppliBussInfo)ite.next();
				rbcpapplibussinfoservice.deleteRBcpAppliBussInfo(app);
			}
		}
		//add
		BMrnAppliAcctInfo appliInfo=null;
		if(null!=insertList){
			Iterator<CashEqualVO> ite = insertList.iterator();
			while(ite.hasNext()){
				CashEqualVO eqlVO=(CashEqualVO)ite.next();
				appliInfo=new BMrnAppliAcctInfo();
				BeanUtils.copyProperties(eqlVO, appliInfo);
				appliInfo.setAppno(inAppno);
				appliInfo.setId(null);
				bmrnappliacctinfoservice.add(appliInfo);

				RBcpAppliBussInfo tabi = new RBcpAppliBussInfo();
				tabi.setAppno(inAppno);
				tabi.setApplyType(WorkflowConstant.APPLI_TYPE_CASHEQUALREG_APPLY);
				tabi.setCustcdBuyer(appliInfo.getCustcd());
				tabi.setMastContno(appliInfo.getMastContno());
				tabi.setBailType(appliInfo.getBailType());
				tabi.setBussType(WorkflowConstant.APPLI_TYPE_DISMORTGAGEBILL);
				tabi.setDebetNo(appliInfo.getDebetNo());
				tabi.setBrcode(bctlVO.getBrNo());						  //当前机构
				tabi.setTlrcd(userInfo.getTlrNo());						  //当前名称
				tabi.setBailAccount(appliInfo.getBailAmount().toString());
				tabi.setAmount(appliInfo.getBailAmount());
				tabi.setConfirmStatus(appliInfo.getConfirmStatus());
				tabi.setAppDate(ScfDateUtil.formatDate(new Date()));
				rbcpapplibussinfoservice.save(tabi);
			}
		}
	}

	/**
	 *
	 * @Description: 保存TblCustAccountBussInfo
	 * @author mengjiajia
	 * @Created 2014年2月22日下午4:17:29
	 * @param bussAppno
	 * @throws ScubeBizException
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public void saveTblCustAccountBussInfo(String bussAppno) throws ScubeBizException {
		UserInfo userInfo = ContextHolder.getUserInfo();
		BctlVO bctlVO = ContextHolder.getOrgInfo();
		List appList = bmrnappliacctinfoservice.findByProperty(bussAppno);
		BMrnAcctBussInfo bussInfo = null;
		if(null!=appList){
			Iterator ite =appList.iterator();
			while(ite.hasNext()){
				BMrnAppliAcctInfo appInfo =(BMrnAppliAcctInfo)ite.next();
				bussInfo =new BMrnAcctBussInfo();
				BeanUtils.copyProperties(appInfo, bussInfo);
				bussInfo.setId(null);
				bussInfo.setConfirmStatus("01");//已确认
				bussInfo.setLastUpdTime(new Date());;
				bussInfo.setLastUpdTlrcd(userInfo.getTlrNo());
				bussInfo.setInitType(ScfBasConstant.INIT_TYPE_ADD);
				bmrnacctbussinfoservice.save(bussInfo);
				
				RBcpAppliBussInfo tabi = new RBcpAppliBussInfo();
				tabi.setAppno(bussAppno);
				tabi.setApplyType(WorkflowConstant.APPLI_TYPE_CASHEQUALREG_APPLY);
				tabi.setCustcdBuyer(bussInfo.getCustcd());
				tabi.setMastContno(bussInfo.getMastContno());
				tabi.setBailType(bussInfo.getBailType());
				tabi.setBussType(WorkflowConstant.APPLI_TYPE_CASHEQUALREG_APPLY);
				tabi.setDebetNo(bussInfo.getDebetNo());
				tabi.setBrcode(bctlVO.getBrNo());						  //当前机构
				tabi.setTlrcd(userInfo.getTlrNo());						  //当前名称
				tabi.setBailAccount(bussInfo.getBailAmount().toString());
				tabi.setAmount(bussInfo.getBailAmount());
				tabi.setConfirmStatus(bussInfo.getConfirmStatus());
				tabi.setAppDate(ScfDateUtil.formatDate(new Date()));
				rbcpapplibussinfoservice.save(tabi);
			}
		}

	}

	/**
	 *
	 * @Description: update TblLnciBaseInfo
	 * @author mengjiajia
	 * @Created 2014年2月22日下午4:40:49
	 * @param bussAppno
	 * @throws ScubeBizException
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public void updateLnciBaseInfoWithCashEql(String bussAppno) throws ScubeBizException {
		List appList = rbcpapplibussdtlservice.findByProperty(bussAppno);
		if(null!=appList){
			Iterator ite=appList.iterator();
			while(ite.hasNext()){
				RBcpAppliBussDtl appInfo=(RBcpAppliBussDtl)ite.next();
				BLanLnciBase lnciInfo = blanlncibaseservice.findBLanLnciBaseByKey(appInfo.getDebetNo());
				BigDecimal cashEql=lnciInfo.getAddCashEqtAmt()!=null?
						lnciInfo.getAddCashEqtAmt():BigDecimal.ZERO;
				BigDecimal addCash=appInfo.getAddBailAmount()!=null?
						appInfo.getAddBailAmount():BigDecimal.ZERO;

				lnciInfo.setAddCashEqtAmt(cashEql.add(addCash));
				lnciInfo.setLockAppno(null);
				lnciInfo.setIsLocked("0");
				blanlncibaseservice.updateBLanLnciBase(lnciInfo);
				//如果增加现金等价物，则要调用额度公用方法，释放相关额度
				if(ScfBasConstant.HAS_INDIRECT_CREDIT_TRUE.equals(lnciInfo.getHasIndirectCredit())){
					bicrinfoservice.indirectCreditAppliCommonProcess(bussAppno,lnciInfo.getDebetNo(),
									ScfBasConstant.CREDIT_TRADE_TYPE_RELEASE,addCash);
				}
			}
		}
	}

	/**
	 *
	 * @Description: 保证金追加查询借据列表
	 * @author jialei.zhang
	 * @Created 2014年4月1日下午2:57:54
	 * @param vo
	 * @return
	 * @throws ScubeBizException
	 */
	/*public PageQueryResult getLnciList(LnciQryVO vo) throws ScubeBizException {
		PageQueryResult pageQueryResult=SCFDAOUtils.getTblLnciBaseInfoDAO()
				.getLnciByLnciQryVO(vo);
		if(pageQueryResult!=null && pageQueryResult.getTotalCount()>0){
			List resultList = new ArrayList();
			for (int i = 0; i < pageQueryResult.getQueryResult().size(); i++) {
				Object obj[] =(Object[])pageQueryResult.getQueryResult().get(i);
				TblLnciBaseInfo lnciBaseInfo = (TblLnciBaseInfo) obj[0];
				TblContBaseInfo cont=(TblContBaseInfo)obj[1];
				DebtLnciBaseInfoVO lnciVO = new DebtLnciBaseInfoVO();
				CommonFunction.copyProperties(lnciVO, lnciBaseInfo);
				lnciVO.setBusinessNo(SCFDAOUtils.getTblContBaseInfoDAO().get(lnciBaseInfo.getMastContno()).getBusinessNo());
				lnciVO.setTotBailAmt(lnciBaseInfo.getBailAmount()==null?BigDecimal.ZERO:lnciBaseInfo.getBailAmount()
						.add(lnciBaseInfo.getAddBailAmount()==null?BigDecimal.ZERO:lnciBaseInfo.getAddBailAmount()));
				lnciVO.setTotCashEqualAmt(lnciBaseInfo.getInitCashEqtAmt()==null?BigDecimal.ZERO:lnciBaseInfo.getInitCashEqtAmt()
						.add(lnciBaseInfo.getAddCashEqtAmt()==null?BigDecimal.ZERO:lnciBaseInfo.getAddCashEqtAmt()));
				lnciVO.setLnciRiskAmt((lnciBaseInfo.getLnciBal()==null?BigDecimal.ZERO:lnciBaseInfo.getLnciBal())
						.subtract(lnciVO.getTotBailAmt()==null?BigDecimal.ZERO:lnciVO.getTotBailAmt())
						.subtract(lnciVO.getTotCashEqualAmt()==null?BigDecimal.ZERO:lnciVO.getTotCashEqualAmt()));
				lnciVO.setBlnUpBrcode(SCFDataFormat.isEmpty(lnciVO.getBussBrcode()) ? "" : SCFDAOUtils.getBctlDAO()
						.get(lnciVO.getBussBrcode()).getBlnUpBrcode());
				lnciVO.setSupplyChainPdId(cont.getSupplyChainPdId());
				resultList.add(lnciVO);
			}
			pageQueryResult.setQueryResult(resultList);
		}
		return pageQueryResult;
	}*/

	/**
	 *
	 * @Description: 保证金追加冻结保存基本信息
	 * @author jialei.zhang
	 * @Created 2014年4月2日上午10:11:16
	 * @param bussVO
	 * @param appliTypeMarginApply
	 * @param procnameMarginApply
	 * @throws ScubeBizException
	 */
	/*public String saveMarginAppliBaseInfo(BailBussInfoVO bussVO, String procnameMarginApply, String appliTypeMarginApply) throws ScubeBizException {
		TblAppliBaseInfoDAO appliDAO=SCFDAOUtils.getTblAppliBaseInfoDAO();
		TblAppliBaseInfo appliBaseInfo =new TblAppliBaseInfo();
		GlobalInfo gb =GlobalInfo.getCurrentInstance();
		appliBaseInfo.setAppBrcode(gb.getBrcode());
		appliBaseInfo.setAppDate(gb.getTxdate());
		appliBaseInfo.setProcessTemplateName(procnameMarginApply);
		appliBaseInfo.setAppliType(appliTypeMarginApply);
		appliBaseInfo.setBusinessnoType(SCFConstants.BUSINESSNO_TYPE_CONTNO);
		appliBaseInfo.setBusinessno(bussVO.getSubContno());
		appliBaseInfo.setAppliStatus(WorkflowConstant.APPLI_STATUS_UNSUBMIT);         // 申请状态:未提交（默认）
		appliBaseInfo.setAppliStatusDtl(WorkflowConstant.APPLI_STATUS_DTL_WRITING); // 申请状态明细:未提交（默认）
		appliBaseInfo.setCustcd(bussVO.getCustcd());
		appliBaseInfo.setAppTlrcd(gb.getTlrno());
		appliBaseInfo.setBailAmount(bussVO.getBailAmount());
		appliBaseInfo.setExt1(bussVO.getNpsBailAmount().toString());
		appliBaseInfo.setSupplyChainPdId(bussVO.getSupplyChainPdId());
		appliDAO.save(appliBaseInfo);
		return appliBaseInfo.getAppno();
	}*/

	/**
	 *
	 * @Description: 保证金追加冻结 保存appliCustAccountInfo
	 * @author jialei.zhang
	 * @Created 2014年4月2日上午10:57:26
	 * @param inAppno
	 * @param bailList
	 * @throws ScubeBizException
	 */
	/*public void saveUpateAppliCustAccountInfo(String inAppno, List bailList) throws ScubeBizException {
		GlobalInfo gb=GlobalInfo.getCurrentInstance();
		TblAppliCustAccountInfoDAO appliDAO=SCFDAOUtils.getTblAppliCustAccountInfoDAO();
		TblLnciBaseInfoDAO lnciDAO =SCFDAOUtils.getTblLnciBaseInfoDAO();
		//delete
		appliDAO.deleteByAppno(inAppno);
		//add
		TblAppliCustAccountInfo appliInfo=null;
		if(null!=bailList){
			Iterator<BailBussInfoVO> ite =bailList.iterator();
			while(ite.hasNext()){
				BailBussInfoVO eqlVO=(BailBussInfoVO)ite.next();
				appliInfo=new TblAppliCustAccountInfo();
				CommonFunction.copyProperties(appliInfo, eqlVO);
				appliInfo.setAppno(inAppno);
				appliInfo.setAccountNo(eqlVO.getBailAccountno());
				appliInfo.setBailFrozenAmt(eqlVO.getBailAmount());
				appliInfo.setAmount(eqlVO.getBailAmount());
				appliInfo.setInitType(SCFConstants.INIT_TYPE_ADD);//追加
				appliInfo.setId(null);
				appliInfo.setBailType(SCFConstants.BAIL_TYPE_NORMAL);
				appliDAO.save(appliInfo);
				lnciDAO.lockDebtBaseInfo(eqlVO.getDebetNo(), inAppno);

			}
		}
	}
*/
	/**
	 *
	 * @Description: 保证金冻结查询信息
	 * @author jialei.zhang
	 * @Created 2014年4月2日下午1:39:23
	 * @param queryVO
	 * @return
	 * @throws ScubeBizException
	 */
	/*public PageQueryResult getMarginApplyInfo(BailTransferQryVO queryVO) throws ScubeBizException {
		TblAppliCustAccountInfoDAO appliDAO =SCFDAOUtils.getTblAppliCustAccountInfoDAO();

		PageQueryResult pageResult=new PageQueryResult();
		List list =appliDAO.findCustAccountInfoByAppno(queryVO.getAppno_Q());
		List result=new ArrayList();
		BailBussInfoVO vo =new BailBussInfoVO();
		if(null!=list&&list.size()>0){
			TblAppliCustAccountInfo appInfo =(TblAppliCustAccountInfo)list.get(0);
			CommonFunction.copyProperties(vo, appInfo);
			TblAppliBaseInfo baseInfo =SCFDAOUtils.getTblAppliBaseInfoDAO().get(queryVO.getAppno_Q());
			if(null!=baseInfo){
				vo.setNpsBailAmount(new BigDecimal(baseInfo.getExt1()!=null?baseInfo.getExt1():"0.00"));
			}
		}
		result.add(vo);
		pageResult.setQueryResult(result);
		return pageResult;
	}*/


}
