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
import com.huateng.scf.bas.common.service.IScfWorkFlowService;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.crr.model.BCrrGntyCon;
import com.huateng.scf.bas.mrn.service.IContractService;
import com.huateng.scf.bas.nte.service.IBNteNoticeBaseService;
import com.huateng.scf.bas.pbc.model.BPbcAppliBaseInfo;
import com.huateng.scf.bas.pbc.model.BPbcMtgBaseInfoVO;
import com.huateng.scf.bas.pbc.service.IBPbcAppliBaseInfoService;
import com.huateng.scf.bas.pbc.service.IBPbcAppliMtgInfoService;
import com.huateng.scf.bas.sys.constant.WorkflowConstant;
import com.huateng.scf.rec.bcp.constant.RBcpErrorConstant;
import com.huateng.scf.sto.nwr.dao.vo.SBcpBillNormalAppVO;
import com.huateng.scf.sto.nwr.service.IBillManagerService;
import com.huateng.scf.sto.nwr.service.IBillNormalMngExcgService;
import com.huateng.scf.sto.nwr.service.IBillStandardApplyService;
import com.huateng.scf.sto.nwr.service.IBillStandardPledgeAppService;
import com.huateng.scf.sto.nwr.service.ISBcpMortBillNormalService;
import com.huateng.scf.sto.nwr.vo.BillNormalAppVO;
import com.huateng.scf.sto.nwr.vo.BillNormalVO;
import com.huateng.scf.sto.nwr.vo.BillStandardBussInfoVO;
import com.huateng.scf.sto.nwr.vo.BillStandardMortgageVO;
import com.huateng.scf.sto.nwr.vo.BillstandardAppVO;
import com.huateng.scf.sto.nwr.vo.BillstandardMortgageQryVO;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * 
 * <p>非标仓单置换	接口实现类</p>
 *
 * @author 	mengjiajia
 * @date 	2017年5月8日下午3:11:23
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2017年5月8日下午3:11:23	     新增
 *
 * </pre>
 */
@ScubeService
@Service("BillNormalMngExcgServiceImpl")
public class BillNormalMngExcgServiceImpl implements IBillNormalMngExcgService 
{
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	//自定义流程公共类
	@Resource(name = IScfWorkFlowService.BEAN_ID)
	IScfWorkFlowService scfWorkFlowService;
	
	//业务申请表
	@Resource(name = "BPbcAppliBaseInfoServiceImpl")
	IBPbcAppliBaseInfoService bpbcapplibaseinfoservice;
	
	@Resource(name = "BillStandardPledgeAppServiceImpl")
	IBillStandardPledgeAppService billstandardpledgeappservice;
	
	@Resource(name = "SBcpMortBillNormalServiceImpl")
	ISBcpMortBillNormalService sbcpmortbillnormalservice;
	
	@Resource(name = "ContractServiceImpl")
	IContractService contractservice;
	
	@Resource(name = "BillStandardApplyServiceImpl")
	IBillStandardApplyService billstandardapplyservice;
	
	//押品业务申请表
	@Resource(name = "BPbcAppliMtgInfoServiceImpl")
	IBPbcAppliMtgInfoService bpbcapplimtginfoservice;
	
	//通知书信息
	@Resource(name = "BNteNoticeBaseServiceImpl")
	IBNteNoticeBaseService bntenoticebaseservice;
	
	@Resource(name = "BillManagerServiceImpl")
	IBillManagerService billmanagerservice;
	
	/**
	 *  任务基本信息
	 */
	@Override
	public BPbcAppliBaseInfo findRBcpAppliBussInfoByAppno(String appno) {
		log.debug("appno:"+appno);
		String process = WorkflowConstant.PROCNAME_NORMAL_BILL_EXCHANGE_APPLY;
		return scfWorkFlowService.findBPbcAppliBaseInfoByAppno(appno, process);
	}
	
	/**
	 * 预入库仓单列表获取
	 * @param pageNo
	 * @param pageSize
	 * @param billNormalAppVO
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年5月8日下午4:51:53
	 */
	@SuppressWarnings({ "unchecked" })
	@Override
	public Page BillMngExcgEnteringListGetter(int pageNo, int pageSize, BillNormalVO billNormalVO) 
			throws ScubeBizException
	{
		Page page = null;
		String appno = billNormalVO.getAppno();//申请编号编号
		String taskName = billNormalVO.getTaskName();//任务名称
		if(StringUtil.isEmpty(appno)){//新增
			page= new Page(pageSize, pageNo, 0);
			return page;
		}
		//"Pricing".equals(taskName)||"Review".equals(taskName)||"Confirm".equals(taskName)
		if(!StringUtil.isEmpty(taskName))
		{
			billNormalVO.setStatus(ScfBasConstant.BILL_MANAGE_STATUS_DELIVERY);//普通仓单置换申请  -- 置换解押
		}
		else
		{
			billNormalVO.setStatus(ScfBasConstant.BILL_MANAGE_STATUS_PLEDGE);//普通仓单置换申请  -- 置换质押
		}

		page = billstandardpledgeappservice.getAppliBillnormalList(billNormalVO, true);
		List<SBcpBillNormalAppVO> list = page.getRecords();
		List<BillNormalAppVO> lis=new ArrayList<BillNormalAppVO>();
		if(list.size()>0)
		{
			for(int i=0;i<list.size();i++)
			{
				BillNormalAppVO VO = new BillNormalAppVO();
				SBcpBillNormalAppVO bill = (SBcpBillNormalAppVO) list.get(i);
//				String billno = bill.getBillno();
//				BigDecimal sum = billstandardpledgeappservice.getSubByBillno(billno);
				BeanUtils.copyProperties(bill, VO);
//				VO.setWhReceiptValue(sum);// 仓单价值
				if (!StringUtil.isEmpty(appno)) 
				{
					VO.setAppno(appno);
				}
				lis.add(VO);
			}
		}
		page.setRecords(lis);
		return page;
	}
	
	/**
	 * 普通仓单换入仓单保存
	 * @param billNormalAppVO
	 * @param insertList
	 * @return
	 * @author 	mengjiajia
	 * @date 	2017年5月8日下午5:33:06
	 */
	@Override
	public String BillMngExcgEnterListUpdater(BillNormalAppVO billNormalAppVO,List<BillNormalAppVO> insertList)
	{
		String bussAppno = billNormalAppVO.getAppno();	// 申请编号
//		String mastContno = billNormalAppVO.getMastContno();	// 主合同号
//		String slaveContno = billNormalAppVO.getSlaveContno();	// 从合同号
		
//		BillNormalAppVO contractVO = new BillNormalAppVO();
//		BCrrGntyCon contSlaveInfo = contractservice.getTblContSlaveInfo(slaveContno);
		String appliType = WorkflowConstant.APPLI_TYPE_BILL_NORMAL_EXCHANGE;
		String workApplyType = WorkflowConstant.PROCNAME_NORMAL_BILL_EXCHANGE_APPLY;
		
//		BeanUtils.copyProperties(contSlaveInfo, contractVO);
//		contractVO.setSlaveContno(contSlaveInfo.getConId());
//		contractVO.setProtocolNo( contSlaveInfo.getPrtclNo());
//		contractVO.setCustcd(contSlaveInfo.getGutId());
//		contractVO.setMastContno(mastContno);
		billNormalAppVO.setAppliType(appliType);
		billNormalAppVO.setProcessTemplateName(workApplyType);
		
		if (StringUtil.isEmpty(bussAppno)){// bussAppno为空 新增申请信息，新增标准仓单信息
			bussAppno = bpbcapplibaseinfoservice.saveBillManageExchangeAppBaseInfo(billNormalAppVO);//bussAppno为空或“”则为新增
			//工作流开始
			HashMap<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("modelId", workApplyType);
			paramMap.put("NodeId", WorkflowConstant.PROCNODE_APPLY);
			paramMap.put("startedUserId", ContextHolder.getUserInfo().getTlrNo());
			try {
				scfWorkFlowService.commonStartFlow(bussAppno,workApplyType, workApplyType, paramMap);
			} catch (FlowsharpException e) {
				e.printStackTrace();
			}
		} else{
			bussAppno = bpbcapplibaseinfoservice.saveBillManageExchangeAppBaseInfoForModify(billNormalAppVO);//bussAppno不为空 为更新
		}
		//保存申请仓单信息
		billstandardpledgeappservice.saveAppliWarehouse(billNormalAppVO, bussAppno);
		billstandardpledgeappservice.BillNormalApplyInfSave(insertList,bussAppno);
		return bussAppno;
	}
	
	/**
	 * 普通仓单置换（解押换出）申请信息保存
	 * @param billNormalAppVO
	 * @param insertList
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年5月9日上午9:27:32
	 */
	@Override
	public void BillNorExcgOutListUpdater(BillNormalAppVO billNormalAppVO,List<BillNormalAppVO> list) throws ScubeBizException
	{
		String appno = billNormalAppVO.getAppno();
		//(解压仓单保存)
		if(StringUtil.isEmpty(appno))
		{
			throw new ScubeBizException("申请编号不存在，请先保存换入仓单信息！", RBcpErrorConstant.ERROR_CODE_PARAM_NOT_EXIST);
		}
		billstandardpledgeappservice.saveAppliWarehouse(billNormalAppVO, appno);
		List<BillNormalAppVO> insertList = new ArrayList<BillNormalAppVO>();
		List<BillNormalAppVO> updateList = new ArrayList<BillNormalAppVO>();
		List<BillNormalAppVO> delList = new ArrayList<BillNormalAppVO>();
		for(BillNormalAppVO appVO:list)
		{
			appVO.setStatus(ScfBasConstant.BILL_MANAGE_STATUS_DELIVERY);//仓单管理表字段（status）  -- 置换解押
			insertList.add(appVO);
		}
		billstandardpledgeappservice.updateReceiptAppBasic(appno, insertList, updateList, delList);//普通仓单置换出库
	}
	
	/**
	 * 流程跳转
	 * @param applibaseinfo
	 * @param status
	 * @author 	mengjiajia
	 * @date 	2017年5月9日上午10:04:22
	 */
	public void processTasks(String appno, String status, String taskComment)
	{
		BPbcAppliBaseInfo applibaseinfo = bpbcapplibaseinfoservice.findBPbcAppliBaseInfoByKey(appno);
		applibaseinfo.setComment(taskComment);
		try {
			scfWorkFlowService.processTasks(applibaseinfo,status);
		} catch (FlowsharpException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 普通非标准仓单置换提交申请		调查岗
	 * @param appno
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年5月9日上午10:07:09
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void BillNorExchangAppSubmitUpdate(String appno) throws ScubeBizException
	{
		//添加仓单与仓单下押品的验证
		//换入仓单验证
		BillNormalVO commonQueryVO = new BillNormalVO();
		commonQueryVO.setAppno(appno);
	    commonQueryVO.setStatus(ScfBasConstant.BILL_MANAGE_STATUS_INPUT);//普通仓单置换申请  -- 置换质押
		Page pageQueryResult= billstandardpledgeappservice.getBillnormalListByAppno(commonQueryVO, false);
		List<SBcpBillNormalAppVO> billnormallist = pageQueryResult.getRecords();
		if(billnormallist.size() == 0)
		{
			throw new ScubeBizException("请填写好换入仓单信息再提交！", RBcpErrorConstant.ERROR_CODE_APPINFO_ERROR);
		}
		for(SBcpBillNormalAppVO normalAppVO:billnormallist)
		{
			String billno = normalAppVO.getBillno();
			String billCode = normalAppVO.getBillcode();
			BillstandardMortgageQryVO qryVO = new BillstandardMortgageQryVO();
			qryVO.setBillno(billno);
			qryVO.setPageIndex(1);
			qryVO.setPageSize(Integer.MAX_VALUE);
			//PageQueryResult pageQueryResult1 = QualityApplyService.getInstance().getApplyMortgageList(commonQueryVO1);
			Page page = billstandardpledgeappservice.billstandardMortgageQuery(qryVO);
			if(page.getRecords()==null||page.getRecords().size()==0)
			{
				throw new ScubeBizException("仓单编号为"+billCode+"的仓单未录入押品信息，请填写相关押品信息后再提交", RBcpErrorConstant.ERROR_CODE_APPINFO_ERROR);
			}
		}
		//换出仓单验证
		BillNormalVO output = new BillNormalVO();
		output.setPageSize(Integer.MAX_VALUE);
		output.setAppno(appno);
		output.setStatus(ScfBasConstant.BILL_MANAGE_STATUS_PLEDGE);//仓单置换申请  -- 置换质押
		pageQueryResult = billstandardpledgeappservice.getAppliBillnormalList(output, false);
		billnormallist = pageQueryResult.getRecords();
		if(billnormallist.size()==0||billnormallist==null)
		{
			throw new ScubeBizException("请填写好换出仓单信息再提交！", RBcpErrorConstant.ERROR_CODE_APPINFO_ERROR);
		}

		//流程流转
		if(StringUtil.isEmpty(appno))
		{
			throw new ScubeBizException("没生成任务请先进行信息保存！", RBcpErrorConstant.ERROR_CODE_APPINFO_ERROR);
		}
		// 工作流处理
		String status = WorkflowConstant.WORKFLOW_TRANS_AGREE;//跳转下一节点
		this.processTasks(appno, status, null);
	}
	
	/**
	 * 非标准仓单置换核价保存（核价岗）
	 * @param billNormalAppVO
	 * @param list
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年5月9日上午10:38:45
	 */
	@Override
	public void BillNorExcgPricingUpdate(BillNormalAppVO billNormalAppVO, List<BPbcMtgBaseInfoVO> list) throws ScubeBizException
	{
		String appno = billNormalAppVO.getAppno();//申请号
		String slaveContno = billNormalAppVO.getSlaveContno();
		String billnoTemp = billNormalAppVO.getBillno();
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
			BPbcMtgBaseInfoVO baseInfoVO = list.get(i);
			applyVO = new BillStandardMortgageVO();
			BeanUtils.copyProperties(baseInfoVO, applyVO);
			applyVO.setAppliMortBizType(ScfBasConstant.MORT_BIZ_TYPE_NORMAL_EXCHANGE_IN); //  申请业务押品清单业务类型[标准仓单质押]
			applyVO.setAppno(appno);
			insertList.add(applyVO);
		}
		
		
		BillstandardAppVO contractVO = new BillstandardAppVO();
		BCrrGntyCon contSlaveInfo = contractservice.getTblContSlaveInfo(slaveContno);//根据slaveContno获取从合同信息
		BeanUtils.copyProperties(contSlaveInfo, contractVO);
		contractVO.setSlaveContno(contSlaveInfo.getConId());
		contractVO.setProtocolNo( contSlaveInfo.getPrtclNo());
		contractVO.setSecCd(contSlaveInfo.getGutId());
		contractVO.setMastContno(billNormalAppVO.getMastContno());
		
		billstandardpledgeappservice.saveAppliWarehouse(billNormalAppVO, appno);
		// 增删改出质清单（押品列表）
		String mortBizType = ScfBasConstant.MORT_BIZ_TYPE_NORMAL_EXCHANGE_IN;
		billstandardapplyservice.addModifyDeleteAppMortgageList(appno, contractVO, insertList, updateList, new ArrayList<BillStandardMortgageVO>(),mortBizType);
	}
	
	/**
	 * 普通非标准仓单置换核价提交
	 * @param bussVO
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年5月9日上午11:12:07
	 */
	@Override
	public void BillNorExchangePricingUpdate(BillStandardBussInfoVO bussVO) throws ScubeBizException
	{
		//校验是否对押品进行核价并保存
		HashMap<String, Object> poMap = new HashMap<String, Object>();
		poMap.put("appno", bussVO.getAppno()); // 申请编号
		poMap.put("appliMortBizType" // 申请业务押品清单业务类型（仓单置换入库）
				, ScfBasConstant.MORT_BIZ_TYPE_NORMAL_EXCHANGE_IN);
		bpbcapplimtginfoservice.findByConditionException("BPbcAppliMtgInfo", poMap, "请先对押品进行核价，并保存！");

		bntenoticebaseservice.addBillNoticeByMortgageModifyMoniFloor(bussVO.getAppno());//换出仓单通知书
		bntenoticebaseservice.saveBillNormalNoticeInfo(bussVO.getAppno(),NoticeConstant.NOTICE_TYPE_128,bussVO,ScfBasConstant.BILL_MANAGE_STATUS_PLEDGE);//换入仓单通知书
		// 工作流处理
		String status = WorkflowConstant.WORKFLOW_TRANS_AGREE;//跳转下一节点
		this.processTasks(bussVO.getAppno(), status, bussVO.getTaskComment());
	}
	
	/**
	 * 普通非标准仓单置换申请复核岗复核
	 * @param billNormalAppVO
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年5月9日下午2:16:16
	 */
	@Override
	public void BillNorExchangReviewUpdate(BillNormalAppVO billNormalAppVO) throws ScubeBizException
	{
		// 工作流处理
		String status = WorkflowConstant.WORKFLOW_TRANS_AGREE;//跳转下一节点
		this.processTasks(billNormalAppVO.getAppno(), status, billNormalAppVO.getTaskComment());
	}
	
	/**
	 * 普通非标准仓单置换回执确认
	 * @param billNormalAppVO
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年5月9日下午2:32:37
	 */
	@Override
	public void BillNorExchangeConfirmUpdate(BillNormalAppVO billNormalAppVO) throws ScubeBizException
	{
		String appno = billNormalAppVO.getAppno();
		//生成通知书
		bntenoticebaseservice.addNoticeByMortgagePriceModify(billNormalAppVO.getAppno(),WorkflowConstant.APPLI_TYPE_BILL_NORMAL_EXCHANGE);
		String status = WorkflowConstant.WORKFLOW_TRANS_AGREE;
		billmanagerservice.saveTblMortgageBillNorInfo(appno);
		//修改通知书状态
		bntenoticebaseservice.updateNoticeStatus(appno,NoticeConstant.NOTICE_TYPE_128,NoticeConstant.NOTICE_BASE_STATUS_CONFIRM_AGREE);
		bntenoticebaseservice.updateNoticeStatus(appno,NoticeConstant.NOTICE_TYPE_127,NoticeConstant.NOTICE_BASE_STATUS_CONFIRM_AGREE);
		this.processTasks(appno, status, billNormalAppVO.getTaskComment());
	}
}
