package com.huateng.scf.nrec.bcp.service.impl.print;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huateng.authority.entity.BctlVO;
import com.huateng.authority.inter.service.ScubeUserService;
import com.huateng.authority.service.OrgService;
import com.huateng.scf.bas.acc.dao.IBAccAccountInfoDAO;
import com.huateng.scf.bas.acc.dao.model.BAccAccountInfo;
import com.huateng.scf.bas.acc.dao.model.BAccAccountInfoExample;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.crm.dao.IBCrmBaseInfoDAO;
import com.huateng.scf.bas.crm.dao.model.BCrmBaseInfo;
import com.huateng.scf.bas.nte.dao.IBNteNoticeBaseDAO;
import com.huateng.scf.bas.nte.dao.model.BNteNoticeBase;
import com.huateng.scf.bas.nte.dao.model.BNteNoticeBaseExample;
import com.huateng.scf.bas.pbc.model.BPbcAppliBaseInfo;
import com.huateng.scf.bas.pbc.service.IBPbcAppliBaseInfoService;
import com.huateng.scf.bas.prd.dao.IBPrdInfoDAO;
import com.huateng.scf.bas.prd.dao.model.BPrdInfo;
import com.huateng.scf.brp.notice.service.INoticeExportReportService;
import com.huateng.scf.nrec.bcp.service.INRBcpAppliBussDtlService;
import com.huateng.scf.rec.bcp.model.RBcpAppliBussDtl;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * 
 * <p>
 * 应收类业务合同
 * </p>
 *
 * @author mengjiajia
 * @date 2017年6月8日下午3:34:53
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 *            <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2017年6月8日下午3:34:53	     新增
 *
 *            </pre>
 */
@ScubeService
@Service("RBcpTransferPrintServiceImpl")
public class RBcpTransferPrintServiceImpl implements INoticeExportReportService {

	@Resource(name = "BPbcAppliBaseInfoServiceImpl")
	IBPbcAppliBaseInfoService bPbcAppliBaseInfoService;

	@Resource(name = "NRBcpAppliBussDtlServiceImpl")
	INRBcpAppliBussDtlService nRBcpAppliBussDtlService;

	@Resource(name = "BPrdInfoDAO")
	IBPrdInfoDAO bprdinfodao;

	@Resource(name = "BAccAccountInfoDAO")
	IBAccAccountInfoDAO bAccAccountInfoDAO;

	@Resource(name = "IBCrmBaseInfoDAO")
	IBCrmBaseInfoDAO bcrmbaseinfodao;

	// 账户信息
	@Resource(name = "BAccAccountInfoDAO")
	IBAccAccountInfoDAO baccaccountinfodao;

	@Autowired
	ScubeUserService scubeUserService;

	@Autowired
	OrgService orgService;
	
	@Resource(name = "BNteNoticeBaseDAO")
	IBNteNoticeBaseDAO bntenoticebasedao;

	@Override
	public Map<String, Object> getContentMap(Map<String, String> params) throws ScubeBizException {
		String appno = params.get("appno");
		String num = params.get("num");
		String brname = "";
		String mastContno = params.get("mastContno");
		String year = params.get("year");
		// 还差 买卖双方的名称，卖方回款账户，业务品种拼接的合同名称，应收账款总额
		BPbcAppliBaseInfo bPbcAppliBaseInfo = bPbcAppliBaseInfoService.findBPbcAppliBaseInfoByKey(appno);
		BctlVO bctlVO = new BctlVO();
		if (StringUtils.isNotEmpty(bPbcAppliBaseInfo.getAppBrcode())) {
			bctlVO.setBrNo(bPbcAppliBaseInfo.getAppBrcode());
			List<BctlVO> bctlVOList = orgService.selectByExample(bctlVO);
			if (bctlVOList != null && bctlVOList.size() > 0) {
				brname = bctlVOList.get(0).getBrName();// 经办机构
			}
		}
		String custcd = bPbcAppliBaseInfo.getCustcd();
		String supplyChainPdId = bPbcAppliBaseInfo.getSupplyChainPdId();
		String buyerCustcd = bPbcAppliBaseInfo.getMoniCustcd();
		BCrmBaseInfo saller = bcrmbaseinfodao.selectById(custcd);
		String cname = "";
		if (saller != null) {
			cname = saller.getCname();
		}
		BCrmBaseInfo buyer = bcrmbaseinfodao.selectById(buyerCustcd);
		String buyerCname = "";
		if (buyer != null) {
			buyerCname = buyer.getCname();
		}
		BPrdInfo bPrdInfo = bprdinfodao.selectByPrimaryKey(supplyChainPdId);
		String contName = "融资";
		if (bPrdInfo != null) {
			contName = bPrdInfo.getProductName() + contName;
		}
		String day = year.substring(6);// 7.8
		String month = year.substring(4, 6);// 5.6
		year = year.substring(0, 4);// 1234
		year = year + "年" + month + "月" + day + "日";
		BAccAccountInfoExample bAccAccountInfoExample = new BAccAccountInfoExample();
		BAccAccountInfoExample.Criteria criteria = bAccAccountInfoExample.createCriteria();
		criteria.andCustcdEqualTo(custcd);
		criteria.andAccountTypeEqualTo("2");
		List<BAccAccountInfo> bAccAccountInfoList = bAccAccountInfoDAO.selectByExample(bAccAccountInfoExample);
		String accountNo = "";
		if (bAccAccountInfoList != null && bAccAccountInfoList.size() > 0) {
			accountNo = bAccAccountInfoList.get(0).getAccountNo();
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
		showValues.put("num", num);// 合同编号
		showValues.put("cname", cname);// 卖方名称
		showValues.put("buyerCname", buyerCname);// 买方名称
		showValues.put("brname", brname);// 经办机构,是申请基本信息中的经办人
		showValues.put("mastContno", mastContno);// 合同编号
		showValues.put("contName", contName);// 合同名称
		showValues.put("year", year);// 回执日期年月日拼接
		showValues.put("totalRemain", bPbcAppliBaseInfo.getAmt());// 转让金额
		showValues.put("hkcount", accountNo);// 卖方的回款账户
		return showValues;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Collection<?> getIterativeData(Map<String, String> params) throws ScubeBizException {
		String appno = params.get("appno");

		List result = new ArrayList();
		List<RBcpAppliBussDtl> rBcpAppliBussDtlList = nRBcpAppliBussDtlService.queryRBcpAppliBussDtlByAppno(appno);
		if (rBcpAppliBussDtlList != null && rBcpAppliBussDtlList.size() > 0) {
			for (RBcpAppliBussDtl rBcpAppliBussDtl : rBcpAppliBussDtlList) {
				Map map = new HashMap();
				String memo = rBcpAppliBussDtl.getMemo();
				if (StringUtils.isEmpty(memo)) {
					memo = "";
				}
				String debtEnd="";
				if(StringUtils.isNotEmpty(rBcpAppliBussDtl.getDebtEnd())){
					debtEnd=rBcpAppliBussDtl.getDebtEnd();
					String year = debtEnd.substring(0, 4);
					String month = debtEnd.substring(4, 6);
					String day = debtEnd.substring(6, 8);
					debtEnd=year+"-"+month+"-"+day;
				}
				map.put("bussCont", rBcpAppliBussDtl.getBussContcode());
				map.put("billsNo", rBcpAppliBussDtl.getBillsNo());
				map.put("viewAmount", rBcpAppliBussDtl.getBillsAmountView());
				map.put("remainAmount", rBcpAppliBussDtl.getRemainingAmount());
				map.put("debtEnd", debtEnd);
				map.put("memo", memo);
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
