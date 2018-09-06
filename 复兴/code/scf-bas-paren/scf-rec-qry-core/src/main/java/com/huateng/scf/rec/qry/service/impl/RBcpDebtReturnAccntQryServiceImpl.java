package com.huateng.scf.rec.qry.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.RandomUtils;
//import org.apache.commons.lang.math.RandomUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huateng.authority.common.ContextHolder;
import com.huateng.authority.entity.BctlVO;
import com.huateng.authority.entity.UserInfo;
import com.huateng.authority.inter.service.ScubeUserService;
import com.huateng.authority.service.DictionaryService;
import com.huateng.base.common.beans.Page;
import com.huateng.data.model.BdDataDictionary;
import com.huateng.scf.bas.common.constant.ScfBasConstant;
import com.huateng.scf.bas.common.util.ScfCommonUtil;
import com.huateng.scf.rec.bcp.model.DebtBillsInfoVO;
import com.huateng.scf.rec.bcp.model.DebtCommonQryVO;
import com.huateng.scf.rec.bcp.service.IRBcpDebtBaseInfoService;
import com.huateng.scf.rec.qry.service.IRBcpDebtReturnAccntQryService;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

@ScubeService
@Service("RBcpDebtReturnAccntQryServiceImpl")
public class RBcpDebtReturnAccntQryServiceImpl implements IRBcpDebtReturnAccntQryService {

	@Resource(name = "RBcpDebtBaseInfoServiceImpl")
	IRBcpDebtBaseInfoService rBcpDebtBaseInfoService;

	@Autowired
	ScubeUserService scubeUserService;
	
	@Autowired
	DictionaryService dictionaryService;

	@Override
	public Page getDebtReturnAccountPage(DebtCommonQryVO commonQueryVO, int pageNo, int pageSize) throws ScubeBizException {
		String custcdSaller_Q = "";// 卖方号
		String custcdBuyer_Q = ""; // 买方号
		String mastContno = ""; // 买方名称
		String contStatus_Q = "";// 合同状态
		String factType = "";// 保理业务类型
		String bussType_Q = "";// 保理业务类型

		DebtCommonQryVO commonQueryVO2 = new DebtCommonQryVO();
		commonQueryVO2.setCustcdSaller_Q(custcdSaller_Q);
		commonQueryVO2.setCustcdBuyer_Q(custcdBuyer_Q);
		commonQueryVO2.setMastContno(mastContno);
		commonQueryVO2.setContStatus_Q(contStatus_Q);
		commonQueryVO2.setFactType_Q(factType);
		commonQueryVO2.setBussType_Q(bussType_Q);
		
		// 取得应收账款池融资支持业务类型
		BdDataDictionary bdDataDictionary = new BdDataDictionary();
		bdDataDictionary.setDictCode("vidBusTypPool");
		Page p = dictionaryService.select(1, 999, bdDataDictionary);
		List<Map<String, Object>> list = p.getRecords();
		List<String> dataNoTemp = new ArrayList<String>();
		if (list != null && list.size() > 0) {
			int count = list.size();
			for (int i = 0; i < count; i++) {
				Map<String, Object> map = list.get(i);
				dataNoTemp.add(map.get("dataVal").toString());
			}
		}
		commonQueryVO.setBussTypeList_Q(dataNoTemp);
		// commonQueryVO.setFlag_Q(SCFConstants.CUST_QUERY_TYPE_BY_MAA);
		String roleFlag = "0"; // 岗位标志位
		List<String> roleList = ContextHolder.getUserInfo().getRoleList();
		if (roleList != null && roleList.size() > 0) {
			for (int i = 0; i < roleList.size(); i++) {
				Object role = roleList.get(i);
				// 判断方式：当前角色当中包含有除客户经理外的其它岗位，Flag为1
				if (!ScfBasConstant.ROLE_ID_MANAGER.equals(String.valueOf(role))) {
					roleFlag = "1";
					break;
				} else {
					roleFlag = "0";
				}
			}
		}

		if ("0".equals(roleFlag)) {
			commonQueryVO.setFlag(ScfBasConstant.CUST_QUERY_TYPE_BY_MANAGER);
		} else {
			commonQueryVO.setFlag(ScfBasConstant.CUST_QUERY_TYPE_BY_BCTL);
		}
		Page pageQueryResult = new Page(pageSize, pageNo, 0);
		pageQueryResult = rBcpDebtBaseInfoService.getDebtBackActImpInfoQuery(commonQueryVO, pageQueryResult);
		Iterator ite = pageQueryResult.getRecords().iterator();
		List resultList = new ArrayList();
		while (ite.hasNext()) {
			DebtBillsInfoVO debtvo = new DebtBillsInfoVO();
			com.huateng.scf.rec.bcp.dao.model.DebtBillsInfoVO billsInfoVO = (com.huateng.scf.rec.bcp.dao.model.DebtBillsInfoVO) ite.next();
			String mastContno_Getter = billsInfoVO.getMastContno();
			String cnameSeller = billsInfoVO.getCnameSeller();
			String bussType = billsInfoVO.getBussType();
			String returnAccount = billsInfoVO.getReturnAccount();
			String mgrno = (String) billsInfoVO.getMgrno();
			String brcode = (String) billsInfoVO.getBrcode();
			debtvo.setMastContno(mastContno_Getter);
			debtvo.setCnameSeller(cnameSeller);
			debtvo.setBussType(bussType);
			debtvo.setReturnAccount(returnAccount);
			debtvo.setMgrno(mgrno);
			debtvo.setBrcode(brcode);
			debtvo.setTlrNo(billsInfoVO.getTlrNo());
			debtvo.setCustcdSaller(billsInfoVO.getCustcdSaller());
			BctlVO bctlVO = scubeUserService.selectBctlByBrNo(billsInfoVO.getBrcode(), ScfCommonUtil.getBrManagerNo(scubeUserService));
			UserInfo userInfo = scubeUserService.selectUserByTlrNo(billsInfoVO.getTlrNo(), ScfCommonUtil.getBrManagerNo(scubeUserService));
			if (bctlVO != null && StringUtils.isNotEmpty(bctlVO.getBrName())) {
				debtvo.setBrcodeNm(bctlVO.getBrName());
			}
			if (userInfo != null && StringUtils.isNotEmpty(userInfo.getTlrName())) {
				debtvo.setTlrName(userInfo.getTlrName());
			}

			resultList.add(debtvo);
		}
		pageQueryResult.setRecords(resultList);
		return pageQueryResult;
	}

	@Override
	public Page getDebtReturnAccountImpDetail(List<DebtBillsInfoVO> dtsrcList, String returnAccount, String payDatefrom, String payDateto, int pageNo,
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
			List<DebtBillsInfoVO> qrylist = new ArrayList<DebtBillsInfoVO>();
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

	// 这里是回款专户查询，现在是死数据
	@Override
	public Page getReturnAccountImpDtl(String returnAccount, int pageNo, int pageSize) throws ScubeBizException {
		Page pageQueryResult = new Page(pageSize, pageNo, 0);

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
		debtvo5.setReturnDate("20160801");
		debtvo5.setReceiveAmount(new BigDecimal(9779));
		debtvo5.setPayerName("EEEE");
		debtvo5.setPayerAcctNo(" ");
		debtvo5.setPayerBank(" ");
		debtvo5.setMemo("D");
		resultList.add(debtvo5);

		DebtBillsInfoVO debtvo6 = new DebtBillsInfoVO();
		debtvo6.setRepayAccount(returnAccount);
		debtvo6.setReturnDate("20161115");
		debtvo6.setReceiveAmount(new BigDecimal(8773));
		debtvo6.setPayerName("FFFF");
		debtvo6.setPayerAcctNo(" ");
		debtvo6.setPayerBank(" ");
		debtvo6.setMemo("D");
		resultList.add(debtvo6);

		DebtBillsInfoVO debtvo7 = new DebtBillsInfoVO();
		debtvo7.setRepayAccount(returnAccount);
		debtvo7.setReturnDate("20161031");
		debtvo7.setReceiveAmount(new BigDecimal(7562));
		debtvo7.setPayerName("BBB");
		debtvo7.setPayerAcctNo(" ");
		debtvo5.setPayerBank(" ");
		debtvo7.setMemo("D");
		resultList.add(debtvo7);

		List<DebtBillsInfoVO> sublist = new ArrayList<DebtBillsInfoVO>();
		if (returnAccount.equals("20161202")) {
			sublist.add(debtvo1);
			sublist.add(debtvo2);
		}
		if (returnAccount.equals("963123100013")) {
			sublist.add(debtvo3);
			sublist.add(debtvo4);
		}
		if (returnAccount.equals("123456789101112130")) {
			sublist.add(debtvo5);
			sublist.add(debtvo6);
			sublist.add(debtvo7);
		}

		pageQueryResult.setRecords(sublist);
		pageQueryResult.setTotalRecord(sublist.size());

		return pageQueryResult;
	}

}
