/*
 * ==================================================================
 * The Huateng Software License
 *
 * Copyright (c) 2008-2012 TOPSCF  All rights reserved.
 * ==================================================================
 */

package com.huateng.scf.nrec.bcp.service.impl;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.cnt.constant.BCntErrorConstant;
import com.huateng.scf.bas.common.startup.ScfMessageUtil;
import com.huateng.scf.bas.common.util.ScfDateUtil;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.lan.dao.model.BLanLnciBase;
import com.huateng.scf.bas.sys.constant.BSysConstant;
import com.huateng.scf.bas.sys.constant.WorkflowConstant;
import com.huateng.scf.nrec.bcp.dao.IRBcpDebtInfoDAO;
import com.huateng.scf.nrec.bcp.dao.ext.ExtNrecBcpDAO;
import com.huateng.scf.nrec.bcp.dao.model.RBcpDebtInfo;
import com.huateng.scf.nrec.bcp.model.BCntBcpInfoVO;
import com.huateng.scf.nrec.bcp.service.IBCntBcpInfoService;
import com.huateng.scf.nrec.bcp.service.INFactFinanceBaseService;
import com.huateng.scf.nrec.bcp.service.INRBcpAppliBussDtlService;
import com.huateng.scf.rec.bcp.model.AppliBussDetailVO;
import com.huateng.scf.rec.bcp.model.DebtBussInfoVO;
import com.huateng.scf.rec.bcp.model.DebtCommonQryVO;
import com.huateng.scf.rec.bcp.model.RBcpAppliBussDtl;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * 
 * <p>应收类融资基础服务</p>
 *
 * @author 	mengjiajia
 * @date 	2017年5月24日下午1:51:16
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2017年5月24日下午1:51:16	     新增
 *
 * </pre>
 */
@ScubeService
@Service("NFactFinanceBaseServiceImpl")
public class NFactFinanceBaseServiceImpl implements INFactFinanceBaseService{

	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@Resource(name = "NRBcpAppliBussDtlServiceImpl")
	INRBcpAppliBussDtlService Nrbcpapplibussdtlservice;
	
	@Resource(name = "IRBcpDebtInfoDAO")
	IRBcpDebtInfoDAO rbcpdebtinfodao;
	
	@Resource(name = "BCntBcpInfoServiceImpl")
	IBCntBcpInfoService bcntbcpinfoservice;
	
	@Resource(name = "ExtNrecBcpDAO")
	ExtNrecBcpDAO extnrecbcpdao;
	
	/**
	 * 查询应收账款列表
	 * @param appno
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年5月24日下午1:32:46
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Page queryAppliBussDetailByAppnoDebt(int pageNo, int pageSize,String appno) throws ScubeBizException
	{
		log.debug("查询应收账款列表==============================");
		Page pageQueryResult = Nrbcpapplibussdtlservice.queryAppliBussDetailByAppnoPage(pageNo, pageSize, appno, null);
		List<RBcpAppliBussDtl> relist = pageQueryResult.getRecords();
		List<AppliBussDetailVO> list = new ArrayList<AppliBussDetailVO>();
		if (relist != null && relist.size() > 0)
		{
			for(RBcpAppliBussDtl bcpAppliBussDtl:relist)
			{
				AppliBussDetailVO dtlVO = new AppliBussDetailVO();
				BeanUtils.copyProperties(bcpAppliBussDtl, dtlVO);
				RBcpDebtInfo baseInfo = rbcpdebtinfodao.selectByPrimaryKey(dtlVO.getDebtId());
				if(baseInfo!=null){
					dtlVO.setBillsAmountView(baseInfo.getBillsAmountView());
					try {
						dtlVO.setDeadLine(ScfDateUtil.toDate(baseInfo.getDeadline(),"yyyyMMdd"));
						dtlVO.setConfirmDate(ScfDateUtil.toDate(baseInfo.getConfirmDate(),"yyyyMMdd"));
						dtlVO.setGracePeriod(baseInfo.getGracePeriod());
					} catch (ParseException e) {
						e.printStackTrace();
					}
				}
				list.add(dtlVO);
			}
		}
		pageQueryResult.setRecords(list);
		return pageQueryResult;
	}
	
	
	/**
	 * 应收账款池融资合同项下生效的借据敞口余额汇总
	 * 修改关联查询表-mengjiajia
	 * @param mastContno
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年6月6日上午9:33:03
	 */
	@Override
	public BigDecimal calculatePoolRiskAvailableAmtByBusinessNo(String mastContno) throws ScubeBizException{
		log.debug("mastContno="+mastContno);
		HashMap<String, Object> omap = new HashMap<String, Object>();
		omap.put("mastContno", mastContno);
		omap.put("state", BSysConstant.FLAG_ON); // 记录状态
		omap.put("isSettle", BSysConstant.FLAG_OFF); // 是否结清
		//用于计算流程中的借据敞口，配置版放款除审批通过及否决，均在流程中
		List<String> appliStatusDtl = new ArrayList<String>();
		appliStatusDtl.add(WorkflowConstant.APPLI_STATUS_DTL_APPROVED);
		appliStatusDtl.add(WorkflowConstant.APPLI_STATUS_DTL_REFUSED);
		omap.put("appliStatusDtl", appliStatusDtl);
		List<BLanLnciBase> list = extnrecbcpdao.queryLnciInfoByMastContno(omap);
		List<HashMap<String, Object>> flowList = extnrecbcpdao.getFlowRiskAmtByMastContno(omap);
		BigDecimal totalContRist = new BigDecimal(0);
		if(list !=null && list.size() > 0){
			BLanLnciBase tblLnciBaseInfoTmp = null;
			int count = list.size();
			BigDecimal addBailAmount;
			BigDecimal bailAmount;
			BigDecimal initCashEqtAmt;
			BigDecimal addCashEqtAmt;
			BigDecimal lnciBal;

			for(int i=0;i<count;i++){
				tblLnciBaseInfoTmp = (BLanLnciBase) list.get(i);
				//借据敞口余额 = 借据余额 – 冻结保证金 – 现金等价物金额
				addBailAmount = (tblLnciBaseInfoTmp.getAddBailAmount()==null?new BigDecimal(0):tblLnciBaseInfoTmp.getAddBailAmount());
				bailAmount = (tblLnciBaseInfoTmp.getBailAmount()== null ? new BigDecimal(0):tblLnciBaseInfoTmp.getBailAmount());
				initCashEqtAmt = (tblLnciBaseInfoTmp.getInitCashEqtAmt()== null? new BigDecimal(0):tblLnciBaseInfoTmp.getInitCashEqtAmt());
				addCashEqtAmt = (tblLnciBaseInfoTmp.getAddCashEqtAmt()== null ? new BigDecimal(0):tblLnciBaseInfoTmp.getAddCashEqtAmt());
				lnciBal = tblLnciBaseInfoTmp.getLnciBal();
				totalContRist = totalContRist.add(lnciBal.subtract(addBailAmount).subtract(bailAmount).subtract(initCashEqtAmt).subtract(addCashEqtAmt));
			}
		}
		// 流程中借据敞口余额也要统计  add by xiaolong.xiong 2013-09-29
		if(flowList != null && flowList.size() > 0)
		{
			HashMap<String, Object> map = (HashMap<String, Object>) flowList.get(0);
			BigDecimal amt = (BigDecimal) (map.get("AMT") == null ? BigDecimal.ZERO : map.get("AMT"));
			totalContRist = totalContRist.add(amt);
		}
		return totalContRist;
	}


	/**
	 * 应收账款转让根据合同编号查询合同信息和业务品种信息
	 * @param commonQueryVO
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年5月31日下午4:56:50
	 */
	@Override
	public DebtBussInfoVO getContDebtInfoByMastContno(DebtCommonQryVO commonQueryVO) throws ScubeBizException {
		BCntBcpInfoVO bCntBcpInfoVO = null;
		if (null != commonQueryVO && StringUtil.isStrNotEmpty(commonQueryVO.getMastContno())) {
			bCntBcpInfoVO = bcntbcpinfoservice.queryBCntBcpInfoByMastContno(commonQueryVO.getMastContno());
		} else {
			log.error("合同号丢失！");
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BCntErrorConstant.SCF_BAS_CNT_30000), BCntErrorConstant.SCF_BAS_CNT_30000);
		}
		if (bCntBcpInfoVO == null) {
			log.error("保理合同信息丢失！");
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BCntErrorConstant.SCF_BAS_CNT_30002), BCntErrorConstant.SCF_BAS_CNT_30002);
		}
		String loanDays = "";
		if(!StringUtil.isEmpty(bCntBcpInfoVO.getLoanDays()))
		{
			loanDays = bCntBcpInfoVO.getLoanDays().toString();
			bCntBcpInfoVO.setLoanDays(null);
		}
		DebtBussInfoVO debtVO = new DebtBussInfoVO();
		BeanUtils.copyProperties(bCntBcpInfoVO, debtVO);
		debtVO.setLoanDays(loanDays);
		debtVO.setCustcdBuyer(commonQueryVO.getCustcdBuyer_Q());
		debtVO.setCustcdSaller(bCntBcpInfoVO.getCustcd());
		debtVO.setCnameSeller(bCntBcpInfoVO.getCname());
		debtVO.setBussType(bCntBcpInfoVO.getSupplyChainPdId());
		if (StringUtil.isEmpty(debtVO.getBalanceAccount())) {
			debtVO.setBalanceAccount(debtVO.getAccountNo());
		} else if (StringUtil.isEmpty(debtVO.getAccountNo())) {
			debtVO.setAccountNo(debtVO.getBalanceAccount());
		}
		debtVO.setAppno(commonQueryVO.getAppno_Q());
		BigDecimal loanpercent = new BigDecimal(0);
		if (bCntBcpInfoVO.getLoanPercent() == null) {
			debtVO.setLoanPercent(loanpercent);
		}
		return debtVO;
	}
}
