package com.huateng.scf.sto.nwr.service.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.huateng.authority.common.ContextHolder;
import com.huateng.base.common.beans.Page;
import com.huateng.flowsharp.entity.FlowsharpException;
import com.huateng.scf.bas.cnt.model.DeliveryQryVO;
import com.huateng.scf.bas.common.constant.IndirectCreditConstant;
import com.huateng.scf.bas.common.constant.NoticeConstant;
import com.huateng.scf.bas.common.constant.ScfBasConstant;
import com.huateng.scf.bas.common.service.IScfIndirectCreditService;
import com.huateng.scf.bas.common.service.IScfWorkFlowService;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.lan.model.BLanAppliLnciBase;
import com.huateng.scf.bas.lan.model.BLanLnciBase;
import com.huateng.scf.bas.lan.service.IBLanAppliLnciBaseService;
import com.huateng.scf.bas.lan.service.IBLanLnciBaseService;
import com.huateng.scf.bas.mrn.model.AppendBailAmountVO;
import com.huateng.scf.bas.mrn.model.BMrnAppliAcctInfo;
import com.huateng.scf.bas.mrn.model.DebetListVO;
import com.huateng.scf.bas.mrn.service.IBMrnAppliAcctInfoService;
import com.huateng.scf.bas.nte.service.IBNteNoticeBaseService;
import com.huateng.scf.bas.pbc.model.BPbcAppliBaseInfo;
import com.huateng.scf.bas.pbc.service.IBPbcAppliBaseInfoService;
import com.huateng.scf.bas.pbc.vo.MortgageApplyVO;
import com.huateng.scf.bas.sys.constant.WorkflowConstant;
import com.huateng.scf.sto.nwr.service.IBillNormalDeliveryApplyService;
import com.huateng.scf.sto.nwr.service.IBillStandardPledgeAppService;
import com.huateng.scf.sto.nwr.service.IDeliveryApplyService;
import com.huateng.scf.sto.nwr.vo.BillNormalAppVO;
import com.huateng.scf.sto.nwr.vo.BillNormalMortgageQryVO;
import com.huateng.scf.sto.nwr.vo.BillNormalMortgageVO;
import com.huateng.scf.sto.nwr.vo.BillNormalVO;
import com.huateng.scf.sto.nwr.vo.DeliveyApplyVO;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * 
 * <p>非标仓单提货接口实现类</p>
 *
 * @author 	mengjiajia
 * @date 	2017年4月26日上午10:01:17
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2017年4月26日上午10:01:17	     新增
 *
 * </pre>
 */
@ScubeService
@Service("BillNormalDeliveryApplyServiceImpl")
public class BillNormalDeliveryApplyServiceImpl implements IBillNormalDeliveryApplyService 
{
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@Resource(name = "BillStandardPledgeAppServiceImpl")
	IBillStandardPledgeAppService billstandardpledgeappservice;
	
	//自定义流程公共类
	@Resource(name = IScfWorkFlowService.BEAN_ID)
	IScfWorkFlowService scfWorkFlowService;
	
	//业务申请表
	@Resource(name = "BPbcAppliBaseInfoServiceImpl")
	IBPbcAppliBaseInfoService bpbcapplibaseinfoservice;
	
	@Resource(name = "BNteNoticeBaseServiceImpl")
	IBNteNoticeBaseService bntenoticebaseservice;
	
	//间接额度处理
	@Resource(name = IScfIndirectCreditService.BEAN_ID)
	IScfIndirectCreditService scfindirectcreditservice;
	
	//借据信息
	@Resource(name = "BLanLnciBaseServiceImpl")
	IBLanLnciBaseService blanlncibaseservice;
	
	//借据申请信息
	@Resource(name = IBLanAppliLnciBaseService.BEAN_ID)
	IBLanAppliLnciBaseService blanapplilncibaseservice; 
	
	@Resource(name = "DeliveryApplyServiceImpl")
	IDeliveryApplyService deliveryapplyservice;

	@Resource(name = "BMrnAppliAcctInfoServiceImpl")
	IBMrnAppliAcctInfoService bmrnappliacctinfoservice;
	
	/**
	 * 查询已质押可以提货的仓单
	 * @param pageNo
	 * @param pageSize
	 * @param billNormalVO
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年4月26日上午11:04:48
	 */
	@Override
	public Page BillNormalDeliverableListGetter(int pageNo, int pageSize, BillNormalVO  billNormalVO) throws ScubeBizException
	{
		log.debug("非标仓单提货列表查询=======================================");
		billNormalVO.setPageIndex(pageNo);
		billNormalVO.setPageSize(pageSize);
		Page page = billstandardpledgeappservice.getBillNormalDeliverableList(billNormalVO);
		return page;
	}
	
	/**
	 * 非标仓单提货申请信息
	 * @param billNormalAppVO
	 * @return
	 * @author 	mengjiajia
	 * @date 	2017年4月26日下午1:34:29
	 */
	@Override
	public DeliveyApplyVO BillNormalDeliveryApplyInfoGetter(BillNormalAppVO billNormalAppVO) 
	{
		DeliveyApplyVO deliveyApplyVO = billstandardpledgeappservice.getBillNormalDeliveryInfo(billNormalAppVO);
		return deliveyApplyVO;
	}
	
	/**
	 *  任务基本信息
	 */
	@Override
	public BPbcAppliBaseInfo findRBcpAppliBussInfoByAppno(String appno) {
		String process = WorkflowConstant.PROCNAME_NORMAL_BILL_DELIVERY_APPLY;
		return scfWorkFlowService.findBPbcAppliBaseInfoByAppno(appno, process);
	}
	
	/**
	 * 非标仓单提货 仓单列表信息查询
	 * @param mortgageQryVO
	 * @return
	 * @author 	mengjiajia
	 * @date 	2017年4月26日下午2:30:11
	 */
	@Override
	public Page BillNormalDeliveryListGetter(int pageNo, int pageSize, BillNormalMortgageQryVO mortgageQryVO)
	{
		mortgageQryVO.setPageIndex(pageNo);
		mortgageQryVO.setPageSize(pageSize);
		Page page = billstandardpledgeappservice.getBillNormalDeliveryList(mortgageQryVO);
		return page;
	}
	
	/**
	 * 非标仓单提货 押品查询
	 * @param pageNo
	 * @param pageSize
	 * @param mortgageQryVO
	 * @return
	 * @author 	mengjiajia
	 * @date 	2017年4月26日下午2:53:23
	 */
	@Override
	public Page BillNormalDeliveryApplyListGetter(int pageNo, int pageSize, BillNormalMortgageQryVO mortgageQryVO)
	{
		mortgageQryVO.setPageIndex(pageNo);
		mortgageQryVO.setPageSize(pageSize);
		Page page = billstandardpledgeappservice.getBillNormalDeliveryApplyList(mortgageQryVO);
		return page;
	}
	
	/**
	 * 非标仓单申请保存发起
	 * @param deliveyApplyVO
	 * @param billList
	 * @param mortList
	 * @author 	mengjiajia
	 * @date 	2017年4月26日下午4:59:52
	 */
	@Override
	public String BillNormalDeliveryApplySaveUpdater(DeliveyApplyVO deliveyApplyVO, List<BillNormalMortgageVO> billList, List<MortgageApplyVO>  mortList)
	{
		String appno=deliveyApplyVO.getAppno();
		if(StringUtil.isEmpty(appno))
		{
			String appliType = WorkflowConstant.APPLI_TYPE_BILL_NORMAL_DELIVERY_APPLY;
			String workApplyType = WorkflowConstant.PROCNAME_NORMAL_BILL_DELIVERY_APPLY;
			deliveyApplyVO.setProcessTemplateName(workApplyType);
			deliveyApplyVO.setAppliType(appliType);
			//保存信息到申请基本信息表，生成appno并返回
			appno = billstandardpledgeappservice.normalDeliverApplySaveBaseInfo(deliveyApplyVO);
			//工作流开始
			HashMap<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("modelId", WorkflowConstant.PROCNAME_NORMAL_BILL_DELIVERY_APPLY);
			paramMap.put("NodeId", WorkflowConstant.PROCNODE_APPLY);
			paramMap.put("startedUserId", ContextHolder.getUserInfo().getTlrNo());
			try {
				scfWorkFlowService.commonStartFlow(appno,workApplyType, workApplyType, paramMap);
			} catch (FlowsharpException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else
		{
				// 更新业务申请基本信息
			billstandardpledgeappservice.normalDeliverApplySaveBaseInfo(deliveyApplyVO);
		}
		if(!StringUtil.isEmpty(appno))
		{
			//bill
			billstandardpledgeappservice.saveAppliMortgageBillNormal(billList,appno);
			//mortgage
			billstandardpledgeappservice.saveAppliMortgageDeliverList(mortList,appno);
		}
		return appno;
	}
	
	/**
	 * 非标仓单提货申请提交
	 * @param deliveyApplyVO
	 * @param billList
	 * @param mortList
	 * @author 	mengjiajia
	 * @date 	2017年4月27日上午11:07:30
	 */
	@Override
	public void BillNormalDeliveryApplySubmitUpdater(DeliveyApplyVO deliveyApplyVO, List<BillNormalMortgageVO> billList, List<MortgageApplyVO>  mortList)
	{
		if(StringUtil.isEmpty(deliveyApplyVO.getAppno())){
			throw new ScubeBizException("appno丢失！");
		}
		billstandardpledgeappservice.normalDeliverApplySaveBaseInfo(deliveyApplyVO);
		 //校验数据
		billstandardpledgeappservice.checkbillNormalDeliveryBailAmount(deliveyApplyVO);
			//bill
		billstandardpledgeappservice.saveAppliMortgageBillNormal(billList,deliveyApplyVO.getAppno());
			//mortgage
		billstandardpledgeappservice.saveAppliMortgageDeliverList(mortList,deliveyApplyVO.getAppno());
		//notice
		bntenoticebaseservice.saveBillNormalDeliveryNotice(deliveyApplyVO,billList,mortList);
		// 工作流处理
		String status = WorkflowConstant.WORKFLOW_TRANS_AGREE;//跳转下一节点
		BPbcAppliBaseInfo applibaseinfo = bpbcapplibaseinfoservice.findBPbcAppliBaseInfoByKey(deliveyApplyVO.getAppno());
		try {
			scfWorkFlowService.processTasks(applibaseinfo,status);
		} catch (FlowsharpException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 非标仓单 提货 审批
	 * @param appno
	 * @author 	mengjiajia
	 * @date 	2017年4月27日下午2:45:25
	 */
	@Override
	public void BillNormalDeliveryApplyIssuedUpdate(DeliveyApplyVO deliveyApplyVO, boolean flag)
	{
		String status = "";
		if(flag)
		{
			status = WorkflowConstant.WORKFLOW_TRANS_AGREE;//跳转下一节点
			billstandardpledgeappservice.billNormalDeliveryUpdateBailAmount(deliveyApplyVO.getAppno());
			//签发通知书
			bntenoticebaseservice.modifyNoticeBaseInfo(deliveyApplyVO.getAppno(),NoticeConstant.NOTICE_BASE_STATUS_CONFIRM_APPROVED);
			
		}
		else
		{
			status = WorkflowConstant.WORKFLOW_TRANS_BACKTOLAST;//跳转下一节点
		}
		BPbcAppliBaseInfo applibaseinfo = bpbcapplibaseinfoservice.findBPbcAppliBaseInfoByKey(deliveyApplyVO.getAppno());
		applibaseinfo.setComment(deliveyApplyVO.getTaskComment());
		try {
			scfWorkFlowService.processTasks(applibaseinfo,status);
		} catch (FlowsharpException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	/**
	 * 非标仓单提货 回执
	 * @param deliveyApplyVO
	 * @author 	mengjiajia
	 * @date 	2017年4月27日下午4:37:14
	 */
	@Override
	public void BillNormalDeliveryApplyReceiptUpdate(DeliveyApplyVO deliveyApplyVO)
	{
		//校验数据
		billstandardpledgeappservice.checkBillNormalDeliveryStatus(deliveyApplyVO.getAppno());
		//更新通知书
		bntenoticebaseservice.modifyNoticeBaseInfo(deliveyApplyVO.getAppno(),NoticeConstant.NOTICE_BASE_STATUS_CONFIRM_AGREE);
		//更新提货申请审批通过后的数据同步 写正式表
		deliveryapplyservice.doDeliveryMortgage(deliveyApplyVO.getAppno());
		//释放额度 start
		BLanLnciBase tblLnciBaseInfo = blanlncibaseservice.getTblLnciBaseInfoByBussAppNo(deliveyApplyVO.getAppno());
		String hasIndirectCredit="";
		if(null!=tblLnciBaseInfo){
			BLanAppliLnciBase tblAppliLnciBaseInfo = blanapplilncibaseservice.findBLanAppliLnciBaseByDebtId(tblLnciBaseInfo.getDebetId());
			hasIndirectCredit = tblAppliLnciBaseInfo.getHasIndirectCredit()==null?"":tblAppliLnciBaseInfo.getHasIndirectCredit().trim();
		}

		if(ScfBasConstant.FLAG_ON.equals(hasIndirectCredit)){//有间接额度
			BPbcAppliBaseInfo tblAppliBaseInfo = bpbcapplibaseinfoservice.findBPbcAppliBaseInfoByKey(deliveyApplyVO.getAppno());
			if(null==tblAppliBaseInfo)
			{
				throw new ScubeBizException("业务申请记录丢失,无法更新！");
			}
			//03-释放
			Map indirectMap=new HashMap();
			indirectMap.put(IndirectCreditConstant.APP_NO, deliveyApplyVO.getAppno());
			indirectMap.put(IndirectCreditConstant.DEBIT_NO, null);
			indirectMap.put(IndirectCreditConstant.OPER_TYPE, ScfBasConstant.CREDIT_TRADE_TYPE_RELEASE);//操作类型-应收账款回款释放
			scfindirectcreditservice.indCreditAppliCommonProcess(indirectMap, tblAppliBaseInfo.getBailAmount());
		}
		//释放额度 end
		String status = WorkflowConstant.WORKFLOW_TRANS_AGREE;
		BPbcAppliBaseInfo applibaseinfo = bpbcapplibaseinfoservice.findBPbcAppliBaseInfoByKey(deliveyApplyVO.getAppno());
		applibaseinfo.setComment(deliveyApplyVO.getTaskComment());
		try {
			scfWorkFlowService.processTasks(applibaseinfo,status);
		} catch (FlowsharpException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 保证金追加页基本信息查询
	 * @param deliveyApplyVO
	 * @return
	 * @author 	mengjiajia
	 * @date 	2017年4月27日下午7:25:42
	 */
	@Override
	public AppendBailAmountVO AppendBailAmountGetter(DeliveryQryVO deliveryQryVO)
	{
		String operationType = deliveryQryVO.getOperationType();//操作类型
		String businessNo = deliveryQryVO.getBusinessNo();//业务关联编号：借据，质押合同，协议号等
		BigDecimal addBailAmount = deliveryQryVO.getAddBailAmount();//追加保证金金额
		String appno = deliveryQryVO.getAppno();  //申请号
		
		if(addBailAmount == null && !StringUtil.isEmpty(appno))
		{
			BPbcAppliBaseInfo appliBaseInfo = bpbcapplibaseinfoservice.findBPbcAppliBaseInfoByKey(appno);
			if(appliBaseInfo != null && appliBaseInfo.getBailAmount() != null )
			{
				addBailAmount = appliBaseInfo.getBailAmount();
			}
		}
		AppendBailAmountVO appendBailAmountVO = new AppendBailAmountVO();
		if(ScfBasConstant.BAIL_ADD_OP_TYPE_CHATTLE_DELIVERY.equals(operationType)
				||ScfBasConstant.BAIL_ADD_OP_TYPE_BILLNORMAL_DELIVERY.equals(operationType)){
			appendBailAmountVO = deliveryapplyservice.getAddBailAmountBySlaveContno(businessNo,addBailAmount);
		}else if(ScfBasConstant.BAIL_ADD_OP_TYPE_ASSURE_DELIVERY.equals(operationType)){
			appendBailAmountVO = deliveryapplyservice.getAddBailAmountByDebetNo(businessNo,addBailAmount);
		}else if(ScfBasConstant.BAIL_ADD_OP_TYPE_BILLFIRST_DELIVERY.equals(operationType)){
			appendBailAmountVO = deliveryapplyservice.getAddBailAmountBySlaveContno(businessNo,addBailAmount);
		}else if(ScfBasConstant.BAIL_ADD_OP_TYPE_MONILINE_ADJUST.equals(operationType)){
			appendBailAmountVO = deliveryapplyservice.getAddBailAmountBySlaveContno(businessNo,addBailAmount);
		}
		//汽车货押提货、换货 add by fengjinfu 20130717
		else if(ScfBasConstant.BAIL_ADD_OP_TYPE_CARMORT_DELIVERY.equals(operationType) || ScfBasConstant.BAIL_ADD_OP_TYPE_CARMORT_REPLACE.equals(operationType)){
			appendBailAmountVO = deliveryapplyservice.getAddBailAmountBySlaveContno(businessNo,addBailAmount);
		}
		appendBailAmountVO.setAppno(appno);
		return appendBailAmountVO;
	}
	
	/**
	 * 借据信息查询
	 * @param pageNo
	 * @param pageSize
	 * @param deliveyApplyVO
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年4月27日下午8:06:07
	 */
	@Override
	public Page DebetListGetter(int pageNo, int pageSize, DeliveryQryVO deliveryQryVO) throws ScubeBizException
	{
		String appno = deliveryQryVO.getAppno();
		String id = deliveryQryVO.getId();
		deliveryQryVO.setPageIndex(pageNo);
		deliveryQryVO.setPageSize(pageSize);
		Page page = new Page();
		if(!StringUtil.isEmpty(appno))
		{
			page = deliveryapplyservice.getAddBailAmountListByAppno(appno,pageNo,pageSize);//根据appno查询借据信息
		}
		else
		{
			id = id==null?"-1":id;
			deliveryQryVO.setBusinessNo(id);
			page = deliveryapplyservice.getLnciBaseInfoByDebetNo(deliveryQryVO);;
		}
		return page;
	}
	
	/**
	 * 保证金冻结借据信息查询
	 * @param pageNo
	 * @param pageSize
	 * @param deliveryQryVO
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年4月28日上午10:36:24
	 */
	@Override
	public Page DebetListAddGetter(int pageNo, int pageSize, DeliveryQryVO deliveryQryVO) throws ScubeBizException
	{
		deliveryQryVO.setPageIndex(pageNo);
		deliveryQryVO.setPageSize(pageSize);
		Page pageQueryResult = deliveryapplyservice.getDebetList(deliveryQryVO);
		return pageQueryResult;
	}
	
	/**
	 * 保证金追加信息保存
	 * @param appendBailAmountVO
	 * @param bailList
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年4月28日下午2:02:57
	 */
	@Override
	public void AppendBailAmountUpdate(AppendBailAmountVO appendBailAmountVO, List<DebetListVO> bailList) throws ScubeBizException
	{
    	//1、获得冻结保证金列表
    	List<BMrnAppliAcctInfo> accountList = bmrnappliacctinfoservice.findBMrnAppliAcctInfoByAppno(appendBailAmountVO.getAppno());
    	//2、删除已存在押品列表
    	for (int i = 0; i < accountList.size(); i++) {
    		BMrnAppliAcctInfo bean = (BMrnAppliAcctInfo)accountList.get(i);
    		bmrnappliacctinfoservice.delete(bean);
		}
    	//3、添加冻结保证金列表
    	for (int i=0;i<bailList.size();i++) 
    	{
    		DebetListVO debetListVO = (DebetListVO)bailList.get(i);
    		BMrnAppliAcctInfo bean = new BMrnAppliAcctInfo();
			bean.setAppno(appendBailAmountVO.getAppno());
			bean.setDebetNo(debetListVO.getDebetNo());
			bean.setBailAccountno(debetListVO.getBailAccount());
			bean.setBailAmount(debetListVO.getAddBailAmount());
			bean.setMastContno(debetListVO.getMastContno());
			bean.setCustcd(appendBailAmountVO.getCustcd());
			bean.setBailType(ScfBasConstant.BAIL_TYPE_NORMAL);//保证金
			bean.setInitType(ScfBasConstant.INIT_TYPE_INIT);//追加
			bean.setConfirmStatus(ScfBasConstant.CONFIRM_STATUS_CONFIRMED);//已确认
			bean.setProtocolNo(appendBailAmountVO.getProtocolNo());
			bean.setSlaveContno(appendBailAmountVO.getSlaveContno());
			bean.setAmount(appendBailAmountVO.getAddBailAmount());
			bean.setId(null);
			bmrnappliacctinfoservice.add(bean);
		}
	}
}
