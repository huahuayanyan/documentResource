package com.huateng.scf.adv.qry.service.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huateng.authority.entity.BctlVO;
import com.huateng.authority.inter.service.ScubeUserService;
import com.huateng.base.common.beans.Page;
import com.huateng.scf.adv.qry.dao.IGoodsInHouseQryDAO;
import com.huateng.scf.adv.qry.service.IGoodsInHouseQryService;
import com.huateng.scf.bas.common.util.ScfCommonUtil;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.pbc.service.IBPbcMtgClassService;
import com.huateng.scf.bas.prd.service.IBPrdInfoService;
import com.huateng.scf.bas.sys.service.IBSysCommonService;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

@ScubeService
@Service("GoodsInHouseQryServiceImpl")
public class GoodsInHouseQryServiceImpl implements IGoodsInHouseQryService {
	
	@Resource(name="goodsInHouseQryDAO")
	IGoodsInHouseQryDAO goodsInHouseQryDAO;
	
	@Autowired
	ScubeUserService scubeUserService;
	
	@Resource(name="bSysCommonService")
	IBSysCommonService bSysCommonService;
	
	@Resource(name="bPbcMtgClassService")
	IBPbcMtgClassService bPbcMtgClassService;
	
	@Resource(name="bPrdInfoService")
	IBPrdInfoService bPrdInfoService;

	@Override
	public Page queryGoodsInHouse(int pageNo,int pageSize,Map<String, Object> param) {
		Page page = new Page(pageSize, pageNo, 0);
		
		Object conId = param.get("conId");
		if(!StringUtil.isEmpty(conId)){
			param.put("conId", conId.toString().toLowerCase());
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
		
		bPbcMtgClassService.checkMtgInfo(param.get("One"), param.get("oneName"), "请通过查询按钮选择[押品一级]！");
		bPbcMtgClassService.checkMtgInfo(param.get("Two"), param.get("TwoName"), "请通过查询按钮选择[押品二级]！");
		
		String productId = bPrdInfoService.getProductIdByFlag(param.get("flag").toString());
		param.put("productId", productId);
		
		goodsInHouseQryDAO.queryGoodsInHouse(param, page);
		Iterator<Map<String, Object>> it = page.getRecords().iterator();
		while(it.hasNext()){
			Map<String, Object> map = it.next();
			
			Object brcode = map.get("BR_CD");
			if(!StringUtil.isEmpty(brcode)){
				BctlVO bctl = scubeUserService.selectBctlByBrNo(brcode.toString(),ScfCommonUtil.getBrManagerNo(scubeUserService));
				if(null!=bctl){
					map.put("BRNAME", bctl.getBrName());// 将查询结果赋值于页面创建人代码。
				}
			}
		}
		return page;
	}
	
}
