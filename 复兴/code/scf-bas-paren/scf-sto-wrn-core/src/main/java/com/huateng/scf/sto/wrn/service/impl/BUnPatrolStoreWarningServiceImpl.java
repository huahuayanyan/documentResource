package com.huateng.scf.sto.wrn.service.impl;

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
import com.huateng.authority.inter.service.ScubeUserService;
import com.huateng.base.common.beans.Page;
import com.huateng.scf.adv.wrn.model.WarnQryVO;
import com.huateng.scf.sto.wrn.model.WarnUnPatrolStoreVO;
import com.huateng.scf.bas.common.util.ScfCommonUtil;
import com.huateng.scf.bas.pbc.dao.IBPbcWhseInspectDAO;
import com.huateng.scf.bas.pbc.dao.impl.BPbcWhseInspectDAOImpl;
import com.huateng.scf.sto.wrn.dao.ext.IBUnPatrolStoreWarningDAO;
import com.huateng.scf.sto.wrn.service.IBUnPatrolStoreWarningService;
import com.huateng.scube.server.annotation.ScubeService;

@ScubeService
@Service(IBUnPatrolStoreWarningService.BeanId)
public class BUnPatrolStoreWarningServiceImpl implements IBUnPatrolStoreWarningService {
	
	@Resource(name=IBUnPatrolStoreWarningDAO.BeanID)
	IBUnPatrolStoreWarningDAO bUnPatrolStoreWarningDAO;
	
	@Autowired
	ScubeUserService scubeUserService;
	
	@Override
	public Page queryUnPatrolStoreWarningByPage(int pageSize, int pageNo, WarnQryVO warnQryVO) {
		Page page = new Page(pageSize, pageNo, 0);
		com.huateng.scf.adv.wrn.dao.model.WarnQryVO warnQryVODal = new com.huateng.scf.adv.wrn.dao.model.WarnQryVO();
		BeanUtils.copyProperties(warnQryVO, warnQryVODal);
		Map<String, Object> params = new HashMap<String, Object>();
		String brattr=ContextHolder.getOrgInfo().getBrAttr();
		params.put("brattr", brattr);
		String brcode=ContextHolder.getOrgInfo().getBrNo();
		params.put("brcode", brcode);
		
		if(StringUtils.isNotBlank(warnQryVO.getWarnNo_Q())){
			params.put("paramId", warnQryVO.getWarnNo_Q());
		}

		if(StringUtils.isNotBlank(warnQryVO.getCname())){
			params.put("cname", warnQryVO.getCname());
		}
		if(StringUtils.isNotBlank(warnQryVO.getMoniName_Q())){
			params.put("moniName", warnQryVO.getMoniName_Q());
		}

		if(StringUtils.isNotBlank(warnQryVO.getSlaveContCode())){
			params.put("slaveContCode", warnQryVO.getSlaveContCode());
		}

		if(StringUtils.isNotBlank(warnQryVO.getStartDate_Q())){
			params.put("startDate", warnQryVO.getStartDate_Q());
		}

		if(StringUtils.isNotBlank(warnQryVO.getEndDate_Q())){
			params.put("endDate", warnQryVO.getEndDate_Q());
		}
		
	
		List<com.huateng.scf.sto.wrn.dao.model.WarnUnPatrolStoreVO> list = bUnPatrolStoreWarningDAO.findUnPatrolStoreWarningByPage(params,page);
		List<WarnUnPatrolStoreVO> records = new ArrayList<WarnUnPatrolStoreVO>();
		WarnUnPatrolStoreVO record = new WarnUnPatrolStoreVO();
		for(com.huateng.scf.sto.wrn.dao.model.WarnUnPatrolStoreVO element:list){
			BeanUtils.copyProperties(element, record);
			if(StringUtils.isNotBlank(record.getBrcode())){
				String brcodeNm = scubeUserService.selectBctlByBrNo(record.getBrcode(), ScfCommonUtil.getBrManagerNo(scubeUserService)).getBrName();
				record.setBrcodeNm(brcodeNm);
			}
			if(StringUtils.isNotBlank(record.getCustManager())){
				String mgrNm = scubeUserService.selectUserByTlrNo(record.getCustManager(), ScfCommonUtil.getBrManagerNo(scubeUserService)).getTlrName();
				record.setMgrNm(mgrNm);
			}
			if(StringUtils.isNotBlank(record.getSlaveContcode())){
				String lastDate=bUnPatrolStoreWarningDAO.getLastAppDateInWhseInspect(params);
				record.setLastDate(lastDate);
			}
			records.add(record);
		}
		Integer count = bUnPatrolStoreWarningDAO.countUnPatrolStoreWarning(params);
		page.setRecords(records);
		page.setTotalRecord(count);
		return page; 
	}

}
