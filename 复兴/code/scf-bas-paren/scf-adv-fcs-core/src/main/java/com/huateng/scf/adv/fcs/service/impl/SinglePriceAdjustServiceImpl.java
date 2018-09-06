/**
 * 
 */
package com.huateng.scf.adv.fcs.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huateng.authority.common.ContextHolder;
import com.huateng.authority.entity.UserInfo;
import com.huateng.flowsharp.entity.FlowsharpException;
import com.huateng.scf.adv.fcs.service.ISinglePriceAdjustService;
import com.huateng.scf.bas.cnt.dao.IBCntMprotBaseInfoDAO;
import com.huateng.scf.bas.cnt.dao.IBCntMprotCmInfoDAO;
import com.huateng.scf.bas.cnt.dao.IBCntMprotPartInfoDAO;
import com.huateng.scf.bas.cnt.dao.model.BCntMprotBaseInfo;
import com.huateng.scf.bas.cnt.dao.model.BCntMprotCmInfo;
import com.huateng.scf.bas.cnt.dao.model.BCntMprotPartInfoExample;
import com.huateng.scf.bas.common.constant.NoticeConstant;
import com.huateng.scf.bas.common.constant.ScfBasConstant;
import com.huateng.scf.bas.common.service.IScfWorkFlowService;
import com.huateng.scf.bas.common.startup.ScfMessageUtil;
import com.huateng.scf.bas.common.util.ScfDateUtil;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.common.util.UUIDGeneratorUtil;
import com.huateng.scf.bas.nte.dao.IBNteNoticeBaseDAO;
import com.huateng.scf.bas.nte.dao.model.BNteNoticeBase;
import com.huateng.scf.bas.nte.dao.model.BNteNoticeBaseExample;
import com.huateng.scf.bas.pbc.dao.IBPbcAppliBaseInfoDAO;
import com.huateng.scf.bas.pbc.dao.IBPbcAppliMtgInfoDAO;
import com.huateng.scf.bas.pbc.dao.IBPbcMtgBaseInfoDAO;
import com.huateng.scf.bas.pbc.dao.IBPbcMtgMktPriceDAO;
import com.huateng.scf.bas.pbc.dao.IBPbcMtgPriceHisDAO;
import com.huateng.scf.bas.pbc.dao.IBPbcMtgStockDtlDAO;
import com.huateng.scf.bas.pbc.dao.IBPbcMtgStorDeliDAO;
import com.huateng.scf.bas.pbc.dao.model.BPbcAppliBaseInfo;
import com.huateng.scf.bas.pbc.dao.model.BPbcMtgMktPrice;
import com.huateng.scf.bas.pbc.dao.model.BPbcMtgMktPriceExample;
import com.huateng.scf.bas.pbc.dao.model.BPbcMtgPriceHis;
import com.huateng.scf.bas.pbc.dao.model.BPbcMtgStockDtl;
import com.huateng.scf.bas.pbc.dao.model.BPbcMtgStorDeli;
import com.huateng.scf.bas.pbc.model.BPbcAppliMtgInfo;
import com.huateng.scf.bas.pbc.model.BPbcMtgBaseInfo;
import com.huateng.scf.bas.pbc.service.IBPbcAppliBaseInfoService;
import com.huateng.scf.bas.pbc.service.IBPbcAppliMtgInfoService;
import com.huateng.scf.bas.pbc.service.IBPbcMtgBaseInfoService;
import com.huateng.scf.bas.sys.constant.WorkflowConstant;
import com.huateng.scf.bas.sys.service.DealEndFlowService;
import com.huateng.scf.bas.sys.service.DealInFlowService;
import com.huateng.scf.rec.bcp.constant.RBcpErrorConstant;
import com.huateng.scf.sto.nwr.dao.IBPbcPricingBaseInfoDAO;
import com.huateng.scf.sto.nwr.dao.IBPbcPricingMtgDAO;
import com.huateng.scf.sto.nwr.dao.model.BPbcPricingBaseInfo;
import com.huateng.scf.sto.nwr.dao.model.BPbcPricingMtg;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * <p>
 * </p>
 *单个押品价格调整
 * @author gongzhao
 * @date 2017年4月26日上午10:25:06
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 *            <pre>
 * =================Modify Record=======================
 * Modifier			date	 	 Content
 * lihao		2017年4月26日上午10:25:06	      新增
 *
 *            </pre>
 */
@ScubeService
@Service("SinglePriceAdjustServiceImpl")
public class SinglePriceAdjustServiceImpl implements ISinglePriceAdjustService, DealInFlowService, DealEndFlowService {
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	//自定义流程公共类
	@Resource(name = IScfWorkFlowService.BEAN_ID)
	IScfWorkFlowService scfWorkFlowService;

	@Resource(name = "BPbcAppliMtgInfoServiceImpl")
	IBPbcAppliMtgInfoService bPbcAppliMtgInfoService;

	@Resource(name = "BPbcMtgBaseInfoServiceImpl")
	IBPbcMtgBaseInfoService bPbcMtgBaseInfoService;
	
	@Resource(name = "BPbcAppliBaseInfoDAO")
	IBPbcAppliBaseInfoDAO iBPbcAppliBaseInfoDAO;
	
	@Resource(name="BPbcMtgStorDeliDAO")
	IBPbcMtgStorDeliDAO iBPbcMtgStorDeliDAO;
	
	@Resource(name="BPbcMtgStockDtlDAO")
	IBPbcMtgStockDtlDAO iBPbcMtgStockDtlDAO;
	
	@Resource(name="BPbcMtgPriceHisDAO")
	IBPbcMtgPriceHisDAO iBPbcMtgPriceHisDAO;

	@Resource(name="BNteNoticeBaseDAO")
	IBNteNoticeBaseDAO BNteNoticeBaseDAO;
	
	@Resource(name="BPbcPricingBaseInfoDAO")
	IBPbcPricingBaseInfoDAO iBPbcPricingBaseInfoDAO;
	
	@Resource(name="BPbcPricingMtgDAO")
	IBPbcPricingMtgDAO IBPbcPricingMtgDAO;
	
	@Resource(name = "BPbcAppliMtgInfoDAO")
	IBPbcAppliMtgInfoDAO bPbcAppliMtgInfoDAO;
	
	@Resource(name="BPbcMtgBaseInfoDAO")
	IBPbcMtgBaseInfoDAO iBPbcMtgBaseInfoDAO;
	
	@Resource(name="BCntMprotBaseInfoDAO")
	IBCntMprotBaseInfoDAO iBCntMprotBaseInfoDAO;
	
	@Resource(name="BCntMprotPartInfoDAO")
	IBCntMprotPartInfoDAO  IBCntMprotPartInfoDAO;
	
	@Resource(name="BCntMprotCmInfoDAO")
	IBCntMprotCmInfoDAO iBCntMprotCmInfoDAO;
	
	@Resource(name="IBPbcMtgMktPriceDAO")
	IBPbcMtgMktPriceDAO iBPbcMtgMktPriceDAO;
	
	@Resource(name="BPbcPricingMtgDAO")
	IBPbcPricingMtgDAO  iBPbcPricingMtgDAO;
	
	@Resource(name = "BPbcAppliBaseInfoServiceImpl")
	IBPbcAppliBaseInfoService bpbcapplibaseinfoservice;
	
 	
	/*
	 * 批量调价审批通过
	 */
	@Override
	@Transactional
	public void doWorkForPass(String appNo) {
		
	
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.huateng.scf.bas.sys.service.DealEndFlowService#doWorkForReject(java.
	 * lang.String)
	 */
	@Override
	public void doWorkForReject(String appNo) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.huateng.scf.bas.sys.service.DealEndFlowService#doWorkForBack(java.
	 * lang.String)
	 */
	@Override
	public void doWorkForBack(String appNo) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.huateng.scf.bas.sys.service.DealInFlowService#doWorkForSubmit(java.
	 * lang.String)
	 */
	@Override
	public void doWorkForSubmit(String appNo) throws ScubeBizException {
		// TODO Auto-generated method stub

	}

	
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.huateng.scf.adv.fcs.service.PriceAdjustService#
	 * updateAppliMortgageStatus(java.lang.String)
	 */
	@Override
	@Transactional
	public void updateAppliMortgageStatus(String appno) throws ScubeBizException {
		// 1.数据校验
		if (appno == null || "".equals(appno)) {
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10005), RBcpErrorConstant.SCF_REC_BCP_10005);
		}
		//保存流水总表
		BPbcAppliBaseInfo bPbcAppliBaseInfo = iBPbcAppliBaseInfoDAO.selectByPrimaryKey(appno);
		BPbcMtgStorDeli bPbcMtgStorDeli = new BPbcMtgStorDeli();
		UserInfo user = ContextHolder.getUserInfo();
		bPbcMtgStorDeli.setAppno(appno);//申请编号
		bPbcMtgStorDeli.setTlrcd(user.getTlrNo());
		bPbcMtgStorDeli.setTxdate(ScfDateUtil.getStringDate(new Date()));
		bPbcMtgStorDeli.setTxtime(new Date());
		bPbcMtgStorDeli.setStorDeliBizType(ScfBasConstant.STOR_DELI_BIZ_TYPE_ADJUST_PRICE);//业务类型
		bPbcMtgStorDeli.setBussType(bPbcAppliBaseInfo.getSupplyChainPdId());//产品类型
		bPbcMtgStorDeli.setStorOrDeli(ScfBasConstant.STOR_OR_DELI_CHECK);//类型
		bPbcMtgStorDeli.setCurcd(bPbcAppliBaseInfo.getCurcd());//币种
		bPbcMtgStorDeli.setMonitorProtocolNo(bPbcAppliBaseInfo.getProtocolNo());//监管协议号
		String pid =  UUIDGeneratorUtil.generate();
		bPbcMtgStorDeli.setId( pid);
		iBPbcMtgStorDeliDAO.insert(bPbcMtgStorDeli);
		
		// 2.更新押品价格表(解锁了),保存流水明细表
		List<BPbcAppliMtgInfo> bPbcAppliMtgInfoList = bPbcAppliMtgInfoService.findBPbcAppliMtgInfoByAppno(appno);
		for (BPbcAppliMtgInfo bPbcAppliMtgInfo : bPbcAppliMtgInfoList) {
			BPbcMtgBaseInfo bPbcMtgBaseInfo = new BPbcMtgBaseInfo();
			bPbcMtgBaseInfo.setMortgageNo(bPbcAppliMtgInfo.getMortgageNo());;
			List<BPbcMtgBaseInfo> bPbcMtgBaseInfoList = bPbcMtgBaseInfoService.getMortgageInfoByMortgageLevels(bPbcMtgBaseInfo);
			//调整前单价
			BigDecimal oldPrice=bPbcAppliMtgInfo.getOldConfirmPrice()==null?new BigDecimal("0"):bPbcAppliMtgInfo.getOldConfirmPrice();
			//调整后单价
			BigDecimal price=bPbcAppliMtgInfo.getConfirmPrice()==null?new BigDecimal("0"):bPbcAppliMtgInfo.getConfirmPrice();
			//押品数量
			BigDecimal quantity=bPbcAppliMtgInfo.getQuantity()==null?new BigDecimal("0"):bPbcAppliMtgInfo.getQuantity();
			for (BPbcMtgBaseInfo bPbcMtgBaseInfo1 : bPbcMtgBaseInfoList) {
				//流水明细表
				BPbcMtgStockDtl bPbcMtgStockDtl=new BPbcMtgStockDtl();
				BeanUtils.copyProperties(bPbcMtgBaseInfo1, bPbcMtgStockDtl);
				bPbcMtgStockDtl.setOldConfirmPrice(oldPrice);//原始核定价
				bPbcMtgStockDtl.setConfirmPrice(price);//核定价
				bPbcMtgStockDtl.setOriginalTotPrice(oldPrice.multiply(quantity));//原始总价
				bPbcMtgStockDtl.setTotPrice(price.multiply(quantity));//总价
				bPbcMtgStockDtl.setBussType(ScfBasConstant.STOR_DELI_BIZ_TYPE_ADJUST_PRICE);//业务类型
				bPbcMtgStockDtl.setType(ScfBasConstant.STOR_DELI_BIZ_TYPE_ADJUST_PRICE);
				bPbcMtgStockDtl.setSupplyChainPdId(bPbcAppliBaseInfo.getSupplyChainPdId());//产品类型
				bPbcMtgStockDtl.setPid(pid);
				bPbcMtgStockDtl.setId(UUIDGeneratorUtil.generate());
				iBPbcMtgStockDtlDAO.insert(bPbcMtgStockDtl);
				
				//押品历史表 
				BPbcMtgPriceHis bPbcMtgPriceHis=new BPbcMtgPriceHis();
				BeanUtils.copyProperties(bPbcMtgBaseInfo1, bPbcMtgPriceHis);
				bPbcMtgPriceHis.setId(UUIDGeneratorUtil.generate());
				bPbcMtgPriceHis.setPriceOld(oldPrice);//原始核定价
				bPbcMtgPriceHis.setPriceNew(price);//核定价
				bPbcMtgPriceHis.setEvalOrg(bPbcMtgBaseInfo1.getBrcode());
				bPbcMtgPriceHis.setTlrcd(user.getTlrNo());
				bPbcMtgPriceHis.setPriceWay(ScfBasConstant.MORTGAGE_PRICE_WAY_BYHAND);
				bPbcMtgPriceHis.setTxdate(ScfDateUtil.getStringDate(new Date()));
				bPbcMtgPriceHis.setEvalTime(ScfDateUtil.getStringDate(new Date()));
				iBPbcMtgPriceHisDAO.insert(bPbcMtgPriceHis);
				
				//更新押品表
				bPbcMtgBaseInfo1.setOldConfirmPrice(oldPrice);
				bPbcMtgBaseInfo1.setConfirmPrice(price);
				bPbcMtgBaseInfo1.setOriginalTotPrice(oldPrice.multiply(quantity));
				bPbcMtgBaseInfo1.setTotPrice(price.multiply(quantity));
				bPbcMtgBaseInfo1.setLockAppno(null);
				bPbcMtgBaseInfo1.setIsLocked(ScfBasConstant.UNLOCKED);
				bPbcMtgBaseInfoService.updateBPbcMtgBaseInfo(bPbcMtgBaseInfo1);
			}
			bPbcAppliMtgInfo.setStatus(ScfBasConstant.APPLI_MORT_STATUS_APPROVED);// 单笔调价审批通过
			bPbcAppliMtgInfoService.updateBPbcAppliMtgInfo(bPbcAppliMtgInfo);
		}
	}
	
	/**
	 * 修改通知书，填写签发日期
	 * @param appno
	 */
	@Transactional
	public void updateNotice(String appno){

		BNteNoticeBaseExample example = new BNteNoticeBaseExample();
		com.huateng.scf.bas.nte.dao.model.BNteNoticeBaseExample.Criteria critiri = example.createCriteria();
		if(appno != null && !StringUtil.isEmpty(appno))
			critiri.andAppnoEqualTo(appno);
		List<BNteNoticeBase> list = BNteNoticeBaseDAO.selectByExample(example);
		if(list != null){
			for (BNteNoticeBase bNteNoticeBase : list) {
				bNteNoticeBase.setSignDate(ScfDateUtil.getStringDate(new Date()));
				bNteNoticeBase.setStatus(NoticeConstant.NOTICE_BASE_STATUS_CONFIRM_APPROVED);
				BNteNoticeBaseDAO.updateByPrimaryKey(bNteNoticeBase);
			}
		}
	}
	
	/**
	 * 保存核价信息
	 * @param bussAppno
	 * @throws CommonException
	 */
	@Transactional
	public void addPricingInfo(String bussAppno) throws ScubeBizException {

		BPbcAppliBaseInfo bPbcAppliBaseInfo = iBPbcAppliBaseInfoDAO.selectByPrimaryKey(bussAppno);

		List<com.huateng.scf.bas.pbc.dao.model.BPbcAppliMtgInfo> bPbcAppliMtgInfoList = bPbcAppliMtgInfoDAO.selectByAppno(bussAppno);

		//保存核价基本信息
		UserInfo user = ContextHolder.getUserInfo();//获取用户信息
		BPbcPricingBaseInfo bPbcPricingBaseInfo = new BPbcPricingBaseInfo();
		bPbcPricingBaseInfo.setAppno(bPbcAppliBaseInfo.getAppno());
		bPbcPricingBaseInfo.setPricingNo(bPbcAppliBaseInfo.getAppno());
		bPbcPricingBaseInfo.setAppliType(bPbcAppliBaseInfo.getAppliType());
		bPbcPricingBaseInfo.setApproveBrcode(user.getBrNo());
		bPbcPricingBaseInfo.setCustcd(bPbcAppliBaseInfo.getCustcd());
		
		BCntMprotBaseInfo bCntMprotBaseInfo = iBCntMprotBaseInfoDAO.selectByPrimaryKey(bPbcAppliBaseInfo.getProtocolNo());
		BCntMprotPartInfoExample example1 = new BCntMprotPartInfoExample();
		com.huateng.scf.bas.cnt.dao.model.BCntMprotPartInfoExample.Criteria c1 = example1.createCriteria();
		c1.andRoleEqualTo( ScfBasConstant.PROTOCOL_PART_ROLE_MONI);
		c1.andProtocolNoEqualTo(bPbcAppliBaseInfo.getProtocolNo());
		com.huateng.scf.bas.cnt.dao.model.BCntMprotPartInfo bCntMprotPartInfo = new com.huateng.scf.bas.cnt.dao.model.BCntMprotPartInfo();
		List<com.huateng.scf.bas.cnt.dao.model.BCntMprotPartInfo> mpList = IBCntMprotPartInfoDAO.selectByExample(example1);
		if(mpList != null && mpList.size()>0)
			bCntMprotPartInfo = mpList.get(0);
		
		bPbcPricingBaseInfo.setMoniOfCustcd(bCntMprotPartInfo.getCustcd());
		bPbcPricingBaseInfo.setPricingDate(ScfDateUtil.getStringDate(new Date()));
		bPbcPricingBaseInfo.setSlaveContno(bPbcAppliBaseInfo.getSlaveContno());
		bPbcPricingBaseInfo.setMonitorProtocolNo(bPbcAppliBaseInfo.getProtocolNo());
		bPbcPricingBaseInfo.setAppTlrcd(bPbcAppliBaseInfo.getAppTlrcd());
		if(bPbcAppliBaseInfo.getAppDate() !=null)
			bPbcPricingBaseInfo.setAppDate(ScfDateUtil.numberToDate(bPbcAppliBaseInfo.getAppDate()));
		else
			bPbcPricingBaseInfo.setAppDate(new Date());
		bPbcPricingBaseInfo.setApproveDate(ScfDateUtil.getStringDate(new Date()));
		bPbcPricingBaseInfo.setApprover(user.getTlrNo());
		bPbcPricingBaseInfo.setMoniModel(bCntMprotBaseInfo.getMoniType());

		//根据申请类型判断 存储 核价动因
		String appliType = bPbcAppliBaseInfo.getAppliType();
		if(WorkflowConstant.APPLI_TYPE_CHANGE_PRICE_APPLY.equals(appliType)){//质物价格调整
			bPbcPricingBaseInfo.setPricingReason(ScfBasConstant.PRICINGREASON_APPLI_CHANGE);
		}
		//查询监管协议扩展表获取仓库类型
		BCntMprotCmInfo bCntMprotCmInfo = iBCntMprotCmInfoDAO.selectByPrimaryKey(bPbcAppliBaseInfo.getProtocolNo());
		bPbcPricingBaseInfo.setMoniModel(bCntMprotCmInfo.getMoniWarehouseType());//监管模式 ->仓库类型
		bPbcPricingBaseInfo.setWarehouseAddress(bCntMprotCmInfo.getWarehousedress());
		String pid = UUIDGeneratorUtil.generate();
		bPbcPricingBaseInfo.setId(pid);
		iBPbcPricingBaseInfoDAO.insert(bPbcPricingBaseInfo);
		
		//价格审核表押品信息
		for (com.huateng.scf.bas.pbc.dao.model.BPbcAppliMtgInfo bPbcAppliMtgInfo : bPbcAppliMtgInfoList) {

			//根据productId 获取 盯市产品市场价
			com.huateng.scf.bas.pbc.dao.model.BPbcMtgBaseInfo bPbcMtgBaseInfo1 = iBPbcMtgBaseInfoDAO.selectByPrimaryKey(bPbcAppliMtgInfo.getMortgageNo());
			
			BigDecimal productPrice = BigDecimal.ZERO;
			BPbcMtgMktPriceExample ex =  new BPbcMtgMktPriceExample();
			com.huateng.scf.bas.pbc.dao.model.BPbcMtgMktPriceExample.Criteria criMktPrice = ex.createCriteria();
			if(bPbcMtgBaseInfo1 != null  && !StringUtil.isEmpty(bPbcMtgBaseInfo1.getFixMortgageNo()))
				criMktPrice.andProductIdEqualTo(bPbcMtgBaseInfo1.getFixMortgageNo());
			 List<BPbcMtgMktPrice> mktPriceList =  iBPbcMtgMktPriceDAO.selectByExample(ex);
			if(mktPriceList!=null && mktPriceList.size()>0)
				productPrice = mktPriceList.get(0).getPrice();
			BPbcPricingMtg bPbcPricingMtg = new BPbcPricingMtg();
			try {
				BeanUtils.copyProperties(bPbcAppliMtgInfo, bPbcPricingMtg);
			} catch (Exception e) {
				e.printStackTrace();
				throw new ScubeBizException();
			}
			bPbcPricingMtg.setPid(pid);
			bPbcPricingMtg.setThirdPartyPrice(productPrice);
			bPbcPricingMtg.setId(UUIDGeneratorUtil.generate());
			iBPbcPricingMtgDAO.insert(bPbcPricingMtg);
		}
	}

	@Override
	public void adjustPriceConfirm(String appNo, String taskComment) throws ScubeBizException {
		//1、修改通知书，填写签发日期
		this.updateNotice(appNo);
		
		// 2.更新押品价格表
		updateAppliMortgageStatus(appNo);
		
		//3、保存核价信息
		addPricingInfo(appNo);
		//4、流程流转
		this.processTasks(appNo, WorkflowConstant.WORKFLOW_TRANS_AGREE, taskComment);
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
		com.huateng.scf.bas.pbc.model.BPbcAppliBaseInfo applibaseinfo = bpbcapplibaseinfoservice.findBPbcAppliBaseInfoByKey(appno);
		applibaseinfo.setComment(taskComment);
		try {
			scfWorkFlowService.processTasks(applibaseinfo,status);
		} catch (FlowsharpException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
