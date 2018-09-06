package com.huateng.scf.rec.qry.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.huateng.authority.common.ContextHolder;
import com.huateng.authority.entity.BctlVO;
import com.huateng.authority.entity.TlrInfoVO;
import com.huateng.authority.entity.UserInfo;
import com.huateng.authority.inter.service.ScubeUserService;
import com.huateng.authority.service.OrgService;
import com.huateng.authority.service.UserService;
import com.huateng.base.common.beans.Page;
import com.huateng.scf.adv.bcp.constant.ABcpErrorConstant;
import com.huateng.scf.bas.brp.dao.IBBrpPrdFactoringDAO;
import com.huateng.scf.bas.brp.dao.model.BBrpPrdFactoring;
import com.huateng.scf.bas.cnt.dao.IBCntDebtInfoDAO;
import com.huateng.scf.bas.cnt.dao.model.BCntDebtInfo;
import com.huateng.scf.bas.cnt.model.FourWareLoanVO;
import com.huateng.scf.bas.common.constant.ScfBasConstant;
import com.huateng.scf.bas.common.util.ScfCommonUtil;
import com.huateng.scf.bas.crr.dao.IBCrrLnConDAO;
import com.huateng.scf.bas.crr.dao.model.BCrrLnCon;
import com.huateng.scf.bas.crr.dao.model.BCrrLnConExample;
import com.huateng.scf.bas.lan.dao.IBLanLnciBaseDAO;
import com.huateng.scf.bas.lan.dao.model.BLanLnciBase;
import com.huateng.scf.bas.lan.dao.model.BLanLnciBaseExample;
import com.huateng.scf.rec.bcp.dao.IRBcpDebtPoolDAO;
import com.huateng.scf.rec.bcp.dao.model.DebtBillsInfoVO;
import com.huateng.scf.rec.bcp.dao.model.FactoringContVO;
import com.huateng.scf.rec.bcp.dao.model.RBcpDebtBaseInfo;
import com.huateng.scf.rec.bcp.dao.model.RBcpDebtPoolExample;
import com.huateng.scf.rec.bcp.model.DebtBussInfoVO;
import com.huateng.scf.rec.bcp.model.DebtLnciBaseInfoVO;
import com.huateng.scf.rec.bcp.service.IFactFinanceBaseService;
import com.huateng.scf.rec.qry.dao.IDebtPoolGenerateDAO;
import com.huateng.scf.rec.qry.service.IDebtPoolGenerateQueryService;
import com.huateng.scube.server.annotation.ScubeService;
@ScubeService
@Service("DebtPoolGenerateQueryServiceImpl")
public class DebtPoolGenerateQueryServiceImpl implements IDebtPoolGenerateQueryService {
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	ScubeUserService scubeUserService;

    @Resource(name = "orgService")
	OrgService orgService;
	@Resource(name = "userService")
	UserService userService;
    @Resource(name = "FactFinanceBaseServiceImpl")
	IFactFinanceBaseService factFinanceBaseService;
	@Resource(name="BBrpPrdFactoringDAO")
	IBBrpPrdFactoringDAO bBrpPrdFactoringDAO;
	@Resource(name="BCntDebtInfoDAO")
	IBCntDebtInfoDAO bCntDebtInfoDAO;
	@Resource(name="RBcpDebtPoolDAO")
	IRBcpDebtPoolDAO rBcpDebtPoolDAO;
	@Resource(name="IBCrrLnConDAO")
	IBCrrLnConDAO bcrrlncondao;
	@Resource(name="DebtPoolGenerateDAO")
	IDebtPoolGenerateDAO debtPoolGenerateDAO;
	@Resource(name="BLanLnciBaseDAO")
	IBLanLnciBaseDAO bLanLnciBaseDAO;
 
	@Override
	public DebtBussInfoVO queryDebtGenaralLedger(String mastContno) {
		DebtBussInfoVO debtVO = new DebtBussInfoVO();
		FactoringContVO contVO = getFactContDetailByMastContno(mastContno);
		BeanUtils.copyProperties(contVO, debtVO);
		//池应收账款余额
		RBcpDebtPoolExample example = new RBcpDebtPoolExample();
		com.huateng.scf.rec.bcp.dao.model.RBcpDebtPoolExample.Criteria criteria = example.createCriteria();
		if (StringUtils.isNotEmpty(mastContno)) {
			criteria.andMastContnoEqualTo(mastContno);
		}
		List<com.huateng.scf.rec.bcp.dao.model.RBcpDebtPool> poolList = rBcpDebtPoolDAO.selectByExample(example);
		if(null!=poolList&&poolList.size()>0){
			if(poolList.get(0)!=null){
				debtVO.setTotalBillsAmount(poolList.get(0).getTotalDebtRemainAmount());
			}else{
				debtVO.setTotalBillsAmount(BigDecimal.ZERO);
			}
		}
		//池敞口金额
		debtVO.setPoolRiskAmt(factFinanceBaseService.calculatePoolRiskAvailableAmtByBusinessNo(mastContno));//池敞口余额
		//池保证金金额
		debtVO.setBailAmount(new BigDecimal(100000000));
		//TODO 需要核心系统取值，后续优化
//		String switchType  = SCFConstants.FLAG_ON; //核心系统开关标志默认开
//		try {
//			switchType = SysParamUnit.getCoreFlag();
//		} catch (CommonException e1) {
//			e1.printStackTrace();
//		}
//		if (SCFConstants.FLAG_ON.equals(switchType)){
//			S033ReqData cores033ReqData = new S033ReqData();
//			cores033ReqData.setJymmbz("0"); //密码校验方式 0－不校验
//			cores033ReqData.setKehuzh(contVO.getBailAcctNo());
//			cores033ReqData.setHuobdh("01");//01-人民币
//			S033RspData s033RspData = CoreClientService.getInstance().doS033(cores033ReqData);
//			if(null!=s033RspData){
//				debtVO.setBailAmount(s033RspData.getAvabal());
//			}
//		}else{
//			debtVO.setBailAmount(new BigDecimal(100000));
//
//		}
//		BctlVO bctl = scubeUserService.selectBctlByBrNo(contVO.getBrcode(),ScfCommonUtil.getBrManagerNo(scubeUserService));
//		debtVO.setBrcode(bctl.getBrName());
//		UserInfo userInfo = scubeUserService.selectUserByTlrNo(contVO.getMgrno(),ScfCommonUtil.getBrManagerNo(scubeUserService));
//		debtVO.setTlrcd(userInfo.getTlrName());
		
		UserInfo userInfo = new UserInfo();
		userInfo.setTlrNo(contVO.getMgrno());
		List<TlrInfoVO> userList = userService.selectByExample(userInfo);
		if (userList != null && userList.size() == 1) {
			debtVO.setTlrcd(userList.get(0).getTlrName());
		}else{
			debtVO.setTlrcd("");
		}
		
		BctlVO bctlVO = new BctlVO();
		bctlVO.setBrNo(contVO.getBrcode());
		List<BctlVO> bctlVOList = orgService.selectByExample(bctlVO);
		if (bctlVOList != null && bctlVOList.size() == 1) {
			debtVO.setBrcode(bctlVOList.get(0).getBrName());
		}else{
			debtVO.setBrcode("");
		}
		debtVO.setCustcdSaller(contVO.getCustcd());
		debtVO.setMastContno(contVO.getDebtContno());
		debtVO.setBailAccount(contVO.getBailAcctNo());
		return debtVO;
	}

	/**
	 * 通过mastContno获取保理合同明细信息
	 * */
	private FactoringContVO getFactContDetailByMastContno(String mastContno) {
		FactoringContVO factContVO = null;
		String productId = null;
		BCntDebtInfo contDebtInfo = bCntDebtInfoDAO.selectByPrimaryKey(mastContno);// 保理合同信息
		if(  null!=contDebtInfo ){
			productId = contDebtInfo.getSupplyChainPdId();
			BBrpPrdFactoring productFactoring = bBrpPrdFactoringDAO.selectByPrimaryKey(productId); //产品参数
			factContVO = new FactoringContVO();
//			BeanUtils.copyProperties(productFactoring,factContVO);字段类型不匹配
			factContVO.setProductId(productFactoring.getProductId());
			factContVO.setSellerType(productFactoring.getSellerType());
			factContVO.setBuyerType(productFactoring.getBuyerType());
			factContVO.setBillsType(productFactoring.getBillsType());
			factContVO.setLeaseFactoringFlag(productFactoring.getLeaseFactoringFlag());
			factContVO.setLeasebackFlag(productFactoring.getLeasebackFlag());
			
			BeanUtils.copyProperties(contDebtInfo,factContVO);
//			TblInsuranceContInfo insuranceInfo =insuranceDAO.get(contDebtInfo.getDebtContno());
//			if(insuranceInfo!=null&&insuranceInfo.getProtocolNo()!=null){
//				factContVO.setInsuranceCustcd(insuranceInfo.getInsuranceCustcd());
//			}

		}
		return factContVO;
	}

	@Override
	public Page getCreditLoanContInfoByParam(int pageNo, int pageSize, String mastContno) {
		//台账查询信贷合同信息
		log.info("台账查询信贷合同信息");
		Page page = new Page(pageSize, pageNo, 0);
		List<FourWareLoanVO> list = new ArrayList<FourWareLoanVO>();
		BCrrLnConExample example = new BCrrLnConExample();
		com.huateng.scf.bas.crr.dao.model.BCrrLnConExample.Criteria cri = example.createCriteria();
		if(mastContno!=null&&!"".equals(mastContno))
		{
			cri.andVidNoEqualTo(mastContno);
		}
		List<BCrrLnCon> crrLnList = bcrrlncondao.selectByPage(example,page);
		for(BCrrLnCon crrLn : crrLnList){
			FourWareLoanVO vo = new FourWareLoanVO();
			vo.setMastContcode(crrLn.getAppId()); //信贷合同号
			vo.setContAmount(crrLn.getLnAmt()); //信贷合同金额
			vo.setRiskAmt(crrLn.getLnAmt()); //信贷合同总敞口(表没有这个字段，写死)
			vo.setAvaliableRiskAmt(crrLn.getLnAmt());	//信贷合同可用敞口(表没有这个字段，写死)
			vo.setStartDate(crrLn.getLnStrtDt()); //合同生效日
			vo.setEndDate(crrLn.getLnEndDt()); //合同到期日
			vo.setMastContno(mastContno); //信贷合同编号
			Map<String,String> param = new HashMap<String,String>();
			param.put("protocolNo", mastContno); 
			param.put("mastContno", vo.getMastContcode());
			List<Map<String, String>> sumList = debtPoolGenerateDAO.getFourProtocolTotalLnciAmtByProtocolNo(param);
			if(null!=sumList&&sumList.size()>0){
				vo.setTotBailAmount(sumList.get(0).get("bailamount")==null?BigDecimal.ZERO:new BigDecimal(sumList.get(0).get("bailamount"))); //信贷合同下借据保证金金额汇总
				vo.setTotCashEqtAmt(sumList.get(0).get("eqtamt")==null?BigDecimal.ZERO:new BigDecimal(sumList.get(0).get("eqtamt"))); //信贷合同下现金等价物价值总计
			}
			 list.add(vo);
		}
		page.setRecords(list);
		return page;
	}

	@Override
	public Page getLnciBaseInfoByProtocolNo(int pageNo, int pageSize, String mastContno) {
		log.info("根据业务合同号获取借据信息");
		Page page = new Page(pageSize, pageNo, 0);
		List<DebtLnciBaseInfoVO> list = new ArrayList<DebtLnciBaseInfoVO>();
		BLanLnciBaseExample example = new BLanLnciBaseExample();
		com.huateng.scf.bas.lan.dao.model.BLanLnciBaseExample.Criteria criteria = example.createCriteria();
		if (StringUtils.isNotEmpty(mastContno)) {
			criteria.andProtocolNoEqualTo(mastContno);
		}
		if (StringUtils.isNotEmpty(ScfBasConstant.FLAG_ON)) {
			criteria.andStateNotEqualTo(ScfBasConstant.FLAG_ON);
		}
		List<com.huateng.scf.bas.lan.dao.model.BLanLnciBase> lnciBaseList = bLanLnciBaseDAO.selectByPage(example,page);
		for(BLanLnciBase temp :lnciBaseList){
			BLanLnciBase lnciInfo = temp;
			DebtLnciBaseInfoVO lnciInfoVO = new DebtLnciBaseInfoVO();
			BeanUtils.copyProperties(lnciInfo,lnciInfoVO) ;
			BigDecimal receivableInt = lnciInfoVO.getReceivableInt()==null?BigDecimal.ZERO:lnciInfoVO.getReceivableInt();
			BigDecimal receivablePunishInt = lnciInfoVO.getReceivablePunishInt()==null?BigDecimal.ZERO:lnciInfoVO.getReceivablePunishInt();
			BigDecimal bailAmount = lnciInfoVO.getBailAmount()==null?BigDecimal.ZERO:lnciInfoVO.getBailAmount();
			BigDecimal addBailAmount = lnciInfoVO.getAddBailAmount()==null?BigDecimal.ZERO:lnciInfoVO.getAddBailAmount();
			BigDecimal initCashEqtAmt = lnciInfoVO.getInitCashEqtAmt()==null?BigDecimal.ZERO:lnciInfoVO.getInitCashEqtAmt();
			BigDecimal addCashEqtAmt = lnciInfoVO.getAddCashEqtAmt()==null?BigDecimal.ZERO:lnciInfoVO.getAddCashEqtAmt();

			lnciInfoVO.setInTableInt(receivableInt.add(receivablePunishInt));//欠息总额 =应收欠息+应罚欠息
			lnciInfoVO.setTotBailAmt(bailAmount.add(addBailAmount));//保证金金额
			lnciInfoVO.setTotCashEqualAmt(initCashEqtAmt.add(addCashEqtAmt)); //现金等价物金额
			list.add(lnciInfoVO);
		}
		page.setRecords(list);
		return page;
	}

	@Override
	public Page getDebtBillsInfo(int pageNo, int pageSize, Map<String,String> paramMap) {
		log.info("应收账款清单");
		Page page = new Page(pageSize, pageNo, 0);
		List<DebtBillsInfoVO> resultList = new ArrayList<DebtBillsInfoVO>();
		List<RBcpDebtBaseInfo> debtList =  debtPoolGenerateDAO.getDebtInfoQuery(paramMap,page);
		for(RBcpDebtBaseInfo debtInfo: debtList){
			DebtBillsInfoVO debtvo=new DebtBillsInfoVO();
			BeanUtils.copyProperties(debtInfo,debtvo) ;
			if(!StringUtils.isEmpty(debtvo.getDebetNo())){
				BLanLnciBase lnciInfo = bLanLnciBaseDAO.selectByPrimaryKey(debtvo.getDebetNo());
				if(lnciInfo!=null){
					debtvo.setDebetNo(lnciInfo.getDebetId());
				}
			}
			resultList.add(debtvo);
		}
		page.setRecords(resultList);
		return page;
	}

}
