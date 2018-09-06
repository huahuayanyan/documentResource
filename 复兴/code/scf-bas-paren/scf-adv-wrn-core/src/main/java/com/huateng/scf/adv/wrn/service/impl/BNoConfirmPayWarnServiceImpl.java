package com.huateng.scf.adv.wrn.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.huateng.authority.common.ContextHolder;
import com.huateng.base.common.beans.Page;
import com.huateng.scf.adv.wrn.dao.IBNoConfirmPayWarnDAO;
import com.huateng.scf.adv.wrn.model.ThreeNoConfirmPayWarnVO;
import com.huateng.scf.adv.wrn.model.WarnQryVO;
import com.huateng.scf.adv.wrn.service.IBNoConfirmPayWarnService;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * @author htrad0055 未收款确认预警
 *
 */
@ScubeService
@Service(IBNoConfirmPayWarnService.BeanId)
public class BNoConfirmPayWarnServiceImpl implements IBNoConfirmPayWarnService {
	@Resource(name = IBNoConfirmPayWarnDAO.BeanId)
	IBNoConfirmPayWarnDAO bConfirmPayWarnDAO;

	public static final String WAREHOUSE_TYPE = "1210020";

	/**
	 * 未收款确认预警分页查询
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Page findNoConfirmPayWarnByPage( int pageNo, int pageSize, WarnQryVO warnQryVO) {
		String productId = this.WAREHOUSE_TYPE;
		Map<String, Object> params = new HashMap<String, Object>();
		String brattr=ContextHolder.getOrgInfo().getBrAttr();
		params.put("brattr", brattr);
		String brcode = ContextHolder.getOrgInfo().getBrNo();
		params.put("brcode", brcode );
		params.put("productId", productId);
		if (StringUtils.isNotBlank(warnQryVO.getWarnLevel_Q())) {
			params.put("warnLevel", warnQryVO.getWarnLevel_Q());
		}
		if (StringUtils.isNotBlank(warnQryVO.getWarehouseType())) {
			params.put("warehouseType", warnQryVO.getWarehouseType());
		}
		if (StringUtils.isNotBlank(warnQryVO.getCnameBuyer_Q())) {
			params.put("cnameBuyer", warnQryVO.getCnameBuyer_Q());
		}
		if (StringUtils.isNotBlank(warnQryVO.getProtocolNo())) {
			params.put("protocolNo", warnQryVO.getProtocolNo());
		}
		if (StringUtils.isNotBlank(warnQryVO.getStartDate_Q())) {
			params.put("startDate", warnQryVO.getStartDate_Q());
		}
		if (StringUtils.isNotBlank(warnQryVO.getEndDate_Q())) {
			params.put("endDate", warnQryVO.getEndDate_Q());
		}
		if (StringUtils.isNotBlank(warnQryVO.getBussType_Q())) {
			params.put("loanWay", warnQryVO.getBussType_Q());
		}
		Page page = new Page(pageSize, pageNo, 0);
		List<com.huateng.scf.adv.wrn.dao.model.ThreeNoConfirmPayWarnVO> list = bConfirmPayWarnDAO.queryNoConfirmPayWarnListByPage(params, page);
		List<ThreeNoConfirmPayWarnVO> resps = new ArrayList<ThreeNoConfirmPayWarnVO>();
		ThreeNoConfirmPayWarnVO newWarnVO = new ThreeNoConfirmPayWarnVO();
		for (com.huateng.scf.adv.wrn.dao.model.ThreeNoConfirmPayWarnVO warnVO : list) {
			BeanUtils.copyProperties(warnVO, newWarnVO);
			resps.add(newWarnVO);
		}
		page.setRecords(resps);
		Integer totalRecord = bConfirmPayWarnDAO.queryNoConfirmPayWarnListCount(params);
		page.setTotalRecord(totalRecord);
		return page;
	}

}
