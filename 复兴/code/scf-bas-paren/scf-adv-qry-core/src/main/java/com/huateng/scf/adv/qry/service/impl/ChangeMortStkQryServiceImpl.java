package com.huateng.scf.adv.qry.service.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.adv.qry.dao.IChangeMortStkQryDAO;
import com.huateng.scf.adv.qry.service.IChangeMortStkQryService;
import com.huateng.scf.bas.common.constant.ScfBasConstant;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.prd.service.IBPrdInfoService;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

@ScubeService
@Service("ChangeMortStkQryServiceImpl")
public class ChangeMortStkQryServiceImpl implements IChangeMortStkQryService {
	
	@Resource(name = "changeMortStkQryDAO")
	private IChangeMortStkQryDAO changeMortStkQryDAO;
	
	@Resource(name = "bPrdInfoService")
	private IBPrdInfoService bPrdInfoService;
	
	@Override
	public Page queryChangeMortByPage(int pageNo, int pageSize, Map<String, Object> param) throws ScubeBizException {
		Page page = new Page(pageSize, pageNo, 0);
		Object slaveContcode = param.get("slaveContno");
		Object flag = param.get("flag");
		if(!StringUtil.isEmpty(slaveContcode)) {
			param.put("slaveContno", slaveContcode.toString().toLowerCase());
		}

		if(!StringUtil.isEmpty(flag)){
			String productId = bPrdInfoService.getProductIdByFlag(param.get("flag").toString());
			param.put("productId", productId);
		}
		
		changeMortStkQryDAO.selectByPage(param, page);
		
		List<Map<String,Object>> list = page.getRecords();
		
		if(list != null && list.size() > 0){
			for (int i = 0; i < list.size(); i++) {
				
				BigDecimal originalQuantity = (list.get(i).get("ORIGINAL_QUANTITY") != null ? (BigDecimal)list.get(i).get("ORIGINAL_QUANTITY") : BigDecimal.ZERO);
				BigDecimal quantity = (list.get(i).get("QUANTITY") != null ? (BigDecimal)list.get(i).get("QUANTITY") : BigDecimal.ZERO);
				if(ScfBasConstant.STOR_OR_DELI_IN.equals(list.get(i).get("STOR_OR_DELI"))){
					list.get(i).put("QUANTITY_AFTER", originalQuantity.add(quantity));
				}else if(ScfBasConstant.STOR_OR_DELI_OUT.equals(list.get(i).get("STOR_OR_DELI"))){
					list.get(i).put("QUANTITY_AFTER", originalQuantity.subtract(quantity));
				}
			}
		}
		return page;
	}
}
