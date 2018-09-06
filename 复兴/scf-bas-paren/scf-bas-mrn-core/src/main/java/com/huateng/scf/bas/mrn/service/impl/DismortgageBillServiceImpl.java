package com.huateng.scf.bas.mrn.service.impl;

import java.lang.reflect.InvocationTargetException;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huateng.authority.common.ContextHolder;
import com.huateng.base.common.beans.Page;
import com.huateng.flowsharp.api.IProcessService;
import com.huateng.flowsharp.entity.FlowsharpException;
import com.huateng.flowsharp.entity.NodeEntity;
import com.huateng.scf.bas.cnt.model.MastContQryVO;
import com.huateng.scf.bas.common.constant.ScfBasConstant;
import com.huateng.scf.bas.common.model.CommonApplyDtlInfoVO;
import com.huateng.scf.bas.common.service.IScfWorkFlowService;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.crr.service.IBCrrLnConService;
import com.huateng.scf.bas.lan.dao.model.BLanLnciBase;
import com.huateng.scf.bas.mrn.model.BCrrLnConCash;
import com.huateng.scf.bas.mrn.service.ICompositeMngService;
import com.huateng.scf.bas.mrn.service.IContractService;
import com.huateng.scf.bas.mrn.service.IDismortgageBillService;
import com.huateng.scf.bas.mrn.vo.MastContVO;
import com.huateng.scf.bas.mrn.vo.OldApplyVO;
import com.huateng.scf.bas.mrn.vo.OldCommonQueryVO;
import com.huateng.scf.bas.pbc.model.AmountVO;
import com.huateng.scf.bas.pbc.model.BPbcAppliBaseInfo;
import com.huateng.scf.bas.pbc.service.IAmountService;
import com.huateng.scf.bas.sys.constant.WorkflowConstant;
import com.huateng.scf.bas.sys.service.DealEndFlowService;
import com.huateng.scf.bas.sys.service.DealInFlowService;
import com.huateng.scf.rec.bcp.constant.RBcpErrorConstant;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * 
 * <p>现金等价物解押实现类</p>
 *
 * @author 	mengjiajia
 * @date 	2017年2月20日下午2:33:10
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2017年2月20日下午2:33:10	     新增
 *
 * </pre>
 */
@SuppressWarnings("deprecation")
@ScubeService
@Service("DismortgageBillServiceImpl")
public class DismortgageBillServiceImpl implements IDismortgageBillService,DealEndFlowService,DealInFlowService {
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@Resource(name=IScfWorkFlowService.BEAN_ID)
	IScfWorkFlowService scfWorkFlowService;
	
	/**
	 * 保证金及现金等价物信息
	 */
	@Resource(name = "CompositeMngServiceImpl")
	ICompositeMngService compositemngservice;
	
	@Resource(name = "BCrrLnConServiceImpl")
	IBCrrLnConService bcrrlnconservice;
	
	@Resource(name = "AmountServiceImpl")
	IAmountService amountService;
	
	@Resource(name = "ContractServiceImpl")
	IContractService contractservice;
	
	@Autowired
	IProcessService processService;//发起工作流
	
	@Override
	public Page queryListByPage(int pageNo, int pageSize,BCrrLnConCash bCrrLnConCash)
	{
		log.debug("列表查询开始===================");
		Page page = new Page(pageSize, pageNo, 0);
		
		return page;
	}
	/**
	 * 点击申请发起按钮启动工作流
	 */
	@Override
	public String StartUpdater(BCrrLnConCash bCrrLnConCash) throws ScubeBizException
	{
		//启动工作流
		OldApplyVO applyVO = new OldApplyVO();
		applyVO.setMastContno(bCrrLnConCash.getAppId());
		applyVO.setCustcd(bCrrLnConCash.getCustId());
		applyVO.setCname(bCrrLnConCash.getCustNm());
		applyVO.setSlaveContno(applyVO.getMastContno());
		String businessnoType=WorkflowConstant.APPLI_TYPE_DISMORTGAGEBILL;
		String workApplyType=WorkflowConstant.PROCNAME_DIS_MORTGAGE_BILL;
		String appno = compositemngservice.saveApplyBaseInfo(applyVO,businessnoType,workApplyType);

		//工作流开始
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("modelId", WorkflowConstant.PROCNAME_DIS_MORTGAGE_BILL);
		paramMap.put("NodeId", WorkflowConstant.POOLREPAY_WRITE);
		paramMap.put("startedUserId", ContextHolder.getUserInfo().getTlrNo());
		try {
			scfWorkFlowService.commonStartFlow(appno,workApplyType, workApplyType,paramMap);
		} catch (FlowsharpException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return appno;
	}
	
	/**
	 * 获取任务信息
	 * @param appno
	 * @return
	 */
	@Override
	public BPbcAppliBaseInfo findBPbcAppliBaseInfoByAppno(String appno)
	{
		log.debug("appno:"+appno);
		String process = WorkflowConstant.PROCNAME_DIS_MORTGAGE_BILL;
		return scfWorkFlowService.findBPbcAppliBaseInfoByAppno(appno,process);
	}
	
	/**
	 * 获取主合同信息
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Page DismortgageBillWriteContGetter(BCrrLnConCash bCrrLnConCash) throws ScubeBizException
	{
		String appno = bCrrLnConCash.getAppno();
		String mastContno = bCrrLnConCash.getAppId();
		String subContno = bCrrLnConCash.getSubContno();
		//放款合同号
		BPbcAppliBaseInfo tblAppliBaseInfo = compositemngservice.getTblAppliBaseInfo(appno);

		if(mastContno == null || mastContno.trim().equals("")){
			mastContno = tblAppliBaseInfo.getMastContno();
		}
		if(subContno == null || subContno.trim().equals("")){
			subContno = tblAppliBaseInfo.getSlaveContno();
		}

		Page pageQueryResult = new Page();
		MastContQryVO commonQueryVO1 = new MastContQryVO();
		commonQueryVO1.setMastContno(mastContno);
		List querResult = bcrrlnconservice.getMastContExceptLCMastCont(commonQueryVO1);
		if(querResult.size()==0){
			pageQueryResult.setRecords(querResult);
			return pageQueryResult;
		}
		MastContVO contractVO = (MastContVO) querResult.get(0);

		MastContVO contractMngVO = new MastContVO();
		BeanUtils.copyProperties(contractVO, contractMngVO);
		if(StringUtil.isEmpty(contractVO.getVidNo())){
			throw new ScubeBizException("合同关联协议不存在，请先将合同补充完整！", RBcpErrorConstant.ERROR_CODE_PARAM_NOT_EXIST);
		}
//		List slavenoList=DAOUtils.getTblContSlaveInfoDAO().getSlaveContnoByOtherprotocolNo(contractVO.getBusinessNo());
//		String slaveContno="";
//		if(slavenoList!=null&&slavenoList.size()>0){
//			slaveContno=(String)slavenoList.get(0);
//		}
		com.huateng.scf.bas.common.model.AmountVO amountVO = new com.huateng.scf.bas.common.model.AmountVO(contractVO.getVidBusiTyp(),contractVO.getVidNo(),contractVO.getVidNo(),null,ScfBasConstant.ARRIVED_MANAGE_MODE_POOL);
		AmountVO amountVO2 = new AmountVO();
		BeanUtils.copyProperties(amountVO, amountVO2);
		BigDecimal openAmount=amountService.getPant(amountVO2);
		contractMngVO.setBailAmount(amountVO.getAccountAmount());//保证金及现金等价物金额
//		contractMngVO.setAmount(contractVO.getContAmount().toString());//从主合同中取得合同金额
		contractMngVO.setOpenAmount(openAmount);//敞口
		contractMngVO.setSupplyChainPdNm(bCrrLnConCash.getVidPrdNm());
//		contractMngVO.setMortgageAmount(amountVO.getTotPrice());//计算押品总价值
//		if(contractMngVO.getLoanType()==null){
//			contractMngVO.setLoanType("01");
//		}

		List list = new ArrayList();
		list.add(contractMngVO);
		pageQueryResult.setRecords(list);
		return pageQueryResult ;
	}
	
	/**
	 * 融资列表Write
	 * @param pageNo
	 * @param pageSize
	 * @param bCrrLnConCash
	 * @return
	 * @throws ScubeBizException
	 */
	@Override
	public Page DismortgageBillLnciGetter(int pageNo, int pageSize,BCrrLnConCash bCrrLnConCash) throws ScubeBizException
	{
		String appno = bCrrLnConCash.getAppno();
		String mastContno = bCrrLnConCash.getAppId();
		String subContno = bCrrLnConCash.getSubContno();
		String custcd = bCrrLnConCash.getCustId();
		BPbcAppliBaseInfo tblAppliBaseInfo = compositemngservice.getTblAppliBaseInfo(appno);

		if(subContno == null || "".equals(subContno)){
			subContno = tblAppliBaseInfo.getSlaveContno();
		}
		if(mastContno == null || "".equals(mastContno)){
			mastContno = tblAppliBaseInfo.getMastContno();
		}
		if(custcd == null || "".equals(custcd)){
			custcd = tblAppliBaseInfo.getCustcd();
		}

//		//放款合同号
//		String subContno = tblAppliBaseInfo.getSlaveContno();

		OldCommonQueryVO commonQueryVO = new OldCommonQueryVO();
		commonQueryVO.setSubContno_Q(subContno);
		commonQueryVO.setMastContno_Q(mastContno);
		commonQueryVO.setCustcd_Q(custcd);
		commonQueryVO.setAppno_Q(appno);
		commonQueryVO.setPageIndex(pageNo);
		commonQueryVO.setPageSize(pageSize);
		Page page = contractservice.getLnciBaseInfoWriteByParamGetter(commonQueryVO);//查询全部合同全部借据;
		//查询数据与page数据相同
//		Page page2 = contractservice.getLnciBaseInfoByParamGetter(commonQueryVO);//查询已选择的借据
//		List list = page.getRecords();
//		List list2 = page2.getRecords();
//		if(list2!=null && list2.size()>0){
//			for(int i = 0 ; i < list2.size() ; i++)
//				for(int j = 0 ; j < list.size() ; j++){
//					BLanLnciBase base = (BLanLnciBase) list.get(j);
//					BLanLnciBase base2 = (BLanLnciBase) list2.get(i);
//					String debtNo=base.getDebetNo();
//					String debtNoSelect=base2.getDebetNo();
//					if(debtNo.equals(debtNoSelect)){
//						//((OldContractVO)list.get(j)).setSelect(true); //借据号相同时，设置select为true
//						//((OldContractVO)list.get(j)).setBillsAmountView(new BigDecimal(((OldContractVO)list2.get(i)).getAmount()));
//					}
//			}
//			page.setRecords(list);
//		}
		return page;
	}
	
	/**
	 * 融资列表Approve,已选择的融资列表信息
	 * @param pageNo
	 * @param pageSize
	 * @param bCrrLnConCash
	 * @return
	 * @throws ScubeBizException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Page DismortgageBillApproveLnciGetter(int pageNo, int pageSize,BCrrLnConCash bCrrLnConCash) throws ScubeBizException
	{
		String appno = bCrrLnConCash.getAppno();
		String mastContno = bCrrLnConCash.getAppId();
		String subContno = bCrrLnConCash.getSubContno();
		String custcd = bCrrLnConCash.getCustId();
		BPbcAppliBaseInfo tblAppliBaseInfo = compositemngservice.getTblAppliBaseInfo(appno);

		if(subContno == null || "".equals(subContno)){
			subContno = tblAppliBaseInfo.getSlaveContno();
		}
		if(mastContno == null || "".equals(mastContno)){
			mastContno = tblAppliBaseInfo.getMastContno();
		}
		if(custcd == null || "".equals(custcd)){
			custcd = tblAppliBaseInfo.getCustcd();
		}

//		//放款合同号
//		String subContno = tblAppliBaseInfo.getSlaveContno();

		OldCommonQueryVO commonQueryVO = new OldCommonQueryVO();
		commonQueryVO.setSubContno_Q(subContno);
		commonQueryVO.setMastContno_Q(mastContno);
		commonQueryVO.setCustcd_Q(custcd);
		commonQueryVO.setAppno_Q(appno);
		commonQueryVO.setPageIndex(pageNo);
		commonQueryVO.setPageSize(pageSize);
		Page page = contractservice.getAppliLnciBaseInfo(commonQueryVO);
//		List list = page.getRecords();
//		if(list!=null && list.size()>0){
//			for(int i = 0 ; i < list.size() ; i++){
//				((OldContractVO)list.get(i)).setSelect(true);
//				//((OldContractVO)list.get(i)).setBillsAmountView(new BigDecimal(((OldContractVO)list.get(i)).getAmount()));
//			}
//		}
		Iterator it= page.getRecords().iterator();
    	List list1 = new ArrayList();
    	while(it.hasNext()){
    		BLanLnciBase vo = (BLanLnciBase)it.next();//从扩展表获取追加现金及等价物
//    		vo.setRefundAmount(dao.getMsExtLnciRefundAmount(MSDAOUtils.getMsTblLnciBaseInfoDAO().get(vo.getDebetNo())));
    		if(vo.getLnciType()==null){
    			vo.setLnciType("01");
    		}
    		if(vo.getLnciStatus()==null){
    			vo.setLnciStatus("1");
    		}
    		list1.add(vo);
    	}
    	page.setRecords(list1);
		return page;
	}
	
	/**
	 * 现金等价物列表
	 */
	@Override
	public Page DismortgageBillwriteBillGetter(int pageNo, int pageSize,BCrrLnConCash bCrrLnConCash)
	{
		String appno = bCrrLnConCash.getAppno();
		BPbcAppliBaseInfo tblAppliBaseInfo = compositemngservice.getTblAppliBaseInfo(appno);
		String debetNo_Q = bCrrLnConCash.getDebetNo();
		//放款合同号
		String mastContno = tblAppliBaseInfo.getMastContno();
		OldCommonQueryVO commonQueryVO = new OldCommonQueryVO();
		commonQueryVO.setMastContno_Q(mastContno);
		commonQueryVO.setDebetNo_Q(debetNo_Q);
		commonQueryVO.setPageIndex(pageNo);
		commonQueryVO.setPageSize(pageSize);
		Page pageQueryResult = contractservice.getBillCustAccountInfoByParam(commonQueryVO);
		if(null == pageQueryResult){
			pageQueryResult = new Page();
		}
		/**
		 * 在页面JS中进行处理
		 */
//		List list = pageQueryResult.getRecords();
//		if(list!=null){
//			for(int i = 0 ; i<list.size() ; i++){
//				BMrnAcctBussInfo acctBussInfo = (BMrnAcctBussInfo) list.get(i);
//				acctBussInfo.setLastUpdTime(null);
//				OldContractVO vo = new OldContractVO();
//				BeanUtils.copyProperties(acctBussInfo, vo);
//				vo.setValue(vo.getBailAmount().multiply(vo.getBailRate().divide(new BigDecimal(100))));
//				//((OldContractVO) list.get(i)).setValue(vo.getBailAmount());
//			}
//		}
		return pageQueryResult;
	}
	
	/**
	 * 现金等价物列表已选择
	 * @param appno
	 * @return
	 * @throws ScubeBizException
	 */
	@Override
	public Page DismortgageBillApproveBillGetter(String appno) throws ScubeBizException
	{
		BPbcAppliBaseInfo tblAppliBaseInfo = compositemngservice.getTblAppliBaseInfo(appno);
		//放款合同号
		String subContno = tblAppliBaseInfo.getSlaveContno();
		OldCommonQueryVO commonQueryVO = new OldCommonQueryVO();
		commonQueryVO.setSubContno_Q(subContno);
		commonQueryVO.setAppno_Q(appno);
		Page page = contractservice.getBillCustAccountInfoApproveByParam(commonQueryVO);
		return page;
	}
	
	/**
	 * 提交审批
	 * @throws ScubeBizException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void DismortgageBillWriteUpdater(OldApplyVO cont,List billList,List lnciList,boolean isProcess) throws ScubeBizException
	{
		//录入现金等价物解押信息，提交工作流
		if(billList == null || billList.size()<1){
			throw new ScubeBizException("该主合同下未绑定现金等价物，无法发起流程",RBcpErrorConstant.RECORD_NOT_EXIST);
		}
		String warnString = "ok";
		try {
			warnString = compositemngservice.writeDismortgaegeBill(cont,billList,lnciList);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			throw new ScubeBizException("拷贝属性出错，您录入信息不全！", RBcpErrorConstant.RECORD_NOT_EXIST);
		} catch (InvocationTargetException e) {
			e.printStackTrace();
			throw new ScubeBizException("拷贝属性出错，您录入信息不全！", RBcpErrorConstant.RECORD_NOT_EXIST);
		}
		for(int i = 0 ; i<billList.size() ; i++){
			Map<String, Object> appliBussInfo = (Map<String, Object>) billList.get(i);
//			OldApplyVO vo = new OldApplyVO();
//			BeanUtils.copyProperties(appliBussInfo, vo);
			//只有银票贴现与存单还款可以转出,给出提示可以继续流程，否则弹出提示框，不允许轮转流程
			String bailType = appliBussInfo.get("bailType").toString();
			String accountType = appliBussInfo.get("accountType").toString();
			if(!"ok".equals(warnString) &&
					!(("01".equals(bailType)&&"1".equals(accountType)) ||
							("02".equals(bailType)&&"2".equals(accountType)))){
				throw new ScubeBizException(warnString, RBcpErrorConstant.RECORD_NOT_EXIST);
			}
		}
		if(isProcess)
		{
			processTasks(cont.getAppno());
		}
	}
	
	/**
	 * 货权内空岗审批
	 * @param appno
	 * @throws ScubeBizException
	 */
	@Override
	public void DismortgageBillApproveUpdater(String appno,boolean isProcess) throws ScubeBizException
	{
		//货权内控岗审批
		//插入通知书表
		CommonApplyDtlInfoVO commAppInfoVo = new CommonApplyDtlInfoVO();
		commAppInfoVo.setBussAppno(appno);
		compositemngservice.saveNotice(commAppInfoVo);
		if(isProcess)
		{
			processTasks(appno);
		}
	}
	
	/**
	 * 复核岗审批
	 * @param appno
	 * @throws ScubeBizException
	 */
	@Override
	public void DismortgageBillConfirmUpdater(String appno,boolean isProcess) throws ScubeBizException
	{
		if(isProcess)
		{
			processTasks(appno);
		}
	}
	
	/**
	 * 审批通过
	 * @param appno
	 * @throws ScubeBizException
	 */
	@Override
	public void DismortgageBillPrintUpdater(String appno,boolean isProcess) throws ScubeBizException
	{
		//打印通知书
		CommonApplyDtlInfoVO commAppInfoVo = new CommonApplyDtlInfoVO();
		commAppInfoVo.setBussAppno(appno);
		compositemngservice.dealPrint(commAppInfoVo);
		if(isProcess)
		{
			processTasks(appno);
		}
	}
	
	/**
	 * 退回
	 */
	@Override
	public void DismortgageBillGoBackUpdater(String appno,boolean isProcess) throws ScubeBizException
	{
		if(isProcess)
		{
			String status = WorkflowConstant.WORKFLOW_TRANS_GOBACK;
			BPbcAppliBaseInfo appliinfo = findBPbcAppliBaseInfoByAppno(appno);
			try {
				scfWorkFlowService.processTasks(appliinfo, status);
			} catch (FlowsharpException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void processTasks(String appno)
	{
		//流程流转
		String status = WorkflowConstant.WORKFLOW_TRANS_AGREE;
		BPbcAppliBaseInfo appliinfo = findBPbcAppliBaseInfoByAppno(appno);
		try {
			scfWorkFlowService.processTasks(appliinfo, status);
		} catch (FlowsharpException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void doWorkForPass(String appNo) {
		DismortgageBillPrintUpdater(appNo, false);
	}
	@Override
	public void doWorkForReject(String appNo) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void doWorkForBack(String appNo) {
		String status = WorkflowConstant.WORKFLOW_TRANS_GOBACK;
		BPbcAppliBaseInfo appliinfo = findBPbcAppliBaseInfoByAppno(appNo);
		try {
			scfWorkFlowService.processTasks(appliinfo, status);
		} catch (FlowsharpException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void doWorkForSubmit(String appNo) throws ScubeBizException {
		String process = WorkflowConstant.PROCNAME_DIS_MORTGAGE_BILL;
		BPbcAppliBaseInfo pbcinfo = scfWorkFlowService.findBPbcAppliBaseInfoByAppno(appNo,process);
		String processId = pbcinfo.getPiid();
		NodeEntity nodeEntity = new NodeEntity();
		try {
			nodeEntity = processService.getCurrentNodeEntity(processId);
		} catch (FlowsharpException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String nodeId = nodeEntity.getId();
		if(nodeId.equals("Approve"))
		{//货权内空岗审批
			DismortgageBillApproveUpdater(appNo, false);
		}
		if(nodeId.equals("confirm"))
		{//复核岗审批
		}
		if(nodeId.equals("end"))
		{//审批通过
			DismortgageBillPrintUpdater(appNo, false);
		}
	}
}
