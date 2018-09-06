package com.huateng.scf.rec.bcp.service.impl;
/**
 * <p>还款申请接口
 * </p>
 *
 * @author zhangcheng
 * @date 2017年3月4日下午8:34:31
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 *            <pre>
 * =================Modify Record=======================
 * Modifier			date	 	 Content
 * lihao		2017年3月4日下午8:34:31	      新增
 *
 *            </pre>
 */
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huateng.authority.common.ContextHolder;
import com.huateng.data.service.BdDataDictService;
import com.huateng.scf.bas.cnt.dao.IBCntDebtInfoDAO;
import com.huateng.scf.bas.cnt.dao.model.BCntDebtInfo;
import com.huateng.scf.bas.cnt.service.IBCntDebtInfoService;
import com.huateng.scf.bas.common.constant.ScfBasConstant;
import com.huateng.scf.bas.common.startup.ScfMessageUtil;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.common.util.UUIDGeneratorUtil;
import com.huateng.scf.bas.crm.dao.IBCrmBaseInfoDAO;
import com.huateng.scf.bas.crm.service.IBCrmBaseInfoService;
import com.huateng.scf.bas.lan.service.IBLanLnciBaseService;
import com.huateng.scf.bas.mrn.model.BMrnAppliAcctInfo;
import com.huateng.scf.bas.mrn.service.IBMrnAppliAcctInfoService;
import com.huateng.scf.bas.pbc.constant.BPbcErrorConstant;
import com.huateng.scf.bas.pbc.model.BPbcAppliBaseInfo;
import com.huateng.scf.bas.pbc.service.IAmountService;
import com.huateng.scf.bas.pbc.service.IBPbcAppliBaseInfoService;
import com.huateng.scf.bas.prd.dao.IBPrdInfoDAO;
import com.huateng.scf.bas.sys.constant.BSysConstant;
import com.huateng.scf.bas.sys.constant.BSysErrorConstant;
import com.huateng.scf.bas.sys.constant.WorkflowConstant;
import com.huateng.scf.bas.sys.service.DealEndFlowService;
import com.huateng.scf.bas.sys.service.IBSysSerialNoService;
import com.huateng.scf.rec.bcp.constant.RBcpDebtConstant;
import com.huateng.scf.rec.bcp.dao.IRBcpAppliBussDtlDAO;
import com.huateng.scf.rec.bcp.dao.IRBcpAppliBussInfoDAO;
import com.huateng.scf.rec.bcp.dao.IRBcpDebtBaseInfoDAO;
import com.huateng.scf.rec.bcp.dao.IRBcpDebtBussDtlDAO;
import com.huateng.scf.rec.bcp.dao.RBcpAppliRepaymentDAO;
import com.huateng.scf.rec.bcp.dao.ext.ExtBcpAppliBussDtlDAO;
import com.huateng.scf.rec.bcp.dao.ext.ExtIRBcpDebtBaseInfoDAO;
import com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussDtlExample;
import com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussDtlExample.Criteria;
import com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussInfoExample;
import com.huateng.scf.rec.bcp.dao.model.RBcpAppliRepayment;
import com.huateng.scf.rec.bcp.dao.model.RBcpAppliRepaymentExample;
import com.huateng.scf.rec.bcp.model.DebtBussInfoVO;
import com.huateng.scf.rec.bcp.model.DebtLnciBaseInfoVO;
import com.huateng.scf.rec.bcp.model.PayMentLanInfo;
import com.huateng.scf.rec.bcp.model.RBcpAppliBussDtl;
import com.huateng.scf.rec.bcp.model.RBcpAppliBussInfo;
import com.huateng.scf.rec.bcp.service.IIfspRBcpPaymentService;
import com.huateng.scf.rec.bcp.service.IRBcpAppliBussInfoService;
import com.huateng.scf.rec.bcp.service.IRBcpAppliRepaymentService;
import com.huateng.scf.rec.bcp.service.IRBcpDebtBaseInfoService;
import com.huateng.scf.rec.bcp.service.IRBcpDebtPoolService;
import com.huateng.scf.rec.bcp.service.InterfaceButtonQueryService;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

@ScubeService
@Service("IfspRBcpPaymentServiceImpl")
public class IfspRBcpPaymentServiceImpl implements IIfspRBcpPaymentService {

	@Resource(name = "BSysSerialNoServiceImpl")	
	IBSysSerialNoService  ibSysSerialNoService;
	@Resource(name = "bPbcAppliBaseInfoService")	
	IBPbcAppliBaseInfoService bPbcAppliBaseInfoService;
	@Resource(name = "RBcpAppliBussInfoDAO")
	IRBcpAppliBussInfoDAO rBcpAppliBussInfoDAO;
	@Resource(name = "BLanLnciBaseServiceImpl")
	IBLanLnciBaseService bLanLnciBaseService;
	@Resource(name = "RBcpAppliRepaymentDAO")
	RBcpAppliRepaymentDAO  rBcpAppliRepaymentDAO;
	@Resource(name = "BCntDebtInfoDAO")
	IBCntDebtInfoDAO bCntDebtInfoDAO;
	@Resource(name = "RBcpAppliRepaymentServiceImpl")
	IRBcpAppliRepaymentService rbcpapplirepaymentservice;
	@Resource(name = "InterfaceButtonQueryServiceImpl")
	InterfaceButtonQueryService interfaceButtonQueryService;
	@Resource(name =IBMrnAppliAcctInfoService.BEAN_ID) //保证金及现金等价物业务申请
	IBMrnAppliAcctInfoService bMrnAppliAcctInfoService;
	
	private final Logger log = LoggerFactory.getLogger(getClass());

	@Override
	@Transactional
	public String addPaymentApply(RBcpAppliBussInfo rBcpAppliBussInfo) {
		// TODO Auto-generated method stub
		String  appno=ibSysSerialNoService.genSerialNo("YS_HK_NO");
		com.huateng.scf.bas.lan.model.BLanLnciBase lnciBase=bLanLnciBaseService.findBLanLnciBaseByDebtId(rBcpAppliBussInfo.getDebetId());
		BCntDebtInfo vo=bCntDebtInfoDAO.selectByPrimaryKey(lnciBase.getProtocolNo());
		BigDecimal totalAmt=interfaceButtonQueryService.getAmountFromRaccount(vo.getReturnAccount());
		 if(rBcpAppliBussInfo.getReturnAmount().compareTo(totalAmt)>0){
				throw  new ScubeBizException("还款金额不能大于账户总额！");
		 }
	    DebtLnciBaseInfoVO lnci = new DebtLnciBaseInfoVO();
	    List lnciList=new ArrayList();
		BeanUtils.copyProperties(lnciBase, lnci);
		lnci.setRepayAmount(rBcpAppliBussInfo.getReturnAmount());
		lnci.setRepayIntamt(new BigDecimal(0));//实际还息金额
		lnci.setRepayBalamt(new BigDecimal(0));//实际还本金额
		lnciList.add(lnci);
		BPbcAppliBaseInfo bPbcAppliBaseInfo=new  BPbcAppliBaseInfo();
		bPbcAppliBaseInfo.setCustcd(rBcpAppliBussInfo.getCustcdSaller());
		bPbcAppliBaseInfo.setAppliType(WorkflowConstant.APPLI_TYPE_CASHPAYMENTAPPLY);
		bPbcAppliBaseInfo.setBusinessnoType(ScfBasConstant.BUSINESSNO_TYPE_CONTNO);
		bPbcAppliBaseInfo.setAppliStatus(WorkflowConstant.APPLI_STATUS_UNSUBMIT); // 申请状态:未提交（默认）
		bPbcAppliBaseInfo.setAppliStatusDtl(WorkflowConstant.APPLI_STATUS_DTL_WRITING); // 申请状态明细:未提交（默认）
		bPbcAppliBaseInfo.setSupplyChainPdId(vo.getSupplyChainPdId());//业务品种
		bPbcAppliBaseInfo.setAppno(appno);
		bPbcAppliBaseInfoService.addBPbcAppliBaseInfo(bPbcAppliBaseInfo);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
		String insertDate = simpleDateFormat.format(new Date());// 新增插入日期
		String brcode = vo.getBrcode();// 经办机构
		String tlrcd =vo.getTlrcd();// 操作员
	    try {
				com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussInfo record=new com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussInfo();	
				BeanUtils.copyProperties(rBcpAppliBussInfo, record);
				BeanUtils.copyProperties(vo, record);
				
				record.setAppno(appno);// 申请号
				record.setToSallerFlag("1");
				record.setInsertDate(insertDate);// 登记时间
				record.setCrtTime(new Date());// 创建时间
				record.setLastUptTime(new Date());// 最后更新时间
				record.setId(UUIDGeneratorUtil.generate());// id
				record.setApplyType(RBcpDebtConstant.APPLY_TYPE_REPAYMENT);
				record.setTlrcd(tlrcd);// 创建人，操作员
				record.setBrcode(brcode);// 设置经办机构信息
				record.setBussType(vo.getSupplyChainPdId());
				record.setReturnDate(insertDate);
				record.setReturnAccount(vo.getReturnAccount());
				record.setAccountNo(vo.getAccountNo());
				record.setReturnAmount(rBcpAppliBussInfo.getReturnAmount());
				record.setDebetId(lnci.getDebetId());
				record.setDebetNo(lnci.getDebetNo());
				rBcpAppliBussInfoDAO.insert(record);
				if(StringUtil.isStrNotEmpty(vo.getRepayPurpose())
						&&!RBcpDebtConstant.RETURN_USAGE_IN_BAILAMOUNT.equals(vo.getRepayPurpose())){
					
					//清空保证金表对应数据
					bMrnAppliAcctInfoService.clearTblAppliCustAccountInfo(appno);
			    
					this.saveTblAppliRepaymentInfo(lnciList,record);// 保存还贷款、尾款信息
				}
				if(StringUtil.isStrNotEmpty(vo.getRepayPurpose())
						&&RBcpDebtConstant.RETURN_USAGE_IN_BAILAMOUNT.equals(vo.getRepayPurpose())){
					
					// 清空还款表对应数据
					rbcpapplirepaymentservice.clearTblAppliRepaymentInfo(appno);
					
					this.saveTblAppliCustAccountInfo(lnciList,record);// 保存入保证金还款信息
				}
				return appno;
	    } catch (Exception e) {
			//e.printStackTrace();
			log.error("业务申请基本信息插入异常！"+e);
			throw  new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BPbcErrorConstant.SCF_BAS_PBC_10001),BPbcErrorConstant.SCF_BAS_PBC_10001);
		}
	     
	}

	
		
		/**
		 * 现金回款 -- 保存还款信息
		 * @param lnciPayList
		 * @param paymentInfo
		 * @throws ScubeBizException
		 */
		@Transactional
		public void saveTblAppliRepaymentInfo(List lnciPayList, com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussInfo paymentInfo) throws ScubeBizException {
			
			//清空保证金表对应数据
			//bMrnAppliAcctInfoService.clearTblAppliCustAccountInfo(paymentInfo.getAppno());
	
			RBcpAppliRepayment record = null;
			String brcode = paymentInfo.getBrcode();// 经办机构
			String tlrcd = paymentInfo.getTlrcd();// 操作员
			//保存前先清掉APPNO查询到记录
			rbcpapplirepaymentservice.clearTblAppliRepaymentInfo(paymentInfo.getAppno());
			DebtLnciBaseInfoVO debtVO = null;
			for (int i=0;i < lnciPayList.size();i++) {
				record = new RBcpAppliRepayment();
				debtVO = (DebtLnciBaseInfoVO) lnciPayList.get(i);
				if(ScfBasConstant.LOAN_WAY_WORKING_CAPITAL.equals(debtVO.getLnciType())){//融资方式是 流动资金贷款
					record.setId(UUIDGeneratorUtil.generate());
					record.setAppno(paymentInfo.getAppno());
					record.setDebetNo(debtVO.getDebetNo());//借据表主键
					record.setDebetId(debtVO.getDebetId());
					if(RBcpDebtConstant.RETURN_METHOD_BUYER_PAYMENT.equals(paymentInfo.getReturnMethod())){
						record.setCustcd(paymentInfo.getCustcdBuyer());//客户内部号
					}else{
						record.setCustcd(paymentInfo.getCustcdSaller());//客户内部号
					}
					record.setTlrcd(tlrcd);
					record.setBrcode(brcode);
					record.setRepayDate(BSysConstant.WORKDATE);
					record.setCurcd(debtVO.getCurcd());// 币别 默认人民币
					record.setReturnMethod(paymentInfo.getReturnMethod());// 还款类型
					record.setRepayAmount(debtVO.getRepayAmount());// 还款金额
					record.setMastContno(paymentInfo.getMastContno());//主合同号
					record.setPayAmount(debtVO.getRepayAmount());//入账金额
					record.setAmountOver(debtVO.getAmountOver());//尾款金额
					record.setRepayIntamt(debtVO.getRepayIntamt());//实际还息金额
					record.setRepayBalamt(debtVO.getRepayBalamt());//实际还本金额
					record.setAccountNo(debtVO.getBailAccount());//保证金账号
					record.setReturnType(paymentInfo.getReturnType());//还款方式
					rBcpAppliRepaymentDAO.insert(record);
				}
			}
		}
		
	/**
	 * 现金回款 -- 保存还款信息
	 * 
	 * @param lnciPayList
	 * @param paymentInfo
	 * @throws ScubeBizException
	 */
		@Transactional
	public void saveTblAppliCustAccountInfo(List lnciPayList, com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussInfo paymentInfo) throws ScubeBizException {
		// 清空还款表对应数据
		//rbcpapplirepaymentservice.clearTblAppliRepaymentInfo(paymentInfo.getAppno());
		
		BMrnAppliAcctInfo record = null;
		// 保存前先清掉APPNO查询到记录
		bMrnAppliAcctInfoService.clearTblAppliCustAccountInfo(paymentInfo.getAppno());
		DebtLnciBaseInfoVO debtVO = null;
		for (int i = 0; i < lnciPayList.size(); i++) {
			record = new BMrnAppliAcctInfo();
			debtVO = (DebtLnciBaseInfoVO) lnciPayList.get(i);
			record.setId(UUIDGeneratorUtil.generate());
			record.setAppno(paymentInfo.getAppno());
			record.setDebetNo(debtVO.getDebetNo());// 借据表主键
			if (RBcpDebtConstant.RETURN_METHOD_BUYER_PAYMENT.equals(paymentInfo.getReturnMethod())) {
				record.setCustcd(paymentInfo.getCustcdBuyer());// 客户内部号
			} else {
				record.setCustcd(paymentInfo.getCustcdSaller());// 客户内部号
			}
			
			record.setCurcd(debtVO.getCurcd());// 币别 默认人民币
			record.setMastContno(paymentInfo.getMastContno());// 主合同号
			record.setBailType(ScfBasConstant.BAIL_TYPE_NORMAL);// 保证金等价物类型：
																	// 03-保证金
			record.setInitType(ScfBasConstant.INIT_TYPE_ADD);// 保证金初始化类型： 02-追加
			record.setBailRate(debtVO.getBailPercent());// 保证金比例
			record.setConfirmStatus(ScfBasConstant.CONFIRM_STATUS_CONFIRMED);// 保证金及现金等价物确认状态：01-已确认
			record.setBailAccountno(debtVO.getBailAccount());// 保证金账号
			record.setAmount(debtVO.getRepayAmount());// 还款金额
			record.setPayAmount(debtVO.getRepayAmount());// 还款金额
			record.setBailAmount(debtVO.getRepayAmount());// 保证金金额
			bMrnAppliAcctInfoService.add(record);
		}
	}


		
}
