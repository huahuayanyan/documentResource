package com.huateng.scf.adv.wrn.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.huateng.authority.common.ContextHolder;
import com.huateng.base.common.beans.Page;
import com.huateng.scf.adv.wrn.dao.IBMatureNoDeliveryWarnDAO;
import com.huateng.scf.adv.wrn.service.IBMatureNoDeliveryWarnService;
import com.huateng.scf.bas.common.model.FourDeliveryQryVO;
import com.huateng.scf.bas.prd.service.IBPrdInfoService;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * @author htrad0055 到期未发货预警
 *
 */
@ScubeService
@Service(IBMatureNoDeliveryWarnService.BeanId)
public class BMatureNoDeliveryWarnServiceImpl implements IBMatureNoDeliveryWarnService {
	
	@Resource(name=IBMatureNoDeliveryWarnDAO.BeanId)
	private IBMatureNoDeliveryWarnDAO bMatureNoDeliveryWarnDAO;
	
	@Resource(name="bPrdInfoService")
	private IBPrdInfoService bPrdInfoService;

	/**
	 * 分页查询到期未发货预警
	 * @param pageNo
	 * @param pageSize
	 * @param warnQryVO
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Page queryNoDeliveryWarningByPage(int pageNo, int pageSize, FourDeliveryQryVO deliveryQryVO) {
		Page page = new Page(pageSize, pageNo, 0);
		Map<String, Object> params = new HashMap<String, Object>();
		
		String brattr =ContextHolder.getOrgInfo().getBrAttr();
		params.put("brattr", brattr);
		String brcode = ContextHolder.getUserInfo().getBrNo();
		params.put("brcode", brcode);
		
		String productId = bPrdInfoService.getProductIdByFlag(deliveryQryVO.getProductId_Q());
		
		if(StringUtils.isNotBlank(deliveryQryVO.getProductId_Q())){
			params.put("productId", productId);
		}
		if(StringUtils.isNotBlank(deliveryQryVO.getCnameSeller_Q())){
			params.put("cnameSeller", deliveryQryVO.getCnameSeller_Q());
		}
		if(StringUtils.isNotBlank(deliveryQryVO.getProtocolNo())){
			params.put("protocolNo", deliveryQryVO.getProtocolNo());
		}
		if(StringUtils.isNotBlank(deliveryQryVO.getStartDate_Q())){
			params.put("startDate", deliveryQryVO.getStartDate_Q());
		}
		if(StringUtils.isNotBlank(deliveryQryVO.getEndDate_Q())){
			params.put("endDate", deliveryQryVO.getEndDate_Q());
		}
			
		List<com.huateng.scf.adv.wrn.dao.model.BWrnMortRedeemInfo> records =bMatureNoDeliveryWarnDAO.selectNoDeliveryWarningListByPage(params, page);
		Integer totalRecord = bMatureNoDeliveryWarnDAO.selectNoDeliveryWarningCount(params);
		page.setTotalRecord(totalRecord);
		page.setRecords(records);
		return page;
	}

}
