package com.huateng.scf.nrec.bcp.service.impl.print;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huateng.authority.inter.service.ScubeUserService;
import com.huateng.scf.bas.brp.dao.IBBrpIndustryTypesDAO;
import com.huateng.scf.bas.brp.dao.model.BBrpIndustryTypes;
import com.huateng.scf.bas.common.util.ScfCommonUtil;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.crm.dao.IBCrmBaseInfoDAO;
import com.huateng.scf.bas.crm.dao.IBCrmEntInfoDAO;
import com.huateng.scf.bas.crm.dao.IBCrmUpanddownRelDAO;
import com.huateng.scf.bas.crm.dao.model.BCrmBaseInfo;
import com.huateng.scf.bas.crm.dao.model.BCrmEntInfo;
import com.huateng.scf.bas.crm.dao.model.BCrmUpanddownRel;
import com.huateng.scf.bas.crm.dao.model.BCrmUpanddownRelExample;
import com.huateng.scf.bas.prd.dao.IBPrdInfoDAO;
import com.huateng.scf.bas.sys.dao.IBSysRegionDAO;
import com.huateng.scf.bas.sys.dao.model.BSysRegion;
import com.huateng.scf.bas.sys.dao.model.BSysRegionExample;
import com.huateng.scf.brp.notice.service.INoticeExportReportService;
import com.huateng.scf.nrec.bcp.model.BCntBcpAppliBaseInfoVO;
import com.huateng.scf.nrec.bcp.service.IBCntBcpAppliBaseInfoService;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;
/**
 * 
 * <p>尽职调查</p>
 *
 * @author 	mengjiajia
 * @date 	2017年6月7日下午1:28:12
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2017年6月7日下午1:28:12	     新增
 *
 * </pre>
 */
@ScubeService
@Service("BCntBcpAppliPrintServiceImpl")
public class BCntBcpAppliPrintServiceImpl implements INoticeExportReportService
{
	@Resource(name = "BCntBcpAppliBaseInfoServiceImpl")
	IBCntBcpAppliBaseInfoService bcntbcpapplibaseinfoservice;
	
	@Resource(name = "IBCrmBaseInfoDAO")
	IBCrmBaseInfoDAO bcrmbaseinfodao;
	
	@Resource(name = "IBCrmUpanddownRelDAO")
	IBCrmUpanddownRelDAO bcrmupanddownreldao;
	
	@Resource(name = "BPrdInfoDAO")
	IBPrdInfoDAO bprdinfodao;
	
	@Resource(name = "IBCrmEntInfoDAO")
	IBCrmEntInfoDAO bcrmentinfodao;

	@Autowired
	ScubeUserService scubeUserService;
	
	// 用于国际行业代码名称的转译。
	@Resource(name = "BBrpIndustryTypesDAO")
	IBBrpIndustryTypesDAO iBBrpIndustryTypesDAO;

	@Resource(name = "BSysRegionDAO")
	IBSysRegionDAO iBSysRegionDAO;
	
	@Override
	public Map<String, Object> getContentMap(Map<String, String> params) throws ScubeBizException
	{
	    String appno = params.get("appno");
	    String custcd = params.get("custcd");
	    Map<String, Object> showValues = new HashMap<String, Object>();
		BCntBcpAppliBaseInfoVO appliBaseInfoVO = bcntbcpapplibaseinfoservice.findBCntAppliBaseInfoByAppno(appno);
		//客户信息
		BCrmBaseInfo baseInfo = bcrmbaseinfodao.selectById(custcd);
		//客户其它信息
		BCrmEntInfo bCrmEntInfo = bcrmentinfodao.selectByPrimaryKey(custcd);
		if(bCrmEntInfo==null)
		{
			bCrmEntInfo = new BCrmEntInfo();
		}
		//行业分类信息
		if(!StringUtil.isEmpty(bCrmEntInfo.getIndustryType()))
		{
			BBrpIndustryTypes brpIndustryTypes = iBBrpIndustryTypesDAO
					.selectByPrimaryKey(bCrmEntInfo.getIndustryType());
			bCrmEntInfo.setIndustryTypeName(brpIndustryTypes.getIndustryName());
		}
		else
		{
			bCrmEntInfo.setIndustryTypeName("未填写");
		}
		if(!StringUtil.isEmpty(bCrmEntInfo.getArea()))
		{
			BSysRegionExample regionExample = new BSysRegionExample();
			regionExample.createCriteria().andRegionCodeEqualTo(bCrmEntInfo.getArea());
			List<BSysRegion> list = iBSysRegionDAO.selectByExample(regionExample);
			if (list != null && list.size() == 1) {
				bCrmEntInfo.setAreaName(list.get(0).getRegionName());
			}
		}
		else
		{
			bCrmEntInfo.setAreaName("未填写");
		}
		String productName = bprdinfodao.selectByPrimaryKey(appliBaseInfoVO.getSupplyChainPdId()).getProductName();
		showValues.put("PRODUCT_NAME", productName);//业务品种
		showValues.put("CNAME", baseInfo.getCname());//客户名称
		showValues.put("CUSTCD", custcd);//客户号
		String mgrname = scubeUserService.selectUserByTlrNo(appliBaseInfoVO.getAppTlrcd(), ScfCommonUtil.getBrManagerNo(scubeUserService)).getTlrName();
		showValues.put("MGRNO", mgrname);//经办人员
		showValues.put("APP_DATE", appliBaseInfoVO.getAppDate());//调查日期
		showValues.put("REG_ADDR", StringUtil.isEmpty(bCrmEntInfo.getRegAddr())?"未填写":bCrmEntInfo.getRegAddr());//注册地址
		showValues.put("EN_ADDR", StringUtil.isEmpty(bCrmEntInfo.getEnAddr())?"未填写":bCrmEntInfo.getEnAddr());//办公地址
		showValues.put("ENTERPRISE_TYPE", StringUtil.isEmpty(bCrmEntInfo.getEnterpriseType())?"企业":bCrmEntInfo.getEnterpriseType());//企业性质
		showValues.put("INDUSTRY_TYPE", StringUtil.isEmpty(bCrmEntInfo.getIndustryTypeName())?"未填写":bCrmEntInfo.getIndustryTypeName());//行业分类
		showValues.put("REG_CAPITAL", StringUtil.isEmpty(bCrmEntInfo.getRegCapital())?BigDecimal.ZERO:bCrmEntInfo.getRegCapital());//注册资金
		showValues.put("CAPITAL", StringUtil.isEmpty(bCrmEntInfo.getCapital())?StringUtil.isEmpty(bCrmEntInfo.getRegCapital())?BigDecimal.ZERO:bCrmEntInfo.getRegCapital():bCrmEntInfo.getCapital());//实收资金
		String enterpriseScope = bCrmEntInfo.getEnterpriseScope();
		showValues.put("ENTERPRISE_SCOPE", StringUtil.isEmpty(enterpriseScope)?"未填写":enterpriseScope.equals("01")?"大型":enterpriseScope.equals("02")?"中型":enterpriseScope.equals("03")?"小型":enterpriseScope.equals("04")?"微型":"其他");//企业规模
		showValues.put("CREDIT_LEVEL", StringUtil.isEmpty(bCrmEntInfo.getCreditLevel())?"未评定":bCrmEntInfo.getCreditLevel());//信用等级
		showValues.put("LEGAL", StringUtil.isEmpty(bCrmEntInfo.getLegal())?"未填写":bCrmEntInfo.getLegal());//法人代表
		showValues.put("ESTABLISH_DATE", StringUtil.isEmpty(bCrmEntInfo.getEstablishDate())?"未填写":bCrmEntInfo.getEstablishDate());//成立时间
		showValues.put("CREDIT_FLAG", StringUtil.isEmpty(baseInfo.getCreditFlag())?"否":baseInfo.getCreditFlag().equals("1")?"是":"否");//是否授信客户
		showValues.put("CORE_FLAG", StringUtil.isEmpty(baseInfo.getCoreFlag())?"否":baseInfo.getCoreFlag().equals("1")?"是":"否");//是否核心厂商
		showValues.put("MAIN_BUSSINESS", StringUtil.isEmpty(bCrmEntInfo.getMainBussiness())?"未填写":bCrmEntInfo.getMainBussiness());//经营范围
		showValues.put("IS_MARKET_CORP", StringUtil.isEmpty(bCrmEntInfo.getIsMarketCorp())?"否":bCrmEntInfo.getIsMarketCorp().equals("1")?"是":"否");//是否上市公司
		showValues.put("DATE_ADDR", StringUtil.isEmpty(bCrmEntInfo.getAreaName())?"无":bCrmEntInfo.getAreaName()+"/"+bCrmEntInfo.getEstablishDate()==null?"无":bCrmEntInfo.getEstablishDate());//上市地点及日期
		return showValues;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Collection<?> getIterativeData(Map<String, String> params) throws ScubeBizException
	{
        List result=new ArrayList();
		String custcd = params.get("custcd");
		BCrmUpanddownRelExample example = new BCrmUpanddownRelExample();
		BCrmUpanddownRelExample.Criteria cri = example.createCriteria();
		cri.andCoreCustcdEqualTo(custcd);
		List<BCrmUpanddownRel> list = bcrmupanddownreldao.selectByExample(example);
		if(list!=null&&list.size()>0)
		{
			int count = 1;
			for(BCrmUpanddownRel rel:list)
			{
				com.huateng.scf.bas.crm.model.BCrmUpanddownRel crmUpanddownRel = 
						new com.huateng.scf.bas.crm.model.BCrmUpanddownRel();
				BeanUtils.copyProperties(rel, crmUpanddownRel);
				//客户信息
				BCrmBaseInfo baseInfo = bcrmbaseinfodao.selectById(crmUpanddownRel.getCustcd());
				//客户其它信息
				BCrmEntInfo bCrmEntInfo = bcrmentinfodao.selectByPrimaryKey(crmUpanddownRel.getCustcd());
				Map map = new HashMap();
				map.put("CNAME",baseInfo.getCname());
      		  	map.put("INDEX",count);
      		  	map.put("ESTABLISH_DATE",StringUtil.isEmpty(bCrmEntInfo.getEstablishDate())?"未填写":bCrmEntInfo.getEstablishDate());
      		  	map.put("ORG_CODE",baseInfo.getOrgCode());
				map.put("REG_CAPITAL",StringUtil.isEmpty(bCrmEntInfo.getRegCapital())?BigDecimal.ZERO:bCrmEntInfo.getRegCapital());
				map.put("RATE",new BigDecimal(96));
      		  	result.add(map);
      		  	count++;
			}
		}
		else
		{
			Map map = new HashMap();
			map.put("CNAME","无");
  		  	map.put("INDEX",0);
  		  	map.put("ESTABLISH_DATE","无");
  		  	map.put("ORG_CODE","无");
			map.put("REG_CAPITAL",BigDecimal.ZERO);
			map.put("RATE",BigDecimal.ZERO);
  		  	result.add(map);
		}
		return result;
	}

	@Override
	public List<Map<String, Object>> getContentMapMultiRecord(Map<String, String> params) throws ScubeBizException {
		return null;

	}

}
