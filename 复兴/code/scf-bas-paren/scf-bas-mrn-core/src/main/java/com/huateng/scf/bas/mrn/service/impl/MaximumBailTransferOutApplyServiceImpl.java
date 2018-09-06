package com.huateng.scf.bas.mrn.service.impl;

import java.math.BigDecimal;
import java.util.HashMap;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huateng.authority.common.ContextHolder;
import com.huateng.flowsharp.api.IProcessService;
import com.huateng.flowsharp.entity.FlowsharpException;
import com.huateng.flowsharp.entity.NodeEntity;
import com.huateng.scf.bas.common.service.IScfWorkFlowService;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.crr.dao.IBCrrGntyConDAO;
import com.huateng.scf.bas.crr.dao.model.BCrrGntyCon;
import com.huateng.scf.bas.mrn.service.ICompositeMngService;
import com.huateng.scf.bas.mrn.service.IMaximumBailTransferOutApplyService;
import com.huateng.scf.bas.mrn.vo.BCrrGntyConVO;
import com.huateng.scf.bas.mrn.vo.OldContractVO;
import com.huateng.scf.bas.pbc.model.BPbcAppliBaseInfo;
import com.huateng.scf.bas.pbc.service.IBPbcAppliBaseInfoService;
import com.huateng.scf.bas.prd.model.BPrdInfo;
import com.huateng.scf.bas.prd.service.IBPrdInfoService;
import com.huateng.scf.bas.sys.constant.WorkflowConstant;
import com.huateng.scf.bas.sys.service.DealEndFlowService;
import com.huateng.scf.bas.sys.service.DealInFlowService;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * 
 * <p>最高额保证金转出申请接口实现类</p>
 *
 * @author 	mengjiajia
 * @date 	2017年2月28日上午9:37:43
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2017年2月28日上午9:37:43	     新增
 *
 * </pre>
 */
@ScubeService
@Service("MaximumBailTransferOutApplyServiceImpl")
public class MaximumBailTransferOutApplyServiceImpl implements IMaximumBailTransferOutApplyService,DealInFlowService,DealEndFlowService {
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@Resource(name=IScfWorkFlowService.BEAN_ID)
	IScfWorkFlowService scfWorkFlowService;
	
	@Resource(name = "BPrdInfoServiceImpl")
	IBPrdInfoService bprdinfoservice;
	
	/**
	 * 保证金及现金等价物信息
	 */
	@Resource(name = "CompositeMngServiceImpl")
	ICompositeMngService compositemngservice;
	
	/**
	 * 业务申请信息
	 */
	@Resource(name = "BPbcAppliBaseInfoServiceImpl")
	IBPbcAppliBaseInfoService bpbcapplibaseinfoservice;
	
	@Resource(name = "IBCrrGntyConDAO")
	IBCrrGntyConDAO bcrrgntycondao;
	
	@Autowired
	IProcessService processService;//发起工作流
	
	/**
	 * 获取任务信息
	 * @param appno
	 * @return
	 */
	@Override
	public BPbcAppliBaseInfo findBPbcAppliBaseInfoByAppno(String appno)
	{
		log.debug("appno:"+appno);
		String process = WorkflowConstant.PROCNAME_MAXBAIL_TRANSFER_OUT_APPLY;
		return scfWorkFlowService.findBPbcAppliBaseInfoByAppno(appno,process);
	}
	
	/**
	 * 保证金转入登记保存--池管理模式
	 */
	@Override
	public String BailTransferOutWriteUpdate(BCrrGntyConVO bCrrGntyConVO,HashMap<String, Object> value)
	{
		String appno = bCrrGntyConVO.getAppno();
		OldContractVO contractVO = new OldContractVO();
		//保证金转入信息
		contractVO.setBailAccountno(value.get("bailAccountno").toString());
		contractVO.setBailAmount(new BigDecimal(value.get("bailAmount").toString()));
		contractVO.setAmt(new BigDecimal(value.get("amt").toString()));
		contractVO.setAmount(value.get("amount").toString());
		contractVO.setNpsBailAmount(new BigDecimal(value.get("npsBailAmount").toString()));
		//担保合同信息
		contractVO.setSupplyChainPdId(bCrrGntyConVO.getVidPrdId());//供应链产品类型
		contractVO.setCustcd(bCrrGntyConVO.getGutId());//客户号
		contractVO.setProtocolNo(bCrrGntyConVO.getPrtclNo());//监管协议号
		contractVO.setMastContno(bCrrGntyConVO.getAppId());//主合同号
		contractVO.setSlaveContno(bCrrGntyConVO.getConId());//抵质押合同号
		
		if(StringUtil.isEmpty(appno)){
			String businessnoType = WorkflowConstant.APPLI_TYPE_MAXBAIL_TRANSFER_OUT_APPLY;
			String workApplyType = WorkflowConstant.PROCNAME_MAXBAIL_TRANSFER_OUT_APPLY;
			appno = compositemngservice.saveApplyBaseInfo(contractVO, businessnoType, workApplyType);
			
			// 工作流开始
			HashMap<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("modelId", WorkflowConstant.PROCNAME_MAXBAIL_TRANSFER_OUT_APPLY);
			paramMap.put("NodeId", WorkflowConstant.POOLREPAY_WRITE);
			paramMap.put("startedUserId", ContextHolder.getUserInfo().getTlrNo());
			try {
				scfWorkFlowService.commonStartFlow(appno,workApplyType, workApplyType, paramMap);
			} catch (FlowsharpException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			contractVO.setAppno(appno);
		}
		compositemngservice.saveBailTransferOutWriteNew(contractVO);
		return appno;
	}
	
	/**
	 * 保证金转出申请录入提交申请
	 * @param appno
	 * @param isProcess
	 */
	@Override
	public void BailTransferOutWriteSubmit(String appno, boolean isProcess)
	{
    	compositemngservice.checkBailTransferOutIsSave(appno);
    	if(isProcess)
		{
    		processTasks(appno);
		}
	}
	
	/**
	 * 保证金转出申请经办机构审查岗复核
	 * 保证金转出申请交易融资部贷权内控岗复核
	 * @param appno
	 * @param isProcess
	 */
	@Override
	public void BailTransferOutSubmit(String appno, boolean isProcess)
	{
    	if(isProcess)
		{
    		processTasks(appno);
		}
	}
	
	/**
	 * 保证金转出申请中心负责人审批
	 * @param appno
	 * @param isProcess
	 */
	@Override
	public void BailTransferOutApproveSubmit(String appno, boolean isProcess)
	{
		compositemngservice.updateBailTransferOutInfoNew(appno);//保证金转出申请流程结束后更新表内信息
    	if(isProcess)
		{
    		processTasks(appno);
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
	
	/**
	 * 退回
	 * @param appno
	 */
	@Override
	public void BailTransferOutBackToModUpdate(String appno, boolean isProcess)
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
	
	/**
	 * 获取担保合同信息
	 * @param conId
	 * @return
	 */
	@Override
	public BCrrGntyConVO findBCrrGntyConByConId(String conId)
	{
		BCrrGntyConVO bCrrGntyConVO = new BCrrGntyConVO();
		BCrrGntyCon bCrrGntyCon = bcrrgntycondao.selectByPrimaryKey(conId);
		String productId = bCrrGntyCon.getVidPrdId();
		String productNm = "";
		if (StringUtil.isStrNotEmpty(productId)) {
			BPrdInfo bPrdInfo = new BPrdInfo();
			bPrdInfo.setProductId(productId);
			productNm = bprdinfoservice.findBPrdInfoByKey(bPrdInfo).getProductName();
		}
		bCrrGntyCon.setVidPrdNm(productNm);
		BeanUtils.copyProperties(bCrrGntyCon, bCrrGntyConVO);
		return bCrrGntyConVO;
	}

	@Override
	public void doWorkForPass(String appNo) {
		BailTransferOutApproveSubmit(appNo, false);
	}

	@Override
	public void doWorkForReject(String appNo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doWorkForBack(String appNo) {
		BailTransferOutBackToModUpdate(appNo, false);
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
		if(nodeId.equals("Write"))
		{//保证金转出申请录入提交申请
			BailTransferOutWriteSubmit(appNo, false);
		}
		if(nodeId.equals("Review"))
		{//保证金转出申请经办机构审查岗复核
			BailTransferOutSubmit(appNo, false);
		}
		if(nodeId.equals("Check"))
		{//保证金转出申请交易融资部贷权内控岗复核
			BailTransferOutSubmit(appNo, false);
		}
		if(nodeId.equals("Approve"))
		{//保证金转出申请中心负责人审批
			BailTransferOutApproveSubmit(appNo, false);
		}
	}
}
