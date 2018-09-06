package com.huateng.scf.nrec.bcp.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huateng.authority.entity.BctlVO;
import com.huateng.authority.entity.TlrInfoVO;
import com.huateng.authority.entity.UserInfo;
import com.huateng.authority.inter.service.ScubeUserService;
import com.huateng.authority.service.OrgService;
import com.huateng.authority.service.UserService;
import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.brp.dao.IBBrpPrdFactoringDAO;
import com.huateng.scf.bas.brp.dao.model.BBrpPrdFactoring;
import com.huateng.scf.bas.cnt.constant.BCntErrorConstant;
import com.huateng.scf.bas.cnt.model.DebtContVO;
import com.huateng.scf.bas.cnt.model.FourWareLoanVO;
import com.huateng.scf.bas.common.constant.ScfBasConstant;
import com.huateng.scf.bas.common.startup.ScfMessageUtil;
import com.huateng.scf.bas.common.util.ScfCommonUtil;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.crr.dao.IBCrrLnConDAO;
import com.huateng.scf.bas.crr.dao.model.BCrrLnCon;
import com.huateng.scf.bas.crr.dao.model.BCrrLnConExample;
import com.huateng.scf.bas.lan.dao.IBLanLnciBaseDAO;
import com.huateng.scf.bas.lan.dao.model.BLanLnciBase;
import com.huateng.scf.bas.lan.dao.model.BLanLnciBaseExample;
import com.huateng.scf.bas.pbc.dao.model.ext.BPbcAppliBaseInfoDO;
import com.huateng.scf.bas.pbc.model.BPbcAppliBaseInfoVO;
import com.huateng.scf.bas.prd.dao.IBPrdInfoDAO;
import com.huateng.scf.bas.sys.constant.DebtConstants;
import com.huateng.scf.nrec.bcp.dao.IBCntBcpExtInfoDAO;
import com.huateng.scf.nrec.bcp.dao.IBCntBcpInfoBussQryDAO;
import com.huateng.scf.nrec.bcp.dao.IBCntBcpInfoDAO;
import com.huateng.scf.nrec.bcp.dao.domodel.BCntBcpInfoDO;
import com.huateng.scf.nrec.bcp.dao.domodel.RBcpDebtBussInfoDO;
import com.huateng.scf.nrec.bcp.dao.domodel.RBcpDebtInfoDO;
import com.huateng.scf.nrec.bcp.dao.ext.ExtNrecBcpDAO;
import com.huateng.scf.nrec.bcp.dao.model.BCntBcpExtInfo;
import com.huateng.scf.nrec.bcp.dao.model.BCntBcpExtInfoExample;
import com.huateng.scf.nrec.bcp.dao.model.BCntBcpInfo;
import com.huateng.scf.nrec.bcp.model.BCntBcpExtInfoVO;
import com.huateng.scf.nrec.bcp.model.BCntBcpInfoVO;
import com.huateng.scf.nrec.bcp.model.RBcpDebtInfoVO;
import com.huateng.scf.nrec.bcp.service.IBCntBcpInfoBussQryService;
import com.huateng.scf.nrec.bcp.service.IBCntBcpInfoService;
import com.huateng.scf.nrec.bcp.service.INFactFinanceBaseService;
import com.huateng.scf.nrec.bcp.vo.NFactoringContVO;
import com.huateng.scf.rec.bcp.dao.IRBcpDebtPoolDAO;
import com.huateng.scf.rec.bcp.dao.model.DebtBillsInfoVO;
import com.huateng.scf.rec.bcp.dao.model.RBcpDebtBaseInfo;
import com.huateng.scf.rec.bcp.dao.model.RBcpDebtPoolExample;
import com.huateng.scf.rec.bcp.model.DebtBussInfoVO;
import com.huateng.scf.rec.bcp.model.DebtLnciBaseInfoVO;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

@ScubeService
@Service(IBCntBcpInfoBussQryService.BeanId)
public class BCntBcpInfoBussQryServiceImpl implements IBCntBcpInfoBussQryService {

	Logger log = LoggerFactory.getLogger(this.getClass());

	@Resource(name = IBCntBcpInfoBussQryDAO.BeanId)
	private IBCntBcpInfoBussQryDAO bCntBcpInfoBussQryDAO;

	@Autowired
	ScubeUserService scubeUserService;

	@Resource(name = "IBCntBcpInfoDAO")
	IBCntBcpInfoDAO bCntBcpInfoDAO;

	@Resource(name = "BBrpPrdFactoringDAO")
	IBBrpPrdFactoringDAO bBrpPrdFactoringDAO;

	@Autowired
	UserService userService;

	@Autowired
	OrgService orgService;

	@Resource(name = "RBcpDebtPoolDAO")
	IRBcpDebtPoolDAO rBcpDebtPoolDAO;

	@Resource(name = "NFactFinanceBaseServiceImpl")
	INFactFinanceBaseService nfactFinanceBaseService;

	@Resource(name = "IBCrrLnConDAO")
	private IBCrrLnConDAO bcrrlncondao;

	@Resource(name = "BCntBcpInfoServiceImpl")
	private IBCntBcpInfoService bCntBcpInfoService;

	@Resource(name = "BPrdInfoDAO")
	IBPrdInfoDAO bPrdInfoDAO;

	@Resource(name = "BLanLnciBaseDAO")
	IBLanLnciBaseDAO bLanLnciBaseDAO;

	@Resource(name = "IBCntBcpExtInfoDAO")
	IBCntBcpExtInfoDAO bCntBcpExtInfoDAO;

	@Resource(name = "ExtNrecBcpDAO")
	ExtNrecBcpDAO extnrecbcpdao;
	
	@SuppressWarnings("rawtypes")
	@Override
	public Page getDebtReturnAccountByPage(int pageNo, int pageSize, Map<String, Object> bcntbcpinfo) {

		Page page = new Page(pageSize, pageNo, 0);

		if (bcntbcpinfo == null) {
			bcntbcpinfo = new HashMap<String, Object>();
		}

		// 查询权限设置
		HashMap<String, List<String>> map = ScfMessageUtil.transSysParamByKey(ScfBasConstant.QUERY_LIMITS);
		bcntbcpinfo.putAll(map);
		
		List<com.huateng.scf.nrec.bcp.dao.domodel.BCntBcpInfoDO> list = bCntBcpInfoBussQryDAO.findBCntBcpInfoDOByPage(bcntbcpinfo, page);
		Iterator itr = list.iterator();
		List<com.huateng.scf.nrec.bcp.dao.domodel.BCntBcpInfoDO> resultList = new ArrayList<com.huateng.scf.nrec.bcp.dao.domodel.BCntBcpInfoDO>();
		while (itr.hasNext()) {
			BCntBcpInfoDO debtvo = new BCntBcpInfoDO();
			com.huateng.scf.nrec.bcp.dao.domodel.BCntBcpInfoDO billsInfoVO = (com.huateng.scf.nrec.bcp.dao.domodel.BCntBcpInfoDO) itr.next();
			BeanUtils.copyProperties(billsInfoVO, debtvo);
			BctlVO bctlVO = scubeUserService.selectBctlByBrNo(billsInfoVO.getBrcode(), ScfCommonUtil.getBrManagerNo(scubeUserService));
			UserInfo userInfo = scubeUserService.selectUserByTlrNo(billsInfoVO.getTlrcd(), ScfCommonUtil.getBrManagerNo(scubeUserService));
			if (bctlVO != null && StringUtils.isNotEmpty(bctlVO.getBrName())) {
				debtvo.setBrname(bctlVO.getBrName());
			}
			if (userInfo != null && StringUtils.isNotEmpty(userInfo.getTlrName())) {
				debtvo.setTlrnm(userInfo.getTlrName());
			}

			resultList.add(debtvo);
		}

		page.setRecords(list);

		return page;

	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Page getDebtRepaymentInfo(int pageNo, int pageSize, Map<String, Object> bcntbcpinfo) {

		if (bcntbcpinfo == null) {
			bcntbcpinfo = new HashMap<String, Object>();
		}
		bcntbcpinfo.put("applyType", DebtConstants.APPLY_TYPE_REPAYMENT);
		// 查询权限设置
		HashMap<String, List<String>> map = ScfMessageUtil.transSysParamByKey(ScfBasConstant.QUERY_LIMITS);
		bcntbcpinfo.putAll(map);
		
		Page page = new Page(pageSize, pageNo, 0);
		//用户名称及用户编号不匹配，则用户手动重置
		List<RBcpDebtBussInfoDO> records = bCntBcpInfoBussQryDAO.findDebtRepaymentInfo(bcntbcpinfo, page);
		Iterator<RBcpDebtBussInfoDO> itr = records.iterator();
		List resultList = new ArrayList();
		while (itr.hasNext()) {
			RBcpDebtBussInfoDO billsInfoVO = itr.next();
			com.huateng.scf.rec.bcp.model.DebtBillsInfoVO debtvo = new com.huateng.scf.rec.bcp.model.DebtBillsInfoVO();
			BeanUtils.copyProperties(billsInfoVO, debtvo);
			BctlVO bctlVO = scubeUserService.selectBctlByBrNo(billsInfoVO.getBrcode(), ScfCommonUtil.getBrManagerNo(scubeUserService));
			UserInfo userInfo = scubeUserService.selectUserByTlrNo(billsInfoVO.getTlrcd(), ScfCommonUtil.getBrManagerNo(scubeUserService));
			if (bctlVO != null && StringUtils.isNotEmpty(bctlVO.getBrName())) {
				debtvo.setBrcodeNm(bctlVO.getBrName());
			}
			if (userInfo != null && StringUtils.isNotEmpty(userInfo.getTlrName())) {
				debtvo.setTlrName(userInfo.getTlrName());
			}
			debtvo.setRemoveAmount(billsInfoVO.getReturnAmount());
			resultList.add(debtvo);
		}

		page.setRecords(resultList);
		return page;
	}

	@Override
	public Page getDebtQuery(int pageNo, int pageSize, Map<String, Object> commonQueryVO) {
		if (commonQueryVO == null) {
			commonQueryVO = new HashMap<String, Object>();
		}
		// 查询权限设置
		HashMap<String, List<String>> map = ScfMessageUtil.transSysParamByKey(ScfBasConstant.QUERY_LIMITS);
		commonQueryVO.putAll(map);
		
		int total = bCntBcpInfoBussQryDAO.countDebtInfoByPerson(commonQueryVO);
		Page page = new Page(pageSize, pageNo, total);

		List<RBcpDebtInfoDO> list = bCntBcpInfoBussQryDAO.getDebtInfoByPerson(commonQueryVO, page);
		Iterator<RBcpDebtInfoDO> itr = list.iterator();
		List<RBcpDebtInfoDO> responseList = new ArrayList<RBcpDebtInfoDO>();
		while (itr.hasNext()) {
			RBcpDebtInfoDO billsInfoVO = itr.next();
			BctlVO bctlVO = scubeUserService.selectBctlByBrNo(billsInfoVO.getBrcode(), ScfCommonUtil.getBrManagerNo(scubeUserService));
			UserInfo userInfo = scubeUserService.selectUserByTlrNo(billsInfoVO.getTlrcd(), ScfCommonUtil.getBrManagerNo(scubeUserService));
			if (bctlVO != null && StringUtils.isNotEmpty(bctlVO.getBrName())) {
				billsInfoVO.setBrcodeNm(bctlVO.getBrName());
			}
			if (userInfo != null && StringUtils.isNotEmpty(userInfo.getTlrName())) {
				billsInfoVO.setTlrName(userInfo.getTlrName());
			}
			responseList.add(billsInfoVO);
		}

		page.setRecords(responseList);
		page.setTotalRecord(total);
		return page;
	}

	@Override
	public Page getDebtReturnAccountImpDetail(List<RBcpDebtInfoVO> dtsrcList, String returnAccount, String payDatefrom, String payDateto, int pageNo,
			int pageSize) throws ScubeBizException {

		Page pageQueryResult = new Page(pageSize, pageNo, 0);

		if (dtsrcList == null || dtsrcList.size() == 0) {
			List<DebtBillsInfoVO> resultList = new ArrayList<DebtBillsInfoVO>();
			DebtBillsInfoVO debtvo1 = new DebtBillsInfoVO();
			debtvo1.setRepayAccount(returnAccount);
			debtvo1.setReturnDate("20161225");
			debtvo1.setReceiveAmount(new BigDecimal(4313));
			debtvo1.setPayerName("AAA");
			debtvo1.setPayerAcctNo(" ");
			debtvo1.setPayerBank(" ");
			debtvo1.setMemo("D");

			DebtBillsInfoVO debtvo2 = new DebtBillsInfoVO();
			debtvo2.setRepayAccount(returnAccount);
			debtvo2.setReturnDate("20160209");
			debtvo2.setReceiveAmount(new BigDecimal(6124));
			debtvo2.setPayerName("EEE");
			debtvo2.setPayerAcctNo(" ");
			debtvo2.setPayerBank(" ");
			debtvo2.setMemo("D");
			resultList.add(debtvo2);

			DebtBillsInfoVO debtvo3 = new DebtBillsInfoVO();
			debtvo3.setRepayAccount(returnAccount);
			debtvo3.setReturnDate("20160713");
			debtvo3.setReceiveAmount(new BigDecimal(1210));
			debtvo3.setPayerName("DDD");
			debtvo3.setPayerAcctNo(" ");
			debtvo3.setPayerBank(" ");
			debtvo3.setMemo("D");
			resultList.add(debtvo3);

			DebtBillsInfoVO debtvo4 = new DebtBillsInfoVO();
			debtvo4.setRepayAccount(returnAccount);
			debtvo4.setReturnDate("20160921");
			debtvo4.setReceiveAmount(new BigDecimal(4566));
			debtvo4.setPayerName("CCC");
			debtvo4.setPayerAcctNo(" ");
			debtvo4.setPayerBank(" ");
			debtvo4.setMemo("D");
			resultList.add(debtvo4);

			DebtBillsInfoVO debtvo5 = new DebtBillsInfoVO();
			debtvo5.setRepayAccount(returnAccount);
			debtvo5.setReturnDate("20161031");
			debtvo5.setReceiveAmount(new BigDecimal(9779));
			debtvo5.setPayerName("BBB");
			debtvo5.setPayerAcctNo(" ");
			debtvo5.setPayerBank(" ");
			debtvo5.setMemo("D");
			resultList.add(debtvo5);

			int from = RandomUtils.nextInt(0, resultList.size());
			int to = RandomUtils.nextInt(0, resultList.size());
			if (from > to) {
				int temp = from;
				to = from;
				from = temp;
			}
			if (from == to) {
				if (from == 0) {
					to = 3;
				} else if (from == resultList.size()) {
					from = from - 3;
				} else {
					from = from - 1;
				}
			}

			List<DebtBillsInfoVO> sublist = resultList.subList(from, to);
			List<DebtBillsInfoVO> qrylist = new ArrayList<DebtBillsInfoVO>();

			if (StringUtils.isNotEmpty(payDatefrom) && StringUtils.isNotEmpty(payDateto)) {
				for (int i = 0; i < sublist.size(); i++) {
					Long datefromVal = null;
					datefromVal = Long.valueOf(payDatefrom);
					Long datetoVal = null;
					datetoVal = Long.valueOf(payDateto);
					Long returnDate = Long.valueOf(sublist.get(i).getReturnDate());
					if (datefromVal != null && datetoVal != null) {
						if (returnDate > datefromVal && returnDate < datetoVal) {
							qrylist.add(sublist.get(i));
						}
					}
				}

				if (qrylist != null && qrylist.size() > 0) {
					sublist.clear();
					sublist.addAll(qrylist);
				}
			}

			pageQueryResult.setRecords(sublist);

			pageQueryResult.setTotalRecord(sublist.size());
		} else {
			List<RBcpDebtInfoVO> qrylist = new ArrayList<RBcpDebtInfoVO>();
			for (int i = 0; i < dtsrcList.size(); i++) {
				Long datefromVal = null;
				if (StringUtils.isNotEmpty(payDatefrom)) {
					datefromVal = Long.valueOf(payDatefrom);
				}
				Long datetoVal = null;
				if (StringUtils.isNotEmpty(payDateto)) {
					datetoVal = Long.valueOf(payDateto);
				}

				Long returnDate = Long.valueOf(dtsrcList.get(i).getReturnDate());
				if (datefromVal != null && datetoVal != null) {
					if (returnDate > datefromVal && returnDate < datetoVal) {
						qrylist.add(dtsrcList.get(i));
					}
				}
			}
			pageQueryResult.setTotalRecord(qrylist.size());
			if (qrylist.size() > 0) {
				pageQueryResult.setRecords(qrylist);
			} else {
				pageQueryResult.setRecords(dtsrcList);
			}
		}

		return pageQueryResult;
	}

	/**
	 * 查询合同列表
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @param bCntBcpInfoV
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Page queryBCntBcpInfoByPage(int pageNo, int pageSize, BCntBcpInfoVO bCntBcpInfoV)
	{
		Page page = bCntBcpInfoService.queryBCntBcpInfoByPage(pageNo, pageSize, bCntBcpInfoV);
		Iterator<BCntBcpInfoDO> itr = page.getRecords().iterator();
		List<BCntBcpInfoDO> responses = new ArrayList<BCntBcpInfoDO>();
		BCntBcpInfoDO response = null;
		BCntBcpInfoDO element = new BCntBcpInfoDO();
		while (itr.hasNext()) {
			response = new BCntBcpInfoDO();
			element = itr.next();
			BeanUtils.copyProperties(element, response);
			if (StringUtils.isNotBlank(response.getSupplyChainPdId())) {
				String productName = bPrdInfoDAO.selectByPrimaryKey(response.getSupplyChainPdId()).getProductName();
				response.setProductName(productName);
			}
			if (StringUtils.isNotBlank(response.getTlrcd())) {
				UserInfo userinfo = scubeUserService.selectUserByTlrNo(response.getTlrcd(), ScfCommonUtil.getBrManagerNo(scubeUserService));
				response.setTlrnm(userinfo.getTlrName());
			}
			if (StringUtils.isNotBlank(response.getBrcode())) {
				BctlVO bctlVO = scubeUserService.selectBctlByBrNo(response.getBrcode(), ScfCommonUtil.getBrManagerNo(scubeUserService));
				response.setBrname(bctlVO.getBrName());
			}

			responses.add(response);
		}
		page.setRecords(responses);
		return page;
	}

	@Override
	public DebtBussInfoVO queryDebtGenaralLedger(String mastContno) {
		DebtBussInfoVO debtVO = new DebtBussInfoVO();
		NFactoringContVO contVO = getFactContDetailByMastContno(mastContno);

		BeanUtils.copyProperties(contVO, debtVO);
		// 池应收账款余额
		RBcpDebtPoolExample example = new RBcpDebtPoolExample();
		com.huateng.scf.rec.bcp.dao.model.RBcpDebtPoolExample.Criteria criteria = example.createCriteria();
		if (StringUtils.isNotEmpty(mastContno)) {
			criteria.andMastContnoEqualTo(mastContno);
		}
		List<com.huateng.scf.rec.bcp.dao.model.RBcpDebtPool> poolList = rBcpDebtPoolDAO.selectByExample(example);
		if (null != poolList && poolList.size() > 0) {
			if (poolList.get(0) != null) {
				debtVO.setTotalBillsAmount(poolList.get(0).getTotalDebtRemainAmount());
			} else {
				debtVO.setTotalBillsAmount(BigDecimal.ZERO);
			}
		}
		// 池敞口金额
		debtVO.setPoolRiskAmt(nfactFinanceBaseService.calculatePoolRiskAvailableAmtByBusinessNo(mastContno));// 池敞口余额
		// 池保证金金额
		debtVO.setBailAmount(new BigDecimal(100000000));
		// TODO 需要核心系统取值，后续优化

		UserInfo userInfo = new UserInfo();
		userInfo.setTlrNo(contVO.getTlrcd());
		List<TlrInfoVO> userList = userService.selectByExample(userInfo);
		if (userList != null && userList.size() == 1) {
			debtVO.setTlrcd(userList.get(0).getTlrName());
		} else {
			debtVO.setTlrcd("");
		}

		BctlVO bctlVO = new BctlVO();
		bctlVO.setBrNo(contVO.getBrcode());
		List<BctlVO> bctlVOList = orgService.selectByExample(bctlVO);
		if (bctlVOList != null && bctlVOList.size() == 1) {
			debtVO.setBrcode(bctlVOList.get(0).getBrName());
		} else {
			debtVO.setBrcode("");
		}
		debtVO.setCustcdSaller(contVO.getCustcd());
		debtVO.setMastContno(contVO.getMastContno());
		debtVO.setBailAccount(contVO.getBalanceAccount());
		return debtVO;
	}

	@Override
	public Page getCreditLoanContInfoByParam(int pageNo, int pageSize, String mastContno) {
		// 台账查询信贷合同信息
		log.info("台账查询信贷合同信息");
		Page page = new Page(pageSize, pageNo, 0);
		List<FourWareLoanVO> list = new ArrayList<FourWareLoanVO>();
		BCrrLnConExample example = new BCrrLnConExample();
		com.huateng.scf.bas.crr.dao.model.BCrrLnConExample.Criteria cri = example.createCriteria();
		if (mastContno != null && !"".equals(mastContno)) {
			cri.andVidNoEqualTo(mastContno);
		}
		List<BCrrLnCon> crrLnList = bcrrlncondao.selectByPage(example, page);
		for (BCrrLnCon crrLn : crrLnList) {
			FourWareLoanVO vo = new FourWareLoanVO();
			vo.setMastContcode(crrLn.getAppId()); // 信贷合同号
			vo.setContAmount(crrLn.getLnAmt()); // 信贷合同金额
			vo.setRiskAmt(crrLn.getLnAmt()); // 信贷合同总敞口(表没有这个字段，写死)
			vo.setAvaliableRiskAmt(crrLn.getLnAmt()); // 信贷合同可用敞口(表没有这个字段，写死)
			vo.setStartDate(crrLn.getLnStrtDt()); // 合同生效日
			vo.setEndDate(crrLn.getLnEndDt()); // 合同到期日
			vo.setMastContno(mastContno); // 信贷合同编号
			Map<String, String> param = new HashMap<String, String>();
			param.put("protocolNo", mastContno);
			param.put("mastContno", vo.getMastContcode());
			List<Map<String, String>> sumList = bCntBcpInfoBussQryDAO.getFourProtocolTotalLnciAmtByProtocolNo(param);
			if (null != sumList && sumList.size() > 0) {
				vo.setTotBailAmount(sumList.get(0).get("bailamount") == null ? BigDecimal.ZERO : new BigDecimal(sumList.get(0).get("bailamount"))); // 信贷合同下借据保证金金额汇总
				vo.setTotCashEqtAmt(sumList.get(0).get("eqtamt") == null ? BigDecimal.ZERO : new BigDecimal(sumList.get(0).get("eqtamt"))); // 信贷合同下现金等价物价值总计
			}
			list.add(vo);
		}
		page.setRecords(list);
		return page;
	}

	@Override
	public Page getLnciBaseInfoByProtocolNo(int pageNo, int pageSize, String mastContno) {
		log.info("根据业务合同号获取借据信息");
		List<DebtLnciBaseInfoVO> list = new ArrayList<DebtLnciBaseInfoVO>();
		BLanLnciBaseExample example = new BLanLnciBaseExample();
		com.huateng.scf.bas.lan.dao.model.BLanLnciBaseExample.Criteria criteria = example.createCriteria();
		if (StringUtils.isNotEmpty(mastContno)) {
			criteria.andMastContnoEqualTo(mastContno);
		}
		if (StringUtils.isNotEmpty(ScfBasConstant.FLAG_ON)) {
			criteria.andStateNotEqualTo(ScfBasConstant.FLAG_ON);
		}
		
		int total = bLanLnciBaseDAO.countByExample(example);
		Page page = new Page(pageSize, pageNo, total);
		
		List<com.huateng.scf.bas.lan.dao.model.BLanLnciBase> lnciBaseList = bLanLnciBaseDAO.selectByPage(example, page);
		for (BLanLnciBase temp : lnciBaseList) {
			BLanLnciBase lnciInfo = temp;
			DebtLnciBaseInfoVO lnciInfoVO = new DebtLnciBaseInfoVO();
			BeanUtils.copyProperties(lnciInfo, lnciInfoVO);
			BigDecimal receivableInt = lnciInfoVO.getReceivableInt() == null ? BigDecimal.ZERO : lnciInfoVO.getReceivableInt();
			BigDecimal receivablePunishInt = lnciInfoVO.getReceivablePunishInt() == null ? BigDecimal.ZERO : lnciInfoVO.getReceivablePunishInt();
			BigDecimal bailAmount = lnciInfoVO.getBailAmount() == null ? BigDecimal.ZERO : lnciInfoVO.getBailAmount();
			BigDecimal addBailAmount = lnciInfoVO.getAddBailAmount() == null ? BigDecimal.ZERO : lnciInfoVO.getAddBailAmount();
			BigDecimal initCashEqtAmt = lnciInfoVO.getInitCashEqtAmt() == null ? BigDecimal.ZERO : lnciInfoVO.getInitCashEqtAmt();
			BigDecimal addCashEqtAmt = lnciInfoVO.getAddCashEqtAmt() == null ? BigDecimal.ZERO : lnciInfoVO.getAddCashEqtAmt();

			lnciInfoVO.setInTableInt(receivableInt.add(receivablePunishInt));// 欠息总额
																				// =应收欠息+应罚欠息
			lnciInfoVO.setTotBailAmt(bailAmount.add(addBailAmount));// 保证金金额
			lnciInfoVO.setTotCashEqualAmt(initCashEqtAmt.add(addCashEqtAmt)); // 现金等价物金额
			list.add(lnciInfoVO);
		}
		page.setRecords(list);
		page.setTotalRecord(total);
		return page;
	}

	@Override
	public Page getDebtBillsInfo(int pageNo, int pageSize, Map<String, String> paramMap) {

		log.info("应收账款清单");
		Page page = new Page(pageSize, pageNo, 0);
		List<DebtBillsInfoVO> resultList = new ArrayList<DebtBillsInfoVO>();
		List<RBcpDebtBaseInfo> debtList = bCntBcpInfoBussQryDAO.getDebtInfoQuery(paramMap, page);
		for (RBcpDebtBaseInfo debtInfo : debtList) {
			DebtBillsInfoVO debtvo = new DebtBillsInfoVO();
			BeanUtils.copyProperties(debtInfo, debtvo);
			if (!StringUtils.isEmpty(debtvo.getDebetNo())) {
				BLanLnciBase lnciInfo = bLanLnciBaseDAO.selectByPrimaryKey(debtvo.getDebetNo());
				if (lnciInfo != null) {
					debtvo.setDebetNo(lnciInfo.getDebetId());
				}
			}
			resultList.add(debtvo);
		}
		page.setRecords(resultList);
		return page;
	}

	/**
	 * 根据合同编号查询合同信息
	 */
	@Override
	public DebtContVO queryBCntDebtInfoByContno(DebtContVO debtContVO) throws ScubeBizException {
		// Map<String, String> map = new HashMap<String, String>();
		String debtContno = null;
		if (null != debtContVO) {
			debtContno = debtContVO.getDebtContno();
		}
		DebtContVO reDebtContVO = new DebtContVO();
		BCntBcpInfoVO daoDebtContVO = new BCntBcpInfoVO();
		daoDebtContVO = bCntBcpInfoService.queryBCntBcpInfoByMastContno(debtContno);
		BeanUtils.copyProperties(daoDebtContVO, reDebtContVO);

		UserInfo userInfo = scubeUserService.selectUserByTlrNo(reDebtContVO.getMgrno(), ScfCommonUtil.getBrManagerNo(scubeUserService));
		if (userInfo != null) {
			reDebtContVO.setMgrnoNm(userInfo.getTlrName());
		}
		BctlVO bctlVO = scubeUserService.selectBctlByBrNo(reDebtContVO.getBrcode(), ScfCommonUtil.getBrManagerNo(scubeUserService));
		List<BctlVO> listBctl = new ArrayList<BctlVO>();
		listBctl.add(bctlVO);
		reDebtContVO.setListBctl(listBctl);
		if (StringUtil.isStrNotEmpty(reDebtContVO.getCooperationBrcode())) {
			BctlVO CoopbctlVO = scubeUserService.selectBctlByBrNo(reDebtContVO.getCooperationBrcode(),
					ScfCommonUtil.getBrManagerNo(scubeUserService));
			if (CoopbctlVO != null) {
				reDebtContVO.setCooperationBrcodeNm(CoopbctlVO.getBrName());
			}
		}

		return reDebtContVO;

	}

	/**
	 * 根据合同编号查询交易对手基本信息
	 */
	@Override
	public BCntBcpExtInfoVO queryBCntBcpExtInfoByContno(DebtContVO debtContVO) throws ScubeBizException {
		// Page page = new Page(pageSize, pageNo, 0);
		BCntBcpExtInfoVO bcntbcpextinfoVO = new BCntBcpExtInfoVO();
		if (null != debtContVO) {
			String debtContno = debtContVO.getDebtContno();
			if (StringUtil.isStrNotEmpty(debtContno)) {
				BCntBcpExtInfoExample example = new BCntBcpExtInfoExample();
				com.huateng.scf.nrec.bcp.dao.model.BCntBcpExtInfoExample.Criteria criteria = example.createCriteria();
				criteria.andBusinessNoEqualTo(debtContno);
				List<BCntBcpExtInfo> records = bCntBcpExtInfoDAO.selectByExample(example);
				BCntBcpExtInfo bcntbcpextinfo = records.get(0);
				BeanUtils.copyProperties(bcntbcpextinfo, bcntbcpextinfoVO);
			} else {
				log.error("合同编号丢失！");
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BCntErrorConstant.SCF_BAS_CNT_30000),
						BCntErrorConstant.SCF_BAS_CNT_30000);
			}
		}
		return bcntbcpextinfoVO;

	}

	// *******************************************************//

	/**
	 * 通过mastContno获取保理合同明细信息
	 */
	@Override
	public NFactoringContVO getFactContDetailByMastContno(String mastContno) {
		NFactoringContVO factContVO = null;
		String productId = null;
		BCntBcpInfo contDebtInfo = bCntBcpInfoDAO.selectByPrimaryKey(mastContno);// 保理合同信息
		if (null != contDebtInfo) {
			productId = contDebtInfo.getSupplyChainPdId();
			BBrpPrdFactoring productFactoring = bBrpPrdFactoringDAO.selectByPrimaryKey(productId); // 产品参数
			factContVO = new NFactoringContVO();
			factContVO.setProductId(productFactoring.getProductId());
			String productNm = bPrdInfoDAO.selectByPrimaryKey(productFactoring.getProductId()).getProductName();
			factContVO.setProductNm(productNm);
			factContVO.setSellerType(productFactoring.getSellerType());
			factContVO.setBuyerType(productFactoring.getBuyerType());
			factContVO.setBillsType(productFactoring.getBillsType());
			factContVO.setLeaseFactoringFlag(productFactoring.getLeaseFactoringFlag());
			factContVO.setLeasebackFlag(productFactoring.getLeasebackFlag());
			BeanUtils.copyProperties(contDebtInfo, factContVO);

		}
		return factContVO;
	}

	/**
	 * 根据业务申请类型及其他参数获取业务申请信息
	 * @param pageNo
	 * @param pageSize
	 * @param value
	 * @return
	 * @author 	mengjiajia
	 * @date 	2017年7月12日下午4:07:11
	 */
	@Override
	public Page findBPbcAppliBaseInfoByParam(int pageNo, int pageSize, HashMap<String, Object> value)
	{
		List<String> appliTypes = new ArrayList<String>();
		if(value==null)
		{
			value = new HashMap<String, Object>();
		}
		if(!StringUtil.isEmpty(value.get("appliType")))
		{
			String arrappliType = value.get("appliType").toString();
			String[] appliTypeList = arrappliType.split(",");
			for(String appliType:appliTypeList)
			{
				appliTypes.add(appliType);
			}
		}
		if(appliTypes!=null&&appliTypes.size()>0)
		{
			value.put("appliTypes", appliTypes);
		}
		// 查询权限设置
		HashMap<String, List<String>> map = ScfMessageUtil.transSysParamByKey(ScfBasConstant.QUERY_LIMITS);
		value.putAll(map);
		
		int total = extnrecbcpdao.countBPbcAppliBaseInfoByParam(value);
		Page page = new Page(pageSize, pageNo, total);
		List<BPbcAppliBaseInfoDO> list = extnrecbcpdao.findBPbcAppliBaseInfoByParam(value,page);
		List<BPbcAppliBaseInfoVO> result = new ArrayList<BPbcAppliBaseInfoVO>();
		if(list!=null&&list.size()>0)
		{
			BPbcAppliBaseInfoVO baseInfoVO = null;
			for(BPbcAppliBaseInfoDO baseInfoDO:list)
			{
				baseInfoVO = new BPbcAppliBaseInfoVO();
				BeanUtils.copyProperties(baseInfoDO, baseInfoVO);
				UserInfo userInfo1 = new UserInfo();
				userInfo1.setTlrNo(baseInfoVO.getStartTlrcd());// 搜索创建人对应的名称。
				List<TlrInfoVO> userList = userService.selectByExample(userInfo1);
				if (userList != null && userList.size() == 1) {
					baseInfoVO.setStartTlrNm(userList.get(0).getTlrName());
				}

				// 经办机构brName
				BctlVO bctlVO = new BctlVO();
				bctlVO.setBrNo(baseInfoVO.getStartBrcode());
				List<BctlVO> bctlVOList = orgService.selectByExample(bctlVO);
				if (bctlVOList != null && bctlVOList.size() == 1) {
					baseInfoVO.setStartBrName(bctlVOList.get(0).getBrName());
				}
				result.add(baseInfoVO);
			}
		}
		page.setRecords(result);
		page.setTotalRecord(total);
		return page;
	}
}
