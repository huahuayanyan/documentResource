package com.huateng.scf.bas.mrn.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
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
import com.huateng.base.common.beans.Page;
import com.huateng.flowsharp.entity.FlowsharpException;
import com.huateng.scf.bas.common.constant.ScfBasConstant;
import com.huateng.scf.bas.common.service.IDebtFinancingService;
import com.huateng.scf.bas.common.service.IScfWorkFlowService;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.crm.model.BCrmBaseInfo;
import com.huateng.scf.bas.crm.service.IBCrmBaseInfoService;
import com.huateng.scf.bas.crr.model.BCrrLnCon;
import com.huateng.scf.bas.crr.service.IBCrrLnConService;
import com.huateng.scf.bas.lan.service.IBLanLnciBaseService;
import com.huateng.scf.bas.mrn.model.BCrrLnConCash;
import com.huateng.scf.bas.mrn.model.BMrnAppliAcctInfo;
import com.huateng.scf.bas.mrn.service.IBMrnAppliAcctInfoService;
import com.huateng.scf.bas.mrn.service.ICashEqualValueRegisterService;
import com.huateng.scf.bas.mrn.service.ICompositeMngService;
import com.huateng.scf.bas.mrn.service.IContractService;
import com.huateng.scf.bas.mrn.vo.BailLnciQryVO;
import com.huateng.scf.bas.mrn.vo.CashEqualVO;
import com.huateng.scf.bas.mrn.vo.CashEqualValueContractVO;
import com.huateng.scf.bas.mrn.vo.MastContVO;
import com.huateng.scf.bas.pbc.model.BPbcAppliBaseInfo;
import com.huateng.scf.bas.pbc.service.IAmountService;
import com.huateng.scf.bas.pbc.service.IBPbcAppliBaseInfoService;
import com.huateng.scf.bas.sys.constant.DebtConstants;
import com.huateng.scf.bas.sys.constant.WorkflowConstant;
import com.huateng.scf.bas.sys.service.DealEndFlowService;
import com.huateng.scf.bas.sys.service.DealInFlowService;
import com.huateng.scf.rec.bcp.constant.RBcpErrorConstant;
import com.huateng.scf.rec.bcp.model.DebtLnciBaseInfoVO;
import com.huateng.scf.rec.bcp.model.RBcpAppliBussDtl;
import com.huateng.scf.rec.bcp.service.IRBcpAppliBussDtlService;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;
/**
 * 
 * <p>现金等价物质押接口实现类</p>
 *
 * @author 	mengjiajia
 * @date 	2017年2月13日下午3:56:48
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2017年2月13日下午3:56:48	     新增
 *
 * </pre>
 */
@ScubeService
@Service("CashEqualValueRegisterServiceImpl")
public class CashEqualValueRegisterServiceImpl implements ICashEqualValueRegisterService,DealEndFlowService,DealInFlowService {
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@Resource(name=IScfWorkFlowService.BEAN_ID)
	IScfWorkFlowService scfWorkFlowService;
	/**
	 * 业务申请信息
	 */
	@Resource(name = "BPbcAppliBaseInfoServiceImpl")
	IBPbcAppliBaseInfoService bpbcapplibaseinfoservice;
	/**
	 * 信贷合同信息
	 */
	@Resource(name = "BCrrLnConServiceImpl")
	IBCrrLnConService bcrrlnconservice;
	/**
	 * 客户信息
	 */
	@Resource(name = "BCrmBaseInfoServiceImpl")
	IBCrmBaseInfoService bcrmbaseinfoservice;
	/**
	 * 借据信息
	 */
	@Resource(name="BLanLnciBaseServiceImpl")
	IBLanLnciBaseService blanlncibaseservice;
	
	@Resource(name = "AmountServiceImpl")
	IAmountService amountService;
	/**
	 * 保证金及现金等价物信息
	 */
	@Resource(name = "CompositeMngServiceImpl")
	ICompositeMngService compositemngservice;
	
	@Resource(name = "ContractServiceImpl")
	IContractService contractservice;
	
	@Resource(name = "BMrnAppliAcctInfoServiceImpl")
	IBMrnAppliAcctInfoService bmrnappliacctinfoservice;
	
	@Resource(name = "DebtFinancingServiceImpl")
	IDebtFinancingService debtfinancingservice;
	
	@Resource(name = "RBcpAppliBussDtlServiceImpl")
	IRBcpAppliBussDtlService rbcpapplibussdtlservice;
	
	/**
	 * 获取任务信息
	 * @param appno
	 * @return
	 */
	@Override
	public BPbcAppliBaseInfo findBPbcAppliBaseInfoByAppno(String appno)
	{
		log.debug("appno:"+appno);
		String process = WorkflowConstant.PROCNAME_CASHEQUALREG_APPLY;
		return scfWorkFlowService.findBPbcAppliBaseInfoByAppno(appno,process);
	}
	
	/**
	 * 合同基本信息
	 * @param bCrrLnConCash
	 * @return
	 * @throws ScubeBizException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Page ContractorQryGetter(BCrrLnConCash bCrrLnConCash) throws ScubeBizException
	{
		Page page = new Page();
		//主同号
		String mastContno = bCrrLnConCash.getAppId();
		//客户号
		String custcd = bCrrLnConCash.getCustId();

		//add by huabin.zhong	begin
		if (StringUtil.isEmpty(mastContno)||StringUtil.isEmpty(custcd)){
			String appno = bCrrLnConCash.getAppno();
			BPbcAppliBaseInfo tblAppliBaseInfo = bpbcapplibaseinfoservice.findBPbcAppliBaseInfoByKey(appno);
			if(null!=tblAppliBaseInfo){
				mastContno = tblAppliBaseInfo.getMastContno().trim();
				custcd = tblAppliBaseInfo.getCustcd().trim();
			}
		}
		//add by huabin.zhong	end

		MastContVO mastContVO = new MastContVO();
		//由于系统中由列表选择进入登记页，所以无需对主合同号再次验证
//		TblContBaseInfo tblContBaseInfo = new TblContBaseInfo();
//		BCrrLnCon tblContBaseInfo = new BCrrLnCon();
//		tblContBaseInfo = bcrrlnconservice.findBCrrLnConByAppId(mastContno);//根据信贷合同号查询合同信息
//		if(tblContBaseInfo == null)
//		{
//			throw new ScubeBizException("合同编号为【" + mastContno
//					+ "】的合同记录丢失！",RBcpErrorConstant.RECORD_NOT_EXIST);
//		}
		List resultList = new ArrayList();
		BeanUtils.copyProperties(bCrrLnConCash,mastContVO);
		BCrmBaseInfo crminfo = new BCrmBaseInfo();
		crminfo.setCustcd(bCrrLnConCash.getCustId() == null ? "" : bCrrLnConCash.getCustId());
		BCrmBaseInfo custbean = bcrmbaseinfoservice.findBCrmBaseInfoByKey(crminfo);
		if (custbean != null) {
			mastContVO.setCustno(custbean.getCustno());
		}
		if(StringUtil.isEmpty(bCrrLnConCash.getCurcd())){//币种查询为空，默认为人民币
			mastContVO.setCurcd(ScfBasConstant.RMB);
		}
		BigDecimal sumCashAmt=BigDecimal.ZERO;
		List sumCash =blanlncibaseservice.calSumCashAndBailByMastContno(mastContno);
		Iterator iteSumCash =sumCash.iterator();
		while(iteSumCash.hasNext()){
			HashMap<String, Object> obj = (HashMap<String, Object>)iteSumCash.next();
			sumCashAmt=(BigDecimal)obj.get("calSum");
		}
		mastContVO.setBailAmount(sumCashAmt);
		BigDecimal openAmt =BigDecimal.ZERO;
		try{
			openAmt = amountService.getContRiskAmt(mastContno, ScfBasConstant.CONT_CREDIT_CYCLE);//mastContVO.getCycle()
		}catch(Exception e){
			
		}
		mastContVO.setOpenAmount(openAmt);
		resultList.add(mastContVO);
		page.setRecords(resultList);
		return page;
	}
	
	/**
	 * 保证金及现金等价物列表信息
	 * @param bCrrLnConCash
	 * @return
	 */
	@Override
	public Page AccountInfoEqualCashGetter(int pageNo, int pageSize, BCrrLnConCash bCrrLnConCash)
	{
		//放款合同号
		String mastContno = bCrrLnConCash.getAppId();
		//客户号
		String custcd = bCrrLnConCash.getCustId();

		BCrrLnCon tblContBaseInfo = bcrrlnconservice.findBCrrLnConByAppId(mastContno);
		BailLnciQryVO commonQueryVO = new BailLnciQryVO();
		//注意：目前合同表还没存协议号 2012-11-9 xu_hong
		commonQueryVO.setProtocolNo(tblContBaseInfo.getVidNo());//多方协议号
		//参数-合同号 在后面的查询中没有用到，先注掉 2012-11-9 xu_hong
		//commonQueryVO.setSubContno_Q(mastContno);//放款合同号
		commonQueryVO.setCustcd(custcd);//出质人
		commonQueryVO.setLnciStatus_Q(DebtConstants.LNCI_STATUS_EFFECTIVE);
		commonQueryVO.setPageIndex(pageNo);
		commonQueryVO.setPageSize(pageSize);

		Page pageQueryResult = compositemngservice.getTblCustAccountBussInfoByParam(commonQueryVO);
		return pageQueryResult;
	}
	
	/**
	 * 融资列表
	 * @param bCrrLnConCash
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Page CashEqualValueLnciWriteGetter(int pageNo, int pageSize, BCrrLnConCash bCrrLnConCash)
	{
		String appno = bCrrLnConCash.getAppno();
		String debetNo_Q = "";  //借据号 DEBET_NO
		String mastContno = bCrrLnConCash.getAppId();//信贷合同号
		Page pageQueryResult = new Page();
		pageQueryResult.setPageNo(pageNo);
		pageQueryResult.setPageSize(pageSize);
		if (!StringUtil.isEmpty(debetNo_Q)){
			if(debetNo_Q.startsWith("/f")){
				debetNo_Q = debetNo_Q.replaceFirst("/f", "");
			}
		}
		List result = new ArrayList();
		if(!StringUtil.isEmpty(appno)||!StringUtil.isEmpty(debetNo_Q)){
			List list = contractservice.getCashEqualValueWriteLnciInfo(appno, debetNo_Q, pageNo, pageSize);
			if(null!=list){
				result.addAll(list);
			}
		}
		if(!StringUtil.isEmpty(mastContno)&&StringUtil.isEmpty(appno)){
			List list =contractservice.getCashEqualValueLnciByMastContno(mastContno);
			if(null!=list){
				result.addAll(list);
			}
		}
		if(!StringUtil.isEmpty(appno))
		{
			BPbcAppliBaseInfo tblAppliBaseInfo = bpbcapplibaseinfoservice.findBPbcAppliBaseInfoByKey(appno);
			if(null!=tblAppliBaseInfo){
				mastContno = tblAppliBaseInfo.getMastContno().trim();
				List list =contractservice.getCashEqualValueLnciByMastContno(mastContno);
				if(null!=list){
					result.addAll(list);
				}
			}
		}
		pageQueryResult.setRecords(result);
		pageQueryResult.setTotalRecord(result.size());
		return pageQueryResult;
	}
	
	/**
	 * 添加现金等价物列表
	 * @param appno
	 * @return
	 * @throws ScubeBizException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Page CashEqualAddInfoGetter(int pageNo, int pageSize, String appno) throws ScubeBizException
	{
		Page result = new Page();
		List<CashEqualVO> resultList =new ArrayList();
		CashEqualVO eqlVO = null;
		List<BMrnAppliAcctInfo> list = bmrnappliacctinfoservice.findBMrnAppliAcctInfoByAppno(appno);
		Iterator ite=list.iterator();
		while(ite.hasNext()){
			BMrnAppliAcctInfo info =(BMrnAppliAcctInfo)ite.next();
			if(null!=info){
				eqlVO= new CashEqualVO();
				BeanUtils.copyProperties(info, eqlVO);
				BigDecimal eqlAmt=eqlVO.getBailAmount()!=null?eqlVO.getBailAmount():BigDecimal.ZERO;
				BigDecimal rate =eqlVO.getBailRate()!=null?eqlVO.getBailRate():BigDecimal.ZERO;
				eqlVO.setValue(eqlAmt.multiply(rate).divide(BigDecimal.TEN).divide(BigDecimal.TEN));
				eqlVO.setNpsBailAmount(eqlVO.getBailAmount());
				resultList.add(eqlVO);
			}
		}
		result.setRecords(resultList);
		result.setTotalRecord(list.size());
		return result;
	}
	
	@SuppressWarnings({ "rawtypes" })
	@Override
	/**
	 * 现金等价物登记-单笔管理模式 申请保存发起
	 */
	public String CashEqualValueInfoSinglesUpdate(BCrrLnConCash bCrrLnConCash,List lnciBaseInfoForCash,List cashEqualValueInfo) throws ScubeBizException
	{
		String appno = bCrrLnConCash.getAppno();
		CashEqualValueContractVO ContractVO1 = new CashEqualValueContractVO();
		DebtLnciBaseInfoVO ContractVO = new DebtLnciBaseInfoVO();
		ArrayList<DebtLnciBaseInfoVO> lnciModifyList = this.getLnciModifyList(lnciBaseInfoForCash);
		BeanUtils.copyProperties(lnciModifyList.get(0), ContractVO);
		ContractVO1.setMastContno(ContractVO.getMastContno());
		ContractVO1.setCustcd(ContractVO.getCustcd());
//		ContractVO1.setBailAmount(((DebtLnciBaseInfoVO)lnciModifyList.get(0)).getAddAmount());
		ContractVO1.setType(WorkflowConstant.APPLI_TYPE_CASHEQUALREG_APPLY);//现金等价物质押类型
		ContractVO1.setBussType(ScfBasConstant.SUPPLYCHAINPDID_02);//差额回购
		ArrayList<CashEqualVO> accountInsertList = this.getAccountInsertList(ContractVO, lnciModifyList, cashEqualValueInfo);
		
		if(StringUtil.isEmpty(appno)){
			String workApplyType=WorkflowConstant.PROCNAME_CASHEQUALREG_APPLY;
			String businessnoType=WorkflowConstant.APPLI_TYPE_CASHEQUALREG_APPLY;
			appno = compositemngservice.saveApplyBaseInfo(ContractVO1, businessnoType, workApplyType);
			// 工作流开始
			HashMap<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("modelId", WorkflowConstant.PROCNAME_CASHEQUALREG_APPLY);
			paramMap.put("NodeId", WorkflowConstant.POOLREPAY_WRITE);
			paramMap.put("startedUserId", ContextHolder.getUserInfo().getTlrNo());
			try {
				scfWorkFlowService.commonStartFlow(appno,workApplyType, workApplyType, paramMap);
			} catch (FlowsharpException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(!StringUtil.isEmpty(appno)){
			compositemngservice.saveAppliDetailInfo(appno,lnciModifyList);
			compositemngservice.saveAppliCustAccountInfo(appno,accountInsertList);
		}
		//锁定借据
		debtfinancingservice.lockLnciBaseInfo(appno,lnciModifyList);
		return appno;
	}
	
	/**
	 * 现金等价物登记 申请提交
	 */
	@SuppressWarnings({ "rawtypes" })
	@Override
	public String CashEqualValueInfoWriteSubmitUpdate(BCrrLnConCash bCrrLnConCash,List lnciBaseInfoForCash,List cashEqualValueInfo,boolean isProcess) throws ScubeBizException
	{
		String appno = bCrrLnConCash.getAppno();
		DebtLnciBaseInfoVO ContractVO = new DebtLnciBaseInfoVO();
		ArrayList<DebtLnciBaseInfoVO> lnciModifyList = new ArrayList<DebtLnciBaseInfoVO>();
		ArrayList<CashEqualVO> accountInsertList = new ArrayList<CashEqualVO>();
		if(isProcess)
		{
			lnciModifyList = this.getLnciModifyList(lnciBaseInfoForCash);
			BeanUtils.copyProperties(lnciModifyList.get(0), ContractVO);
			accountInsertList = this.getAccountInsertList(ContractVO, lnciModifyList, cashEqualValueInfo);
		}
		else
		{
			for(int i=0;i<lnciBaseInfoForCash.size();i++)
			{
				DebtLnciBaseInfoVO infoVO = new DebtLnciBaseInfoVO();
				BeanUtils.copyProperties(lnciBaseInfoForCash.get(i), infoVO);
				lnciModifyList.add(infoVO);
			}
			for(int i=0;i<cashEqualValueInfo.size();i++)
			{
				CashEqualVO infoVO = new CashEqualVO();
				BeanUtils.copyProperties(cashEqualValueInfo.get(i), infoVO);
				accountInsertList.add(infoVO);
			}
		}
		
		compositemngservice.saveAppliDetailInfo(appno,lnciModifyList);
		compositemngservice.saveAppliCustAccountInfo(appno,accountInsertList);
		//锁定借据
		debtfinancingservice.lockLnciBaseInfo(appno,lnciModifyList);

		if(isProcess)
		{
			//流程流转
			BPbcAppliBaseInfo appliinfo = bpbcapplibaseinfoservice.findBPbcAppliBaseInfoByKey(appno);
			String status = WorkflowConstant.WORKFLOW_TRANS_AGREE;
			try {
				scfWorkFlowService.processTasks(appliinfo, status);
			} catch (FlowsharpException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return appno;
	}
	
	/**
	 * 获取页面选中的融资信息
	 * @param lnciBaseInfoForCash
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ArrayList<DebtLnciBaseInfoVO> getLnciModifyList(List lnciBaseInfoForCash)
	{
		DebtLnciBaseInfoVO ContractVO = new DebtLnciBaseInfoVO();
		ArrayList<DebtLnciBaseInfoVO> lnciModifyList = new ArrayList<DebtLnciBaseInfoVO>();
		if(lnciBaseInfoForCash.size()>0)
		{
			Map<String, Object> map = (Map<String, Object>) lnciBaseInfoForCash.get(0);
			//无法直接将map转换为实体类，因此根据借据主键数据库查询，并将新的追加保证金金额赋值给查询道德实体对象
			String addCashEqtAmt = map.get("addCashEqtAmt").toString();//本次追加保证金金额
			String debetId = map.get("debetId").toString();//借据号/承兑协议号
			com.huateng.scf.bas.lan.model.BLanLnciBase blnci = blanlncibaseservice.findBLanLnciBaseByDebtId(debetId);//选中的融资信息
			blnci.setAddCashEqtAmt(new BigDecimal(addCashEqtAmt));
			
			BeanUtils.copyProperties(blnci, ContractVO);
			lnciModifyList.add(ContractVO);
		}
		if(StringUtil.isEmpty(ContractVO.getMastContno())){
			throw new ScubeBizException("合同号丢失，无法保存", RBcpErrorConstant.ERROR_CODE_PARAM_NOT_EXIST);
		}
		if(StringUtil.isEmpty(ContractVO.getCustcd())){
			throw new ScubeBizException("登记客户号丢失，无法保存", RBcpErrorConstant.ERROR_CODE_PARAM_NOT_EXIST);
		}
		/**
		 * 用处未知
		 */
		BigDecimal totAddAmount =BigDecimal.ZERO;
		for (int i = 0; i < lnciModifyList.size(); i++) {
			BigDecimal addAmount = lnciModifyList.get(i).getAddCashEqtAmt();
			if(null==addAmount){
				lnciModifyList.get(i).setAddCashEqtAmt(BigDecimal.ZERO);
			}
			if(addAmount != null){
				totAddAmount=totAddAmount.add(addAmount);
			}
		}
		return lnciModifyList;
	}
	
	/**
	 * 获取页面添加的现金等价物信息
	 * @param ContractVO
	 * @param lnciModifyList
	 * @param cashEqualValueInfo
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ArrayList<CashEqualVO> getAccountInsertList(DebtLnciBaseInfoVO ContractVO,ArrayList<DebtLnciBaseInfoVO> lnciModifyList,List cashEqualValueInfo)
	{
		CashEqualVO eqlVO = null;
		ArrayList<CashEqualVO> accountInsertList = new ArrayList<CashEqualVO>();
		for(int i=0;i<cashEqualValueInfo.size();i++)
		{
			Map<String, Object> map = (Map<String, Object>) cashEqualValueInfo.get(i);
			String bailType = map.get("bailType").toString();//类型
			String bailAccountno = map.get("bailAccountno").toString();//现金等价物编号
			String bailAmount = map.get("bailAmount").toString();//现金等价物金额
			String bailRate = map.get("bailRate").toString();//现金等价物质押率
			String value = map.get("value").toString();//现金等价物质押价值
			String npsBailAmount = map.get("npsBailAmount").toString();//核心返回金额
			String protocolNo = map.get("protocolNo").toString();
			//无法直接将map转换为实体类，因此将map中的值逐个赋值给CashEqualVO对象
			eqlVO = new CashEqualVO();
			eqlVO.setBailType(bailType);
			eqlVO.setBailAccountno(bailAccountno);
			eqlVO.setBailAmount(new BigDecimal(bailAmount));
			eqlVO.setBailRate(new BigDecimal(bailRate));
			eqlVO.setValue(new BigDecimal(value));
			eqlVO.setNpsBailAmount(new BigDecimal(npsBailAmount));
			eqlVO.setProtocolNo(protocolNo);
			eqlVO.setMastContno(ContractVO.getMastContno());
			eqlVO.setCustcd(ContractVO.getCustcd());
			eqlVO.setDebetNo(((DebtLnciBaseInfoVO)lnciModifyList.get(0)).getDebetNo());
			accountInsertList.add(eqlVO);
		}
		return accountInsertList;
	}
	
	/**
	 * 现金等价物登记 退回
	 */
	@Override
	public void CashEqualValueRegCheckUpdateBack(String appno,boolean isProcess)
	{
		if(isProcess)
		{
			//流程流转
			BPbcAppliBaseInfo appliinfo = bpbcapplibaseinfoservice.findBPbcAppliBaseInfoByKey(appno);
			String status = WorkflowConstant.WORKFLOW_TRANS_GOBACK;
			try {
				scfWorkFlowService.processTasks(appliinfo, status);
			} catch (FlowsharpException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 现金等价物登记 同意
	 */
	@Override
	public void CashEqualValueRegCheckUpdateAgree(String appno,boolean isProcess)
	{
		//存tblcustaccountbussinfo
		compositemngservice.saveTblCustAccountBussInfo(appno);
		compositemngservice.updateLnciBaseInfoWithCashEql(appno);
		if(isProcess)
		{
			//流程流转
			BPbcAppliBaseInfo appliinfo = bpbcapplibaseinfoservice.findBPbcAppliBaseInfoByKey(appno);
			String status = WorkflowConstant.WORKFLOW_TRANS_AGREE;
			try {
				scfWorkFlowService.processTasks(appliinfo, status);
			} catch (FlowsharpException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void doWorkForPass(String appNo) {
		CashEqualValueRegCheckUpdateAgree(appNo, false);
	}

	@Override
	public void doWorkForReject(String appNo) {
		CashEqualValueRegCheckUpdateBack(appNo, false);
	}

	@Override
	public void doWorkForBack(String appNo) {
		CashEqualValueRegCheckUpdateBack(appNo, false);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public void doWorkForSubmit(String appNo) throws ScubeBizException {
		BPbcAppliBaseInfo appliBaseInfo = this.findBPbcAppliBaseInfoByAppno(appNo);
		String appId = appliBaseInfo.getMastContno();
		BCrrLnCon bCrrLnCon = bcrrlnconservice.findBCrrLnConByAppId(appId);
		BCrrLnConCash bCrrLnConCash = new BCrrLnConCash();
		BeanUtils.copyProperties(bCrrLnCon, bCrrLnConCash);
		bCrrLnConCash.setAppno(appNo);
		Page lnciResult = CashEqualValueLnciWriteGetter(1, 10, bCrrLnConCash);
		List lnciBaseInfoForCash = lnciResult.getRecords();
		Page cashResult = CashEqualAddInfoGetter(1, Integer.MAX_VALUE, appNo);
		List cashEqualValueInfo = cashResult.getRecords();
		CashEqualValueInfoWriteSubmitUpdate(bCrrLnConCash, lnciBaseInfoForCash, cashEqualValueInfo, false);
	}
	
	/**
	 * 获取已选中的融资列表信息
	 * @param appno
	 * @return
	 * @throws ScubeBizException
	 */
	@Override
	public List<CashEqualValueContractVO> getChoosedLnciInfo(String appno) throws ScubeBizException
	{
		List<CashEqualValueContractVO> result = new ArrayList<CashEqualValueContractVO>();
		List<RBcpAppliBussDtl> list = rbcpapplibussdtlservice.findByProperty(appno);
		if(list.size()>0)
		{
			for(RBcpAppliBussDtl appliBussDtl:list)
			{
				CashEqualValueContractVO contractVO = new CashEqualValueContractVO();
				BeanUtils.copyProperties(appliBussDtl, contractVO);
				result.add(contractVO);
			}
		}
		return result;
	}
}
