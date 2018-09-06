package com.huateng.scf.bas.mrn.service.impl;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huateng.authority.common.ContextHolder;
import com.huateng.base.common.beans.Page;
import com.huateng.scf.adv.qry.model.ContBaseResultVO;
import com.huateng.scf.bas.bcp.dao.ISBcpAppliLowerPriceDAO;
import com.huateng.scf.bas.bcp.dao.model.SBcpAppliLowerPrice;
import com.huateng.scf.bas.bcp.dao.model.SBcpAppliLowerPriceExample;
import com.huateng.scf.bas.cnt.dao.IBCntMprotBaseInfoDAO;
import com.huateng.scf.bas.cnt.dao.IBCntMprotChgHisDAO;
import com.huateng.scf.bas.cnt.dao.IBCntMprotCmInfoDAO;
import com.huateng.scf.bas.cnt.dao.IBCntMprotPartInfoDAO;
import com.huateng.scf.bas.cnt.dao.ext.ExtIBCntMprotBaseInfoDAO;
import com.huateng.scf.bas.cnt.dao.model.BCntMprotBaseInfo;
import com.huateng.scf.bas.cnt.dao.model.BCntMprotChgHis;
import com.huateng.scf.bas.cnt.dao.model.BCntMprotCmInfo;
import com.huateng.scf.bas.cnt.dao.model.BCntMprotPartInfo;
import com.huateng.scf.bas.cnt.model.MastContQryVO;
import com.huateng.scf.bas.cnt.model.MonitorProtocolVO;
import com.huateng.scf.bas.cnt.service.IBCntDebtInfoService;
import com.huateng.scf.bas.cnt.service.IBCntMprotPartInfoService;
import com.huateng.scf.bas.common.constant.ScfBasConstant;
import com.huateng.scf.bas.common.model.DeliveryApplyQryVO;
import com.huateng.scf.bas.common.service.ICustomerService;
import com.huateng.scf.bas.common.service.IProductService;
import com.huateng.scf.bas.common.util.ScfDateUtil;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.common.util.UUIDGeneratorUtil;
import com.huateng.scf.bas.crm.dao.IBCrmBaseInfoDAO;
import com.huateng.scf.bas.crm.dao.model.BCrmBaseInfo;
import com.huateng.scf.bas.crr.model.BCrrGntyCon;
import com.huateng.scf.bas.crr.model.BCrrLnCon;
import com.huateng.scf.bas.crr.service.IBCrrGntyConService;
import com.huateng.scf.bas.crr.service.IBCrrLnConService;
import com.huateng.scf.bas.icr.dao.IBIcrDtlDAO;
import com.huateng.scf.bas.icr.dao.IBIcrInfoDAO;
import com.huateng.scf.bas.icr.model.BIcrInfo;
import com.huateng.scf.bas.icr.model.CreditInterParamBean;
import com.huateng.scf.bas.icr.model.CreditQryVO;
import com.huateng.scf.bas.icr.service.IBIcrDtlService;
import com.huateng.scf.bas.icr.service.IBIcrInfoService;
import com.huateng.scf.bas.lan.dao.IBLanAppliLnciBaseDAO;
import com.huateng.scf.bas.lan.dao.IBLanLnciBaseDAO;
import com.huateng.scf.bas.lan.model.BLanLnciBase;
import com.huateng.scf.bas.lan.model.vo.ContSlaveQryVO;
import com.huateng.scf.bas.lan.model.vo.ContSlaveResultVO;
import com.huateng.scf.bas.lan.service.IBLanLnciBaseService;
import com.huateng.scf.bas.mrn.model.BMrnAppliAcctInfo;
import com.huateng.scf.bas.mrn.service.IBMrnAcctBussInfoService;
import com.huateng.scf.bas.mrn.service.IBMrnAppliAcctInfoService;
import com.huateng.scf.bas.mrn.service.IContractService;
import com.huateng.scf.bas.mrn.vo.CashEqualValueContractVO;
import com.huateng.scf.bas.mrn.vo.OldCommonQueryVO;
import com.huateng.scf.bas.mrn.vo.ProtocolQryVO;
import com.huateng.scf.bas.pbc.dao.IBPbcAppliBaseInfoDAO;
import com.huateng.scf.bas.pbc.dao.IBPbcAppliMtgInfoDAO;
import com.huateng.scf.bas.pbc.dao.IBPbcMtgBaseInfoDAO;
import com.huateng.scf.bas.pbc.dao.model.BPbcAppliBaseInfo;
import com.huateng.scf.bas.pbc.dao.model.BPbcAppliBaseInfoExample;
import com.huateng.scf.bas.pbc.dao.model.BPbcAppliMtgInfo;
import com.huateng.scf.bas.pbc.dao.model.BPbcAppliMtgInfoExample;
import com.huateng.scf.bas.pbc.dao.model.BPbcMtgBaseInfo;
import com.huateng.scf.bas.pbc.dao.model.BPbcMtgBaseInfoExample;
import com.huateng.scf.bas.pbc.model.AmountVO;
import com.huateng.scf.bas.pbc.service.IAmountService;
import com.huateng.scf.bas.pbc.service.IBPbcAppliBaseInfoService;
import com.huateng.scf.bas.pbc.service.IBPbcMtgBaseInfoService;
import com.huateng.scf.bas.prd.dao.IBPrdInfoDAO;
import com.huateng.scf.bas.prd.dao.IBPrdMortDAO;
import com.huateng.scf.bas.prd.dao.model.BPrdInfo;
import com.huateng.scf.bas.prd.dao.model.BPrdMort;
import com.huateng.scf.bas.prd.service.IBPrdInfoService;
import com.huateng.scf.bas.sys.constant.BSysConstant;
import com.huateng.scf.bas.sys.service.IBSysSerialNoService;
import com.huateng.scf.rec.bcp.constant.RBcpErrorConstant;
import com.huateng.scf.rec.bcp.model.DebtCommonQryVO;
import com.huateng.scf.rec.bcp.model.RBcpAppliBussDtl;
import com.huateng.scf.rec.bcp.service.IRBcpAppliBussDtlService;
import com.huateng.scf.sto.dmp.service.ISBcpAppliLowerPriceService;
import com.huateng.scf.sto.nwr.dao.ext.ExtSBcpNwrDAO;
import com.huateng.scf.sto.nwr.vo.PledgeContractVO;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * 
 * <p>
 * </p>
 *
 * @author mengjiajia
 * @date 2017年2月20日下午2:31:01
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 *            <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2017年2月20日下午2:31:01	     新增
 *
 *            </pre>
 */
@SuppressWarnings("deprecation")
@ScubeService
@Service("ContractServiceImpl")
public class ContractServiceImpl implements IContractService {

	private final Logger log = LoggerFactory.getLogger(getClass());

	@Resource(name = "BLanLnciBaseServiceImpl")
	IBLanLnciBaseService blanlncibaseservice;

	@Resource(name = "RBcpAppliBussDtlServiceImpl")
	IRBcpAppliBussDtlService rbcpapplibussdtlservice;

	@Resource(name = "BMrnAppliAcctInfoServiceImpl")
	IBMrnAppliAcctInfoService bmrnappliacctinfoservice;

	@Resource(name = "BCntDebtInfoServiceImpl")
	IBCntDebtInfoService bcntdebtinfoservice;

	@Resource(name = "BCrrLnConServiceImpl")
	IBCrrLnConService bcrrlnconservice;

	@Resource(name = "BMrnAcctBussInfoServiceImpl")
	IBMrnAcctBussInfoService bmrnacctbussinfoservice;

	@Resource(name = "BCntMprotPartInfoServiceImpl")
	IBCntMprotPartInfoService bcntmprotpartinfoservice;

	@Resource(name = "BCrrGntyConServiceImpl")
	IBCrrGntyConService bcrrgntyconservice;

	@Resource(name = "BPrdInfoDAO")
	IBPrdInfoDAO bprdinfodao;

	@Resource(name = "BPrdInfoServiceImpl")
	IBPrdInfoService bprdinfoservice;

	@Resource(name = "ExtSBcpNwrDAO")
	ExtSBcpNwrDAO extsbcpnwrdao;

	@Resource(name = "CustomerServiceImpl")
	ICustomerService customerservice;

	@Resource(name = "ExtBCntMprotBaseInfoDAO")
	ExtIBCntMprotBaseInfoDAO extbcntmprotbaseinfodao;

	@Resource(name = "IBPrdMortDAO")
	IBPrdMortDAO bprdmortdao;

	@Resource(name = "BPbcMtgBaseInfoServiceImpl")
	IBPbcMtgBaseInfoService bpbcmtgbaseinfoservice;

	@Resource(name = "AmountServiceImpl")
	IAmountService amountservice;

	@Resource(name = "IBCrmBaseInfoDAO")
	IBCrmBaseInfoDAO bcrmbaseinfodao;

	@Resource(name = "BPbcAppliBaseInfoDAO")
	IBPbcAppliBaseInfoDAO bPbcAppliBaseInfoDAO;
	
	@Resource(name = "BPbcAppliBaseInfoServiceImpl")
	IBPbcAppliBaseInfoService bpbcapplibaseinfoservice;
	
	@Resource(name = "ProductServiceImpl")
	IProductService productServiceImpl;
	
	@Resource(name = "BCntMprotBaseInfoDAO")
	IBCntMprotBaseInfoDAO iBCntMprotBaseInfoDAO;

	@Resource(name = "BSysSerialNoServiceImpl")
	private IBSysSerialNoService bSysSerialNoService;// 流水号生成服务
	
	@Resource(name = "BCntMprotCmInfoDAO")
	IBCntMprotCmInfoDAO bCntMprotCmInfoDAO;
	
	@Resource(name = "BCntMprotPartInfoDAO")
	IBCntMprotPartInfoDAO bCntMprotPartInfoDAO;
	
	@Resource(name = "BCntMprotChgHisDAO")
	IBCntMprotChgHisDAO bCntMprotChgHisDAO;
	
	@Resource(name = "BLanLnciBaseDAO")
	IBLanLnciBaseDAO bLanLnciBaseDAO;
	
	@Resource(name = "BIcrInfoDAO")
	IBIcrInfoDAO bIcrInfoDAO;
	
	@Resource(name = "BIcrInfoServiceImpl")
	IBIcrInfoService bIcrInfoService;
	
	@Resource(name = "BIcrDtlDAO")
	IBIcrDtlDAO bIcrDtlDAO;
	
	@Resource(name = "BIcrDtlServiceImpl")
	IBIcrDtlService bIcrDtlService;
	
	@Resource(name = "BCrrGntyConServiceImpl")
	IBCrrGntyConService bCrrGntyConService;
	
	@Resource(name = "SBcpAppliLowerPriceDAO")
	ISBcpAppliLowerPriceDAO sBcpAppliLowerPriceDAO;
	
	@Resource(name = "SBcpAppliLowerPriceServiceImpl")
	ISBcpAppliLowerPriceService sBcpAppliLowerPriceService;
	
	@Resource(name = "BPbcAppliMtgInfoDAO")
	IBPbcAppliMtgInfoDAO bPbcAppliMtgInfoDAO;
	
	@Resource(name = "BPbcMtgBaseInfoDAO")
	IBPbcMtgBaseInfoDAO bPbcMtgBaseInfoDAO;
	
	@Resource(name = "BLanAppliLnciBaseDAO")
	IBLanAppliLnciBaseDAO bLanAppliLnciBaseDAO;

	/**
	 * @Description: 现金等价物申请借据信息查询 @author zhonghuabin @Created
	 * 2013-10-31下午3:58:18 @param appno @param pageIndex @param
	 * pageSize @return @throws
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List getCashEqualValueWriteLnciInfo(String appno, String debetNo, int pageIndex, int pageSize) throws ScubeBizException {
		log.debug("appno:" + appno + ",debetNo:" + debetNo);
		// Page pageQueryResult = new Page();
		List returnList = new ArrayList();
		if (!StringUtil.isEmpty(appno) && StringUtil.isEmpty(debetNo)) {
			List<RBcpAppliBussDtl> retList = getCashEqualValueWriteLnciInfo(appno, pageIndex, pageSize);
			if (retList != null && retList.size() > 0) {
				for (int i = 0; i < retList.size(); i++) {
					RBcpAppliBussDtl lncibaseinfo = (RBcpAppliBussDtl) retList.get(i);
					// TblAppliCustAccountInfo tblAppliCustAccountInfo =
					// (TblAppliCustAccountInfo)obj[1];
					CashEqualValueContractVO contractVO = new CashEqualValueContractVO();
					BigDecimal openAmt = BigDecimal.ZERO;
					if (!StringUtil.isEmpty(lncibaseinfo.getDebetNo())) {
						BLanLnciBase lnciInfo = blanlncibaseservice.findBLanLnciBaseByKey(lncibaseinfo.getDebetNo());
						if (null != lnciInfo) {
							BeanUtils.copyProperties(lnciInfo, contractVO);
							openAmt = (lnciInfo.getLnciBal() == null ? BigDecimal.ZERO : lnciInfo.getLnciBal())
									.subtract(lnciInfo.getBailAmount() == null ? BigDecimal.ZERO : lnciInfo.getBailAmount())
									.subtract(lnciInfo.getAddBailAmount() == null ? BigDecimal.ZERO : lnciInfo.getAddBailAmount())
									.subtract(lnciInfo.getInitCashEqtAmt() == null ? BigDecimal.ZERO : lnciInfo.getInitCashEqtAmt())
									.subtract(lnciInfo.getAddCashEqtAmt() == null ? BigDecimal.ZERO : lnciInfo.getAddCashEqtAmt());
							if (openAmt.compareTo(BigDecimal.ZERO) < 0) {
								openAmt = BigDecimal.ZERO;
							}
							contractVO.setAppno(lncibaseinfo.getAppno());
							contractVO.setLnciRiskBal(openAmt);

							contractVO.setAddCashEqtAmt(lncibaseinfo.getAddBailAmount());
						}
					}
					// contractVO.setAfterAddBailAmount(tblAppliCustAccountInfo.getAmount());

					// contractVO.setToTCashEqtAmt((lncibaseinfo.getInitCashEqtAmt()
					// == null ? BigDecimal.ZERO :
					// lncibaseinfo.getInitCashEqtAmt())
					// .add(lncibaseinfo.getAddCashEqtAmt() == null ?
					// BigDecimal.ZERO : lncibaseinfo.getAddCashEqtAmt()));

					// contractVO.setLnciRiskBal((lncibaseinfo.getLnciBal() ==
					// null ? BigDecimal.ZERO : lncibaseinfo.getLnciBal())
					// .subtract(lncibaseinfo.getBailAmount() == null ?
					// BigDecimal.ZERO : lncibaseinfo.getBailAmount())
					// .subtract(lncibaseinfo.getAddBailAmount() == null ?
					// BigDecimal.ZERO : lncibaseinfo.getAddBailAmount())
					// .subtract(contractVO.getToTCashEqtAmt() == null ?
					// BigDecimal.ZERO : contractVO.getToTCashEqtAmt()));
					// contractVO.setAfterLnciRiskBal((lnciInfo.getLnciAmt() ==
					// null ? BigDecimal.ZERO : lnciInfo.getLnciAmt())
					// .subtract(lnciInfo.getBailAmount() == null ?
					// BigDecimal.ZERO : lnciInfo.getBailAmount())
					// .subtract(lnciInfo.getAddBailAmount() == null ?
					// BigDecimal.ZERO : lnciInfo.getAddBailAmount())
					// .subtract(contractVO.getAfterAddBailAmount() == null ?
					// BigDecimal.ZERO : contractVO.getAfterAddBailAmount()));
					if (!StringUtil.isEmpty(contractVO.getAppno())) {
						contractVO.setSelect(true);
					}

					returnList.add(contractVO);
				}
				// pageQueryResult.setRecords(returnList);
			}
		}
		if (!StringUtil.isEmpty(debetNo)) {
			List<BLanLnciBase> retList = blanlncibaseservice.queryLnciBaseInfoByDebetNo(debetNo, pageIndex, pageSize);
			if (retList != null && retList.size() > 0) {
				// List returnList = new ArrayList();
				for (int i = 0; i < retList.size(); i++) {
					BLanLnciBase lncibaseinfo = (BLanLnciBase) retList.get(i);
					BMrnAppliAcctInfo tblAppliCustAccountInfo = bmrnappliacctinfoservice.getTblAliCustAccInfoByAppnoAndDebetNo(appno,
							lncibaseinfo.getDebetNo());
					CashEqualValueContractVO contractVO = new CashEqualValueContractVO();
					BeanUtils.copyProperties(lncibaseinfo, contractVO);
					contractVO.setAfterAddBailAmount(tblAppliCustAccountInfo.getAmount());

					contractVO.setToTCashEqtAmt((lncibaseinfo.getInitCashEqtAmt() == null ? new BigDecimal(0) : lncibaseinfo.getInitCashEqtAmt())
							.add(lncibaseinfo.getAddCashEqtAmt() == null ? new BigDecimal(0) : lncibaseinfo.getAddCashEqtAmt()));

					contractVO.setLnciRiskBal((lncibaseinfo.getLnciBal() == null ? new BigDecimal(0) : lncibaseinfo.getLnciBal())
							.subtract(lncibaseinfo.getBailAmount() == null ? new BigDecimal(0) : lncibaseinfo.getBailAmount())
							.subtract(lncibaseinfo.getAddBailAmount() == null ? new BigDecimal(0) : lncibaseinfo.getAddBailAmount())
							.subtract(contractVO.getToTCashEqtAmt() == null ? new BigDecimal(0) : contractVO.getToTCashEqtAmt()));

					contractVO.setAfterLnciRiskBal((lncibaseinfo.getLnciBal() == null ? new BigDecimal(0) : lncibaseinfo.getLnciBal())
							.subtract(lncibaseinfo.getBailAmount() == null ? new BigDecimal(0) : lncibaseinfo.getBailAmount())
							.subtract(lncibaseinfo.getAddBailAmount() == null ? new BigDecimal(0) : lncibaseinfo.getAddBailAmount())
							.subtract(contractVO.getAfterAddBailAmount() == null ? new BigDecimal(0) : contractVO.getAfterAddBailAmount()));
					returnList.add(contractVO);
				}
				// pageQueryResult.setRecords(returnList);
			}
		}
		return returnList;
	}

	/**
	 *
	 * @Description: 查询信贷合同下借据 not locked @author @Created
	 * 2014年2月21日下午4:04:48 @param mastContno @return @throws
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List getCashEqualValueLnciByMastContno(String mastContno) throws ScubeBizException {
		List list = blanlncibaseservice.getLnciBaseInfo(null, null, mastContno, null);
		List result = new ArrayList();
		CashEqualValueContractVO lnciVO = null;
		if (null != list) {
			Iterator ite = list.iterator();
			while (ite.hasNext()) {
				com.huateng.scf.bas.lan.dao.model.BLanLnciBase lnci = (com.huateng.scf.bas.lan.dao.model.BLanLnciBase) ite.next();
				lnciVO = new CashEqualValueContractVO();
				BeanUtils.copyProperties(lnci, lnciVO);
				lnciVO.setAppno(null);
				BigDecimal openAmt = BigDecimal.ZERO;
				if (null != lnci) {
					openAmt = (lnci.getLnciBal() == null ? BigDecimal.ZERO : lnci.getLnciBal())
							.subtract(lnci.getBailAmount() == null ? BigDecimal.ZERO : lnci.getBailAmount())
							.subtract(lnci.getAddBailAmount() == null ? BigDecimal.ZERO : lnci.getAddBailAmount())
							.subtract(lnci.getInitCashEqtAmt() == null ? BigDecimal.ZERO : lnci.getInitCashEqtAmt())
							.subtract(lnci.getAddCashEqtAmt() == null ? BigDecimal.ZERO : lnci.getAddCashEqtAmt());
					if (openAmt.compareTo(BigDecimal.ZERO) < 0) {
						openAmt = BigDecimal.ZERO;
					}
					lnciVO.setLnciRiskBal(openAmt);
					lnciVO.setAddCashEqtAmt(BigDecimal.ZERO);
				}
				result.add(lnciVO);
			}
		}
		return result;
	}

	/**
	 * @Description: 现金等价物申请借据信息查询 @author zhonghuabin @Created
	 * 2013-10-31下午4:08:05 @param appno @param pageIndex @param
	 * pageSize @return @throws
	 */
	@SuppressWarnings("rawtypes")
	public List getCashEqualValueWriteLnciInfo(String appno, int pageIndex, int pageSize) throws ScubeBizException {
		RBcpAppliBussDtl rBcpAppliBussDtl = new RBcpAppliBussDtl();
		rBcpAppliBussDtl.setAppno(appno);
		List list = rbcpapplibussdtlservice.findRBcpAppliBussDtlByAppno(rBcpAppliBussDtl);
		return list;
	}

	/**
	 * @Description: 根据指定条件查询保理合同信息列表
	 * @author mengjiajia
	 * @Created 2013-8-1下午8:40:06
	 * @param commonQueryVO
	 * @return
	 * @throws
	 * 
	 * 			B_CNT_DEBT_INFO
	 */
	@Override
	public Page getTblContDebtInfoList(DebtCommonQryVO commonQueryVO) throws ScubeBizException {
		return bcntdebtinfoservice.getTblContDebtInfoList(commonQueryVO);
	}

	/**
	 *
	 * @Description:查询主合同 @author mengjiajia @Created 2012-11-8下午03:35:08 @param
	 * commonQueryVO @return @throws
	 */
	// 修改进入模式后可省略
	// public Page getContBaseInfoListByParam(MastContQryVO mastContQryVO)
	// throws ScubeBizException{
	// Page pageQueryResult =
	// bcrrlnconservice.getContBaseInfoListByParam(mastContQryVO);
	// return pageQueryResult;
	// }

	/**
	 * @Description: 查询全部合同全部借据 @author mengjiajia @Created
	 * 2012-11-12下午05:02:28 @param commonQueryVO @return @throws
	 */
	@Override
	public Page getLnciBaseInfoWriteByParamGetter(OldCommonQueryVO commonQueryVO) throws ScubeBizException {
		Page page = blanlncibaseservice.getLnciBaseInfoByWriteParamGetter(commonQueryVO);
		return page;
	}

	@Override
	public Page getAppliLnciBaseInfo(OldCommonQueryVO commonQueryVO) throws ScubeBizException {
		Page page = blanlncibaseservice.getAppliLnciBaseInfo(commonQueryVO);
		return page;
	}

	/**
	 * DESCRIPTION:获取有效的借据
	 * 
	 * @author mengjiajia
	 * @date 2012-5-18 getLnciBaseInfoByParamGetter 方法
	 * @param commonQueryVO
	 * @return
	 * @throws ScubeBizException
	 */
	@Override
	public Page getLnciBaseInfoByParamGetter(OldCommonQueryVO commonQueryVO) throws ScubeBizException {
		Page page = blanlncibaseservice.getLnciBaseInfoByParamGetter(commonQueryVO);
		return page;
	}

	/**
	 * DESCRIPTION:获取现金等价物
	 * 
	 * @author mengjiajia
	 * @date 2012-5-18 getBillCustAccountInfoByParam 方法
	 * @param commonQueryVO
	 * @return
	 * @throws ScubeBizException
	 */
	@Override
	public Page getBillCustAccountInfoByParam(OldCommonQueryVO commonQueryVO) throws ScubeBizException {
		Page page = bmrnacctbussinfoservice.getBillCustAccountInfoByParam(commonQueryVO);
		return page;
	}

	/**
	 * DESCRIPTION:现金等价物解押审批--获取 现金等价物信息
	 * 
	 * @author mengjiajia
	 * @date 2012-5-19 getBillCustAccountInfoApproveByParam 方法
	 * @param commonQueryVO
	 * @return
	 * @throws ScubeBizException
	 */
	@Override
	public Page getBillCustAccountInfoApproveByParam(OldCommonQueryVO commonQueryVO) throws ScubeBizException {
		Page page = bmrnappliacctinfoservice.getBillCustAccountInfoApprove(commonQueryVO);
		return page;
	}

	/**
	 *
	 * 编辑 getMutiProtPartInfoByPara 方法的文档注释
	 * 
	 * @param commonQueryVO
	 * @return
	 * @throws ScubeBizException
	 */
	@Override
	public Page getMutiProtPartInfoByPara(DeliveryApplyQryVO commonQueryVO) throws ScubeBizException {
		Page PageQu = bcntmprotpartinfoservice.getMutiProtPartInfoByPara(commonQueryVO);
		return PageQu;
	}

	/**
	 *
	 * @Description: 获取合同信息
	 * @author mengjiajia
	 * @Created 2012-11-7上午09:54:41
	 * @param commonQueryVO
	 * @return
	 * @throws ScubeBizException
	 */
	@Override
	public Page getContSlaveBaseInfo(MastContQryVO mastContQryVO) throws ScubeBizException {
		Page page = bcrrgntyconservice.getContSlaveBaseInfo(mastContQryVO);
		return page;
	}

	/**
	 * 查询质押合同信息
	 * 
	 * @param slaveContno
	 * @return
	 * @throws ScubeBizException
	 * @author mengjiajia
	 * @date 2017年4月13日下午7:44:09
	 */
	@Override
	public BCrrGntyCon getTblContSlaveInfo(String slaveContno) throws ScubeBizException {
		BCrrGntyCon contSlaveInfo = bcrrgntyconservice.findBCrrGntyConByConId(slaveContno);
		if (contSlaveInfo == null)
			throw new ScubeBizException("合同编号为【" + slaveContno + "】的担保合同记录丢失,无法更新！", RBcpErrorConstant.RECORD_NOT_EXIST);
		return contSlaveInfo;
	}

	/**
	 * 通过productId查找产品记录，返回String
	 * 
	 * @param parentId
	 * @return
	 * @throws ScubeBizException
	 * @author mengjiajia
	 * @date 2017年4月14日下午1:56:37
	 */
	@Override
	public String getProductByParentId(String parentId) throws ScubeBizException {
		return bprdinfoservice.getProductByParentId(parentId);
	}

	/**
	 * 待选合同列表
	 * 
	 * @param pledgeContractVO
	 * @return
	 * @throws ScubeBizException
	 * @author mengjiajia
	 * @date 2017年4月14日下午2:10:44
	 */
	@Override
	public Page getAppContInfoBySupplyChainPdId(PledgeContractVO pledgeContractVO) throws ScubeBizException {
		HashMap<String, Object> omap = new HashMap<String, Object>();
		List<String> supplyChainPdIdList = new ArrayList<String>();
		if (!StringUtil.isEmpty(pledgeContractVO.getSupplyChainPdId())) {
			String[] scpids = pledgeContractVO.getSupplyChainPdId().split("\\,");
			if (scpids.length > 1) {
				for (String supplyChainPdId : scpids) {
					if (!StringUtil.isEmpty(supplyChainPdId)) {
						supplyChainPdIdList.add(supplyChainPdId);
					}
				}
			} else {
				omap.put("supplyChainPdId", pledgeContractVO.getSupplyChainPdId());
			}
		}
		if (supplyChainPdIdList.size() > 0) {
			omap.put("supplyChainPdIdList", supplyChainPdIdList);
		}
		if (!StringUtil.isEmpty(pledgeContractVO.getSlaveContno())) { // 质押合同号
			omap.put("slaveContno", pledgeContractVO.getSlaveContno());
		}
		if (!StringUtil.isEmpty(pledgeContractVO.getMastContno())) { // 主合同号
			omap.put("mastContno", pledgeContractVO.getMastContno());
		}
		if (!StringUtil.isEmpty(pledgeContractVO.getCustcd())) { // 客户号
			omap.put("custcd", pledgeContractVO.getCustcd());
		}
		if (!StringUtil.isEmpty(pledgeContractVO.getMoniOfCustcd())) { // 监管公司客户号
			omap.put("planMoniEnt", pledgeContractVO.getMoniOfCustcd());
		}

		int total = extsbcpnwrdao.countAppContInfoBySupplyChainPdId(omap);
		Page pageQueryResult = new Page(pledgeContractVO.getPageSize(), pledgeContractVO.getPageIndex(), total);
		pageQueryResult.setRecords(extsbcpnwrdao.getAppContInfoBySupplyChainPdId(omap, pageQueryResult));
		return pageQueryResult;
	}

	/**
	 * 通过主合同编号查询主合同信息
	 * 
	 * @param mastContno
	 * @return
	 * @throws ScubeBizException
	 * @author mengjiajia
	 * @date 2017年4月18日上午9:27:34
	 */
	@Override
	public BCrrLnCon getTblContBaseInfo(String mastContno) throws ScubeBizException {
		BCrrLnCon contBaseInfo = bcrrlnconservice.findBCrrLnConByAppId(mastContno); // 目标对象
		if (contBaseInfo == null)
			throw new ScubeBizException("合同编号为【" + contBaseInfo + "】的合同记录丢失！", RBcpErrorConstant.RECORD_NOT_EXIST);
		return contBaseInfo;
	}

	/**
	 * 根据抵/质押合同号，查询监管公司信息
	 * 
	 * @param slaveContno
	 * @return
	 * @throws ScubeBizException
	 * @author mengjiajia
	 * @date 2017年4月18日上午10:30:40
	 */
	@Override
	public Page getMutiProtPartInfo(String slaveContno) throws ScubeBizException {
		Page pageQueryResult = null;
		pageQueryResult = bcntmprotpartinfoservice.getMutiProtPartInfo(slaveContno);
		return pageQueryResult;
	}

	/**
	 * 监管协议获取
	 * 
	 * @param protocolQryVO
	 * @return
	 * @throws ScubeBizException
	 * @author mengjiajia
	 * @date 2017年4月21日下午1:54:13
	 */
	@SuppressWarnings({ "rawtypes" })
	@Override
	public Page getMonitorProtocolQuery(ProtocolQryVO protocolQryVO) throws ScubeBizException {
		HashMap<String, Object> omap = new HashMap<String, Object>();
		if (!StringUtil.isEmpty(protocolQryVO.getProtocolNo())) {
			omap.put("protocolNo", protocolQryVO.getProtocolNo());
		}

		if (!StringUtil.isEmpty(protocolQryVO.getOtherProtocolNo_Q())) {
			omap.put("otherprotocolNo", protocolQryVO.getOtherProtocolNo_Q());
		}

		if (!StringUtil.isEmpty(protocolQryVO.getProtocolType_Q())) {
			omap.put("protocolType", protocolQryVO.getProtocolType_Q());
		}

		if (!StringUtil.isEmpty(protocolQryVO.getProtocolCode())) {
			omap.put("protocolCode", protocolQryVO.getProtocolCode());
		}

		if (!StringUtil.isEmpty(protocolQryVO.getProductId_Q())) {
			omap.put("productId", "'" + protocolQryVO.getProductId_Q() + "'");
		}
		if (!StringUtil.isEmpty(protocolQryVO.getSupplyChainPdId_Q())) {
			omap.put("supplyChainPdId", protocolQryVO.getSupplyChainPdId_Q());
		}
		if (!StringUtil.isEmpty(protocolQryVO.getStartDate1_Q())) { // 开始日期
			omap.put("startDate1", protocolQryVO.getStartDate1_Q());
		}
		if (!StringUtil.isEmpty(protocolQryVO.getStartDate2_Q())) { // 发票登记日期
			omap.put("startDate2", protocolQryVO.getStartDate2_Q());
		}
		if (!StringUtil.isEmpty(protocolQryVO.getState_Q())) {
			omap.put("state", protocolQryVO.getState_Q());
		}

		omap.put("role", ScfBasConstant.PROTOCOL_PART_ROLE_BANK);
		omap.put("role2", ScfBasConstant.PROTOCOL_PART_ROLE_CREDIT);
		omap.put("role3", ScfBasConstant.PROTOCOL_PART_ROLE_MONI);
		// 出质人
		if (!StringUtil.isEmpty(protocolQryVO.getCustName_Q())) {
			omap.put("custname", protocolQryVO.getCustName_Q());
		}
		// 监管公司
		if (!StringUtil.isEmpty(protocolQryVO.getCname())) {
			omap.put("cname", protocolQryVO.getCname());
		}

		if (!StringUtil.isEmpty(protocolQryVO.getMoniCustcd_Q())) {
			omap.put("custcd", protocolQryVO.getMoniCustcd_Q());
		}
		List<String> custcdList = new ArrayList<String>();
		// 监管协议管理时，合同对所有管理客户可见 add by xiaolong.xiong 2013-04-18
		if (ScfBasConstant.QUERY_TYPE_MAG_ALL.equals(protocolQryVO.getFlag())) {
			custcdList = customerservice.getCustcdsQueryCondition("mppi_2.custcd", ScfBasConstant.QUERY_TYPE_MAG_ALL,
					ContextHolder.getUserInfo().getTlrNo());
		}
		if (custcdList.size() > 0) {
			omap.put("custcdList", custcdList);
		}

		// 增加协议隶属客户经理条件限制 add by xiaolong.xiong 2012-11-05
		if (ScfBasConstant.QUERY_TYPE_MAG_ALL_MAS.equals(protocolQryVO.getFlag())) {
			omap.put("mgrno", ContextHolder.getUserInfo().getTlrNo());
		}

		// 增加协议隶属机构条件限制 add by xiaolong.xiong 2012-11-07
		if (ScfBasConstant.QUERY_TYPE_ALL.equals(protocolQryVO.getFlag())) {
			omap.put("parentBrcode", ContextHolder.getOrgInfo().getBrNo());
			omap.put("affiliationType", ScfBasConstant.BCTL_AFFILIATION_BELONG);
		}

		int total = extbcntmprotbaseinfodao.countMonitorProtocolQuery(omap);
		Page page = new Page(protocolQryVO.getPageSize(), protocolQryVO.getPageIndex(), total);

		List list = extbcntmprotbaseinfodao.getMonitorProtocolQuery(omap, page);

		page.setRecords(list);
		page.setTotalRecord(total);
		return page;
	}

	/**
	 * 查询抵质押合同列表
	 * 
	 * @param contSlaveQryVO
	 * @return
	 * @throws ScubeBizException
	 * @author mengjiajia
	 * @date 2017年5月10日下午2:30:51
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public Page getSlaveContList(ContSlaveQryVO contSlaveQryVO) throws ScubeBizException {
		Page pageQueryResult = bcrrgntyconservice.getSlaveContList2(contSlaveQryVO);
		List<ContSlaveResultVO> list = new ArrayList<ContSlaveResultVO>();
		for (int i = 0; i < pageQueryResult.getRecords().size(); i++) {
			com.huateng.scf.bas.crr.dao.model.BCrrGntyCon obj = (com.huateng.scf.bas.crr.dao.model.BCrrGntyCon) pageQueryResult.getRecords().get(i);
			String slaveContno = obj.getConId();
			String protocolNo = obj.getPrtclNo();
			String supplyChainPdId = obj.getVidPrdId();
			BigDecimal ration = obj.getRation();
			BigDecimal lowPriceNew = obj.getLowPriceNew();
			if (null == lowPriceNew) {
				lowPriceNew = new BigDecimal("0");
			}
			String startDate = obj.getStrtDt();
			String endDate = obj.getEndDt();
			String assureType = obj.getConTyp();
			String mgrno = obj.getTlrNo();
			String mgrnoNm = obj.getTlrNm();
			String brcode = obj.getBrCd();
			String brcodeName = obj.getBrNm();
			String moniModel = obj.getMoniMd();
			String flag = obj.getFlg();
			ContSlaveResultVO vo = new ContSlaveResultVO();
			vo.setSlaveContno(obj.getConId());
			vo.setSlaveContcode(obj.getConId());
			vo.setProtocolNo(protocolNo);
			vo.setCustcd(obj.getGutId());
			vo.setCname(obj.getGutNm());
			vo.setSupplyChainPdId(supplyChainPdId);
			vo.setCurcd(obj.getGutCurcd());
			vo.setSlaveContAmt(obj.getGutVal());
			vo.setRation(ration);
			vo.setLowPriceNew(lowPriceNew);
			vo.setStartDate(startDate);
			vo.setEndDate(endDate);
			vo.setAssureType(assureType);
			vo.setMgrno(mgrno);
			vo.setBrcode(brcode);
			vo.setFlag(flag);
			vo.setMgrnoNm(mgrnoNm);
			vo.setBrcodeName(brcodeName);
			DeliveryApplyQryVO deliveryApplyQryVO = new DeliveryApplyQryVO();
			if (!StringUtil.isEmpty(protocolNo)) {
				deliveryApplyQryVO.setProtocolNo(protocolNo);
				deliveryApplyQryVO.setPageIndex(1);
				deliveryApplyQryVO.setPageSize(999999);
				deliveryApplyQryVO.setRole_Q(ScfBasConstant.PROTOCOL_PART_ROLE_MONI);
				Page pageQueryResult1 = getMutiProtPartInfoByPara(deliveryApplyQryVO);
				if (!pageQueryResult1.getRecords().isEmpty()) {
					BCntMprotPartInfo thrMutiProtPartInfo = (BCntMprotPartInfo) pageQueryResult1.getRecords().get(0);
					vo.setMoniCustcd(thrMutiProtPartInfo.getCustcd());
					BCrmBaseInfo custvo = bcrmbaseinfodao.selectById(thrMutiProtPartInfo.getCustcd());
					if (custvo != null) {
						vo.setMoniNm(custvo.getCname());
					}
				}
			}
			// 计算敞口
			AmountVO amountVO = new AmountVO();
			amountVO.setProductId(supplyChainPdId);
			amountVO.setSlaveContno(slaveContno);
			BigDecimal openAmount = amountservice.getPant(amountVO);
			vo.setOpenAmount(openAmount);// 敞口
			BigDecimal totalLnciAmt = blanlncibaseservice.queryLnciAmtBySlaveContno(slaveContno);
			BigDecimal bd = bpbcmtgbaseinfoservice.getSumPriceByslaveContno(slaveContno);
			vo.setMortgageAmount(bd);
			vo.setTotalLnciAmt(totalLnciAmt);
			vo.setDeliveryAmt(bd.subtract(lowPriceNew));
			vo.setMoniModel(moniModel);
			BPrdMort tblProductMort = bprdmortdao.selectByPrimaryKey(supplyChainPdId);
			if ((null != tblProductMort) && (ScfBasConstant.MONI_MODEL_STATIC.equals(tblProductMort.getMoniType()))) {// 动产静态·
				if (null != ration && (ration.compareTo(BigDecimal.ZERO) > 0)) {
					vo.setLowPriceNew(openAmount.multiply(new BigDecimal(100)).divide(ration, 2, BigDecimal.ROUND_HALF_UP));
					vo.setDeliveryAmt(bd.subtract(vo.getLowPriceNew()));
				}
			}
			BPrdInfo tblProductInfo = bprdinfodao.selectByPrimaryKey(supplyChainPdId);
			if ((null != tblProductInfo) && ((ScfBasConstant.PRODUCT_TYPE_CAR_PLEDGE.equals(tblProductInfo.getParentId())
					|| (ScfBasConstant.PRODUCT_TYPE_WAREHOUSE.equals(tblProductInfo.getParentId()))))) {
				// 汽车货押 或者四方
				if (null != ration && (ration.compareTo(BigDecimal.ZERO) > 0)) {
					vo.setLowPriceNew(openAmount.multiply(new BigDecimal(100)).divide(ration, 2, BigDecimal.ROUND_HALF_UP));
					vo.setDeliveryAmt(bd.subtract(vo.getLowPriceNew()));
				}
			}

			// 通过质押合同号去查询是否存在有审批中的放款。
			vo.setCheckFlag("0");
			List listTemp = blanlncibaseservice.getLnciBaseInfoListBySlaveContno(slaveContno);
			if (listTemp != null && listTemp.size() > 0) {
				vo.setCheckFlag("1");
			}
			List listTemp1 = bpbcapplibaseinfoservice.queryAppliBaseInfoBySlaveContno(slaveContno);
			if (listTemp1 != null && listTemp1.size() > 0) {
				vo.setCheckFlag("1");
			}

			list.add(vo);
		}
		pageQueryResult.setRecords(list);
		return pageQueryResult;
	}

	/**
	 * 信贷合同列表
	 * 
	 * @param contSlaveQryVO
	 * @return
	 * @author mengjiajia
	 * @date 2017年5月10日下午4:55:03
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Page getContBaseInfoListBySlaveContno(ContSlaveQryVO contSlaveQryVO) {
		Page pageQueryResult = bcrrlnconservice.getContBaseInfoListBySlaveContno(contSlaveQryVO);
		List<com.huateng.scf.bas.crr.dao.model.BCrrLnCon> listcon = pageQueryResult.getRecords();
		List<ContBaseResultVO> list = new ArrayList<ContBaseResultVO>();
		if (listcon != null && listcon.size() > 0) {
			for (com.huateng.scf.bas.crr.dao.model.BCrrLnCon bCrrLnCon : listcon) {
				ContBaseResultVO contBaseResultVO = new ContBaseResultVO();
				BeanUtils.copyProperties(bCrrLnCon, contBaseResultVO);
				HashMap<String, Object> map = blanlncibaseservice.getLnciSumByParam(bCrrLnCon.getAppId());
				BigDecimal bailAmount = (BigDecimal) map.get("bailAmount");
				BigDecimal cashEqtAmt = (BigDecimal) map.get("cashEqtAmt");
				contBaseResultVO.setBailAmount(bailAmount);
				contBaseResultVO.setCashEqtAmt(cashEqtAmt);
				// 获取合同下的敞口余额。
				BigDecimal contRistAmtTemp = amountservice.getContRiskAmtByCycle(bCrrLnCon.getAppId(), bCrrLnCon.getControlType());
				BigDecimal riskAmt = contBaseResultVO.getLnAmt() == null ? BigDecimal.ZERO : contBaseResultVO.getLnAmt();
				contBaseResultVO.setAvaliableRiskAmt(riskAmt.subtract(contRistAmtTemp));

				list.add(contBaseResultVO);
			}
		}
		pageQueryResult.setRecords(list);
		return pageQueryResult;
	}

	/**
	 * 查询质押合同下所有借据
	 * 
	 * @param contSlaveQryVO
	 * @return
	 * @throws ScubeBizException
	 * @author mengjiajia
	 * @date 2017年5月10日下午5:13:43
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Page getLnciBaseInfoListBySlaveContno(ContSlaveQryVO contSlaveQryVO) throws ScubeBizException {
		Page pageQueryResult = blanlncibaseservice.getLnciBaseInfoListBySlaveContno(contSlaveQryVO);
		List<com.huateng.scf.bas.lan.dao.model.BLanLnciBase> listlnci = pageQueryResult.getRecords();
		if (listlnci != null && listlnci.size() > 0) {
			for (com.huateng.scf.bas.lan.dao.model.BLanLnciBase lanLnciBase : listlnci) {
				BigDecimal bailAmount = lanLnciBase.getBailAmount() == null ? BigDecimal.ZERO : lanLnciBase.getBailAmount();
				BigDecimal addBailAmount = lanLnciBase.getAddBailAmount() == null ? BigDecimal.ZERO : lanLnciBase.getAddBailAmount();
				BigDecimal initCashEqtAmt = lanLnciBase.getInitCashEqtAmt() == null ? BigDecimal.ZERO : lanLnciBase.getInitCashEqtAmt();
				BigDecimal addCashEqtAmt = lanLnciBase.getAddCashEqtAmt() == null ? BigDecimal.ZERO : lanLnciBase.getAddCashEqtAmt();
				lanLnciBase.setBailAmount(bailAmount.add(addBailAmount));
				lanLnciBase.setInitCashEqtAmt(initCashEqtAmt.add(addCashEqtAmt));
				BigDecimal receivableInt = lanLnciBase.getReceivableInt() == null ? BigDecimal.ZERO : lanLnciBase.getReceivableInt();
				lanLnciBase.setReceivableInt(receivableInt);
			}
		}
		pageQueryResult.setRecords(listlnci);
		return pageQueryResult;
	}
	
	/**
	 * 保存时验证担保合同是否已被其他供应链产品抢占,未抢占则更新担保合同的产品ID
	 * @param slaveContno
	 * @param supplyChainPdId
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年5月16日下午4:06:42
	 */
	@Override
	public void checkUpdateSlaveContractBySupplyChainPdId(String slaveContno,
			String supplyChainPdId) throws ScubeBizException {
		bcrrgntyconservice.checkUpdateSlaveContractBySupplyChainPdId(slaveContno,supplyChainPdId);
	}

	@Override
	@Transactional
	public String saveChgMutiProt(MonitorProtocolVO contractVO) throws ScubeBizException {
		String protocolNo = new String();
		//保存后的操作
		//1.保存变更后的协议
		protocolNo = saveChgMutiProtInfo(contractVO);
		//2.将原协议置为无效
		StopProtocolNo(contractVO.getProtocolNo());
		//3.新增协议变更历史
		addTblMutiProtChgHis(protocolNo, contractVO.getProtocolNo(), ContextHolder.getUserInfo().getTlrNo());
		//4.监管商变更时，变更额度信息（额度的占用和释放）
		updateCraditInfo(contractVO.getSecCd(),contractVO.getProtocolNo(),contractVO.getThrCode(),contractVO.getProductId());
		//6.修改先票后货协议参与方包含监管公司
		updateMutiProtPartByProcolNo(contractVO.getProtocolNo(),
				contractVO.getThrCode(),contractVO.getThrName());
		//7.将监管下限调整申请表中的旧（监管合同号、监管模式、监管公司客户号）换成新的
		updateTblAppliLowerPrice(protocolNo,contractVO.getProtocolNo(),
				contractVO.getThrCode(),contractVO.getWarehouseType());
		//8.将押品信息表中的旧（监管合同号、监管公司客户号）换成新的
		updateMortgageBaseInfo(protocolNo,contractVO.getProtocolNo(),contractVO.getThrCode());
		//9.借据表及借据申请表中的间接额度客户要更改（监管商变更）
		updateLnciInfo(contractVO.getSecCd(),contractVO.getProtocolNo(),contractVO.getThrCode(),contractVO.getProductId());
		//10.修改业务申请基本信息表中监管公司信息
		updateTblAppliBaseInfo(contractVO.getProductId(),protocolNo,contractVO.getProtocolNo(),
				contractVO.getThrCode());
		//5.修改抵质押合同
		updateContSlaveProtocolNo(protocolNo,contractVO.getProtocolNo());
		return protocolNo;
	}
	
	/**
	 * 将抵质押合同中的旧监管合同号换成新监管合同号
	 *
	 * @throws CommonException
	 */
	public void updateContSlaveProtocolNo(String protocolNo,String protocolNoChg){
		List<BCrrGntyCon> list = bcrrgntyconservice.getContSlaveByProtocolNo(protocolNoChg);
		if(list!=null && list.size()>0){
			Iterator  iter = list.iterator();
			while(iter.hasNext()){
				BCrrGntyCon vo = (BCrrGntyCon) iter.next();
				vo.setPrtclNo(protocolNo);
				bcrrgntyconservice.update(vo);
			}
		}
	}
	
	/**
	 * @Description: 将基本申请信息表中的旧（监管合同号、监管公司客户号）换成新的
	 * @param protocolNo
	 * @param protocolNoChg
	 * @param moniOfCustcd
	 * @param moniModel
	 * @throws CommonException
	 */
	public void updateTblAppliBaseInfo(String productId,String protocolNo,String protocolNoChg,String moniOfCustcd){
		BPbcAppliBaseInfoExample example = new BPbcAppliBaseInfoExample();
		BPbcAppliBaseInfoExample.Criteria cri = example.createCriteria();
		cri.andOtherProtocolNoEqualTo(protocolNoChg);
		List<BPbcAppliBaseInfo> list = bPbcAppliBaseInfoDAO.selectByExample(example);
		if(list!=null && list.size()>0){
			Iterator  iter = list.iterator();
			while(iter.hasNext()){
				BPbcAppliBaseInfo vo = (BPbcAppliBaseInfo) iter.next();
				if(!productId.equals(ScfBasConstant.PRODUCT_TYPE_CAR_PL) && !productId.equals(ScfBasConstant.PRODUCT_TYPE_XPHH)){
					vo.setProtocolNo(protocolNo);
				}

				vo.setOtherProtocolNo(protocolNo);
				vo.setMoniCustcd(moniOfCustcd);
				bPbcAppliBaseInfoDAO.updateByPrimaryKey(vo);
			}
		}
	}
	
	/**
	 * 借据表及借据申请表中的间接额度客户要更改（监管商变更）
	 *参数：出质人，原监管合同号，监管商
	 * @throws CommonException
	 */
	public void updateLnciInfo(String secCd,String protocolNoChg,String thrCd,String productId){
		String oldThrCd = bcntmprotpartinfoservice.findCoreorCustByProtocolNo(
				protocolNoChg, ScfBasConstant.PROTOCOL_PART_ROLE_MONI).getCustcd();//原监管商
		//判断是先票款后货还是存货类
		if(productId.equals(ScfBasConstant.PRODUCT_TYPE_CAR_PL) || productId.equals(ScfBasConstant.PRODUCT_TYPE_XPHH)){
			BCntMprotBaseInfo tblMutiProtBaseInfoVO = iBCntMprotBaseInfoDAO.selectByPrimaryKey(protocolNoChg);
			if(tblMutiProtBaseInfoVO.getOtherprotocolNo()!=null && tblMutiProtBaseInfoVO.getOtherprotocolNo()!=""){
				List<com.huateng.scf.bas.lan.dao.model.BLanLnciBase> lnciInfoList = bLanLnciBaseDAO.getTblLnciBaseInfo(oldThrCd,secCd,tblMutiProtBaseInfoVO.getOtherprotocolNo());
				if(lnciInfoList!=null && lnciInfoList.size()>0){
					Iterator  iter = lnciInfoList.iterator();
					while(iter.hasNext()){
						com.huateng.scf.bas.lan.dao.model.BLanLnciBase vo = (com.huateng.scf.bas.lan.dao.model.BLanLnciBase) iter.next();
						vo.setCreditCustcd(thrCd);
						bLanLnciBaseDAO.updateByPrimaryKey(vo);
					}
				}
				List<com.huateng.scf.bas.lan.dao.model.BLanAppliLnciBase> lnciappliInfoList = bLanAppliLnciBaseDAO.getTblAppliLnciBaseInfo(oldThrCd,secCd,tblMutiProtBaseInfoVO.getOtherprotocolNo());
				if(lnciappliInfoList!=null && lnciappliInfoList.size()>0){
					Iterator  appli = lnciappliInfoList.iterator();
					while(appli.hasNext()){
						com.huateng.scf.bas.lan.dao.model.BLanAppliLnciBase vo = (com.huateng.scf.bas.lan.dao.model.BLanAppliLnciBase) appli.next();
						vo.setCreditCustcd(thrCd);
						bLanAppliLnciBaseDAO.updateByPrimaryKey(vo);
					}
				}

			}
		}else{
			List<BCrrGntyCon> list = bcrrgntyconservice.getContSlaveByProtocolNo(protocolNoChg);
			if(list!=null && list.size()>0){
				Iterator  iter = list.iterator();
				while(iter.hasNext()){
					BCrrGntyCon tblContSlaveInfoVO = (BCrrGntyCon) iter.next();
					List<com.huateng.scf.bas.lan.dao.model.BLanLnciBase> lnciInfoList = bLanLnciBaseDAO.getTblLnciBaseInfo(oldThrCd,secCd,tblContSlaveInfoVO.getConId());
					if(lnciInfoList!=null && lnciInfoList.size()>0){
						Iterator  lnci = lnciInfoList.iterator();
						while(lnci.hasNext()){
							com.huateng.scf.bas.lan.dao.model.BLanLnciBase vo = (com.huateng.scf.bas.lan.dao.model.BLanLnciBase) lnci.next();
							vo.setCreditCustcd(thrCd);
							bLanLnciBaseDAO.updateByPrimaryKey(vo);
						}
					}
					List<com.huateng.scf.bas.lan.dao.model.BLanAppliLnciBase> lnciappliInfoList = bLanAppliLnciBaseDAO.getTblAppliLnciBaseInfo(oldThrCd,secCd,tblContSlaveInfoVO.getConId());
					if(lnciappliInfoList!=null && lnciappliInfoList.size()>0){
						Iterator  applilnci = lnciappliInfoList.iterator();
						while(applilnci.hasNext()){
							com.huateng.scf.bas.lan.dao.model.BLanAppliLnciBase vo = (com.huateng.scf.bas.lan.dao.model.BLanAppliLnciBase) applilnci.next();
							vo.setCreditCustcd(thrCd);
							bLanAppliLnciBaseDAO.updateByPrimaryKey(vo);
						}
					}
				}
			}
		}
	}
	
	/**
	 * @Description: 将押品信息表中的旧（监管合同号、监管公司客户号）换成新的
	 * @param protocolNo
	 * @param protocolNoChg
	 * @param moniOfCustcd
	 * @throws CommonException
	 */
	public void updateMortgageBaseInfo(String protocolNo,String protocolNoChg,String moniOfCustcd){
		BPbcAppliMtgInfoExample example = new BPbcAppliMtgInfoExample();
		BPbcAppliMtgInfoExample.Criteria cri = example.createCriteria();
		cri.andMonitorProtocolNoEqualTo(protocolNoChg);
		List<BPbcAppliMtgInfo> listOne = bPbcAppliMtgInfoDAO.selectByExample(example);
		
		BPbcMtgBaseInfoExample example2 = new BPbcMtgBaseInfoExample();
		BPbcMtgBaseInfoExample.Criteria cri2 = example2.createCriteria();
		cri2.andMonitorProtocolNoEqualTo(protocolNoChg);
		List<BPbcMtgBaseInfo> listTwo = bPbcMtgBaseInfoDAO.selectByExample(example2);
		
		if(listOne!=null && listOne.size()>0){
			Iterator  iterOne = listOne.iterator();
			while(iterOne.hasNext()){
				BPbcAppliMtgInfo tblAppliMortgageBaseInfo = (BPbcAppliMtgInfo) iterOne.next();
				tblAppliMortgageBaseInfo.setMonitorProtocolNo(protocolNo);
				tblAppliMortgageBaseInfo.setMoniOfCustcd(moniOfCustcd);
				bPbcAppliMtgInfoDAO.updateByPrimaryKey(tblAppliMortgageBaseInfo);
			}
		}
		if(listTwo!=null && listTwo.size()>0){
			Iterator  iterTwo = listTwo.iterator();
			while(iterTwo.hasNext()){
				BPbcMtgBaseInfo tblMortgageBaseInfo = (BPbcMtgBaseInfo) iterTwo.next();
				tblMortgageBaseInfo.setMonitorProtocolNo(protocolNo);
				tblMortgageBaseInfo.setMoniOfCustcd(moniOfCustcd);
				bPbcMtgBaseInfoDAO.updateByPrimaryKey(tblMortgageBaseInfo);
			}
		}
	}
	
	/**
	 * @Description: 将监管下限调整申请表中的旧（监管合同号、监管模式、监管公司客户号）换成新的
	 * @param protocolNo
	 * @param protocolNoChg
	 * @param moniOfCustcd
	 * @param moniModel
	 * @throws CommonException
	 */
	public void updateTblAppliLowerPrice(String protocolNo,String protocolNoChg,String moniOfCustcd,String moniModel){
		SBcpAppliLowerPriceExample example = new SBcpAppliLowerPriceExample();
		SBcpAppliLowerPriceExample.Criteria cri = example.createCriteria();
		cri.andProtocolNoEqualTo(protocolNoChg);
		List<SBcpAppliLowerPrice> list = sBcpAppliLowerPriceDAO.selectByExample(example);
		if(list!=null && list.size()>0){
			Iterator iter = list.iterator();
			while(iter.hasNext()){
				SBcpAppliLowerPrice vo = (SBcpAppliLowerPrice) iter.next();
				vo.setProtocolNo(protocolNo);
				vo.setMoniOfCustcd(moniOfCustcd);
				vo.setMoniModel(moniModel);
				sBcpAppliLowerPriceDAO.updateByPrimaryKey(vo);
			}
		}
	}
	
	/**
	 * 多方协议参与者信息表旧监管合同号换成新监管合同号(先票后货协议参与方包含监管公司)
	 *
	 * @throws CommonException TBL_MUTI_PROT_PART_INFO
	 */
	public void updateMutiProtPartByProcolNo(String protocolNoChg,String moniOfCustcd,String moniOfCname){
		BCntMprotBaseInfo tblMutiProtBaseInfoVO = iBCntMprotBaseInfoDAO.selectByPrimaryKey(protocolNoChg);
		if(tblMutiProtBaseInfoVO.getOtherprotocolNo()!=null && tblMutiProtBaseInfoVO.getOtherprotocolNo()!=""){
			 com.huateng.scf.bas.cnt.model.BCntMprotPartInfo tblMutiProtPartInfoVO = bcntmprotpartinfoservice.
				findCoreorCustByProtocolNo(tblMutiProtBaseInfoVO.getOtherprotocolNo(),ScfBasConstant.PROTOCOL_PART_ROLE_MONI);
			tblMutiProtPartInfoVO.setCustcd(moniOfCustcd);
			tblMutiProtPartInfoVO.setCname(moniOfCname);
			BCntMprotPartInfo info = new BCntMprotPartInfo();
			BeanUtils.copyProperties(tblMutiProtPartInfoVO, info);
			bCntMprotPartInfoDAO.updateByPrimaryKey(info);
		}
	}
	
	/**
	 * 监管商变更时，变更额度信息（额度的占用和释放）
	 *参数：出质人，原监管合同号，监管商
	 * @throws CommonException
	 */
	public void updateCraditInfo(String secCd,String protocolNoChg,String thrCd,String productId){
		String oldThrCd = bcntmprotpartinfoservice.findCoreorCustByProtocolNo(
				protocolNoChg, ScfBasConstant.PROTOCOL_PART_ROLE_MONI).getCustcd();//原监管商
		//判断是先票款后货还是存货类
		if(productId.equals(ScfBasConstant.PRODUCT_TYPE_CAR_PL) || productId.equals(ScfBasConstant.PRODUCT_TYPE_XPHH)){
			BCntMprotBaseInfo tblMutiProtBaseInfoVO = iBCntMprotBaseInfoDAO.selectByPrimaryKey(protocolNoChg);
			if(tblMutiProtBaseInfoVO.getOtherprotocolNo()!=null && tblMutiProtBaseInfoVO.getOtherprotocolNo()!=""){
				List<Map<String, Object>> lnciInfoList = bLanLnciBaseDAO.getKindsOfSum(tblMutiProtBaseInfoVO.getOtherprotocolNo(),oldThrCd);
				Map<String, Object> amounts = lnciInfoList.get(0);
				BigDecimal chgAmount = (BigDecimal) amounts.get("LNCI_BAL");
				if(chgAmount != null && !chgAmount.equals(new BigDecimal(0))){
					String creditType = "EDZL2013112900010";//监管商自由库监管额度
					BIcrInfo tblCreditInfoVO = (BIcrInfo)bIcrInfoService.checkCredit(oldThrCd,secCd,creditType).get(0);
					if(!StringUtil.isEmpty(tblCreditInfoVO)){//判断原先有没有额度信息
						//占用额度
						indirectCreditDealWithChg(thrCd,secCd,creditType,
								ScfBasConstant.CREDIT_TRADE_TYPE_DIRECT_OCCUPY,chgAmount);
						//释放额度
						indirectCreditDealWithChg(oldThrCd,secCd,creditType,
								ScfBasConstant.CREDIT_TRADE_TYPE_RELEASE,chgAmount);
					}
				}
			}
		}else{
			List<BCrrGntyCon> list = bCrrGntyConService.getContSlaveByProtocolNo(protocolNoChg);
			if(list!=null && list.size()>0){
				Iterator  iter = list.iterator();
				BigDecimal chgAmount = new BigDecimal(0);//计算该次额度释放金额
					while(iter.hasNext()){
						BCrrGntyCon tblContSlaveInfoVO = (BCrrGntyCon) iter.next();
						List<Map<String, Object>> lnciInfoList = bLanLnciBaseDAO.getKindsOfSum(tblContSlaveInfoVO.getConId(),oldThrCd);
						Map<String, Object> amounts = lnciInfoList.get(0);
						BigDecimal lnciBal = (BigDecimal) amounts.get("LNCI_BAL");
						if(lnciBal != null && !lnciBal.equals(new BigDecimal(0))){
							chgAmount = chgAmount.add((BigDecimal) lnciBal);
						}
					}
					String creditType = "EDZL2013112900010";//监管商自由库监管额度
					if( bIcrInfoService.checkCredit(oldThrCd,secCd,creditType).size() > 0){
						BIcrInfo tblCreditInfoVO = (BIcrInfo) bIcrInfoService.checkCredit(oldThrCd,secCd,creditType).get(0);

						if(chgAmount != null &&!chgAmount.equals(new BigDecimal(0))){
							if(!StringUtil.isEmpty(tblCreditInfoVO)){//判断原先有没有额度信息
								//占用额度
								indirectCreditDealWithChg(thrCd,secCd,creditType,
										ScfBasConstant.CREDIT_TRADE_TYPE_DIRECT_OCCUPY,chgAmount);
								//释放额度
								indirectCreditDealWithChg(oldThrCd,secCd,creditType,
										ScfBasConstant.CREDIT_TRADE_TYPE_RELEASE,chgAmount);
							}
						}
					}
			}
		}
	}
	
	/**
	 * @Description: （监管商变更）间接额度操作方法
	 * @param custcd
	 * @param otherCustcd
	 * @param creditType
	 * @param operType
	 * @param amt
	 * @throws CommonException
	 */
	public void indirectCreditDealWithChg(String custcd,String otherCustcd,String creditType,String operType,BigDecimal amt){

		if(StringUtil.isEmpty(custcd)){
			throw new ScubeBizException("客户信息丢失！");
		}
		if(StringUtil.isEmpty(otherCustcd)){
			throw new ScubeBizException("交易对手信息丢失！");
		}
		if(StringUtil.isEmpty(creditType)){
			throw new ScubeBizException("间接额度种类信息丢失！");
		}
		if(StringUtil.isEmpty(operType)){
			throw new ScubeBizException("间接额度操作类型丢失！");
		}
		if(!ScfBasConstant.CREDIT_TRADE_TYPE_END.equalsIgnoreCase(operType)){
			if(amt==null){
				throw new ScubeBizException("间接额度操作金额信息丢失！");
			}
		}

		CreditQryVO creditQryVO = new CreditQryVO();
		creditQryVO.setCreditClass_Q(ScfBasConstant.CREDIT_CLASS_INDIRECT);
		creditQryVO.setNodeType_Q(ScfBasConstant.CREDIT_NODE_TYPE_SUB_LEAF);
		creditQryVO.setCustcd(custcd);
		creditQryVO.setOtherCustcd_Q(otherCustcd);
		creditQryVO.setCreditType_Q(creditType);
		creditQryVO.setPageIndex(1);
		creditQryVO.setPageSize(Integer.MAX_VALUE);
		//直接占用
		if(ScfBasConstant.CREDIT_TRADE_TYPE_DIRECT_OCCUPY.equalsIgnoreCase(operType)){
			creditQryVO.setStatus_Q(ScfBasConstant.CREDIT_STATUS_NORMAL);
			Page pageQueryResult = bIcrInfoService.getCurrenyEffectiveTblCreditInfoByCreditQryVO(creditQryVO);
			List subLeafCreditInfoList=pageQueryResult.getRecords();
			// 检查额度是否存在 条件：额度种类，客户号，交易对手 记录不存在则异常抛出错误
			if (subLeafCreditInfoList==null||subLeafCreditInfoList.size()==0) {
				throw new ScubeBizException("新的监管商没有间接领用额度信息,请维护额度！");
			}

			//获取领用额度
			BIcrInfo subLeafCreditInfo =(BIcrInfo)subLeafCreditInfoList.get(0);
			//操作金额必须小于领用额度可用余额
			if(amt.compareTo(subLeafCreditInfo.getCreditUsableAmount())>0){
				throw new ScubeBizException("新的监管商可用余额不足,请维护额度！");
			}
			//记录流水
			CreditInterParamBean creditInterParam = new CreditInterParamBean();
			creditInterParam.setCreditNo(subLeafCreditInfo.getCreditNo());
			creditInterParam.setOperType(operType);
			creditInterParam.setAmount(amt);
			bIcrDtlService.addCreditDetailChg(creditInterParam,custcd,otherCustcd,creditType,operType,amt,subLeafCreditInfo);
			// 更新额度信息
			BigDecimal creditUsableAmount=subLeafCreditInfo.getCreditUsableAmount();
			BigDecimal usedAmount=subLeafCreditInfo.getUsedAmount();
		 	//额度余额 = 前额度余额 – 交易金额
			subLeafCreditInfo.setCreditUsableAmount(creditUsableAmount.subtract(amt));
			//实占用额度 = 前实占用额度 + 交易金额
			subLeafCreditInfo.setUsedAmount(usedAmount.add(amt));
			com.huateng.scf.bas.icr.dao.model.BIcrInfo info = new com.huateng.scf.bas.icr.dao.model.BIcrInfo();
			BeanUtils.copyProperties(subLeafCreditInfo, info);
			bIcrInfoDAO.updateByPrimaryKey(info);

		}
		//占用恢复
		if(ScfBasConstant.CREDIT_TRADE_TYPE_RELEASE.equalsIgnoreCase(operType)){
			//获取领用额度
			BIcrInfo subLeafCreditInfo = (BIcrInfo) bIcrInfoService.checkCredit(custcd,otherCustcd,creditType).get(0);
//			TblCreditInfo subLeafCreditInfo = tblCreditInfoDAO.get(SCFDataFormat.trim(tblLnciBaseInfo.getCreditNo()));
			if (subLeafCreditInfo == null){
				throw new ScubeBizException("间接领用额度信息丢失,不可释放额度！");
			}
				// 恢复(释放)额度不可大于占用额度 当大于恢复额度大于占用额度的时候 直接恢复已占用额度
				if(amt.compareTo(subLeafCreditInfo.getUsedAmount())>0){
					amt=subLeafCreditInfo.getUsedAmount();
				}
				// 记录流水
				CreditInterParamBean creditInterParam2 = new CreditInterParamBean();
				creditInterParam2.setCreditNo(subLeafCreditInfo.getCreditNo());
				creditInterParam2.setOperType(operType);
				creditInterParam2.setAmount(amt);
				bIcrDtlService.addCreditDetailChg(creditInterParam2,custcd,otherCustcd,creditType,operType,amt,subLeafCreditInfo);

				// 更新额度信息
				BigDecimal creditUsableAmount=subLeafCreditInfo.getCreditUsableAmount();
				BigDecimal usedAmount=subLeafCreditInfo.getUsedAmount();
				//额度余额 = 前额度余额 + 交易金额
				subLeafCreditInfo.setCreditUsableAmount(creditUsableAmount.add(amt));
				//实占用额度 = 前实占用额度 - 交易金额
				subLeafCreditInfo.setUsedAmount(usedAmount.subtract(amt));
				com.huateng.scf.bas.icr.dao.model.BIcrInfo info = new com.huateng.scf.bas.icr.dao.model.BIcrInfo();
				BeanUtils.copyProperties(subLeafCreditInfo, info);
				bIcrInfoDAO.updateByPrimaryKey(info);
//			}
		}
	}
	
	/**
	 * 新增协议变更历史
	 *
	 * @throws CommonException
	 */
	public void addTblMutiProtChgHis(String protocolNo,String oldProtocolNo,String tlrcd){
		BCntMprotChgHis tblMutiProtChgHis = new BCntMprotChgHis();
		tblMutiProtChgHis.setId(UUIDGeneratorUtil.generate());
		tblMutiProtChgHis.setProtocolNo(protocolNo);
		tblMutiProtChgHis.setOldProtocolNo(oldProtocolNo);
		tblMutiProtChgHis.setTime(new Date());
		tblMutiProtChgHis.setTlrcd(tlrcd);
		bCntMprotChgHisDAO.insert(tblMutiProtChgHis);
	}

	
	private void StopProtocolNo(String protocolNo){
		BCntMprotBaseInfo info = new BCntMprotBaseInfo();
		info.setProtocolNo(protocolNo);
		info.setState(ScfBasConstant.STATE_INVALID);
		iBCntMprotBaseInfoDAO.updateByPrimaryKeySelective(info);
	}
	
	/**
	 *
	 * @Description:监管协议监管商变更
	 * @author jianfeng.huang
	 * @Created 2013-7-5上午6:21:55
	 * @param contractVO
	 * @return
	 * @throws CommonException
	 */
	@Transactional
	public String saveChgMutiProtInfo(MonitorProtocolVO contractVO){
		BCntMprotBaseInfo tblMutiProtBaseInfo = null;
		tblMutiProtBaseInfo = new BCntMprotBaseInfo();
		contractVO.setProtocolNo(contractVO.getProtocolCode());
		BeanUtils.copyProperties(contractVO, tblMutiProtBaseInfo);

		String protocolNo = null;
		String parentProductID = productServiceImpl.getParentIdById(tblMutiProtBaseInfo.getProductId());
		
		BCntMprotBaseInfo BaseInfo = iBCntMprotBaseInfoDAO.selectByPrimaryKey(tblMutiProtBaseInfo.getProtocolNo());

		if (BaseInfo != null) {
			tblMutiProtBaseInfo.setProductId(BaseInfo.getProductId());// 产品ID
			// 先票后货
			if (ScfBasConstant.PRODUCT_TYPE_PREP.equals(parentProductID)) {
				if (ScfBasConstant.PRODUCT_TYPE_XPHH.equals(contractVO.getProductId()))
					protocolNo = bSysSerialNoService.genSerialNo(ScfBasConstant.BUSSNO_TYPE_PROTOCOL_CODE_JGXPHH);// 先票款后货
			}
			//现货
			if(ScfBasConstant.PRODUCT_TYPE_CHATTLE.equals(parentProductID)){
				if(ScfBasConstant.MONI_MODEL_DYNAMIC.equals(tblMutiProtBaseInfo.getMoniType())){  //动态
					protocolNo = bSysSerialNoService.genSerialNo(ScfBasConstant.BUSSNO_TYPE_PROTOCOL_CODE_JGDT);//number和code保持一致
				}
				if(ScfBasConstant.MONI_MODEL_STATIC.equals(tblMutiProtBaseInfo.getMoniType())){  //静态
					protocolNo = bSysSerialNoService.genSerialNo(ScfBasConstant.BUSSNO_TYPE_PROTOCOL_CODE_JGJT);//number和code保持一致
				}
			}
			//非标准仓单（普通仓单）
			if(ScfBasConstant.PRODUCT_TYPE_BILL_NORMAL.equals(tblMutiProtBaseInfo.getProductId())){
				protocolNo = bSysSerialNoService.genSerialNo(ScfBasConstant.BUSSNO_TYPE_PROTOCOL_CODE_JGFBC);//number和code保持一致
			}
		}

		tblMutiProtBaseInfo.setProtocolNo(protocolNo);
		tblMutiProtBaseInfo.setProtocolCode(protocolNo);
		tblMutiProtBaseInfo.setCurcd(contractVO.getCurcdNm());
		tblMutiProtBaseInfo.setState(ScfBasConstant.STATE_VALID);// 协议状态 有效-1
		try {
			tblMutiProtBaseInfo.setUpdateDate(ScfDateUtil.toDate(BSysConstant.WORKDATE, ScfDateUtil.DATE_FORMAT_YYYYMMDD));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		tblMutiProtBaseInfo.setUpdateState(ScfBasConstant.UPDATESTATE_VALID);// 协议更新状态
		tblMutiProtBaseInfo.setTlrno(ContextHolder.getUserInfo().getTlrNo());
		tblMutiProtBaseInfo.setBrcode(ContextHolder.getOrgInfo().getBrNo());
		tblMutiProtBaseInfo.setSignDate(BSysConstant.WORKDATE);
		tblMutiProtBaseInfo.setProtocolType(ScfBasConstant.MUTI_PROTOCOL_MONI);// 多方协议类型
		tblMutiProtBaseInfo.setStartDate(contractVO.getStartDate());
		tblMutiProtBaseInfo.setEndDate(contractVO.getEndDate());
		tblMutiProtBaseInfo.setMoniType(contractVO.getMoniType());
		try {
			tblMutiProtBaseInfo
					.setTenor(ScfDateUtil.getTenOr(ScfDateUtil.toDate(tblMutiProtBaseInfo.getStartDate(), ScfDateUtil.DATE_FORMAT_YYYYMMDD), ScfDateUtil.toDate(tblMutiProtBaseInfo.getEndDate(), ScfDateUtil.DATE_FORMAT_YYYYMMDD)));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		iBCntMprotBaseInfoDAO.insert(tblMutiProtBaseInfo);
		BCntMprotCmInfo tblMutiProtCmInfo = new BCntMprotCmInfo();
		BeanUtils.copyProperties(contractVO, tblMutiProtCmInfo);

		tblMutiProtCmInfo.setProtocolNo(protocolNo);
		tblMutiProtCmInfo.setMoniOfCustcd(contractVO.getThrCode());
		// tblMutiProtCmInfo.setMoniType(contractVO.getMoniType());
//		tblMutiProtCmInfo.setMoniProtocolType(contractVO.getMoniProtocolType());// 监管协议类型
//		tblMutiProtCmInfo.setLowPriceNew(contractVO.getLowPriceNew());// 监管底线

//		tblMutiProtCmInfo.setIsHighestLimit(contractVO.getIsHighestLimit());
//		tblMutiProtCmInfo.setMoniPriceModel(contractVO.getMoniPriceModel());
//		tblMutiProtCmInfo.setMoniModel(contractVO.getMoniModel());
//		tblMutiProtCmInfo.setDeallineRate(contractVO.getDeallineRate());
		tblMutiProtCmInfo.setWarehouseType(contractVO.getWarehouseType());
//		tblMutiProtCmInfo.setWarehouseHireProtocol(contractVO.getWarehouseHireProtocol());
//		tblMutiProtCmInfo.setWarehouseHireStartDate(contractVO.getWarehouseHireStartDate());
//		tblMutiProtCmInfo.setWarehouseHireEndDate(contractVO.getWarehouseHireEndDate());
		tblMutiProtCmInfo.setOtherDes(contractVO.getOtherDes());
//		tblMutiProtCmInfo.setNoticeType(contractVO.getNoticeType());
//		tblMutiProtCmInfo.setCostBear(contractVO.getCostBear());
//		tblMutiProtCmInfo.setCostStandard(contractVO.getCostStandard());
//		tblMutiProtCmInfo.setMoniWarehouseType(contractVO.getMoniWarehouseType());
//		tblMutiProtCmInfo.setMoniAreaType(contractVO.getMoniAreaType());
		tblMutiProtCmInfo.setLogisticsMoniCondition(contractVO.getLogisticsMoniCondition());
//		tblMutiProtCmInfo.setWarehousedress(contractVO.getWarehouseAddress());
//		tblMutiProtCmInfo.setMortgagePayType(contractVO.getMortgagePayType());
//		tblMutiProtCmInfo.setSpecialWarehouseCondition(contractVO.getSpecialWarehouseCondition());
//		tblMutiProtCmInfo.setMoniCost(contractVO.getMoniCost());
		tblMutiProtCmInfo.setIsPledge(contractVO.getIsPledge());
		bCntMprotCmInfoDAO.insert(tblMutiProtCmInfo);

		BCntMprotPartInfo tInfofir = new BCntMprotPartInfo();
		tInfofir.setRole(ScfBasConstant.PROTOCOL_PART_ROLE_BANK);// 银行
		tInfofir.setProtocolNo(protocolNo);
		tInfofir.setId(UUIDGeneratorUtil.generate());
		tInfofir.setCustcd(ContextHolder.getOrgInfo().getBrNo());
		tInfofir.setCname(ContextHolder.getOrgInfo().getBrName());
		bCntMprotPartInfoDAO.insert(tInfofir);

		BCntMprotPartInfo tInfosec = new BCntMprotPartInfo();
		tInfosec.setRole(ScfBasConstant.PROTOCOL_PART_ROLE_CREDIT);// 经销商
		tInfosec.setProtocolNo(protocolNo);
		tInfosec.setId(UUIDGeneratorUtil.generate());
		tInfosec.setCustcd(contractVO.getSecCd());
		tInfosec.setCname(contractVO.getSecName());
//		tInfosec.setActBankno(contractVO.getActBankno());
		bCntMprotPartInfoDAO.insert(tInfosec);

		BCntMprotPartInfo tInfothr = new BCntMprotPartInfo();
		tInfothr.setRole(ScfBasConstant.PROTOCOL_PART_ROLE_MONI);// 监管公司
		tInfothr.setProtocolNo(protocolNo);
		tInfothr.setId(UUIDGeneratorUtil.generate());
		tInfothr.setCustcd(contractVO.getThrCode());
		tInfothr.setCname(contractVO.getThrName());
		bCntMprotPartInfoDAO.insert(tInfothr);

		return tblMutiProtBaseInfo.getProtocolNo();
	}
	
}
