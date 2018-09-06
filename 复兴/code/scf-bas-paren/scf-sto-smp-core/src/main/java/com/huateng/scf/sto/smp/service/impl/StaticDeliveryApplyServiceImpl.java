package com.huateng.scf.sto.smp.service.impl;

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
import org.springframework.stereotype.Service;

import com.huateng.base.common.beans.Page;
import com.huateng.flowsharp.entity.FlowsharpException;
import com.huateng.scf.adv.fcs.model.FourMortgageVO;
import com.huateng.scf.bas.cnt.dao.model.BCntMprotPartInfo;
import com.huateng.scf.bas.cnt.model.BCntMprotBaseInfo;
import com.huateng.scf.bas.cnt.service.IBCntMprotBaseInfoService;
import com.huateng.scf.bas.common.constant.IndirectCreditConstant;
import com.huateng.scf.bas.common.constant.NoticeConstant;
import com.huateng.scf.bas.common.constant.ScfBasConstant;
import com.huateng.scf.bas.common.model.AmountVO;
import com.huateng.scf.bas.common.model.DeliveryApplyQryVO;
import com.huateng.scf.bas.common.service.IScfIndirectCreditService;
import com.huateng.scf.bas.common.service.IScfWorkFlowService;
import com.huateng.scf.bas.common.util.ScfDateUtil;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.crm.dao.IBCrmBaseInfoDAO;
import com.huateng.scf.bas.crr.model.BCrrGntyCon;
import com.huateng.scf.bas.crr.service.IBCrrGntyConService;
import com.huateng.scf.bas.lan.dao.IBLanLnciBaseDAO;
import com.huateng.scf.bas.lan.model.BLanAppliLnciBase;
import com.huateng.scf.bas.lan.model.BLanLnciBase;
import com.huateng.scf.bas.lan.service.IBLanAppliLnciBaseService;
import com.huateng.scf.bas.lan.service.IBLanLnciBaseService;
import com.huateng.scf.bas.mrn.dao.IBMrnAppliAcctInfoDAO;
import com.huateng.scf.bas.mrn.dao.model.BMrnAppliAcctInfo;
import com.huateng.scf.bas.mrn.service.IContractService;
import com.huateng.scf.bas.mrn.vo.BCrrGntyConVO;
import com.huateng.scf.bas.nte.dao.model.BNteNoticeBase;
import com.huateng.scf.bas.nte.service.IBNteNoticeBaseService;
import com.huateng.scf.bas.pbc.dao.model.BPbcAppliMtgInfo;
import com.huateng.scf.bas.pbc.dao.model.BPbcMtgBaseInfo;
import com.huateng.scf.bas.pbc.dao.vo.BPbcAppliMtgInfoVO;
import com.huateng.scf.bas.pbc.model.BPbcAppliBaseInfo;
import com.huateng.scf.bas.pbc.service.IAmountService;
import com.huateng.scf.bas.pbc.service.IBPbcAppliBaseInfoService;
import com.huateng.scf.bas.pbc.service.IBPbcAppliMtgInfoService;
import com.huateng.scf.bas.pbc.service.IBPbcMtgBaseInfoService;
import com.huateng.scf.bas.pbc.vo.MortgageApplyVO;
import com.huateng.scf.bas.sys.constant.WorkflowConstant;
import com.huateng.scf.rec.bcp.constant.RBcpErrorConstant;
import com.huateng.scf.sto.nwr.service.IDeliveryApplyService;
import com.huateng.scf.sto.nwr.vo.AppliMortgageBaseQryVO;
import com.huateng.scf.sto.nwr.vo.DeliveyApplyVO;
import com.huateng.scf.sto.pcb.service.IAdjustPriceService;
import com.huateng.scf.sto.smp.model.MortgageSumPriceQryVO;
import com.huateng.scf.sto.smp.model.ProtocolAmountVO;
import com.huateng.scf.sto.smp.service.IStaticDeliveryApplyService;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * 
 * <p></p>
 *
 * @author 	mengjiajia
 * @date 	2017年5月16日下午1:44:51
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2017年5月16日下午1:44:51	     新增
 *
 * </pre>
 */
@ScubeService
@Service("StaticDeliveryApplyServiceImpl")
public class StaticDeliveryApplyServiceImpl implements IStaticDeliveryApplyService
{
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	//自定义流程公共类
	@Resource(name = IScfWorkFlowService.BEAN_ID)
	IScfWorkFlowService scfWorkFlowService;
	
	@Resource(name = "BPbcAppliBaseInfoServiceImpl")
	IBPbcAppliBaseInfoService bpbcapplibaseinfoservice;
	
	@Resource(name = "ContractServiceImpl")
	IContractService contractservice;
	
	@Resource(name = "AmountServiceImpl")
	IAmountService amountservice;
	
	//押品信息
	@Resource(name = "BPbcMtgBaseInfoServiceImpl")
	IBPbcMtgBaseInfoService bpbcmtgbaseinfoservice;
	
	//押品业务申请表
	@Resource(name = "BPbcAppliMtgInfoServiceImpl")
	IBPbcAppliMtgInfoService bpbcapplimtginfoservice;
	
	@Resource(name = "AdjustPriceServiceImpl")
	IAdjustPriceService adjustpriceservice;
	
	@Resource(name = "DeliveryApplyServiceImpl")
	IDeliveryApplyService deliveryapplyservice;

	@Resource(name = "IBCrmBaseInfoDAO")
	IBCrmBaseInfoDAO bcrmbaseinfodao;
	
	@Resource(name = "BNteNoticeBaseServiceImpl")
	IBNteNoticeBaseService bntenoticebaseservice;
	
	@Resource(name = "BLanLnciBaseServiceImpl")
	IBLanLnciBaseService blanlncibaseservice;
	
	@Resource(name = IBLanAppliLnciBaseService.BEAN_ID)
	IBLanAppliLnciBaseService blanapplilncibaseservice;
	
	@Resource(name = IScfIndirectCreditService.BEAN_ID)
	IScfIndirectCreditService scfIndirectCreditService;
	
	@Resource(name = "IBMrnAppliAcctInfoDAO")
	IBMrnAppliAcctInfoDAO bmrnappliacctinfodao;
	
	@Resource(name="BLanLnciBaseDAO")
	IBLanLnciBaseDAO  iBLanLnciBaseDAO;
	
	/**
	 *  任务基本信息
	 */
	@Override
	public BPbcAppliBaseInfo findRBcpAppliBussInfoByAppno(String appno) 
	{
		log.debug("获取任务信息=======================");
		String process = WorkflowConstant.PROCNAME_E_DELIVERYAPPLY;
		return scfWorkFlowService.findBPbcAppliBaseInfoByAppno(appno, process);
	}
	
	@Resource(name = "BCrrGntyConServiceImpl")
	IBCrrGntyConService	bcrrgntyconservice;
	
	@Resource(name = "BCntMprotBaseInfoServiceImpl")
	IBCntMprotBaseInfoService bcntmprotbaseinfoservice;
	
	/**
	 * 对提货申请数据获取，进行了重构
	 * @param gntyConVO
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年5月16日下午1:58:11
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Page DeliveryApplyQryGetter(BCrrGntyConVO gntyConVO) throws ScubeBizException
	{
		String appno = gntyConVO.getAppno();
		String slaveContno = gntyConVO.getConId();
		String protocolNo = gntyConVO.getPrtclNo();
		List result = new ArrayList();
		if(StringUtil.isEmpty(appno))
		{
			BCrrGntyCon tblContSlaveInfo = bcrrgntyconservice.findBCrrGntyConByConId(slaveContno);
			BCntMprotBaseInfo tblMutiProtBaseInfo = bcntmprotbaseinfoservice.findBCntMprotBaseInfoByKey(protocolNo);
			ProtocolAmountVO applyVO = new ProtocolAmountVO();
			
			DeliveryApplyQryVO commonQueryVO =new  DeliveryApplyQryVO();
			commonQueryVO.setProtocolNo(protocolNo);
			commonQueryVO.setRole_Q("02");
			Page PageQu = contractservice.getMutiProtPartInfoByPara(commonQueryVO);
			List list1 = PageQu.getRecords();
			String  MoniCustcd = "";
			String moniCname = "";
			if(list1!=null&&list1.size()>0)
			{
				BCntMprotPartInfo TblMutiProtPartInfo = (BCntMprotPartInfo)list1.get(0);
				MoniCustcd = TblMutiProtPartInfo.getCustcd();
				moniCname = TblMutiProtPartInfo.getCname();
			}
			applyVO.setMoniCustcd(MoniCustcd);
			applyVO.setMoniCname(moniCname);
			applyVO.setSlaveContno(tblContSlaveInfo.getConId());
			applyVO.setSlaveContcode(tblContSlaveInfo.getConId());
			applyVO.setSupplyChainPdId(tblMutiProtBaseInfo.getProductId());
			applyVO.setCustcd(tblContSlaveInfo.getGutId());
			applyVO.setCname(gntyConVO.getGutNm());
			applyVO.setMonitorProtocolNo(protocolNo);
			applyVO.setProtocolNo(protocolNo);
			applyVO.setProtocolCode(protocolNo);
			//获得押品总价
			MortgageSumPriceQryVO commonVO = new MortgageSumPriceQryVO();
			commonVO.setSlaveContno(tblContSlaveInfo.getConId());
//			commonVO.setPageIndex(1);
//			commonVO.setPageSize(1000000);
			BigDecimal totalPrice = bpbcmtgbaseinfoservice.getMortgageSumPriceByParam(commonVO);
			applyVO.setTotalPrice(totalPrice);
			AmountVO amountVO = new AmountVO(applyVO.getSupplyChainPdId(),tblContSlaveInfo.getConId());
			//供应链产品种类：动产(动产协议里面暂时没存productId字段)
			amountVO.setMidProductId(ScfBasConstant.PRODUCT_TYPE_CHATTLE);//动产
			com.huateng.scf.bas.pbc.model.AmountVO amountVO2 = new com.huateng.scf.bas.pbc.model.AmountVO();
			BeanUtils.copyProperties(amountVO, amountVO2);
			BigDecimal amt = amountservice.getDelivery(amountVO2);//可提货
			BigDecimal pant = amountservice.getPant(amountVO2);//敞口
			applyVO.setMaxDeliverValue(StringUtil.isEmpty(amt)?BigDecimal.ZERO:amt);  //可提货金额
			applyVO.setRation(tblContSlaveInfo.getRation());//质押率
			applyVO.setMortAmount(StringUtil.isEmpty(totalPrice)?BigDecimal.ZERO:totalPrice);//货物总价值
			applyVO.setDebtAmount(StringUtil.isEmpty(pant)?BigDecimal.ZERO:pant);//敞口
			applyVO.setLowPriceNew(StringUtil.isEmpty(tblContSlaveInfo.getLowPriceNew())?BigDecimal.ZERO:tblContSlaveInfo.getLowPriceNew());//监管下限
			applyVO.setPledgeMode(tblMutiProtBaseInfo.getMoniType());
			result.add(applyVO);
		}
		else
		{
			BPbcAppliBaseInfo applibaseinfo = bpbcapplibaseinfoservice.findBPbcAppliBaseInfoByKey(appno);
			BCrrGntyCon tblContSlaveInfo = bcrrgntyconservice.findBCrrGntyConByConId(StringUtil.isEmpty(slaveContno)?applibaseinfo.getSlaveContno():slaveContno);
			DeliveyApplyVO vo = new DeliveyApplyVO();
			BeanUtils.copyProperties(applibaseinfo, vo);
			if(!StringUtil.isEmpty(vo.getProtocolNo())){
				protocolNo=vo.getProtocolNo();
			}
			else
			{
				protocolNo=vo.getMonitorProtocolNo();
			}
			vo.setMonitorProtocolNo(protocolNo);
			BCntMprotBaseInfo tblMutiProtBaseInfo = bcntmprotbaseinfoservice.findBCntMprotBaseInfoByKey(protocolNo);
			AmountVO amountVO = new AmountVO(vo.getSupplyChainPdId(),StringUtil.isEmpty(slaveContno)?vo.getSlaveContno():slaveContno);
			//供应链产品种类：动产(动产协议里面暂时没存productId字段)
			amountVO.setMidProductId(ScfBasConstant.PRODUCT_TYPE_CHATTLE);//动产
			com.huateng.scf.bas.pbc.model.AmountVO amountVO2 = new com.huateng.scf.bas.pbc.model.AmountVO();
			BeanUtils.copyProperties(amountVO, amountVO2);
			BigDecimal amt = amountservice.getDelivery(amountVO2);//可提货
			BigDecimal pant = amountservice.getPant(amountVO2);//敞口

			//可提货金额，需要考虑本次追加的保证金金额   add by fengjinfu
			if(vo.getBailAmount() !=null && vo.getBailAmount().floatValue() > 0)
			{
				amt = amt.add(vo.getBailAmount().multiply(new BigDecimal(100)).divide(tblContSlaveInfo.getRation(),2,BigDecimal.ROUND_HALF_UP));
			}
			vo.setDeliverValue(applibaseinfo.getAmt());
			vo.setMaxDeliverValue(amt);  //可提货金额
			vo.setRation(tblContSlaveInfo.getRation());//质押率
			//获得押品总价
			MortgageSumPriceQryVO commonVO = new MortgageSumPriceQryVO();
			commonVO.setSlaveContno(applibaseinfo.getSlaveContno());
			BigDecimal totalPrice = bpbcmtgbaseinfoservice.getMortgageSumPriceByParam(commonVO);
			vo.setMortAmount(totalPrice);//货物总价值
			vo.setDebtAmount(pant);//敞口
			vo.setPledgeMode(tblMutiProtBaseInfo.getMoniType());
			vo.setLowPriceNew(tblContSlaveInfo.getLowPriceNew());//监管下限
			vo.setCname(bcrmbaseinfodao.selectById(vo.getCustcd()).getCname());
			vo.setMoniCname(bcrmbaseinfodao.selectById(vo.getMoniCustcd()).getCname());
			result.add(vo);
		}
		Page page = new Page();
		page.setRecords(result);
		return page;
	}
	
	/**
	 * 提货押品查询
	 * @param pageNo
	 * @param pageSize
	 * @param mortgageBaseQryVO
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年5月16日下午3:11:56
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Page DeliveryAppListMngGetter(int pageNo, int pageSize, AppliMortgageBaseQryVO mortgageBaseQryVO) throws ScubeBizException
	{
		String appno = mortgageBaseQryVO.getAppno();
		String mortgageNo = mortgageBaseQryVO.getMortgageNo();
		boolean selectFlag = mortgageBaseQryVO.getSelectFlag();
		
		AppliMortgageBaseQryVO appliMortgageBaseQryVO = new AppliMortgageBaseQryVO();
		appliMortgageBaseQryVO.setPageIndex(pageNo);   //页码
		appliMortgageBaseQryVO.setPageSize(pageSize);  //每页笔数
	
		Page pageQueryResult = new Page();
		if(!StringUtil.isEmpty(appno))
		{
			if(selectFlag)
			{
				pageQueryResult = bpbcmtgbaseinfoservice.queryDeliveryMortgageByMortgageNo(mortgageNo, pageNo, pageSize);
				AppliMortgageBaseQryVO commonQueryVO = new AppliMortgageBaseQryVO();
				commonQueryVO.setAppno_Q(appno);
				BPbcAppliMtgInfo tblAppliMortgageBaseInfo = null;
				List<BPbcMtgBaseInfo> list = pageQueryResult.getRecords();
				List<FourMortgageVO> resultList = new ArrayList<FourMortgageVO>();
				FourMortgageVO vo = null;
				for(int i=0;i<list.size();i++){
					tblAppliMortgageBaseInfo = null;  
					BPbcMtgBaseInfo tblMortgageBaseInfo = list.get(i);
//					tblMortgageBaseInfo.setQuantity(BigDecimal.ZERO);//页面初始的时候默认数量为0
					commonQueryVO.setMortgageNo(tblMortgageBaseInfo.getMortgageNo());
					List<BPbcAppliMtgInfo> applyMortgageList = bpbcapplimtginfoservice.getApplyMortgageList(commonQueryVO);
					if(null!=applyMortgageList&&applyMortgageList.size()>0)
					{
						tblAppliMortgageBaseInfo = applyMortgageList.get(0);
					}
					vo = new FourMortgageVO();
					BeanUtils.copyProperties(tblMortgageBaseInfo, vo);
					if(tblAppliMortgageBaseInfo != null)
					{
						vo.setBalQuantity(tblAppliMortgageBaseInfo.getBalQuantity());
					}   
				
					if(ScfBasConstant.JOIN_BATCH_YES.equals(vo.getJoinBatch())){
						vo.setJoinBatch("true");
					}else{
						vo.setJoinBatch("false");
					}
					resultList.add(vo);
				}
				pageQueryResult.setRecords(resultList);
			}
			else
			{
				appliMortgageBaseQryVO.setAppno_Q(appno);
		        pageQueryResult = this.getApplyMortgageList(appliMortgageBaseQryVO);
			}
		}
		else
		{
			mortgageNo = mortgageNo==null?"-1":mortgageNo;
	        pageQueryResult = bpbcmtgbaseinfoservice.queryDeliveryMortgageByMortgageNo(mortgageNo, pageNo, pageSize);
	        List<BPbcMtgBaseInfo> list = pageQueryResult.getRecords();
			List<FourMortgageVO> resultList = new ArrayList<FourMortgageVO>();
			FourMortgageVO vo = null;
			for(int i=0;i<list.size();i++){
				BPbcMtgBaseInfo tblMortgageBaseInfo = list.get(i);
//				tblMortgageBaseInfo.setQuantity(BigDecimal.ZERO);//页面初始的时候默认数量为0
				vo = new FourMortgageVO();
				BeanUtils.copyProperties(tblMortgageBaseInfo, vo);
				if(ScfBasConstant.JOIN_BATCH_YES.equals(vo.getJoinBatch())){
					vo.setJoinBatch("true");
				}else{
					vo.setJoinBatch("false");
				}
				resultList.add(vo);
			}
			pageQueryResult.setRecords(resultList);
		}
		return pageQueryResult;
	}
	
	/**
	 * @Description: 在库押品列表
	 * @param commonQueryVO
	 * @throws CommonException
	 */
	@SuppressWarnings("unchecked")
	public Page getApplyMortgageList(AppliMortgageBaseQryVO commonQueryVO) throws ScubeBizException
	{
		Page pageQueryResult = bpbcapplimtginfoservice.getTblAppliMortgageBaseInfoByPara(commonQueryVO);
		List<BPbcAppliMtgInfoVO> list = pageQueryResult.getRecords();
		FourMortgageVO vo = null;
		List<FourMortgageVO> resultList = new ArrayList<FourMortgageVO>();
		for(int i=0;i<list.size();i++){
			vo = new FourMortgageVO();
			BPbcAppliMtgInfoVO appliMortgageBaseInfo = list.get(i);
			BeanUtils.copyProperties(appliMortgageBaseInfo, vo);
			vo.setNumber(appliMortgageBaseInfo.getBalQuantity());
			vo.setBalQuantity(appliMortgageBaseInfo.getBalQuantity());
			vo.setCurcd("CNY");
			resultList.add(vo);
		}
		pageQueryResult.setRecords(resultList);
		return pageQueryResult;
	}
	
	/**
	 * 添加质押合同下押品列表
	 * @param pageNo
	 * @param pageSize
	 * @param mortgageBaseQryVO
	 * @return
	 * @author 	mengjiajia
	 * @date 	2017年5月16日下午3:11:12
	 */
	@Override
	public Page PriceAdjustMortListAddGetter(int pageNo, int pageSize, AppliMortgageBaseQryVO mortgageBaseQryVO)
	{
		String slaveContno = mortgageBaseQryVO.getSlaveContno();//质押合同号
		
		Page pageQueryResult = adjustpriceservice.getMortListBySlaveContno(pageNo, pageSize, slaveContno);
		return pageQueryResult;
	}
	
	/**
	 * 填写岗提货保存并发起流程
	 * @param mortgageApplyVO
	 * @param insertList
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年5月16日下午3:15:34
	 */
	@Override
	public String DeliveryProcessStartSaveUpdater(MortgageApplyVO mortgageApplyVO,List<MortgageApplyVO> insertList) 
			throws ScubeBizException
	{
		BigDecimal value = mortgageApplyVO.getDeliverValue();
		if(StringUtil.isEmpty(value)||"0".equals(value.toString())||"0.00".equals(value.toString()))
		{
			throw new ScubeBizException("提货数量不正确或提货价值为空！", RBcpErrorConstant.ERROR_CODE_PARAM_NOT_EXIST);
		}
		List<MortgageApplyVO> deleteList = new ArrayList<MortgageApplyVO>();
		List<MortgageApplyVO> updateList = new ArrayList<MortgageApplyVO>();
		mortgageApplyVO.setAmt(mortgageApplyVO.getDeliverValue());   //本次提货押品价值
		String appno = deliveryapplyservice.saveOrUpdateApplyMortgageInfo(mortgageApplyVO, insertList, deleteList,updateList);
		return appno;
	}
	
	/**
	 * 保存并填写岗审批
	 * @param mortgageApplyVO
	 * @param insertList
	 * @return
	 * @throws ScubeBizException
	 * @author 	Qinwei
	 * @date 	2017年5月16日
	 */
	@Override
	public String DeliveryProcessStartSubmit(MortgageApplyVO mortgageApplyVO,List<MortgageApplyVO> insertList){
		String appno = mortgageApplyVO.getAppno();
		
		BigDecimal value = mortgageApplyVO.getDeliverValue();
		if(StringUtil.isEmpty(value)||"0".equals(value.toString())||"0.00".equals(value.toString()))
		{
			throw new ScubeBizException("提货数量不正确或提货价值为空！", RBcpErrorConstant.ERROR_CODE_PARAM_NOT_EXIST);
		}
		
		mortgageApplyVO.setAmt(mortgageApplyVO.getDeliverValue());   //本次提货押品价值
		
		deliveryapplyservice.saveOrUpdateApplyMortgageInfo(mortgageApplyVO,insertList,null,null);
		deliveryapplyservice.checkAmtEqual(mortgageApplyVO.getBailAmount(), appno);  //校验数据
		deliveryapplyservice.deliveryAppSignNotice(mortgageApplyVO.getAppno());
		//流程流转
		this.processTasks(appno,WorkflowConstant.WORKFLOW_TRANS_AGREE,mortgageApplyVO.getTaskComment());
		return appno;
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
	 * 通知书签发岗审批同意
	 * @param appno
	 * @param taskComment
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年5月17日下午1:55:01
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void DeliveryAppSignUpdater(String appno, String taskComment) throws ScubeBizException
	{
		
		//1、发往核心冻结保证金信息(待完善)
		//2、如果发送成功了，需要修改借据表的追加保证金金额
		List<BMrnAppliAcctInfo> bmrnappliacctinfoList = bmrnappliacctinfodao.selectByAppno(appno);
		if(bmrnappliacctinfoList != null && bmrnappliacctinfoList.size()>0){
			for (BMrnAppliAcctInfo bMrnAppliAcctInfo : bmrnappliacctinfoList) {
				com.huateng.scf.bas.lan.dao.model.BLanLnciBase bLanLnciBase = iBLanLnciBaseDAO.selectByPrimaryKey(bMrnAppliAcctInfo.getDebetNo());
				BigDecimal addbailAmt = bLanLnciBase.getAddBailAmount()==null?BigDecimal.ZERO:bLanLnciBase.getAddBailAmount();
				bLanLnciBase.setAddBailAmount(addbailAmt.add(bMrnAppliAcctInfo.getBailAmount()==null?BigDecimal.ZERO:bMrnAppliAcctInfo.getBailAmount()));
				//如果敞口为零将借据置为已结清状态
				BigDecimal lnciBal = bLanLnciBase.getLnciBal()==null?BigDecimal.ZERO:bLanLnciBase.getLnciBal();
				BigDecimal openAmt =lnciBal
						.subtract(bLanLnciBase.getAddBailAmount()!=null?bLanLnciBase.getAddBailAmount():BigDecimal.ZERO)
						.subtract(bLanLnciBase.getBailAmount()!=null?bLanLnciBase.getBailAmount():BigDecimal.ZERO)
						.subtract(bLanLnciBase.getAddCashEqtAmt()!=null?bLanLnciBase.getAddCashEqtAmt():BigDecimal.ZERO)
						.subtract(bLanLnciBase.getInitCashEqtAmt()!=null?bLanLnciBase.getInitCashEqtAmt():BigDecimal.ZERO);
					if(openAmt.compareTo(BigDecimal.ZERO)<=0){
						bLanLnciBase.setIsSettle(ScfBasConstant.FLAG_ON);//已结清
					}
					iBLanLnciBaseDAO.updateByPrimaryKey(bLanLnciBase);
			}
		}
		
		//3、填写通知书的签发日期
		List<BNteNoticeBase>  noticeList = bntenoticebaseservice.getNoticeBaseInfoByAppno(appno);
		if(noticeList !=null && noticeList.size() > 0)
		{
			int count = noticeList.size();
			BNteNoticeBase tblNoticeBaseInfo = null;
			for(int i=0;i<count;i++)
			{
				tblNoticeBaseInfo = noticeList.get(i);
				tblNoticeBaseInfo.setSignDate(ScfDateUtil.getStringDate(new Date()));
				com.huateng.scf.bas.nte.model.BNteNoticeBase bNteNoticeBase = 
						new com.huateng.scf.bas.nte.model.BNteNoticeBase();
				BeanUtils.copyProperties(tblNoticeBaseInfo, bNteNoticeBase);
				bntenoticebaseservice.updateBNteNoticeBase(bNteNoticeBase);
			}
		}
		//流程流转
		this.processTasks(appno,WorkflowConstant.WORKFLOW_TRANS_AGREE,taskComment);
	}
	
	/**
	 * 复核岗审批退回
	 * @param appno
	 * @param taskComment
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年5月17日下午1:58:04
	 */
	@Override
	public void DeliveryAppReviewBackUpdater(String appno, String taskComment) throws ScubeBizException
	{
		//流程流转
		this.processTasks(appno,WorkflowConstant.WORKFLOW_TRANS_GOBACK,taskComment);
	}
	
	/**
	 * 回执确认岗审批通过
	 * @param appno
	 * @param taskComment
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年5月17日下午2:01:10
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void DeliveryAppReceiptUpdater(String appno, String taskComment) throws ScubeBizException
	{
		//更新通知书
		bntenoticebaseservice.modifyNoticeBaseInfo(appno,NoticeConstant.NOTICE_BASE_STATUS_CONFIRM_AGREE);
		//更新提货申请审批通过后的数据同步 写正式表
		deliveryapplyservice.doDeliveryMortgage(appno);
		//释放额度 start
		BLanLnciBase tblLnciBaseInfo= blanlncibaseservice.getTblLnciBaseInfoByBussAppNo(appno);
		String hasIndirectCredit = "";
		if(null!=tblLnciBaseInfo)
		{
			BLanAppliLnciBase tblAppliLnciBaseInfo = blanapplilncibaseservice.findBLanAppliLnciBaseByDebtId(tblLnciBaseInfo.getDebetId());
			hasIndirectCredit=tblAppliLnciBaseInfo.getHasIndirectCredit()==null?"":tblAppliLnciBaseInfo.getHasIndirectCredit().trim();
		}

		if(ScfBasConstant.FLAG_ON.equals(hasIndirectCredit)){//有间接额度
			BPbcAppliBaseInfo tblAppliBaseInfo = bpbcapplibaseinfoservice.findBPbcAppliBaseInfoByKey(appno);
			if(tblAppliBaseInfo==null)
			{
				throw new ScubeBizException("业务申请记录丢失,无法更新！");
			}
			
			Map indirectMap=new HashMap();
			indirectMap.put(IndirectCreditConstant.APP_NO, appno);
			indirectMap.put(IndirectCreditConstant.DEBIT_NO, tblLnciBaseInfo.getDebetNo());
			indirectMap.put(IndirectCreditConstant.OPER_TYPE, ScfBasConstant.CREDIT_TRADE_TYPE_RELEASE);//操作类型
			scfIndirectCreditService.indCreditAppliCommonProcess(indirectMap, tblAppliBaseInfo.getBailAmount());
		}
		//释放额度 end
		//流程流转
		this.processTasks(appno,WorkflowConstant.WORKFLOW_TRANS_AGREE,taskComment);
	}
}
