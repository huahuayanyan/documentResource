package com.huateng.scf.bas.com.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.acc.service.IBAccAccountInfoService;
import com.huateng.scf.bas.common.constant.ScfBasConstant;
import com.huateng.scf.bas.common.model.CostQryVO;
import com.huateng.scf.bas.common.model.CustAccountQryVO;
import com.huateng.scf.bas.common.service.ICostService;
import com.huateng.scf.bas.common.service.ICostledgerQueryService;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.mrn.service.IContractService;
import com.huateng.scf.rec.bcp.model.DebtCommonQryVO;
import com.huateng.scf.rec.bcp.model.RBcpCostOut;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * 
 * <p>费用信息管理接口实现类</p>
 *
 * @author 	mengjiajia
 * @date 	2017年2月17日上午9:05:18
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2017年2月17日上午9:05:18	     新增
 *
 * </pre>
 */
@ScubeService
@Service("CostledgerQueryServiceImpl")
public class CostledgerQueryServiceImpl implements ICostledgerQueryService {
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@Resource(name = "CostServiceImpl")
	ICostService costservice;
	
	@Resource(name = "ContractServiceImpl")
	IContractService contractservice;
	
	@Resource(name = "IBAccAccountInfoServiceImpl")
	IBAccAccountInfoService baccaccountinfoservice;
	
	@Override
	public Page CostledgerQueryGetter(int pageNo, int pageSize, CostQryVO costQryVO) throws ScubeBizException {
		log.debug("费用信息查询开始==================");
		costQryVO.setPageIndex(pageNo);
		costQryVO.setPageSize(pageSize);
		Page pageQueryResult = costservice.queryTblCostOut(costQryVO);
		log.debug("费用信息查询结束==================");
		return pageQueryResult;
    }
	
	@Override
	public HashMap<String, String> addCostOut() throws ScubeBizException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		String flowNo = sdf.format(new Date());
		HashMap<String, String> bcpCostOut = new HashMap<String, String>();
		bcpCostOut.put("txFlowNo","F"+flowNo);
		bcpCostOut.put("costName", "保理手续费");
		bcpCostOut.put("costClass", "1");
		bcpCostOut.put("costType", "1");
		bcpCostOut.put("costCalcType", "2");
		bcpCostOut.put("chargeClass", "2");
		return bcpCostOut;
	}

	/**
	 * 根据客户好筛选保理合同信息
	 */
	@Override
	public Page DebtContDropDownGetter(int pageNo, int pageSize, HashMap<String, String> value) throws ScubeBizException
	{
		String bussContno = value.get("bussContno");
		String custcd = value.get("custcd");
		if(StringUtil.isEmpty(custcd))
		{
			throw new ScubeBizException("请选择客户！");
		}
		DebtCommonQryVO commonQueryVO = new DebtCommonQryVO();
		commonQueryVO.setBussContno(bussContno);
		commonQueryVO.setCustcd(custcd);
		commonQueryVO.setPageIndex(pageNo);
		commonQueryVO.setPageSize(pageSize);
		Page pageQueryResult = contractservice.getTblContDebtInfoList(commonQueryVO);
		return pageQueryResult;
	}
	
	/**
	 * 根据客户号等信息查询结算帐号
	 * @param pageNo
	 * @param pageSize
	 * @param value
	 * @return
	 * @throws ScubeBizException
	 */
	@Override
	public Page AccountDropDownSelectGetter(int pageNo, int pageSize, HashMap<String, String> value) throws ScubeBizException
	{
		String costAccount = value.get("costAccount");
		String custcd = value.get("custcd");
		if(StringUtil.isEmpty(custcd))
		{
			throw new ScubeBizException("请选择客户！");
		}
		String accountType = ScfBasConstant.ACCOUNT_TYPE_BALANCE;
		CustAccountQryVO custAccountQryVO = new CustAccountQryVO();
		custAccountQryVO.setAccountNo_Q(costAccount);
		custAccountQryVO.setCustcd(custcd);
		custAccountQryVO.setAccountType_Q(accountType);
		Page page = baccaccountinfoservice.getCustAccountListByParam(custAccountQryVO);
		return page;
	}
	
	/**
	 * 保存补录的费用信息
	 * @param bcpCostOut
	 * @throws ScubeBizException
	 */
	@Override
	public void CostInfoRecordUpdate(RBcpCostOut bcpCostOut) throws ScubeBizException
	{
		bcpCostOut.setCostCode("1001");
		costservice.saveTblCostOut(bcpCostOut);
	}
}
