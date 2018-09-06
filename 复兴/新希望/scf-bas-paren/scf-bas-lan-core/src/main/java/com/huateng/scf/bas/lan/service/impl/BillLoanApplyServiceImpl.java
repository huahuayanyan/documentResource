package com.huateng.scf.bas.lan.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.common.constant.ScfBasConstant;
import com.huateng.scf.bas.common.model.AmountVO;
import com.huateng.scf.bas.common.service.IProductService;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.common.util.UUIDGeneratorUtil;
import com.huateng.scf.bas.crm.dao.IBCrmBaseInfoDAO;
import com.huateng.scf.bas.crm.dao.model.BCrmBaseInfo;
import com.huateng.scf.bas.crr.dao.IBCrrGntyConDAO;
import com.huateng.scf.bas.crr.dao.IBCrrLnConDAO;
import com.huateng.scf.bas.crr.dao.model.BCrrGntyCon;
import com.huateng.scf.bas.crr.dao.model.BCrrLnCon;
import com.huateng.scf.bas.lan.model.BLanAppliLnciBase;
import com.huateng.scf.bas.lan.service.IBLanAppliLnciBaseService;
import com.huateng.scf.bas.lan.service.IBillApplyMngService;
import com.huateng.scf.bas.lan.service.IBillLoanApplyService;
import com.huateng.scf.bas.mrn.service.IContractService;
import com.huateng.scf.bas.mrn.vo.ProtocolQryVO;
import com.huateng.scf.bas.pbc.service.IAmountService;
import com.huateng.scf.bas.pbc.service.IBPbcMtgBaseInfoService;
import com.huateng.scf.bas.pbc.vo.MortgageBaseInfoVO;
import com.huateng.scf.bas.prd.service.IBPrdInfoService;
import com.huateng.scf.rec.bcp.constant.RBcpErrorConstant;
import com.huateng.scf.sto.nwr.dao.model.SBcpAppliMortBillNormal;
import com.huateng.scf.sto.nwr.vo.AppliMortgageBaseQryVO;
import com.huateng.scf.sto.nwr.vo.BillCommonQryVO;
import com.huateng.scf.sto.nwr.vo.BillLnciBaseInfoVO;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * 
 * <p>仓单融资服务类</p>
 *
 * @author 	mengjiajia
 * @date 	2017年4月21日上午11:12:51
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2017年4月21日上午11:12:51	     新增
 *
 * </pre>
 */
@ScubeService
@Service("BillLoanApplyServiceImpl")
public class BillLoanApplyServiceImpl implements IBillLoanApplyService 
{
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@Resource(name = "IBCrrLnConDAO")
	IBCrrLnConDAO bcrrlncondao;
	
	@Resource(name = "IBCrrGntyConDAO")
	IBCrrGntyConDAO bcrrgntycondao;
	
	@Resource(name = IBLanAppliLnciBaseService.BEAN_ID)
	IBLanAppliLnciBaseService blanapplilncibaseservice;

	@Resource(name = "AmountServiceImpl")
	IAmountService amountservice;
	
	@Resource(name = "ProductServiceImpl")
	IProductService productservice;
	
	@Resource(name = "ContractServiceImpl")
	IContractService contractservice;
	
	@Resource(name = "IBCrmBaseInfoDAO")
	IBCrmBaseInfoDAO bcrmbaseinfodao;
	
//	@Resource(name = "SBcpAppliMortBillNormalServiceImpl")
//	ISBcpAppliMortBillNormalService sbcpapplimortbillnormalservice;
	
	@Resource(name = "BPbcMtgBaseInfoServiceImpl")
	IBPbcMtgBaseInfoService bpbcmtgbaseinfoservice;
	
	@Resource(name = "BillApplyMngServiceImpl")
	IBillApplyMngService billapplymngservice;
	
	@Resource(name = "BPrdInfoServiceImpl")
	IBPrdInfoService bprdinfoservice;
	
	/**
	 * 得到普通仓单贷款申请信息
	 * @param billCommonQryVO
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年4月21日上午11:20:47
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Page getBillNormalLoanApplyInfo(BillCommonQryVO billCommonQryVO ) throws ScubeBizException 
	{
		log.debug("融资基本信息查询==========================================");
		Page pageQueryResult = new Page();

		BillLnciBaseInfoVO billLnciBaseInfoVO = new BillLnciBaseInfoVO();
		List<BillLnciBaseInfoVO> resultList = new ArrayList<BillLnciBaseInfoVO>();
		BLanAppliLnciBase appliLnciBaseInfo = blanapplilncibaseservice.queryBLanAppliLnciBaseByAppno(billCommonQryVO.getAppno());// 借据申请信息
		if(appliLnciBaseInfo == null){
			throw new ScubeBizException("融资申请借据信息丢失！", RBcpErrorConstant.RECORD_NOT_EXIST);
		}

		//1-获取借据表的信息
		BeanUtils.copyProperties(appliLnciBaseInfo, billLnciBaseInfoVO);

		billLnciBaseInfoVO.setLoanWay(appliLnciBaseInfo.getLnciType());  //出账方式
		//2-借款合同表的信息
		BCrrLnCon tblContBaseInfo = bcrrlncondao.selectByPrimaryKey(billLnciBaseInfoVO.getMastContcode());  //信贷合同号
		billLnciBaseInfoVO.setContStartDate(tblContBaseInfo.getLnStrtDt());
		billLnciBaseInfoVO.setContEndDate(tblContBaseInfo.getLnEndDt());
		billLnciBaseInfoVO.setContAmount(tblContBaseInfo.getLnAmt());  //合同金额
		billLnciBaseInfoVO.setContRiskAmt(tblContBaseInfo.getLnAmt());  //总敞口
		billLnciBaseInfoVO.setCycle(tblContBaseInfo.getControlType());  //是否循环使用
		billLnciBaseInfoVO.setMastContStatus(tblContBaseInfo.getAppStat()); //合同状态
		billLnciBaseInfoVO.setMastContcode(tblContBaseInfo.getAppId());  //信贷合同号
        billLnciBaseInfoVO.setMastContno(tblContBaseInfo.getAppId()); //信贷合同号(ID)
        billLnciBaseInfoVO.setCurcd(tblContBaseInfo.getCurcd());   //币种
        billLnciBaseInfoVO.setCreditProtNo(tblContBaseInfo.getCreditProtNo());  //额度协议流水号
        billLnciBaseInfoVO.setRateType(tblContBaseInfo.getIntCd());//利率类型
        billLnciBaseInfoVO.setRepayMethod(tblContBaseInfo.getRtnTyp());//还款方式

        //设置借据申请表的产品ID信息
        if(!StringUtil.isEmpty(billCommonQryVO.getSupplyChainPdId()))
        {
        	appliLnciBaseInfo.setProductId(billCommonQryVO.getSupplyChainPdId());
        }
        String protocolNo = null;
        String parentProductID = productservice.getParentIdById(billCommonQryVO.getSupplyChainPdId());
        String businessNo  = tblContBaseInfo.getVidNo();  //业务合同号
//        BigDecimal lowNewPrice = new BigDecimal(0);
//        String moniModel="";

       //获取信贷合同的可用敞口   modify by fengjinfu 2013-10-17  start
		BigDecimal contOpenAmount = amountservice.getContRiskAmtByCycle(tblContBaseInfo.getAppId(),tblContBaseInfo.getControlType());
		billLnciBaseInfoVO.setAvaliableRiskAmt(tblContBaseInfo.getLnAmt().subtract(contOpenAmount));
		//获取信贷合同的可用敞口   modify by fengjinfu 2013-10-17  start

		//3-担保合同信息
    	BCrrGntyCon tblContSlaveInfo = bcrrgntycondao.selectByPrimaryKey(businessNo);  //担保合同号ID
        if(parentProductID.equals(ScfBasConstant.PRODUCT_TYPE_MORT) )
        {
        	billLnciBaseInfoVO.setSupplyChainPdId(tblContSlaveInfo.getVidPrdId());  //业务品种
        	billLnciBaseInfoVO.setSlaveContno(businessNo);
        	billLnciBaseInfoVO.setSlaveContcode(businessNo);  //质押合同号
        	
        	billLnciBaseInfoVO.setBusinessNo(businessNo);
        	protocolNo = tblContSlaveInfo.getPrtclNo();
        }
        billLnciBaseInfoVO.setRation(tblContSlaveInfo.getRation());  //质押率

        //4-监管合同信息
        billLnciBaseInfoVO.setProtocolNo(protocolNo);
        ProtocolQryVO protocolQryVO = new ProtocolQryVO();
        protocolQryVO.setProtocolNo(protocolNo);
        Page contractpageQueryResult = contractservice.getMonitorProtocolQuery(protocolQryVO);
        List contractList = contractpageQueryResult.getRecords();
        if(contractList != null && contractList.size()> 0)
        {
        	Map<String, Object> contractVO = (Map<String, Object>) contractList.get(0);
        	billLnciBaseInfoVO.setProtocolCode(contractVO.get("protocolCode").toString());
        	billLnciBaseInfoVO.setMoniCustcd(contractVO.get("thrCd").toString());  //监管公司客户号
        	billLnciBaseInfoVO.setMoniName(contractVO.get("thrName").toString());  //监管公司名称
        }

        //5-出质人名称
        BCrmBaseInfo tblCustBaseInfo = bcrmbaseinfodao.selectById(billLnciBaseInfoVO.getCustcd());
        billLnciBaseInfoVO.setCname(tblCustBaseInfo.getCname());

    	  //6-计算可用敞口
        AmountVO amountVO =  new AmountVO(billLnciBaseInfoVO.getSupplyChainPdId(),billLnciBaseInfoVO.getBusinessNo());
        amountVO.setArrivedManageModel(ScfBasConstant.ARRIVED_MANAGE_MODE_SINGLE);
        com.huateng.scf.bas.pbc.model.AmountVO amount = new com.huateng.scf.bas.pbc.model.AmountVO();
        BeanUtils.copyProperties(amountVO, amount);
        BigDecimal openAmount= amountservice.getPant(amount);//敞口余额
  //    mortgageLnciBaseInfoVO.setAvaliableRiskAmt(mortgageLnciBaseInfoVO.getContRiskAmt().subtract(openAmount));//信贷合同可用敞口

        String billno_Q = "";
//        List<SBcpAppliMortBillNormal> list = sbcpapplimortbillnormalservice.getBillNormalAppByAppno(billCommonQryVO.getAppno());
        List<SBcpAppliMortBillNormal> list = null;
        if(list != null && list.size() > 0)
        {
        	for(int i = 0; i < list.size(); i++)
        	{
        		SBcpAppliMortBillNormal billNormal = list.get(i);
        		billno_Q = billno_Q + "/f" +  billNormal.getBillno();
        	}
        	billno_Q = billno_Q.replaceFirst("/f", "");
        }

        //7-现货押品总价值 
        AppliMortgageBaseQryVO commonQueryVO = new AppliMortgageBaseQryVO();
        commonQueryVO.setSlaveContno(billLnciBaseInfoVO.getBusinessNo());
        commonQueryVO.setBillno(billno_Q);
        Page  mortgagePageQueryResult =  bpbcmtgbaseinfoservice.getEffectTotPrice(commonQueryVO);
        List mortgageList = mortgagePageQueryResult.getRecords();
        if(mortgageList!=null && mortgageList.size() > 0)
        {
        	MortgageBaseInfoVO mortgageBaseInfoVO = (MortgageBaseInfoVO) mortgageList.get(0);
        	billLnciBaseInfoVO.setMortgageTotalValue(mortgageBaseInfoVO.getTotalPrice());  //押品总价值
        	if(null == billLnciBaseInfoVO.getMortgageTotalValue() ){
        		billLnciBaseInfoVO.setMortgageTotalValue(new BigDecimal("0"));
        	}
        }

        //8-可融资金额
        //规则：可融资金额 = 押品总价值*质押率 - 敞口余额
        BigDecimal avaliableAmt = BigDecimal.ZERO;
        //规则：可融资金额 = 押品总价值*质押率 - 已融资金额
        BigDecimal billLoanAmt = this.getBillNormalLoanAmt(billCommonQryVO.getAppno());
        avaliableAmt =billLnciBaseInfoVO.getMortgageTotalValue()
        								.multiply(StringUtil.isEmpty(billLnciBaseInfoVO.getRation())?new BigDecimal(0):billLnciBaseInfoVO.getRation())
        								.divide(new BigDecimal(100))
        								.subtract(billLoanAmt)
        								// .subtract(openAmount)
        								.setScale(2, BigDecimal.ROUND_HALF_UP);
        billLnciBaseInfoVO.setAvaliableAmt(avaliableAmt);

        //9-本笔风险敞口
        //规则：本笔风险敞口 = 出账金额 – 初始保证金 – 初始现金等价物金额。页面端需要根据初始现金等价物的更新而变化。
        if(billLnciBaseInfoVO.getBailAmount() == null)
        {
        	billLnciBaseInfoVO.setBailAmount(new BigDecimal(0));  //判空处理
        }
        if(billLnciBaseInfoVO.getInitCashEqtAmt() == null)
        {
        	billLnciBaseInfoVO.setInitCashEqtAmt(new BigDecimal(0));   //判空处理
        }

        BigDecimal riskAmt = billLnciBaseInfoVO.getLnciAmt().subtract(billLnciBaseInfoVO.getBailAmount()).subtract(billLnciBaseInfoVO.getInitCashEqtAmt());
        billLnciBaseInfoVO.setRiskAmt(riskAmt);

    	BigDecimal lowNewPrice = openAmount.multiply(new BigDecimal(100)).divide(StringUtil.isEmpty(billLnciBaseInfoVO.getRation())?new BigDecimal(0):billLnciBaseInfoVO.getRation(),2,BigDecimal.ROUND_HALF_UP);
    	billLnciBaseInfoVO.setLowPriceNew(lowNewPrice);


        resultList.add(billLnciBaseInfoVO);
		pageQueryResult.setRecords(resultList);
		pageQueryResult.setTotalRecord(resultList.size());
		return pageQueryResult;
	}

	/**
	 * 获取仓单审批已通过的融资金额
	 * @param appno
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年4月21日下午4:14:31
	 */
	@SuppressWarnings("unchecked")
	public BigDecimal getBillNormalLoanAmt(String appno) throws ScubeBizException
	{
//		List<SBcpAppliMortBillNormal> list = sbcpapplimortbillnormalservice.getBillNormalAppByAppno(appno);
		List<SBcpAppliMortBillNormal> list =null;
		BigDecimal result = new BigDecimal("0");
		if(list != null && list.size() > 0){
			SBcpAppliMortBillNormal appBill = (SBcpAppliMortBillNormal)list.get(0);
			String billno = appBill.getBillno();
			result = billapplymngservice.getBillNormalLoanAmt(billno);
		}
		return result;
	}
	
	/**
	 * 查询普通仓单申请质物的核库信息
	 * @param billCommonQryVO
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年4月24日下午2:38:12
	 */
	@Override
	public Page getBillNormalAppChkStockInfo(BillCommonQryVO billCommonQryVO) throws ScubeBizException
	{
		Page queryResult = billapplymngservice.getBillNormalAppChkStockInfo(billCommonQryVO);
		return queryResult;
	}

	/**
	 * 保存借据表的信息
	 * @param appliLnciInfo
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年4月24日下午4:02:44
	 */
	@Override
	public void saveLoanApplyInfo(BillLnciBaseInfoVO appliLnciInfo) throws ScubeBizException
	{
		// 保存借据申请表的信息
		BLanAppliLnciBase tblAppliLnciBaseInfo = blanapplilncibaseservice.queryBLanAppliLnciBaseByAppno(appliLnciInfo.getAppno());
		//获取中类信息
//		String midProductId = bprdinfoservice.getSubClassProductIds(appliLnciInfo.getSupplyChainPdId());
		//补录相关的信息
		tblAppliLnciBaseInfo.setInitCashEqtAmt(appliLnciInfo.getInitCashEqtAmt()==null?new BigDecimal(0):appliLnciInfo.getInitCashEqtAmt());
		BigDecimal bailAmount = tblAppliLnciBaseInfo.getBailAmount()==null?new BigDecimal(0):tblAppliLnciBaseInfo.getBailAmount();
		BigDecimal addBailAmount = tblAppliLnciBaseInfo.getAddBailAmount()==null ? new BigDecimal(0):tblAppliLnciBaseInfo.getAddBailAmount();
		tblAppliLnciBaseInfo.setTotalBailAmount(bailAmount.add(addBailAmount));  //保证金总金额
		tblAppliLnciBaseInfo.setRiskAmt(appliLnciInfo.getRiskAmt());  //本笔风险敞口；
		tblAppliLnciBaseInfo.setAvaliableAmt(appliLnciInfo.getAvaliableAmt());  //可融资金额
		tblAppliLnciBaseInfo.setBailAmount(appliLnciInfo.getBailAmount());
		if(StringUtil.isEmpty(tblAppliLnciBaseInfo.getSlaveContno()))
		{
			BCrrLnCon tblContBaseInfo = bcrrlncondao.selectByPrimaryKey(tblAppliLnciBaseInfo.getMastContcode());
			BCrrGntyCon tblContSlaveInfo = bcrrgntycondao.selectByPrimaryKey(tblContBaseInfo.getVidNo());
			tblAppliLnciBaseInfo.setSlaveContno(tblContSlaveInfo.getConId());  //质押合同号
			tblAppliLnciBaseInfo.setProtocolNo(tblContSlaveInfo.getPrtclNo());   //监管协议号
		}
		if(StringUtil.isEmpty(tblAppliLnciBaseInfo.getId())){
			tblAppliLnciBaseInfo.setId(UUIDGeneratorUtil.generate());
		}

		if(StringUtil.isEmpty(tblAppliLnciBaseInfo.getDebetNo())){
			tblAppliLnciBaseInfo.setDebetNo(UUIDGeneratorUtil.generate());
		}
		blanapplilncibaseservice.updateBLanAppliLnciBase(tblAppliLnciBaseInfo);
	}
}
