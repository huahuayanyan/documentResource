package com.huateng.scf.nrec.bcp.service.impl.print;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huateng.authority.entity.BctlVO;
import com.huateng.authority.inter.service.ScubeUserService;
import com.huateng.scf.bas.acc.dao.IBAccAccountInfoDAO;
import com.huateng.scf.bas.acc.dao.model.BAccAccountInfo;
import com.huateng.scf.bas.acc.dao.model.BAccAccountInfoExample;
import com.huateng.scf.bas.common.util.ScfCommonUtil;
import com.huateng.scf.bas.common.util.ScfDateUtil;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.crm.dao.IBCrmBaseInfoDAO;
import com.huateng.scf.bas.nte.dao.IBNteNoticeBaseDAO;
import com.huateng.scf.bas.nte.dao.model.BNteNoticeBase;
import com.huateng.scf.bas.nte.dao.model.BNteNoticeBaseExample;
import com.huateng.scf.bas.pbc.dao.IBPbcAppliBaseInfoDAO;
import com.huateng.scf.bas.pbc.dao.model.BPbcAppliBaseInfo;
import com.huateng.scf.bas.prd.dao.IBPrdInfoDAO;
import com.huateng.scf.brp.notice.service.INoticeExportReportService;
import com.huateng.scf.nrec.bcp.dao.IBCntBcpInfoDAO;
import com.huateng.scf.nrec.bcp.dao.model.BCntBcpInfo;
import com.huateng.scf.nrec.bcp.service.INRBcpAppliBussDtlService;
import com.huateng.scf.rec.bcp.model.RBcpAppliBussDtl;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * 
 * <p>应收类催收、提示付款</p>
 *
 * @author 	mengjiajia
 * @date 	2017年6月23日下午1:25:35
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2017年6月23日下午1:25:35	     新增
 *
 * </pre>
 */
@ScubeService
@Service("RDebtPressPrintServiceImpl")
public class RDebtPressPrintServiceImpl implements INoticeExportReportService
{
	@Resource(name = "BPbcAppliBaseInfoDAO")
	IBPbcAppliBaseInfoDAO bpbcapplibaseinfodao;
	
	@Resource(name = "NRBcpAppliBussDtlServiceImpl")
	INRBcpAppliBussDtlService nrbcpapplibussdtlservice;

	@Resource(name = "IBCrmBaseInfoDAO")
	IBCrmBaseInfoDAO bcrmbaseinfodao;
	
	@Resource(name = "IBCntBcpInfoDAO")
	IBCntBcpInfoDAO bcntbcpinfodao;
	
	//账户信息
	@Resource(name = "BAccAccountInfoDAO")
	IBAccAccountInfoDAO baccaccountinfodao;
	
	@Autowired
	ScubeUserService scubeUserService;
	
	@Resource(name = "BPrdInfoDAO")
	IBPrdInfoDAO bprdinfodao;
	
	@Resource(name = "BNteNoticeBaseDAO")
	IBNteNoticeBaseDAO bntenoticebasedao;
	
	@Override
	public Map<String, Object> getContentMap(Map<String, String> params) throws ScubeBizException {
		String num = params.get("num");//通知书编号
		String appno = params.get("appno");
		String mastContno = params.get("mastContno");//合同编号
		BPbcAppliBaseInfo appliBaseInfo = bpbcapplibaseinfodao.selectByPrimaryKey(appno);
		String cname = bcrmbaseinfodao.selectById(appliBaseInfo.getCustcd()).getCname();//买方名称
		String businessCname = bcrmbaseinfodao.selectById(appliBaseInfo.getMoniCustcd()).getCname();//买方名称
		String productName = bprdinfodao.selectByPrimaryKey(appliBaseInfo.getSupplyChainPdId()).getProductName();
		//合同信息
		BCntBcpInfo bCntBcpInfo = bcntbcpinfodao.selectByPrimaryKey(mastContno);
		String endDate = bCntBcpInfo.getEndDate();
		String endYear = endDate.substring(0, 4);
		String endMon = endDate.substring(4, 6);
		String endDay = endDate.substring(6, 8);
		String brno = bCntBcpInfo.getBrcode();
		BctlVO br = scubeUserService.selectBctlByBrNo(brno, ScfCommonUtil.getBrManagerNo(scubeUserService));
		String brname = "";
		if(br!=null)
		{
			brname = br.getBrName();
		}
		//账户信息
		BAccAccountInfoExample example1 = new BAccAccountInfoExample();
		BAccAccountInfoExample.Criteria cri = example1.createCriteria();
		//结算账号、收款账号信息
		cri.andAccountTypeEqualTo("1");
		cri.andCustcdEqualTo(appliBaseInfo.getCustcd());
		List<BAccAccountInfo> list1 = baccaccountinfodao.selectByExample(example1);
		String accountNo = "";
		String accountName = "";
		if(list1!=null&&list1.size()>0)
		{
			BAccAccountInfo accountInfo = list1.get(0);
			accountNo = accountInfo.getAccountNo();
			accountName = accountInfo.getAccountName();
		}
		
		if(StringUtil.isEmpty(num))
		{
			BNteNoticeBaseExample example = new BNteNoticeBaseExample();
			BNteNoticeBaseExample.Criteria crin = example.createCriteria();
			crin.andAppnoEqualTo(appno);
			List<BNteNoticeBase> list = bntenoticebasedao.selectByExample(example);
			if(list!=null&&list.size()>0)
			{
				BNteNoticeBase base = list.get(0);
				num = base.getNum();
			}
		}
		
		Map<String, Object> showValues = new HashMap<String, Object>();
		showValues.put("NUM", num);//通知书编号
		showValues.put("CNAME", cname);//卖方名称
		showValues.put("BUSINESS_CNAME", businessCname);//买方名称
		showValues.put("END_YEAR", endYear);//年
		showValues.put("END_MON", endMon);//月
		showValues.put("END_DAY", endDay);//日
		showValues.put("ACCOUNT_NO", accountNo);//帐号
		showValues.put("ACCOUNT_NAME", accountName);//帐号名称
		showValues.put("MAST_CONTNO", mastContno);//合同编号
		showValues.put("BANK_NAME", brname);//银行信息（保理商使用则需另外获取）
		showValues.put("PRODUCT_NAME", productName);//产品名称
		return showValues;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Collection<?> getIterativeData(Map<String, String> params) throws ScubeBizException {
		List result=new ArrayList();
		String appno = params.get("appno");
		List<RBcpAppliBussDtl> list = nrbcpapplibussdtlservice.queryRBcpAppliBussDtlByAppno(appno);
		if(list==null||list.size()==0)
		{
			Map map = new HashMap();
			map.put("BUSS_CONTCODE"," ");
  		  	map.put("BILLS_NO"," ");
  		  	map.put("BILLS_AMOUNT_VIEW",BigDecimal.ZERO);
			map.put("REMAINING_AMOUNT",BigDecimal.ZERO);
			map.put("DEBT_END"," ");
			map.put("MEMO"," ");
  		  	result.add(map);
		}
		else
		{
			for(RBcpAppliBussDtl dtl:list)
			{
				Map map = new HashMap();
				map.put("BUSS_CONTCODE",dtl.getBussContcode());
	  		  	map.put("BILLS_NO",dtl.getBillsNo());
	  		  	map.put("BILLS_AMOUNT_VIEW",dtl.getBillsAmountView());
				map.put("REMAINING_AMOUNT",dtl.getRemainingAmount());
				String debtEnd = dtl.getDebtEnd();
				Date date = ScfDateUtil.numberToDate(debtEnd);
				debtEnd = ScfDateUtil.formatDate(date, ScfDateUtil.DATE_FORMAT_FULL);
				debtEnd = debtEnd.substring(0, debtEnd.indexOf(" "));
				map.put("DEBT_END",debtEnd);
				map.put("MEMO",StringUtil.isEmpty(dtl.getMemo())?" ":dtl.getMemo());
	  		  	result.add(map);
			}
		}
		return result;
	}

	@Override
	public List<Map<String, Object>> getContentMapMultiRecord(Map<String, String> params) throws ScubeBizException {
		return null;
	}

}
