package com.huateng.scf.adv.qry.service.impl;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huateng.authority.entity.BctlVO;
import com.huateng.authority.inter.service.ScubeUserService;
import com.huateng.authority.service.DictionaryService;
import com.huateng.authority.service.OrgService;
import com.huateng.authority.service.UserService;
import com.huateng.base.common.beans.Page;
import com.huateng.data.model.BdDataDictionary;
import com.huateng.scf.adv.qry.dao.IMortgageInoutInfoDAO;
import com.huateng.scf.adv.qry.service.IMortgageInoutService;
import com.huateng.scf.bas.common.constant.ScfBasConstant;
import com.huateng.scf.bas.common.util.ScfCommonUtil;
import com.huateng.scf.bas.common.util.ScfDateUtil;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.prd.service.IBPrdInfoService;
import com.huateng.scf.bas.sys.service.IBSysCommonService;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

@ScubeService
@Service("MortgageInoutServiceImpl")
public class MortgageInoutServiceImpl implements IMortgageInoutService {
	
	@Resource(name = "scubeUserService")
	ScubeUserService scubeUserService;
	
	@Resource(name = "mortgageInoutInfoDAO")
	private IMortgageInoutInfoDAO mortgageInoutInfoDAO;
	
	@Resource(name = "userService")
	private UserService userService;
	
	// 机构
	@Resource(name = "BSysCommonServiceImpl")
	IBSysCommonService bSysCommonService;
	
	@Resource(name = "orgService")
	OrgService orgService;
	
	@Resource(name = "bPrdInfoService")
	IBPrdInfoService bPrdInfoService;
	
	@Autowired
	DictionaryService dictionaryService;
	
	@Override
	public Page queryMortgageInoutByPage(int pageNo, int pageSize, Map<String, Object> param) throws ScubeBizException {
		Page page = new Page(pageSize, pageNo, 0);
		Object slaveContcode = param.get("slaveContcode");
		Object bussTypes = param.get("bussType");
		if(!StringUtil.isEmpty(slaveContcode)) {
			param.put("slaveContcode", slaveContcode.toString().toLowerCase());
		}
		
		if(param.get("brCode") != null && param.get("brName") != null){
			BctlVO bctlVO = new BctlVO();
			bctlVO.setBrNo(param.get("brCode") == null ? null : param.get("brCode").toString());
			bctlVO.setBrName(param.get("brName") == null ? null : param.get("brName").toString());
			Page cooperationBrcodeInfo = bSysCommonService.selectBranchInfo(1, 10, bctlVO);
			List records = cooperationBrcodeInfo.getRecords();
			if (records == null || records.size() != 1) {
				throw new ScubeBizException("经办机构名称与经办机构号不对应,请通过查询按钮选择[经办机构]！");
			}
		}
		
		if(StringUtil.isEmpty(bussTypes)){
			BdDataDictionary bdDataDictionary = new BdDataDictionary();
			bdDataDictionary.setDictCode("mortgageBizType");
			Page p = dictionaryService.select(1, 10, bdDataDictionary);
			List<Map<String, Object>> list = p.getRecords();
			List<String> dataNoTemp = new ArrayList<String>();
			if(list!=null && list.size() > 0){
				int count = list.size();
				for(int i=0;i<count;i++){
					Map<String, Object> map = list.get(i); 
					dataNoTemp.add(map.get("dataVal").toString());
				}
			}
			param.put("bussTypes", dataNoTemp);
		}else{
			String[] s = {bussTypes.toString()};
			param.put("bussTypes", s);
		}
		
		String productId = bPrdInfoService.getProductIdByFlag(param.get("flag").toString());
		param.put("productId", productId);
		
		mortgageInoutInfoDAO.selectByPage(param, page);
		List<Map<String,Object>> list = page.getRecords();
		if(list != null && list.size() > 0){
			for (int i = 0; i < list.size(); i++) {
				String bussType = list.get(i).get("MORTGAGE_BIZ_TYPE") == null ? null : list.get(i).get("MORTGAGE_BIZ_TYPE").toString();
				BigDecimal quantity = list.get(i).get("QUANTITY") == null ? BigDecimal.ZERO : (BigDecimal)list.get(i).get("QUANTITY");
				
				BigDecimal origanquantity=list.get(i).get("ORIGINAL_QUANTITY")==null?BigDecimal.ZERO:(BigDecimal)list.get(i).get("ORIGINAL_QUANTITY");
				list.get(i).put("QUANTITY", origanquantity);
				list.get(i).put("TOT_PRICE",origanquantity.multiply(list.get(i).get("CONFIRM_PRICE") == null ? BigDecimal.ZERO : (BigDecimal)list.get(i).get("CONFIRM_PRICE")));
				if(!StringUtil.isStrEmpty(bussType)){
					bussType=bussType.substring(2, 4);
					if(ScfBasConstant.STOR_OR_DELI_IN.equals(bussType)){
						list.get(i).put("INQUANTITY", quantity);
						list.get(i).put("OUTQUANTITY", BigDecimal.ZERO);
					}else if(ScfBasConstant.STOR_OR_DELI_OUT.equals(bussType)){
						list.get(i).put("INQUANTITY", BigDecimal.ZERO);
						list.get(i).put("OUTQUANTITY", quantity);
					}
				}
				
				Object brcode = list.get(i).get("BRCODE");
				if(!StringUtil.isEmpty(brcode)){
					BctlVO bctl = scubeUserService.selectBctlByBrNo(brcode.toString(),ScfCommonUtil.getBrManagerNo(scubeUserService));
					if(null!=bctl){
						list.get(i).put("BRNAME", bctl.getBrName());// 将查询结果赋值于页面创建人代码。
					}
				}
				
				Object lastUpdTime = list.get(i).get("LAST_UPD_TIME");
				if(lastUpdTime != null){
					list.get(i).put("LAST_UPD_TIME", ScfDateUtil.formatDate((Date)lastUpdTime));
				}
			}
		}
		return page;
	}
	@Override
	public Page selectOrg(int pageNo, int pageSize, BctlVO bctlVO) {
		return orgService.select(pageNo, 10, bctlVO);
	}
}
