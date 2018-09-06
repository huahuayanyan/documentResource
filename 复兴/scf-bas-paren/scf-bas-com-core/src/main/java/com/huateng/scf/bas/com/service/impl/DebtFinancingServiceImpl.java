package com.huateng.scf.bas.com.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huateng.authority.common.ContextHolder;
import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.common.constant.ScfBasConstant;
import com.huateng.scf.bas.common.service.IDebtFinancingService;
import com.huateng.scf.bas.common.util.ScfDateUtil;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.lan.service.IBLanLnciBaseService;
import com.huateng.scf.bas.pbc.model.BPbcAppliBaseInfo;
import com.huateng.scf.bas.pbc.service.IBPbcAppliBaseInfoService;
import com.huateng.scf.bas.sys.constant.DebtConstants;
import com.huateng.scf.bas.sys.constant.WorkflowConstant;
import com.huateng.scf.bas.sys.service.IBSysSerialNoService;
import com.huateng.scf.nrec.bcp.dao.ext.ExtNrecBcpDAO;
import com.huateng.scf.nrec.bcp.dao.model.RBcpDebtInfo;
import com.huateng.scf.nrec.bcp.model.BCntBcpExtInfoVO;
import com.huateng.scf.nrec.bcp.model.BCntBcpInfoVO;
import com.huateng.scf.nrec.bcp.service.IBCntBcpExtInfoService;
import com.huateng.scf.nrec.bcp.service.IBCntBcpInfoService;
import com.huateng.scf.nrec.bcp.service.INRBcpAppliBussDtlService;
import com.huateng.scf.nrec.bcp.service.INRBcpDebtBussInfoService;
import com.huateng.scf.nrec.bcp.service.INRBcpDebtPoolService;
import com.huateng.scf.nrec.bcp.service.IRBcpDebtInfoService;
import com.huateng.scf.nrec.bcp.vo.NDebtBillsInfoVO;
import com.huateng.scf.rec.bcp.constant.RBcpErrorConstant;
import com.huateng.scf.rec.bcp.model.AppliBussDetailVO;
import com.huateng.scf.rec.bcp.model.DebtBussInfoVO;
import com.huateng.scf.rec.bcp.model.DebtCommonQryVO;
import com.huateng.scf.rec.bcp.model.DebtLnciBaseInfoVO;
import com.huateng.scf.rec.bcp.model.RBcpAppliBussDtl;
import com.huateng.scf.rec.bcp.model.RBcpDebtBussInfo;
import com.huateng.scf.rec.bcp.model.RBcpDebtPool;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * 
 * <p>应收账款配置版	接口实现类</p>
 *
 * @author 	mengjiajia
 * @date 	2017年2月20日下午2:31:17
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2017年2月20日下午2:31:17	     新增
 *
 * </pre>
 */
@ScubeService
@Service("DebtFinancingServiceImpl")
public class DebtFinancingServiceImpl implements IDebtFinancingService
{
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	/**
	 * 借据信息
	 */
	@Resource(name="BLanLnciBaseServiceImpl")
	IBLanLnciBaseService blanlncibaseservice;
	
	//应收类配置版应收账款信息
	@Resource(name = "RBcpDebtInfoServiceImpl")
	IRBcpDebtInfoService rbcpdebtinfoservice;
	
	@Resource(name = "NRBcpAppliBussDtlServiceImpl")
	INRBcpAppliBussDtlService nrbcpapplibussdtlservice;
	
	//合同信息
	@Resource(name = "BCntBcpInfoServiceImpl")
	IBCntBcpInfoService bcntbcpinfoservice;
	
	//贸易对手信息
	@Resource(name = "BCntBcpExtInfoServiceImpl")
	IBCntBcpExtInfoService bcntbcpextinfoservice;
	
	@Resource(name = "BSysSerialNoServiceImpl")	
	IBSysSerialNoService  ibSysSerialNoService;//业务编号生成器
	
	@Resource(name = "BPbcAppliBaseInfoServiceImpl")
	IBPbcAppliBaseInfoService bpbcapplibaseinfoservice;
	
	@Resource(name = "NRBcpDebtBussInfoServiceImpl")
	INRBcpDebtBussInfoService nrbcpdebtbussinfoservice;
	
	@Resource(name = "NRBcpDebtPoolServiceImpl")
	INRBcpDebtPoolService nrbcpdebtpoolservice;
	
	@Resource(name = "ExtNrecBcpDAO")
	ExtNrecBcpDAO extnrecbcpdao;
	
	/**
	 *
	 * @Description: 锁定保理还款借据 方法
	 * @author jialei.zhang
	 * @Created 2013-8-28下午2:51:10
	 * @param invoiceList
	 * @throws CommonException
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public void lockLnciBaseInfo(String appno,List invoiceList) throws ScubeBizException {
		log.debug("appno="+appno+"====================");
		blanlncibaseservice.releaseDebtBaseInfoByLockAppno(appno);
		if(invoiceList!=null&&invoiceList.size()>0){
			Iterator ite = invoiceList.iterator();
			while(ite.hasNext()){
				DebtLnciBaseInfoVO lnciVO=(DebtLnciBaseInfoVO)ite.next();
				blanlncibaseservice.lockDebtBaseInfo(lnciVO.getDebetNo(),appno);
			}
		}
	}
	
	/**
	 * 应收账款查询列表
	 * @param debtCommonQryVO
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年5月24日下午1:57:00
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Page getInvoiceFinancingQuery(DebtCommonQryVO debtCommonQryVO) throws ScubeBizException
	{
		List<String> orderFileds = new ArrayList<String>();
		orderFileds.add("DEBT_END");
		orderFileds.add("BILLS_NO");
		Page pageQueryResult = rbcpdebtinfoservice.getInvoiceSelectedQuery(debtCommonQryVO, orderFileds);
		List<RBcpDebtInfo> list = pageQueryResult.getRecords();
		List<NDebtBillsInfoVO> resultList = new ArrayList<NDebtBillsInfoVO>();
		if(list!=null && list.size()>0)
		{
			for(RBcpDebtInfo debtInfo:list)
			{
				NDebtBillsInfoVO debtVO = new NDebtBillsInfoVO();
				BeanUtils.copyProperties(debtInfo, debtVO);
				resultList.add(debtVO);
			}
		}
		pageQueryResult.setRecords(resultList);
		return pageQueryResult;
	}
	
	/**	发票融资发放发票添加
	 *
	 * @author zhoujun.hou
	 * @date 2011-10-17
	 * @param commonQueryVO
	 * @return
	 * @throws CommonException
	 * @throws CommonException
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Page getInvoiceFinancingAddQry(DebtCommonQryVO debtCommonQryVO) throws ScubeBizException
	{
		// 查询
		Page pageQuryResult = rbcpdebtinfoservice.getInvoiceFinancingAddQry(debtCommonQryVO);
		List<NDebtBillsInfoVO> resultList = new ArrayList<NDebtBillsInfoVO>();
		List<RBcpDebtInfo> list = pageQuryResult.getRecords();
		if(list!=null&&list.size()>0)
		{
			for(RBcpDebtInfo debtInfo:list)
			{
				NDebtBillsInfoVO billsVO = new NDebtBillsInfoVO();
				BeanUtils.copyProperties(debtInfo, billsVO);
				billsVO.setDebtId(billsVO.getId());
				resultList.add(billsVO);
			}
		}
		pageQuryResult.setRecords(resultList);
		return pageQuryResult;
	}
	
	/**
	 * 应收账款单据查询
	 * @param debtCommonQryVO
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年5月25日下午8:28:18
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Page getDebtInfoQuery(DebtCommonQryVO debtCommonQryVO, boolean flag) throws ScubeBizException
	{
		Page pageQuryResult = rbcpdebtinfoservice.getDebtInfoQuery(debtCommonQryVO, flag);
		List<NDebtBillsInfoVO> resultList = new ArrayList<NDebtBillsInfoVO>();
		List<RBcpDebtInfo> list = pageQuryResult.getRecords();
		if(list!=null&&list.size()>0)
		{
			for(RBcpDebtInfo debtInfo:list)
			{
				NDebtBillsInfoVO billsVO = new NDebtBillsInfoVO();
				BeanUtils.copyProperties(debtInfo, billsVO);
				billsVO.setDebtId(billsVO.getId());
				resultList.add(billsVO);
			}
		}
		pageQuryResult.setRecords(resultList);
		return pageQuryResult;
	}

	/**
	 * 催收待添加发票查询
	 * @param debtCommonQryVO
	 * @return
	 * @author 	mengjiajia
	 * @date 	2017年5月27日下午3:10:30
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Page getDebtInvoiceInfoPressing(DebtCommonQryVO debtCommonQryVO)
	{
		Page page = rbcpdebtinfoservice.getDebtInvoiceInfoPressing(debtCommonQryVO);
		List<RBcpDebtInfo> list = page.getRecords();
		ArrayList<NDebtBillsInfoVO> result = new ArrayList<NDebtBillsInfoVO>();
		if(list!=null&&list.size()>0)
		{
			for(RBcpDebtInfo debtInfo:list)
			{
				NDebtBillsInfoVO debtVO = new NDebtBillsInfoVO();
				BeanUtils.copyProperties(debtInfo, debtVO);
				debtVO.setDebtId(debtInfo.getId());
				result.add(debtVO);
			}
		}
		page.setRecords(result);
		return page;
	}
	
	/**
	 * 根据appno对流程锁定的应收账款进行解锁
	 * @param appno
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年5月31日下午3:10:54
	 */
	@Override
	public void releaseAppliDebtBaseInfo(String appno) throws ScubeBizException
	{
		List<RBcpAppliBussDtl> bussDetailList = nrbcpapplibussdtlservice.queryRBcpAppliBussDtlByAppno(appno);
		for(int i = 0; i < bussDetailList.size(); i++){
			RBcpAppliBussDtl busdtl = bussDetailList.get(i);
			AppliBussDetailVO bussDetail = new AppliBussDetailVO();
			BeanUtils.copyProperties(busdtl, bussDetail);
			if(!StringUtil.isEmpty(bussDetail.getDebtId())){
				rbcpdebtinfoservice.releaseDebtBaseInfo(bussDetail.getDebtId());
			}
		}
	}
	
	/**
	 * 保存业务申请信息
	 * @param debtVO
	 * @param businessnoType
	 * @param workApplyType
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年6月1日上午10:27:50
	 */
	@Transactional
	@Override
	public String saveFactoringAppBasicInfo(DebtBussInfoVO debtVO, String businessnoType, String workApplyType)
			throws ScubeBizException
	{
		BCntBcpInfoVO bCntBcpInfoVO = bcntbcpinfoservice.queryBCntBcpInfoByMastContno(debtVO.getMastContno());
		BPbcAppliBaseInfo bPbcAppliBaseInfo = null;
		String appNo = null;
		workApplyType = workApplyType.replace("N-", "");
		if (StringUtil.isEmpty(debtVO.getAppno()))
		{// 保存新增
			if(workApplyType.equals(WorkflowConstant.PROCNAME_ACCOUNTS_RECEIVABLE_INPOOL_APPLY))
			{//应收账款入池
				appNo = ibSysSerialNoService.genSerialNo(ScfBasConstant.BUSSNO_TYPE_YSRC_T_APP_NO);
			}
			//应收账款出池
			if(workApplyType.equals(WorkflowConstant.PROCNAME_ACCOUNTS_RECEIVABLE_OUTPOOL_APPLY)){
				appNo = ibSysSerialNoService.genSerialNo(ScfBasConstant.BUSSNO_TYPE_YSCC_T_APP_NO);
			}
			if(workApplyType.equals(WorkflowConstant.PROCNAME_FACTORING_POOL_BUYBACK_APPLY)
					||workApplyType.equals(WorkflowConstant.PROCNAME_FACTORING_ACCOUNTREPUR_APPLY)
					||workApplyType.equals(WorkflowConstant.PROCNAME_FACTORING_CREDIT_BUY_BACK_APPLY)
					||workApplyType.equals(WorkflowConstant.PROCNAME_FACTORING_DOUBLE_BUY_BACK_APPLY)
					||workApplyType.equals(WorkflowConstant.PROCNAME_FACTORING_LEASE_BUY_BACK_APPLY))
			{//应收账款反转让
				appNo = ibSysSerialNoService.genSerialNo(ScfBasConstant.BUSSNO_TYPE_YSFZR_T_APP_NO);
			}
			if(workApplyType.equals(WorkflowConstant.PROCNAME_FACTORING_POOL_CANCEL_APPLY)
					||workApplyType.equals(WorkflowConstant.PROCNAME_FACTORING_ACCOUNTCANCEL_APPLY)
					||workApplyType.equals(WorkflowConstant.PROCNAME_FACTORING_LEASE_CHARGE_OFF_APPLY)
					||workApplyType.equals(WorkflowConstant.PROCNAME_FACTORING_DOUBLE_CHARGE_OFF_APPLY)
					||workApplyType.equals(WorkflowConstant.PROCNAME_FACTORING_CREDIT_CHARGE_OFF_APPLY))
			{//应收账款核销、应收账款池核销
				appNo = ibSysSerialNoService.genSerialNo(ScfBasConstant.BUSSNO_TYPE_YSHX_T_APP_NO);
			}
			if(workApplyType.equals(WorkflowConstant.PROCNAME_ALLOWANCE_POOL_APPLY)
					||workApplyType.equals(WorkflowConstant.PROCNAME_ALLOWANCE_APPLY)
					||workApplyType.equals(WorkflowConstant.PROCNAME_ALLOWANCE_DOUBLE_APPLY)
					||workApplyType.equals(WorkflowConstant.PROCNAME_ALLOWANCE_LEASE_APPLY)
					||workApplyType.equals(WorkflowConstant.PROCNAME_ALLOWANCE_CREDIT_APPLY))
			{//应收账款减值、应收账款池减值
				appNo = ibSysSerialNoService.genSerialNo(ScfBasConstant.BUSSNO_TYPE_YSJZ_T_APP_NO);
			}
			
			bPbcAppliBaseInfo = new BPbcAppliBaseInfo();
			try {
				BeanUtils.copyProperties(debtVO,bPbcAppliBaseInfo);// 拷贝信息                      
				bPbcAppliBaseInfo.setCustcd(debtVO.getCustcdSaller());  // 客户号
				bPbcAppliBaseInfo.setMoniCustcd(debtVO.getCustcdBuyer());
				bPbcAppliBaseInfo.setCurcd(bCntBcpInfoVO.getCurcd());                         // 币种
				bPbcAppliBaseInfo.setProcessTemplateName("N-"+workApplyType);              		 // 流程名称
				bPbcAppliBaseInfo.setAppliType(businessnoType);
				bPbcAppliBaseInfo.setBusinessnoType(ScfBasConstant.BUSINESSNO_TYPE_CONTNO);
				bPbcAppliBaseInfo.setBusinessno(bCntBcpInfoVO.getMastContno());
				bPbcAppliBaseInfo.setAppliStatus(WorkflowConstant.APPLI_STATUS_UNSUBMIT);         // 申请状态:未提交（默认）
				bPbcAppliBaseInfo.setAppliStatusDtl(WorkflowConstant.APPLI_STATUS_DTL_WRITING); // 申请状态明细:未提交（默认）
				bPbcAppliBaseInfo.setAppBrcode(ContextHolder.getOrgInfo().getBrNo());	                     // 登记机构
				bPbcAppliBaseInfo.setApprover(ContextHolder.getUserInfo().getTlrNo());
				bPbcAppliBaseInfo.setApproveTime(new Date());
				bPbcAppliBaseInfo.setAppDate(ScfDateUtil.getStringDate(new Date()));	                     // 登记时间
				bPbcAppliBaseInfo.setStartTime(new Date());
				bPbcAppliBaseInfo.setStratDate(ScfDateUtil.getStringDate(new Date()));
				bPbcAppliBaseInfo.setStartBrcode(ContextHolder.getOrgInfo().getBrNo());
				bPbcAppliBaseInfo.setStartTlrcd(ContextHolder.getUserInfo().getTlrNo());
				bPbcAppliBaseInfo.setAppTlrcd(ContextHolder.getUserInfo().getTlrNo());	                     // 登记人
//				bPbcAppliBaseInfo.setMortgageName(debtVO.getPayType());					//还款类别
//				bPbcAppliBaseInfo.setSupplyChainPdId(debtVO.getProductId());               // 产品ID
				bPbcAppliBaseInfo.setSupplyChainPdId(debtVO.getBussType());				//业务品种
				bPbcAppliBaseInfo.setMastContno(bCntBcpInfoVO.getMastContno());           // 主合同号
				bPbcAppliBaseInfo.setMemo(debtVO.getMemo());
				bPbcAppliBaseInfo.setAmt(debtVO.getTotalAmount());	// 转让总金额
				bPbcAppliBaseInfo.setAppno(appNo);
				if (StringUtil.isEmpty(bPbcAppliBaseInfo.getBusinessno())) {
					bPbcAppliBaseInfo.setBusinessno(bPbcAppliBaseInfo.getAppno());
				}
				if (StringUtil.isEmpty(bPbcAppliBaseInfo.getChannelFlag())) {
					bPbcAppliBaseInfo.setChannelFlag(ScfBasConstant.CHANNEL_FLAG_SCF);//默认渠道标识为供应链
				}
				if (StringUtil.isEmpty(bPbcAppliBaseInfo.getIsFlowEnd())) {
					bPbcAppliBaseInfo.setIsFlowEnd(ScfBasConstant.FLAG_OFF);//默认流程未结束
				}
			} catch (Exception e) {
				log.error(e.getMessage());
				e.printStackTrace();
				throw new ScubeBizException();
			}
			bpbcapplibaseinfoservice.addBPbcAppliBaseInfo(bPbcAppliBaseInfo);
		}
		else
		{//更新
			bPbcAppliBaseInfo = new BPbcAppliBaseInfo();
			bPbcAppliBaseInfo = bpbcapplibaseinfoservice.findBPbcAppliBaseInfoByKey(debtVO.getAppno());
			bPbcAppliBaseInfo.setMemo(debtVO.getMemo());
			bPbcAppliBaseInfo.setAmt(debtVO.getTotalAmount());	// 转让总金额
			bpbcapplibaseinfoservice.updateBPbcAppliBaseInfo(bPbcAppliBaseInfo);
		}
		return bPbcAppliBaseInfo.getAppno();
	}
	
	/**
	 * 获取保理合同（有/无）追索类型
	 * @param mastContno
	 * @param custcdBuyer
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年6月1日上午10:37:56
	 */
	@Override
	public String getDebtContRecoverType(String mastContno,String custcdBuyer) throws ScubeBizException
	{
		BCntBcpExtInfoVO debtExtInfo = bcntbcpextinfoservice.queryContDebtExInfoByMastContno(mastContno,custcdBuyer);
		if(debtExtInfo == null){
			throw new ScubeBizException("合同信息丢失！", RBcpErrorConstant.RECORD_NOT_EXIST);
		}
		return debtExtInfo.getRecoverType();
	}
	
	/**
	 * 回购审批通过
	 * @param insertDebtList
	 * @param debtVO
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年6月1日上午10:40:10
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	@Transactional
	public void factoringDebtBackAddApply(List<NDebtBillsInfoVO> insertDebtList,DebtBussInfoVO debtVO) throws ScubeBizException 
	{
		debtVO.setApplyType(DebtConstants.APPLY_TYPE_REPURCHASE);
		debtVO.setReason(debtVO.getReason());
		debtVO.setAmount(debtVO.getTotalAmount());//回购金额
		
		RBcpDebtBussInfo tblDebtBussInfo = nrbcpdebtbussinfoservice.debtBussInfoAdd(debtVO);
		tblDebtBussInfo.setAmount(debtVO.getTotalAmount());//回购金额
		List cancelList = rbcpdebtinfoservice.factoringDebtBackAddApply(insertDebtList, tblDebtBussInfo);
		//核销流水
		rbcpdebtinfoservice.saveDebtBussInfoWhenCanceled(cancelList, debtVO);
	}
	
	/**
	 * 回购、核销更新池的发票总余额和可融资余额
	 * @param debtVO
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年6月1日上午10:53:36
	 */
	@Override
	@Transactional
	public void updatePoolRemainAmount(DebtBussInfoVO debtVO) throws ScubeBizException
	{
		BCntBcpInfoVO baseInfo = bcntbcpinfoservice.queryBCntBcpInfoByMastContno(debtVO.getMastContno());//获取合同信息
		if(baseInfo != null && !StringUtil.isEmpty(baseInfo.getFinancingType())
				&&DebtConstants.FINANCING_TYPE_POOL.equals(baseInfo.getFinancingType())){
//			BigDecimal amount = debtVO.getTotalAmount()==null?new BigDecimal("0"):debtVO.getTotalAmount();
			List<RBcpDebtPool> list = nrbcpdebtpoolservice.queryDebtPollByMastContno(debtVO.getMastContno(), debtVO.getCustcdSaller());//获取池信息
			if(list!=null && list.size()>0){
				for(int i=0;i<list.size();i++)
				{
					RBcpDebtPool debtpool = list.get(i);
					RBcpDebtPool debtPool = nrbcpdebtpoolservice.findRBcpDebtPoolByKey(debtpool.getId());
					nrbcpdebtpoolservice.updatePoolRemainAmount(debtPool, baseInfo, debtVO.getFlag());
				}
			}else{
				throw new ScubeBizException("应收账款池信息获取失败！", RBcpErrorConstant.RECORD_HAS_EXIST);
			}
		}
	}
	
	
	/**
	 * 核销申请发票添加查询
	 * @param commonQueryVO
	 * @param flag
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年6月2日下午3:14:19
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Page getInvoiceChargeOffAddQry(DebtCommonQryVO commonQueryVO) throws ScubeBizException
	{
		Page page = rbcpdebtinfoservice.getInvoiceChargeOffAddQry(commonQueryVO);
		List<RBcpDebtInfo> list = page.getRecords();
		ArrayList<NDebtBillsInfoVO> result = new ArrayList<NDebtBillsInfoVO>();
		if(list!=null&&list.size()>0)
		{
			for(RBcpDebtInfo debtInfo:list)
			{
				NDebtBillsInfoVO debtVO = new NDebtBillsInfoVO();
				BeanUtils.copyProperties(debtInfo, debtVO);
				debtVO.setDebtId(debtVO.getId());
				debtVO.setRemoveAmount(debtVO.getRemainingAmount());
				result.add(debtVO);
			}
		}
		page.setRecords(result);
		return page;
	}
	/**	
	 * 核销审批通过
	 * @param insertDebtList
	 * @param debtVO
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年6月2日下午4:04:20
	 */
	@Override
	public void factoringChargeOffAddSave(List<NDebtBillsInfoVO> insertDebtList,DebtBussInfoVO debtVO) throws ScubeBizException
	{
		debtVO.setApplyType(DebtConstants.APPLY_TYPE_VERIFY);
		debtVO.setAmount(debtVO.getTotalAmount());//核销金额
		//归还卖买方关联额度
//		debtVO.setReason(debtVO.getRebateReason());
		RBcpDebtBussInfo bcpDebtBussInfo = nrbcpdebtbussinfoservice.debtBussInfoAdd(debtVO);
		rbcpdebtinfoservice.factoringChargeOffAddSave(insertDebtList, bcpDebtBussInfo);
	}
	
	/**
	 * 查询应收账款列表
	 * @param commonQueryVO
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年6月5日上午10:28:58
	 */
	@Override
	public Page getAcquisitionsInformation(DebtCommonQryVO debtCommonQryVO) throws ScubeBizException
	{
		return rbcpdebtinfoservice.getAcquisitionsInformation(debtCommonQryVO);
	}

	/**
	 * 减值申请发票添加
	 * @param debtCommonQryVO
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年6月5日上午10:57:50
	 */
	@Override
	public Page getInvoiceAllowanceAddQry(DebtCommonQryVO debtCommonQryVO) throws ScubeBizException
	{
		return rbcpdebtinfoservice.getInvoiceAllowanceAddQry(debtCommonQryVO,true);
	}
	
	/**
	 * 减值审批通过
	 * @param insertDebtList
	 * @param debtVO
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年6月5日下午2:45:13
	 */
	@Override
	public void factoringAllowanceAddApply(List<NDebtBillsInfoVO> insertDebtList,DebtBussInfoVO debtVO) throws ScubeBizException
	{
		debtVO.setApplyType(DebtConstants.APPLY_TYPE_DISCOUNT);
		debtVO.setAmount(debtVO.getTotalAmount());//减值金额
		RBcpDebtBussInfo tblDebtBussInfo = nrbcpdebtbussinfoservice.debtBussInfoAdd(debtVO);
		rbcpdebtinfoservice.factoringAllowanceAddApply(insertDebtList, tblDebtBussInfo);//应收账款解锁在其中
		nrbcpdebtpoolservice.updateDebtPoolInfo(debtVO);//更新池信息
	}

}
