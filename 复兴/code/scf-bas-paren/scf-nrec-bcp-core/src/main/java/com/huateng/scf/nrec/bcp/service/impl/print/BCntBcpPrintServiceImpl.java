package com.huateng.scf.nrec.bcp.service.impl.print;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huateng.authority.inter.service.ScubeUserService;
import com.huateng.scf.bas.acc.dao.IBAccAccountInfoDAO;
import com.huateng.scf.bas.acc.dao.model.BAccAccountInfo;
import com.huateng.scf.bas.acc.dao.model.BAccAccountInfoExample;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.crm.dao.IBCrmBaseInfoDAO;
import com.huateng.scf.bas.crm.dao.IBCrmEntInfoDAO;
import com.huateng.scf.bas.crm.dao.model.BCrmBaseInfo;
import com.huateng.scf.bas.crm.dao.model.BCrmEntInfo;
import com.huateng.scf.bas.prd.dao.IBPrdInfoDAO;
import com.huateng.scf.brp.notice.service.INoticeExportReportService;
import com.huateng.scf.nrec.bcp.model.BCntBcpExtInfoVO;
import com.huateng.scf.nrec.bcp.model.BCntBcpInfoVO;
import com.huateng.scf.nrec.bcp.service.IBCntBcpExtInfoService;
import com.huateng.scf.nrec.bcp.service.IBCntBcpInfoService;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;
/**
 * 
 * <p>应收类业务合同</p>
 *
 * @author 	mengjiajia
 * @date 	2017年6月8日下午3:34:53
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2017年6月8日下午3:34:53	     新增
 *
 * </pre>
 */
@ScubeService
@Service("BCntBcpPrintServiceImpl")
public class BCntBcpPrintServiceImpl implements INoticeExportReportService
{
	//业务合同
	@Resource(name = "BCntBcpInfoServiceImpl")
	IBCntBcpInfoService bcntbcpinfoservice;
	
	//贸易对手
	@Resource(name = "BCntBcpExtInfoServiceImpl")
	IBCntBcpExtInfoService bcntbcpextinfoservice;
	
	@Resource(name = "IBCrmBaseInfoDAO")
	IBCrmBaseInfoDAO bcrmbaseinfodao;
	
	@Resource(name = "IBCrmEntInfoDAO")
	IBCrmEntInfoDAO bcrmentinfodao;
	
	@Resource(name = "BPrdInfoDAO")
	IBPrdInfoDAO bprdinfodao;
	
	//账户信息
	@Resource(name = "BAccAccountInfoDAO")
	IBAccAccountInfoDAO baccaccountinfodao;
	
	@Autowired
	ScubeUserService scubeUserService;
	
	@Override
	public Map<String, Object> getContentMap(Map<String, String> params) throws ScubeBizException
	{
	    String mastContno = params.get("mastContno");
	    //业务合同信息
	    BCntBcpInfoVO bCntBcpInfoVO = bcntbcpinfoservice.queryBCntBcpInfoByMastContno(mastContno);
	    BCntBcpExtInfoVO bCntBcpExtInfoVO = bcntbcpextinfoservice.queryContDebtExInfoByMastContno(mastContno, null);
	    Map<String, Object> showValues = new HashMap<String, Object>();
		String productName = bprdinfodao.selectByPrimaryKey(bCntBcpInfoVO.getSupplyChainPdId()).getProductName();
		showValues.put("MAST_CONTNO", mastContno);//合同编号
		showValues.put("TITLE_NAME", productName+"业务合同");//标题
		showValues.put("PRODUCT_NAME", productName);//业务品种
		//融资企业
		BCrmBaseInfo baseInfo = bcrmbaseinfodao.selectById(bCntBcpInfoVO.getCustcd());
		//融资企业其它信息
		BCrmEntInfo bCrmEntInfo = bcrmentinfodao.selectByPrimaryKey(bCntBcpInfoVO.getCustcd());
		showValues.put("CNAME", baseInfo.getCname());//卖方名称（融资企业）
		showValues.put("ADDR", bCrmEntInfo.getEnAddr());//地址
		showValues.put("TEL", bCrmEntInfo.getContactTel());//电话
		showValues.put("FAX", StringUtil.isEmpty(bCrmEntInfo.getFax())?"未填写":bCrmEntInfo.getFax());//传真
		showValues.put("LEGAL", StringUtil.isEmpty(bCrmEntInfo.getLegal())?"未填写":bCrmEntInfo.getLegal());//法定代表人
		showValues.put("JOB", "总裁");//传真
		//贸易对手
		BCrmBaseInfo extbaseinfo = bcrmbaseinfodao.selectById(bCntBcpExtInfoVO.getBusinessCustcd());
		//贸易对手其它信息
		BCrmEntInfo extbCrmEntInfo = bcrmentinfodao.selectByPrimaryKey(bCntBcpExtInfoVO.getBusinessCustcd());
		showValues.put("EXT_CNAME", extbaseinfo.getCname());//卖方名称（融资企业）
		showValues.put("EXT_ADDR", extbCrmEntInfo.getEnAddr());//地址
		showValues.put("EXT_TEL", extbCrmEntInfo.getContactTel());//电话
		showValues.put("EXT_FAX", StringUtil.isEmpty(extbCrmEntInfo.getFax())?"未填写":extbCrmEntInfo.getFax());//传真
		showValues.put("EXT_LEGAL", StringUtil.isEmpty(extbCrmEntInfo.getLegal())?"未填写":extbCrmEntInfo.getLegal());//法定代表人
		showValues.put("EXT_JOB", "总裁");//传真
		//回款账号信息
		showValues.put("RETURNACCOUNT", bCntBcpInfoVO.getReturnAccount());//回款账户
		BAccAccountInfoExample example = new BAccAccountInfoExample();
		BAccAccountInfoExample.Criteria cri = example.createCriteria();
		cri.andAccountNoEqualTo(bCntBcpInfoVO.getReturnAccount());
		cri.andAccountTypeEqualTo("2");
		cri.andCustcdEqualTo(bCntBcpInfoVO.getCustcd());
		List<BAccAccountInfo> list2 = baccaccountinfodao.selectByExample(example);
		if(list2!=null&&list2.size()>0)
		{
			BAccAccountInfo accountInfo = list2.get(0);
			showValues.put("RETURNACCTNAME", StringUtil.isEmpty(accountInfo.getAccountName())?"未填写":accountInfo.getAccountName());//回款账户户名
			showValues.put("RETURNACCTBANK", StringUtil.isEmpty(accountInfo.getOpenAccBankNm())?"未填写":accountInfo.getOpenAccBankNm());//开户行
		}
		showValues.put("CONT_AMOUNT", "500000");//保理额度
		showValues.put("AMOUNT", "伍拾万");//大写额度
		//合同基本信息
		String startDate = bCntBcpInfoVO.getStartDate();
		showValues.put("S_YEAR", startDate.substring(0, 4));//年
		showValues.put("S_MON", startDate.substring(4, 6));//月
		showValues.put("S_DAY", startDate.substring(6, 8));//日
		String endDate = bCntBcpInfoVO.getEndDate();
		showValues.put("E_YEAR", endDate.substring(0, 4));//年
		showValues.put("E_MON", endDate.substring(4, 6));//月
		showValues.put("E_DAY", endDate.substring(6, 8));//日
		
		showValues.put("FACT_PATTERN", bCntBcpInfoVO.getFactPattern().equals("1")?"明保理":"暗保理");//保理性质
		return showValues;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Collection<?> getIterativeData(Map<String, String> params) throws ScubeBizException
	{
		Map map=new HashMap();
        List result=new ArrayList();
        map.put("CNAME","无");
		map.put("INDEX","0");
		map.put("ESTABLISH_DATE","无");
		map.put("ORG_CODE","无");
		map.put("REG_CAPITAL","无");
		map.put("RATE","无");
		result.add(map);
		return result;
	}

	@Override
	public List<Map<String, Object>> getContentMapMultiRecord(Map<String, String> params) throws ScubeBizException {
		return null;

	}

}
