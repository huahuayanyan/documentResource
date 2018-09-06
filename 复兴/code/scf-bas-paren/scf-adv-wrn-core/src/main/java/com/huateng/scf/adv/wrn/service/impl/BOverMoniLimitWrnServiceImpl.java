package com.huateng.scf.adv.wrn.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.huateng.authority.common.ContextHolder;
import com.huateng.base.common.beans.Page;
import com.huateng.scf.adv.wrn.dao.IBOverMoniLimitWrnDAO;
import com.huateng.scf.adv.wrn.service.IBOverMoniLimitWrnService;
import com.huateng.scf.sto.wrn.model.DownLowPriceNewQryVO;
import com.huateng.scube.server.annotation.ScubeService;


/**
 * @author htrad0055
 *	查询突破监管限额预警列表
 */
@ScubeService
@Service(IBOverMoniLimitWrnService.BeanId)
public class BOverMoniLimitWrnServiceImpl implements IBOverMoniLimitWrnService {
	
	@Resource(name=IBOverMoniLimitWrnDAO.BeanId)
	IBOverMoniLimitWrnDAO bOverMoniLimitWrnDAO;
	
	@SuppressWarnings("rawtypes")
	@Override
	public Page queryOverMoniLimitWrnByPage(int pageNo, int pageSize, DownLowPriceNewQryVO downLowPriceNewQryVO) {
		Page page = new Page(pageSize, pageNo, 0);
		Map<String, Object> params = new HashMap<String, Object>();
//		params.put("brcode", ContextHolder.getOrgInfo().getBrNo());
		params.put("brattr", ContextHolder.getOrgInfo().getBrAttr());
		
		if(StringUtils.isNotBlank(downLowPriceNewQryVO.getMoniCname_Q())){
			params.put("moniCname", downLowPriceNewQryVO.getMoniCname_Q());
		}
		if(StringUtils.isNotBlank(downLowPriceNewQryVO.getStartDate_Q())){
			params.put("startDate", downLowPriceNewQryVO.getStartDate_Q());
		}
		if(StringUtils.isNotBlank(downLowPriceNewQryVO.getEndDate_Q())){
			params.put("endDate", downLowPriceNewQryVO.getEndDate_Q());
		}
		if(StringUtils.isNotBlank(downLowPriceNewQryVO.getWarnNo_Q())){
			params.put("warnNo", downLowPriceNewQryVO.getWarnNo_Q());
		}
		
		List records = bOverMoniLimitWrnDAO.findOverMoniLimitWrnListByPage(params,page);
		
		Integer totalRecord = bOverMoniLimitWrnDAO.findOverMoniLimitWrnCount(params);
		page.setRecords(records);
		page.setTotalRecord(totalRecord);
		return page;
	}

}
