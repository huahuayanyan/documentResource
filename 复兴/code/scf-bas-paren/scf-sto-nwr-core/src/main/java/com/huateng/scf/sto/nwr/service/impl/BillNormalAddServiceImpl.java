package com.huateng.scf.sto.nwr.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.huateng.authority.common.ContextHolder;
import com.huateng.base.common.beans.Page;
import com.huateng.flowsharp.entity.FlowsharpException;
import com.huateng.scf.bas.common.constant.NoticeConstant;
import com.huateng.scf.bas.common.constant.ScfBasConstant;
import com.huateng.scf.bas.common.service.IProductService;
import com.huateng.scf.bas.common.service.IScfWorkFlowService;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.crm.dao.IBCrmBaseInfoDAO;
import com.huateng.scf.bas.crr.model.BCrrGntyCon;
import com.huateng.scf.bas.mrn.service.IContractService;
import com.huateng.scf.bas.nte.service.IBNteNoticeBaseService;
import com.huateng.scf.bas.pbc.model.BPbcAppliBaseInfo;
import com.huateng.scf.bas.pbc.service.IBPbcAppliBaseInfoService;
import com.huateng.scf.bas.pbc.service.IBPbcAppliMtgInfoService;
import com.huateng.scf.bas.sys.constant.WorkflowConstant;
import com.huateng.scf.rec.bcp.constant.RBcpErrorConstant;
import com.huateng.scf.sto.nwr.dao.model.SBcpAppliMortBillNormal;
import com.huateng.scf.sto.nwr.model.SBcpMortBillNormalVO;
import com.huateng.scf.sto.nwr.service.IBillManagerService;
import com.huateng.scf.sto.nwr.service.IBillNormalAddService;
import com.huateng.scf.sto.nwr.service.IBillStandardApplyService;
import com.huateng.scf.sto.nwr.service.IBillStandardPledgeAppService;
import com.huateng.scf.sto.nwr.service.ISBcpAppliMortBillNormalService;
import com.huateng.scf.sto.nwr.vo.BillNormalAppVO;
import com.huateng.scf.sto.nwr.vo.BillNormalMortgageQryVO;
import com.huateng.scf.sto.nwr.vo.BillNormalVO;
import com.huateng.scf.sto.nwr.vo.BillStandardBussInfoVO;
import com.huateng.scf.sto.nwr.vo.BillStandardMortgageVO;
import com.huateng.scf.sto.nwr.vo.BillstandardAppVO;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * 
 * <p>仓单追加申请 接口实现类</p>
 *
 * @author 	mengjiajia
 * @date 	2017年5月2日上午9:17:47
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2017年5月2日上午9:17:47	     新增
 *
 * </pre>
 */
@ScubeService
@Service("BillNormalAddServiceImpl")
public class BillNormalAddServiceImpl implements IBillNormalAddService
{
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@Resource(name = "BillStandardPledgeAppServiceImpl")
	IBillStandardPledgeAppService billstandardpledgeappservice;
	
	//自定义流程公共类
	@Resource(name = IScfWorkFlowService.BEAN_ID)
	IScfWorkFlowService scfWorkFlowService;
	
	//产品公共类
	@Resource(name = "ProductServiceImpl")
	IProductService productService;
	
	@Resource(name = "SBcpAppliMortBillNormalServiceImpl")
	ISBcpAppliMortBillNormalService sbcpapplimortbillnormalservice;

	@Resource(name = "ContractServiceImpl")
	IContractService contractservice;
	
	@Resource(name = "BillStandardApplyServiceImpl")
	IBillStandardApplyService billstandardapplyservice;

	//业务申请表
	@Resource(name = "BPbcAppliBaseInfoServiceImpl")
	IBPbcAppliBaseInfoService bpbcapplibaseinfoservice;
	
	//通知书信息
	@Resource(name = "BNteNoticeBaseServiceImpl")
	IBNteNoticeBaseService bntenoticebaseservice;
	
	@Resource(name = "BillManagerServiceImpl")
	IBillManagerService billmanagerservice;
	
	@Resource(name = "IBCrmBaseInfoDAO")
	IBCrmBaseInfoDAO bcrmbaseinfodao;
	
	//押品业务申请表
	@Resource(name = "BPbcAppliMtgInfoServiceImpl")
	IBPbcAppliMtgInfoService bpbcapplimtginfoservice;
	
	
	/**
	 * 普通仓单列表查询
	 * @param pageNo
	 * @param pageSize
	 * @param billNormalVO
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年5月2日上午9:24:09
	 */
	@Override
	public Page BillNormalQueryGetter(int pageNo, int pageSize, BillNormalVO billNormalVO) throws ScubeBizException
	{
		log.debug("仓单追加申请列表查询=====================================");
		String flag = billNormalVO.getFlag();
		if("Review".equals(flag))
		{
		}
		else
		{
			billNormalVO.setFlag(ScfBasConstant.CUST_QUERY_TYPE_BY_MAA);
		}
		billNormalVO.setPageIndex(pageNo);
		billNormalVO.setPageSize(pageSize);
		
		String supplyChainPdId = productService.getBillByMidProductId(ScfBasConstant.BILL_TYPE_NORMAL);
		billNormalVO.setSupplyChainPdId(supplyChainPdId);//设置业务品种
		Page pageQueryResult = billstandardpledgeappservice.getNormalList(billNormalVO);
		return pageQueryResult;
	}
	
	/**
	 *  任务基本信息
	 */
	@Override
	public BPbcAppliBaseInfo findRBcpAppliBussInfoByAppno(String appno) {
		String process = WorkflowConstant.PROCNAME_NORMAL_BILL_ADD_APPLY;
		return scfWorkFlowService.findBPbcAppliBaseInfoByAppno(appno, process);
	}
	
	/**
	 * 普通仓单列表查询
	 * @param pageNo
	 * @param pageSize
	 * @param mortgageQryVO
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年5月2日上午9:58:06
	 */
	@Override
	public Page BillNomalDetailGetter(int pageNo, int pageSize, BillNormalMortgageQryVO mortgageQryVO) 
			throws ScubeBizException
	{
		String appno_Q = mortgageQryVO.getAppno();
		String billno = mortgageQryVO.getBillno();
		if(!StringUtil.isEmpty(appno_Q)&&StringUtil.isEmpty(billno))
		{
			billno = ((SBcpAppliMortBillNormal) sbcpapplimortbillnormalservice.findByProperty(appno_Q).get(0)).getBillno();
		}
		
		SBcpMortBillNormalVO Info = billstandardpledgeappservice.getNormalById(billno);
		Info.setCname(bcrmbaseinfodao.selectById(Info.getCustcd()).getCname());
		Info.setAppno(appno_Q);
		List<SBcpMortBillNormalVO> list = new ArrayList<SBcpMortBillNormalVO>();
		list.add(Info);
		
		Page pageQueryResult = new Page();
		pageQueryResult.setTotalRecord(list.size());
		pageQueryResult.setRecords(list);
		return pageQueryResult;
	}
	
	/**
	 * 非标准仓单追加-点击“保存”
	 * @param billStandardBussInfoVO	需要更新的担保合同信息
	 * @param billNormalList	取得要更新的标准仓单记录
	 * @param billNormalMortList
	 * @author 	mengjiajia
	 * @date 	2017年5月2日上午10:48:33
	 */
	@Override
	public String BillNormalAddAppUpdate(BillStandardBussInfoVO billStandardBussInfoVO,List<BillNormalAppVO> billNormalList, List<BillStandardMortgageVO> billNormalMortList)
	{
		String bussAppno = billStandardBussInfoVO.getAppno();
		String appno = "";
		String appliType = WorkflowConstant.APPLI_TYPE_BILL_NORMAL_ADD_APPLI;
		String workApplyType = WorkflowConstant.PROCNAME_NORMAL_BILL_ADD_APPLY;
		billStandardBussInfoVO.setApplyType(appliType);
		billStandardBussInfoVO.setWorkApplyType(workApplyType);

		if(StringUtil.isEmpty(bussAppno)){

			//保存信息到申请基本信息表，生成appno并返回
			appno = billstandardpledgeappservice.saveAppliBaseInfo(billStandardBussInfoVO);
			//工作流开始
			HashMap<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("modelId", WorkflowConstant.PROCNAME_NORMAL_BILL_ADD_APPLY);
			paramMap.put("NodeId", WorkflowConstant.PROCNODE_APPLY);
			paramMap.put("startedUserId", ContextHolder.getUserInfo().getTlrNo());
			try {
				scfWorkFlowService.commonStartFlow(appno,workApplyType, workApplyType, paramMap);
			} catch (FlowsharpException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			// 更新业务申请基本信息
			billstandardpledgeappservice.updateAppliBaseInfo(billStandardBussInfoVO,false);
	    	appno = bussAppno;
	    }

		//存申请仓单信息
		billstandardpledgeappservice.BillNormalAddApplyInfSave(billNormalList,appno);

		//保存押品信息
		List<BillStandardMortgageVO> updateListYP = new ArrayList<BillStandardMortgageVO>();	// 取得要更新的押品清单记录
		String slaveContno = billStandardBussInfoVO.getSlaveContno();// 担保合同编号

		BillstandardAppVO contractVO = new BillstandardAppVO();
		BCrrGntyCon contSlaveInfo = contractservice.getTblContSlaveInfo(slaveContno);//根据slaveContno获取从合同信息

		BeanUtils.copyProperties(contSlaveInfo, contractVO);
		contractVO.setSlaveContno(contSlaveInfo.getConId());
		contractVO.setProtocolNo( contSlaveInfo.getPrtclNo());
		contractVO.setSecCd(contSlaveInfo.getGutId());
		contractVO.setMastContno(billStandardBussInfoVO.getMastContno());

		// 增删改出质清单（押品列表）
		billstandardapplyservice.addModifyDeleteAppMortgageList(appno, contractVO, billNormalMortList, updateListYP, new ArrayList<BillStandardMortgageVO>());
		return appno;
	}
	
	/**
	 * 普通非标准仓单追加申请提交
	 * @param billStandardBussInfoVO
	 * @param billNormalList
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年5月2日下午2:27:54
	 */
	@Override
	public void BillNorAddAppSubmitUpdate(BillStandardBussInfoVO billStandardBussInfoVO,List<BillNormalAppVO> billNormalList) throws ScubeBizException
	{
		billstandardpledgeappservice.updateAppliBaseInfo(billStandardBussInfoVO,false);
		// 保存业务申请信息
		billstandardpledgeappservice.BillNormalAddApplyInfSave(billNormalList,billStandardBussInfoVO.getAppno());

	 	// 工作流处理
		String status = WorkflowConstant.WORKFLOW_TRANS_AGREE;//跳转下一节点
		BPbcAppliBaseInfo applibaseinfo = bpbcapplibaseinfoservice.findBPbcAppliBaseInfoByKey(billStandardBussInfoVO.getAppno());
		applibaseinfo.setComment(billStandardBussInfoVO.getTaskComment());
		try {
			scfWorkFlowService.processTasks(applibaseinfo,status);
		} catch (FlowsharpException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 标准仓单核价，点击“保存”
	 * @param billNormalVO
	 * @param list
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年5月2日下午3:08:16
	 */
	@Override
	public void BillNormalAddMorgListUpdate(BillNormalVO billNormalVO, List<BillStandardMortgageVO> list) throws ScubeBizException
	{
		String appno = billNormalVO.getAppno();//申请号
		String slaveContno = billNormalVO.getSlaveContno();
		String billnoTemp = billNormalVO.getBillno();
		if (StringUtil.isEmpty(appno))
		{//如果appno为空 则不进行押品信息保存，必须先保存仓单信息产生申请编号
			appno="";
		}
		if(slaveContno == null)
		{
			slaveContno ="";

		}
		String billno = null;
		if(!StringUtil.isEmpty(billnoTemp))
		{
			billnoTemp = billnoTemp.trim();
			try 
			{
				billno = billnoTemp;
			} catch (NumberFormatException e) 
			{
				log.info("------ BillstandardMorgPricingUpdate->saveOrUpdate 从String的billno到Long的billno 时转换出错------");
				e.printStackTrace();
			}
		}
		if(StringUtil.isEmpty(billno)){
			throw new ScubeBizException("仓单号丢失,无法保存押品信息！", RBcpErrorConstant.ERROR_CODE_PARAM_NOT_EXIST);
		}
        /** modified by huaidong.li @2011-7-20 end */
		// 填装押品列表信息
		List<BillStandardMortgageVO> insertList = new ArrayList<BillStandardMortgageVO>();
		List<BillStandardMortgageVO> updateList = new ArrayList<BillStandardMortgageVO>();
		BillStandardMortgageVO applyVO = null;
		for(int i=0;i<list.size();i++)
		{
			applyVO = list.get(i);
			applyVO.setAppliMortBizType(ScfBasConstant.MORT_BIZ_TYPE_NORMAL_PLEDGE_IN); //  申请业务押品清单业务类型[标准仓单质押]
			applyVO.setAppno(appno);
			insertList.add(applyVO);
		}
		
		BillstandardAppVO contractVO = new BillstandardAppVO();
		BCrrGntyCon contSlaveInfo = contractservice.getTblContSlaveInfo(slaveContno);//根据slaveContno获取从合同信息
		BeanUtils.copyProperties(contSlaveInfo, contractVO);
		contractVO.setSlaveContno(contSlaveInfo.getConId());
		contractVO.setProtocolNo( contSlaveInfo.getPrtclNo());
		contractVO.setSecCd(contSlaveInfo.getGutId());
		contractVO.setMastContno(billNormalVO.getMastContno());
		// 增删改出质清单（押品列表）
		billstandardapplyservice.addModifyDeleteAppMortgageList(appno, contractVO, insertList, updateList, new ArrayList<BillStandardMortgageVO>());
	}
	
	/**
	 * 普通非标准仓单质押申请核价岗提交
	 * @param billStandardBussInfoVO
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年5月2日下午3:31:33
	 */
	@Override
	public void BillNorAddPricingUpdate(BillStandardBussInfoVO billStandardBussInfoVO) throws ScubeBizException
	{
		String appno = billStandardBussInfoVO.getAppno();
		//校验是否对押品进行核价并保存
		HashMap<String, Object> poMap = new HashMap<String, Object>();
		poMap.put("appno", appno); // 申请编号
		poMap.put("appliMortBizType", ScfBasConstant.MORT_BIZ_TYPE_NORMAL_PLEDGE_IN); // 申请业务押品清单业务类型（仓单置换入库）
		bpbcapplimtginfoservice.findByConditionException("BPbcAppliMtgInfo", poMap, "请先对押品进行核价，并保存！");

		//更新调价通知书
		bntenoticebaseservice.saveBillNormalNoticeInfo(appno,NoticeConstant.NOTICE_TYPE_131,billStandardBussInfoVO);
		bntenoticebaseservice.saveBillNormalNoticeInfo(appno,NoticeConstant.NOTICE_TYPE_128,billStandardBussInfoVO);
		// 复核流程方法
		String status = WorkflowConstant.WORKFLOW_TRANS_AGREE;//跳转下一节点
		BPbcAppliBaseInfo applibaseinfo = bpbcapplibaseinfoservice.findBPbcAppliBaseInfoByKey(billStandardBussInfoVO.getAppno());
		applibaseinfo.setComment(billStandardBussInfoVO.getTaskComment());
		try {
			scfWorkFlowService.processTasks(applibaseinfo,status);
		} catch (FlowsharpException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 普通非标准仓单追加申请复核岗复核
	 * @param billStandardBussInfoVO
	 * @author 	mengjiajia
	 * @date 	2017年5月2日下午3:43:59
	 */
	@Override
	public void BillNorAddReviewUpdate(BillStandardBussInfoVO billStandardBussInfoVO)
	{
		//流程跳转
		String status = WorkflowConstant.WORKFLOW_TRANS_AGREE;//跳转下一节点
		BPbcAppliBaseInfo applibaseinfo = bpbcapplibaseinfoservice.findBPbcAppliBaseInfoByKey(billStandardBussInfoVO.getAppno());
		applibaseinfo.setComment(billStandardBussInfoVO.getTaskComment());
		try {
			scfWorkFlowService.processTasks(applibaseinfo,status);
		} catch (FlowsharpException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 普通非标准仓单质押申请回执确认
	 * @param billStandardBussInfoVO
	 * @author 	mengjiajia
	 * @date 	2017年5月2日下午4:18:36
	 */
	@Override
	public void BillNorAddConfirmUpdate(BillStandardBussInfoVO billStandardBussInfoVO)
	{
		//流程跳转
		String status = WorkflowConstant.WORKFLOW_TRANS_AGREE;//跳转下一节点
		if(status.equals(WorkflowConstant.WORKFLOW_TRANS_AGREE))
		{
			billmanagerservice.saveTblMortgageBillNorAdd(billStandardBussInfoVO.getAppno());
			//修改通知书状态
			bntenoticebaseservice.updateNoticeStatus(billStandardBussInfoVO.getAppno(),NoticeConstant.NOTICE_TYPE_131,NoticeConstant.NOTICE_BASE_STATUS_CONFIRM_AGREE);
			bntenoticebaseservice.updateNoticeStatus(billStandardBussInfoVO.getAppno(),NoticeConstant.NOTICE_TYPE_128,NoticeConstant.NOTICE_BASE_STATUS_CONFIRM_AGREE);
		}
		BPbcAppliBaseInfo applibaseinfo = bpbcapplibaseinfoservice.findBPbcAppliBaseInfoByKey(billStandardBussInfoVO.getAppno());
		applibaseinfo.setComment(billStandardBussInfoVO.getTaskComment());
		try {
			scfWorkFlowService.processTasks(applibaseinfo,status);
		} catch (FlowsharpException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 普通非标准仓单追加申请退回修改
	 * @param billStandardBussInfoVO
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年5月2日下午4:22:19
	 */
	@Override
	public void BillNorAddBackToModifyUpdate(BillStandardBussInfoVO billStandardBussInfoVO) throws ScubeBizException
	{
		//流程跳转
		String status = WorkflowConstant.WORKFLOW_TRANS_GOBACK;//退回上一节点
		BPbcAppliBaseInfo applibaseinfo = bpbcapplibaseinfoservice.findBPbcAppliBaseInfoByKey(billStandardBussInfoVO.getAppno());
		applibaseinfo.setComment(billStandardBussInfoVO.getTaskComment());
		try {
			scfWorkFlowService.processTasks(applibaseinfo,status);
		} catch (FlowsharpException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
