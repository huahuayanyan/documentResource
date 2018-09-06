package com.huateng.scf.bas.crm.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.crm.dao.IBCrmCustomerDAO;
import com.huateng.scf.bas.crm.model.BCrmBaseInfo;
import com.huateng.scf.bas.crm.model.CustomerQryVO;
import com.huateng.scf.bas.crm.service.IBCrmCustomerService;
import com.huateng.scube.server.annotation.ScubeService;

@ScubeService
@Service("BCrmCustomerServiceImpl")
public class BCrmCustomerServiceImpl implements IBCrmCustomerService {
	
	@Resource(name="IBCrmCustomerDAO")
	private IBCrmCustomerDAO bCrmCustomerDAO;
	
	@Override
	public Page findFactorCustRelationPageByCust(CustomerQryVO customerQryVO,int pageNo,int pageSize) {
		
		Map<String, Object> params = new HashMap<String, Object>();
		
		if(StringUtils.isNotEmpty(customerQryVO.getCustcd())){
			params.put("custcd", customerQryVO.getCustcd());
		}
		if(StringUtils.isNotEmpty(customerQryVO.getOtherCustcd_Q())){
			params.put("otherCustcd", customerQryVO.getOtherCustcd_Q());
		}
		if(StringUtils.isNotEmpty(customerQryVO.getOtherCname_Q())){
			params.put("otherCname", customerQryVO.getOtherCname_Q());
		}
		
//		params.put("distinct", true);
		
		List<com.huateng.scf.bas.crm.dao.model.BCrmBaseInfo> querylist = bCrmCustomerDAO.queryContDebtInfoByBuyercustcd(params,pageNo,pageSize);
		
		List<BCrmBaseInfo> responseList = new ArrayList<BCrmBaseInfo>();
		BCrmBaseInfo element = new BCrmBaseInfo();
		if(querylist!=null&&querylist.size()>0){
			
			for(int i=0;i<querylist.size();i++){
				
				com.huateng.scf.bas.crm.dao.model.BCrmBaseInfo baseinfo=querylist.get(i);
				BeanUtils.copyProperties(baseinfo, element);
				
				if(responseList.size()==0){
					responseList.add(element);
				}
				boolean flag = true;
				if(responseList.size()>0){
					for(int j=0;j<responseList.size();j++){
						BCrmBaseInfo responsElement =responseList.get(j);
						if(responsElement.getCustcd()==element.getCustcd()){
							flag = false;
						}
					}
					if(flag){
						responseList.add(element);
					}
				}
				
			}
			
			
		}
		
		Page page = new Page(pageSize, pageNo, 0);
		page.setRecords(responseList);
		int count = bCrmCustomerDAO.queryContDebtCountByBuyercustcd(params);
		page.setTotalRecord(count);
		
		return page;
	}

	@Override
	public Page findFlcCustomerPage(CustomerQryVO customerQryVO, int pageNo, int pageSize) {
		Map<String, Object> params = new HashMap<String, Object>();
		Page page = new Page(pageSize, pageNo, 0);
		
		if(StringUtils.isNotBlank(customerQryVO.getCustno_Q())){
			params.put("custno_Q", customerQryVO.getCustno_Q());
		}
		
		if(StringUtils.isNotBlank(customerQryVO.getCname_Q())){
			params.put("cname_Q", customerQryVO.getCname_Q());
		}
		
		if(StringUtils.isNotBlank(customerQryVO.getCustStatus_Q())){
			params.put("custStatus_Q", customerQryVO.getCustStatus_Q());
		}
		List records = bCrmCustomerDAO.selectFlcCustomerListByPage(params,page);
		int totalRecord = bCrmCustomerDAO.selectFlcCustomerCount(params);
		page.setRecords(records);
		page.setTotalRecord(totalRecord);
		
		return page;
	}

}
