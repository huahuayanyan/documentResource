package com.huateng.scf.bas.crr.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huateng.base.common.beans.Page;
import com.huateng.flowsharp.api.IProcessService;
import com.huateng.flowsharp.entity.ProcessEntity;
import com.huateng.scf.bas.common.constant.ScfBasConstant;
import com.huateng.scf.bas.common.startup.ScfBaseData;
import com.huateng.scf.bas.common.startup.ScfMessageUtil;
import com.huateng.scf.bas.common.util.ScfDateUtil;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.crm.dao.IBCrmBaseInfoDAO;
import com.huateng.scf.bas.crm.dao.model.BCrmBaseInfo;
import com.huateng.scf.bas.crr.dao.IBCrrBillInfoDAO;
import com.huateng.scf.bas.crr.dao.IBCrrDuebillAppDAO;
import com.huateng.scf.bas.crr.dao.IBCrrEqptInfoDAO;
import com.huateng.scf.bas.crr.dao.IBCrrInvInfoDAO;
import com.huateng.scf.bas.crr.dao.IBCrrLcInfoDAO;
import com.huateng.scf.bas.crr.dao.IBCrrLgInfoDAO;
import com.huateng.scf.bas.crr.dao.IBCrrLnConRelaDAO;
import com.huateng.scf.bas.crr.dao.IBCrrPrdMdDAO;
import com.huateng.scf.bas.crr.dao.ext.ExtBCrrDAO;
import com.huateng.scf.bas.crr.dao.model.BCrrBillInfo;
import com.huateng.scf.bas.crr.dao.model.BCrrDuebillAppExample;
import com.huateng.scf.bas.crr.dao.model.BCrrDuebillAppExample.Criteria;
import com.huateng.scf.bas.crr.dao.model.BCrrPrdMd;
import com.huateng.scf.bas.crr.model.BCrrDuebill;
import com.huateng.scf.bas.crr.model.BCrrDuebillApp;
import com.huateng.scf.bas.crr.model.BCrrLnCon;
import com.huateng.scf.bas.crr.service.IBCrrGntyConService;
import com.huateng.scf.bas.crr.service.IBCrrLnConService;
import com.huateng.scf.bas.crr.service.IIfspBCrrDuebillAppService;
import com.huateng.scf.bas.crr.util.BCrrModelCommonUtil;
import com.huateng.scf.bas.icr.dao.IBIcrInfoDAO;
import com.huateng.scf.bas.icr.dao.IBIcrPrdBindDAO;
import com.huateng.scf.bas.icr.dao.model.BIcrInfo;
import com.huateng.scf.bas.icr.dao.model.BIcrPrdBind;
import com.huateng.scf.bas.lan.constant.BLanErrorConstant;
import com.huateng.scf.bas.lan.dao.IBLanAppliLnciBaseDAO;
import com.huateng.scf.bas.lan.dao.model.BLanAppliLnciBase;
import com.huateng.scf.bas.lan.service.IBLanRepayApproveCommonService;
import com.huateng.scf.bas.lan.service.IBLanRepayFlowCreditApplyService;
import com.huateng.scf.bas.lan.service.IBLanRepaySilverApplyService;
import com.huateng.scf.bas.mrn.dao.IBMrnAppliAcctInfoDAO;
import com.huateng.scf.bas.mrn.dao.model.BMrnAppliAcctInfo;
import com.huateng.scf.bas.pbc.model.BPbcAppliBaseInfo;
import com.huateng.scf.bas.prd.dao.IBPrdCreditBindDAO;
import com.huateng.scf.bas.prd.dao.model.BPrdCreditBind;
import com.huateng.scf.bas.sys.constant.BSysErrorConstant;
import com.huateng.scf.bas.sys.constant.WorkflowConstant;
import com.huateng.scf.bas.sys.dao.model.RSysAcctBctl;
import com.huateng.scf.bas.sys.model.BSysAcctBctl;
import com.huateng.scf.bas.sys.service.IBSysAcctBctlService;
import com.huateng.scf.bas.sys.service.IBSysSerialNoService;
import com.huateng.scf.rec.bcp.dao.IRBcpAppliBussDtlDAO;
import com.huateng.scf.rec.bcp.dao.IRBcpDebtBussDtlDAO;
import com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussDtl;
import com.huateng.scf.rec.bcp.model.ProcessModel;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;
/**
 * 
 * <p>出账申请接口实现类</p>
 *
 * @author 	zhangcheng
 * @date 	2017年3月4日下午3:26:27
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2017年3月4日下午3:26:27	     新增
 *
 * </pre>
 */
@ScubeService
@Service("IfspBCrrDuebillAppServiceImpl")
public class IfspBCrrDuebillAppServiceImpl implements IIfspBCrrDuebillAppService {
	private final Logger log = LoggerFactory.getLogger(getClass());
	@Resource(name = "BSysSerialNoServiceImpl")	
	IBSysSerialNoService  ibSysSerialNoService;
	@Resource(name = "IBCrrDuebillAppDAO")
	IBCrrDuebillAppDAO bcrrduebillappdao;
	@Resource(name = "BCrrLnConServiceImpl")	
	IBCrrLnConService  bcrrlnconservice;
	// 流程申请基本信息
	@Resource(name = "IBCrmBaseInfoDAO")
	IBCrmBaseInfoDAO bCrmBaseInfoDAO;
	@Override
	@Transactional
	public BCrrDuebillApp add(BCrrDuebillApp bCrrDuebillApp) {
		log.info("出账申请新增操作");
		String id =ibSysSerialNoService.genSerialNo("DUE_APP_NO");
		BigDecimal lnAmt=bCrrDuebillApp.getLnAmt();//出账金额
		String lnNo=bCrrDuebillApp.getLnNo();//结算帐号
		String rtnIntInvl=bCrrDuebillApp.getRtnIntInvl();//计息周期
		String appId=bCrrDuebillApp.getAppId();//计息周期
		String ifspAppno=bCrrDuebillApp.getIfspAppno();//在线流水号
		String appStat = WorkflowConstant.APPLI_STATUS_UNSUBMIT;
		if(lnAmt==null||lnAmt.compareTo(new BigDecimal(0))<=0){
	    	throw new ScubeBizException("出账金额必须大于0！");
	
		}
		if(ifspAppno==null||"".equals(ifspAppno)){
			throw new ScubeBizException("在线流水不能为空！");
			
		}
		if(lnNo==null||"".equals(lnNo)){
			throw new ScubeBizException("结算帐号不能为空！");
			
		}
		if(rtnIntInvl==null||"".equals(rtnIntInvl)){
			throw new ScubeBizException("计息周期不能为空！");
			
		}
		if(appId==null||"".equals(appId)){
			throw new ScubeBizException("信贷合同号不能为空！");
			
		}
		BCrrLnCon lncon=bcrrlnconservice.findBCrrLnConByAppId(bCrrDuebillApp.getAppId());
		if(lncon==null){
	    	throw new ScubeBizException("信贷合同信息不存在！");
		}
		BCrmBaseInfo sellcrmBase=bCrmBaseInfoDAO.selectById(bCrrDuebillApp.getCustCd());
		if(sellcrmBase==null){
	    	throw new ScubeBizException("客户信息不存在！");
		}
		BeanUtils.copyProperties(lncon, bCrrDuebillApp);
		bCrrDuebillApp.setId(id);
		bCrrDuebillApp.setAppStat(appStat);
		bCrrDuebillApp.setInpDt(ScfDateUtil.formatDate(new Date(),"yyyy-MM-dd HH:mm:ss"));
		bCrrDuebillApp.setLstUpdDt(ScfDateUtil.formatDate(new Date(),"yyyy-MM-dd HH:mm:ss"));
		bCrrDuebillApp.setLnAmt(lnAmt);
		bCrrDuebillApp.setLnNo(lnNo);
		bCrrDuebillApp.setRtnIntInvl(rtnIntInvl);
		bCrrDuebillApp.setAppId(appId);
		bCrrDuebillApp.setCname(sellcrmBase.getCname());
		bCrrDuebillApp.setIsDt(lncon.getLnStrtDt());
		bCrrDuebillApp.setTeDt(lncon.getLnEndDt());
		bCrrDuebillApp.setIfspAppno(ifspAppno);
		// VO转PO 展现层对象转换DAO层对象
	    com.huateng.scf.bas.crr.dao.model.BCrrDuebillApp bCrrDuebillAppdal =
	    		new com.huateng.scf.bas.crr.dao.model.BCrrDuebillApp();
	    try
	    {
	    	BeanUtils.copyProperties(bCrrDuebillApp, bCrrDuebillAppdal);
	    }
	    catch(BeansException e)
	    {
	    	throw new ScubeBizException("转换异常");
	    }
	    try
	    {
	    	bcrrduebillappdao.insertIfspSelective(bCrrDuebillAppdal);
	    }
	    catch(BeansException e)
	    {
	    	throw new ScubeBizException("插入异常");
	    }
	  //  BCrrLnCon bCrrLnCon = new BCrrLnCon();
	    //bCrrLnCon.setAppId(bCrrDuebillApp.getAppId());
	    //bcrrlnconservice.update(bCrrLnCon);
	    return bCrrDuebillApp;
	}
	
	@Transactional
	@Override
	public BCrrDuebillApp findBCrrDuebillAppByIfspAppno(String ifspAppno) throws ScubeBizException {
		if (StringUtil.isEmpty(ifspAppno)) {
			log.info("ifspAppno不能为空");
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BLanErrorConstant.SCF_BAS_LAN_20020), BLanErrorConstant.SCF_BAS_LAN_20020);
		}
		 com.huateng.scf.bas.crr.dao.model.BCrrDuebillApp bCrrDuebillAppdal =bcrrduebillappdao.findBCrrDuebillAppByIfspAppno(ifspAppno);
		 BCrrDuebillApp bCrrDuebillApp=new BCrrDuebillApp();
		 if(bCrrDuebillAppdal==null){
		    	throw new ScubeBizException("业务信息不存在！");
		  }
		  BeanUtils.copyProperties(bCrrDuebillAppdal, bCrrDuebillApp);
		return bCrrDuebillApp;
       
   }
}