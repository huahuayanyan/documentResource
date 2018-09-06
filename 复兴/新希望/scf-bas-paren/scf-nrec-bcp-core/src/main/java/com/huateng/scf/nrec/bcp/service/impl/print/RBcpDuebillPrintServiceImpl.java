package com.huateng.scf.nrec.bcp.service.impl.print;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.huateng.scf.bas.acc.dao.IBAccAccountInfoDAO;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.prd.dao.IBPrdInfoDAO;
import com.huateng.scf.brp.notice.service.INoticeExportReportService;
import com.huateng.scf.nrec.bcp.model.RBcpDuebillRegisterVO;
import com.huateng.scf.nrec.bcp.service.IRBcpDuebillRegisterService;
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
@Service("RBcpDuebillPrintServiceImpl")
public class RBcpDuebillPrintServiceImpl implements INoticeExportReportService
{
	//出账登记信息
	@Resource(name = "RBcpDuebillRegisterServiceImpl")
	IRBcpDuebillRegisterService rbcpduebillregisterservice;
	
	@Resource(name = "BPrdInfoDAO")
	IBPrdInfoDAO bprdinfodao;
	
	//账户信息
	@Resource(name = "BAccAccountInfoDAO")
	IBAccAccountInfoDAO baccaccountinfodao;
	
	@Override
	public Map<String, Object> getContentMap(Map<String, String> params) throws ScubeBizException
	{
	    String receiveNo = params.get("receiveNo");
	    //出账登记信息
	    RBcpDuebillRegisterVO registerVO = rbcpduebillregisterservice.findRBcpDuebillRegisterByReceiveNo(receiveNo);
	    Map<String, Object> showValues = new HashMap<String, Object>();
//		String productName = bprdinfodao.selectByPrimaryKey(registerVO.getSupplyChainPdId()).getProductName();
		showValues.put("RECEIVE_NO", StringUtil.isEmpty(registerVO.getReceiveNo())?registerVO.getId():registerVO.getReceiveNo());//合同编号
		showValues.put("CNAME", registerVO.getCname());//借款人
		showValues.put("CURCD", "人民币");//币种
		showValues.put("MAST_CONTNO", registerVO.getMastContno());//合同编号
		showValues.put("LN_AMT_CN", registerVO.getLnAmt().toString());//借款金额(大写)
		showValues.put("LN_AMT", registerVO.getLnAmt().toString());//借款金额(小写)
		showValues.put("BL_FEE_RATE", registerVO.getActInt().toString()+"%");//借款利率
		showValues.put("YQ_RATE", registerVO.getYqRate().toString()+"%");//罚息利率
		showValues.put("FEE_RATE", registerVO.getActInt().toString()+"%");//手续费率
		showValues.put("START_DATE", registerVO.getStartDate());//开始日期
		showValues.put("END_DATE", registerVO.getEndDate());//到期日期
		showValues.put("ACCOUNT_NO", registerVO.getAccountNo());//收款账号
		showValues.put("ACCOUNT_NAME", StringUtil.isEmpty(registerVO.getAccountName())?"未填写":registerVO.getAccountName());//收款账号名称
		showValues.put("ACCOUNT_BANK", StringUtil.isEmpty(registerVO.getAccountBank())?"未填写":registerVO.getAccountBank());//收款账号开户行
		showValues.put("PAY_ACT_NO", StringUtil.isEmpty(registerVO.getPayActNo())?"未填写":registerVO.getPayActNo());//放款账户
		showValues.put("PAY_ACT_NAME", StringUtil.isEmpty(registerVO.getPayActName())?"未填写":registerVO.getPayActName());//放款账户名称
		showValues.put("PAY_ACT_BANK", StringUtil.isEmpty(registerVO.getPayActBank())?"未填写":registerVO.getPayActBank());//放款账户开户行
		showValues.put("RETURN_ACCOUNT", registerVO.getReturnAccount());//还款账号
		showValues.put("RETURN_NAME", StringUtil.isEmpty(registerVO.getReturnAccountName())?"未填写":registerVO.getReturnAccountName());//还款账号
		showValues.put("RETURN_BANK", StringUtil.isEmpty(registerVO.getReturnAccountBank())?"未填写":registerVO.getReturnAccountBank());//还款账号
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
