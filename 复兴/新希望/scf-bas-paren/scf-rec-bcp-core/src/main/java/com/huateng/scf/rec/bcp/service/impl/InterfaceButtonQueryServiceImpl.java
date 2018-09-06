/*
 * ==================================================================
 * The Huateng Software License
 *
 * Copyright (c) 2008-2012 TOPSCF  All rights reserved.
 * ==================================================================
 */

package com.huateng.scf.rec.bcp.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.common.constant.InterfaceConstants;
import com.huateng.scf.bas.common.constant.ScfBasConstant;
import com.huateng.scf.bas.common.model.InterfaceButtonVO;
import com.huateng.scf.bas.mrn.dao.IBMrnAcctBussInfoDAO;
import com.huateng.scf.bas.mrn.dao.model.BMrnAcctBussInfoExample;
import com.huateng.scf.bas.mrn.model.ExtInterface;
import com.huateng.scf.rec.bcp.constant.RBcpErrorConstant;
import com.huateng.scf.rec.bcp.service.InterfaceButtonQueryService;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * 
 * <p>调用接口查询信息按钮，通过触发页面按钮，根据不同的交易码调用不同的接口查询相关信息</p>
 *
 * @author 	mengjiajia
 * @date 	2017年1月22日上午10:42:32
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2017年1月22日上午10:42:32	     新增
 *
 * </pre>
 */
@ScubeService
@Service("InterfaceButtonQueryServiceImpl")
public class InterfaceButtonQueryServiceImpl implements InterfaceButtonQueryService {
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@Resource(name = "BMrnAcctBussInfoDAO")
	IBMrnAcctBussInfoDAO bmrnacctbussinfodao;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Page InterfaceButtonQuery(ExtInterface extInterface) throws ScubeBizException {
		log.debug("保证金账户："+extInterface.getBailAccountno());
		String txnCode = extInterface.getTxnCode();
		if (StringUtils.isEmpty(txnCode)) {
			throw new ScubeBizException("接口交易码为空，不能进行接口查询",
					RBcpErrorConstant.ERROR_CODE_DATA_INPUT_ERR);
		}
		Page queryResult = new Page();
		if (txnCode.equals(InterfaceConstants.TXCODE_ACCOUNT_QUERY_RECORDS)){	// 账号信息查询
			String switchType  = ScfBasConstant.FLAG_OFF; //核心系统开关标志默认开
//			try {	//调用核心接口
//				switchType = SysParamUnit.getCoreFlag();
//			} catch (CommonException e1) {
//				e1.printStackTrace();
//			}
			if (ScfBasConstant.FLAG_ON.equals(switchType)){
				BMrnAcctBussInfoExample example = new BMrnAcctBussInfoExample();
				BMrnAcctBussInfoExample.Criteria cri = example.createCriteria();
				cri.andBailAccountnoEqualTo(extInterface.getBailAccountno());
				List<com.huateng.scf.bas.mrn.dao.model.BMrnAcctBussInfo> mrnlist = bmrnacctbussinfodao.selectByExample(example);
				queryResult.setRecords(mrnlist);
				queryResult.setTotalRecord(mrnlist.size());
			}else{
				InterfaceButtonVO interfaceButtonVO = new InterfaceButtonVO();
				interfaceButtonVO.setAccountBalance(new BigDecimal(10000000));
				interfaceButtonVO.setAvaliableRiskAmt(new BigDecimal(10000000));
				List list = new ArrayList();
				list.add(interfaceButtonVO);
				queryResult.setRecords(list);
				queryResult.setTotalRecord(list.size());
			}
		}
//		if (txnCode.equals(InterfaceConstants.TXCODE_BAIL_SYNCHRONIZE)){	//冻结保证金信息
//			String mastContno = DataFormat.trim(getCommQueryServletRequest()
//					.getParameter("mastContno"));
//			String slaveContno = DataFormat.trim(getCommQueryServletRequest()
//					.getParameter("slaveContno"));
//			String riskAmtStr = DataFormat.trim(getCommQueryServletRequest()
//					.getParameter("riskAmt"));
//			String debetNo = DataFormat.trim(getCommQueryServletRequest()
//					.getParameter("debetNo"));
//			BigDecimal avaliableRiskAmt = null;
//			String switchType  = SCFConstants.FLAG_ON;
//			BigDecimal freezBail = BigDecimal.ZERO;
//			BigDecimal totBal = BigDecimal.ZERO;
//			BigDecimal bailAmount = BigDecimal.ZERO;
//			BigDecimal addBailAmount = BigDecimal.ZERO;
//			String cycle = "1";
//			List list =new ArrayList();
//			TblLnciBaseInfoDAO tblLnciBaseInfoDAO = SCFDAOUtils.getTblLnciBaseInfoDAO();
//			if(!SCFDataFormat.isEmpty(slaveContno)){ //根据质押合同号查借据敞口余额
//				list = SCFDAOUtils.getApplyServiceDAO().getLnciListBySlaveContno(slaveContno);
////				riskAmtStr = DAOUtils.getTblContBaseInfoDAO().getSumRiskAmt(
////						slaveContno) == null ? "0" : DAOUtils
////						.getTblContBaseInfoDAO().getSumRiskAmt(slaveContno).toString();
//			}else if(!SCFDataFormat.isEmpty(debetNo)) {//借据查询
//				list = tblLnciBaseInfoDAO.queryByCondition("po.debetNo = '" + debetNo +"'");
//			}else {
//				TblContBaseInfo contBaseInfo = SCFDAOUtils.getTblContBaseInfoDAO().get(SCFDataFormat.trim(mastContno));
//				if (contBaseInfo != null){
//					cycle = SCFDataFormat.trim(contBaseInfo.getCycle());
//				}
//				if (cycle.equals(SCFConstants.CONT_CREDIT_CYCLE)){
//					list = tblLnciBaseInfoDAO.queryByCondition("po.state != '"
//							+ SCFConstants.FLAG_ON + "' and po.isSettle = '"
//							+ SCFConstants.FLAG_OFF + "' and po.mastContno = '"
//							+ mastContno + "'");
//				}else{
//					list = tblLnciBaseInfoDAO.queryByCondition("po.state != '"
//							+ SCFConstants.FLAG_ON + "' and po.mastContno = '"
//							+ mastContno + "'");
//				}
//			}
//			if (list == null || list.size()<= 0){
//				avaliableRiskAmt = BigDecimal.ZERO;
//				if (!SCFDataFormat.isEmpty(mastContno) && !SCFDataFormat.isEmpty(riskAmtStr)){
//					avaliableRiskAmt = (new BigDecimal(riskAmtStr)).subtract(totBal);
//					TblAppliLnciBaseInfoDAO tblAppliLnciBaseInfoDAO = SCFDAOUtils.getTblAppliLnciBaseInfoDAO();
//					List sumlist  = tblAppliLnciBaseInfoDAO.getFlowRiskAmtByMastContno(mastContno);
//					if(sumlist !=null && sumlist.size() > 0){
//						BigDecimal flowAmt = (BigDecimal)sumlist.get(0);
//						avaliableRiskAmt = avaliableRiskAmt.subtract(flowAmt==null?new BigDecimal(0):flowAmt);
//					}
//				}
//			}else{
//				try {	//调用核心接口，查询冻结保证金
//					switchType = SysParamUnit.getCoreFlag();
//				} catch (CommonException e1) {
//					e1.printStackTrace();
//				}
//				if(SCFConstants.FLAG_OFF.equals(switchType)){//开关关闭
//					avaliableRiskAmt = new BigDecimal("9999.00");
//				}else if (SCFConstants.FLAG_ON.equals(switchType)){//开关打开
//					TblLnciBaseInfo tblLnciBaseInfo = null;
//					List lnciList = new ArrayList();
//					for (int i = 0; i < list.size(); i++){
//						tblLnciBaseInfo = (TblLnciBaseInfo)list.get(i);
//						if (cycle.equals(SCFConstants.CONT_CREDIT_CYCLE)){
//							if (SCFConstants.LOAN_WAY_BANK_ACCEPTENCE.equals(tblLnciBaseInfo.getLnciType())){
//								freezBail = this.getBillFreezBailInfo(tblLnciBaseInfo.getDebetNo());
//							}else{
//								freezBail = this.getFreezBailInfo(tblLnciBaseInfo.getDebetId()).getJioyje();
//							}
//							if(SCFConstants.LNCI_STATE_NEW.equals(tblLnciBaseInfo.getState()))
//							{
//								freezBail = tblLnciBaseInfo.getBailAmount();
//							}
//							totBal = totBal.add(tblLnciBaseInfo.getLnciBal()==null?new BigDecimal(0):tblLnciBaseInfo.getLnciBal()
//									.subtract(tblLnciBaseInfo.getAddCashEqtAmt()==null?new BigDecimal(0):tblLnciBaseInfo.getAddCashEqtAmt())
//									.subtract(tblLnciBaseInfo.getInitCashEqtAmt()==null?new BigDecimal(0):tblLnciBaseInfo.getInitCashEqtAmt())
//									.subtract(freezBail));
//							bailAmount = tblLnciBaseInfo.getBailAmount()==null?new BigDecimal(0):tblLnciBaseInfo.getBailAmount();
//							addBailAmount = tblLnciBaseInfo.getAddBailAmount()==null?new BigDecimal(0):tblLnciBaseInfo.getAddBailAmount();
//							if (freezBail.subtract(bailAmount.add(addBailAmount)).floatValue()>0){//追加保证金
//								tblLnciBaseInfo.setAddBailAmount(freezBail.subtract(bailAmount));
//							}else if (freezBail.subtract(bailAmount.add(addBailAmount)).floatValue()<0){//减少保证金
//								if ((bailAmount.add(addBailAmount)).subtract(freezBail).subtract(addBailAmount).floatValue()<=0){
//									tblLnciBaseInfo.setAddBailAmount(freezBail.subtract(bailAmount));
//								}else{
//									tblLnciBaseInfo.setAddBailAmount(BigDecimal.ZERO);
//									tblLnciBaseInfo.setBailAmount(freezBail);
//								}
//							}
////							if(!SCFConstants.LNCI_STATE_NEW.equals(tblLnciBaseInfo.getState()))
////							{
//								lnciList.add(tblLnciBaseInfo);
////							}
//						}else{
//							if (SCFConstants.LOAN_WAY_BANK_ACCEPTENCE.equals(tblLnciBaseInfo.getLnciType())){
//								freezBail = this.getBillFreezBailInfo(tblLnciBaseInfo.getDebetNo());
//							}else{
//								freezBail = this.getFreezBailInfo(tblLnciBaseInfo.getDebetId()).getJioyje();
//							}
//							if(SCFConstants.LNCI_STATE_NEW.equals(tblLnciBaseInfo.getState()))
//							{
//								freezBail = tblLnciBaseInfo.getBailAmount();
//							}
//
//							totBal = totBal.add(tblLnciBaseInfo.getLnciAmt()==null?new BigDecimal(0):tblLnciBaseInfo.getLnciAmt()
//									.subtract(tblLnciBaseInfo.getAddCashEqtAmt()==null?new BigDecimal(0):tblLnciBaseInfo.getAddCashEqtAmt())
//									.subtract(tblLnciBaseInfo.getInitCashEqtAmt()==null?new BigDecimal(0):tblLnciBaseInfo.getInitCashEqtAmt())
//									.subtract(freezBail));
//							bailAmount = tblLnciBaseInfo.getBailAmount()==null?new BigDecimal(0):tblLnciBaseInfo.getBailAmount();
//							addBailAmount = tblLnciBaseInfo.getAddBailAmount()==null?new BigDecimal(0):tblLnciBaseInfo.getAddBailAmount();
//							if (freezBail.subtract(bailAmount.add(addBailAmount)).floatValue()>0){//追加保证金
//								tblLnciBaseInfo.setAddBailAmount(freezBail.subtract(bailAmount));
//							}else if (freezBail.subtract(bailAmount.add(addBailAmount)).floatValue()<0){//减少保证金
//								if ((bailAmount.add(addBailAmount)).subtract(freezBail).subtract(addBailAmount).floatValue()<=0){
//									tblLnciBaseInfo.setAddBailAmount(freezBail.subtract(bailAmount));
//								}else{
//									tblLnciBaseInfo.setAddBailAmount(BigDecimal.ZERO);
//									tblLnciBaseInfo.setBailAmount(freezBail);
//								}
//							}
////							if(!SCFConstants.LNCI_STATE_NEW.equals(tblLnciBaseInfo.getState()))
////							{
//								lnciList.add(tblLnciBaseInfo);
////							}
//						}
//						// 同步时释放间接额度 add by huabin.zhong 2013-11-20
//						if (freezBail.subtract(bailAmount.add(addBailAmount)).floatValue()>0
//								&& SCFConstants.FLAG_ON.equals(tblLnciBaseInfo.getHasIndirectCredit())
//								&& SCFConstants.FLAG_OFF.equals(tblLnciBaseInfo.getState())) {
//							IndirectCreditService.getInstance().indirectCreditAppliCommonProcess(
//									tblLnciBaseInfo.getAppno(), tblLnciBaseInfo.getDebetNo(),
//									SCFConstants.CREDIT_TRADE_TYPE_RELEASE, freezBail.subtract(bailAmount.add(addBailAmount)));
//						}
//					}
//					//更新借据表，先注释掉
//					//tblLnciBaseInfoDAO.updateAll(lnciList);
//					if (!SCFDataFormat.isEmpty(mastContno) && !SCFDataFormat.isEmpty(riskAmtStr)){
//						avaliableRiskAmt = (new BigDecimal(riskAmtStr)).subtract(totBal);
//						TblAppliLnciBaseInfoDAO tblAppliLnciBaseInfoDAO = SCFDAOUtils.getTblAppliLnciBaseInfoDAO();
//						List sumlist  = tblAppliLnciBaseInfoDAO.getFlowRiskAmtByMastContno(mastContno);
//						if(sumlist !=null && sumlist.size() > 0){
//							BigDecimal flowAmt = (BigDecimal)sumlist.get(0);
//							avaliableRiskAmt = avaliableRiskAmt.subtract(flowAmt==null?new BigDecimal(0):flowAmt);
//						}
//					}else{
//						//根据质押合同号查借据敞口余额，不要用信贷合同的总敞口减了
//						if(!SCFDataFormat.isEmpty(slaveContno))
//						{
//							//计算敞口余额时，需要统计流程中的数据。
//							TblAppliLnciBaseInfoDAO tblAppliLnciBaseInfoDAO = SCFDAOUtils.getTblAppliLnciBaseInfoDAO();
//							List sumlist  = tblAppliLnciBaseInfoDAO.getFlowRiskAmtByBusinessNo(slaveContno);
//						    if(sumlist !=null && sumlist.size() > 0)
//						    {
//						    	BigDecimal flowAmt = (BigDecimal)sumlist.get(0);
//						    	totBal = totBal.add(flowAmt==null?new BigDecimal(0):flowAmt);
//						    }
//						}
//
//						avaliableRiskAmt = totBal;
//					}
//				}
//			}
//			InterfaceButtonVO interfaceButtonVO = new InterfaceButtonVO();
//			List resultlist =new ArrayList();
//			interfaceButtonVO.setAvaliableRiskAmt(avaliableRiskAmt);
//			resultlist.add(interfaceButtonVO);
//			queryResult.setQueryResult(resultlist);
//			queryResult.setTotalCount(1);
//		}
		return queryResult;
	}

	/**
	 * @Description: 账号信息查询 交易码s033
	 * @author zhonghuabin
	 * @Created 2013-8-9下午3:22:32
	 * @param accountNo
	 * @return
	 */
//	public Page getAccountInfo(String accountNo) throws ScubeBizException {
//		Page pageQueryResult = new Page();
//		List list = new ArrayList();
//		S033ReqData cores033ReqData = new S033ReqData();
//		cores033ReqData.setJymmbz("0"); //密码校验方式 0－不校验
//		cores033ReqData.setKehuzh(accountNo);
//		cores033ReqData.setHuobdh("01");//01-人民币
//		S033RspData s033RspData = CoreClientService.getInstance().doS033(cores033ReqData);
//		InterfaceButtonVO interfaceButtonVO = new InterfaceButtonVO();
//		interfaceButtonVO.setAccountBalance(s033RspData.getAvabal());
//		list.add(interfaceButtonVO);
//		pageQueryResult.setQueryResult(list);
//		pageQueryResult.setTotalCount(1);
//		return pageQueryResult;
//	}

	/**
	 * @Description: 核心系统冻结保证金查询 交易码s169
	 * @author zhonghuabin
	 * @Created 2013-8-9下午4:38:50
	 * @param debetNo
	 * @return
	 * @throws CommonException
	 */
//	public S169RspData getFreezBailInfo(String debetId) throws CommonException {
//		S169ReqData s169ReqData = new S169ReqData();
//		s169ReqData.setYsywbh(SCFDataFormat.trim(debetId));
//		s169ReqData.setQudaoo(SCFConstants.CHNL_NO_CCMS); //渠道号统一使用13-信贷系统
//		S169RspData s169RspData = CoreClientService.getInstance().doS169(s169ReqData);
//		return s169RspData;
//	}

	/**
	 * @Description: 银承借据根据票据来查核心系统冻结保证金
	 * @author zhonghuabin
	 * @Created 2013-11-13下午5:50:55
	 * @param debetNo
	 * @return
	 * @throws CommonException
	 */
//	public BigDecimal getBillFreezBailInfo(String debetNo) throws CommonException {
//		BigDecimal freezBail = BigDecimal.ZERO;
//		S169ReqData s169ReqData = new S169ReqData();
//		List billList = SCFDAOUtils.getTblBillBaseInfoDAO().queryByCondition("po.debetNo = '" + debetNo+  "'");
//		if (billList!=null && billList.size()>0){
//			for (int i=0;i<billList.size();i++){
//				TblBillBaseInfo tblBillBaseInfo = (TblBillBaseInfo)billList.get(i);
//				s169ReqData.setYsywbh(SCFDataFormat.trim(tblBillBaseInfo.getLoanNo()));
//				s169ReqData.setQudaoo(SCFConstants.CHNL_NO_CCMS); //渠道号统一使用13-信贷系统
//				S169RspData s169RspData = CoreClientService.getInstance().doS169(s169ReqData);
//				freezBail = freezBail.add(s169RspData.getJioyje()==null?BigDecimal.ZERO:s169RspData.getJioyje());
//			}
//		}
//		return freezBail;
//	}
	public BigDecimal getAmountFromRaccount(String returnAccount) throws ScubeBizException{
        return new BigDecimal(10000000);
}
}
