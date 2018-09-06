package com.huateng.scf.sto.nwr.service.impl;

import java.math.BigDecimal;
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
import com.huateng.scf.bas.nte.service.IBNteNoticeBaseService;
import com.huateng.scf.bas.pbc.dao.vo.BPbcMtgBaseInfoVO;
import com.huateng.scf.bas.pbc.model.BPbcAppliBaseInfo;
import com.huateng.scf.bas.pbc.service.IBPbcAppliBaseInfoService;
import com.huateng.scf.bas.pbc.service.IBPbcMtgBaseInfoService;
import com.huateng.scf.bas.sys.constant.WorkflowConstant;
import com.huateng.scf.rec.bcp.constant.RBcpErrorConstant;
import com.huateng.scf.sto.nwr.dao.model.SBcpMortBillNormal;
import com.huateng.scf.sto.nwr.service.IBillManagerService;
import com.huateng.scf.sto.nwr.service.IBillNormalOffMngService;
import com.huateng.scf.sto.nwr.service.IBillStandardPledgeAppService;
import com.huateng.scf.sto.nwr.service.ISBcpMortBillNormalService;
import com.huateng.scf.sto.nwr.vo.BillNormalAppVO;
import com.huateng.scf.sto.nwr.vo.BillNormalVO;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * 
 * <p>非标仓单解押	接口实现类</p>
 *
 * @author 	mengjiajia
 * @date 	2017年5月2日下午4:59:45
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2017年5月2日下午4:59:45	     新增
 *
 * </pre>
 */
@ScubeService
@Service("BillNormalOffMngServiceImpl")
public class BillNormalOffMngServiceImpl implements IBillNormalOffMngService 
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
	
	@Resource(name = "BPbcMtgBaseInfoServiceImpl")
	IBPbcMtgBaseInfoService bpbcmtgbaseinfoservice;

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
		String process = WorkflowConstant.PROCNAME_NORMAL_BILL_UNPLEDGE_APPLY;
		return scfWorkFlowService.findBPbcAppliBaseInfoByAppno(appno, process);
	}
	
	/**
	 * 在押仓单清单列表
	 * @param pageNo
	 * @param pageSize
	 * @param billNormalAppVO
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年5月3日上午9:39:47
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Page BillNormalOffListQueryGetter(int pageNo, int pageSize, BillNormalAppVO billNormalAppVO) throws ScubeBizException
	{
		Page page = new Page();
		billNormalAppVO.setPageIndex(pageNo);
		billNormalAppVO.setPageSize(pageSize);
		page = sbcpmortbillnormalservice.getBillNormalBasicListPQResult(billNormalAppVO);
		List<SBcpMortBillNormal> list = page.getRecords();
		List<BillNormalAppVO> lis = new ArrayList<BillNormalAppVO>();
		if(list.size()>0)
		{
			for(int i=0;i<list.size();i++)
			{
				BillNormalAppVO VO = new BillNormalAppVO();
				SBcpMortBillNormal bill = (SBcpMortBillNormal)list.get(i);
				String billno = bill.getBillno();
				BigDecimal sum = billstandardpledgeappservice.getSubByBillno(billno);
				BeanUtils.copyProperties(bill, VO);
				VO.setWhReceiptValue(sum);//仓单价值
				lis.add(VO);
			}
		}
		page.setRecords(lis);
		return page;
	}
	
	/**
	 * 预解除仓单清单列表查询
	 * @param billNormalVO
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年5月8日上午11:24:21
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Page BillNormalOffListMngDetailGetter(int pageNo, int pageSize, BillNormalVO billNormalVO) throws ScubeBizException
	{
		Page page = new Page();
		if(StringUtil.isEmpty(billNormalVO.getAppno()))
		{//新增
			page = new Page();
			return page;
		}
		billNormalVO.setPageSize(pageSize);
		billNormalVO.setPageIndex(pageNo);
		page = billmanagerservice.getBillExchangeEnteringListByParam(billNormalVO);
		List<SBcpMortBillNormal> list = page.getRecords();
		List<BillNormalAppVO> lis = new ArrayList<BillNormalAppVO>();
		if(list.size()>0)
		{
			for(int i=0;i<list.size();i++)
			{
				BillNormalAppVO VO = new BillNormalAppVO();
				SBcpMortBillNormal bill = (SBcpMortBillNormal)list.get(i);
				String billno = bill.getBillno();
				BigDecimal sum = billstandardpledgeappservice.getSubByBillno(billno);
				BeanUtils.copyProperties(bill, VO);
				VO.setWhReceiptValue(sum);//仓单价值
				lis.add(VO);
			}
		}
		page.setRecords(lis);
		return page;
	}
	
	/**
	 * 新增仓单解押申请保存
	 * @param basicApplyVO	仓单解押申请基本信息
	 * @param list	预解除仓单清单列表
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年5月3日上午10:45:59
	 */
	@SuppressWarnings("unchecked")
	@Override
	public String BillNormalOffListAddUpdater(BillNormalAppVO billNormalAppVO, List<BillNormalAppVO> list) throws ScubeBizException
	{
		BigDecimal _bailAmount = billNormalAppVO.getBailAmount();
		if(_bailAmount==null)
		{
			_bailAmount = BigDecimal.ZERO;
		}
		String appno = billNormalAppVO.getAppno();
		String slaveContno = billNormalAppVO.getSlaveContno();	// 担保合同编号
		String custcd = billNormalAppVO.getCustcd(); // 从合同号

		if (!StringUtil.isEmpty(appno))
		{
			BPbcAppliBaseInfo tblApplyBaseInfo = bpbcapplibaseinfoservice.findBPbcAppliBaseInfoByKey(appno);
			slaveContno = tblApplyBaseInfo.getBusinessno();
			custcd = tblApplyBaseInfo.getCustcd();
			billNormalAppVO.setSlaveContno(slaveContno);
			billNormalAppVO.setCustcd(custcd);
		}
		List<BillNormalAppVO> outInsertList = new ArrayList<BillNormalAppVO>();
		List<BillNormalAppVO> outUpdateList = new ArrayList<BillNormalAppVO>();
		List<BillNormalAppVO> outDelList = new ArrayList<BillNormalAppVO>();
		if(list != null&&list.size()>0) 
		{
			for(BillNormalAppVO applyVO:list)
			{
				applyVO.setSlaveContno(slaveContno); // 从合同号
				applyVO.setStatus(ScfBasConstant.BILL_MANAGE_STATUS_DELIVERY);//仓单管理表字段（status）  -- 解押
				outInsertList.add(applyVO);
			}
		}

		for(int i=0;i<outInsertList.size();i++)
		{
			BillNormalAppVO vo = (BillNormalAppVO)outInsertList.get(i);
			List<BPbcMtgBaseInfoVO> outlist = bpbcmtgbaseinfoservice.getBillstandardMorgByBillno(vo.getBillno());
            if(outlist==null||outlist.size()==0)
            {
    			throw new ScubeBizException("存在无任何押品的仓单！", RBcpErrorConstant.RECORD_NOT_EXIST);

            }
		}
		
		String appliType = WorkflowConstant.APPLI_TYPE_BILL_NORMAL_UNPLEDGEAPPLI;
		String workApplyType = WorkflowConstant.PROCNAME_NORMAL_BILL_UNPLEDGE_APPLY;
		billNormalAppVO.setAppliType(appliType);
		billNormalAppVO.setProcessTemplateName(workApplyType);
		appno = billNormalAppVO.getAppno();
		if(StringUtil.isEmpty(appno))
		{
			appno = billstandardpledgeappservice.updateReceiptAppBasic(
					 billNormalAppVO, outInsertList, outUpdateList, outDelList);
			//工作流开始
			HashMap<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("modelId", workApplyType);
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
			appno = billstandardpledgeappservice.updateReceiptAppBasic(billNormalAppVO, outInsertList, 
					outUpdateList, outDelList);
		}
		return appno;
	}
	
	/**
	 * 流程跳转
	 * @param applibaseinfo
	 * @param status
	 * @author 	mengjiajia
	 * @date 	2017年5月9日上午10:04:22
	 */
	public void processTasks(BPbcAppliBaseInfo applibaseinfo, String status)
	{
		try {
			scfWorkFlowService.processTasks(applibaseinfo,status);
		} catch (FlowsharpException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 仓单解押申请提交
	 * @param billNormalAppVO
	 * @param list
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年5月3日下午2:59:17
	 */
	@Override
	public void BillNormalOffMngSubmit(BillNormalAppVO billNormalAppVO, List<BillNormalAppVO> list) throws ScubeBizException
	{
		this.BillNormalOffListAddUpdater(billNormalAppVO, list);
		String appno = billNormalAppVO.getAppno();
		if(StringUtil.isEmpty(appno))
		{
			throw new ScubeBizException("请先保存解押信息！", RBcpErrorConstant.RECORD_NOT_EXIST);
		}
		Page pageResult = billstandardpledgeappservice.getReceiptAppListMngAdd(billNormalAppVO);
		if (pageResult.getRecords()==null||pageResult.getRecords().size() == 0)
		{
			throw new ScubeBizException("该解押申请下无任何仓单！", RBcpErrorConstant.RECORD_NOT_EXIST);
		}
		// 工作流处理
		String status = WorkflowConstant.WORKFLOW_TRANS_AGREE;//跳转下一节点
		BPbcAppliBaseInfo applibaseinfo = bpbcapplibaseinfoservice.findBPbcAppliBaseInfoByKey(billNormalAppVO.getAppno());
		applibaseinfo.setComment(billNormalAppVO.getTaskComment());
		this.processTasks(applibaseinfo, status);
	}
	
	/**普通非标准仓单解押复核岗提交
	 * 
	 * @param billNormalAppVO
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年5月3日下午4:39:00
	 */
	@Override
	public void BillNormalOffReviewUpdate(BillNormalAppVO billNormalAppVO) throws ScubeBizException
	{
		// 工作流处理
		String status = WorkflowConstant.WORKFLOW_TRANS_AGREE;//跳转下一节点
		// 通过APPNO生成通知书（1-押品监管下限通知书/2-押品变更通知书）
		bntenoticebaseservice.addBillNoticeByMortgageModifyMoniFloor(billNormalAppVO.getAppno());
		BPbcAppliBaseInfo applibaseinfo = bpbcapplibaseinfoservice.findBPbcAppliBaseInfoByKey(billNormalAppVO.getAppno());
		applibaseinfo.setComment(billNormalAppVO.getTaskComment());
		this.processTasks(applibaseinfo, status);
	}
	
	/**
	 * 普通非标准仓单解押申请退回修改
	 * @param billNormalAppVO
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年5月3日下午4:42:50
	 */
	@Override
	public void BillNormalOffBackUpdate(BillNormalAppVO billNormalAppVO) throws ScubeBizException
	{
		// 工作流处理
		String status = WorkflowConstant.WORKFLOW_TRANS_GOBACK;//退回上一节点
		BPbcAppliBaseInfo applibaseinfo = bpbcapplibaseinfoservice.findBPbcAppliBaseInfoByKey(billNormalAppVO.getAppno());
		applibaseinfo.setComment(billNormalAppVO.getTaskComment());
		this.processTasks(applibaseinfo, status);
	}
	
	/**
	 * 普通非标准仓单解押审批岗提交
	 * @param billNormalAppVO
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年5月3日下午4:50:20
	 */
	@Override
	public void BillNormalOffNoticeUpdate(BillNormalAppVO billNormalAppVO) throws ScubeBizException
	{
		billstandardpledgeappservice.copyStandardUpledgeAppInfoToDelTable(billNormalAppVO.getAppno());
		// 更新通知书
		bntenoticebaseservice.modifyNoticeBaseInfo(billNormalAppVO.getAppno(),
				NoticeConstant.NOTICE_BASE_STATUS_CONFIRM_APPROVED);
		// 工作流处理
		String status = WorkflowConstant.WORKFLOW_TRANS_AGREE;//跳转下一节点
		BPbcAppliBaseInfo applibaseinfo = bpbcapplibaseinfoservice.findBPbcAppliBaseInfoByKey(billNormalAppVO.getAppno());
		applibaseinfo.setComment(billNormalAppVO.getTaskComment());
		this.processTasks(applibaseinfo, status);
	}
	
	/**
	 * 普通非标准仓单解押回执提交
	 * @param billNormalAppVO
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年5月3日下午5:08:30
	 */
	@Override
	public void BillNormalOffConfirmUpdate(BillNormalAppVO billNormalAppVO) throws ScubeBizException
	{
		bntenoticebaseservice.modifyNoticeBaseInfo(billNormalAppVO.getAppno(),
				NoticeConstant.NOTICE_BASE_STATUS_CONFIRM_AGREE);
		String bussAppno = billNormalAppVO.getAppno();
		billstandardpledgeappservice.updateBillNormalOffAppliStatus(bussAppno);
		// 工作流处理
		String status = WorkflowConstant.WORKFLOW_TRANS_AGREE;//跳转下一节点
		BPbcAppliBaseInfo applibaseinfo = bpbcapplibaseinfoservice.findBPbcAppliBaseInfoByKey(billNormalAppVO.getAppno());
		applibaseinfo.setComment(billNormalAppVO.getTaskComment());
		this.processTasks(applibaseinfo, status);		
	}
}
