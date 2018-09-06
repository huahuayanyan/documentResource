package com.huateng.scf.sto.nwr.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
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
import com.huateng.scf.adv.tcs.service.IATcsThreeDeliveryService;
import com.huateng.scf.bas.cnt.model.BCntMprotBaseInfo;
import com.huateng.scf.bas.cnt.model.BCntMprotPartInfo;
import com.huateng.scf.bas.cnt.model.DeliveryQryVO;
import com.huateng.scf.bas.cnt.service.IBCntMprotBaseInfoService;
import com.huateng.scf.bas.cnt.service.IBCntMprotPartInfoService;
import com.huateng.scf.bas.common.constant.NoticeConstant;
import com.huateng.scf.bas.common.constant.ScfBasConstant;
import com.huateng.scf.bas.common.model.AmountVO;
import com.huateng.scf.bas.common.service.IScfWorkFlowService;
import com.huateng.scf.bas.common.util.ScfDateUtil;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.common.util.UUIDGeneratorUtil;
import com.huateng.scf.bas.crm.dao.IBCrmBaseInfoDAO;
import com.huateng.scf.bas.crm.dao.model.BCrmBaseInfo;
import com.huateng.scf.bas.crr.dao.IBCrrGntyConDAO;
import com.huateng.scf.bas.crr.dao.model.BCrrGntyCon;
import com.huateng.scf.bas.lan.dao.vo.BLanLnciBaseAcctVo;
import com.huateng.scf.bas.lan.model.BLanLnciBase;
import com.huateng.scf.bas.lan.service.IBLanLnciBaseService;
import com.huateng.scf.bas.mrn.dao.model.BMrnAppliAcctInfo;
import com.huateng.scf.bas.mrn.model.AppendBailAmountVO;
import com.huateng.scf.bas.mrn.model.DebetListVO;
import com.huateng.scf.bas.mrn.service.IBMrnAppliAcctInfoService;
import com.huateng.scf.bas.mrn.service.IContractService;
import com.huateng.scf.bas.nte.dao.model.BNteNoticeBase;
import com.huateng.scf.bas.nte.dao.model.BNteNoticeMtg;
import com.huateng.scf.bas.nte.service.IBNteNoticeBaseService;
import com.huateng.scf.bas.nte.service.IBNteNoticeMtgService;
import com.huateng.scf.bas.pbc.model.BPbcAppliBaseInfo;
import com.huateng.scf.bas.pbc.model.BPbcAppliMtgInfo;
import com.huateng.scf.bas.pbc.model.BPbcMtgBaseInfo;
import com.huateng.scf.bas.pbc.model.BPbcMtgStockDtl;
import com.huateng.scf.bas.pbc.model.BPbcMtgStorDeli;
import com.huateng.scf.bas.pbc.service.IAmountService;
import com.huateng.scf.bas.pbc.service.IBPbcAppliBaseInfoService;
import com.huateng.scf.bas.pbc.service.IBPbcAppliMtgInfoService;
import com.huateng.scf.bas.pbc.service.IBPbcMtgBaseInfoService;
import com.huateng.scf.bas.pbc.service.IBPbcMtgStockDtlService;
import com.huateng.scf.bas.pbc.service.IBPbcMtgStorDeliService;
import com.huateng.scf.bas.pbc.service.IQualityApplyService;
import com.huateng.scf.bas.pbc.vo.MortgageApplyVO;
import com.huateng.scf.bas.sys.constant.WorkflowConstant;
import com.huateng.scf.bas.sys.service.IBSysSerialNoService;
import com.huateng.scf.rec.bcp.constant.RBcpErrorConstant;
import com.huateng.scf.sto.nwr.service.IDeliveryApplyService;
import com.huateng.scf.sto.nwr.vo.AppliMortgageBaseQryVO;
import com.huateng.scf.sto.pcb.service.IAdjustPriceService;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;
import static java.lang.Math.abs;

/**
 * 
 * <p>换货申请实现类</p>
 *
 * @author 	mengjiajia
 * @date 	2017年4月27日下午3:56:51
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2017年4月27日下午3:56:51	     新增
 *
 * </pre>
 */
@ScubeService
@Service("DeliveryApplyServiceImpl")
public class DeliveryApplyServiceImpl implements IDeliveryApplyService 
{
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@Resource(name = "BPbcAppliMtgInfoServiceImpl")
	IBPbcAppliMtgInfoService bpbcapplimtginfoservice;
	
	@Resource(name ="BPbcMtgBaseInfoServiceImpl")
	IBPbcMtgBaseInfoService bpbcmtgbaseinfoservice;
	
	@Resource(name ="BPbcAppliBaseInfoServiceImpl")
	IBPbcAppliBaseInfoService bpbcapplibaseinfoservice;
	
	@Resource(name = "BPbcMtgStorDeliServiceImpl")
	IBPbcMtgStorDeliService bpbcmtgstordeliservice;
	
	@Resource(name = "BPbcMtgStockDtlServiceImpl")
	IBPbcMtgStockDtlService bpbcmtgstockdtlservice;
	
	@Resource(name = "ATcsThreeDeliveryServiceImpl")
	IATcsThreeDeliveryService atcsthreedeliveryservice;
	
	@Resource(name = "IBCrrGntyConDAO")
	IBCrrGntyConDAO bcrrgntycondao;

	@Resource(name = "IBCrmBaseInfoDAO")
	IBCrmBaseInfoDAO bcrmbaseinfodao;
	
	@Resource(name = "BMrnAppliAcctInfoServiceImpl")
	IBMrnAppliAcctInfoService bmrnappliacctinfoservice;
	
	@Resource(name = "AmountServiceImpl")
	IAmountService amountservice;
	
	@Resource(name = "BLanLnciBaseServiceImpl")
	IBLanLnciBaseService blanlncibaseservice;
	
	@Resource(name = "ContractServiceImpl")
	IContractService contractservice;
	
	@Resource(name = "BCntMprotBaseInfoServiceImpl")
	IBCntMprotBaseInfoService bcntmprotbaseinfoservice;
	
	@Resource(name = "BCntMprotPartInfoServiceImpl")
	IBCntMprotPartInfoService bcntmprotpartinfoservice;
	
	@Resource(name = "QualityApplyServiceImpl")
	IQualityApplyService qualityapplyservice;
	
	@Resource(name = "AdjustPriceServiceImpl")
	IAdjustPriceService adjustpriceservice;
	
	//自定义流程公共类
	@Resource(name = IScfWorkFlowService.BEAN_ID)
	IScfWorkFlowService scfWorkFlowService;
	
	@Resource(name = "BNteNoticeBaseServiceImpl")
	IBNteNoticeBaseService bntenoticebaseservice;
	
	@Resource(name = "BSysSerialNoServiceImpl")
	IBSysSerialNoService bSysSerialNoService;// 流水号生成服务
	
	@Resource(name = "BNteNoticeMtgServiceImpl")
	IBNteNoticeMtgService bntenoticemtgservice;
	
	/**
	 * 提货回执确认后处理押品
	 * @param appno
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年4月27日下午3:58:14
	 */
	@Override
	public void doDeliveryMortgage(String appno) throws ScubeBizException
	{
		log.debug("appno:"+appno);
		//获取提货押品信息
		List<?> list = bpbcapplimtginfoservice.findBPbcAppliMtgInfoByAppno(appno);
		
		//押品变更流水
		String id = InsertMortgageStorDeliInfo(appno);
		//押品变更明细
		InsertMortgageStockInfo(id, list,appno);
		
		for(int i=0;i<list.size();i++)
		{
			BPbcAppliMtgInfo baseInfo =(BPbcAppliMtgInfo)list.get(i);
			String mortNo = baseInfo.getMortgageNo();
			//提货数量
			BigDecimal mortNum = baseInfo.getBalQuantity()==null?new BigDecimal("0"):baseInfo.getBalQuantity();
			BPbcMtgBaseInfo mortgageBaseInfo = bpbcmtgbaseinfoservice.findBPbcMtgBaseInfoByKey(mortNo);

			BigDecimal quantitys = mortgageBaseInfo.getQuantity()==null?new BigDecimal("0"):mortgageBaseInfo.getQuantity();
			//剩余数量
			BigDecimal quantity = quantitys.subtract(mortNum);
			if(quantity.compareTo(BigDecimal.ZERO)==-1)
			{
				throw new ScubeBizException("在库押品数量小于提货数量!",RBcpErrorConstant.ERROR_CODE_INFO_DTL);
			}
			if(quantity.compareTo(BigDecimal.ZERO)==0)
			{
				mortgageBaseInfo.setStockStatus(ScfBasConstant.STOCK_STATUS_INVALID);
			}
			mortgageBaseInfo.setQuantity(quantity);
			BigDecimal confirmPrice = mortgageBaseInfo.getConfirmPrice();
			BigDecimal totPrice = quantity.multiply(confirmPrice).setScale(2,BigDecimal.ROUND_DOWN);
			mortgageBaseInfo.setTotPrice(totPrice);
			bpbcmtgbaseinfoservice.update(mortgageBaseInfo);

			//押品解锁
			bpbcmtgbaseinfoservice.releaseMortgageBaseInfo(mortgageBaseInfo.getMortgageNo());
		}
		atcsthreedeliveryservice.savecustAccountInfo(appno);
	}
	
	/**
	 * 动产提货押品变更流水
	 * @param appno
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年4月27日下午4:04:06
	 */
	public String InsertMortgageStorDeliInfo(String appno) throws ScubeBizException
	{
		BPbcAppliBaseInfo applyInfo=bpbcapplibaseinfoservice.findBPbcAppliBaseInfoByKey(appno);
		//流水总表
		BPbcMtgStorDeli tblMortgageStorDeliInfo=new BPbcMtgStorDeli();
		tblMortgageStorDeliInfo.setAppno(appno);//申请编号
		tblMortgageStorDeliInfo.setTlrcd(applyInfo.getAppTlrcd());
		tblMortgageStorDeliInfo.setTxdate(ScfDateUtil.getStringDate(new Date()));
		tblMortgageStorDeliInfo.setTxtime(new Date());
		tblMortgageStorDeliInfo.setStorDeliBizType(ScfBasConstant.STOR_DELI_BIZ_TYPE_DELIVERY);//业务类型
		tblMortgageStorDeliInfo.setBussType(applyInfo.getSupplyChainPdId());//产品类型
		tblMortgageStorDeliInfo.setStorOrDeli(ScfBasConstant.STOR_OR_DELI_OUT);//类型
		tblMortgageStorDeliInfo.setMonitorProtocolNo(applyInfo.getProtocolNo());//监管协议号
		String fid = bpbcmtgstordeliservice.addBPbcMtgStorDeli(tblMortgageStorDeliInfo);
		return fid;
	}
	
	/**
	 * 动产提货明细流水
	 * @param id
	 * @param list
	 * @param appno
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年4月27日下午4:08:45
	 */
	public void InsertMortgageStockInfo(String id,List<?> list,String appno) throws ScubeBizException
	{
		BPbcAppliBaseInfo applyInfo = bpbcapplibaseinfoservice.findBPbcAppliBaseInfoByKey(appno);
		BPbcMtgBaseInfo tblMortgageBaseInfo = new BPbcMtgBaseInfo();
		for(int i=0;i<list.size();i++)
		{
			//押品信息
			BPbcAppliMtgInfo tblAppliMortgageBaseInfo=(BPbcAppliMtgInfo) list.get(i);
			if(tblAppliMortgageBaseInfo==null)
			{
				throw new ScubeBizException("押品信息获取失败！", RBcpErrorConstant.RECORD_NOT_EXIST);
			}
			//押品数量
			BigDecimal quantity = tblAppliMortgageBaseInfo.getBalQuantity()==null?new BigDecimal("0"):tblAppliMortgageBaseInfo.getBalQuantity();
			BigDecimal price=tblAppliMortgageBaseInfo.getConfirmPrice()==null?new BigDecimal("0"):tblAppliMortgageBaseInfo.getConfirmPrice();
			//流水明细表
			BPbcMtgStockDtl tblMortgageStockInfo = new BPbcMtgStockDtl();

			BeanUtils.copyProperties(tblAppliMortgageBaseInfo, tblMortgageStockInfo);
			
			tblMortgageBaseInfo = bpbcmtgbaseinfoservice.findBPbcMtgBaseInfoByKey(tblAppliMortgageBaseInfo.getMortgageNo());
			if(null!=tblMortgageBaseInfo && (null!=tblMortgageBaseInfo.getQuantity()))
			{
				tblMortgageStockInfo.setOriginalQuantity(tblMortgageBaseInfo.getQuantity());
			}
			else
			{
				tblMortgageStockInfo.setOriginalQuantity(BigDecimal.ZERO);
			}
			tblMortgageStockInfo.setMortgageBizType(ScfBasConstant.MORT_BIZ_TYPE_DELIVERY_OUT);//业务类型
			tblMortgageStockInfo.setQuantity(quantity);
			tblMortgageStockInfo.setConfirmPrice(price);//核定价
			tblMortgageStockInfo.setTotPrice(price.multiply(quantity));//总价
			tblMortgageStockInfo.setBussType(applyInfo.getSupplyChainPdId());
			tblMortgageStockInfo.setType(ScfBasConstant.STOR_DELI_BIZ_TYPE_DELIVERY);
			tblMortgageStockInfo.setSupplyChainPdId(applyInfo.getSupplyChainPdId());//产品类型
			tblMortgageStockInfo.setLastUpdTime(new Date());
			tblMortgageStockInfo.setPid(id);
			tblMortgageStockInfo.setId(null);
			bpbcmtgstockdtlservice.addBPbcMtgStockDtl(tblMortgageStockInfo);

		}
	}
	
	/**
	 * 根据质押合同查询保证金追加基本信息
	 * @param slaveContno
	 * @param addBailAmount
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年4月27日下午7:37:42
	 */
	@Override
	public AppendBailAmountVO getAddBailAmountBySlaveContno(String slaveContno,BigDecimal addBailAmount) throws ScubeBizException
	{
		BCrrGntyCon bCrrGntyCon = bcrrgntycondao.selectByPrimaryKey(slaveContno);
		AppendBailAmountVO vo = new AppendBailAmountVO();
		if(StringUtil.isEmpty(addBailAmount))
		{
			addBailAmount = null;
		}
		if(bCrrGntyCon!=null)
		{
			BCrmBaseInfo cust = bcrmbaseinfodao.selectById(bCrrGntyCon.getGutId());
			BeanUtils.copyProperties(bCrrGntyCon, vo);
			vo.setAddBailAmount(addBailAmount==null?BigDecimal.ZERO:addBailAmount);
			vo.setCustno(cust.getCustno());
			vo.setCustcd(cust.getCustcd());
			vo.setCname(cust.getCname());
			vo.setSlaveContno(slaveContno);
			vo.setSupplyChainPdId(bCrrGntyCon.getVidPrdId());
			vo.setProtocolNo(bCrrGntyCon.getPrtclNo());
		}
		return vo;
	}
	
	/**
	 * 根据借据号查询保证金追加基本信息
	 * @param debetNo
	 * @param addBailAmount
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年4月27日下午7:43:50
	 */
	@Override
	public AppendBailAmountVO getAddBailAmountByDebetNo(String debetNo,BigDecimal addBailAmount) throws ScubeBizException
	{
		AppendBailAmountVO vo = new AppendBailAmountVO();
//		Page pageQueryResult = SCFDAOUtils.getThreeCommonServiceDAO().getAddBailAmountByDebetNo(debetNo);
//		List list = pageQueryResult.getQueryResult();
//		List resultList = new ArrayList();
//		for(int i=0;i<list.size();i++){
//			AppendBailAmountVO vo = new AppendBailAmountVO();
//			Object[] obj = (Object[])list.get(i);
//			TblLnciBaseInfo lnciBaseInfo = (TblLnciBaseInfo)obj[0];
//			TblMutiProtBaseInfo baseInfo  = (TblMutiProtBaseInfo)obj[1];
//			CommonFunction.copyProperties(vo, lnciBaseInfo);
//			vo.setSupplyChainPdId(baseInfo.getProductId());
//			vo.setProtocolNo(baseInfo.getProtocolNo());
//			vo.setAddBailAmount(addBailAmount==null?BigDecimal.ZERO:new BigDecimal(addBailAmount));
//			TblMutiProtPartInfo partInfo = SCFDAOUtils.getTblMutiProtPartInfoDAO().findCoreorCustByProtocolNo(baseInfo.getProtocolNo(), ScfBasConstant.PROTOCOL_PART_ROLE_CREDIT);
//			vo.setCustcd(partInfo.getCustcd());
//			resultList.add(vo);
//		}
//		pageQueryResult.setQueryResult(resultList);
		return vo;
	}
	
	/**
	 * 根据申请编号查询冻结保证金信息
	 * @param appno
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年4月28日上午8:52:49
	 */
	@Override
	public Page getAddBailAmountListByAppno(String appno, Integer pageNo,Integer pageSize) throws ScubeBizException
	{
		Page pageQueryResult = bmrnappliacctinfoservice.getAddBailAmountListByAppno(appno, pageNo, pageSize);
		List<DebetListVO> list=new ArrayList<DebetListVO>();
		BLanLnciBase tblLnciBaseInfo = null;
		BPbcAppliBaseInfo tblAppliBaseInfo = null;
		if(pageQueryResult.getRecords()!=null&&pageQueryResult.getRecords().size()>0)
		{
			for(int i=0;i<pageQueryResult.getRecords().size();i++)
			{
				DebetListVO debetListVO = new DebetListVO();
				BLanLnciBaseAcctVo lnciBaseAcctVo = (BLanLnciBaseAcctVo) pageQueryResult.getRecords().get(i);
				tblLnciBaseInfo = new BLanLnciBase();
				BeanUtils.copyProperties(lnciBaseAcctVo, debetListVO);
				BeanUtils.copyProperties(lnciBaseAcctVo, tblLnciBaseInfo);
				debetListVO.setBailAccount(lnciBaseAcctVo.getBailAccountno());
				debetListVO.setAddBailAmount(StringUtil.isEmpty(lnciBaseAcctVo.getAddNewBailAmount())?BigDecimal.ZERO:lnciBaseAcctVo.getAddNewBailAmount());
				debetListVO.setRiskAmt(amountservice.getLnciRiskAmt(tblLnciBaseInfo));  //敞口余额;
				tblAppliBaseInfo = bpbcapplibaseinfoservice.findBPbcAppliBaseInfoByKey(tblLnciBaseInfo.getAppno());
				if(null!=tblAppliBaseInfo){
					debetListVO.setIncomeAppno(tblAppliBaseInfo.getIncomeAppno());  //出账流水号
				}
				if(StringUtil.isEmpty(debetListVO.getReceivableInt()))
				{
					debetListVO.setReceivableInt(BigDecimal.ZERO);
				}
				list.add(debetListVO);
			}
		}
		pageQueryResult.setRecords(list);
		return pageQueryResult;
	}
	
	/**
	 * 根据借据号查询借据信息
	 * @param deliveryQryVO
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年4月28日上午9:11:28
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Page getLnciBaseInfoByDebetNo(DeliveryQryVO deliveryQryVO) throws ScubeBizException
	{
		Page pageQueryResult = blanlncibaseservice.getLnciBaseInfoByDebetNo(deliveryQryVO.getBusinessNo(), deliveryQryVO.getPageIndex(), deliveryQryVO.getPageSize());
		List<com.huateng.scf.bas.lan.dao.model.BLanLnciBase> list = pageQueryResult.getRecords();
		List<DebetListVO> resultList=new ArrayList<DebetListVO>();
		DebetListVO debetListVO = null;
		com.huateng.scf.bas.lan.dao.model.BLanLnciBase tblLnciBaseInfo = null;
		BPbcAppliBaseInfo tblAppliBaseInfo = null;
		if(list!=null&&list.size()>0)
		{
			for(int i=0;i<list.size();i++)
			{
				debetListVO = new DebetListVO();
				tblLnciBaseInfo = (com.huateng.scf.bas.lan.dao.model.BLanLnciBase)list.get(i);
				BeanUtils.copyProperties(debetListVO, tblLnciBaseInfo);
				BLanLnciBase bLanLnciBase = new BLanLnciBase();
				BeanUtils.copyProperties(tblLnciBaseInfo, bLanLnciBase);
				debetListVO.setRiskAmt(amountservice.getLnciRiskAmt(bLanLnciBase));  //敞口余额
				//应收欠息
				BigDecimal receivableInt = tblLnciBaseInfo.getReceivableInt()==null?BigDecimal.ZERO:tblLnciBaseInfo.getReceivableInt();
				BigDecimal receivablePunishInt = tblLnciBaseInfo.getReceivablePunishInt()==null?BigDecimal.ZERO:tblLnciBaseInfo.getReceivablePunishInt();
				//催收欠息
				BigDecimal collectionInt = tblLnciBaseInfo.getCollectionInt()==null?BigDecimal.ZERO:tblLnciBaseInfo.getCollectionInt();
				BigDecimal	collectionPunishInt = tblLnciBaseInfo.getCollectionPunishInt()==null?BigDecimal.ZERO:tblLnciBaseInfo.getCollectionPunishInt();
				BigDecimal compoundInt = tblLnciBaseInfo.getCompoundInt()==null?BigDecimal.ZERO:tblLnciBaseInfo.getCompoundInt();
				//表内欠息
				BigDecimal tabIntAmt = receivableInt.add(receivablePunishInt);
				//表外欠息
				BigDecimal tabOutAmt = collectionInt.add(collectionPunishInt).add(compoundInt);

				debetListVO.setReceivableInt(tabIntAmt.add(tabOutAmt));
				tblAppliBaseInfo= bpbcapplibaseinfoservice.findBPbcAppliBaseInfoByKey(tblLnciBaseInfo.getAppno());
				if(null!=tblAppliBaseInfo){
					debetListVO.setIncomeAppno(tblAppliBaseInfo.getIncomeAppno()==null?"":tblAppliBaseInfo.getIncomeAppno());  //出账流水号
					debetListVO.setLoanAppno(tblAppliBaseInfo.getIncomeAppno()==null?"":tblAppliBaseInfo.getIncomeAppno());
				}
				resultList.add(debetListVO);
			}
		}
		pageQueryResult.setRecords(resultList);
		return pageQueryResult;
	}

	/**
	 * 根据质押合同查询借据信息
	 * @param deliveryQryVO
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年4月28日上午10:37:49
	 */
	@Override
	public Page getLnciBaseInfoByBusinessNo(DeliveryQryVO deliveryQryVO) throws ScubeBizException
	{
		Page pageQueryResult = blanlncibaseservice.getDebetList(deliveryQryVO);
		List<DebetListVO> list=new ArrayList<DebetListVO>();
		if(pageQueryResult.getRecords()!=null&&pageQueryResult.getRecords().size()>0)
		{
			for(int i=0;i<pageQueryResult.getRecords().size();i++)
			{
				com.huateng.scf.bas.lan.dao.model.BLanLnciBase tblLnciBaseInfo = 
						(com.huateng.scf.bas.lan.dao.model.BLanLnciBase) pageQueryResult.getRecords().get(i);
				DebetListVO debetListVO = new DebetListVO();
				BeanUtils.copyProperties(tblLnciBaseInfo, debetListVO);
				BLanLnciBase bLanLnciBase = new BLanLnciBase();
				
				BeanUtils.copyProperties(tblLnciBaseInfo, bLanLnciBase);
				debetListVO.setRiskAmt(amountservice.getLnciRiskAmt(bLanLnciBase));  //敞口余额;
				
				if(StringUtil.isEmpty(debetListVO.getReceivableInt()))
				{
					debetListVO.setReceivableInt(BigDecimal.ZERO);
				}
				if(StringUtil.isEmpty(debetListVO.getRiskAmt()))
				{
					debetListVO.setRiskAmt(BigDecimal.ZERO);
				}
				if(StringUtil.isEmpty(debetListVO.getAddBailAmount()))
				{
					debetListVO.setAddBailAmount(BigDecimal.ZERO);
				}
				list.add(debetListVO);
			}
		}
		pageQueryResult.setRecords(list);
		return pageQueryResult;
	}

	/**
	 * 根据协议号查询借据信息
	 * @param deliveryQryVO
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年4月28日上午10:38:45
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public Page getLnciBaseInfoByProtocolNo(DeliveryQryVO deliveryQryVO) throws ScubeBizException
	{
		Page pageQueryResult = blanlncibaseservice.getLnciBaseInfoByProtocolNo(deliveryQryVO.getProtocolNo(), deliveryQryVO.getPageIndex(), deliveryQryVO.getPageSize());
		List result = pageQueryResult.getRecords();
		List<DebetListVO> list=new ArrayList<DebetListVO>();
		if(result!=null&&result.size()>0)
		{
			for(int i=0;i<result.size();i++)
			{
				com.huateng.scf.bas.lan.dao.model.BLanLnciBase tblLnciBaseInfo = 
						(com.huateng.scf.bas.lan.dao.model.BLanLnciBase) result.get(i);
				DebetListVO debetListVO = new DebetListVO();
				BeanUtils.copyProperties(tblLnciBaseInfo, debetListVO);
				
				BLanLnciBase bLanLnciBase = new BLanLnciBase();
				BeanUtils.copyProperties(tblLnciBaseInfo, bLanLnciBase);
				debetListVO.setRiskAmt(amountservice.getLnciRiskAmt(bLanLnciBase));  //敞口余额;
				
				//应收欠息
				BigDecimal receivableInt = tblLnciBaseInfo.getReceivableInt()==null?BigDecimal.ZERO:tblLnciBaseInfo.getReceivableInt();
				BigDecimal receivablePunishInt = tblLnciBaseInfo.getReceivablePunishInt()==null?BigDecimal.ZERO:tblLnciBaseInfo.getReceivablePunishInt();
				//催收欠息
				BigDecimal collectionInt = tblLnciBaseInfo.getCollectionInt()==null?BigDecimal.ZERO:tblLnciBaseInfo.getCollectionInt();
				BigDecimal	collectionPunishInt = tblLnciBaseInfo.getCollectionPunishInt()==null?BigDecimal.ZERO:tblLnciBaseInfo.getCollectionPunishInt();
				BigDecimal compoundInt = tblLnciBaseInfo.getCompoundInt()==null?BigDecimal.ZERO:tblLnciBaseInfo.getCompoundInt();
				//表内欠息
				BigDecimal tabIntAmt = receivableInt.add(receivablePunishInt);
				//表外欠息
				BigDecimal tabOutAmt = collectionInt.add(collectionPunishInt).add(compoundInt);

				debetListVO.setReceivableInt(tabIntAmt.add(tabOutAmt));
				list.add(debetListVO);
			}
		}
		pageQueryResult.setRecords(list);
		return pageQueryResult;
	}
	
	/**
	 * 保证金冻结借据信息查询
	 * @param deliveryQryVO
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年4月28日上午10:10:48
	 */
	@Override
	public Page getDebetList(DeliveryQryVO deliveryQryVO) throws ScubeBizException
	{
		Page pageQueryResult = new Page();
		if(ScfBasConstant.BAIL_ADD_OP_TYPE_CHATTLE_DELIVERY.equals(deliveryQryVO.getOperationType())
				||ScfBasConstant.BAIL_ADD_OP_TYPE_BILLNORMAL_DELIVERY.equals(deliveryQryVO.getOperationType())){
			pageQueryResult=this.getLnciBaseInfoByBusinessNo(deliveryQryVO);
		}else if(ScfBasConstant.BAIL_ADD_OP_TYPE_ASSURE_DELIVERY.equals(deliveryQryVO.getOperationType())){
			pageQueryResult = this.getLnciBaseInfoByDebetNo(deliveryQryVO);
		}else if(ScfBasConstant.BAIL_ADD_OP_TYPE_BILLFIRST_DELIVERY.equals(deliveryQryVO.getOperationType())){
			pageQueryResult=this.getLnciBaseInfoByProtocolNo(deliveryQryVO);
		}else if(ScfBasConstant.BAIL_ADD_OP_TYPE_CARMORT_DELIVERY.equals(deliveryQryVO.getOperationType())||
				ScfBasConstant.BAIL_ADD_OP_TYPE_CARMORT_REPLACE.equals(deliveryQryVO.getOperationType()))
		{
			pageQueryResult=this.getLnciBaseInfoByBusinessNo(deliveryQryVO);
		}
		return pageQueryResult;
	}
	
	/**
	 * 提货信息申请表保存
	 * @param mortgageApplyVO
	 * @param insertList
	 * @param deleteList
	 * @param updateList
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年5月16日下午3:46:21
	 */
	@Override
	public String saveOrUpdateApplyMortgageInfo(MortgageApplyVO mortgageApplyVO,List<?> insertList,List<?> deleteList,List<?> updateList) 
			throws ScubeBizException
	{
		//提货申请
		String businessnoType = WorkflowConstant.APPLI_TYPE_DELIVERYAPPLI;
		String workApplyType = WorkflowConstant.PROCNAME_E_DELIVERYAPPLY;

		//获取基本信息
		String slaveContno = (String)mortgageApplyVO.getSlaveContno();
		String appno = (String)mortgageApplyVO.getAppno();
		String protocolNo = (String)mortgageApplyVO.getProtocolNo();


		//获取质押合同信息
		
		BCrrGntyCon tblContSlaveInfo = bcrrgntycondao.selectByPrimaryKey(slaveContno);
		if(tblContSlaveInfo==null)
		{
			throw new ScubeBizException("质押合同不存在");
		}
		mortgageApplyVO.setMastContno("");

		//获取客户号
		String custcd = tblContSlaveInfo.getGutId();
		mortgageApplyVO.setCustcd(custcd);

		//获取协议编号
		if(StringUtil.isEmpty(protocolNo)){
			protocolNo = tblContSlaveInfo.getPrtclNo();
		}
		mortgageApplyVO.setProtocolNo(protocolNo);

		//获取监管协议信息
		BCntMprotBaseInfo tblMutiProtBaseInfo = bcntmprotbaseinfoservice.findBCntMprotBaseInfoByKey(protocolNo);
		if (tblMutiProtBaseInfo == null)
		{
			throw new ScubeBizException("关联协议信息查询失败", RBcpErrorConstant.RECORD_NOT_EXIST);
		}

		//查协议的产品编号
		String  productId=tblMutiProtBaseInfo.getProductId();
		mortgageApplyVO.setProductId(productId);



		//获取监管公司信息以作监管货权校验
		BCntMprotPartInfo tblMutiProtPartInfo = bcntmprotpartinfoservice.findCustByProtocolNoAndRole(protocolNo, ScfBasConstant.PROTOCOL_PART_ROLE_MONI);

		if(tblMutiProtPartInfo==null||StringUtil.isEmpty(tblMutiProtPartInfo.getCustcd()))
		{
			throw new ScubeBizException("监管公司信息查询失败！", RBcpErrorConstant.ERROR_CODE_PARAM_NOT_EXIST);
		}

		//获取监管公司客户号
		String moniCustcd =tblMutiProtPartInfo.getCustcd();
		mortgageApplyVO.setMoniCustcd(moniCustcd);


		//校验敞口
		AmountVO amountVO=new AmountVO(productId,slaveContno);
		amountVO.setMidProductId(ScfBasConstant.PRODUCT_TYPE_CHATTLE);
		com.huateng.scf.bas.pbc.model.AmountVO amountVO2 = new com.huateng.scf.bas.pbc.model.AmountVO();
		BeanUtils.copyProperties(amountVO, amountVO2);
		BigDecimal amount =	amountservice.getDelivery(amountVO2);//可提货金额（动产）
		BigDecimal bailAmount = mortgageApplyVO.getBailAmount()==null?new BigDecimal(0):mortgageApplyVO.getBailAmount();
		BigDecimal tempBailAmount = bailAmount.multiply(new BigDecimal(100)).divide(mortgageApplyVO.getRation(), 10, BigDecimal.ROUND_HALF_UP);
	       
		//需要考虑增加本次追加的保证金金额
		amount = amount.add(tempBailAmount);    
	 	if(mortgageApplyVO.getDeliverValue()!=null&&amount!=null)
	 	{ 
	 		if(amount.subtract(mortgageApplyVO.getDeliverValue()).floatValue()>0)
	 		{
	       		
	       	}
	 		else
	 		{
	       		if(abs(mortgageApplyVO.getDeliverValue().subtract(amount).floatValue()) >=0.005 )
	       		{
	       			throw new ScubeBizException("提出'"+mortgageApplyVO.getDeliverValue()+"'价值的货物后，押品质押值加保证金及其等价物价值不能覆盖业务敞口！",
	       					RBcpErrorConstant.ERROR_CODE_DATA_INPUT_ERR);   
	       		}
	       	}
	 	}
	 	if(StringUtil.isEmpty(appno))
	 	{
			//保存提货申请基本信息
			appno = qualityapplyservice.saveQualityApplyInfo(mortgageApplyVO,businessnoType,workApplyType);
			//更新押品申请信息
			modifyDeliveryMortgageList(appno,insertList,deleteList,updateList);
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
			appno = qualityapplyservice.saveQualityApplyInfo(mortgageApplyVO,businessnoType,workApplyType);
			//更新押品申请信息
			modifyDeliveryMortgageList(appno,insertList,deleteList,updateList);
	 	}
		return appno;
	}
	
	/**
	 * 提货申请押品信息修改
	 * @param appno
	 * @param insertList
	 * @param deleteList
	 * @param updateList
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年5月16日下午3:44:54
	 */
	@Override
	public void modifyDeliveryMortgageList(String appno,List<?> insertList,List<?> deleteList,List<?> updateList) throws ScubeBizException
	{

		//查询申请基本信息
		BPbcAppliBaseInfo appBaseInfo = bpbcapplibaseinfoservice.findBPbcAppliBaseInfoByKey(appno);
		if(appBaseInfo==null)
		{
			throw new ScubeBizException("申请表记录不存在");
		}
		
		//保存追加申请押品信息
		List<BPbcAppliMtgInfo> list = bpbcapplimtginfoservice.findBPbcAppliMtgInfoByAppno(appno);
		if(list!=null&&list.size()>0)
		{
			for(BPbcAppliMtgInfo appliMtgInfo : list)
			
				bpbcapplimtginfoservice.deleteBPbcAppliMtgInfo(appliMtgInfo.getId());
		}
		for(int i = 0;i<insertList.size();i++)
		{
			MortgageApplyVO mortgageApplyVO = (MortgageApplyVO)insertList.get(i);

			//押品上锁
			adjustpriceservice.checkMortLockInfo(appno,mortgageApplyVO.getMortgageNo());

			mortgageApplyVO.setAppliMortBizType(ScfBasConstant.MORT_BIZ_TYPE_DELIVERY_OUT);
			BPbcMtgBaseInfo tblMortgageBaseInfo = bpbcmtgbaseinfoservice.findBPbcMtgBaseInfoByKey(mortgageApplyVO.getMortgageNo());
			mortgageApplyVO.setConfirmPrice(tblMortgageBaseInfo.getConfirmPrice());
			bpbcapplimtginfoservice.addAppMortgageVO(appBaseInfo, mortgageApplyVO);
		}
	}

	/**
	 * 判断冻结金额是否与借据金额一致
	 * @param amt
	 * @param appno
	 * @author 	mengjiajia
	 * @date 	2017年5月17日下午2:29:35
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public void checkAmtEqual(BigDecimal amt, String appno) {
		BigDecimal addBailAmount =amt;//本次追加保证金金额
		if(addBailAmount.compareTo(BigDecimal.ZERO)>0)
		{
			List accountList =bmrnappliacctinfoservice.findBMrnAppliAcctInfoByAppno(appno);
    		if(accountList!=null && accountList.size()>0){
    			BigDecimal totalAddBailAmount = BigDecimal.ZERO;
	        	for (int i = 0; i < accountList.size(); i++) {
	        		com.huateng.scf.bas.mrn.model.BMrnAppliAcctInfo bean = (com.huateng.scf.bas.mrn.model.BMrnAppliAcctInfo) accountList.get(i);
	        		BigDecimal bailAmount = bean.getBailAmount()==null?BigDecimal.ZERO:bean.getBailAmount();//冻结保证金列表
	        		totalAddBailAmount=totalAddBailAmount.add(bailAmount);
	    		}
	        	if(addBailAmount.compareTo(totalAddBailAmount)!=0){
	        		throw new ScubeBizException("追加冻结金额总金额必须等于本次追加保证金总额！",RBcpErrorConstant.ERROR_CODE_DATA_INPUT_ERR);
	        	}
    		}else{
    			throw new ScubeBizException("冻结保证金列表记录不能为空！",RBcpErrorConstant.ERROR_CODE_DATA_NOT_EQUAL);
    		}
    	}
	}
	
	/**
	 * 生成签发提货通知书
	 * @param appno
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年5月17日下午3:01:31
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void deliveryAppSignNotice(String appno)throws ScubeBizException
	{
		//查询基本申请信息表
		BPbcAppliBaseInfo tblAppliBaseInfo = bpbcapplibaseinfoservice.findBPbcAppliBaseInfoByKey(appno);
		if(tblAppliBaseInfo==null)
		{
			throw new ScubeBizException("申请信息查询失败！");
		}
	    //查询质押合同信息
		BCrrGntyCon tblContSlaveInfo = bcrrgntycondao.selectByPrimaryKey(tblAppliBaseInfo.getSlaveContno());
		if(tblContSlaveInfo==null)
		{
			throw new ScubeBizException("质押合同信息查询失败", RBcpErrorConstant.RECORD_NOT_EXIST);
		}
		com.huateng.scf.bas.crr.model.BCrrGntyCon bCrrGntyCon = 
				new com.huateng.scf.bas.crr.model.BCrrGntyCon();
		BeanUtils.copyProperties(tblContSlaveInfo, bCrrGntyCon);
		//协议查询
		BCntMprotBaseInfo tblMutiProtBaseInfo = bcntmprotbaseinfoservice.findBCntMprotBaseInfoByKey(tblAppliBaseInfo.getProtocolNo());
		if(tblMutiProtBaseInfo==null)
		{
			throw new ScubeBizException("协议信息查询失败", RBcpErrorConstant.RECORD_NOT_EXIST);
		}
	   //保存押品变更通知书
		List<?> noticeList = bntenoticebaseservice.getNoticeBaseInfoByAppno(appno);
		String id="";
		if(noticeList.size()==0){
			AppliMortgageBaseQryVO commonQueryVO = new AppliMortgageBaseQryVO();
			commonQueryVO.setAppno(appno);
			List<com.huateng.scf.bas.pbc.dao.model.BPbcAppliMtgInfo> applyMortgageList = bpbcapplimtginfoservice.getApplyMortgageList(commonQueryVO);
			String noticeNo = bSysSerialNoService.genSerialNo(ScfBasConstant.BUSSNO_TYPE_PLSY_NOTICE_NO);
			id = bntenoticebaseservice.addNoticeBaseInfo(tblAppliBaseInfo, bCrrGntyCon, tblMutiProtBaseInfo, ScfBasConstant.MORTGAGE_CHANGE_TYPE_RELESE, NoticeConstant.NOTICE_TYPE_22, noticeNo);
			bntenoticebaseservice.addNoticeMortgageInfo(id, applyMortgageList, ScfBasConstant.MORTGAGE_TYPE_IN);
		}
		else
		{
			BNteNoticeBase tblNoticeBaseInfo = (BNteNoticeBase)noticeList.get(0);
			List<BNteNoticeMtg> list = bntenoticemtgservice.getMortgageListByAppnoAndPid(appno,String.valueOf(tblNoticeBaseInfo.getId()));
//			SCFDAOUtils.getTblNoticeMortgageInfoDAO().getCurSession().flush();
//			SCFDAOUtils.getTblNoticeMortgageInfoDAO().getCurSession().clear();
			for (BNteNoticeMtg noticeMortgageInfo : list)
			{
				bntenoticemtgservice.deleteBNteNoticeMtg(noticeMortgageInfo.getId());
			}
			//通知书中的货物信息表
			AppliMortgageBaseQryVO commonQueryVO0 = new AppliMortgageBaseQryVO();
			commonQueryVO0.setAppno(appno);
			List<com.huateng.scf.bas.pbc.dao.model.BPbcAppliMtgInfo> applyMortgageList = bpbcapplimtginfoservice.getApplyMortgageList(commonQueryVO0);
			for (int i = 0; i < applyMortgageList.size(); i++)
			{
				com.huateng.scf.bas.pbc.dao.model.BPbcAppliMtgInfo appliMortgageBaseInfo = applyMortgageList.get(i);
				com.huateng.scf.bas.nte.model.BNteNoticeMtg bNteNoticeMtg = 
						new com.huateng.scf.bas.nte.model.BNteNoticeMtg();
				BeanUtils.copyProperties(appliMortgageBaseInfo, bNteNoticeMtg);
				bNteNoticeMtg.setMortgageType(ScfBasConstant.MORTGAGE_TYPE_IN);//货物类型 0：表示新入库。1:表示解除抵押，出库。
				bNteNoticeMtg.setPid(tblNoticeBaseInfo.getId());
				bNteNoticeMtg.setManufacturer(appliMortgageBaseInfo.getManufacturer());
				bNteNoticeMtg.setId(UUIDGeneratorUtil.generate());
				bntenoticemtgservice.addBNteNoticeMtg(bNteNoticeMtg);
			}
		}

	}
	
}
