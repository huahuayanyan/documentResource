package com.huateng.scf.adv.wrn.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huateng.authority.common.ContextHolder;
import com.huateng.authority.entity.BctlVO;
import com.huateng.authority.entity.UserInfo;
import com.huateng.authority.inter.service.ScubeUserService;
import com.huateng.base.common.beans.Page;
import com.huateng.scf.adv.wrn.dao.IBCheckStockWarnDAO;
import com.huateng.scf.adv.wrn.dao.model.BWanCheckStock;
import com.huateng.scf.adv.wrn.model.WarnQryVO;
import com.huateng.scf.adv.wrn.service.IBCheckStockWarnService;
import com.huateng.scf.bas.common.util.ScfCommonUtil;
import com.huateng.scf.bas.prd.dao.IBPrdInfoDAO;
import com.huateng.scf.bas.prd.dao.model.BPrdInfo;
import com.huateng.scube.server.annotation.ScubeService;

@ScubeService
@Service(IBCheckStockWarnService.BeanId)
public class BCheckStockWarnServiceImpl implements IBCheckStockWarnService {
	@Resource(name=IBCheckStockWarnDAO.BeanId)
	IBCheckStockWarnDAO bCheckStockWarnDAO;
	
	@Resource(name="BPrdInfoDAO")
	IBPrdInfoDAO bPrdInfoDAO; 
	
	@Autowired
	ScubeUserService scubeUserService;
	@Override
	public Page queryCheckStockWarnByPage(WarnQryVO warnQryVO,int pageNo, int pageSize) {
		Page page = new Page(pageSize, pageNo, 0);
		Map<String, Object> params = new HashMap<String, Object>();
		if(StringUtils.isNotBlank(warnQryVO.getWarnNo_Q())){
			params.put("paramId", warnQryVO.getWarnNo_Q());
		}
		if(StringUtils.isNotBlank(warnQryVO.getCname_Q())){
			params.put("cname", warnQryVO.getCname_Q());
		}
		if(StringUtils.isNotBlank(warnQryVO.getSlaveContcode_Q())){
			params.put("slaveContcode", warnQryVO.getSlaveContcode_Q());
		}
		if(StringUtils.isNotBlank(warnQryVO.getMoniName_Q())){
			params.put("moniCame", warnQryVO.getMoniName_Q());
		}
		if(StringUtils.isNotBlank(warnQryVO.getCheckType_Q())){
			params.put("checkType", warnQryVO.getCheckType_Q());
		}
		if(StringUtils.isNotBlank(warnQryVO.getCustcd())){
			params.put("custcd", warnQryVO.getCustcd());
		}
		
		String brattr = ContextHolder.getOrgInfo().getBrAttr();
		params.put("brattr", brattr);
		
		String brcode = ContextHolder.getOrgInfo().getBrNo();
		params.put("brcode", brcode);
		
		List<com.huateng.scf.adv.wrn.dao.model.BWanCheckStockVO> list =bCheckStockWarnDAO.findCheckStockWarnByPage(params,page);
		Integer count = bCheckStockWarnDAO.findCheckStockWarnCount(params);
		List<BWanCheckStockVO> responses = new ArrayList<BWanCheckStockVO>();
		BWanCheckStockVO responseVO = null;
		for(BWanCheckStock warnCheckStock:list){
			responseVO = new BWanCheckStockVO();
			BeanUtils.copyProperties(warnCheckStock, responseVO);
			if(StringUtils.isNotBlank(responseVO.getCustManager())){
				UserInfo userInfo = scubeUserService.selectUserByTlrNo(responseVO.getCustManager(), ScfCommonUtil.getBrManagerNo(scubeUserService));
				String mgrNm=userInfo.getTlrName();
				responseVO.setMgrNm(mgrNm);
				BctlVO bctlVO = scubeUserService.selectBctlByBrNo(responseVO.getBrcode(), ScfCommonUtil.getBrManagerNo(scubeUserService));
				String brNm = bctlVO.getBrName();
				responseVO.setBrcodeNm(brNm);
				
				BPrdInfo bPrdInfo = bPrdInfoDAO.selectByPrimaryKey(responseVO.getProductId());
				responseVO.setProductNm(bPrdInfo.getProductName());
			}
			responses.add(responseVO);
		}
		
		page.setTotalRecord(count);
		page.setRecords(responses);
		
		return page;
	}

}
