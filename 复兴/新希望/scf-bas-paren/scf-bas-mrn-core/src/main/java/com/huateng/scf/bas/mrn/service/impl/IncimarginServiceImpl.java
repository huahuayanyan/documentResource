package com.huateng.scf.bas.mrn.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huateng.authority.common.ContextHolder;
import com.huateng.base.common.beans.Page;
import com.huateng.flowsharp.entity.FlowsharpException;
import com.huateng.scf.adv.tcs.constant.ATcsErrorConstant;
import com.huateng.scf.bas.common.constant.ScfBasConstant;
import com.huateng.scf.bas.common.service.IScfWorkFlowService;
import com.huateng.scf.bas.common.startup.ScfMessageUtil;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.common.util.UUIDGeneratorUtil;
import com.huateng.scf.bas.crm.model.BCrmBaseInfo;
import com.huateng.scf.bas.crm.service.IBCrmBaseInfoService;
import com.huateng.scf.bas.lan.model.BLanLnciBase;
import com.huateng.scf.bas.lan.service.IBLanLnciBaseService;
import com.huateng.scf.bas.mrn.constant.BMrnErrorConstant;
import com.huateng.scf.bas.mrn.model.BMrnAcctBussInfo;
import com.huateng.scf.bas.mrn.model.BMrnAppliAcctInfo;
import com.huateng.scf.bas.mrn.service.IBMrnAcctBussInfoService;
import com.huateng.scf.bas.mrn.service.IBMrnAppliAcctInfoService;
import com.huateng.scf.bas.mrn.service.IncimarginService;
import com.huateng.scf.bas.pbc.model.BPbcAppliBaseInfo;
import com.huateng.scf.bas.pbc.service.IBPbcAppliBaseInfoService;
import com.huateng.scf.bas.sys.constant.BSysErrorConstant;
import com.huateng.scf.bas.sys.constant.WorkflowConstant;
import com.huateng.scf.bas.sys.service.DealEndFlowService;
import com.huateng.scf.bas.sys.service.IBSysSerialNoService;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

@ScubeService
@Service("IncimarginServiceImpl")
public class IncimarginServiceImpl implements IncimarginService,DealEndFlowService {
	
	@Resource(name = "BSysSerialNoServiceImpl")
	private  IBSysSerialNoService bSysSerialNoService;//流水号生成服务
	
	@Resource(name = "BLanLnciBaseServiceImpl")
	IBLanLnciBaseService   ibLanLnciBaseService;
	
	@Resource(name = IBPbcAppliBaseInfoService.BEAN_ID)
	IBPbcAppliBaseInfoService bPbcAppliBaseInfoService;//业务申请表
	
	@Resource(name = IBMrnAppliAcctInfoService.BEAN_ID)
	IBMrnAppliAcctInfoService bMrnAppliAcctInfoService; //保证金及现金等价物业务申请信息
	
	@Resource(name = IBLanLnciBaseService.BEAN_ID)
	IBLanLnciBaseService bLanLnciBaseService;//借据基本信息表
	
	@Resource(name=IScfWorkFlowService.BEAN_ID) //供应链工作流
	IScfWorkFlowService scfWorkFlowService;
	
	@Resource(name ="BCrmBaseInfoServiceImpl")
	IBCrmBaseInfoService  ibCrmBaseInfoService;
	
	
	@Resource(name ="BMrnAcctBussInfoServiceImpl")
	IBMrnAcctBussInfoService bMrnAcctBussInfoService; 
	
	private final Logger log = LoggerFactory.getLogger(getClass());

	@Override
	public Page findBLanLnciBaseList(int pageNo, int pageSize, BLanLnciBase bLanLnciBase) {
		Page p	=ibLanLnciBaseService.findBLanLnciBaseListForBLanLnciBase(pageNo, pageSize, bLanLnciBase);		
			if(p!=null){	
					List records=new ArrayList();
				    for(int i=0;i<p.getRecords().size();i++){
					    	BLanLnciBase   bLanLnciBaseVO =new   BLanLnciBase();
					    	BeanUtils.copyProperties(p.getRecords().get(i), bLanLnciBaseVO);
					    	records.add(bLanLnciBaseVO);
				    } 
				   p.setRecords(records);
			}
				
		// TODO Auto-generated method stub
		return p;

	}

	/* (non-Javadoc)
	 * @see com.huateng.scf.bas.mrn.service.IncimarginService#marginApplySaveUpdate(com.huateng.scf.bas.mrn.model.BMrnAppliAcctInfo)
	 */
	@Override
	@Transactional
	public String marginApplySaveUpdate(BMrnAppliAcctInfo bmrnAppliAcctInfo) {
		String appno=null;
		//0-流程互斥校验
		BLanLnciBase baseInfo = bLanLnciBaseService.findBLanLnciBaseByKey(bmrnAppliAcctInfo.getDebetNo());
		

	
				if(StringUtil.isEmpty(bmrnAppliAcctInfo.getAppno())){
						if(ScfBasConstant.LOCKED.equals(baseInfo.getIsLocked())){
							log.error("借据【"+baseInfo.getDebetId()+"】下存在尚未审批的流程【"+baseInfo.getLockAppno()+"】，无法提交本次申请。");
							throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(ATcsErrorConstant.SCF_ADV_TCS_20000),ATcsErrorConstant.SCF_ADV_TCS_20000);
						}
						try{
						// TODO Auto-generated method stub
					    appno=this.saveMarginAppliBaseInfo(bmrnAppliAcctInfo, WorkflowConstant.PROCNAME_MARGIN_APPLY,WorkflowConstant.APPLI_TYPE_MARGIN_APPLY);
						BMrnAppliAcctInfo bean = new BMrnAppliAcctInfo();
						bean.setAppno(appno);
						bean.setAccountNo(bmrnAppliAcctInfo.getBailAccountno());
						bean.setAmount(bmrnAppliAcctInfo.getBailAmount());
						bean.setBailFrozenAmt(bmrnAppliAcctInfo.getBailAmount());
						bean.setDebetNo(bmrnAppliAcctInfo.getDebetNo());
						bean.setCustcd(bmrnAppliAcctInfo.getCustcd());
						bean.setBailType(ScfBasConstant.BAIL_TYPE_NORMAL);//保证金
						bean.setInitType(ScfBasConstant.INIT_TYPE_INIT);//追加
						bean.setBailAccountno(bmrnAppliAcctInfo.getBailAccountno());
						bean.setAccountName(bmrnAppliAcctInfo.getAccountName());
						bean.setBailAmount(bmrnAppliAcctInfo.getBailAmount());
						bean.setMastContno(bmrnAppliAcctInfo.getMastContno());
						//bean.setId(null);
						bMrnAppliAcctInfoService.add(bean);
						//借据锁定
						bLanLnciBaseService.lockDebtBaseInfo(bmrnAppliAcctInfo.getDebetNo(), appno);
						BCrmBaseInfo bCrmBaseInfo=new BCrmBaseInfo();
						bCrmBaseInfo.setCustcd(bmrnAppliAcctInfo.getCustcd());
						BCrmBaseInfo nBCrmBaseInfo=ibCrmBaseInfoService.findBCrmBaseInfoByKey(bCrmBaseInfo);
						//发起工作流
						String modelId  = WorkflowConstant.PROCNAME_MARGIN_APPLY;
						HashMap<String, Object> paramMap = new HashMap<String, Object>();
						paramMap.put("modelId", modelId);
						paramMap.put("NodeId", WorkflowConstant.PROCNODE_APPLY);
						paramMap.put("startedUserId", ContextHolder.getUserInfo().getTlrNo());
						paramMap.put(WorkflowConstant.CUST_CD, bmrnAppliAcctInfo.getCustcd());
						paramMap.put(WorkflowConstant.CUST_NAME, nBCrmBaseInfo.getCname());
						scfWorkFlowService.startWorkFlow(appno, modelId, modelId, paramMap);
						}catch(Exception e){
							log.error("系统错误",e);
							throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BSysErrorConstant.SCF_BAS_SYS_20004),BSysErrorConstant.SCF_BAS_SYS_20004);
							
						}
				}
				else {
					
					appno=bmrnAppliAcctInfo.getAppno();
					bMrnAppliAcctInfoService.clearTblAppliCustAccountInfo(appno);
					BMrnAppliAcctInfo bean = new BMrnAppliAcctInfo();
					bean.setAppno(appno);
					bean.setAccountNo(bmrnAppliAcctInfo.getBailAccountno());
					bean.setAmount(bmrnAppliAcctInfo.getBailAmount());
					bean.setBailFrozenAmt(bmrnAppliAcctInfo.getBailAmount());
					bean.setDebetNo(bmrnAppliAcctInfo.getDebetNo());
					bean.setCustcd(bmrnAppliAcctInfo.getCustcd());
					bean.setBailType(ScfBasConstant.BAIL_TYPE_NORMAL);//保证金
					bean.setInitType(ScfBasConstant.INIT_TYPE_INIT);//追加
					bean.setBailAccountno(bmrnAppliAcctInfo.getBailAccountno());
					bean.setAccountName(bmrnAppliAcctInfo.getAccountName());
					bean.setBailAmount(bmrnAppliAcctInfo.getBailAmount());
					bean.setMastContno(bmrnAppliAcctInfo.getMastContno());
					bMrnAppliAcctInfoService.add(bean);
					BPbcAppliBaseInfo  appliBaseInfo = bPbcAppliBaseInfoService.findBPbcAppliBaseInfoByKey(appno);
					appliBaseInfo.setBailAmount(bmrnAppliAcctInfo.getBailAmount());
					appliBaseInfo.setExt1(bmrnAppliAcctInfo.getNpsBailAmount().toString()); 
					bPbcAppliBaseInfoService.updateBPbcAppliBaseInfo(appliBaseInfo);
				}
	
		return appno;
	}
	
	
	@Transactional
	public String saveMarginAppliBaseInfo(BMrnAppliAcctInfo bmrnAppliAcctInfo, String procnameMarginApply, String appliTypeMarginApply) {	
		BPbcAppliBaseInfo bPbcAppliBaseInfo = new BPbcAppliBaseInfo();
		bPbcAppliBaseInfo.setProcessTemplateName(procnameMarginApply);
		bPbcAppliBaseInfo.setAppliType(appliTypeMarginApply);
		bPbcAppliBaseInfo.setAppliStatus(WorkflowConstant.APPLI_STATUS_UNSUBMIT);         // 申请状态:未提交（默认）
		bPbcAppliBaseInfo.setAppliStatusDtl(WorkflowConstant.APPLI_STATUS_DTL_WRITING); // 申请状态明细:未提交（默认）
		bPbcAppliBaseInfo.setCustcd(bmrnAppliAcctInfo.getCustcd());
		bPbcAppliBaseInfo.setBailAmount(bmrnAppliAcctInfo.getBailAmount());
		String appno = bSysSerialNoService.genSerialNo(ScfBasConstant.BUSSNO_TYPE_SKQR_T_APP_NO); 
		bPbcAppliBaseInfo.setAppno(appno);
		bPbcAppliBaseInfo.setWorkflowAppno(appno);
		bPbcAppliBaseInfo.setBusinessno(appno);
		bPbcAppliBaseInfo.setChannelFlag(ScfBasConstant.CHANNEL_FLAG_SCF);//默认渠道标识为供应链
		bPbcAppliBaseInfo.setIsFlowEnd(ScfBasConstant.FLAG_OFF);//默认流程未结束
		bPbcAppliBaseInfo.setExt1(bmrnAppliAcctInfo.getNpsBailAmount().toString()); 
		bPbcAppliBaseInfoService.addBPbcAppliBaseInfo(bPbcAppliBaseInfo);
		return bPbcAppliBaseInfo.getAppno();
	}
	
	
	
	
	public BLanLnciBase queryIncimarginLoan(String appno) {
		BMrnAppliAcctInfo  bmrnAppliAcctInfo=queryIncimargin(appno) ;
		BLanLnciBase	 blanLnciBase=ibLanLnciBaseService.findBLanLnciBaseByKey(bmrnAppliAcctInfo.getDebetNo());
		// TODO Auto-generated method stub
		return blanLnciBase;

	}
	
	

	public BMrnAppliAcctInfo queryIncimargin(String appno) {
		List<BMrnAppliAcctInfo> bmrnAppliAcctInfoList=  bMrnAppliAcctInfoService.findBMrnAppliAcctInfoByAppno(appno);
		BMrnAppliAcctInfo bmrnAppliAcctInfo =bmrnAppliAcctInfoList.get(0);
		BPbcAppliBaseInfo bPbcAppliBaseInfo =bPbcAppliBaseInfoService.findBPbcAppliBaseInfoByKey(bmrnAppliAcctInfo.getAppno());
		bmrnAppliAcctInfo.setNpsBailAmount(new BigDecimal(bPbcAppliBaseInfo.getExt1()==null?"0":bPbcAppliBaseInfo.getExt1()));
		// TODO Auto-generated method stub
		return bmrnAppliAcctInfo;

	}
	
	
	@Override
	@Transactional
	public void marginApplySubmit(BMrnAppliAcctInfo bmrnAppliAcctInfo) {
		String appno= marginApplySaveUpdate(bmrnAppliAcctInfo); 
		//流程流转
		BPbcAppliBaseInfo bPbcAppliBaseInfo = bPbcAppliBaseInfoService.findBPbcAppliBaseInfoByKey(appno);
		String status = WorkflowConstant.WORKFLOW_TRANS_AGREE;
		try {
			scfWorkFlowService.processTasks(bPbcAppliBaseInfo, status);
		} catch (FlowsharpException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

	@Override
	@Transactional
	public void doWorkForPass(String appNo) {
		
		BPbcAppliBaseInfo bPbcAppliBaseInfo=new  BPbcAppliBaseInfo();
		bPbcAppliBaseInfo.setAppliStatus(WorkflowConstant.APPLI_STATUS_APPROVED); 
		bPbcAppliBaseInfo.setAppliStatusDtl(WorkflowConstant.APPLI_STATUS_DTL_APPROVED);
		bPbcAppliBaseInfo.setAppno(appNo);
		bPbcAppliBaseInfoService.updateBPbcAppliBaseInfo(bPbcAppliBaseInfo);	
		List<BMrnAppliAcctInfo> bmrnAppliAcctInfoList=bMrnAppliAcctInfoService.findBMrnAppliAcctInfoByAppno(appNo);	
		BMrnAppliAcctInfo  bmrnAppliAcctInfo=bmrnAppliAcctInfoList.get(0);
		//保存借据还款信息 入保证金信息
		savecustAccountInfo(bmrnAppliAcctInfo) ;
		//调用间接额度公共方法释放额度
	//	IndirectCreditService.getInstance().indirectCreditAppliCommonProcess(commAppInfoVo.getBussAppno(), null,SCFConstants.CREDIT_TRADE_TYPE_RELEASE,null);
		//解锁借据
		bLanLnciBaseService.releaseDebtBaseInfo(bmrnAppliAcctInfo.getDebetNo());
		
		
		
	}
	
	@Transactional
	public void saveBailTransferApplySingle(BMrnAppliAcctInfo bmrnAppliAcctInfo) {
		bmrnAppliAcctInfo.setBailType(ScfBasConstant.BAIL_TYPE_NORMAL);
		bmrnAppliAcctInfo.setInitType(ScfBasConstant.INIT_TYPE_ADD);
		bmrnAppliAcctInfo.setBailRate(new BigDecimal("100"));
		bmrnAppliAcctInfo.setConfirmStatus(ScfBasConstant.CONFIRM_STATUS_CONFIRMED);
		BMrnAcctBussInfo bMrnAcctBussInfo=new  BMrnAcctBussInfo();
		bMrnAcctBussInfo.setBailType(ScfBasConstant.BAIL_TYPE_NORMAL);
		bMrnAcctBussInfo.setInitType(ScfBasConstant.INIT_TYPE_ADD);
		bMrnAcctBussInfo.setBailAccountno(bmrnAppliAcctInfo.getBailAccountno());
		bMrnAcctBussInfo.setMastContno(bmrnAppliAcctInfo.getMastContno());
		List bailList=bMrnAcctBussInfoService.queryTblCustAccountBussInfoListForBMrnAcctBussInfo(bMrnAcctBussInfo);
		if (bailList != null && bailList.size() > 0) {
			// 保证金账号存在,更新客户账号业务信息表中的保证金金额和最后更新时间
		    this.modifyTblCustAccountBussInfo(bailList,bmrnAppliAcctInfo);
		} else {
			this.savecustAccountInfo(bmrnAppliAcctInfo) ;
		}
		// 更新借据基本信息表Tbl_Lnci_Base_Info中追加现金及其等价物价值
		this.modifyTblLnciBaseInfo(bmrnAppliAcctInfo);

	}
	
	@Transactional
	public void modifyTblCustAccountBussInfo(List bailList,BMrnAppliAcctInfo bmrnAppliAcctInfo) {
		BMrnAcctBussInfo bmrnAcctBussInfo =new   BMrnAcctBussInfo();
		com.huateng.scf.bas.mrn.dao.model.BMrnAcctBussInfo  bMrnAcctBussInfodal = (com.huateng.scf.bas.mrn.dao.model.BMrnAcctBussInfo ) bailList.get(0);
		try {
			BeanUtils.copyProperties(bMrnAcctBussInfodal, bmrnAcctBussInfo);
		} catch (BeansException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error("保证金及现金等价物交易流水转换异常！");
			throw  new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BMrnErrorConstant.SCF_BAS_MRN_10000),BMrnErrorConstant.SCF_BAS_MRN_10000);
		} 
		if(bmrnAcctBussInfo.getBailAmount()==null){
			bmrnAcctBussInfo.setBailAmount(BigDecimal.ZERO);
		}
		// SCF保证金金额=前次保证金金额+本次转入保证金金额
		BigDecimal sumBailAmount = bmrnAcctBussInfo.getBailAmount().add(
				bmrnAppliAcctInfo.getBailAmount());
		bmrnAcctBussInfo.setBailAmount(sumBailAmount);
		bmrnAcctBussInfo.setLastUpdTime(new Date());
		bMrnAcctBussInfoService.updateBMrnAcctBussInfo(bmrnAcctBussInfo);
	}

	
	@Transactional
	public void modifyTblLnciBaseInfo(BMrnAppliAcctInfo bmrnAppliAcctInfo){
		   BLanLnciBase 	bLanLnciBase=bLanLnciBaseService.findBLanLnciBaseByKey(bmrnAppliAcctInfo.getDebetNo());
			if (bLanLnciBase != null) {
			// 追加现金及其等价物价值=追加现金及其等价物价值+本次追加现金及其等价物价值
			if(bLanLnciBase.getAddBailAmount()==null){
				bLanLnciBase.setAddBailAmount(new BigDecimal(0));
			}
			BigDecimal totalBailAmount = bLanLnciBase.getAddBailAmount().add(
					bmrnAppliAcctInfo.getBailAmount());
			bLanLnciBase.setAddBailAmount(totalBailAmount);
			bLanLnciBaseService.updateBLanLnciBase(bLanLnciBase);	
	    }	
	}
	
	
	@Transactional
	public void savecustAccountInfo(BMrnAppliAcctInfo bean ) throws ScubeBizException{
    		BMrnAcctBussInfo accountBussInfo = new BMrnAcctBussInfo();
    		BeanUtils.copyProperties(bean,accountBussInfo);
    		accountBussInfo.setBailAmount(bean.getBailAmount());
    		String id = UUIDGeneratorUtil.generate();
    		accountBussInfo.setId(id);
    		bMrnAcctBussInfoService.addBMrnAcctBussInfo(accountBussInfo);
	
	}
	

	@Override
	@Transactional
	public void doWorkForReject(String appNo) {
		// TODO Auto-generated method stub
		BPbcAppliBaseInfo bPbcAppliBaseInfo=new  BPbcAppliBaseInfo();
		bPbcAppliBaseInfo.setAppliStatus(WorkflowConstant.APPLI_STATUS_REFUSED); 
		bPbcAppliBaseInfo.setAppliStatusDtl(WorkflowConstant.APPLI_STATUS_DTL_REFUSED);
		bPbcAppliBaseInfo.setAppno(appNo);
		bPbcAppliBaseInfoService.updateBPbcAppliBaseInfo(bPbcAppliBaseInfo);	
		List<BMrnAppliAcctInfo> bmrnAppliAcctInfoList=bMrnAppliAcctInfoService.findBMrnAppliAcctInfoByAppno(appNo);	
		bLanLnciBaseService.releaseDebtBaseInfo(bmrnAppliAcctInfoList.get(0).getDebetNo());
		
	}

	@Override
	@Transactional
	public void doWorkForBack(String appNo) {
		// TODO Auto-generated method stub
		
	}

}
